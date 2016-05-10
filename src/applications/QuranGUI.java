/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.event.InternalFrameListener;
import misc.ComboBoxTools;
import misc.HashmapSeeker;
import misc.MDIChild;
import misc.Tools;
import quran.*;
import twitter.TwitTools;

/**
 *
 * @author Administrator
 */
public class QuranGUI extends MDIChild implements ActionListener, KeyListener, InternalFrameListener
{
    transient private Quran m_quran;
    transient private VerbalQuran m_speaker;
    private final ArrayList<SeekResultGui> seekResults = new ArrayList<>();

    @Override
    public void initAfterDeserialization()
    {
        m_quran = new Quran(0);
        m_speaker = new VerbalQuran();
    }

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

    // Initializer
    
    {
        m_quran = new Quran(0);
        m_speaker = new VerbalQuran();
        initComponents();
        fillCB();
        showText();
    }

    /**
     * fills combobox with quran instances
     */
    private void fillCB()
    {
        ComboBoxTools.pollute(combobox, m_quran.getFileNames());
    }

    /**
     * Creates new form NewJInternalFrame
     *
     * @throws java.io.IOException
     */
    public QuranGUI() throws IOException
    {
        ComboBoxTools.pollute(combobox, m_quran.getFileNames());
    }

    private String getSuraHeader(int sura)
    {
        try
        {
            QuranMetadata dat = QuranMetadata.get();
            if (sura == - 1)
            {
                sura = getSelectedVerse().sura;
            }
            QuranMetadata.SuraInfo info = dat.getSuraInfo(sura);
            return "I:" + info.index + "|O:" + info.order + "|" + "S:" + info.ayas + "|"
                    + info.ename + "|" + info.name + "|" + info.tname + "|" + info.type;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    private String loadText() throws Exception
    {
        Verse v = getSelectedVerse();
        infoText.setText(getSuraHeader(v.sura));
        return m_quran.getAya(v.sura, v.aya);
    }

    public void display(String sa)
    {
        String[] sp0 = sa.split(Pattern.quote(": "));
        //System.out.println(sp0[0]);  // sp0[0] ist quran file name
        m_quran = new Quran(sp0[0]);
        String[] sp = sp0[1].split(Pattern.quote("|"));
        int s = Integer.parseInt(sp[0]);
        int a = Integer.parseInt(sp[1]);
        setSelectedVerse(s, a);
        showText();
    }

    private void setSelectedVerse(int sura, int aya)
    {
        tf_sura.setText("" + sura);
        tf_aya.setText("" + aya);
        cpFromTo.setText (""+aya+"/"+aya);
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
        infoText = new javax.swing.JTextField();
        seekText = new javax.swing.JTextField();
        seekButton = new javax.swing.JButton();
        cpFromTo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outText = new javax.swing.JTextPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setVisible(true);
        addInternalFrameListener(this);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Sura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, -1, -1));

        tf_sura.setText("1");
        tf_sura.addKeyListener(this);
        jPanel1.add(tf_sura, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 1, 60, -1));

