package clock;

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import misc.Tools;

///////////////////////////////////////////////////////////////////
///////////////////// C L O C K ///////////////////////////////////
public class Clock extends JPanel implements Runnable
{
    private static final long serialVersionUID = 1L;
    // Farben
    Color m_secondcolor = new Color(255, 255, 0);
    Color m_minutecolor = new Color(255, 255, 255);
    Color m_hourcolor = new Color(255, 255, 255);
    Color m_framecolor = new Color(255, 255, 255);
    Color m_xorcolor = new Color(0, 0, 255);
    // FensterKoordinaten
    final int m_width = 78, m_height = 78, m_x2 = 39, m_y2 = 39;
    // Uhr
    int m_second = -1;
    int m_minute = -1;
    int m_hour = -1;
    int m_day = -1;
    // Letzte Position der Zeiger
    int m_lastsec = -1;
    int m_lastmin = -1;
    int m_lasthour = -1;
    int m_lastday = -1;
    // Bitmaps
    Image m_img, m_imgdays, m_imgthisday = null;

    BufferedImage imagebuffer = new BufferedImage (m_width, m_height, BufferedImage.TYPE_INT_ARGB);
    Graphics img_g = imagebuffer.createGraphics();
    
    public Clock(Image img, Image img2)
    {
        super();
        m_img = img;
        m_imgdays = img2;
        //this.setOpaque(true);
        //this.setDoubleBuffered(true);

        // draw clock face
        img_g.drawImage(m_img, 0, 0, this);
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);    
    }

    public Clock()
    {
        this (Tools.loadImageFromRessource("JOKE.GIF"),
              Tools.loadImageFromRessource("DAYS.GIF"));
    }
    
    // Berechnet den EndPunkt einer Geraden, deren StartPunkt der
    // MittelPunkt eines Kreises ist.
    // Eingabe:  xs,ys, -> der MittelPunkt
    //        	 rad -> Radius des Kreises
    //			 angle -> Winkel der Geraden
    private Point CirclePoint(int xs, int ys, int rad, int angle)
    {
        double len = (double) rad;
        double ang = (double) (angle - 90) / 180 * Math.PI;
        double x = len * Math.cos(ang);
        double y = len * Math.sin(ang);
        return new Point(xs + (int) x, ys + (int) y);
    }

    // Timer Tick 
    @Override
    public void run()
    {
        Graphics g = img_g;
        // Leave if g is currently not available
        GregorianCalendar cal = new GregorianCalendar();
        int sec = cal.get(GregorianCalendar.SECOND);
        int min = cal.get(GregorianCalendar.MINUTE);
        int hr = 5 * cal.get(GregorianCalendar.HOUR_OF_DAY) + min / 12;
        int day = cal.get(GregorianCalendar.DAY_OF_WEEK)-1;
        if (m_second != sec)
        {
            UpdateSecond(g, sec);
        }
        if (m_minute != min)
        {
            UpdateMinute(g, min);
        }
        if (m_hour != hr)
        {
            UpdateHour(g, hr);
        }
        if (day != m_day)
        {
            UpdateDay(g, day);
        }
        
        // to sreen
        getGraphics().drawImage(imagebuffer, 0, 0, getWidth(), getHeight(), this);
    }

    // Aktualisiert den SekundenZeiger
    private void UpdateSecond(Graphics g, int sec)
    {
        m_second = sec;
        if (m_lastsec >= 0)
        {
            DrawPointer(g, m_lastsec, 35, m_secondcolor);
        }
        m_lastsec = sec;
        DrawPointer(g, sec, 35, m_secondcolor);
    }

    // Aktualisiert den MinutenenZeiger
    private void UpdateMinute(Graphics g, int min)
    {
        m_minute = min;
        if (m_lastmin >= 0)
        {
            DrawPointer(g, m_lastmin, 34, m_minutecolor);
        }
        m_lastmin = min;
        DrawPointer(g, min, 34, m_minutecolor);
    }

    // Aktualisiert den StundenZeiger
    private void UpdateHour(Graphics g, int hour)
    {
        m_hour = hour;
        if (m_lasthour >= 0)
        {
            DrawPointer(g, m_lasthour, 23, m_hourcolor);
        }
        m_lasthour = hour;
        DrawPointer(g, hour, 23, m_hourcolor);
    }

    private void UpdateDay(Graphics g, int day)
    {
        m_day = day;
        if (m_lastday != m_day)
        {
            CropImageFilter crop = new CropImageFilter(day * 18, 0, 18, 8);
            FilteredImageSource fim = new FilteredImageSource(m_imgdays.getSource(), crop);
            m_imgthisday = createImage(fim);
            m_lastday = day;
        }
        if (m_imgthisday != null)
        {
            g.drawImage(m_imgthisday, m_x2 + 12, m_y2 - 4, this);
        }
    }

    // Malt einen Zeiger
    private void DrawPointer(Graphics g, int position, int len, Color col)
    {
        Point pt = CirclePoint(m_x2, m_y2, len, position * 6);
        Point pt2 = CirclePoint(m_x2, m_y2, 10, position * 6 + 180);
        g.setColor(col);
        g.setXORMode(m_xorcolor);
        g.drawLine(pt2.x, pt2.y, pt.x, pt.y);
        g.setPaintMode();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(m_width, m_height);
    }
}
