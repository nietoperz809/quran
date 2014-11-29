package mixit;

import applications.SlidersGUI;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:31
 * To change this template use File | Settings | File Templates.
 */
class EditPanel extends Panel
{
    private final ZeroText rd;
    private final ZeroText gd;
    private final ZeroText bd;
    private ZeroText rh;
    private ZeroText gh;
    private ZeroText bh;
    private final SlidersGUI sl;
    private static final int INT = 255;

    EditPanel (String a1, String a2, String a3, SlidersGUI sl)
    {
        this.sl = sl;

        setLayout (new GridLayout (3, 2));

        add (new ColorLabel (a1));
        add (rd = new ZeroText (a1));
        if ("R".equals (a1))
        {
            add (rh = new ZeroText (a1));
        }

        add (new ColorLabel (a2));
        add (gd = new ZeroText (a1));
        if ("R".equals (a1))
        {
            add (gh = new ZeroText (a1));
        }

        add (new ColorLabel (a3));
        add (bd = new ZeroText (a1));
        if ("R".equals (a1))
        {
            add (bh = new ZeroText (a1));
        }
    }

    public void colorChanged (int r, int g, int b)
    {
        if (null == rh)
        {
            rd.setText ("" + (float) r / (float) Constants.MULTI);
            gd.setText ("" + (float) g / (float) Constants.MULTI);
            bd.setText ("" + (float) b / (float) Constants.MULTI);
        }
        else
        {
            String h = Constants.HexStr (r) + Constants.HexStr (g) + Constants.HexStr (b);
            String h6 = h.toUpperCase ();
            int n = Constants.fromHex (h6);
            if (-1 == n)
            {
                int itemCount = sl.two.h.c.getItemCount ();
                sl.two.h.c.select (itemCount - 1);
            }
            else
            {
                sl.two.h.c.select (n >> 1);
            }
            String s6 = h.toUpperCase ();
            sl.two.h.html.setText (" #" + s6);

            rd.setText ("" + r);
            String s = Constants.HexStr (r);
            rh.setText ("0x" + s);

            gd.setText ("" + g);
            String s2 = Constants.HexStr (g);
            gh.setText ("0x" + s2);

            bd.setText ("" + b);
            String s3 = Constants.HexStr (b);
            bh.setText ("0x" + s3);

            if (null != sl.cb)
            {
                sl.cb.setBackground (new Color (r, g, b));
            }
        }

        try
        {
            Color c0 = sl.cb.p[0].field.getBackground ();
            Color c1 = sl.cb.p[1].field.getBackground ();
            Color c2 = sl.cb.p[2].field.getBackground ();

            int c0r = c0.getRed ();
            int c0g = c0.getGreen ();
            int c0b = c0.getBlue ();

            int c1r = c1.getRed ();
            int c1g = c1.getGreen ();
            int c1b = c1.getBlue ();

            int c2r = c2.getRed ();
            int c2g = c2.getGreen ();
            int c2b = c2.getBlue ();

            int a = Math.max (c0r, c1r);
            int ra = Math.max (a, c2r);
            int a2 = Math.max (c0g, c1g);
            int g2 = Math.max (a2, c2g);
            int a3 = Math.max (c0b, c1b);
            int b3 = Math.max (a3, c2b);
            Color c3 = new Color (ra, g2, b3);

            int a4 = Math.min (c0r, c1r);
            int r4 = Math.min (a4, c2r);
            int a5 = Math.min (c0g, c1g);
            int g5 = Math.min (a5, c2g);
            int a6 = Math.min (c0b, c1b);
            int b6 = Math.min (a6, c2b);
            Color c4 = new Color (r4, g5, b6);

            Color c5 = new Color ((c0r + c1r + c2r) / 3, (c0g + c1g + c2g) / 3, (c0b + c1b + c2b) / 3);

            int blue = c3.getBlue ();
            int green = c3.getGreen ();
            int red = c3.getRed ();
            Color c6 = new Color (EditPanel.INT - red, EditPanel.INT - green, INT - blue);
            int blue2 = c4.getBlue ();
            int green2 = c4.getGreen ();
            int red2 = c4.getRed ();
            Color c7 = new Color (INT - red2, INT - green2, INT - blue2);
            int blue3 = c5.getBlue ();
            int green3 = c5.getGreen ();
            int red3 = c5.getRed ();
            Color c8 = new Color (INT - red3, INT - green3, INT - blue3);

            sl.cb.p[3].field.setBackground (c3);
            sl.cb.p[4].field.setBackground (c4);
            sl.cb.p[5].field.setBackground (c5);
            sl.cb.p[6].field.setBackground (c6);
            sl.cb.p[7].field.setBackground (c7);
            sl.cb.p[8].field.setBackground (c8);

        }
        catch (Exception ex)
        {

        }
    }
}
