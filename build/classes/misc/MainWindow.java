import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:26 CEST 2016
 */



/**
 * @author unknown
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
    }

    private void openMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem10ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem12ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem14ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem15ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem16ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem17ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem18ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem19ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem20ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem21ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem23ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem11ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem22ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jMenuItem24ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        openMenuItem = new JMenuItem();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jMenuItem6 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        jMenuItem9 = new JMenuItem();
        jMenuItem10 = new JMenuItem();
        jMenuItem12 = new JMenuItem();
        jMenuItem13 = new JMenuItem();
        jMenuItem14 = new JMenuItem();
        jMenuItem15 = new JMenuItem();
        jMenuItem16 = new JMenuItem();
        jMenuItem17 = new JMenuItem();
        jMenuItem18 = new JMenuItem();
        jMenuItem19 = new JMenuItem();
        jMenuItem20 = new JMenuItem();
        jMenuItem21 = new JMenuItem();
        jMenuItem23 = new JMenuItem();
        savesMenu = new JMenu();
        jMenu1 = new JMenu();
        jMenuItem7 = new JMenuItem();
        jMenuItem11 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem22 = new JMenuItem();
        jMenuItem24 = new JMenuItem();
        desktopPane = new BackWindow();

        //======== this ========
        setDefaultCloseOperation(3);
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //======== fileMenu ========
            {
                fileMenu.setMnemonic(102);
                fileMenu.setText("App");

                //---- openMenuItem ----
                openMenuItem.setMnemonic(111);
                openMenuItem.setLabel("New Quran");
                openMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        openMenuItemActionPerformed(e);
                    }
                });
                fileMenu.add(openMenuItem);

                //---- jMenuItem1 ----
                jMenuItem1.setText("DirectTweet");
                jMenuItem1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem1ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem1);

                //---- jMenuItem2 ----
                jMenuItem2.setText("LaTEX");
                jMenuItem2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem2ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem2);

                //---- jMenuItem3 ----
                jMenuItem3.setText("Sliders");
                jMenuItem3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem3ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem3);

                //---- jMenuItem4 ----
                jMenuItem4.setText("RegExer");
                jMenuItem4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem4ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem4);

                //---- jMenuItem5 ----
                jMenuItem5.setText("ArrayGen");
                jMenuItem5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem5ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem5);

                //---- jMenuItem6 ----
                jMenuItem6.setText("Generate QR");
                jMenuItem6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem6ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem6);

                //---- jMenuItem8 ----
                jMenuItem8.setText("LindenGUI");
                jMenuItem8.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem8ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem8);

                //---- jMenuItem9 ----
                jMenuItem9.setText("MemoryMon");
                jMenuItem9.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem9ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem9);

                //---- jMenuItem10 ----
                jMenuItem10.setText("C64Text");
                jMenuItem10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem10ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem10);

                //---- jMenuItem12 ----
                jMenuItem12.setText("BASIC");
                jMenuItem12.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem12ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem12);

                //---- jMenuItem13 ----
                jMenuItem13.setText("Warper");
                jMenuItem13.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem13ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem13);

                //---- jMenuItem14 ----
                jMenuItem14.setText("Hadith");
                jMenuItem14.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem14ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem14);

                //---- jMenuItem15 ----
                jMenuItem15.setText("TwitterTimeline");
                jMenuItem15.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem15ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem15);

                //---- jMenuItem16 ----
                jMenuItem16.setText("Diskpart");
                jMenuItem16.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem16ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem16);

                //---- jMenuItem17 ----
                jMenuItem17.setText("Webserver");
                jMenuItem17.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem17ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem17);

                //---- jMenuItem18 ----
                jMenuItem18.setText("Magnifier");
                jMenuItem18.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem18ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem18);

                //---- jMenuItem19 ----
                jMenuItem19.setText("Rdesktop");
                jMenuItem19.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem19ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem19);

                //---- jMenuItem20 ----
                jMenuItem20.setText("Transformer");
                jMenuItem20.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem20ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem20);

                //---- jMenuItem21 ----
                jMenuItem21.setText("FTPServer");
                jMenuItem21.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem21ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem21);

                //---- jMenuItem23 ----
                jMenuItem23.setText("numconv.NumberConverter");
                jMenuItem23.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem23ActionPerformed(e);
                    }
                });
                fileMenu.add(jMenuItem23);
            }
            menuBar.add(fileMenu);

            //======== savesMenu ========
            {
                savesMenu.setText("Saves");
            }
            menuBar.add(savesMenu);

            //======== jMenu1 ========
            {
                jMenu1.setText("Window");
                jMenu1.setHorizontalAlignment(0);

                //---- jMenuItem7 ----
                jMenuItem7.setText("Arrange");
                jMenuItem7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem7ActionPerformed(e);
                    }
                });
                jMenu1.add(jMenuItem7);

                //---- jMenuItem11 ----
                jMenuItem11.setText("Close All");
                jMenuItem11.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem11ActionPerformed(e);
                    }
                });
                jMenu1.add(jMenuItem11);
            }
            menuBar.add(jMenu1);

            //======== jMenu2 ========
            {
                jMenu2.setText("Tools");

                //---- jMenuItem22 ----
                jMenuItem22.setText("DebugOut");
                jMenuItem22.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem22ActionPerformed(e);
                    }
                });
                jMenu2.add(jMenuItem22);

                //---- jMenuItem24 ----
                jMenuItem24.setText("Clock");
                jMenuItem24.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem24ActionPerformed(e);
                    }
                });
                jMenu2.add(jMenuItem24);
            }
            menuBar.add(jMenu2);
        }
        setJMenuBar(menuBar);

        //======== desktopPane ========
        {
            desktopPane.setDoubleBuffered(true);
            desktopPane.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < desktopPane.getComponentCount(); i++) {
                    Rectangle bounds = desktopPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = desktopPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                desktopPane.setMinimumSize(preferredSize);
                desktopPane.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, desktopPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(desktopPane, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openMenuItem;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    private JMenuItem jMenuItem10;
    private JMenuItem jMenuItem12;
    private JMenuItem jMenuItem13;
    private JMenuItem jMenuItem14;
    private JMenuItem jMenuItem15;
    private JMenuItem jMenuItem16;
    private JMenuItem jMenuItem17;
    private JMenuItem jMenuItem18;
    private JMenuItem jMenuItem19;
    private JMenuItem jMenuItem20;
    private JMenuItem jMenuItem21;
    private JMenuItem jMenuItem23;
    private JMenu savesMenu;
    private JMenu jMenu1;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem11;
    private JMenu jMenu2;
    private JMenuItem jMenuItem22;
    private JMenuItem jMenuItem24;
    private JDesktopPane desktopPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
