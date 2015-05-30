/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import misc.DebugOut;
import misc.PathNames;

/**
 *
 * @author Administrator
 */
public class VerbalQuran implements Runnable, PathNames
{
    private ThreadParam param;
    private final ZipFile m_zipFile;

    public VerbalQuran() throws IOException
    {
        final String resourcesPath = "quranvoice/000_versebyverse-1.zip";
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourcesPath);
        File f;
        try
        {
            f = new File(url.toURI());
        }
        catch (URISyntaxException e)
        {
            f = new File(url.getPath());
        }
        m_zipFile = new ZipFile(f);
    }

    class ThreadParam
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
        return m_zipFile.getInputStream(new ZipEntry(pathToMp3));
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
            DebugOut.get().out.println(ex);
        }
        return null;
    }

    public void playAsync(int sura, int aya)
    {
        param = new ThreadParam(sura, aya);
        new Thread(this).start();
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
            DebugOut.get().out.println(ex);
        }
    }
}
