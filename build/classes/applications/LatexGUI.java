import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:05 CEST 2016
 */



/**
 * @author unknown
 */
public class LatexGUI extends JInternalFrame {
    public LatexGUI() {
        initComponents();
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

    private void jButton7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton7 = new JButton();
        saveName = new JTextField();
        canvas = new misc.PixelCanvas();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LaTEX");
        setToolTipText("");
        setName("");
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

            //======== jScrollPane1 ========
            {

                //---- textArea ----
                textArea.setColumns(20);
                textArea.setRows(5);
                jScrollPane1.setViewportView(textArea);
            }
            jPanel1.add(jScrollPane1);
            jScrollPane1.setBounds(0, 0, 630, 90);

            //---- jButton1 ----
            jButton1.setText("Render");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(new Rectangle(new Point(10, 100), jButton1.getPreferredSize()));

            //---- jButton2 ----
            jButton2.setText("to Clipboard");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(new Rectangle(new Point(100, 100), jButton2.getPreferredSize()));

            //---- jButton3 ----
            jButton3.setText("Tweet");
            jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3ActionPerformed(e);
                }
            });
            jPanel1.add(jButton3);
            jButton3.setBounds(new Rectangle(new Point(210, 100), jButton3.getPreferredSize()));

            //---- jButton7 ----
            jButton7.setText("Save as -->");
            jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton7ActionPerformed(e);
                }
            });
            jPanel1.add(jButton7);
            jButton7.setBounds(310, 100, 115, jButton7.getPreferredSize().height);

            //---- saveName ----
            saveName.setText("LaTEX");
            jPanel1.add(saveName);
            saveName.setBounds(430, 100, 192, saveName.getPreferredSize().height);

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
            canvas.setName("");
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
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton7;
    private JTextField saveName;
    private JPanel canvas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
