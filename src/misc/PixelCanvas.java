/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import twitter.TwitTools;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class PixelCanvas extends JPanel
{
    protected BufferedImage m_img = null;

    public void setImage(BufferedImage i)
    {
        m_img = i;
    }

    public BufferedImage getImage()
    {
        return m_img;
    }

    public void tweet (String label)
    {
        if (m_img == null)
            return;
        try
        {
            TwitTools.get().send(m_img, label);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void toClipboard()
    {
        if (m_img == null)
            return; 
        new ClipboardImage (m_img);
    }
    
    protected void drawImg (Graphics g)
    {
        int w = getWidth();
        int h = getHeight();
        int wi = m_img.getHeight(null);
        int hi = m_img.getWidth(null);
        int off_x = (w-wi)/2;
        int off_y = (h-hi)/2;
        g.drawImage(m_img, off_x, off_y, null);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (m_img == null)
        {
            return;
        }
        drawImg(g);
    }
    
}