        jLabel2.setText("Aya");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, -1, -1));

        tf_aya.setText("1");
        tf_aya.addKeyListener(this);
        jPanel1.add(tf_aya, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 32, 60, -1));

        jLabel3.setText("Quran");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combobox.addActionListener(this);
        jPanel1.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 132, -1));

        jButton1.setText("Recite");
        jButton1.setToolTipText("");
        jButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton1.addActionListener(this);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 70, -1));

        upButton.setText("+");
        upButton.addActionListener(this);
        jPanel1.add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 32, 40, -1));

        downButton.setText("-");
        downButton.addActionListener(this);
        jPanel1.add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 32, 40, -1));

        jButton2.setText("Tweet");
        jButton2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton2.addActionListener(this);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 70, -1));

        jButton3.setText("Copy");
        jButton3.setToolTipText("");
        jButton3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton3.addActionListener(this);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 56, -1));

        upButton1.setText("+");
        upButton1.addActionListener(this);
        jPanel1.add(upButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 0, 40, -1));

        downButton1.setText("-");
        downButton1.addActionListener(this);
        jPanel1.add(downButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 0, 40, -1));

        infoText.setEditable(false);
        infoText.setBackground(new java.awt.Color(102, 255, 204));
        infoText.setFont(new java.awt.Font("Arabic Typesetting", 1, 24)); // NOI18N
        infoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        infoText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(infoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 660, 37));
        jPanel1.add(seekText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 100, -1));

        seekButton.setText("Seek");
        seekButton.addActionListener(this);
        jPanel1.add(seekButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        cpFromTo.setText("1/1");
        cpFromTo.setToolTipText("Select Aya from/to for copy");
        jPanel1.add(cpFromTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 60, -1));

        jLabel4.setText("-->");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        outText.setBackground(new java.awt.Color(255, 255, 255));
        outText.setContentType("text/html"); // NOI18N
        outText.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(outText);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == combobox)
        {
            QuranGUI.this.comboboxActionPerformed(evt);
        }
        else if (evt.getSource() == jButton1)
        {
            QuranGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == upButton)
        {
            QuranGUI.this.upButtonActionPerformed(evt);
        }
        else if (evt.getSource() == downButton)
        {
            QuranGUI.this.downButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2)
        {
            QuranGUI.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton3)
        {
            QuranGUI.this.jButton3ActionPerformed(evt);
        }
        else if (evt.getSource() == upButton1)
        {
            QuranGUI.this.upButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == downButton1)
        {
            QuranGUI.this.downButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == seekButton)
        {
            QuranGUI.this.seekButtonActionPerformed(evt);
        }
    }

    public void keyPressed(java.awt.event.KeyEvent evt)
    {
    }

    public void keyReleased(java.awt.event.KeyEvent evt)
    {
        if (evt.getSource() == tf_sura)
        {
            QuranGUI.this.tf_suraKeyReleased(evt);
        }
        else if (evt.getSource() == tf_aya)
        {
            QuranGUI.this.tf_ayaKeyReleased(evt);
        }
    }

    public void keyTyped(java.awt.event.KeyEvent evt)
    {
    }

    public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
    {
    }

    public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
    {
        if (evt.getSource() == QuranGUI.this)
        {
            QuranGUI.this.formInternalFrameClosed(evt);
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

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_comboboxActionPerformed
    {//GEN-HEADEREND:event_comboboxActionPerformed
        m_quran = new Quran(combobox.getSelectedIndex());
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
        String s = tf_aya.getText();
        if (s.isEmpty())
            return;
        cpFromTo.setText (s+"/"+s);

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
        int next = v.aya+1;
        tf_aya.setText("" + next);
        cpFromTo.setText (""+next+"/"+next);
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
        cpFromTo.setText (""+v.aya+"/"+v.aya);
        showText();
    }//GEN-LAST:event_downButtonActionPerformed

    /**
     * Tweet the current verse
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {
            Verse v = getSelectedVerse();
            String t = loadText() + " #Quran " + v.sura + ":" + v.aya;
            TwitTools.sendLongString(t);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Put verse onto clipboard
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        try
        {
            String[] fromto = cpFromTo.getText().split("/");
            int sura = Integer.parseInt(tf_sura.getText());
            int astart = Integer.parseInt(fromto[0]);
            int aend = Integer.parseInt(fromto[1]);
            String s = m_quran.getAya(sura, astart, aend);
            s = s + " #Quran " + sura + ":" + astart;
            if (aend > astart)
                s = s + "-" + aend;
            Tools.toClipBoard(s);
            outText.setText("<html>" + s + "</html>");
        }
        catch (Exception ex)
        {
            System.err.println("Fail in cp to clipbrd:"+ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Next Sura
     *
     * @param evt
     */
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

    /**
     * Previous Sura
     *
     * @param evt
     */
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

    private void seekButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_seekButtonActionPerformed
    {//GEN-HEADEREND:event_seekButtonActionPerformed
        String text = seekText.getText();
        if (text.length() < 3)
        {
            return;
        }
        Runnable r = () ->
        {
            try
            {
                String[] res = Seeker.seekAllQurans(text);
                SeekResultGui sr = new SeekResultGui(this, text, res);
                seekResults.add(sr);
                this.getDesktopPane().add(sr);
                sr.moveToFront();
            }
            catch (Exception ex)
            {
                Logger.getLogger(TwitTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        Tools.submit(r);
    }//GEN-LAST:event_seekButtonActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt)//GEN-FIRST:event_formInternalFrameClosed
    {//GEN-HEADEREND:event_formInternalFrameClosed
        seekResults.stream().forEach((g) ->
        {
            g.dispose();
        });
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combobox;
    private javax.swing.JTextField cpFromTo;
    private javax.swing.JButton downButton;
    private javax.swing.JButton downButton1;
    private javax.swing.JTextField infoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane outText;
    private javax.swing.JButton seekButton;
    private javax.swing.JTextField seekText;
    private javax.swing.JTextField tf_aya;
    private javax.swing.JTextField tf_sura;
    private javax.swing.JButton upButton;
    private javax.swing.JButton upButton1;
    // End of variables declaration//GEN-END:variables
}
