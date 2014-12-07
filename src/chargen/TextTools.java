/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chargen;

import java.awt.Dimension;

/**
 *
 * @author Administrator
 */
public class TextTools
{
    private final String[] m_split;
    private final Dimension m_dim;
    private static final String SEPARATOR = "\n";

    /**
     * Constructor: takes text and does some pre-actions
     * @param s
     */
    public TextTools(String s)
    {
        m_split = s.split(SEPARATOR);
        m_dim = new Dimension(0, 0);
        for (String str : m_split)
        {
            if (str.length() > m_dim.width)
            {
                m_dim.width = str.length();
            }
            m_dim.height++;
        }
    }

    /**
     * Internal function to align strings
     * @param div 2 == align center, 1 == align right
     * @return
     */
    private String align(int div)
    {
        StringBuilder sb = new StringBuilder();
        for (String str : m_split)
        {
            int n = (m_dim.width - str.length()) / div;
            if (div == 1 && n == 3)
            {
                n = 2;
            }
            while (n-- > 0)
            {
                sb.append(' ');
            }
            sb.append(str);
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Center Text
     * @return
     */
    public String getCenteredText()
    {
        return align(2);
    }

    /**
     * Right align text
     * @return
     */
    public String getRightText()
    {
        return align(1);
    }

    /**
     * Get Text max x and y
     * @return
     */
    public Dimension getTextDimension()
    {
        return m_dim;
    }

    /**
     * Get Image dimension needed to display entire text
     * in 8*8 font
     * @return
     */
    public Dimension getImageDimension()
    {
        Dimension d2 = new Dimension(m_dim);
        d2.height *= 8;
        d2.width *= 8;
        d2.width += 10;
        d2.height += 10;
        return d2;
    }
}
