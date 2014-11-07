/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class DebugTools
{
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
