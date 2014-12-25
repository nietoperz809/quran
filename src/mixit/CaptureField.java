package mixit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingUtilities;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 04.09.2008
 * Time: 00:48:20
 * To change this template use File | Settings | File Templates.
 */
class CaptureField extends Label implements Runnable
{
    private final HeadPanel h;
    private Robot r;
    private Color pc = Color.RED;
    private static final int INT = 11;
    private static final int MILLIS = 300;

    CaptureField (HeadPanel hp, Label l)
    {
        super (" ");
        h = hp;
        setBackground (Color.GREEN);
        try
        {
            r = new Robot ();
            addMouseMotionListener (new MouseMotionAdapter()
            {
                public void mouseDragged (MouseEvent e)
                {
                    pc = Color.BLACK;
                    Point pt = e.getPoint ();
                    SwingUtilities.convertPointToScreen (pt, CaptureField.this);
                    Color c = r.getPixelColor (pt.x, pt.y);
                    int blue = c.getBlue ();
                    int green = c.getGreen ();
                    int red = c.getRed ();
                    h.cp_rgb.adjrgb.setRGB (red, green, blue);
                }
            }
            );
            Thread t = new Thread (this);
            t.setDaemon (true);
            t.start ();
        }
        catch (Exception ex)
        {
            setVisible (false);
            l.setBackground (Color.MAGENTA);
            l.setText ("Bullshit! Auf deinem System ist der Pixelgrabber leider nicht verfügbar...");
        }
    }

    public void run ()
    {
        while (true)
        {
            try
            {
                Thread.sleep ((long) CaptureField.MILLIS);
            }
            catch (Exception ex)
            {
            }
            if (pc.equals (Color.RED))
            {
                pc = Color.GREEN;
            }
            else
            {
                pc = Color.RED;
            }
            repaint ();
        }
    }

    @Override
    public void paint (Graphics g)
    {
        g.setColor (pc);
        int height = getHeight ();
        int width = getWidth ();
        g.fillRect (5, 5, width - CaptureField.INT, height - CaptureField.INT);
        g.setColor (Color.RED);
        int height2 = getHeight ();
        int width2 = getWidth ();
        g.drawRect (0, 0, width2 - 1, height2 - 1);
    }
}
