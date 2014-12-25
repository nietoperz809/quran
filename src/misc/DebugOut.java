/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Administrator
 */
public class DebugOut
{
    static private DebugOut instance;
    public PrintStream out; 
    
    private DebugOut()
    {
        out = new PrintStream(new OutputStream()
        {
            @Override
            public void write(int b) throws IOException
            {
                System.out.write(b);
            }
        });
    }
    
    static public DebugOut get()
    {
        if (instance == null)
            instance = new DebugOut();
        return instance;
    }
}
