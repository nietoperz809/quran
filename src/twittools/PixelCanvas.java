/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class PixelCanvas extends JPanel
{
    private BufferedImage m_img = null;

    public void setImage(BufferedImage i)
    {
        m_img = i;
    }

    public BufferedImage getImage()
    {
        return m_img;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (m_img == null)
        {
            return;
        }
        g.drawImage(m_img, 0, 0, null);
    }
    
}
