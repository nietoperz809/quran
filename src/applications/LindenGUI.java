/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import misc.MainWindow;
import misc.MDIChild;
import misc.Tools;
import turtle.RulePanel;
import turtle.Turtle;
import turtle.TurtleWindow;
import twitter.TwitTools;

/**
 *
 * @author Administrator
 */
public class LindenGUI extends MDIChild implements ActionListener
{
    private transient TurtleWindow bitmapView = null;
    
    // Instance initializer
    {
        initComponents();
    }

    /**
     * Creates new form LindenGUI
     */
    public LindenGUI()
    {

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

        North = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        penSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        penPosX = new javax.swing.JTextField();
        penPosY = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lineLength = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        recursions = new javax.swing.JTextField();
        axiom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        angle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sizeY = new javax.swing.JTextField();
        sizeX = new javax.swing.JTextField();
        South = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        saveName = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rulePanelContainer = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lindenmayer");
        setDoubleBuffered(true);
        setMaximumSize(new java.awt.Dimension(32000, 32000));
        setMinimumSize(new java.awt.Dimension(100, 38));
        setPreferredSize(new java.awt.Dimension(600, 300));
        setVisible(true);

        North.setBackground(new java.awt.Color(153, 255, 255));
        North.setMinimumSize(new java.awt.Dimension(100, 100));
        North.setPreferredSize(new java.awt.Dimension(591, 100));
        North.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Add Rule");
        jButton3.addActionListener(this);
        North.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 71, -1, -1));

        jLabel1.setText("Axiom");
        North.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 45, -1, -1));

        jButton2.setText("Final Rule");
        jButton2.addActionListener(this);
        North.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 71, -1, -1));

        jLabel3.setText("PenSize");
        North.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        penSize.setText("0");
        North.add(penSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 13, 31, -1));

        jLabel4.setText("PenPos");
        North.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 16, -1, -1));

        penPosX.setText("506");
        North.add(penPosX, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 13, 39, -1));

        penPosY.setText("254");
        North.add(penPosY, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 13, 38, -1));

        jLabel5.setText("LineLength");
        North.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 16, -1, -1));

        lineLength.setText("2.0");
        North.add(lineLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 13, 39, -1));

        jLabel2.setText("Recursions");
        North.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 16, -1, -1));

        recursions.setText("6");
        North.add(recursions, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 13, 26, -1));

        axiom.setText("F+XF+F+XF");
        North.add(axiom, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 42, 186, -1));

        jLabel6.setText("Angle");
        North.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, -1, -1));

        angle.setText("90.0");
        North.add(angle, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 42, 43, -1));

        jLabel7.setText("Imagesize");
        North.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 45, -1, -1));

        sizeY.setText("600");
        North.add(sizeY, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 42, 37, -1));

        sizeX.setText("600");
        North.add(sizeX, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 42, 37, -1));

        getContentPane().add(North, java.awt.BorderLayout.NORTH);

        South.setBackground(new java.awt.Color(255, 153, 153));
        South.setMinimumSize(new java.awt.Dimension(100, 50));
        South.setPreferredSize(new java.awt.Dimension(591, 70));
        South.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Render");
        jButton1.addActionListener(this);
        South.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, -1, -1));

        jButton4.setText("Tweet");
        jButton4.addActionListener(this);
        South.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 32, -1, -1));

        saveName.setText("LindeSave");
        South.add(saveName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 192, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Save as -->");
        jButton7.addActionListener(this);
        South.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 115, -1));

        getContentPane().add(South, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        rulePanelContainer.setLayout(new javax.swing.BoxLayout(rulePanelContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(rulePanelContainer);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == jButton3)
        {
            LindenGUI.this.jButton3ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2)
        {
            LindenGUI.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton1)
        {
            LindenGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton4)
        {
            LindenGUI.this.jButton4ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7)
        {
            LindenGUI.this.jButton7ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Refresh UI after Rule added/removed
     */
    private void refreshUI()
    {
        invalidate();
        repaint();
        revalidate();  // Repaint
    }

    private void createView()
    {
        if (bitmapView == null)
        {
            bitmapView = new TurtleWindow(
                    Tools.readInt(sizeX, 500),
                    Tools.readInt(sizeY, 500)
            );
            MainWindow.getInstance().addChild(bitmapView);
        }
    }

    /**
     * RemoveView
     */
    private void removeView()
    {
        if (bitmapView != null)
        {
            MainWindow.getInstance().remove(bitmapView);
            bitmapView.dispose();
            bitmapView = null;
        }
    }

    /**
     * Remove Rule
     *
     * @param com
     */
    public void remove(RulePanel com)
    {
        rulePanelContainer.remove(com);
        refreshUI();
    }

    /**
     * Add rule
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        rulePanelContainer.add(new RulePanel(this, false));
        refreshUI();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Add final rule
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        rulePanelContainer.add(new RulePanel(this, true));
        refreshUI();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Draws Lindenmayer system
     *
     * @param t
     * @throws Exception
     */
    void buildLindeFromControls(Turtle t) throws Exception
    {
        t.CmdSetPenSize(Tools.readInt(penSize, 0));
        t.CmdSetPenPositionAbsolute(
                Tools.readInt(penPosX, 506),
                Tools.readInt(penPosY, 254));
        t.CmdSetLindeLineLength(Tools.readDouble(lineLength, 2.0));
        t.CmdSetLindeRecursionNumber(Tools.readInt(recursions, 6));
        t.CmdSetLindeAngle(Tools.readDouble(angle, 90.0));
        t.CmdSetLindeAxiom(axiom.getText());
        //t.CmdSetLindeRule("X->XF-F+F-XF+F+XF-F+F-X");

        // Process the Rules
        Component[] comps = rulePanelContainer.getComponents();
        for (Component c : comps)
        {
            RulePanel rp = (RulePanel) c;
            String rule = rp.getRule();
            double prob = rp.getProbability();

            t.CmdSetLindeRule(rule, prob);
        }

        t.CmdLindeDraw();
        t.execute(t.getGraphics());
    }

    /**
     * Render button clicked
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        removeView();
        createView();

        Turtle t = bitmapView.getTurtle();
        try
        {
            buildLindeFromControls(t);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Tweet button
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        if (bitmapView == null)
        {
            return;
        }

        BufferedImage img = bitmapView.getTurtle().getImage();
        try
        {
            TwitTools.get().send(img, "LindenTest");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /** 
     * Save "this"
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        try
        {
            Tools.serialize(saveName.getText(), this);
            MainWindow.getInstance().initSavesMenu();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel North;
    private javax.swing.JPanel South;
    private javax.swing.JTextField angle;
    private javax.swing.JTextField axiom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lineLength;
    private javax.swing.JTextField penPosX;
    private javax.swing.JTextField penPosY;
    private javax.swing.JTextField penSize;
    private javax.swing.JTextField recursions;
    private javax.swing.JPanel rulePanelContainer;
    private javax.swing.JTextField saveName;
    private javax.swing.JTextField sizeX;
    private javax.swing.JTextField sizeY;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        // Nothing to do here
    }
}
