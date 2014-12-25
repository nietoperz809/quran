package mixit;

import java.awt.Color;
import java.awt.Label;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:29
 * To change this template use File | Settings | File Templates.
 */
class ColorLabel extends Label
{
    ColorLabel (String a)
    {
        super (a, Label.CENTER);
        setBackground (Color.LIGHT_GRAY);
    }
}
