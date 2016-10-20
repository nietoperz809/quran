import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:03 CEST 2016
 */



/**
 * @author unknown
 */
public class FtpServerGUI extends JInternalFrame {
    public FtpServerGUI() {
        initComponents();
    }

    private void formInternalFrameClosed(InternalFrameEvent e) {
        // TODO add your code here
    }

    private void buttonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        pathTxt = new JTextField();
        portTxt = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        button = new JToggleButton();
        transmitted = new JLabel();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FtpServer");
        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosed(InternalFrameEvent e) {
                formInternalFrameClosed(e);
            }
        });
        Container contentPane = getContentPane();

        //---- pathTxt ----
        pathTxt.setText("C:\\\\");

        //---- portTxt ----
        portTxt.setText("21");

        //---- jLabel1 ----
        jLabel1.setText("BasePath");

        //---- jLabel2 ----
        jLabel2.setText("Port");

        //---- button ----
        button.setText("Start");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonActionPerformed(e);
            }
        });

        //---- transmitted ----
        transmitted.setText("0");
        transmitted.setToolTipText("Bytes transferred ...");
        transmitted.setDoubleBuffered(true);
        transmitted.setOpaque(true);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jLabel1)
                            .addPreferredGap(LayoutStyle.RELATED))
                        .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                            .add(jLabel2)
                            .add(34, 34, 34)))
                    .add(contentPaneLayout.createParallelGroup()
                        .add(pathTxt)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(portTxt, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .add(38, 38, 38)
                            .add(transmitted, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED, 74, Short.MAX_VALUE)
                            .add(button, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel1)
                        .add(pathTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                .add(jLabel2)
                                .add(portTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(transmitted, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                            .add(0, 15, Short.MAX_VALUE))
                        .add(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField pathTxt;
    private JTextField portTxt;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JToggleButton button;
    private JLabel transmitted;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
