/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class PackageQuran extends Quran
{
    public PackageQuran(int idx) throws IOException
    {
        super(idx);
    }

//    public PackageQuran(String item) throws IOException
//    {
//        readFile (item);
//    }
    
    @Override
    protected void readFile (String filename) throws IOException
    {
        InputStream in = ClassLoader.getSystemResourceAsStream(filename);        

        Scanner scanner = new Scanner (in, ENCODING.name());
        scan (scanner);
    }
    
}
