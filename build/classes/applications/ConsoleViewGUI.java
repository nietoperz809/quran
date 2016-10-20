import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:03:57 CEST 2016
 */



/**
 * @author unknown
 */
public class ConsoleViewGUI extends JInternalFrame {
    public ConsoleViewGUI() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        textBox = new JTextArea();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        //======== this ========
        setResizable(true);
        setTitle("DebugOut");
        setName("");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jScrollPane1 ========
        {

            //---- textBox ----
            textBox.setEditable(false);
            textBox.setColumns(20);
            textBox.setRows(5);
            jScrollPane1.setViewportView(textBox);
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


            //---- jButton1 ----
            jButton1.setText("CLR");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });

            //---- jButton2 ----
            jButton2.setText("ToClip");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jButton1)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(jButton2)
                        .add(0, 259, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jButton1)
                            .add(jButton2)))
            );
        }
        contentPane.add(jPanel1, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JTextArea textBox;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
