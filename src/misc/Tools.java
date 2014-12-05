/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class Tools
{
    public static double readDouble(JTextField jf, double defaultvalue)
    {
        double res;
        try
        {
            res = Double.parseDouble(jf.getText());
        }
        catch (Exception ex)
        {
            res = defaultvalue;
        }
        System.out.println(res);
        return res;
    }

    public static int readInt(JTextField jf, int defaultvalue)
    {
        int res;
        try
        {
            res = Integer.parseInt(jf.getText());
        }
        catch (Exception ex)
        {
            res = defaultvalue;
        }
        System.out.println(res);
        return res;
    }

    static void printStringArray(String[] sa)
    {
        for (String s : sa)
        {
            System.out.println(s);
            System.out.println("----------------");
        }
    }

    static void printStringList(List<String> sa)
    {
        for (String s : sa)
        {
            System.out.println(s);
            System.out.println("----------------");
        }
    }

    static final String m_path = "../ser/";

    public static void serialize(String filename, Object o) throws Exception
    {
        new File(m_path).mkdirs();
        FileOutputStream f_out = new FileOutputStream(m_path + filename);
        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
        obj_out.writeObject(o);
    }

    public static Object deSerialize(String filename) throws Exception
    {
        FileInputStream f_in = new FileInputStream(m_path + filename);
        ObjectInputStream obj_in = new ObjectInputStream(f_in);
        return obj_in.readObject();
    }

    public static List<String> listSaves()
    {
        List<String> result = new ArrayList<>();
        File[] files = new File(m_path).listFiles();
        for (File file : files)
        {
            if (file.isFile())
            {
                result.add(file.getName());
            }
        }
        return result;
    }
}
