package quran;

import misc.HashmapSeeker;

import java.io.UnsupportedEncodingException;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Administrator on 4/26/2016.
 */
public class Seeker
{
    public static String[] seekAllQurans (String text)
    {
        ArrayList<String> all = new ArrayList<>();
        for (String file : Quran.m_files)
        {
            WeakReference<Quran> q = new WeakReference<>(new Quran(file));
            HashMap<String, String> map = q.get().getMap();
            HashmapSeeker seeker = new HashmapSeeker(map);
            try
            {
                Vector<String> res = seeker.seek1(text);
                for (String r : res)
                {
                    all.add(file+": "+r);
                }
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return all.toArray(new String[all.size()]);
    }
}
