/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import java.awt.Point;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 *
 * @author Administrator
 */
public class DoublePoint
{
    private final Point Min;
    private final Point Max;

    public DoublePoint()
    {
        Min = new Point(MAX_VALUE, MAX_VALUE);
        Max = new Point(MIN_VALUE, MIN_VALUE);
    }

    public DoublePoint(DoublePoint src)
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
