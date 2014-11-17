/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Quran implements Settings
{
    protected final HashMap<String, String> m_map = new HashMap<>();
    //protected final String m_path = "c:\\quran\\";
    protected final Charset ENCODING = StandardCharsets.UTF_8;
    
    static final String[] m_files =
    {
        "en.wahiduddin.txt",
        "en.ahmedali.txt",
        "en.ahmedraza.txt",
        "en.arberry.txt",
        "en.daryabadi.txt",
        "en.hilali.txt",
        "en.itani.txt",
        "en.maududi.txt",
        "en.pickthall.txt",
        "en.qarai.txt",
        "en.qaribullah.txt",
        "en.sahih.txt",
        "en.sarwar.txt",
        "en.shakir.txt",
        "en.transliteration.txt",
        "en.wahiduddin.txt",
        "en.yusufali.txt",
        "de.aburida.txt",
        "de.bubenheim.txt",
        "de.khoury.txt",
        "de.zaidan.txt",
        "ar.jalalayn.txt",
        "ar.muyassar.txt",
    };

    public Quran(String filename) throws IOException
    {
        readFile (filename);
    }

    public Quran(int idx) throws IOException
    {
        this (m_files[idx]);
    }

    protected String[] getFileNames()
    {
        return m_files;
    }
    
    protected void scan (Scanner scanner)
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
    
    protected void readFile (String filename) throws IOException
    {
        Scanner scanner = new Scanner (new File(QuranSinglePath + filename), ENCODING.name());
        scan (scanner);
    }

    public String getAya(String key) throws Exception
    {
        String v = m_map.get(key); 
        if (v == null)
            throw new Exception("not found");
        return v;
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
