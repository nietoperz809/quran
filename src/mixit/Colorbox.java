package mixit;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:25
 * To change this template use File | Settings | File Templates.
 */
public class Colorbox extends Panel
{
    private ColorField selected;
    final HeadPanel twopanel;
    CFLabel prev;

    final ColorFieldPanel[] p = {new ColorFieldPanel (this, "C0"), new ColorFieldPanel (this, "C1"),
            new ColorFieldPanel (this, "C2"), new ColorFieldPanel (this, "C3 = max (C0,C1,C2)"),
            new ColorFieldPanel (this, "C4 = min (C0,C1,C2)"), new ColorFieldPanel (this, "C5 = avg (C0,C1,C2)"),
            new ColorFieldPanel (this, "C6 = not (C3)"), new ColorFieldPanel (this, "C7 = not (C4)"),
            new ColorFieldPanel (this, "C8 = not (C5)")};

    /**
     *
     * @param twopanel
     */
    public Colorbox (HeadPanel twopanel)
    {
        this.twopanel = twopanel;
        setLayout (new GridLayout (0, 3));
        for (ColorFieldPanel p1 : p)
        {
            add(p1);
        }
        p[0].field.ma.mouseClicked (null);
    }

    @Override
    public void setBackground (Color c)
    {
        selected.setBackground (c);
    }

    public void setSelected (ColorField s)
    {
        selected = s;
        Color c = s.getBackground ();
        int blue = c.getBlue ();
        int green = c.getGreen ();
        int red = c.getRed ();
        twopanel.cp_rgb.adjrgb.setRGB (red, green, blue);
    }
}
