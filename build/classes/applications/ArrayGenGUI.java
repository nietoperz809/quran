import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
/*
 * Created by JFormDesigner on Mon Jul 25 21:03:45 CEST 2016
 */



/**
 * @author unknown
 */
public class ArrayGenGUI extends JInternalFrame {
    public ArrayGenGUI() {
        initComponents();
    }

    private void chooserActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void rbCActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void rbJavaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void nameFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void rbPHPActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void rbJava1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        chooser = new JFileChooser();
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();
        button = new JButton();
        rbC = new JRadioButton();
        rbJava = new JRadioButton();
        nameField = new JTextField();
        rbPHP = new JRadioButton();
        rbJava1 = new JRadioButton();

        //======== this ========
        setTitle("Pittis Array Generator");
        Container contentPane = getContentPane();

        //---- chooser ----
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setControlButtonsAreShown(false);
        chooser.setToolTipText("");
        chooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooserActionPerformed(e);
            }
        });

        //======== jScrollPane1 ========
        {

            //---- textArea ----
            textArea.setColumns(20);
            textArea.setRows(5);
            jScrollPane1.setViewportView(textArea);
        }

        //---- button ----
        button.setText("Copy to clipboard ...");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });

        //---- rbC ----
        rbC.setText("C");
        rbC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rbCActionPerformed(e);
            }
        });

        //---- rbJava ----
        rbJava.setText("Java");
        rbJava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rbJavaActionPerformed(e);
            }
        });

        //---- nameField ----
        nameField.setText("myArray");
        nameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameFieldActionPerformed(e);
            }
        });

        //---- rbPHP ----
        rbPHP.setText("PHP");
        rbPHP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rbPHPActionPerformed(e);
            }
        });

        //---- rbJava1 ----
        rbJava1.setSelected(true);
        rbJava1.setText("Java func");
        rbJava1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rbJava1ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(12, 12, 12)
                    .add(button)
                    .add(8, 8, 8)
                    .add(rbC)
                    .add(4, 4, 4)
                    .add(rbJava)
                    .add(4, 4, 4)
                    .add(rbJava1)
                    .add(0, 0, 0)
                    .add(rbPHP)
                    .add(18, 18, 18)
                    .add(nameField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE))
                .add(jScrollPane1)
                .add(chooser, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(chooser, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                    .add(7, 7, 7)
                    .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                    .add(7, 7, 7)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(button)
                        .add(rbC)
                        .add(rbJava)
                        .add(rbJava1)
                        .add(rbPHP)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(1, 1, 1)
                            .add(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //---- buttonGroup ----
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbC);
        buttonGroup.add(rbJava);
        buttonGroup.add(rbPHP);
        buttonGroup.add(rbJava1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFileChooser chooser;
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    private JButton button;
    private JRadioButton rbC;
    private JRadioButton rbJava;
    private JTextField nameField;
    private JRadioButton rbPHP;
    private JRadioButton rbJava1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
