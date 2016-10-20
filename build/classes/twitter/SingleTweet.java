import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:34 CEST 2016
 */



/**
 * @author unknown
 */
public class SingleTweet extends JPanel {
    public SingleTweet() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        mainTxt = new JTextArea();
        timeTxt = new JTextField();
        userTxt = new JTextField();
        miscTxt = new JTextField();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //======== jScrollPane1 ========
        {

            //---- mainTxt ----
            mainTxt.setEditable(false);
            mainTxt.setColumns(20);
            mainTxt.setLineWrap(true);
            mainTxt.setRows(2);
            mainTxt.setWrapStyleWord(true);
            mainTxt.setAutoscrolls(false);
            jScrollPane1.setViewportView(mainTxt);
        }

        //---- timeTxt ----
        timeTxt.setEditable(false);

        //---- userTxt ----
        userTxt.setEditable(false);

        //---- miscTxt ----
        miscTxt.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .add(layout.createSequentialGroup()
                    .add(layout.createParallelGroup()
                        .add(timeTxt)
                        .add(userTxt, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .add(miscTxt)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .add(layout.createSequentialGroup()
                    .add(layout.createParallelGroup()
                        .add(layout.createSequentialGroup()
                            .add(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(userTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .add(jScrollPane1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                    .add(miscTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JTextArea mainTxt;
    private JTextField timeTxt;
    private JTextField userTxt;
    private JTextField miscTxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
