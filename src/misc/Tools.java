/*
 * Tools of all kind
 */
package misc;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class Tools
{
    public static String humanReadableByteCount (long bytes, boolean si)
    {
        int unit = si ? 1000 : 1024;
        if (bytes < unit)
        {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static String humanReadableByteCount (long bytes)
    {
        DecimalFormat myFormatter = new DecimalFormat("000,000,000");
        return "  "+myFormatter.format (bytes);
    }
    
    
    /**
     * Load a buffered image from disk
     *
     * @param parent
     * @return
     */
    public static BufferedImage loadImage(Frame parent)
    {
        FileDialog fd = new FileDialog(parent, "Load", FileDialog.LOAD);
        fd.show();
        if (fd.getFile() == null)
        {
            return null;
        }
        File f = new File(fd.getDirectory() + fd.getFile());
        try
        {
            return ImageIO.read(f);
        }
        catch (IOException ex)
        {
        }
        return null;
    }

    public static boolean saveImage (String name, BufferedImage img)
    {
        if (!name.endsWith(".png"))
        {
            name = name + ".png";
        }
        File f = new File(name);
        try
        {
            ImageIO.write(img, "png", f);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static boolean saveImage(BufferedImage img)
    {
        FileDialog fd = new FileDialog((Frame)null, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() == null)
        {
            return false;
        }
        return saveImage (fd.getDirectory() + fd.getFile(), img);
    }

    /**
     * Creates Image copy of new size
     *
     * @param originalImage Input image
     * @param b With
     * @param h Height
     * @return new Image
     */
    public static BufferedImage resizeImage(BufferedImage originalImage, int b, int h)
    {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(b, h, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, b, h, null);
        g.dispose();
        return resizedImage;
    }

    /**
     * Reduces image quality
     *
     * @param path Path of jpeg file
     * @param qual Quality 0.0 ... 1.0
     * @return byte array of jpeg data
     * @throws Exception
     */
    public static byte[] reduceImg(File path, float qual) throws Exception
    {
        BufferedImage image = ImageIO.read(path);
        image = resizeImage(image, 100, 100);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(qual); // Change this, float between 0.0 and 1.0

        writer.setOutput(ImageIO.createImageOutputStream(os));
        writer.write(null, new IIOImage(image, null, null), param);
        writer.dispose();
        return os.toByteArray();
    }

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
        DebugOut.get().out.println(res);
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
        DebugOut.get().out.println(res);
        return res;
    }

    static void printStringArray(String[] sa)
    {
        for (String s : sa)
        {
            DebugOut.get().out.println(s);
            DebugOut.get().out.println(s.length());
            DebugOut.get().out.println("----------------");
        }
    }

    static void printStringList(List<String> sa)
    {
        for (String s : sa)
        {
            DebugOut.get().out.println(s);
            DebugOut.get().out.println("----------------");
        }
    }

    static final String m_path = "../ser/";

    /**
     * Create a save
     *
     * @param filename
     * @param o
     * @throws Exception
     */
    public static void serialize(String filename, Object o) throws Exception
    {
        new File(m_path).mkdirs();
        FileOutputStream f_out = new FileOutputStream(m_path + filename);
        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
        obj_out.writeObject(o);
        obj_out.close();
        f_out.close();
    }

    /**
     * Delete a save
     *
     * @param filename
     */
    public static void deleteSave(String filename)
    {
        File f = new File(m_path + filename);
        String message = f.exists() ? "is in use by another app" : "does not exist";
        if (!f.delete())
        {
            DebugOut.get().out.println("Could not delete " + m_path + filename + " -- " + message);
        }
    }

    /**
     * Open a save
     *
     * @param filename
     * @return
     * @throws Exception
     */
    public static Object deSerialize(String filename) throws Exception
    {
        Object ret = null;
        FileInputStream f_in = new FileInputStream(m_path + filename);
        ObjectInputStream obj_in = new ObjectInputStream(f_in);
        try
        {
            ret = obj_in.readObject();
        }
        finally
        {
            obj_in.close();
            f_in.close();
        }
        return ret;
    }

    public static void toClipBoard(final String s)
    {
        StringSelection selection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public static String removeHTML(String s)
    {
        s = s.replace("<br>", "\n");
        s = s.replaceAll("\\<.*?>", "");
        return s;
    }

    /**
     * Get a list of all saves
     *
     * @return
     */
    public static List<String> listSaves()
    {
        List<String> result = new ArrayList<>();
        File[] files = new File(m_path).listFiles();
        if (files == null)
        {
            return result;
        }
        for (File file : files)
        {
            if (file.isFile())
            {
                result.add(file.getName());
            }
        }
        return result;
    }

    /**
     * Get all file names of a package
     *
     * @param path package (as "hello/world/uh" instead of hello.world.uh)
     * @return String array with all names
     * @throws Exception
     */
    public static String[] listPackage(String path)
    {
        try
        {
            int pathLen = path.length();
            URL url1 = ClassLoader.getSystemResource(path);

            String jarFileName;
            JarFile jf;
            Enumeration<JarEntry> jarEntries;
            String entryName;
            ArrayList<String> list = new ArrayList<>();

            jarFileName = URLDecoder.decode(url1.getFile(), "UTF-8");
            jarFileName = jarFileName.substring(5, jarFileName.indexOf("!"));
            jf = new JarFile(jarFileName);
            jarEntries = jf.entries();
            while (jarEntries.hasMoreElements())
            {
                entryName = jarEntries.nextElement().getName();
                if (entryName.startsWith(path))
                {
                    entryName = entryName.substring(pathLen);
                    if (!entryName.isEmpty())
                    {
                        list.add(entryName);
                    }
                }
            }
            String[] arr = new String[list.size()];
            list.toArray(arr);
            return arr;
        }
        catch (Exception ex)
        {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getBuildNumber()
    {
        ResourceBundle vprops = ResourceBundle.getBundle("version", Locale.getDefault());
        String number = vprops.getString("BUILDNUMBER");
        String date = vprops.getString("BUILDDATE");
        return date + "/" + number;
    }

    /**
     * Centers Component
     *
     * @param a Component to center
     * @param b Parent component
     */
    public static void centerComponent(Component a, Component b)
    {
        Dimension db = b.getSize();
        Dimension da = a.getSize();
        Point pt = new Point((db.width - da.width) / 2, (db.height - da.height) / 2);
        if (pt.x < 0)
        {
            pt.x = 0;
        }
        if (pt.y < 0)
        {
            pt.y = 0;
        }
        a.setLocation(pt);
    }
}
