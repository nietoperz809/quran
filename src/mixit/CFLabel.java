package mixit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:24
 * To change this template use File | Settings | File Templates.
 */
class CFLabel extends Label
{
    ColorField f;

    CFLabel (String txt)
    {
        super (txt);
        setBackground (Color.LIGHT_GRAY);
        setFont (new Font ("Arial", Font.BOLD, 10));
        addMouseListener (new MouseAdapter()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                CFLabel.this.f.ma.mouseClicked (null);
            }
        }
        );
    }
}
