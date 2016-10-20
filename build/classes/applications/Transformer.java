import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:20 CEST 2016
 */



/**
 * @author unknown
 */
public class Transformer extends JInternalFrame {
    public Transformer() {
        initComponents();
    }

    private void checkBase64ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void checkMD5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void checkCRC16ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void encodeButtActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void decodeButtActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void checkRot13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void checkSHA1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jRadioButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        checkBase64 = new JRadioButton();
        checkMD5 = new JRadioButton();
        checkCRC16 = new JRadioButton();
        encodeButt = new JButton();
        decodeButt = new JButton();
        jRadioButton1 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        jSplitPane1 = new JSplitPane();
        jScrollPane1 = new JScrollPane();
        clearText = new JTextArea();
        jScrollPane2 = new JScrollPane();
        encText = new JTextArea();
        checkRot13 = new JRadioButton();
        checkSHA1 = new JRadioButton();
        jRadioButton4 = new JRadioButton();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //======== jPanel1 ========
        {

            // JFormDesigner evaluation mark
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- checkBase64 ----
            checkBase64.setText("Base64");
            checkBase64.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checkBase64ActionPerformed(e);
                }
            });

            //---- checkMD5 ----
            checkMD5.setText("MD5");
            checkMD5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checkMD5ActionPerformed(e);
                }
            });

            //---- checkCRC16 ----
            checkCRC16.setText("CRC16-CCITT");
            checkCRC16.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checkCRC16ActionPerformed(e);
                }
            });

            //---- encodeButt ----
            encodeButt.setText("Encode >>");
            encodeButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    encodeButtActionPerformed(e);
                }
            });

            //---- decodeButt ----
            decodeButt.setText("<< Decode");
            decodeButt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    decodeButtActionPerformed(e);
                }
            });

            //---- jRadioButton1 ----
            jRadioButton1.setText("SHA256");
            jRadioButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRadioButton1ActionPerformed(e);
                }
            });

            //---- jRadioButton3 ----
            jRadioButton3.setText("GrayCode");
            jRadioButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRadioButton3ActionPerformed(e);
                }
            });

            //---- jRadioButton2 ----
            jRadioButton2.setText("MD4");
            jRadioButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRadioButton2ActionPerformed(e);
                }
            });

            //---- jRadioButton5 ----
            jRadioButton5.setText("Substitute1");
            jRadioButton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRadioButton5ActionPerformed(e);
                }
            });

            //---- jRadioButton6 ----
            jRadioButton6.setText("Hagelin");
            jRadioButton6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jRadioButton6ActionPerformed(e);
                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(decodeButt)
                        .add(99, 99, 99))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup()
                            .add(checkBase64)
                            .add(jRadioButton1)
                            .add(jRadioButton2))
                        .add(18, 18, 18)
                        .add(jPanel1Layout.createParallelGroup()
                            .add(jRadioButton3)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(checkMD5)
                                .add(73, 73, 73)
                                .add(jRadioButton5))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(GroupLayout.TRAILING)
                                    .add(encodeButt)
                                    .add(checkCRC16))
                                .add(18, 18, 18)
                                .add(jRadioButton6)))
                        .add(0, 372, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(checkBase64)
                            .add(checkMD5)
                            .add(jRadioButton5))
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jRadioButton1)
                            .add(checkCRC16)
                            .add(jRadioButton6))
                        .addPreferredGap(LayoutStyle.UNRELATED)
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jRadioButton2)
                            .add(jRadioButton3))
                        .addPreferredGap(LayoutStyle.RELATED, 9, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(encodeButt)
                            .add(decodeButt)))
            );
        }

        //======== jSplitPane1 ========
        {
            jSplitPane1.setDividerLocation(340);
            jSplitPane1.setDividerSize(3);
            jSplitPane1.setToolTipText("Drag left/right");

            //======== jScrollPane1 ========
            {

                //---- clearText ----
                clearText.setColumns(20);
                clearText.setLineWrap(true);
                clearText.setRows(5);
                jScrollPane1.setViewportView(clearText);
            }
            jSplitPane1.setLeftComponent(jScrollPane1);

            //======== jScrollPane2 ========
            {

                //---- encText ----
                encText.setColumns(20);
                encText.setLineWrap(true);
                encText.setRows(5);
                jScrollPane2.setViewportView(encText);
            }
            jSplitPane1.setRightComponent(jScrollPane2);
        }

        //---- checkRot13 ----
        checkRot13.setSelected(true);
        checkRot13.setText("Rot13");
        checkRot13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkRot13ActionPerformed(e);
            }
        });

        //---- checkSHA1 ----
        checkSHA1.setText("SHA1");
        checkSHA1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkSHA1ActionPerformed(e);
            }
        });

        //---- jRadioButton4 ----
        jRadioButton4.setText("URL Enc");
        jRadioButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRadioButton4ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(GroupLayout.TRAILING, jSplitPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(contentPaneLayout.createSequentialGroup()
                    .add(checkRot13)
                    .add(30, 30, 30)
                    .add(checkSHA1)
                    .add(67, 67, 67)
                    .add(jRadioButton4)
                    .add(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(checkRot13)
                        .add(checkSHA1)
                        .add(jRadioButton4))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jSplitPane1, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(checkBase64);
        buttonGroup1.add(checkMD5);
        buttonGroup1.add(checkCRC16);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton5);
        buttonGroup1.add(jRadioButton6);
        buttonGroup1.add(checkRot13);
        buttonGroup1.add(checkSHA1);
        buttonGroup1.add(jRadioButton4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JRadioButton checkBase64;
    private JRadioButton checkMD5;
    private JRadioButton checkCRC16;
    private JButton encodeButt;
    private JButton decodeButt;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JSplitPane jSplitPane1;
    private JScrollPane jScrollPane1;
    private JTextArea clearText;
    private JScrollPane jScrollPane2;
    private JTextArea encText;
    private JRadioButton checkRot13;
    private JRadioButton checkSHA1;
    private JRadioButton jRadioButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
