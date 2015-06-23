/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transform;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class UrlEncode implements Transformation
{

    @Override
    public String transform(String in)
    {
        try
        {
            return URLEncoder.encode (in, "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(UrlEncode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String retransform(String in)
    {
        try
        {
            return URLDecoder.decode (in, "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(UrlEncode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
