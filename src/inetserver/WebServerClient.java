package inetserver;

import applications.WebServerGUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import misc.Tools;
import misc.Transmitter;
import transform.Transformation;
import transform.UrlEncodeUTF8;

/**
 *
 * @author Administrator
 */
public class WebServerClient implements Runnable, Comparable
{
    private final Socket m_sock;
    private final int m_buffSize;
    private final Thread m_thread;
    private final WebServerGUI _gui;
    private final UrlEncodeUTF8 m_urltransform;
    private static int instances;

    /**
     * Constructor
     *
     * @param b send buffer size
     * @param s communication socket
     * @param g GUI
     */
    public WebServerClient(int b, Socket s, WebServerGUI g)
    {
        m_buffSize = b;
        m_sock = s;
        m_urltransform = new UrlEncodeUTF8();
        _gui = g;
        m_thread = new Thread(this);
        instances++;
        m_thread.setName("webConn" + instances);
        m_thread.start();
    }

    public boolean isRunning()
    {
        return m_thread.isAlive();
    }
    
    /**
     * Is File MP4
     *
     * @param in file name
     * @return TRUE if file is named .mp4
     */
    private boolean isMP4(String in)
    {
        return in.toLowerCase().endsWith(".mp4");
    }

    /**
     * Is File Jpeg?
     *
     * @param in file name
     * @return TRUE if file is jpeg
     */
    private boolean isJpeg(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".jpg") || in.endsWith(".jpeg");
    }

    /**
     * Is File Zip?
     *
     * @param in file name
     * @return TRUE if file is zip
     */
    private boolean isZip(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".zip") || in.endsWith(".rar");
    }

    /**
     * Is Text file
     *
     * @param in file name
     * @return TRUE if file is text file
     */
    private boolean isText(String in)
    {
        in = in.toLowerCase();
        return in.endsWith(".txt") || in.endsWith(".c")
                || in.endsWith(".cpp")
                || in.endsWith(".h") || in.endsWith(".cxx")
                || in.endsWith(".hxx") || in.endsWith(".java");
    }

    String makeHTTPHeader(int len, String type)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK" + "\r\n");
        sb.append("Content-Length: ").append(len).append("\r\n");
        sb.append("Content-Type: ").append(type).append("; charset=utf-8" + "\r\n");
        sb.append("\r\n");
        return sb.toString();
    }

    /**
     * Send HTTP response header
     *
     * @param out socket as printwriter
     * @param txt content as String
     * @param type Type parameter
     */
    private void sendHeader(PrintWriter out, int len, String type)
    {
        String s = makeHTTPHeader(len, type);
        out.print(s);
    }

    private void sendHeader(OutputStream out, int len, String type) throws Exception
    {
        String s = makeHTTPHeader(len, type);
        out.write(s.getBytes());
    }

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
            String u8 = m_urltransform.transform(pp.toString());
            sb2.append("<a href=\"").append(u8).append("\">");
            sb2.append("*BACK*").append("</a>").append("<hr>\r\n");
        }
        for (File fil : fils)
        {
            String name = fil.getName();
            Path p = Paths.get(path, name);
            String u8 = m_urltransform.transform(p.toString());
            if (fil.isDirectory())
            {
                dirs.add(p);
            }
            else if (isJpeg(name))
            {
                sb.append("<a href=\"");
                sb.append("*IMG*");
                sb.append(u8);
                sb.append("\" target=\"_blank\"><img src=\"");
                sb.append(u8);
                sb.append("\"></a>\r\n");
            }
            else if (isMP4(name))
            {
                sb.append("<video controls src=\"");
                sb.append(u8).append("\">");
                sb.append("Your user agent does not support the HTML5 Video element.</video>");
                sb.append("\r\n");
            }
            else if (isText(name) || isZip(name))
            {
                txtfiles.add(p);
            }
        }
        for (Path dir : dirs)
        {
            String u8 = m_urltransform.transform(dir.toString());
            sb2.append("<a href=\"").append(u8).append("\">");
            sb2.append(dir.getFileName().toString()).append("</a>").append("<br>\r\n");
        }
        for (Path fil : txtfiles)
        {
            String u8 = m_urltransform.transform(fil.toString());
            sb2.append("<a href=\"").append(u8).append("\">");
            sb2.append(fil.getFileName().toString()).append("</a>").append("<br>\r\n");
        }
        sb2.append("<hr>");
        sb2.append(sb);
        //System.err.println(sb2.toString());
        return sb2.toString();
    }

