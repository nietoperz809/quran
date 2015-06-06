/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magnify;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.ClipboardImage;
import twitter.TwitTools;

/**
 *
 * @author Administrator
 */
public class MagnifyPanel extends javax.swing.JPanel
{
    Robot robot;
    Rectangle re;
    BufferedImage img;
    Point pt;

    /**
     * Creates new form magnifyPanel
     */
    public MagnifyPanel()
    {
        try
        {
            robot = new Robot();
            re = new Rectangle();
            initComponents();
        }
        catch (AWTException ex)
        {
            Logger.getLogger(MagnifyPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setBackground(new java.awt.Color(51, 204, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseDragged
    {//GEN-HEADEREND:event_formMouseDragged
        pt = evt.getPoint();
        javax.swing.SwingUtilities.convertPointToScreen(pt, this);

        re.width = getWidth();
        re.height = getHeight();
        re.x = pt.x - re.width;
        re.y = pt.y - re.height;

        img = robot.createScreenCapture(re);
        repaint();
    }//GEN-LAST:event_formMouseDragged

    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public boolean toClipboard()
    {
        if (img == null)
        {
            return false;
        }
        new ClipboardImage(img);
        return true;
    }

    public boolean tweet()
    {
        if (img == null)
        {
            return false;
        }
        TwitTools.get().sendAsync(img, TOOL_TIP_TEXT_KEY);
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
