/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import applications.LindenGUI;
import static java.awt.Color.ORANGE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;

/**
 *
 * @author Administrator
 */
public class RulePanel extends javax.swing.JPanel implements ActionListener
{
    private final LindenGUI parent;
    
    {
        initComponents();
    }
    
    /**
     * Creates new form RulePanel
     * @param con Parent
     * @param fin true == final rule
     */
    public RulePanel (LindenGUI con, boolean fin)
    {
        parent = con;
        if (fin)
        {
            this.setBackground (ORANGE);
            ruleTypeText.setText("Final Rule");
        }
    }

    public String getRule()
    {
        return ruleTxt.getText();
    }
    
    public double getProbability()
    {
        try
        {
            return parseDouble (probTxt.getText());
        }
        catch (NumberFormatException ex)
        {
            return 1.0;
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
        jButton1 = new JButton();
        ruleTxt = new JTextField();
        probTxt = new JTextField();
        ruleTypeText = new JLabel();
        jLabel2 = new JLabel();

        //======== this ========
        setBorder(new BevelBorder(BevelBorder.RAISED));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- jButton1 ----
        jButton1.setText("X");
        jButton1.setMargin(new Insets(0, 0, 0, 0));
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));
        add(jButton1);
        jButton1.setBounds(14, 15, 27, jButton1.getPreferredSize().height);
        add(ruleTxt);
        ruleTxt.setBounds(53, 27, 430, ruleTxt.getPreferredSize().height);

        //---- probTxt ----
        probTxt.setText("1.0");
        add(probTxt);
        probTxt.setBounds(490, 27, 88, probTxt.getPreferredSize().height);

        //---- ruleTypeText ----
        ruleTypeText.setText("Rule");
        add(ruleTypeText);
        ruleTypeText.setBounds(53, 2, 111, ruleTypeText.getPreferredSize().height);

        //---- jLabel2 ----
        jLabel2.setText("Probability");
        add(jLabel2);
        jLabel2.setBounds(new Rectangle(new Point(490, 2), jLabel2.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Delete Button clicked
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        parent.remove(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton jButton1;
    private JTextField ruleTxt;
    private JTextField probTxt;
    private JLabel ruleTypeText;
    private JLabel jLabel2;

    @Override
    public void actionPerformed (ActionEvent e)
    {

    }
    // End of variables declaration//GEN-END:variables
}
