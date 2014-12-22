package midisystem;

import java.util.concurrent.Semaphore;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public final class MidiSynthSystem
{
    private final Sequencer sm_sequencer;
    private final Synthesizer sm_synthesizer;
    private Sequence sm_sequence;
    private final Instrument[] orchestra;
    private static MidiSynthSystem this_mss;
    private final Object waitObject;

    /**
     * Constructor
     *
     * @throws Exception If smth goes wrong
     */
    private MidiSynthSystem() throws Exception
    {
        sm_sequencer = MidiSystem.getSequencer();
        sm_sequencer.close();
        sm_synthesizer = MidiSystem.getSynthesizer();
        sm_synthesizer.close();
        sm_sequence = new Sequence(Sequence.SMPTE_30, 1);

        sm_synthesizer.open();
        sm_sequencer.open();
        sm_sequencer.stop();
        orchestra = sm_synthesizer.getAvailableInstruments();
        waitObject = new Object();
    }

    public static MidiSynthSystem get()
    {
        if (this_mss == null)
        {
            try
            {
                this_mss = new MidiSynthSystem();
                System.out.println("Midi system OPEN");
            }
            catch (Exception ex)
            {
                return null;
            }
        }
        return this_mss;
    }

    /**
     * Shuts down the sound system
     */
    public void shutdown()
    {
        if (this_mss == null)
        {
            return;
        }
        sm_sequencer.stop();
        sm_sequencer.close();
        sm_synthesizer.close();
        System.out.println("Midi system END");
        this_mss = null;
    }

    /**
     * Get Sequencer
     *
     * @return
     */
    public Sequencer getSequencer()
    {
        return sm_sequencer;
    }

    /**
     * Get Synthesizer
     *
     * @return
     */
    public Synthesizer getSynthesizer()
    {
        return sm_synthesizer;
    }

    /**
     * Get Sequence
     *
     * @return
     */
    public Sequence getSequence()
    {
        return sm_sequence;
    }

    /**
     * Get one Instrument from instrument bank
     *
     * @param idx Instr index
     * @return
     */
    public Instrument getInstrument(int idx)
    {
        if (idx < 0 || idx >= orchestra.length)
        {
            return null;
        }
        return orchestra[idx];
    }

    public void setLoops(int i)
    {
        sm_sequencer.setLoopCount(i);
    }

    public boolean start()
    {
        try
        {
            sm_sequencer.setSequence(sm_sequence);
        }
        catch (InvalidMidiDataException ex)
        {
            return false;
        }

        sm_sequencer.addMetaEventListener((MetaMessage event) ->
        {
            if (event.getType() == 47)
            {
                //System.out.println ("end of midi");
                try
                {
                    deleteAllTracks();
                    synchronized (waitObject)
                    {
                        waitObject.notify();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("deleteAllTracks failed");
                }
            }
        });
        sm_sequencer.start();
        return true;
    }

    public void waitUntilEnd() throws InterruptedException
    {
        synchronized (waitObject)
        {
            waitObject.wait();
        }
    }

    /**
     * Deletes all tracks
     */
    public void deleteAllTracks() throws Exception
    {
        sm_sequence = new Sequence(Sequence.SMPTE_30, 1);
    }
}
