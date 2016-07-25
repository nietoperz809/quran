/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import numconv.ConvertNumber;
import twitter.TwitTools;

/**
 *
 * @author Administrator
 */
public class NumberConverter extends javax.swing.JInternalFrame
{
    /**
     * Creates new form NumberConverter
     */
    public NumberConverter()
    {
        initComponents();
    }

    private String doConversion() throws Exception
    {
        String from = tfIn.getText();
        int baseFrom = Integer.parseInt(tfFrom.getText());
        int baseTo = Integer.parseInt(tfTo.getText());
        return  ConvertNumber.convNumber(from, baseFrom, baseTo);
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
        tfIn = new JTextField();
        labOut = new JLabel();
        jButton1 = new JButton();
        tfFrom = new JTextField();
        tfTo = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton2 = new JButton();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //---- tfIn ----
        tfIn.setToolTipText("input");

        //---- labOut ----
        labOut.setText("  ");
        labOut.setOpaque(true);

        //---- jButton1 ----
        jButton1.setText("Just do it");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        //---- tfFrom ----
        tfFrom.setText("10");

        //---- tfTo ----
        tfTo.setText("16");
        tfTo.addActionListener(e -> tfToActionPerformed(e));

        //---- jLabel2 ----
        jLabel2.setText("from base");

        //---- jLabel3 ----
        jLabel3.setText("to base");

        //---- jButton2 ----
        jButton2.setText("Tweet");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(tfIn)
                                .addComponent(labOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfFrom, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                            .addComponent(jButton2)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tfIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jButton2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                    .addComponent(labOut)
                    .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
        {
            labOut.setText(doConversion());
        }
        catch (Exception ex)
        {
            System.out.println("oops" + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfToActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfToActionPerformed
    {//GEN-HEADEREND:event_tfToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfToActionPerformed
    
    // tweet button pressed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {
            StringBuilder sb = new StringBuilder();
            sb.append (tfIn.getText());
            sb.append (" in base ").append(tfFrom.getText());
            sb.append (" is ").append(doConversion());
            sb.append (" in base ").append(tfTo.getText());
            System.out.println(sb.toString());
            TwitTools.get().sendAsync(sb.toString());
        }
        catch (Exception ex)
        {
            System.out.println("oops" + ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField tfIn;
    private JLabel labOut;
    private JButton jButton1;
    private JTextField tfFrom;
    private JTextField tfTo;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JButton jButton2;
    // End of variables declaration//GEN-END:variables
}