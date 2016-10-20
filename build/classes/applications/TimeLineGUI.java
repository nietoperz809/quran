import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:17 CEST 2016
 */



/**
 * @author unknown
 */
public class TimeLineGUI extends JInternalFrame {
    public TimeLineGUI() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        buttonPanel = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        itemPanel = new JPanel();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== buttonPanel ========
        {

            // JFormDesigner evaluation mark
            buttonPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), buttonPanel.getBorder())); buttonPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- jButton1 ----
            jButton1.setText("Fetch");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });

            //---- jButton2 ----
            jButton2.setText("toClipBrd");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });

            GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
            buttonPanel.setLayout(buttonPanelLayout);
            buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup()
                    .add(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton1)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(jButton2)
                        .addContainerGap(368, Short.MAX_VALUE))
            );
            buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup()
                    .add(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(buttonPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jButton1)
                            .add(jButton2))
                        .addContainerGap(23, Short.MAX_VALUE))
            );
        }
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        //======== jScrollPane1 ========
        {

            //======== itemPanel ========
            {
                itemPanel.setLayout(new GridLayout(0, 1, 5, 5));
            }
            jScrollPane1.setViewportView(itemPanel);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel buttonPanel;
    private JButton jButton1;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private JPanel itemPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
