/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Administrator
 */
public class ZippedQuran extends Quran
{
    public ZippedQuran(int idx) throws IOException
    {
        super(idx);
    }
    
    @Override
    protected void readFile (String entryname) throws IOException
    {
        ZipFile zipfile = new ZipFile(m_path+"quran.zip");
        InputStream inputstream = zipfile.getInputStream (new ZipEntry(entryname));
        Scanner scanner = new Scanner(inputstream, ENCODING.name());
        scan (scanner);
    }
    
}
