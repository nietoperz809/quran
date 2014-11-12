/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittools;

import java.util.HashMap;
import java.util.Map;

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

        m_map.entrySet().stream().forEach((entry) -> 
        {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println (key + "|" + value);
        });
    }
}
