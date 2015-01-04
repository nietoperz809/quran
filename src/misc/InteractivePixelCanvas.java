/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Administrator
 */
public class InteractivePixelCanvas extends PixelCanvas implements MouseListener, MouseMotionListener
{
    private int m_x;
    private int m_y;
    private int m_oldx;
    private int m_oldy;
    private final Color m_xorcolor = new Color(255, 255, 255);
    
    public InteractivePixelCanvas()
    {
        super();
        addMouseListener (this);
        addMouseMotionListener (this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        m_x = e.getX();
        m_y = e.getY();
        m_oldx = m_x;
        m_oldy = m_y;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (m_img == null)
            return;
        repaint();
        float yb = m_img.getHeight();
        float xb = m_img.getWidth();
        float ys = size().height;
        float xs = size().width;
        int xb1 = (int) (xb * m_x / xs);
        int yb1 = (int) (yb * m_y / ys);
        int xb2 = (int) (xb * e.getX() / xs);
        int yb2 = (int) (yb * e.getY() / ys);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        Graphics g = getGraphics();
        g.setXORMode(m_xorcolor);
        g.drawLine(m_x, m_y, m_oldx, m_oldy);
        g.drawLine(m_x, m_y, e.getX(), e.getY());
        m_oldx = e.getX();
        m_oldy = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
