package applications;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JInternalFrame;
import monitor.MemoryMonitor;

/**
 * New Class.
 * User: Administrator
 * Date: 05.01.2009
 * Time: 22:46:57
 */
public class MemoryMonitorGUI extends JInternalFrame
{
    private class LocaWindowListener extends WindowAdapter
    {
        /**
         * The window is closing
         * @param e The window event that causes the action
         */
        @Override
        public void windowClosing(WindowEvent e)
        {
            mon.surf.stop();
            ((MemoryMonitorGUI)e.getSource()).dispose();
            m_instance = null;
        }
    }

    MemoryMonitor mon;
    static MemoryMonitorGUI m_instance = null;

    public MemoryMonitorGUI()
    {
        super();
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        
        //addWindowListener(new LocaWindowListener());
        mon = new MemoryMonitor();
        add (mon);
        setSize (600,200);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setTitle ("Memory Monitor");
        setLocation(x, y);
        setVisible (true);
        mon.surf.start();
        m_instance = this;
    }
}
