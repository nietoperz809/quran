/*
 * Run external process 
*/
package misc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Administrator
 */
public class ProcessTool
{
    private Process pc;
    private InputStream in;
    private OutputStream out;

    ProcessTool(String cmd)
    {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Runnable r = () ->
        {
            try
            {
                pc = pb.start();
                in = pc.getInputStream();
                out = pc.getOutputStream();
            }
            catch (IOException ex)
            {
                pc = null;
            }
        };
        new Thread(r).start();
    }

    ProcessTool(String cmd, int wait)
    {
        this (cmd);
        try
        {
            Thread.sleep (wait);
        }
        catch (InterruptedException ex)
        {
        }
    }
    
    public synchronized void kill()
    {
        pc.destroyForcibly();
        pc = null;
    }
    
    public void writeln (String s) 
    {
        write (s+"\r\n");
    }

    public String ww (String s)
    {
        writeln (s);
        try
        {
            while (in.available() <= 0);
        }
        catch (IOException ex)
        {
            return null;
        }
        return read();
    }
    
    public synchronized void write(String s)
    {
        if (pc == null)
        {
            return;
        }
        try
        {
            out.write(s.getBytes());
            out.flush();
        }
        catch (IOException ex)
        {
        }
    }

    public synchronized String read()
    {
        if (pc == null)
        {
            return null;
        }
        try
        {
            StringBuilder sb = new StringBuilder();
            out: while (true)
            {
                long t1 = System.currentTimeMillis()+100;
                while (in.available() <= 0)
                {
                    if (t1 < System.currentTimeMillis())
                        break out;
                }
                byte[] b = new byte[256];
                in.read(b);
                sb.append (new String(b));
            }
            return sb.toString();
        }
        catch (IOException ex)
        {
            return null;
        }
    }

    // test
    public static void main(String[] args) throws InterruptedException
    {
        ProcessTool cmd = new ProcessTool("diskpart", 1000);

        String s = cmd.read();
        System.out.println(s);

        s = cmd.ww("help");
        System.out.println(s);
    }
}
