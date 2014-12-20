package midisystem;

/*
 *	SimpleMidiPlayer.java
 *
 *	This file is part of jsresources.org
 */

/*
 |<---            this code is formatted to fit into 80 columns             --->|
 */
import javax.sound.midi.MetaMessage;

public class SimpleMidiPlayer
{
    static void handleEnd (MidiSynthSystem mss)
    {
        mss.getSequencer().addMetaEventListener((MetaMessage event) ->
        {
            if (event.getType() == 47)
            {
                System.out.println ("end of midi");
                //mss.getSequencer().close();
                //if (mss.getSynthesizer() != null)
                //    mss.getSynthesizer().close();
            }
        });
    }

    public static void main(String[] args) throws Exception
    {
        MidiSynthSystem ssys = MidiSynthSystem.get();
        
        //makeDemoTrack(sequence);
        TrackMaker tm = new TrackMaker (ssys, 2);
        tm.fromString("I:70 50:50 80:50");
        TrackMaker tm2 = new TrackMaker (ssys, 1);
        tm2.fromString("I:88 50:10 80:10 50:10 80:10 50:10 P:100 50:10 80:10 50:10 80:10 50:10 P:10");


        handleEnd(ssys);


        /*
         *	Now, we can start over.
         */
        ssys.setLoops (4);
        ssys.start();
    }
}


