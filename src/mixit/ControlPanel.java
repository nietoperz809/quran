package mixit;

import applications.SlidersGUI;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:30
 * To change this template use File | Settings | File Templates.
 */
class ControlPanel extends Panel
{
    final EditPanel e;
    final ScrollPanel s;
    ControlPanel friend;
    final AdjRGB adjrgb;
    private final AdjHSV adjhsv;

    ControlPanel (String a1, String a2, String a3, SlidersGUI sl)
    {
        adjrgb = new AdjRGB (this);
        adjhsv = new AdjHSV (this);

        setLayout (new BorderLayout ());

        e = new EditPanel (a1, a2, a3, sl);
        s = new ScrollPanel (a1);

        if ("R".equals (a1))
        {
            s.r.addAdjustmentListener (adjrgb);
            s.g.addAdjustmentListener (adjrgb);
            s.b.addAdjustmentListener (adjrgb);
        }
        else
        {
            s.r.addAdjustmentListener (adjhsv);
            s.g.addAdjustmentListener (adjhsv);
            s.b.addAdjustmentListener (adjhsv);
        }

        add ("West", e);
        add ("Center", s);
    }
}
