/*
 */
package misc;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 * Background image drawing in JDesktopPane
 * @author Administrator
 */
public class BackWindow extends JDesktopPane // implements PathNames
{
    private static final long serialVersionUID = 1L;
    private Image image;

    public BackWindow ()
    {
        this ("allah.jpg");
    }

    public BackWindow (String BackImagePath)
    {
        image = ImageTools.loadImageFromRessource(BackImagePath);
    }

    public BackWindow (InputStream in)
    {
        load (in);
    }

    private void load (InputStream is)
    {
        this.setOpaque(false);
        try
        {
            image = ImageIO.read (is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent (Graphics g)
    {
        int x = this.getWidth();
        int y = this.getHeight();
        g.drawImage(image, 0, 0, x, y, this);
    }
}
