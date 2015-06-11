package webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.Tools;

/**
 *
 * @author Administrator
 */
public class Client implements Runnable
{
    Socket m_sock;
    Thread m_thread;
    String rootPath;
    
    public Client (Socket s, String rp)
    {
        rootPath = rp;
        m_sock = s;
        m_thread = new Thread(this);
        m_thread.start();
    }

    private boolean isJpeg(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".jpg") || in.endsWith(".jpeg");
    }

    private boolean isZip(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".zip") || in.endsWith(".rar");
    }

    private boolean isText(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".txt") || in.endsWith(".c")
                || in.endsWith(".cpp")
                || in.endsWith(".h") || in.endsWith(".cxx")
                || in.endsWith(".hxx") || in.endsWith(".java");
    }

    private void sendHeader(PrintWriter out, String txt, String type)
    {
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Length: " + txt.getBytes().length);
        out.println("Content-Type: " + type + "; charset=utf-8");
        out.println();
    }

//    protected void html(PrintWriter out, String txt)
//    {
//        txt = "<html>" + txt + "</html>";
//        sendHeader(out, txt, "text/html");
//        out.print(txt);
//    }
    /**
     * Build HTML page for directory
     *
     * @param path dir to be used
     * @return html page
     */
    private String buildMainPage(String path)
    {
        File f = new File(path);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        File[] fils = f.listFiles();

        if (fils == null)
        {
            return "--- noone";
        }

        ArrayList<Path> dirs = new ArrayList<>();
        ArrayList<Path> txtfiles = new ArrayList<>();

        Path pp = Paths.get(path).getParent();
        if (pp != null)
        {
            sb2.append("<a href=\"").append(URLEncoder.encode(pp.toString())).append("\">");
            sb2.append("*BACK*").append("</a>").append("<hr>\r\n");
        }
        for (File fil : fils)
        {
            String name = fil.getName();
            String low = name.toLowerCase();
            Path p = Paths.get(path, name);
            if (fil.isDirectory())
            {
                dirs.add(p);
            }
            else if (isJpeg(low))
            {
                sb.append("<a href=\"");
                sb.append("*IMG*");
                sb.append(URLEncoder.encode(p.toString()));
                sb.append("\" target=\"_blank\"><img src=\"");
                sb.append(URLEncoder.encode(p.toString()));
                sb.append("\"></a>\r\n");
            }
            else if (isText(low) || isZip(low))
            {
                txtfiles.add(p);
            }
        }
        for (Path dir : dirs)
        {
            sb2.append("<a href=\"").append(URLEncoder.encode(dir.toString())).append("\">");
            sb2.append(dir.getFileName().toString()).append("</a>").append("&nbsp;|&nbsp;\r\n");
        }
        for (Path fil : txtfiles)
        {
            sb2.append("<a href=\"").append(URLEncoder.encode(fil.toString())).append("\">");
            sb2.append(fil.getFileName().toString()).append("</a>").append("&nbsp;|&nbsp;\r\n");
        }
        sb2.append("<hr>");
        sb2.append(sb);
        return sb2.toString();
    }

    private void zipHead(PrintWriter w, int len, String filename)
    {
        w.println("HTTP/1.1 200 OK");
        w.println("Pragma: public");
        w.println("Expires: 0");
        w.println("Cache-Control: must-revalidate, post-check=0, pre-check=0");
        w.println("Cache-Control: public");
        w.println("Content-Description: File Transfer");
        w.println("Content-type: application/octet-stream");
        w.println("Content-Disposition: attachment; filename=\"" + filename + "\"");
        w.println("Content-Transfer-Encoding: binary");
        w.println("Content-Length: " + len);
        w.println();
    }

    private void imgHead(PrintWriter w, int len)
    {
        w.println("HTTP/1.1 200 OK");
        w.println("Content-Length: " + len);
        w.println("Content-Type: image/jpeg");
        w.println("Cache-Control: max-age=31536000, public");
        //w.println("Expires: 06 Apr 2020 19:25:30 GMT");
        w.println("Connection: close");
        w.println();
    }

    /**
     * Send JPEG to output stream
     *
     * @param out output stream
     * @param fname file name
     */
    private void sendJpegSmall(OutputStream out, String path)
    {
        File f = new File(path);
        PrintWriter w = new PrintWriter(out);
        try
        {
            byte[] b = Tools.reduceImg(f, 0.2f);
            imgHead(w, b.length);
            out.write(b);
            w.flush();
            out.flush();
        }
        catch (Exception ex)
        {
            System.out.println("catch");
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.gc ();
        //System.runFinalization ();
    }

    private void sendJpegOriginal(OutputStream out, String fname)
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        try
        {
            InputStream input = new FileInputStream(f);
            byte[] b = new byte[(int) f.length()];
            input.read(b);
            imgHead(w, b.length);
            out.write(b);
            w.flush();
            out.flush();
        }
        catch (Exception ex)
        {
            System.out.println("catch");
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendZip(OutputStream out, String fname)
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        try
        {
            InputStream input = new FileInputStream(f);
            byte[] b = new byte[(int) f.length()];
            input.read(b);
            zipHead (w, b.length, fname);
            out.write(b);
            w.flush();
            out.flush();
        }
        catch (Exception ex)
        {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * send image page
     *
     * @param out Print Writer
     */
    private void imagePage(PrintWriter out, String path)
    {
        String txt = "<html>\r\n" + buildMainPage(path) + "</html>";
        sendHeader(out, txt, "text/html");
        out.print(txt);
    }

    private byte[] getTextFile(String file)
    {
        Path p = Paths.get(file);
        try
        {
            return Files.readAllBytes(p);
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    private void textFile(PrintWriter out, String path)
    {
        try
        {
            byte[] b = getTextFile(path);
            String cnt = new String(b, "ISO-8859-1");
            String txt = "<html><pre>\r\n" + cnt + "</pre></html>";
            sendHeader(out, txt, "text/html");
            out.print(txt);
        }
        catch (Exception ex)
        {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getInput(BufferedReader in)
    {
        try
        {
            String[] out = in.readLine().split(" ");
            out[1] = java.net.URLDecoder.decode(out[1], "UTF-8");
            return out;
        }
        catch (Exception ex)
        {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void naked(PrintWriter out, String txt)
    {
        sendHeader(out, txt, "text/text");
        out.print(txt);
    }

    private void perform() throws Exception
    {
        //System.gc ();
        //System.runFinalization ();
        System.out.println(Runtime.getRuntime().freeMemory());
        try (BufferedReader in
                = new BufferedReader(new InputStreamReader(m_sock.getInputStream()));
                PrintWriter out
                = new PrintWriter(m_sock.getOutputStream(), true);)
        {
            String[] si = getInput(in);
            if (si == null)
            {
                return;
            }
            String path = si[1].substring(1);
            //String lowpath = path.toLowerCase();
            if (isJpeg(path))
            {
                if (path.startsWith("*IMG*"))
                {
                    sendJpegOriginal(m_sock.getOutputStream(), path.substring(5));
                }
                else
                {
                    sendJpegSmall(m_sock.getOutputStream(), path);
                }
            }
            else if (isZip(path))
            {
                sendZip(m_sock.getOutputStream(), path);
            }
            else if (isText(path))
            {
                textFile(out, path);
                //System.out.println("text -- " + path);
            }
            else
            {
                if (path.isEmpty())
                {
                    path = rootPath;
                }
                imagePage(out, path);
            }
        }
    }

    @Override
    public void run()
    {
        try
        {
            perform();
            m_sock.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
