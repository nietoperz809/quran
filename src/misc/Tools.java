/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
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
import java.util.ArrayList;
import java.util.List;
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

    public static void saveImage(Frame parent, BufferedImage img)
    {
        FileDialog fd = new FileDialog(parent, "Save", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() == null)
        {
            return;
        }
        File f = new File(fd.getDirectory() + fd.getFile());
        try
        {
            ImageIO.write(img, "png", f);
        }
        catch (IOException ex)
        {
        }
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
        ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();

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
            return result;
        for (File file : files)
        {
            if (file.isFile())
            {
                result.add(file.getName());
            }
        }
        return result;
    }

}
