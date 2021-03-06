package mixit;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Scrollbar;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:35
 * To change this template use File | Settings | File Templates.
 */
class ScrollPanel extends Panel
{
    final Scrollbar r;
    final Scrollbar g;
    final Scrollbar b;
    private static final int MAXIMUM = 256;

    ScrollPanel (String sa)
    {
        setLayout (new GridLayout (3, 0));
        if ("R".equals (sa))
        {
            add (r = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, ScrollPanel.MAXIMUM));
            add (g = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, ScrollPanel.MAXIMUM));
            add (b = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, ScrollPanel.MAXIMUM));
        }
        else
        {
            add (r = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, Constants.MULTI + 1));
            add (g = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, Constants.MULTI + 1));
            add (b = new Scrollbar (Scrollbar.HORIZONTAL, 0, 0, 0, Constants.MULTI + 1));
        }
    }
}
