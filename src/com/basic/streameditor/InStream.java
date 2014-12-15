/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.streameditor;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class InStream extends java.io.InputStream implements Serializable
{
    public static final long serialVersionUID = 1L;
    private final RingBuffer<Character> buffer;

    public InStream (RingBuffer b)
    {
        buffer = b;
    }

    @Override
    public int available()
    {
        return buffer.size();
    }
    
    @Override
    public int read() throws IOException
    {
        try
        {
            return buffer.remove();
        }
        catch (InterruptedException ex)
        {
            System.out.println(ex);
            return -1;
        }
    }
}
