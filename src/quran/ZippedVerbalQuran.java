/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import quran.VerbalQuran;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javazoom.jl.player.Player;

/**
 *
 * @author Administrator
 */
public class ZippedVerbalQuran extends VerbalQuran
{
    private final ZipFile m_zip;
    
    public ZippedVerbalQuran() throws IOException
    {
        m_zip = new ZipFile(QuranSpeakerZipFile);
    }

    @Override
    protected Player loadAya (int sura, int aya)
    {
        try
        {
            String pathToMp3 = String.format ("%03d%03d%s", sura, aya, ".mp3");
            InputStream i = m_zip.getInputStream (new ZipEntry(pathToMp3));
            return getPlayer (i); 
        }
        catch (Exception ex)
        {
            
        }
        return null;
    }
    
}
