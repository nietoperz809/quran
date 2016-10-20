import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:04 CEST 2016
 */



/**
 * @author unknown
 */
public class HadithGUI extends JInternalFrame {
    public HadithGUI() {
        initComponents();
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton1 = new JButton();
        jScrollPane2 = new JScrollPane();
        outWin = new JTextArea();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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


            //---- jButton2 ----
            jButton2.setText("GET");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });

            //---- jButton1 ----
            jButton1.setText("Tweet");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton2)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(jButton1)
                        .addContainerGap(396, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jButton2)
                            .add(jButton1))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        contentPane.add(jPanel1, BorderLayout.SOUTH);

        //======== jScrollPane2 ========
        {
            jScrollPane2.setHorizontalScrollBarPolicy(31);

            //---- outWin ----
            outWin.setEditable(false);
            outWin.setColumns(20);
            outWin.setLineWrap(true);
            outWin.setRows(5);
            outWin.setWrapStyleWord(true);
            jScrollPane2.setViewportView(outWin);
        }
        contentPane.add(jScrollPane2, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JButton jButton2;
    private JButton jButton1;
    private JScrollPane jScrollPane2;
    private JTextArea outWin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
