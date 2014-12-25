package mixit;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:17
 * To change this template use File | Settings | File Templates.
 */
class AdjHSV implements AdjustmentListener
{
    private final ControlPanel s;
    private static final int INT = 0xff;
    private static final int INT16 = 16;

    AdjHSV (ControlPanel ps)
    {
        super ();
        s = ps;
    }

    public void adjustmentValueChanged (AdjustmentEvent e)
    {
        float fr = (float) s.s.r.getValue () / (float) Constants.MULTI;
        float fg = (float) s.s.g.getValue () / (float) Constants.MULTI;
        float fb = (float) s.s.b.getValue () / (float) Constants.MULTI;

        int rgb = Color.HSBtoRGB (fr, fg, fb);
        int r = rgb >> INT16 & AdjHSV.INT;
        int g = rgb >> 8 & AdjHSV.INT;
        int b = rgb & AdjHSV.INT;

        int value = s.s.r.getValue ();
        int value2 = s.s.g.getValue ();
        int value3 = s.s.b.getValue ();
        s.e.colorChanged (value, value2, value3);

        s.friend.s.r.setValue (r);
        s.friend.s.g.setValue (g);
        s.friend.s.b.setValue (b);

        s.friend.e.colorChanged (r, g, b);
    }
}
