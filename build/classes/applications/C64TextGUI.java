import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:03:47 CEST 2016
 */



/**
 * @author unknown
 */
public class C64TextGUI extends JInternalFrame {
    public C64TextGUI() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        inputText = new JTextArea();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton7 = new JButton();
        saveName = new JTextField();
        jButton2 = new JButton();
        jButton4 = new JButton();
        messageTxt = new JTextField();
        checkCentered = new JCheckBox();
        checkRight = new JCheckBox();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("C64Font");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jScrollPane1 ========
        {

            //---- inputText ----
            inputText.setColumns(20);
            inputText.setRows(5);
            jScrollPane1.setViewportView(inputText);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);

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
            jButton1.setText("Render");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(10, 0, jButton1.getPreferredSize().width, 20);

            //---- jButton7 ----
            jButton7.setText("Save as -->");
            jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton7ActionPerformed(e);
                }
            });
            jPanel1.add(jButton7);
            jButton7.setBounds(390, 10, 120, jButton7.getPreferredSize().height);

            //---- saveName ----
            saveName.setText("C64Text");
            jPanel1.add(saveName);
            saveName.setBounds(510, 10, 160, saveName.getPreferredSize().height);

            //---- jButton2 ----
            jButton2.setText("To Clip");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(10, 30, 90, 20);

            //---- jButton4 ----
            jButton4.setText("Tweet");
            jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4ActionPerformed(e);
                }
            });
            jPanel1.add(jButton4);
            jButton4.setBounds(new Rectangle(new Point(250, 0), jButton4.getPreferredSize()));

            //---- messageTxt ----
            messageTxt.setText("C64_Font");
            jPanel1.add(messageTxt);
            messageTxt.setBounds(230, 30, 120, messageTxt.getPreferredSize().height);

            //---- checkCentered ----
            checkCentered.setText("centered");
            jPanel1.add(checkCentered);
            checkCentered.setBounds(111, 0, 110, checkCentered.getPreferredSize().height);

            //---- checkRight ----
            checkRight.setText("right");
            jPanel1.add(checkRight);
            checkRight.setBounds(110, 20, 91, checkRight.getPreferredSize().height);

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
        contentPane.add(jPanel1, BorderLayout.PAGE_END);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JTextArea inputText;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton7;
    private JTextField saveName;
    private JButton jButton2;
    private JButton jButton4;
    private JTextField messageTxt;
    private JCheckBox checkCentered;
    private JCheckBox checkRight;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
