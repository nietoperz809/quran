/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class QuadraticPixelCanvas extends PixelCanvas
{
    @Override
    protected void drawImg (Graphics g)
    {
        int w = getWidth();
        int h = getHeight();
        int i = Math.min(w, h);
        int off_x = (w-i)/2;
        int off_y = (h-i)/2;
        g.drawImage(m_img, off_x, off_y, i, i, null);
    }
}
