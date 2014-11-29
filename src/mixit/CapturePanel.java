package mixit;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:23
 * To change this template use File | Settings | File Templates.
 */
public class CapturePanel extends Panel
{
    public CapturePanel (HeadPanel h)
    {
        Label l = new Label (
                " <--- Pixelgrabber: Hier klicken, Taste gedrückt halten und Maus über den Bildschirm bewegen"
        );
        setLayout (new FlowLayout (FlowLayout.LEFT));
        add (new CaptureField (h, l));
        setBackground (Color.LIGHT_GRAY);
        add (l);
    }
}
