package mixit;

//import applications.ZeroText;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:34
 * To change this template use File | Settings | File Templates.
 */
class HtmlPanel extends Panel
{
    final Choice c;
    final ZeroText html;

    HtmlPanel (final HeadPanel two)
    {
        setLayout (new BorderLayout ());

        c = new Choice ();
        c.setBackground (Color.BLACK);
        c.setForeground (Constants.txcColor);
        for (int s = 0; s < Constants.html.length; s += 2)
        {
            c.add (Constants.html[s]);
        }
        c.add (" - - - -");
        c.addItemListener (new ItemListener()
        {
            public void itemStateChanged (ItemEvent e)
            {
                try
                {
                    int selectedIndex = c.getSelectedIndex ();
                    Color cl = Color.decode ("0x" + Constants.html[2 * selectedIndex + 1]);
                    int blue = cl.getBlue ();
                    int green = cl.getGreen ();
                    int red = cl.getRed ();
                    two.cp_rgb.adjrgb.setRGB (red, green, blue);
                }
                catch (Exception ex)
                {
                }
            }
        }
        );

        html = new ZeroText ("html");
        Label l = new Label ("HTML", Label.CENTER);
        l.setBackground (Color.LIGHT_GRAY);
        add ("North", l);
        add ("Center", html);
        add ("South", c);
    }
}
