package mixit;

import java.awt.*;

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
    private final String a;
    private static final int MAXIMUM = 256;

    ScrollPanel (String sa)
    {
        a = sa;
        setLayout (new GridLayout (3, 0));
        if ("R".equals (a))
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
