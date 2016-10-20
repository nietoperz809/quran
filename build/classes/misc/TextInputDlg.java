import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:27 CEST 2016
 */



/**
 * @author unknown
 */
public class TextInputDlg extends JDialog {
    public TextInputDlg(Frame owner) {
        super(owner);
        initComponents();
    }

    public TextInputDlg(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void textFieldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField = new JTextField();

        //======== this ========
        setDefaultCloseOperation(2);
        Container contentPane = getContentPane();

        //---- textField ----
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, textField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
