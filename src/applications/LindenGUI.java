/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
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
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        North = new JPanel();
        jButton3 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jLabel3 = new JLabel();
        penSize = new JTextField();
        jLabel4 = new JLabel();
        penPosX = new JTextField();
        penPosY = new JTextField();
        jLabel5 = new JLabel();
        lineLength = new JTextField();
        jLabel2 = new JLabel();
        recursions = new JTextField();
        axiom = new JTextField();
        jLabel6 = new JLabel();
        angle = new JTextField();
        jLabel7 = new JLabel();
        sizeY = new JTextField();
        sizeX = new JTextField();
        South = new JPanel();
        jButton1 = new JButton();
        jButton4 = new JButton();
        saveName = new JTextField();
        jButton7 = new JButton();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        rulePanelContainer = new JPanel();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lindenmayer");
        setDoubleBuffered(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== North ========
        {

            // JFormDesigner evaluation mark
            North.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), North.getBorder())); North.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            North.setLayout(null);

            //---- jButton3 ----
            jButton3.setText("Add Rule");
            jButton3.addActionListener(e -> jButton3ActionPerformed(e));
            North.add(jButton3);
            jButton3.setBounds(new Rectangle(new Point(158, 71), jButton3.getPreferredSize()));

            //---- jLabel1 ----
            jLabel1.setText("Axiom");
            North.add(jLabel1);
            jLabel1.setBounds(new Rectangle(new Point(111, 45), jLabel1.getPreferredSize()));

            //---- jButton2 ----
            jButton2.setText("Final Rule");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));
            North.add(jButton2);
            jButton2.setBounds(new Rectangle(new Point(250, 71), jButton2.getPreferredSize()));

            //---- jLabel3 ----
            jLabel3.setText("PenSize");
            North.add(jLabel3);
            jLabel3.setBounds(new Rectangle(new Point(12, 16), jLabel3.getPreferredSize()));

            //---- penSize ----
            penSize.setText("0");
            North.add(penSize);
            penSize.setBounds(62, 13, 31, penSize.getPreferredSize().height);

            //---- jLabel4 ----
            jLabel4.setText("PenPos");
            North.add(jLabel4);
            jLabel4.setBounds(new Rectangle(new Point(158, 16), jLabel4.getPreferredSize()));

            //---- penPosX ----
            penPosX.setText("506");
            North.add(penPosX);
            penPosX.setBounds(204, 13, 39, penPosX.getPreferredSize().height);

            //---- penPosY ----
            penPosY.setText("254");
            North.add(penPosY);
            penPosY.setBounds(261, 13, 38, penPosY.getPreferredSize().height);

            //---- jLabel5 ----
            jLabel5.setText("LineLength");
            North.add(jLabel5);
            jLabel5.setBounds(new Rectangle(new Point(304, 16), jLabel5.getPreferredSize()));

            //---- lineLength ----
            lineLength.setText("2.0");
            North.add(lineLength);
            lineLength.setBounds(370, 13, 39, lineLength.getPreferredSize().height);

            //---- jLabel2 ----
            jLabel2.setText("Recursions");
            North.add(jLabel2);
            jLabel2.setBounds(new Rectangle(new Point(414, 16), jLabel2.getPreferredSize()));

            //---- recursions ----
            recursions.setText("6");
            North.add(recursions);
            recursions.setBounds(481, 13, 26, recursions.getPreferredSize().height);

            //---- axiom ----
            axiom.setText("F+XF+F+XF");
            North.add(axiom);
            axiom.setBounds(158, 42, 186, axiom.getPreferredSize().height);

            //---- jLabel6 ----
            jLabel6.setText("Angle");
            North.add(jLabel6);
            jLabel6.setBounds(new Rectangle(new Point(12, 45), jLabel6.getPreferredSize()));

            //---- angle ----
            angle.setText("90.0");
            North.add(angle);
            angle.setBounds(49, 42, 43, angle.getPreferredSize().height);

            //---- jLabel7 ----
            jLabel7.setText("Imagesize");
            North.add(jLabel7);
            jLabel7.setBounds(new Rectangle(new Point(356, 45), jLabel7.getPreferredSize()));

            //---- sizeY ----
            sizeY.setText("600");
            North.add(sizeY);
            sizeY.setBounds(419, 42, 37, sizeY.getPreferredSize().height);

            //---- sizeX ----
            sizeX.setText("600");
            North.add(sizeX);
            sizeX.setBounds(463, 42, 37, sizeX.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < North.getComponentCount(); i++) {
                    Rectangle bounds = North.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = North.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                North.setMinimumSize(preferredSize);
                North.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(North, BorderLayout.NORTH);

        //======== South ========
        {
            South.setLayout(null);

            //---- jButton1 ----
            jButton1.setText("Render");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));
            South.add(jButton1);
            jButton1.setBounds(new Rectangle(new Point(12, 32), jButton1.getPreferredSize()));

            //---- jButton4 ----
            jButton4.setText("Tweet");
            jButton4.addActionListener(e -> jButton4ActionPerformed(e));
            South.add(jButton4);
            jButton4.setBounds(new Rectangle(new Point(99, 32), jButton4.getPreferredSize()));

            //---- saveName ----
            saveName.setText("LindeSave");
            South.add(saveName);
            saveName.setBounds(330, 30, 192, saveName.getPreferredSize().height);

            //---- jButton7 ----
            jButton7.setText("Save as -->");
            jButton7.addActionListener(e -> jButton7ActionPerformed(e));
            South.add(jButton7);
            jButton7.setBounds(210, 30, 115, jButton7.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < South.getComponentCount(); i++) {
                    Rectangle bounds = South.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = South.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                South.setMinimumSize(preferredSize);
                South.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(South, BorderLayout.SOUTH);

        //======== jPanel1 ========
        {
            jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));

            //======== jScrollPane1 ========
            {

                //======== rulePanelContainer ========
                {
                    rulePanelContainer.setLayout(new BoxLayout(rulePanelContainer, BoxLayout.Y_AXIS));
                }
                jScrollPane1.setViewportView(rulePanelContainer);
            }
            jPanel1.add(jScrollPane1);
        }
        contentPane.add(jPanel1, BorderLayout.CENTER);
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
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel North;
    private JButton jButton3;
    private JLabel jLabel1;
    private JButton jButton2;
    private JLabel jLabel3;
    private JTextField penSize;
    private JLabel jLabel4;
    private JTextField penPosX;
    private JTextField penPosY;
    private JLabel jLabel5;
    private JTextField lineLength;
    private JLabel jLabel2;
    private JTextField recursions;
    private JTextField axiom;
    private JLabel jLabel6;
    private JTextField angle;
    private JLabel jLabel7;
    private JTextField sizeY;
    private JTextField sizeX;
    private JPanel South;
    private JButton jButton1;
    private JButton jButton4;
    private JTextField saveName;
    private JButton jButton7;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JPanel rulePanelContainer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        // Nothing to do here
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {

    }
}
