/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import applications.LindenGUI;
import static java.awt.Color.ORANGE;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static javax.swing.BorderFactory.createBevelBorder;
import static javax.swing.border.BevelBorder.RAISED;

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
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        ruleTxt = new javax.swing.JTextField();
        probTxt = new javax.swing.JTextField();
        ruleTypeText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 102));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(592, 49));
        setMinimumSize(new java.awt.Dimension(592, 49));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("X");
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(this);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 27, -1));
        add(ruleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 27, 430, -1));

        probTxt.setText("1.0");
        add(probTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 27, 88, -1));

        ruleTypeText.setText("Rule");
        add(ruleTypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 2, 111, -1));

        jLabel2.setText("Probability");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 2, -1, -1));
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == jButton1)
        {
            RulePanel.this.jButton1ActionPerformed(evt);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField probTxt;
    private javax.swing.JTextField ruleTxt;
    private javax.swing.JLabel ruleTypeText;
    // End of variables declaration//GEN-END:variables
}
