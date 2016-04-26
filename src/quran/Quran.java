/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

import misc.Tools;

/**
 *
 * @author Administrator
 */
public class Quran
{
    private final HashMap<String, String> m_map = new HashMap<>();
    private final Charset ENCODING = StandardCharsets.UTF_8;
    
    static final String[] m_files = Tools.listPackage("quran/quranfiles/");

    public Quran(int idx)
    {
        readFile (m_files[idx]);
    }

    public Quran(String name)
    {
        readFile (name);
    }

    /**
     *
     * @return
     */
    public String[] getFileNames()
    {
        return m_files;
    }
    
    /**
     * Constructs map from quran file
     * @param scanner
     */
    private void scan (Scanner scanner)
    {
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if (line.isEmpty())
            {
                break;
            }
            int idx = line.lastIndexOf('|');
            if (idx == -1)
                System.out.println (0);
            String txt = line.substring(idx + 1);
            String head = line.substring(0, idx);
            m_map.put(head, txt);
        }
    }
    
    /**
     * Reads whole Quran
     * @param filename name of the quran file
     */
    private void readFile (String filename)
    {
        InputStream in = ClassLoader.getSystemResourceAsStream("quran/quranfiles/"+filename);        

        Scanner scanner = new Scanner (in, ENCODING.name());
        scan (scanner);
    }
    
    public String getAya(String key) throws Exception
    {
        String v = m_map.get(key); 
        if (v == null)
            throw new Exception("not found");
        return v;
    }
    
    public String getAya (int sura, int first, int last) throws Exception
    {
        String out = getAya (sura, first);
        while (first < last)
        {
            first++;
            out += " " + getAya (sura, first);

        }
        return out;
    }
    
    public String getAya(int sura, int ayat) throws Exception
    {
        return getAya ("" + sura + "|" + ayat);
    }

    public String getSura(int num)
    {
        StringBuilder sb = new StringBuilder();
        int ayat = 1;
        for (;;)
        {
            String s;
            try
            {
                s = getAya(num, ayat);
            }
            catch (Exception ex)
            {
                break;
            }
            sb.append("(").append(num).append(":").append(ayat).append(") ");
            sb.append(s);
            sb.append(' ');
            ayat++;
        }
        String r = sb.toString();
        if (r.isEmpty())
        {
            return null;
        }
        return r;
    }
    
    public HashMap<String, String> getMap()
    {
        return m_map;
    }
}
