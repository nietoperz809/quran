package mixit;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:19
 * To change this template use File | Settings | File Templates.
 */
class AdjRGB implements AdjustmentListener
{
    private final ControlPanel s;

    AdjRGB (ControlPanel ps)
    {
        s = ps;
    }

    public void setRGB (int r, int g, int b)
    {
        s.s.r.setValue (r);
        s.s.g.setValue (g);
        s.s.b.setValue (b);
        setFriendsRGB (r, g, b);
    }

    private void setFriendsRGB (int r, int g, int b)
    {
        s.e.colorChanged (r, g, b);

        float[] hsv = new float[3];
        Color.RGBtoHSB (r, g, b, hsv);
        r = (int) ((float) Constants.MULTI * hsv[0]);
        g = (int) ((float) Constants.MULTI * hsv[1]);
        b = (int) ((float) Constants.MULTI * hsv[2]);

        s.friend.s.r.setValue (r);
        s.friend.s.g.setValue (g);
        s.friend.s.b.setValue (b);

        s.friend.e.colorChanged (r, g, b);
    }

    public void adjustmentValueChanged (AdjustmentEvent e)
    {
        int r = s.s.r.getValue ();
        int g = s.s.g.getValue ();
        int b = s.s.b.getValue ();
        setFriendsRGB (r, g, b);
    }
}