//    private void zipHead(PrintWriter w, int len, String filename)
//    {
//        w.println("HTTP/1.1 200 OK");
//        w.println("Pragma: public");
//        w.println("Expires: 0");
//        w.println("Cache-Control: must-revalidate, post-check=0, pre-check=0");
//        w.println("Cache-Control: public");
//        w.println("Content-Description: File Transfer");
//        w.println("Content-type: application/octet-stream");
//        w.println("Content-Disposition: attachment; filename=\"" + filename + "\"");
//        w.println("Content-Transfer-Encoding: binary");
//        w.println("Content-Length: " + len);
//        w.println();
//    }
    /**
     * Send MP4 HTTP header
     *
     * @param w Socket writer
     * @param len File length
     * @param filename name of file
     * @return FALSE if something goes wrong
     */
    private boolean mp4Head(PrintWriter w, long len, String filename)
    {
        if (len <= 0)
        {
            return false;
        }
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
        return true;
    }

    /**
     * Send image HTTP response header
     *
     * @param w output socket as printwriter
     * @param len size of image
     */
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
    private void sendJpegSmall(OutputStream out, String path) throws Exception
    {
        File f = new File(path);
        PrintWriter w = new PrintWriter(out);
        byte[] b = Tools.reduceImg(f, 0.2f);
        imgHead(w, b.length);
        Transmitter t = new Transmitter(b, out, m_buffSize);
        t.doTransmission(_gui);
        //System.gc ();
        //System.runFinalization ();
    }

    private void sendJpegOriginal(OutputStream out, String fname) throws IOException
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        InputStream input = new FileInputStream(f);
        imgHead(w, (int) f.length());
        Transmitter t = new Transmitter(input, out, m_buffSize);
        t.doTransmission(_gui);
    }

    // not tested
    private void sendMP4(OutputStream out, String fname) throws Exception
    {
        System.err.println("Sending MP4: " + fname);
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);

        InputStream input = new FileInputStream(f);
        if (false == mp4Head(w, f.length(), fname))
        {
            w.println("File too small");
            w.close();
        }
        Transmitter t = new Transmitter(input, out, m_buffSize);
        t.doTransmission(_gui);
    }

    private void sendZip(OutputStream out, String fname) throws IOException
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        InputStream input = new FileInputStream(f);
        mp4Head(w, f.length(), fname);
        Transmitter t = new Transmitter(input, out, m_buffSize);
        t.doTransmission(_gui);
    }

    /**
     * send image page
     *
     * @param out Print Writer
     */
    private void imagePage(OutputStream out, PrintWriter out2, String path) throws Exception
    {
        String txt = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"/></head>\r\n"
                + buildMainPage(path)
                + "\r\n</html>";
        byte[] bt = txt.getBytes(Transformation.utf8);
        sendHeader(out, bt.length, "text/html");
        out.write(bt);
        out.flush();
    }

    private byte[] getTextFile(String file) throws IOException
    {
        Path p = Paths.get(file);
        return Files.readAllBytes(p);
    }

    private void textFile(PrintWriter out, String path) throws IOException
    {
        byte[] b = getTextFile(path);
        String cnt = new String(b, "ISO-8859-1");
        String txt = "<html><pre>\r\n" + cnt + "</pre></html>";
        sendHeader(out, txt.length(), "text/html");
        out.print(txt);
    }

    private String[] getInput(BufferedReader in) throws Exception
    {
//        while (in.ready() == false)
//        {
//            System.out.println("Tick");
//            Thread.sleep(1000);
//        }
        String[] out = in.readLine().split(" ");
        return out;
    }
    
    public void closeSocket()
    {
        try
        {
            m_sock.shutdownOutput();
            m_sock.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    private void perform() throws Exception
    {
        BufferedReader in
                = new BufferedReader(new InputStreamReader(m_sock.getInputStream()));
        PrintWriter out
                = new PrintWriter(m_sock.getOutputStream(), true);
        String[] si = getInput(in);
        if (si == null)
        {
            return;
        }
        String path = si[1].substring(1);

        path = m_urltransform.retransform(path);

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
        else if (isMP4(path))
        {
            sendMP4(m_sock.getOutputStream(), path);
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
                path = _gui.getBasePath();
            }
            imagePage(m_sock.getOutputStream(), out, path);
        }
        out.flush();
        out.close();
        m_sock.close();
    }

    @Override
    public void run()
    {
        System.out.println("++ Client");
        try
        {
            perform();
            Sockserver.removClient(this);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            //System.err.println(ex + " " + Thread.currentThread().getName());
        }

        System.out.println("-- Client");
        //instances--;
    }

    @Override
    public int compareTo(Object o)
    {
        return o.hashCode() - this.hashCode();
    }
}
