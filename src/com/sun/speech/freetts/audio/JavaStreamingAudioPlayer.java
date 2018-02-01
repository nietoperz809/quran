/**
 * Copyright 2001 Sun Microsystems, Inc.
 * 
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL 
 * WARRANTIES.
 */
package com.sun.speech.freetts.audio;

import java.util.concurrent.Semaphore;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import com.sun.speech.freetts.util.BulkTimer;
import com.sun.speech.freetts.util.Timer;
import com.sun.speech.freetts.util.Utilities;

/** Streams audio to java audio. This class provides a low latency method of sending audio output through the javax.sound
 * audio API. Audio data is sent in small sets to the audio system allowing it to be played soon after it is generated.
 * Unfortunately, the current release of the JDK (JDK 1.4 beta 2) has a bug or two in the implementation of
 * 'SourceDataLine.drain'. A workaround solution that sleep/waits on SourceDataLine.isActive is used here instead. To
 * disable the work around (i.e use the real 'drain') set the property:
 * <p>
 * <code>
 *   com.sun.speech.freetts.audio.AudioPlayer.drainWorksProperly;
 * </code> to <code>true</code>. If the workaround is enabled, the line.isActive method will be performed periodically.
 * The period of the test can be controlled with:
 * <p>
 * <code>
 *   com.sun.speech.freetts.audio.AudioPlayer.drainDelay"
 * </code>
 * <p>
 * The default if 5ms.
 * <p>
 * The property <code>
 *   com.sun.speech.freetts.audio.AudioPlayer.bufferSize"
 * </code>
 * <p>
 * Controls the audio buffer size, it defaults to 8192
 * <p>
 * Even with this drain work around, there are some issues with this class. The workaround drain is not completely
 * reliable. A <code>resume</code> following a <code>pause</code> does not always continue at the proper position in the
 * audio. On a rare occasion, sound output will be repeated a number of times. This may be related to bug 4421330 in the
 * Bug Parade database. */
public class JavaStreamingAudioPlayer implements AudioPlayer {

	private volatile boolean paused;
	private volatile boolean done = false;
	private volatile boolean cancelled = false;

	private SourceDataLine line;
	private float volume = 1.0f; // the current volume
	private long timeOffset = 0L;
	private BulkTimer timer = new BulkTimer();

	// default format is 8khz
	private AudioFormat defaultFormat = new AudioFormat(8000f, 16, 1, true, true);
	private AudioFormat currentFormat = defaultFormat;

	private boolean debug = false;
	private boolean audioMetrics = false;
	private boolean firstSample = true;

	private long cancelDelay;
	private long drainDelay;
	private long openFailDelayMs;
	private long totalOpenFailDelayMs;

	private Semaphore openSemaphore; // Supports waiting for line to be ready for use. ref
																		// http://stackoverflow.com/a/11514789/10245
	private Object lineLock = new Object();

	/** controls the buffering to java audio */
	private final static int AUDIO_BUFFER_SIZE = Utilities.getInteger(
			"com.sun.speech.freetts.audio.AudioPlayer.bufferSize", 8192).intValue();

	/** controls the number of bytes of audio to write to the buffer for each call to write() */
	private final static int BYTES_PER_WRITE = Utilities.getInteger(
			"com.sun.speech.freetts.audio.AudioPlayer.bytesPerWrite", 160).intValue();

	/** Constructs a default JavaStreamingAudioPlayer */
	public JavaStreamingAudioPlayer() {
		debug = Utilities.getBoolean("com.sun.speech.freetts.audio.AudioPlayer.debug");
		cancelDelay = Utilities.getLong("com.sun.speech.freetts.audio.AudioPlayer.cancelDelay", 0L).longValue();
		drainDelay = Utilities.getLong("com.sun.speech.freetts.audio.AudioPlayer.drainDelay", 150L).longValue();
		openFailDelayMs = Utilities.getLong("com.sun.speech.freetts.audio.AudioPlayer.openFailDelayMs", 0L).longValue();
		totalOpenFailDelayMs = Utilities.getLong("com.sun.speech.freetts.audio.AudioPlayer.totalOpenFailDelayMs", 0L)
				.longValue();
		audioMetrics = Utilities.getBoolean("com.sun.speech.freetts.audio.AudioPlayer.showAudioMetrics");

		line = null;
		setPaused(false);
		openSemaphore = new Semaphore(1);
	}

	/** Sets the audio format for this player
	 * @param format the audio format
	 * @throws UnsupportedOperationException if the line cannot be opened with the given format */
	public synchronized void setAudioFormat(AudioFormat format) {
		currentFormat = format;
		debugPrint("AF changed to " + format);
	}

	/** Gets the audio format for this player
	 * @return format the audio format */
	public AudioFormat getAudioFormat() {
		return currentFormat;
	}

	/** Starts the first sample timer */
	public void startFirstSampleTimer() {
		timer.start("firstAudio");
		firstSample = true;
	}

