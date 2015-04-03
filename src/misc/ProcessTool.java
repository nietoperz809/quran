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
    private Thread thr;

    public ProcessTool(String cmd)
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
            catch (Exception ex)
            {
                System.out.println (ex);
                pc = null;
            }
        };
        thr = new Thread(r);
        thr.start();
    }

    public InputStream getInput()
    {
        return in;
    }
    
    public ProcessTool(String cmd, int wait)
    {
        this(cmd);
        try
        {
            Thread.sleep(wait);
        }
        catch (InterruptedException ex)
        {
        }
    }

    public void kill()
    {
        pc.destroyForcibly();
        pc = null;
    }

    public void writeln(String s)
    {
        write(s + "\r\n");
    }

    public String ww(String s)
    {
        writeln(s);
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

    public void write(String s)
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

    public void clear()
    {
        try
        {
            out.flush();
            while (in.available() > 0)
                in.read();
        }
        catch (IOException ex)
        {
            
        }
    }
    
    public String read()
    {
        return read(500);
    }

    public String readtrim()
    {
        return read().trim().replace("\r\n\r\n", "\r\n");
    }

    public String read(int wait)
    {
        if (pc == null)
        {
            return null;
        }
        try
        {
            byte[] b = new byte[1];
            StringBuilder sb = new StringBuilder();
            out:
            while (true)
            {
                long t1 = System.currentTimeMillis() + wait;
                while (in.available() <= 0)
                {
                    if (t1 < System.currentTimeMillis())
                    {
                        break out;
                    }
                }
                in.read (b);
                sb.append ((char)b[0]);
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
