/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.event.ActionListener;
import java.io.Serializable;
import misc.MainWindow;
import misc.PittiFrame;
import misc.Tools;

/**
 *
 * @author Administrator
 */
public class C64TextGUI extends PittiFrame implements Serializable, ActionListener
{
    public static final long serialVersionUID = 1L;

    /**
     * Initializer
     */
    {
        initComponents();
    }
    
    /**
     * Creates new form C64TextGUI
     */
    public C64TextGUI()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        saveName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("C64Font");
        setMinimumSize(new java.awt.Dimension(550, 38));
        setVisible(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(491, 50));
        jPanel1.setLayout(null);

        jButton1.setText("Render");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 75, 30);

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Save as -->");
        jButton7.addActionListener(this);
        jPanel1.add(jButton7);
        jButton7.setBounds(200, 10, 120, 25);

        saveName.setText("C64Text");
        jPanel1.add(saveName);
        saveName.setBounds(330, 10, 160, 22);

        jButton2.setText("To Clip");
        jPanel1.add(jButton2);
        jButton2.setBounds(90, 10, 90, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == jButton1)
        {
            C64TextGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7)
        {
            C64TextGUI.this.jButton7ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Render Button
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        try
        {
            Tools.serialize(saveName.getText(), this);
            MainWindow.instance.initSavesMenu();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField saveName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        // Nix
    }
}
