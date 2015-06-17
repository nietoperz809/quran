
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class ListJar
{
    public static void main(String[] args) throws IOException
    {
        //ListJar lj = new ListJar();

        CodeSource src = ListJar.class.getProtectionDomain().getCodeSource();
        System.out.println(src.getLocation());
//        if (src != null)
//        {
//            URL jar = src.getLocation();
//            ZipInputStream zip = new ZipInputStream(jar.openStream());
//            while (true)
//            {
//                ZipEntry e = zip.getNextEntry();
//                if (e == null)
//                {
//                    break;
//                }
//                String name = e.getName();
//
//                if (name.startsWith("path/to/your/dir/"))
//                {
//                }
//            }
//        }
//        else
//        {
//
//        }
    }
}
