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
import misc.StringDivider;
import misc.Tools;
import twitter.TwitTools;

/**
 *
 * @author Administrator
 */
public class DirectTweetGUI extends PittiFrame implements Serializable, ActionListener
{
    public static final long serialVersionUID = 1L;

    /**
     * Initializer
     */
    {
        initComponents();
    }

    /**
     * Creates new form DirectTweet
     */
    public DirectTweetGUI()
    {
        initComponents();
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
        textArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        saveName = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("DirectTweet");
        setPreferredSize(new java.awt.Dimension(425, 412));
        setVisible(true);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(487, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Send");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 90, 40));

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Save as -->");
        jButton7.addActionListener(this);
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 115, -1));

        saveName.setText("DirectTweet");
        jPanel1.add(saveName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 192, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == jButton1)
        {
            DirectTweetGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7)
        {
            DirectTweetGUI.this.jButton7ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        String s = textArea.getText();
        StringDivider sd = new StringDivider(s, 120);
        String[] div = sd.splitByWords();
        TwitTools tw = TwitTools.get();
        try
        {
            tw.sendStringArray(div);
        }
        catch (Exception ex)
        {
           System.out.println (ex);
        }
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
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saveName;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        // Nothing to do
    }
}
