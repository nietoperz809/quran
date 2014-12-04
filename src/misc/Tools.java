/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class Tools
{
    public static double readDouble (JTextField jf, double defaultvalue)
    {
        double res;
        try
        {
            res =  Double.parseDouble(jf.getText());
        }
        catch (Exception ex)
        {
            res = defaultvalue;
        }
        System.out.println (res);
        return res;
    }

    public static int readInt (JTextField jf, int defaultvalue)
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
        System.out.println (res);
        return res;
    }
    
    static void printStringArray (String[] sa)
    {
        for (String s: sa)
        {
            System.out.println (s);
            System.out.println ("----------------");
        }
    }

    static void printStringList (List<String> sa)
    {
        for (String s: sa)
        {
            System.out.println (s);
            System.out.println ("----------------");
        }
    }


}
