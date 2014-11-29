package mixit;

import applications.SlidersGUI;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:33
 * To change this template use File | Settings | File Templates.
 */
public class HeadPanel extends Panel
{
    final ControlPanel cp_rgb;
    private final ControlPanel cp_hsv;
    final HtmlPanel h;
    private static final int INT = 100;
    private static final double DOUBLE = 50.0;

    @Override
    public void setEnabled (boolean f)
    {
        if (!f)
        {
            setBackground (Color.BLACK);
        }
        else
        {
            setBackground (Color.RED);
        }
        cp_rgb.s.setEnabled (f);
        cp_hsv.s.setEnabled (f);
        h.c.setEnabled (f);
    }

    public HeadPanel (SlidersGUI sl)
    {
        cp_rgb = new ControlPanel ("R", "G", "B", sl);
        cp_hsv = new ControlPanel ("H", "S", "V", sl);
        cp_rgb.friend = cp_hsv;
        cp_hsv.friend = cp_rgb;
        h = new HtmlPanel (this);

        GridBagLayout g = new GridBagLayout ();
        setLayout (g);
        GridBagConstraints gc = new GridBagConstraints ();
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridheight = 1;
        gc.gridwidth = HeadPanel.INT;
        gc.gridx = GridBagConstraints.RELATIVE;
        gc.gridy = GridBagConstraints.RELATIVE;
        gc.insets = new Insets (1, 1, 1, 1);

        gc.weightx = 1.0;
        add (h);
        g.setConstraints (h, gc);

        gc.weightx = HeadPanel.DOUBLE;
        add (cp_rgb);
        g.setConstraints (cp_rgb, gc);

        add (cp_hsv);
        g.setConstraints (cp_hsv, gc);

        setBackground (Color.RED);
    }
}
