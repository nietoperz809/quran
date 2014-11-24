package mixit;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:28
 * To change this template use File | Settings | File Templates.
 */
class ColorFieldPanel extends Panel
{
    final ColorField field;
    private final CFLabel cf;

    ColorFieldPanel (Colorbox cb, String txt)
    {
        setLayout (new BorderLayout (1, 1));
        cf = new CFLabel (txt);
        add ("North", cf);
        field = new ColorField (cb, cf);
        cf.f = field;
        add ("Center", field);
    }

    public Insets getInsets ()
    {
        return new Insets (1, 1, 1, 1);
    }
}
