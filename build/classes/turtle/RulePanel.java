import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:31 CEST 2016
 */



/**
 * @author unknown
 */
public class RulePanel extends JPanel {
    public RulePanel() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
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
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton jButton1;
    private JTextField ruleTxt;
    private JTextField probTxt;
    private JLabel ruleTypeText;
    private JLabel jLabel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
