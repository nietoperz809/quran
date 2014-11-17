/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Administrator
 */
public class VerbalQuran implements Runnable, Settings
{
    //private final String m_path; // = "c:\\quran\\000_versebyverse-1\\";

    class ThreadParam
    {
        public int sura;
        public int aya;
        
        public ThreadParam (int s, int a)
        {
            sura = s;
            aya = a;
        }
    }
    ThreadParam param;
    

    protected Player getPlayer (InputStream i) throws JavaLayerException
    {
        Player p = new Player(i);
        p.play(1);
        return p;
    }
    
    protected Player loadAya (int sura, int aya)
    {
        try
        {
            String pathToMp3 = String.format ("%s%03d%03d%s", QuranSpeakerPath, sura, aya, ".mp3");
            FileInputStream f = new FileInputStream(pathToMp3);
            return getPlayer (f);
        }
        catch (FileNotFoundException | JavaLayerException ex)
        {
        }
        return null;
    }
    
    public void playAsync (int sura, int aya)
    {
        param = new ThreadParam (sura, aya);
        new Thread(this).start();
    }
    
    public void play (int sura, int aya) throws JavaLayerException 
    {
        Player p = loadAya (sura, aya);
        p.play();
    }
    
    public void play (int sura) throws JavaLayerException
    {
        int aya = 1;
        ArrayList<Player> list = new ArrayList<>();
        for(;;)
        {
            Player p = loadAya (sura, aya);
            if (p == null)
                break;
            aya++;
            list.add(p);
        }
        for (Player pl : list)
        {
            pl.play();
        }
    }

    @Override
    public void run()
    {
        try
        {
            play (param.sura, param.aya);
        }
        catch (JavaLayerException ex)
        {
            System.out.println (ex);
        }
    }
}
