/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraygen;

import java.io.File;
import java.io.FileInputStream;
import misc.DebugOut;

/**
 *
 * @author Administrator
 */
public class Arraygen
{
    public enum CODE {JAVA, JAVAFUNC, C, PHP};
    static CODE code = CODE.JAVAFUNC; 
    
    public static void setCode (CODE c)
    {
        code = c;
    }

    public static byte[] loadFile (String filename) throws Exception
    {
        File f = new File (filename);
        byte[] arr = new byte[(int)f.length()];
        FileInputStream fi = new FileInputStream (f);
        fi.read(arr);
        fi.close();
        return arr;
    }
    
    public static String makeIt (String varname, String filename) throws Exception
    {
        byte[] arr = loadFile (filename); 
        StringBuilder buff = new StringBuilder();
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int cnt = 0;
        if (varname == null || varname.isEmpty())
        {
            int idx = filename.lastIndexOf('\\');
            varname = filename.substring(idx+1).replace('.','_');
        }
        if (code == CODE.PHP)
        {
            buff.append ("$").append(varname).append(" = array\n(\n\t");
        }
        else if (code == CODE.JAVA)
            buff.append ("byte[] ").append(varname).append(" =\n{\n\t");
        else if (code == CODE.JAVAFUNC)
            buff.append ("static byte[] ").append(varname).append("()\n{\n\treturn new byte[]\n\t{\n\t\t");
        else if (code == CODE.C)
            buff.append ("unsigned char ").append(varname).append("[] =\n{\n\t");
        for (byte x : arr)
        {
            if (code == CODE.JAVA || code == CODE.JAVAFUNC)
                buff.append("(byte)0x");
            else if (code == CODE.C || code == CODE.PHP)
                buff.append("0x");
            buff.append (hex[(x>>>4)&0xf]).append(hex[x&0xf]).append(", ");
            if (cnt++ == 8)
            {
                cnt = 0;
                buff.append("\n\t");
                if (code == CODE.JAVAFUNC)
                    buff.append ('\t');
            }
        }
        buff.deleteCharAt(buff.length()-1);
        buff.deleteCharAt(buff.length()-1);
        if (code == CODE.PHP)
            buff.append("\n);");
        else if (code == CODE.JAVAFUNC)
            buff.append("\n\t};\n}");
        else
            buff.append("\n};");
        return buff.toString();
    }
    
    public static void main(String[] args)
    {
        try
        {
            String code = makeIt ("arr", "c:\\users\\administrator\\dropbox\\jac64\\jac64_source\\roms\\chargen.c64");
            DebugOut.get().out.println (code);
        }
        catch (Exception ex)
        {
            System.err.println (ex);
        }
    }
}