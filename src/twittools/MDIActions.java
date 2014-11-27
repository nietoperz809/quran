/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Administrator
 */
public class MDIActions
{
    public static void arrange (JDesktopPane desk, ActionEvent ev)
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
