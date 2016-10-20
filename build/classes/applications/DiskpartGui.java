import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:01 CEST 2016
 */



/**
 * @author unknown
 */
public class DiskpartGui extends JInternalFrame {
    public DiskpartGui() {
        initComponents();
    }

    private void formInternalFrameClosed(InternalFrameEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void directTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton8ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton10ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton11ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton12ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton14ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        outField = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        numberField = new JTextField();
        jButton6 = new JButton();
        jButton7 = new JButton();
        directText = new JTextField();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("DiskPartitioner");
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosed(InternalFrameEvent e) {
                formInternalFrameClosed(e);
            }
        });
        Container contentPane = getContentPane();

        //======== jScrollPane1 ========
        {

            //---- outField ----
            outField.setColumns(20);
            outField.setRows(5);
            jScrollPane1.setViewportView(outField);
        }

        //---- jButton1 ----
        jButton1.setText("help");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        //---- jButton2 ----
        jButton2.setText("listVolume");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        //---- jButton3 ----
        jButton3.setText("listDisk");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });

        //---- jButton4 ----
        jButton4.setText("listPartition");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton4ActionPerformed(e);
            }
        });

        //---- jButton5 ----
        jButton5.setText("selDisk");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton5ActionPerformed(e);
            }
        });

        //---- numberField ----
        numberField.setText("0");

        //---- jButton6 ----
        jButton6.setText("selPartition");
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton6ActionPerformed(e);
            }
        });

        //---- jButton7 ----
        jButton7.setText("selVolume");
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton7ActionPerformed(e);
            }
        });

        //---- directText ----
        directText.setText("?");
        directText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                directTextActionPerformed(e);
            }
        });

        //---- jButton8 ----
        jButton8.setText("detDisk");
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton8ActionPerformed(e);
            }
        });

        //---- jButton9 ----
        jButton9.setText("detPart");
        jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton9ActionPerformed(e);
            }
        });

        //---- jButton10 ----
        jButton10.setText("detVolume");
        jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton10ActionPerformed(e);
            }
        });

        //---- jButton11 ----
        jButton11.setText("fileSys");
        jButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton11ActionPerformed(e);
            }
        });

        //---- jButton12 ----
        jButton12.setText("attrVolume");
        jButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton12ActionPerformed(e);
            }
        });

        //---- jButton13 ----
        jButton13.setText("attrDisk");
        jButton13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton13ActionPerformed(e);
            }
        });

        //---- jButton14 ----
        jButton14.setText("clr");
        jButton14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton14ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(1, 1, 1)
                    .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(60, 60, 60)
                                    .add(jButton12))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(160, 160, 160)
                                    .add(jButton7))
                                .add(jButton5)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(150, 150, 150)
                                    .add(jButton13))
                                .add(jButton3)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(70, 70, 70)
                                    .add(jButton4))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(160, 160, 160)
                                    .add(jButton2))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(70, 70, 70)
                                    .add(jButton6))
                                .add(jButton8)
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(70, 70, 70)
                                    .add(jButton9))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(140, 140, 140)
                                    .add(jButton10))
                                .add(jButton11))
                            .add(9, 9, 9)
                            .add(numberField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(250, 250, 250)
                            .add(jButton1))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(40, 40, 40)
                            .add(directText, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(16, 16, 16)
                            .add(jButton14))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(60, 60, 60)
                            .add(jButton12))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(20, 20, 20)
                            .add(jButton7))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(20, 20, 20)
                            .add(jButton5))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(60, 60, 60)
                            .add(jButton13))
                        .add(jButton3)
                        .add(jButton4)
                        .add(jButton2)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(20, 20, 20)
                            .add(jButton6))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(40, 40, 40)
                            .add(jButton8))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(40, 40, 40)
                            .add(jButton9))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(40, 40, 40)
                            .add(jButton10))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(60, 60, 60)
                            .add(jButton11))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(20, 20, 20)
                            .add(numberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .add(jButton1))
                    .add(175, 175, 175)
                    .add(directText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jButton14)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(jScrollPane1)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JTextArea outField;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JTextField numberField;
    private JButton jButton6;
    private JButton jButton7;
    private JTextField directText;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
