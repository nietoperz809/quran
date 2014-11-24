package mixit;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:27
 * To change this template use File | Settings | File Templates.
 */
class ColorField extends Canvas
{
    private final Colorbox cp;
    private final CFLabel cf;

    ColorField (Colorbox colorbox, CFLabel cf)
    {
        this.cp = colorbox;
        this.cf = cf;
        setBackground (Color.BLACK);
        addMouseListener (ma);
    }

    final MouseAdapter ma = new MouseAdapter()
    {
        @Override
        public void mouseClicked (MouseEvent e)
        {
            cp.setSelected (ColorField.this);
            if (3 > cf.getText ().length ())
            {
                cf.setBackground (Color.YELLOW);
                cp.twopanel.setEnabled (true);
            }
            else
            {
                cf.setBackground (Color.RED);
                cp.twopanel.setEnabled (false);
            }
            if (null != cp.prev && !cp.prev.equals (cf))
            {
                cp.prev.setBackground (Color.LIGHT_GRAY);
            }
            cp.prev = cf;
        }
    };
}
