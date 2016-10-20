import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:12 CEST 2016
 */



/**
 * @author unknown
 */
public class NumberConverter extends JInternalFrame {
    public NumberConverter() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void tfToActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        tfIn = new JTextField();
        labOut = new JLabel();
        jButton1 = new JButton();
        tfFrom = new JTextField();
        tfTo = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton2 = new JButton();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //---- tfIn ----
        tfIn.setToolTipText("input");

        //---- labOut ----
        labOut.setText("  ");
        labOut.setOpaque(true);

        //---- jButton1 ----
        jButton1.setText("Just do it");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        //---- tfFrom ----
        tfFrom.setText("10");

        //---- tfTo ----
        tfTo.setText("16");
        tfTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfToActionPerformed(e);
            }
        });

        //---- jLabel2 ----
        jLabel2.setText("from base");

        //---- jLabel3 ----
        jLabel3.setText("to base");

        //---- jButton2 ----
        jButton2.setText("Tweet");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(tfIn)
                                .add(labOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                            .add(14, 14, 14)
                            .add(jLabel2)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(tfFrom, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(jLabel3)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(tfTo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .add(51, 51, 51)
                            .add(jButton1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED, 94, Short.MAX_VALUE)
                            .add(jButton2)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(tfIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .add(18, 18, 18)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .add(tfFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(tfTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(jLabel2)
                        .add(jLabel3)
                        .add(jButton2))
                    .addPreferredGap(LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                    .add(labOut)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField tfIn;
    private JLabel labOut;
    private JButton jButton1;
    private JTextField tfFrom;
    private JTextField tfTo;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JButton jButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
