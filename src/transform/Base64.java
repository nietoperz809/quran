/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transform;

/**
 *
 * @author Administrator
 */
public class Base64 implements Transformation
{
    @Override
    public String transform(String in)
    {
        return java.util.Base64.getEncoder().encodeToString(in.getBytes());
    }

    @Override
    public String retransform(String in)
    {
        byte[] barr = java.util.Base64.getDecoder().decode(in);
        return new String (barr);
    }
}
