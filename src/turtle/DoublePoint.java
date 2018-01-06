package turtle;

import java.awt.*;

public class DoublePoint
{
    final Point Min;
    final Point Max;

    public DoublePoint ()
    {
        Min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public DoublePoint (DoublePoint src)
    {
        Min = new Point(src.Min);
        Max = new Point(src.Max);
    }

    @Override
    public String toString()
    {
        return "Min: " + Min + "/Max: " + Max;
    }

    void addPoint(Point pt)
    {
        if (pt.x < Min.x)
        {
            Min.x = pt.x;
        }
        if (pt.y < Min.y)
        {
            Min.y = pt.y;
        }
        if (pt.x > Max.x)
        {
            Max.x = pt.x;
        }
        if (pt.y > Max.y)
        {
            Max.y = pt.y;
        }
    }
}
