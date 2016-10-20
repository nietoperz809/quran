import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:13 CEST 2016
 */



/**
 * @author unknown
 */
public class QuranGUI extends JInternalFrame {
    public QuranGUI() {
        initComponents();
    }

    private void formInternalFrameClosed(InternalFrameEvent e) {
        // TODO add your code here
    }

    private void tf_suraKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void tf_ayaKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void comboboxActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void upButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void downButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void upButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void downButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void seekButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        tf_sura = new JTextField();
        jLabel2 = new JLabel();
        tf_aya = new JTextField();
        jLabel3 = new JLabel();
        combobox = new JComboBox();
        jButton1 = new JButton();
        upButton = new JButton();
        downButton = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        upButton1 = new JButton();
        downButton1 = new JButton();
        infoText = new JTextField();
        seekText = new JTextField();
        seekButton = new JButton();
        cpFromTo = new JTextField();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        outText = new JTextPane();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosed(InternalFrameEvent e) {
                formInternalFrameClosed(e);
            }
        });
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

            jPanel1.setLayout(null);

            //---- jLabel1 ----
            jLabel1.setText("Sura");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(new Rectangle(new Point(0, 4), jLabel1.getPreferredSize()));

            //---- tf_sura ----
            tf_sura.setText("1");
            tf_sura.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    tf_suraKeyReleased(e);
                }
            });
            jPanel1.add(tf_sura);
            tf_sura.setBounds(29, 1, 60, tf_sura.getPreferredSize().height);

            //---- jLabel2 ----
            jLabel2.setText("Aya");
            jPanel1.add(jLabel2);
            jLabel2.setBounds(new Rectangle(new Point(6, 35), jLabel2.getPreferredSize()));

            //---- tf_aya ----
            tf_aya.setText("1");
            tf_aya.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    tf_ayaKeyReleased(e);
                }
            });
            jPanel1.add(tf_aya);
            tf_aya.setBounds(29, 32, 60, tf_aya.getPreferredSize().height);

            //---- jLabel3 ----
            jLabel3.setText("Quran");
            jPanel1.add(jLabel3);
            jLabel3.setBounds(new Rectangle(new Point(180, 0), jLabel3.getPreferredSize()));

            //---- combobox ----
            combobox.setModel(new DefaultComboBoxModel(new String[] {
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4"
            }));
            combobox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    comboboxActionPerformed(e);
                }
            });
            jPanel1.add(combobox);
            combobox.setBounds(220, 0, 132, combobox.getPreferredSize().height);

            //---- jButton1 ----
            jButton1.setText("Recite");
            jButton1.setToolTipText("");
            jButton1.setMargin(new Insets(2, 0, 2, 0));
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(350, 0, 70, jButton1.getPreferredSize().height);

            //---- upButton ----
            upButton.setText("+");
            upButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    upButtonActionPerformed(e);
                }
            });
            jPanel1.add(upButton);
            upButton.setBounds(96, 32, 40, upButton.getPreferredSize().height);

            //---- downButton ----
            downButton.setText("-");
            downButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    downButtonActionPerformed(e);
                }
            });
            jPanel1.add(downButton);
            downButton.setBounds(131, 32, 40, downButton.getPreferredSize().height);

            //---- jButton2 ----
            jButton2.setText("Tweet");
            jButton2.setMargin(new Insets(2, 0, 2, 0));
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(430, 0, 70, jButton2.getPreferredSize().height);

            //---- jButton3 ----
            jButton3.setText("Copy");
            jButton3.setToolTipText("");
            jButton3.setMargin(new Insets(2, 0, 2, 0));
            jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3ActionPerformed(e);
                }
            });
            jPanel1.add(jButton3);
            jButton3.setBounds(430, 30, 56, jButton3.getPreferredSize().height);

            //---- upButton1 ----
            upButton1.setText("+");
            upButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    upButton1ActionPerformed(e);
                }
            });
            jPanel1.add(upButton1);
            upButton1.setBounds(96, 0, 40, upButton1.getPreferredSize().height);

            //---- downButton1 ----
            downButton1.setText("-");
            downButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    downButton1ActionPerformed(e);
                }
            });
            jPanel1.add(downButton1);
            downButton1.setBounds(131, 0, 40, downButton1.getPreferredSize().height);

            //---- infoText ----
            infoText.setEditable(false);
            infoText.setHorizontalAlignment(0);
            infoText.setBorder(new EmptyBorder(1, 1, 1, 1));
            jPanel1.add(infoText);
            infoText.setBounds(0, 64, 660, 37);
            jPanel1.add(seekText);
            seekText.setBounds(180, 30, 100, seekText.getPreferredSize().height);

            //---- seekButton ----
            seekButton.setText("Seek");
            seekButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    seekButtonActionPerformed(e);
                }
            });
            jPanel1.add(seekButton);
            seekButton.setBounds(new Rectangle(new Point(280, 30), seekButton.getPreferredSize()));

            //---- cpFromTo ----
            cpFromTo.setText("1/1");
            cpFromTo.setToolTipText("Select Aya from/to for copy");
            jPanel1.add(cpFromTo);
            cpFromTo.setBounds(350, 30, 60, cpFromTo.getPreferredSize().height);

            //---- jLabel4 ----
            jLabel4.setText("-->");
            jPanel1.add(jLabel4);
            jLabel4.setBounds(new Rectangle(new Point(410, 40), jLabel4.getPreferredSize()));

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
        contentPane.add(jPanel1, BorderLayout.PAGE_START);

        //======== jScrollPane1 ========
        {

            //---- outText ----
            outText.setContentType("text/html");
            jScrollPane1.setViewportView(outText);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JTextField tf_sura;
    private JLabel jLabel2;
    private JTextField tf_aya;
    private JLabel jLabel3;
    private JComboBox combobox;
    private JButton jButton1;
    private JButton upButton;
    private JButton downButton;
    private JButton jButton2;
    private JButton jButton3;
    private JButton upButton1;
    private JButton downButton1;
    private JTextField infoText;
    private JTextField seekText;
    private JButton seekButton;
    private JTextField cpFromTo;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JTextPane outText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
