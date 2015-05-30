/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import misc.PathNames;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class HadithCollection
{
    private final ArrayList<String> list = new ArrayList<>();
    private final Random rnd = new Random();
    private String last = null;
    
    public HadithCollection() throws IOException
    {
        makeDatabase();
    }
    
    public int getSize()
    {
        return list.size();
    }
    
    public String getHadith (int n)
    {
        last = list.get(n);
        return last;
    }
    
    public String getRandomHadith()
    {
        last = list.get(rnd.nextInt(list.size()));
        return last;
    }
    
    public String getLast()
    {
        return last;
    }
    
    private void makeDatabase() throws IOException
    {
        InputStream in = ClassLoader.getSystemResourceAsStream("hadith.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));)
        {
            String line;
            StringBuilder bui = new StringBuilder();
            while ((line = br.readLine()) != null)
            {
                if (line.equals("[SEP]"))
                {
                    list.add (bui.toString());
                    bui.setLength(0);
                    continue;
                }
                bui.append(line).append('\n');
            }
            if (bui.length() != 0)
                list.add (bui.toString());
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        HadithCollection h = new HadithCollection();
        String s = h.getRandomHadith();
        System.out.println(s);
    }
}
