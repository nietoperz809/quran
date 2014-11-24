package mixit;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:37
 * To change this template use File | Settings | File Templates.
 */
class WinCloser extends WindowAdapter
{
    @Override
    public void windowClosing (WindowEvent e)
    {
        Window window = e.getWindow ();
        window.dispose ();
    }
}
