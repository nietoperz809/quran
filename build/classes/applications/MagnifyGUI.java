import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:08 CEST 2016
 */



/**
 * @author unknown
 */
public class MagnifyGUI extends JInternalFrame {
    public MagnifyGUI() {
        initComponents();
    }

    private void formComponentResized(ComponentEvent e) {
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

    private void autoSaveTextFocusGained(FocusEvent e) {
        // TODO add your code here
    }

    private void autoSaveTextFocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void autoSaveTextActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        spinX = new JSpinner();
        spinY = new JSpinner();
        jButton3 = new JButton();
        checkHide = new JCheckBox();
        autoSaveText = new JTextField();
        JpgCheck = new JCheckBox();
        magnifyPanel = new magnify.MagnifyPanel(this);;

        //======== this ========
        setClosable(true);
        setResizable(true);
        setTitle("Magnifier");
        setName("");
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                formComponentResized(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jPanel2 ========
        {

            // JFormDesigner evaluation mark
            jPanel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel2.getBorder())); jPanel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- jButton1 ----
            jButton1.setText("toClpBrd");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1ActionPerformed(e);
                }
            });

            //---- jButton2 ----
            jButton2.setText("Tweet");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2ActionPerformed(e);
                }
            });

            //---- jButton3 ----
            jButton3.setText("Save->");
            jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3ActionPerformed(e);
                }
            });

            //---- checkHide ----
            checkHide.setText("Hide all");

            //---- autoSaveText ----
            autoSaveText.setToolTipText("<html><u>autoSaveDir (empty = autoave off)</u><br>only name of dir allowed<br>subdir will be stored in home directory</html>");
            autoSaveText.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    autoSaveTextFocusGained(e);
                }
                public void focusLost(FocusEvent e) {
                    autoSaveTextFocusLost(e);
                }
            });
            autoSaveText.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    autoSaveTextActionPerformed(e);
                }
            });

            //---- JpgCheck ----
            JpgCheck.setText("Save as Jpg");

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2Layout.createParallelGroup()
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jButton1)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(spinX, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(spinY, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(autoSaveText, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jButton2)
                                .addPreferredGap(LayoutStyle.RELATED)
                                .add(jButton3)
                                .add(18, 18, 18)
                                .add(checkHide)
                                .addPreferredGap(LayoutStyle.UNRELATED)
                                .add(JpgCheck)))
                        .addContainerGap(219, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .add(GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup()
                            .add(jButton1)
                            .add(jPanel2Layout.createParallelGroup(GroupLayout.BASELINE)
                                .add(spinY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(spinX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(autoSaveText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(GroupLayout.BASELINE)
                            .add(jButton2)
                            .add(jButton3)
                            .add(checkHide)
                            .add(JpgCheck))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        contentPane.add(jPanel2, BorderLayout.NORTH);

        //======== magnifyPanel ========
        {

            GroupLayout magnifyPanelLayout = new GroupLayout(magnifyPanel);
            magnifyPanel.setLayout(magnifyPanelLayout);
            magnifyPanelLayout.setHorizontalGroup(
                magnifyPanelLayout.createParallelGroup()
                    .add(0, 576, Short.MAX_VALUE)
            );
            magnifyPanelLayout.setVerticalGroup(
                magnifyPanelLayout.createParallelGroup()
                    .add(0, 204, Short.MAX_VALUE)
            );
        }
        contentPane.add(magnifyPanel, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jPanel2;
    private JButton jButton1;
    private JButton jButton2;
    private JSpinner spinX;
    private JSpinner spinY;
    private JButton jButton3;
    private JCheckBox checkHide;
    private JTextField autoSaveText;
    private JCheckBox JpgCheck;
    private JPanel magnifyPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
