import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:03:46 CEST 2016
 */



/**
 * @author unknown
 */
public class BasicGUI extends JInternalFrame {
    public BasicGUI() {
        initComponents();
    }

    private void formInternalFrameClosed(InternalFrameEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton9 = new JButton();
        saveName = new JTextField();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        area = new StreamingTextArea();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BASIC");
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

            //---- jButton1 ----
            jButton1.setText("CLS");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(new Rectangle(new Point(0, 0), jButton1.getPreferredSize()));

            //---- jButton9 ----
            jButton9.setText("Save as -->");
            jButton9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton9ActionPerformed(e);
                }
            });
            jPanel1.add(jButton9);
            jButton9.setBounds(310, 0, 120, jButton9.getPreferredSize().height);

            //---- saveName ----
            saveName.setText("BASIC");
            jPanel1.add(saveName);
            saveName.setBounds(430, 0, 160, saveName.getPreferredSize().height);

            //---- jButton2 ----
            jButton2.setText("Stop");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(new Rectangle(new Point(70, 0), jButton2.getPreferredSize()));

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
        contentPane.add(jPanel1, BorderLayout.SOUTH);

        //======== jScrollPane1 ========
        {

            //---- area ----
            area.setColumns(20);
            area.setLineWrap(true);
            area.setRows(20);
            area.setCaretColor(new Color(255, 102, 102));
            jScrollPane1.setViewportView(area);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton9;
    private JTextField saveName;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private JTextArea area;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
