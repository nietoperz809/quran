package applications;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import monitor.MemoryMonitor;

/**
 * New Class.
 * User: Administrator
 * Date: 05.01.2009
 * Time: 22:46:57
 */
public class MemoryMonitorGUI extends JInternalFrame
{
    private class LocaWindowListener implements InternalFrameListener
    {
        @Override
        public void internalFrameOpened (InternalFrameEvent e)
        {

        }

        @Override
        public void internalFrameClosing (InternalFrameEvent e)
        {
            mon.surf.stop();
            ((MemoryMonitorGUI) e.getSource()).dispose();
        }

        @Override
        public void internalFrameClosed (InternalFrameEvent e)
        {
        }

        @Override
        public void internalFrameIconified (InternalFrameEvent e)
        {

        }

        @Override
        public void internalFrameDeiconified (InternalFrameEvent e)
        {

        }

        @Override
        public void internalFrameActivated (InternalFrameEvent e)
        {

        }

        @Override
        public void internalFrameDeactivated (InternalFrameEvent e)
        {

        }
    }

    private final MemoryMonitor mon;

    public MemoryMonitorGUI()
    {
        super();
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        
        this.addInternalFrameListener(new LocaWindowListener());
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
    }
}
