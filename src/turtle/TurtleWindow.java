/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class TurtleWindow extends javax.swing.JInternalFrame
{
    private final DoubleBufferedTurtle turtle;

    /**
     * Creates new form LindenView
     * @param x
     * @param y
     */
    public TurtleWindow (int x, int y)
    {
        turtle = new DoubleBufferedTurtle (x, y);
        initComponents();
        add (turtle);
        add(turtle, BorderLayout.CENTER);
        this.setVisible(true);
        sizeChanged();
    }

    public void setBkColor (Color bk)
    {
        BufferedImage img = turtle.getImage();
        Graphics2D ig2 = img.createGraphics();
        ig2.setBackground(bk);
        ig2.clearRect(0, 0, img.getWidth(), img.getHeight());
    }

    public void sizeChanged()
    {
        BufferedImage bi = turtle.getResizedImage();
        this.setSize(bi.getWidth()+10,
                bi.getHeight()+30);
        this.revalidate();
        this.repaint();
    }

    /**
     * Get embedded Turtle
     * @return 
     */
    public DoubleBufferedTurtle getTurtle()
    {
        return turtle;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    // End of variables declaration//GEN-END:variables
}
