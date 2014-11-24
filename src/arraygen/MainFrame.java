/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraygen;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;


/**
 *
 * @author PetSel
 */
public class MainFrame extends JInternalFrame
{
    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        initComponents();
        setSize(800, 400);
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setOpaque(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup = new javax.swing.ButtonGroup();
        chooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        button = new javax.swing.JButton();
        rbC = new javax.swing.JRadioButton();
        rbJava = new javax.swing.JRadioButton();
        nameField = new javax.swing.JTextField();
        rbPHP = new javax.swing.JRadioButton();
        rbJava1 = new javax.swing.JRadioButton();

        setTitle("Pittis Array Generator");

        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setControlButtonsAreShown(false);
        chooser.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        chooser.setToolTipText("");
        chooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chooser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chooserActionPerformed(evt);
            }
        });

        textArea.setBackground(new java.awt.Color(153, 255, 255));
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        button.setText("Copy to clipboard ...");
        button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonActionPerformed(evt);
            }
        });

        buttonGroup.add(rbC);
        rbC.setText("C");
        rbC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbCActionPerformed(evt);
            }
        });

        buttonGroup.add(rbJava);
        rbJava.setText("Java");
        rbJava.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbJavaActionPerformed(evt);
            }
        });

        nameField.setText("myArray");
        nameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nameFieldActionPerformed(evt);
            }
        });

        buttonGroup.add(rbPHP);
        rbPHP.setText("PHP");
        rbPHP.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbPHPActionPerformed(evt);
            }
        });

        buttonGroup.add(rbJava1);
        rbJava1.setSelected(true);
        rbJava1.setText("Java func");
        rbJava1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbJava1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(button)
                .addGap(8, 8, 8)
                .addComponent(rbC)
                .addGap(4, 4, 4)
                .addComponent(rbJava)
                .addGap(4, 4, 4)
                .addComponent(rbJava1)
                .addGap(0, 0, 0)
                .addComponent(rbPHP)
                .addGap(18, 18, 18)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button)
                    .addComponent(rbC)
                    .addComponent(rbJava)
                    .addComponent(rbJava1)
                    .addComponent(rbPHP)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateText()
    {
        File f = chooser.getSelectedFile();
        if (f == null)
        {
            textArea.setText("Ooops?! No file selected");
            return;
        }    
        if (f.length() > 65536)
        {
            textArea.setText("Sorry, File too big");
            return;
        }
        try
        {
            String text = Arraygen.makeIt(nameField.getText(), f.getPath());
            textArea.setText(text);
        }
        catch (Exception ex)
        {
            System.err.println("No file");
        }
    }
        
    private void chooserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooserActionPerformed
    {//GEN-HEADEREND:event_chooserActionPerformed
        generateText();
    }//GEN-LAST:event_chooserActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonActionPerformed
    {//GEN-HEADEREND:event_buttonActionPerformed
        String s = textArea.getText();
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_buttonActionPerformed

    private void rbJavaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rbJavaActionPerformed
    {//GEN-HEADEREND:event_rbJavaActionPerformed
        Arraygen.setCode (Arraygen.CODE.JAVA);
        generateText();
    }//GEN-LAST:event_rbJavaActionPerformed

    private void rbCActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rbCActionPerformed
    {//GEN-HEADEREND:event_rbCActionPerformed
        Arraygen.setCode (Arraygen.CODE.C);
        generateText();
    }//GEN-LAST:event_rbCActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nameFieldActionPerformed
    {//GEN-HEADEREND:event_nameFieldActionPerformed
        generateText();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void rbPHPActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rbPHPActionPerformed
    {//GEN-HEADEREND:event_rbPHPActionPerformed
        Arraygen.setCode (Arraygen.CODE.PHP);
        generateText();
    }//GEN-LAST:event_rbPHPActionPerformed

    private void rbJava1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rbJava1ActionPerformed
    {//GEN-HEADEREND:event_rbJava1ActionPerformed
        Arraygen.setCode (Arraygen.CODE.JAVAFUNC);
        generateText();
    }//GEN-LAST:event_rbJava1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception
    {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //buttonGroup.add(rbC);
        //buttonGroup.add
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton rbC;
    private javax.swing.JRadioButton rbJava;
    private javax.swing.JRadioButton rbJava1;
    private javax.swing.JRadioButton rbPHP;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
