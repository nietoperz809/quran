/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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

    /**
     *
     * @param sura
     * @param aya
     * @return
     * @throws Exception
     */
    @Override
    public InputStream load(int sura, int aya) throws Exception
    {
        String pathToMp3 = String.format("%03d%03d%s", sura, aya, ".mp3");
        return m_zip.getInputStream(new ZipEntry(pathToMp3));
    }
}
