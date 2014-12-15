/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import com.basic.CommandInterpreter;
import com.basic.streameditor.StreamingTextArea;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameListener;
import misc.MainWindow;
import misc.PittiFrame;
import misc.Tools;

/**
 *
 * @author Administrator
 */
public class BasicGUI extends PittiFrame implements Runnable, ActionListener, InternalFrameListener
{
    transient private Thread thread;
    CommandInterpreter ci;
    
    {
        initComponents();
    }
    
    /**
     * Creates new form NewJInternalFrame
     */
    public BasicGUI()
    {
        thread = new Thread(this);
        thread.start();
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        saveName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new StreamingTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BASIC");
        setVisible(true);
        addInternalFrameListener(this);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("CLS");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 0));
        jButton9.setText("Save as -->");
        jButton9.addActionListener(this);
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 120, -1));

        saveName.setText("BASIC");
        jPanel1.add(saveName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 160, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        area.setColumns(20);
        area.setLineWrap(true);
        area.setRows(20);
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == jButton1)
        {
            BasicGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton9)
        {
            BasicGUI.this.jButton9ActionPerformed(evt);
        }
    }

    public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
    {
        if (evt.getSource() == BasicGUI.this)
        {
            BasicGUI.this.formInternalFrameClosed(evt);
        }
    }

    public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt)
    {
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Window closed
     * @param evt 
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameClosed
    {//GEN-HEADEREND:event_formInternalFrameClosed
        StreamingTextArea st = (StreamingTextArea)area;
        st.fakeIn("bye\n");
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        area.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton9ActionPerformed
    {//GEN-HEADEREND:event_jButton9ActionPerformed
        try
        {
            Tools.serialize(saveName.getText(), this);
            MainWindow.instance.initSavesMenu();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saveName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        StreamingTextArea st = (StreamingTextArea)area;
        st.startThread();
        thread = new Thread(this);
        thread.start();
    }

    private void basic()
    {
        if (ci == null)
        {
            StreamingTextArea st = (StreamingTextArea)area;
            ci = new CommandInterpreter(st);
        }
        try
        {
            ci.start();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    @Override
    public void run()
    {
        System.out.println ("BasicThread start");
        basic();
//        while (running)
//        {
//            area.append("lala");
//        }
        System.out.println ("BasicThread end");
    }
}