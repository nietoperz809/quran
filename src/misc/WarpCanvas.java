/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.Point;
import warper.ImageWarper;
import warper.MouseAction;

/**
 *
 * @author Administrator
 */
public class WarpCanvas extends InteractivePixelCanvas implements MouseAction
{
    public WarpCanvas()
    {
        super();
        action = this;
    }

    @Override
    public void doMouseAction(Point pt1, Point pt2)
    {
        ImageWarper wa = new ImageWarper (m_img, pt1, pt2);
        m_img = wa.warpPixels();
    }
}
