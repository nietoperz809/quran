/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import javax.swing.*;
import javax.swing.event.*;
import com.basic.CommandInterpreter;
import com.basic.streameditor.StreamingTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;
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
    //transient private Thread basicThread;
    Future basicTask;
    private CommandInterpreter commandInterpreter;
    transient public static final
        ConcurrentHashMap<Long, CountDownLatch> latchMap = new ConcurrentHashMap<>();

    public static final ExecutorService executor = Executors.newFixedThreadPool(10);

    {
        initComponents();
    }

    /**
     * Creates new form NewJInternalFrame
     */
    public BasicGUI()
    {
        basicTask = executor.submit(this);
        //basicThread = new Thread(this);
        //basicThread.start();
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
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton9 = new JButton();
        saveName = new JTextField();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        area = new StreamingTextArea();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BASIC");
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                formInternalFrameClosed(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jPanel1 ========
        {

            // JFormDesigner evaluation mark
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            jPanel1.setLayout(null);

            //---- jButton1 ----
            jButton1.setText("CLS");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));
            jPanel1.add(jButton1);
            jButton1.setBounds(new Rectangle(new Point(0, 0), jButton1.getPreferredSize()));

            //---- jButton9 ----
            jButton9.setText("Save as -->");
            jButton9.addActionListener(e -> jButton9ActionPerformed(e));
            jPanel1.add(jButton9);
            jButton9.setBounds(310, 0, 120, jButton9.getPreferredSize().height);

            //---- saveName ----
            saveName.setText("BASIC");
            jPanel1.add(saveName);
            saveName.setBounds(430, 0, 160, saveName.getPreferredSize().height);

            //---- jButton2 ----
            jButton2.setText("Stop");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));
            jPanel1.add(jButton2);
            jButton2.setBounds(new Rectangle(new Point(70, 0), jButton2.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jPanel1.getComponentCount(); i++) {
                    Rectangle bounds = jPanel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jPanel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jPanel1.setMinimumSize(preferredSize);
                jPanel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(jPanel1, BorderLayout.SOUTH);

        //======== jScrollPane1 ========
        {

            //---- area ----
            area.setColumns(20);
            area.setLineWrap(true);
            area.setRows(20);
            area.setCaretColor(new Color(255, 102, 102));
            jScrollPane1.setViewportView(area);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Window closed
     *
     * @param evt
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameClosed
    {//GEN-HEADEREND:event_formInternalFrameClosed
        commandInterpreter.basicProgram.thread_running = false;  // Force basicThread to end if pg runs
        StreamingTextArea st = (StreamingTextArea) area;
        st.fakeIn("bye\n");  // Force basicThread to end if no pg runs
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
        // end possible wait state
        basicTask.cancel(true);
        commandInterpreter.basicProgram.basic_prg_running = false;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton9;
    private JTextField saveName;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private JTextArea area;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        StreamingTextArea st = (StreamingTextArea) area;
        st.startThread();
        //basicThread = new Thread(this);
        //basicThread.start();
        basicTask = executor.submit(this);
    }

    /**
     * runs the command line interpreter
     * @return 1 if GUI closed. otherwise 0
     */
    private int runBasicSystem ()
    {
        if (commandInterpreter == null)
        {
            commandInterpreter = new CommandInterpreter (this);
        }
        try
        {
            StreamingTextArea st = (StreamingTextArea) area;
            return commandInterpreter.start(st);
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
            commandInterpreter.dispose();
            dispose();
        }
        System.out.println("BasicThread end");
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {

    }

    @Override
    public void internalFrameOpened (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameClosing (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameClosed (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameIconified (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameDeiconified (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameActivated (InternalFrameEvent e)
    {

    }

    @Override
    public void internalFrameDeactivated (InternalFrameEvent e)
    {

    }
}
