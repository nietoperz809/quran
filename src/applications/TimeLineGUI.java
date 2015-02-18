/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.util.List;
import twitter.TwitTools;
import twitter4j.Status;

/**
 *
 * @author Administrator
 */
public class TimeLineGUI extends javax.swing.JInternalFrame
{

    /**
     * Creates new form TimeLineGUI
     */
    public TimeLineGUI()
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

        view = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        view.setBackground(new java.awt.Color(0, 0, 0));
        view.setForeground(new java.awt.Color(255, 255, 102));
        view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        view.setText("jLabel1");
        view.setMaximumSize(new java.awt.Dimension(1000, 1000));
        view.setOpaque(true);
        view.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(view, java.awt.BorderLayout.CENTER);

        jButton1.setText("Fetch");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Clicked Fetch Button
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        List<Status> l = TwitTools.getTimeLine();
        StringBuilder sb = new StringBuilder();
        for (Status status : l)
        {
            sb.append("<b>");
            sb.append(status.getUser().getName());
            sb.append("</b>:");
            sb.append(status.getText());
            sb.append("<br><br>");
        }
        print (sb.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void print (String s)
    {
        view.setText ("<html>"+s+"<br></html>");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
}
