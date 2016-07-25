/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
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

    @Override
    public void keyTyped (KeyEvent e)
    {

    }

    @Override
    public void keyPressed (KeyEvent e)
    {

    }

    @Override
    public void keyReleased (KeyEvent e)
    {

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
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        tf_sura = new JTextField();
        jLabel2 = new JLabel();
        tf_aya = new JTextField();
        jLabel3 = new JLabel();
        combobox = new JComboBox<>();
        jButton1 = new JButton();
        upButton = new JButton();
        downButton = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        upButton1 = new JButton();
        downButton1 = new JButton();
        infoText = new JTextField();
        seekText = new JTextField();
        seekButton = new JButton();
        cpFromTo = new JTextField();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        outText = new JTextPane();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

            //---- jLabel1 ----
            jLabel1.setText("Sura");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(new Rectangle(new Point(0, 4), jLabel1.getPreferredSize()));

            //---- tf_sura ----
            tf_sura.setText("1");
            tf_sura.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tf_suraKeyReleased(e);
                }
            });
            jPanel1.add(tf_sura);
            tf_sura.setBounds(29, 1, 60, tf_sura.getPreferredSize().height);

            //---- jLabel2 ----
            jLabel2.setText("Aya");
            jPanel1.add(jLabel2);
            jLabel2.setBounds(new Rectangle(new Point(6, 35), jLabel2.getPreferredSize()));

            //---- tf_aya ----
            tf_aya.setText("1");
            tf_aya.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tf_ayaKeyReleased(e);
                }
            });
            jPanel1.add(tf_aya);
            tf_aya.setBounds(29, 32, 60, tf_aya.getPreferredSize().height);

            //---- jLabel3 ----
            jLabel3.setText("Quran");
            jPanel1.add(jLabel3);
            jLabel3.setBounds(new Rectangle(new Point(180, 0), jLabel3.getPreferredSize()));

            //---- combobox ----
            combobox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4"
            }));
            combobox.addActionListener(e -> comboboxActionPerformed(e));
            jPanel1.add(combobox);
            combobox.setBounds(220, 0, 132, combobox.getPreferredSize().height);

            //---- jButton1 ----
            jButton1.setText("Recite");
            jButton1.setToolTipText("");
            jButton1.setMargin(new Insets(2, 0, 2, 0));
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));
            jPanel1.add(jButton1);
            jButton1.setBounds(350, 0, 70, jButton1.getPreferredSize().height);

            //---- upButton ----
            upButton.setText("+");
            upButton.addActionListener(e -> upButtonActionPerformed(e));
            jPanel1.add(upButton);
            upButton.setBounds(96, 32, 40, upButton.getPreferredSize().height);

            //---- downButton ----
            downButton.setText("-");
            downButton.addActionListener(e -> downButtonActionPerformed(e));
            jPanel1.add(downButton);
            downButton.setBounds(131, 32, 40, downButton.getPreferredSize().height);

            //---- jButton2 ----
            jButton2.setText("Tweet");
            jButton2.setMargin(new Insets(2, 0, 2, 0));
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));
            jPanel1.add(jButton2);
            jButton2.setBounds(430, 0, 70, jButton2.getPreferredSize().height);

            //---- jButton3 ----
            jButton3.setText("Copy");
            jButton3.setToolTipText("");
            jButton3.setMargin(new Insets(2, 0, 2, 0));
            jButton3.addActionListener(e -> jButton3ActionPerformed(e));
            jPanel1.add(jButton3);
            jButton3.setBounds(430, 30, 56, jButton3.getPreferredSize().height);

            //---- upButton1 ----
            upButton1.setText("+");
            upButton1.addActionListener(e -> upButton1ActionPerformed(e));
            jPanel1.add(upButton1);
            upButton1.setBounds(96, 0, 40, upButton1.getPreferredSize().height);

            //---- downButton1 ----
            downButton1.setText("-");
            downButton1.addActionListener(e -> downButton1ActionPerformed(e));
            jPanel1.add(downButton1);
            downButton1.setBounds(131, 0, 40, downButton1.getPreferredSize().height);

            //---- infoText ----
            infoText.setEditable(false);
            infoText.setHorizontalAlignment(0);
            infoText.setBorder(new EmptyBorder(1, 1, 1, 1));
            jPanel1.add(infoText);
            infoText.setBounds(0, 64, 660, 37);
            jPanel1.add(seekText);
            seekText.setBounds(180, 30, 100, seekText.getPreferredSize().height);

            //---- seekButton ----
            seekButton.setText("Seek");
            seekButton.addActionListener(e -> seekButtonActionPerformed(e));
            jPanel1.add(seekButton);
            seekButton.setBounds(new Rectangle(new Point(280, 30), seekButton.getPreferredSize()));

            //---- cpFromTo ----
            cpFromTo.setText("1/1");
            cpFromTo.setToolTipText("Select Aya from/to for copy");
            jPanel1.add(cpFromTo);
            cpFromTo.setBounds(350, 30, 60, cpFromTo.getPreferredSize().height);

            //---- jLabel4 ----
            jLabel4.setText("-->");
            jPanel1.add(jLabel4);
            jLabel4.setBounds(new Rectangle(new Point(410, 40), jLabel4.getPreferredSize()));

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
        contentPane.add(jPanel1, BorderLayout.PAGE_START);

        //======== jScrollPane1 ========
        {

            //---- outText ----
            outText.setContentType("text/html");
            jScrollPane1.setViewportView(outText);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
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
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JTextField tf_sura;
    private JLabel jLabel2;
    private JTextField tf_aya;
    private JLabel jLabel3;
    private JComboBox<String> combobox;
    private JButton jButton1;
    private JButton upButton;
    private JButton downButton;
    private JButton jButton2;
    private JButton jButton3;
    private JButton upButton1;
    private JButton downButton1;
    private JTextField infoText;
    private JTextField seekText;
    private JButton seekButton;
    private JTextField cpFromTo;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JTextPane outText;
    // End of variables declaration//GEN-END:variables
}
