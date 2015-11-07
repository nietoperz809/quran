
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import transform.Transformation;

// $Revision:$

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
    public static void main(String[] args) throws Exception
    {
        System.out.println(Transformation.utf8);
        //String[] test = listPackage ("quran/quranfiles/");
        //System.out.println(Arrays.toString(test));
    }
    
    public static String[] listPackage(String path) throws Exception
    {
        int pathLen = path.length();
        URL url1 = ClassLoader.getSystemResource(path);

        String jarFileName;
        JarFile jf;
        Enumeration<JarEntry> jarEntries;
        String entryName;
        ArrayList<String> list = new ArrayList<>();
        
        // build jar file name, then loop through zipped entries
        jarFileName = URLDecoder.decode(url1.getFile(), Transformation.utf8);
        jarFileName = jarFileName.substring(5, jarFileName.indexOf("!"));
        jf = new JarFile(jarFileName);
        jarEntries = jf.entries();
        while (jarEntries.hasMoreElements())
        {
            entryName = jarEntries.nextElement().getName();
            if (entryName.startsWith(path))
            {
                entryName = entryName.substring(pathLen);
                if (!entryName.isEmpty())
                    list.add(entryName);
            }
        }
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }
}
