/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import com.basic.CommandInterpreter;
import com.basic.streameditor.StreamingTextArea;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameListener;
import misc.MainWindow;
import misc.MDIChild;
import misc.Tools;

/**
 *
 * @author Administrator
 */
public class BasicGUI extends MDIChild implements Runnable, ActionListener, InternalFrameListener
{
    transient private Thread thread;
    private CommandInterpreter ci;

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

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        saveName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
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

        jButton2.setText("Stop");
        jButton2.addActionListener(this);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        area.setBackground(new java.awt.Color(0, 0, 153));
        area.setColumns(20);
        area.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18)); // NOI18N
        area.setForeground(new java.awt.Color(255, 255, 102));
        area.setLineWrap(true);
        area.setRows(20);
        area.setCaretColor(new java.awt.Color(255, 102, 102));
        area.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        else if (evt.getSource() == jButton2)
        {
            BasicGUI.this.jButton2ActionPerformed(evt);
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
     *
     * @param evt
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameClosed
    {//GEN-HEADEREND:event_formInternalFrameClosed
        ci.basicProgram.thread_running = false;  // Force thread to end if pg runs
        StreamingTextArea st = (StreamingTextArea) area;
        st.fakeIn("bye\n");  // Force thread to end if no pg runs
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
            MainWindow.getInstance().initSavesMenu();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        ci.basicProgram.basic_prg_running = false;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField saveName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        StreamingTextArea st = (StreamingTextArea) area;
        st.startThread();
        thread = new Thread(this);
        thread.start();
    }

    /**
     * runs the command line interpreter
     * @return 1 if GUI closed. otherwise 0
     */
    private int runBasicSystem ()
    {
        if (ci == null)
        {
            ci = new CommandInterpreter (this);
        }
        try
        {
            StreamingTextArea st = (StreamingTextArea) area;
            return ci.start(st);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println("BasicThread start");
        int ret = runBasicSystem();
        if (ret == 1)
        {
            ci.dispose();
            dispose();
        }
        System.out.println("BasicThread end");
    }
}
