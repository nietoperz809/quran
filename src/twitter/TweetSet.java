/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import twitter4j.Status;

class MyComp implements Comparator<Status>
{
    @Override
    public int compare(Status o1, Status o2)
    {
        Long i1 = o1.getCreatedAt().getTime();
        Long i2 = o2.getCreatedAt().getTime();
        return i2.compareTo(i1);
    }
}

/**
 *
 * @author Administrator
 */
public class TweetSet extends TreeSet<Status>
{
    private final int _max;

    public TweetSet(int max)
    {
        super(new MyComp());
        _max = max;
    }

    @Override
    public synchronized boolean add(Status e)
    {
        if (this.size() == _max)
        {
            if (e.getCreatedAt().getTime() > this.last().getCreatedAt().getTime())
            {
                this.pollLast();
            }
            else
            {
                return false;
            }
        }
        return super.add(e);
    }

    @Override
    public synchronized Iterator iterator()
    {
        return super.iterator();
    }
}