	/** Opens the audio
	 * @param format the format for the audio
	 * @throws UnsupportedOperationException if the line cannot be opened with the given format */
	private synchronized void openLine(AudioFormat format) {
		synchronized (lineLock) {
			if (line != null) {
				line.close();
				line = null;
			}
		}
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		boolean opened = false;
		long totalDelayMs = 0;

		do {
			try {
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.addLineListener(new JavaStreamLineListener());

				line.open(format, AUDIO_BUFFER_SIZE);
				openSemaphore.acquire(); // line now open, use the only available permit
				openSemaphore.acquire(); // wait for the listener to release the permit, thus indicating the line is ready for
																	// use
				opened = true;
				openSemaphore.release(); // release the original permit again ready for the next line to be opened
			} catch (LineUnavailableException lue) {
				System.err.println("LINE UNAVAILABLE: " + "Format is " + currentFormat);
				try {
					Thread.sleep(openFailDelayMs);
					totalDelayMs += openFailDelayMs;
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			} catch (InterruptedException ie) { // ugh, checked exceptions.
				ie.printStackTrace();
			}
		} while (!opened && totalDelayMs < totalOpenFailDelayMs);

		if (opened) {
			setVolume(line, volume);
			resetTime();
			if (isPaused() && line.isRunning()) {
				line.stop();
			} else {
				line.start();
			}
		} else {
			if (line != null) {
				line.close();
			}
			line = null;
		}
	}

	/** Pauses audio output */
	public synchronized void pause() {
		if (!isPaused()) {
			setPaused(true);
			if (line != null) {
				line.stop();
			}
		}
	}

	/** Resumes audio output */
	public synchronized void resume() {
		if (isPaused()) {
			setPaused(false);
			if (!isCancelled() && line != null) {
				line.start();
				notify();
			}
		}
	}

	/** Cancels currently playing audio. */

	// [[[ WORKAROUND TODO
	// The "Thread.sleep(cancelDelay)" is added to fix a problem in the
	// FreeTTSEmacspeak demo. The problem was that the engine would
	// stutter after using it for a while. Adding this sleep() fixed the
	// problem. If we later find out that this problem no longer exists,
	// we should remove the thread.sleep(). ]]]
	public void cancel() {
		debugPrint("cancelling...");

		if (audioMetrics) {
			timer.start("audioCancel");
		}

		if (cancelDelay > 0) {
			try {
				Thread.sleep(cancelDelay);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

		synchronized (lineLock) {
			if (line != null && line.isRunning()) {
				line.stop();
				line.flush();
			}
		}

		/* sets 'cancelled' to false, which breaks the write while loop */
		synchronized (this) {
			cancelled = true;
			notify();
		}

		if (audioMetrics) {
			timer.stop("audioCancel");
			Timer.showTimesShortTitle("");
			timer.getTimer("audioCancel").showTimesShort(0);
		}

		debugPrint("...cancelled");
	}

	/** Prepares for another batch of output. Larger groups of output (such as all output associated with a single
	 * FreeTTSSpeakable) should be grouped between a reset/drain pair. */
	public synchronized void reset() {
		timer.start("audioOut");
		if (line != null) {
			waitResume();
			if (isCancelled() && !isDone()) {
				cancelled = false;
				line.start();
			}
		}
	}

	/** Closes this audio player */
	public synchronized void close() {
		done = true;
		if (line != null && line.isOpen()) {
			line.close();
			line = null;
			notify();
		}
	}

	/** Returns the current volume.
	 * @return the current volume (between 0 and 1) */
	public float getVolume() {
		return volume;
	}

	/** Sets the current volume.
	 * @param volume the current volume (between 0 and 1) */
	public void setVolume(float volume) {
		if (volume > 1.0f) {
			volume = 1.0f;
		}
		if (volume < 0.0f) {
			volume = 0.0f;
		}
		this.volume = volume;
	}

	/** Sets us in pause mode
	 * @param state true if we are paused */
	private void setPaused(boolean state) {
		paused = state;
	}

	/** Returns true if we are in pause mode
	 * @return true if paused */
	private boolean isPaused() {
		return paused;
	}

	/** Sets the volume on the given clip
	 * @param line the line to set the volume on
	 * @param vol the volume (range 0 to 1) */
	private void setVolume(SourceDataLine line, float vol) {
		if (line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
			FloatControl volumeControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
			float range = volumeControl.getMaximum() - volumeControl.getMinimum();
			volumeControl.setValue(vol * range + volumeControl.getMinimum());
		}
	}

	/** Starts the output of a set of data. For this JavaStreamingAudioPlayer, it actually opens the audio line. Since this
	 * is a streaming audio player, the <code>size</code> parameter has no meaning and effect at all, so any value can be
	 * used. Audio data for a single utterance should be grouped between begin/end pairs.
	 * @param size supposedly the size of data between now and the end, but since this is a streaming audio player, this
	 * parameter has no meaning and effect at all */
	public void begin(int size) {
		debugPrint("opening Stream...");
		openLine(currentFormat);
		reset();
		debugPrint("...Stream opened");
	}

	/** Marks the end of a set of data. Audio data for a single utterance should be groupd between begin/end pairs.
	 * @return true if the audio was output properly, false if the output was cancelled or interrupted. */
	public synchronized boolean end() {
		if (line != null) {
			drain();
			synchronized (lineLock) {
				line.close();
				line = null;
			}
			notify();
			debugPrint("ended stream...");
		}
		return true;
	}

	/** Waits for all queued audio to be played
	 * @return true if the audio played to completion, false if the audio was stopped [[[ WORKAROUND TODO The
	 * javax.sound.sampled drain is almost working properly. On linux, there is still a little bit of sound that needs to
	 * go out, even after drain is called. Thus, the drainDelay. We wait for a few hundred milliseconds while the data is
	 * really drained out of the system ]]] */
	public boolean drain() {
		if (line != null) {
			debugPrint("started draining...");
			if (line.isOpen()) {
				line.drain();
				if (drainDelay > 0L) {
					try {
						Thread.sleep(drainDelay);
					} catch (InterruptedException ie) {
					}
				}
			}
			debugPrint("...finished draining");
		}
		timer.stop("audioOut");

		return !isCancelled();
	}

	/** Gets the amount of played since the last mark
	 * @return the amount of audio in milliseconds */
	public synchronized long getTime() {
		return (line.getMicrosecondPosition() - timeOffset) / 1000L;
	}

	/** Resets the audio clock */
	public synchronized void resetTime() {
		timeOffset = line.getMicrosecondPosition();
	}

	/** Writes the given bytes to the audio stream
	 * @param audioData audio data to write to the device
	 * @return <code>true</code> of the write completed successfully, <code> false </code>if the write was cancelled. */
	public boolean write(byte[] audioData) {
		return write(audioData, 0, audioData.length);
	}

	/** Writes the given bytes to the audio stream
	 * @param bytes audio data to write to the device
	 * @param offset the offset into the buffer
	 * @param size the size into the buffer
	 * @return <code>true</code> of the write completed successfully, <code> false </code>if the write was cancelled. */
	public boolean write(byte[] bytes, int offset, int size) {
		if (line == null) {
			return false;
		}

		int bytesRemaining = size;
		int curIndex = offset;

		if (firstSample) {
			firstSample = false;
			timer.stop("firstAudio");
			if (audioMetrics) {
				Timer.showTimesShortTitle("");
				timer.getTimer("firstAudio").showTimesShort(0);
			}
		}
		debugPrint(" au write " + bytesRemaining + " pos " + line.getMicrosecondPosition() + " avail " + line.available()
				+ " bsz " + line.getBufferSize());

		while (bytesRemaining > 0 && !isCancelled()) {

			if (!waitResume()) {
				return false;
			}

			debugPrint("   queueing cur " + curIndex + " br " + bytesRemaining);
			int bytesWritten;

			synchronized (lineLock) {
				bytesWritten = line.write(bytes, curIndex, Math.min(BYTES_PER_WRITE, bytesRemaining));

				if (bytesWritten != bytesRemaining) {
					debugPrint("RETRY! bw" + bytesWritten + " br " + bytesRemaining);
				}
				// System.out.println("BytesWritten: " + bytesWritten);
				curIndex += bytesWritten;
				bytesRemaining -= bytesWritten;
			}

			debugPrint("   wrote " + " cur " + curIndex + " br " + bytesRemaining + " bw " + bytesWritten);

		}
		return !isCancelled() && !isDone();
	}

	/** Waits for resume. If this audio player is paused waits for the player to be resumed. Returns if resumed, cancelled
	 * or shutdown.
	 * @return true if the output has been resumed, false if the output has been cancelled or shutdown. */
	private synchronized boolean waitResume() {
		while (isPaused() && !isCancelled() && !isDone()) {
			try {
				debugPrint("   paused waiting ");
				wait();
			} catch (InterruptedException ie) {
			}
		}

		return !isCancelled() && !isDone();
	}

	/** Returns the name of this audioplayer
	 * @return the name of the audio player */
	public String toString() {
		return "JavaStreamingAudioPlayer";
	}

	/** Outputs a debug message if debugging is turned on
	 * @param msg the message to output */
	private void debugPrint(String msg) {
		if (debug) {
			System.out.println(toString() + ": " + msg);
		}
	}

	/** Shows metrics for this audio player */
	public void showMetrics() {
		timer.show("JavaStreamingAudioPlayer");
	}

	/** Determines if the output has been canceled. Access to the canceled variable should be within a synchronized block
	 * such as this to ensure that access is coherent.
	 * @return true if output has been canceled */
	private synchronized boolean isCancelled() {
		return cancelled;
	}

	/** Determines if the output is done. Access to the done variable should be within a synchronized block such as this to
	 * ensure that access is coherent.
	 * @return true if output has completed */
	private synchronized boolean isDone() {
		return done;
	}

	/** Provides a LineListener for this clas. */
	private class JavaStreamLineListener implements LineListener {

		/** Implements update() method of LineListener interface. Responds to the line events as appropriate.
		 * @param event the LineEvent to handle */
		public void update(LineEvent event) {
			if (event.getType().equals(LineEvent.Type.OPEN)) {
				openSemaphore.release(); // allow the main thread to continue now that the line is ready for use
			}
		}
	}
}