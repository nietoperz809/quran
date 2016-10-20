import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:22 CEST 2016
 */



/**
 * @author unknown
 */
public class WarperGUI extends JInternalFrame {
    public WarperGUI() {
        initComponents();
    }

    private void jMenuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jPanel1 = new WarpCanvas();
        jPanel2 = new JPanel();
        jButton4 = new JButton();
        messageTxt = new JTextField();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jMenuBar1 ========
        {

            //======== jMenu1 ========
            {
                jMenu1.setText("File");

                //---- jMenuItem1 ----
                jMenuItem1.setText("Load");
                jMenuItem1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem1ActionPerformed(e);
                    }
                });
                jMenu1.add(jMenuItem1);

                //---- jMenuItem2 ----
                jMenuItem2.setText("Save");
                jMenuItem2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem2ActionPerformed(e);
                    }
                });
                jMenu1.add(jMenuItem2);
            }
            jMenuBar1.add(jMenu1);
        }
        setJMenuBar(jMenuBar1);

        //======== jPanel1 ========
        {

            // JFormDesigner evaluation mark
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(0, 329, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .add(0, 207, Short.MAX_VALUE)
            );
        }
        contentPane.add(jPanel1, BorderLayout.CENTER);

        //======== jPanel2 ========
        {

            //---- jButton4 ----
            jButton4.setText("Tweet");
            jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4ActionPerformed(e);
                }
            });

            //---- messageTxt ----
            messageTxt.setText("Warped_Image");

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton4)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(messageTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(121, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(jPanel2Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(messageTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(jButton4))
                        .add(0, 24, Short.MAX_VALUE))
            );
        }
        contentPane.add(jPanel2, BorderLayout.PAGE_END);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JButton jButton4;
    private JTextField messageTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
