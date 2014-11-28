/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Administrator
 */
public class ZippedQuran extends Quran
{
    private ZipFile m_zip;

    public ZippedQuran(int idx) throws IOException
    {
        super(idx);
        m_zip = new ZipFile(QuranZipFile);
    }

    private String[] getZipEntries()
    {
        final Enumeration<? extends ZipEntry> entries = m_zip.entries();
        final ArrayList<String> names = new ArrayList<>();

        while (entries.hasMoreElements())
        {
            final ZipEntry entry = entries.nextElement();
            names.add(entry.getName());
        }
        return names.toArray(new String[names.size()]);
    }

    @Override
    protected String[] getFileNames()
    {
        return getZipEntries();
    }

    @Override
    protected void readFile(String entryname) throws IOException
    {
        if (m_zip == null)
            m_zip = new ZipFile(QuranZipFile);
        InputStream inputstream = m_zip.getInputStream(new ZipEntry(entryname));
        Scanner scanner = new Scanner(inputstream, ENCODING.name());
        scan(scanner);
    }

}
