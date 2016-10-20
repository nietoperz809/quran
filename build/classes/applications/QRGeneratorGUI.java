import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:12 CEST 2016
 */



/**
 * @author unknown
 */
public class QRGeneratorGUI extends JInternalFrame {
    public QRGeneratorGUI() {
        initComponents();
    }

    private void makeButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        makeButton = new JButton();
        jScrollPane1 = new JScrollPane();
        inputField = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton7 = new JButton();
        sizeField = new JTextField();
        jLabel1 = new JLabel();
        canvas = new misc.QuadraticPixelCanvas();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QR Maker");
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

            //---- makeButton ----
            makeButton.setText("Make!");
            makeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    makeButtonActionPerformed(e);
                }
            });
            jPanel1.add(makeButton);
            makeButton.setBounds(new Rectangle(new Point(18, 7), makeButton.getPreferredSize()));

            //======== jScrollPane1 ========
            {

                //---- inputField ----
                inputField.setColumns(20);
                inputField.setRows(5);
                jScrollPane1.setViewportView(inputField);
            }
            jPanel1.add(jScrollPane1);
            jScrollPane1.setBounds(100, 0, 462, jScrollPane1.getPreferredSize().height);

            //---- jButton1 ----
            jButton1.setText("To Clip");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(new Rectangle(new Point(18, 39), jButton1.getPreferredSize()));

            //---- jButton2 ----
            jButton2.setText("Tweet");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(new Rectangle(new Point(18, 71), jButton2.getPreferredSize()));

            //---- jButton7 ----
            jButton7.setText("Save");
            jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton7ActionPerformed(e);
                }
            });
            jPanel1.add(jButton7);
            jButton7.setBounds(20, 110, 80, jButton7.getPreferredSize().height);

            //---- sizeField ----
            sizeField.setText("200");
            jPanel1.add(sizeField);
            sizeField.setBounds(180, 110, 50, sizeField.getPreferredSize().height);

            //---- jLabel1 ----
            jLabel1.setText("---- SIZE --->");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(100, 110, 80, jLabel1.getPreferredSize().height);

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
        contentPane.add(jPanel1, BorderLayout.NORTH);

        //======== canvas ========
        {
            canvas.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < canvas.getComponentCount(); i++) {
                    Rectangle bounds = canvas.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = canvas.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                canvas.setMinimumSize(preferredSize);
                canvas.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(canvas, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JButton makeButton;
    private JScrollPane jScrollPane1;
    private JTextArea inputField;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton7;
    private JTextField sizeField;
    private JLabel jLabel1;
    private JPanel canvas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
