/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class MDIChild extends javax.swing.JInternalFrame
{
    Quran m_quran;
    VerbalQuran m_speaker;

    class Verse
    {
        public int sura;
        public int aya;
    }

    private Verse getSelectedVerse() throws Exception
    {
        Verse v = new Verse();
        v.sura = Integer.parseInt(tf_sura.getText());
        v.aya = Integer.parseInt(tf_aya.getText());
        return v;
    }

    /**
     * Creates new form NewJInternalFrame
     */
    public MDIChild() throws IOException
    {
        //super();
        //setSize(100, 100);
        initComponents();
        m_quran = new ZippedQuran(0);
        m_speaker = new ZippedVerbalQuran("c:\\quran\\000_versebyverse-1");
        combobox.setModel(new javax.swing.DefaultComboBoxModel(m_quran.getFileNames()));
        showText();
    }

    private String loadText() throws Exception
    {
        Verse v = getSelectedVerse();
        return m_quran.getAya(v.sura, v.aya);
    }

    private void showText()
    {
        try
        {
            String t = loadText();
            t = "<html>" + t + "</html>";
            outText.setText(t);
        }
        catch (Exception e)
        {
            outText.setText("Sura/Aya not found");
        }
    }

    private void speakText()
    {
        try
        {
            Verse v = getSelectedVerse();
            m_speaker.playAsync(v.sura, v.aya);
        }
        catch (Exception e)
        {
        }
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
        jLabel1 = new javax.swing.JLabel();
        tf_sura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_aya = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        upButton1 = new javax.swing.JButton();
        downButton1 = new javax.swing.JButton();
        outText = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 60));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setText("Sura");

        tf_sura.setText("1");
        tf_sura.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                tf_suraKeyReleased(evt);
            }
        });

        jLabel2.setText("Aya");

        tf_aya.setText("1");
        tf_aya.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                tf_ayaKeyReleased(evt);
            }
        });

        jLabel3.setText("Quran");

        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combobox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                comboboxActionPerformed(evt);
            }
        });

        jButton1.setText("Recite");
        jButton1.setToolTipText("");
        jButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        upButton.setText("+");
        upButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        upButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText("-");
        downButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        downButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                downButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Tweet");
        jButton2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Copy");
        jButton3.setToolTipText("");
        jButton3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        upButton1.setText("+");
        upButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        upButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                upButton1ActionPerformed(evt);
            }
        });

        downButton1.setText("-");
        downButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        downButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                downButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(tf_aya, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(tf_sura, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(upButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_sura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(downButton1)
                    .addComponent(upButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_aya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downButton)
                    .addComponent(jButton3)
                    .addComponent(upButton))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        outText.setBackground(new java.awt.Color(0, 0, 0));
        outText.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        outText.setForeground(new java.awt.Color(255, 255, 255));
        outText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        outText.setAutoscrolls(true);
        outText.setDoubleBuffered(true);
        outText.setOpaque(true);
        getContentPane().add(outText, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comboboxActionPerformed
    {//GEN-HEADEREND:event_comboboxActionPerformed
        String item = (String) combobox.getSelectedItem();
        try
        {
            m_quran = new Quran(item);
        }
        catch (IOException ex)
        {
            return;
        }
        showText();
    }//GEN-LAST:event_comboboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        speakText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_suraKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_tf_suraKeyReleased
    {//GEN-HEADEREND:event_tf_suraKeyReleased
        showText();
    }//GEN-LAST:event_tf_suraKeyReleased

    private void tf_ayaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_tf_ayaKeyReleased
    {//GEN-HEADEREND:event_tf_ayaKeyReleased
        showText();
    }//GEN-LAST:event_tf_ayaKeyReleased

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_upButtonActionPerformed
    {//GEN-HEADEREND:event_upButtonActionPerformed
        Verse v;
        try
        {
            v = getSelectedVerse();
        }
        catch (Exception ex)
        {
            return;
        }
        tf_aya.setText("" + (v.aya + 1));
        showText();
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_downButtonActionPerformed
    {//GEN-HEADEREND:event_downButtonActionPerformed
        Verse v;
        try
        {
            v = getSelectedVerse();
        }
        catch (Exception ex)
        {
            return;
        }
        if (v.aya != 1)
        {
            v.aya--;
        }
        tf_aya.setText("" + v.aya);
        showText();
    }//GEN-LAST:event_downButtonActionPerformed

    // Twitter button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {
            Verse v = getSelectedVerse();
            String t = loadText() + " #Quran " + v.sura + ":" + v.aya;
            TwitTools tw = TwitTools.get();
            StringDivider sd = new StringDivider(t, 120);
            String[] div = sd.divideWords();
            //DebugTools.printStringArray (div);
            tw.sendStringArray(div);
        }
        catch (Exception ex)
        {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        try
        {
            Verse v = getSelectedVerse();
            String t = loadText() + " #Quran " + v.sura + ":" + v.aya;
            StringSelection selection = new StringSelection(t);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
        catch (Exception ex)
        {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void upButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_upButton1ActionPerformed
    {//GEN-HEADEREND:event_upButton1ActionPerformed
        Verse v;
        try
        {
            v = getSelectedVerse();
        }
        catch (Exception ex)
        {
            return;
        }
        tf_sura.setText("" + (v.sura + 1));
        showText();
    }//GEN-LAST:event_upButton1ActionPerformed

    private void downButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_downButton1ActionPerformed
    {//GEN-HEADEREND:event_downButton1ActionPerformed
        Verse v;
        try
        {
            v = getSelectedVerse();
        }
        catch (Exception ex)
        {
            return;
        }
        if (v.sura != 1)
        {
            v.sura--;
        }
        tf_sura.setText("" + v.sura);
        showText();
    }//GEN-LAST:event_downButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combobox;
    private javax.swing.JButton downButton;
    private javax.swing.JButton downButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel outText;
    private javax.swing.JTextField tf_aya;
    private javax.swing.JTextField tf_sura;
    private javax.swing.JButton upButton;
    private javax.swing.JButton upButton1;
    // End of variables declaration//GEN-END:variables
}
