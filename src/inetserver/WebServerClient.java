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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import misc.Tools;
import misc.Transmitter;

/**
 *
 * @author Administrator
 */
public class WebServerClient implements Runnable
{
    private final Socket m_sock;
    private final Thread m_thread;
    private final String rootPath;
    private WebServerGUI _gui;

    /**
     * Constructor
     * @param s communication socket
     * @param rp web server root path
     */
    public WebServerClient(Socket s, String rp)
    {
        rootPath = rp;
        m_sock = s;
        m_thread = new Thread(this);
        m_thread.start();
    }

    /**
     * Constructor
     * @param s communication socket
     * @param rp web server root path
     * @param g GUI  
     */
    public WebServerClient(Socket s, String rp, WebServerGUI g)
    {
        this(s, rp);
        _gui = g;
    }

    /**
     * Is File MP4
     * @param in file name
     * @return TRUE if file is named .mp4
     */
    private boolean isMP4(String in)
    {
        return in.toLowerCase().endsWith(".mp4");
    }

    /**
     * Is File Jpeg?
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

    String makeHTTPHeader (int len, String type)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK"+"\r\n");
        sb.append("Content-Length: ").append(len).append("\r\n");
        sb.append("Content-Type: ").append(type).append("; charset=utf-8"+"\r\n");
        sb.append("\r\n");
        return sb.toString();
    }
    
    /**
     * Send HTTP response header
     * @param out socket as printwriter
     * @param txt content as String
     * @param type Type parameter
     */
    private void sendHeader(PrintWriter out, int len, String type)
    {
        String s = makeHTTPHeader (len, type);
        out.print(s);
    }

    private void sendHeader(OutputStream out, int len, String type) throws Exception
    {
        String s = makeHTTPHeader (len, type);
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
            sb2.append("<a href=\"").append(URLEncoder.encode(pp.toString())).append("\">");
            sb2.append("*BACK*").append("</a>").append("<hr>\r\n");
        }
        for (File fil : fils)
        {
            String name = fil.getName();
            Path p = Paths.get(path, name);
            if (fil.isDirectory())
            {
                dirs.add(p);
            }
            else if (isJpeg(name))
            {
                sb.append("<a href=\"");
                sb.append("*IMG*");
                sb.append(URLEncoder.encode(p.toString()));
                sb.append("\" target=\"_blank\"><img src=\"");
                sb.append(URLEncoder.encode(p.toString()));
                sb.append("\"></a>\r\n");
            }
            else if (isText(name) || isZip(name) || isMP4(name))
            {
                txtfiles.add(p);
            }
        }
        for (Path dir : dirs)
        {
            sb2.append("<a href=\"").append(URLEncoder.encode(dir.toString())).append("\">");
            sb2.append(dir.getFileName().toString()).append("</a>").append("</br>\r\n");
        }
        for (Path fil : txtfiles)
        {
            sb2.append("<a href=\"").append(URLEncoder.encode(fil.toString())).append("\">");
            sb2.append(fil.getFileName().toString()).append("</a>").append("</br>\r\n");
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
    private void sendJpegSmall(OutputStream out, String path)
    {
        File f = new File(path);
        PrintWriter w = new PrintWriter(out);
        try
        {
            byte[] b = Tools.reduceImg(f, 0.2f);
            imgHead(w, b.length);
            Transmitter t = new Transmitter(b, out);
            t.doTransmission(_gui);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
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
            imgHead(w, (int) f.length());
            Transmitter t = new Transmitter(input, out);
            t.doTransmission(_gui);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            //Logger.getLogger(WebServerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // not tested
    private void sendMP4(OutputStream out, String fname)
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        
        try
        {
            InputStream input = new FileInputStream(f);
            if (false == mp4Head(w, f.length(), fname))
            {
                w.println("File too small");
                w.close();
            }
            Transmitter t = new Transmitter(input, out);
            t.doTransmission(_gui);
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

    private void sendZip(OutputStream out, String fname)
    {
        File f = new File(fname);
        PrintWriter w = new PrintWriter(out);
        try
        {
            InputStream input = new FileInputStream(f);
            mp4Head(w, f.length(), fname);
            Transmitter t = new Transmitter(input, out);
            t.doTransmission(_gui);
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

    /**
     * send image page
     *
     * @param out Print Writer
     */
    private void imagePage (OutputStream out, PrintWriter out2, String path) throws Exception
    {
        String txt = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"/></head>\r\n" 
                + buildMainPage(path) 
                + "\r\n</html>";
        byte[] bt = txt.getBytes(StandardCharsets.UTF_8);//"UTF-8");
        sendHeader(out, bt.length, "text/html");
        out.write(bt);
        out.flush();
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
            System.err.println(ex);
            return null;
        }
    }

    private void textFile (PrintWriter out, String path)
    {
        try
        {
            byte[] b = getTextFile(path);
            String cnt = new String(b, "ISO-8859-1");
            String txt = "<html><pre>\r\n" + cnt + "</pre></html>";
            sendHeader(out, txt.length(), "text/html");
            out.print(txt);
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

    private String[] getInput(BufferedReader in)
    {
        try
        {
            String[] out = in.readLine().split(" ");
            out[1] = java.net.URLDecoder.decode(out[1]);
            return out;
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
        return null;
    }

//    private void naked(PrintWriter out, String txt)
//    {
//        sendHeader(out, txt, "text/text");
//        out.print(txt);
//    }
    private void perform() throws Exception
    {
        //System.gc ();
        //System.runFinalization ();
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
                    path = rootPath;
                }
                imagePage(m_sock.getOutputStream(), out, path);
            }
            out.flush();
            out.close();
        }
    }

    @Override
    public void run()
    {
        try
        {
            perform();
            //m_sock.shutdownOutput();
            m_sock.close();
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }
}
