/*
 */
package misc;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 * Background image drawing JDesktopPane
 * @author Administrator
 */
public class BackWindow extends JDesktopPane implements PathNames
{
    private static final long serialVersionUID = 1L;
    private Image image;

    public BackWindow()
    {
        this.setOpaque(false);
        try
        {
            image = ImageIO.read(new File(BackImagePath));
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
