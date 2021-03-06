/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class HashmapSeeker
{
    private final HashMap<String, String> m_map;
    
    public HashmapSeeker (HashMap<String, String> m)
    {
        m_map = m;
    }

    public Vector<String> seek1 (String what) throws UnsupportedEncodingException
    {
        System.err.println("seeking for raw: "+what);
        final String low = what.toLowerCase();
        System.err.println("seeking for: "+low);
        Vector<String> result = new Vector<>();
        //Vector<String> result = new Vector<>();

        m_map.entrySet().stream().forEach((entry) ->
        {
            String key = entry.getKey();
            //System.out.println(entry.getKey()+"---"+entry.getValue());
            String value = entry.getValue().toLowerCase();
            if (value.contains(low))
                result.add(key);
        });
        System.err.println("Found: "+result.size());

        Collections.sort(result, (String s1, String s2) -> s1.compareTo(s2));
        return result;
    }

    public String[] seek (String what) throws UnsupportedEncodingException
    {
        Vector<String> v = seek1 (what);
        return v.toArray(new String[v.size()]);
    }
}
