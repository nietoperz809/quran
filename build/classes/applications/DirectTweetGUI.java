import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:03:57 CEST 2016
 */



/**
 * @author unknown
 */
public class DirectTweetGUI extends JInternalFrame {
    public DirectTweetGUI() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton7 = new JButton();
        saveName = new JTextField();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("DirectTweet");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jScrollPane1 ========
        {

            //---- textArea ----
            textArea.setColumns(20);
            textArea.setLineWrap(true);
            textArea.setRows(5);
            textArea.setWrapStyleWord(true);
            jScrollPane1.setViewportView(textArea);
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

            jPanel1.setLayout(null);

            //---- jButton1 ----
            jButton1.setText("Send");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(20, 5, 90, 40);

            //---- jButton7 ----
            jButton7.setText("Save as -->");
            jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton7ActionPerformed(e);
                }
            });
            jPanel1.add(jButton7);
            jButton7.setBounds(150, 10, 115, jButton7.getPreferredSize().height);

            //---- saveName ----
            saveName.setText("DirectTweet");
            jPanel1.add(saveName);
            saveName.setBounds(280, 10, 192, saveName.getPreferredSize().height);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton7;
    private JTextField saveName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
