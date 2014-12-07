/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Administrator
 */
public class MDIActions
{
    public static void closeAll (JDesktopPane desk)
    {
        JInternalFrame[] allframes = desk.getAllFrames();
        for (JInternalFrame f : allframes)
            desk.getDesktopManager().closeFrame(f);
    }
    
    public static void arrange (JDesktopPane desk)
    {
        // How many frames do we have?
        JInternalFrame[] allframes = desk.getAllFrames();
        int count = allframes.length;
        if (count == 0)
        {
            return;
        }

        // Determine the necessary grid size
        int sqrt = (int) Math.sqrt(count);
        int rows = sqrt;
        int cols = sqrt;
        if (rows * cols < count)
        {
            cols++;
            if (rows * cols < count)
            {
                rows++;
            }
        }

        // Define some initial values for size & location.
        Dimension size = desk.getSize();

        int w = size.width / cols;
        int h = size.height / rows;
        int x = 0;
        int y = 0;

        // Iterate over the frames, deiconifying any iconified frames and then
        // relocating & resizing each.
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols && ((i * cols) + j < count); j++)
            {
                JInternalFrame f = allframes[(i * cols) + j];

                if (!f.isClosed() && f.isIcon())
                {
                    try
                    {
                        f.setIcon(false);
                    }
                    catch (PropertyVetoException ignored)
                    {
                    }
                }

                desk.getDesktopManager().resizeFrame(f, x, y, w, h);
                x += w;
            }
            y += h; // start the next row
            x = 0;
        }
    }
}
