import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:23 CEST 2016
 */



/**
 * @author unknown
 */
public class WebServerGUI extends JInternalFrame {
    public WebServerGUI() {
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
        fileTime = new JLabel();
        jLabel4 = new JLabel();
        jLabel3 = new JLabel();
        buffSizeTxt = new JTextField();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Webserver");
        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosed(InternalFrameEvent e) {
                formInternalFrameClosed(e);
            }
        });
        Container contentPane = getContentPane();

        //---- pathTxt ----
        pathTxt.setText("F:\\\\");

        //---- portTxt ----
        portTxt.setText("80");

        //---- jLabel1 ----
        jLabel1.setText("BasePath");

        //---- jLabel2 ----
        jLabel2.setText("Port");

        //---- button ----
        button.setText("Start");
        button.setDoubleBuffered(true);
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

        //---- fileTime ----
        fileTime.setText("0");
        fileTime.setBorder(new BevelBorder(BevelBorder.RAISED));

        //---- jLabel4 ----
        jLabel4.setText("time:");

        //---- jLabel3 ----
        jLabel3.setText("Buffer");

        //---- buffSizeTxt ----
        buffSizeTxt.setText("113072");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.LEADING, false)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jLabel2)
                            .add(18, 18, 18)
                            .add(portTxt))
                        .add(jLabel1)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(jLabel3)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(buffSizeTxt, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(17, 17, 17)
                            .add(transmitted, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(jLabel4)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(fileTime, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(button, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .add(pathTxt))
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
                                .add(transmitted, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .add(fileTime)
                                .add(jLabel4))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                .add(jLabel3)
                                .add(buffSizeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .add(0, 3, Short.MAX_VALUE))
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
    private JLabel fileTime;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JTextField buffSizeTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
