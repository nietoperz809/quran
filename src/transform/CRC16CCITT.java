/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transform;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CRC16CCITT implements Transformation
{
    @Override
    public String transform(String in)
    {
        try
        {
            int crc = 0xFFFF;          // initial value
            int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)
            
            byte[] bytes = in.getBytes("UTF-8");
            
            for (byte b : bytes)
            {
                for (int i = 0; i < 8; i++)
                {
                    boolean bit = ((b >> (7 - i) & 1) == 1);
                    boolean c15 = ((crc >> 15 & 1) == 1);
                    crc <<= 1;
                    if (c15 ^ bit)
                    {
                        crc ^= polynomial;
                    }
                }
            }
            crc &= 0xffff;
            return Integer.toHexString(crc);
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(CRC16CCITT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "oops?";
    }

    @Override
    public String retransform(String in)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
