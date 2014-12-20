package midisystem;


import javax.sound.midi.Instrument;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TrackMaker
{
    private final Track track;
    private final MidiSynthSystem synthsys;
    private int timeoffset;
    private final EventMaker emaker;
    
    /**
     * Constructor
     * @param ms
     * @param chan
     */
    public TrackMaker (MidiSynthSystem ms, int chan)
    {
        synthsys = ms;
        track = ms.getSequence().createTrack();
        timeoffset = 5;
        emaker = new EventMaker (chan); 
    }
    
    /**
     * Adds a note (on/off events)
     * @param note Frequency
     * @param length Ticks between on/off events
     * @return Current position in Track
     */
    public int addNote (int note, int length)
    {
        track.add(emaker.on(note, timeoffset));
        timeoffset += length;
        track.add(emaker.off(note, timeoffset));
        return timeoffset;
    }

    /**
     * Adds a Pause
     * @param length Length (ticks) of Pause
     * @return Current position in Track
     */
    public int addPause (int length)
    {
        track.add(emaker.insertPause(length));
        timeoffset += length;
        return timeoffset;
    }

    /**
     * Adds final stop event
     */
    public void addStop()
    {
        track.add(emaker.insertStop(timeoffset));
    }
    
    /**
     * Adds "change instrument" event
     * @param instr Instrument to be used
     * @return Current position in Track
     */
    public int setInstrument (Instrument instr)
    {
        track.add(emaker.changeInstrument(instr, timeoffset));
        timeoffset += 1;
        return timeoffset;
    }
    
    /**
     * Get the working track
     * @return The Track
     */
    public Track getTrack()
    {
        return track;
    }
    
    public Track fromString (String str) throws Exception
    {
        String[] split = str.split(" ");
        for (String s : split)
        {
            String[] cmd = s.split(":");
            if (cmd.length != 2)
                throw new Exception ("Unknown token");
            int len = Integer.parseInt(cmd[1]);
            switch (cmd[0])
            {
                case "P":
                    addPause (len);
                    break;
                case "I":
                    setInstrument (synthsys.getInstrument(len));
                    break;
                default:
                    int freq = Integer.parseInt(cmd[0]);
                    addNote (freq, len);
                    break;
            }
        }
        //addStop();
        return track;
    }
}
