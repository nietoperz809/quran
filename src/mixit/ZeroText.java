/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mixit;

import java.awt.Color;
import java.awt.TextField;

class ZeroText extends TextField
{
    ZeroText(String a)
    {
        if ("H".equals(a))
        {
            setText("0.0");
            setColumns(6);
        }
        else if ("html".equals(a))
        {
            setText("#000000");
        }
        else
        {
            setText("0");
            setColumns(2);
        }
        setEditable(false);
        setBackground(Color.BLACK);
        setForeground(Constants.txcColor);
    }
}