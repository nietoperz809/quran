/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import net.propero.rdp.RdStarter;
import net.propero.rdp.RdpParamDialog;
import quran.QuranMetadata;

/**
 * $id:$
 * @author Administrator
 */
public class MainWindow extends javax.swing.JFrame
{
    private static MainWindow instance;

    /**
     * @return the instance
     */
    public static MainWindow getInstance()
    {
        return instance;
    }

    public final void initSavesMenu()
    {
        savesMenu.removeAll();
        List<String> saves = Tools.listSaves();
        saves.stream().forEach((s) ->
        {
            JMenuItem men = new JMenuItem(s);
            men.addActionListener((ActionEvent e) ->
            {
                try
                {
                    MDIChild obj = (MDIChild)Tools.deSerialize(s);
                    obj.initAfterDeserialization();
                    MainWindow.getInstance().addChild(obj);
                }
                catch (Exception ex)
                {
                    savesMenu.remove(men); // Remove damaged entry
                    Tools.deleteSave(s);    
                }
            });
            savesMenu.add(men);
        });
    }

    /**
     * Creates new form MDIApplication
     */
    public MainWindow()
    {
        instance = this;
        initComponents();
        this.setTitle(Tools.getBuildNumber());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initSavesMenu();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // menuBar.add(Box.createGlue()) added manually !!!!!!!!!!!!!!!
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        desktopPane = new BackWindow("allah.jpg");
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        savesMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setDoubleBuffered(true);
        desktopPane.setPreferredSize(new java.awt.Dimension(400, 400));

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setPreferredSize(new java.awt.Dimension(100, 21));

        fileMenu.setMnemonic('f');
        fileMenu.setText("App");

        openMenuItem.setMnemonic('o');
        openMenuItem.setLabel("New Quran");
        openMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        jMenuItem1.setText("DirectTweet");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setText("LaTEX");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem3.setText("Sliders");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);

        jMenuItem4.setText("RegExer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem4);

        jMenuItem5.setText("ArrayGen");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem5ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem5);

        jMenuItem6.setText("Generate QR");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem6ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem6);

        jMenuItem8.setText("LindenGUI");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem8ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem8);

        jMenuItem9.setText("MemoryMon");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem9ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem9);

        jMenuItem10.setText("C64Text");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem10ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem10);

        jMenuItem12.setText("BASIC");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem12ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem12);

        jMenuItem13.setText("Warper");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem13ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem13);

        jMenuItem14.setText("Hadith");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem14ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem14);

        jMenuItem15.setText("TwitterTimeline");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem15ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem15);

        jMenuItem16.setText("Diskpart");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem16ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem16);

        jMenuItem17.setText("Webserver");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem17ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem17);

        jMenuItem18.setText("Magnifier");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem18ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem18);

        jMenuItem19.setText("Rdesktop");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem19ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem19);

        jMenuItem20.setText("Transformer");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem20ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem20);

        jMenuItem21.setText("FTPServer");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem21ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem21);

        jMenuItem23.setText("NumberConverter");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem23ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem23);

        menuBar.add(fileMenu);

        savesMenu.setText("Saves");
        menuBar.add(savesMenu);

        jMenu1.setText("Window");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuItem7.setText("Arrange");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem11.setText("Close All");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        menuBar.add(Box.createGlue());

        menuBar.add(jMenu1);

        jMenu2.setText("Tools");

        jMenuItem22.setText("DebugOut");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem22);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addChild(JInternalFrame c)
    {
        desktopPane.add(c);
        Tools.centerComponent(c, desktopPane);
        c.moveToFront();
    }

    /**
     * Creates new MDI child from class name
     *
     * @param c Runtime class Must be of type JInternalFrame
     * @return New JInternalFrame or null on Error
     */
    public JInternalFrame createMDIChild(Class<?> c)
    {
        System.err.println("Starting app: "+c.getName());
        try
        {
            Constructor<?> cons = c.getConstructor();
            JInternalFrame q = (JInternalFrame) cons.newInstance();
            addChild(q);
            return q;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openMenuItemActionPerformed
    {//GEN-HEADEREND:event_openMenuItemActionPerformed
        createMDIChild(applications.QuranGUI.class);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
        createMDIChild(applications.DirectTweetGUI.class);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        createMDIChild(applications.LatexGUI.class);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
        createMDIChild(applications.SlidersGUI.class);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem4ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem4ActionPerformed
        createMDIChild(applications.RegExerGUI.class);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem5ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem5ActionPerformed
        createMDIChild(applications.ArrayGenGUI.class);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem6ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem6ActionPerformed
        createMDIChild(applications.QRGeneratorGUI.class);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * Arrange
     *
     * @param evt
     */
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem7ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem7ActionPerformed
        MDIActions.arrange(desktopPane);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem8ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem8ActionPerformed
        createMDIChild(applications.LindenGUI.class);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem9ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem9ActionPerformed
        createMDIChild (applications.MemoryMonitorGUI.class);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem10ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem10ActionPerformed
        createMDIChild (applications.C64TextGUI.class);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * Close all
     * @param evt 
     */
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem11ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem11ActionPerformed
        MDIActions.closeAll (desktopPane);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem12ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem12ActionPerformed
        createMDIChild (applications.BasicGUI.class);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem13ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem13ActionPerformed
        createMDIChild (applications.WarperGUI.class);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem14ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem14ActionPerformed
        createMDIChild (applications.HadithGUI.class);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem15ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem15ActionPerformed
        createMDIChild (applications.TimeLineGUI.class);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem16ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem16ActionPerformed
        createMDIChild (applications.DiskpartGui.class);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem17ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem17ActionPerformed
        createMDIChild (applications.WebServerGUI.class);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem18ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem18ActionPerformed
        createMDIChild (applications.MagnifyGUI.class);
    }//GEN-LAST:event_jMenuItem18ActionPerformed
    
    
    // Start RDesktop
    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem19ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem19ActionPerformed
        RdpParamDialog rp = new RdpParamDialog (this, true);
        rp.setVisible(true);
        rp.setVisible(false);
        //System.out.println(rp.getHost());
        RdStarter rdStart = new RdStarter(rp.getHost());
        rdStart.startWait();
        addChild(rdStart.getFrame());
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem20ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem20ActionPerformed
       createMDIChild (applications.Transformer.class);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem21ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem21ActionPerformed
       createMDIChild (applications.FtpServerGUI.class);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem22ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem22ActionPerformed
        createMDIChild (applications.ConsoleViewGUI.class);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem23ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem23ActionPerformed
        createMDIChild (applications.NumberConverter.class);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    /** m0xyzptlkxy0
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception
    {
        //System.exit(0);
        org.apache.log4j.BasicConfigurator.configure();
        QuranMetadata.get();

        /* Set the look and feel */
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenu savesMenu;
    // End of variables declaration//GEN-END:variables

}
