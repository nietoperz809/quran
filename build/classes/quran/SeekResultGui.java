import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:30 CEST 2016
 */



/**
 * @author unknown
 */
public class SeekResultGui extends JInternalFrame {
    public SeekResultGui() {
        initComponents();
    }

    private void listControlMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jScrollPane1 = new JScrollPane();
        listControl = new JList();

        //======== this ========
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setName("");
        setSelected(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== jScrollPane1 ========
        {

            //---- listControl ----
            listControl.setModel(new AbstractListModel() {
                String[] values = {
                    "Item 1",
                    "Item 2",
                    "Item 3",
                    "Item 4",
                    "Item 5"
                };
                public int getSize() { return values.length; }
                public Object getElementAt(int i) { return values[i]; }
            });
            listControl.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    listControlMouseClicked(e);
                }
            });
            jScrollPane1.setViewportView(listControl);
        }
        contentPane.add(jScrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    private JList listControl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
