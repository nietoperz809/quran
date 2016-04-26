package quran;

import misc.HashmapSeeker;

import java.io.UnsupportedEncodingException;
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
            Quran q = new Quran(file);
            HashMap<String, String> map = q.getMap();
            HashmapSeeker seeker = new HashmapSeeker(map);
            try
            {
                Vector<String> res = seeker.seek1(text);
                all.addAll (res);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return all.toArray(new String[all.size()]);
    }
}
