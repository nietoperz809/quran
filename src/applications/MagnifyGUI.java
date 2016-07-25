/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import magnify.MagnifyPanel;

/**
 *
 * @author Administrator
 */
public class MagnifyGUI extends javax.swing.JInternalFrame
{

    /**
     * Creates new form MagnifyGUI
     */
    public MagnifyGUI()
    {
        initComponents();
        spinX.setUI(new NewSpinUI(spinX));
        spinY.setUI(new NewSpinUI(spinY));
    }

    class NewSpinUI extends javax.swing.plaf.basic.BasicSpinnerUI
    {
        private final JSpinner target;

        public NewSpinUI(JSpinner tg)
        {
            super();
            target = tg;
        }

        private void doIt()
        {
            Rectangle r = MagnifyGUI.this.getBounds();
            if (target == spinX)
            {
                r.width = (Integer) MagnifyGUI.this.spinX.getValue();
            }
            else
            {
                r.height = (Integer) MagnifyGUI.this.spinY.getValue();
            }
            MagnifyGUI.this.setBounds(r);
        }

        @Override
        protected JComponent createEditor()
        {
            JSpinner.DefaultEditor comp = (JSpinner.DefaultEditor) super.createEditor();
            JFormattedTextField tf = comp.getTextField();
            tf.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(final KeyEvent e)
                {
                    try
                    {
                        target.commitEdit();
                    }
                    catch (ParseException ex)
                    {
                        Logger.getLogger(MagnifyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    doIt();
                    //System.out.println("enter pressed");
                }
            });
            return comp;
        }

        @Override
        protected Component createNextButton()
        {
            JButton btnUp = (JButton) super.createNextButton();
            btnUp.addActionListener((ActionEvent ae) ->
            {
                doIt();
            });
            return btnUp;
        }

        @Override
        protected Component createPreviousButton()
        {
            JButton btnDown = (JButton) super.createPreviousButton();
            btnDown.addActionListener((ActionEvent ae) ->
            {
                doIt();
            });
            return btnDown;
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
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        spinX = new JSpinner();
        spinY = new JSpinner();
        jButton3 = new JButton();
        checkHide = new JCheckBox();
        autoSaveText = new JTextField();
        JpgCheck = new JCheckBox();
        magnifyPanel = new magnify.MagnifyPanel(this);;

        //======== this ========
        setClosable(true);
        setResizable(true);
        setTitle("Magnifier");
        setName("");
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                formComponentResized(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jPanel2 ========
        {

            // JFormDesigner evaluation mark
            jPanel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel2.getBorder())); jPanel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- jButton1 ----
            jButton1.setText("toClpBrd");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jButton2 ----
            jButton2.setText("Tweet");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jButton3 ----
            jButton3.setText("Save->");
            jButton3.addActionListener(e -> jButton3ActionPerformed(e));

            //---- checkHide ----
            checkHide.setText("Hide all");

            //---- autoSaveText ----
            autoSaveText.setToolTipText("<html><u>autoSaveDir (empty = autoave off)</u><br>only name of dir allowed<br>subdir will be stored in home directory</html>");
            autoSaveText.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    autoSaveTextFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    autoSaveTextFocusLost(e);
                }
            });
            autoSaveText.addActionListener(e -> autoSaveTextActionPerformed(e));

            //---- JpgCheck ----
            JpgCheck.setText("Save as Jpg");

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup()
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinX, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinY, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(autoSaveText, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(checkHide)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JpgCheck)))
                        .addContainerGap(219, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup()
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(spinY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(autoSaveText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(checkHide)
                            .addComponent(JpgCheck))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        contentPane.add(jPanel2, BorderLayout.NORTH);

        //======== magnifyPanel ========
        {

            GroupLayout magnifyPanelLayout = new GroupLayout(magnifyPanel);
            magnifyPanel.setLayout(magnifyPanelLayout);
            magnifyPanelLayout.setHorizontalGroup(
                magnifyPanelLayout.createParallelGroup()
                    .addGap(0, 576, Short.MAX_VALUE)
            );
            magnifyPanelLayout.setVerticalGroup(
                magnifyPanelLayout.createParallelGroup()
                    .addGap(0, 204, Short.MAX_VALUE)
            );
        }
        contentPane.add(magnifyPanel, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        ((MagnifyPanel) magnifyPanel).toClipboard(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        ((MagnifyPanel) magnifyPanel).tweet();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentResized
    {//GEN-HEADEREND:event_formComponentResized
        Dimension d = evt.getComponent().getSize();
        spinX.setValue(d.width);
        spinY.setValue(d.height);
    }//GEN-LAST:event_formComponentResized

    // Save
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        ((MagnifyPanel) magnifyPanel).save(JpgCheck.isSelected());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void autoSaveTextActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_autoSaveTextActionPerformed
    {//GEN-HEADEREND:event_autoSaveTextActionPerformed
        autoSaveChanged = true;
        checkHide.requestFocus(); // Move Focus away
    }//GEN-LAST:event_autoSaveTextActionPerformed

    private void autoSaveTextFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_autoSaveTextFocusGained
    {//GEN-HEADEREND:event_autoSaveTextFocusGained
        autoSaveText.setBackground(Color.pink);
        autoSaveText.repaint();
    }//GEN-LAST:event_autoSaveTextFocusGained

    private void autoSaveTextFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_autoSaveTextFocusLost
    {//GEN-HEADEREND:event_autoSaveTextFocusLost
        autoSaveText.setBackground(Color.white);
        autoSaveText.repaint();
    }//GEN-LAST:event_autoSaveTextFocusLost

    public String getAutosavePath()
    {
        String txt = autoSaveText.getText();
        if (txt.isEmpty())
            return null;
        return txt;
    }
    
    public boolean isAutoSaveChanged()
    {
        boolean b = autoSaveChanged;
        autoSaveChanged = false;
        return b;
    }
    
    public boolean getHideMode()
    {
        return checkHide.isSelected();
    }

    private boolean autoSaveChanged;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel2;
    private JButton jButton1;
    private JButton jButton2;
    private JSpinner spinX;
    private JSpinner spinY;
    private JButton jButton3;
    private JCheckBox checkHide;
    private JTextField autoSaveText;
    private JCheckBox JpgCheck;
    private JPanel magnifyPanel;
    // End of variables declaration//GEN-END:variables
}
