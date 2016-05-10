/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.InputStream;
import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import misc.Tools;

/**
 *
 * @author Administrator
 */
public class VerbalQuran implements Runnable
{
    private ThreadParam param;

    public VerbalQuran()
    {
    }

    private class ThreadParam
    {
        public int sura;
        public int aya;

        public ThreadParam(int s, int a)
        {
            sura = s;
            aya = a;
        }
    }

    public Player getPlayer(InputStream i) throws JavaLayerException
    {
        Player p = new Player(i);
        p.play(1);
        return p;
    }

    /**
     *
     * @param sura
     * @param aya
     * @return
     * @throws Exception
     */
    public InputStream load(int sura, int aya) throws Exception
    {
        String pathToMp3 = String.format("%03d%03d%s", sura, aya, ".mp3");
        return ClassLoader.getSystemResourceAsStream(pathToMp3);
    }

    public Player loadAya(int sura, int aya)
    {
        try
        {
            InputStream f = load(sura, aya);
            return getPlayer(f);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    public void playAsync(int sura, int aya)
    {
        param = new ThreadParam(sura, aya);
        Tools.execute(this);
    }

    public void play(int sura, int aya) throws JavaLayerException
    {
        Player p = loadAya(sura, aya);
        p.play();
    }

    public void play(int sura) throws JavaLayerException
    {
        int aya = 1;
        ArrayList<Player> list = new ArrayList<>();
        for (;;)
        {
            Player p = loadAya(sura, aya);
            if (p == null)
            {
                break;
            }
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
            play(param.sura, param.aya);
        }
        catch (JavaLayerException ex)
        {
            System.out.println(ex);
        }
    }
}
