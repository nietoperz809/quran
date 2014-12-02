/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author Administrator
 */
public class ComboBoxTools
{
    public static void pollute (JComboBox box, String[] str)
    {
        box.setModel(new DefaultComboBoxModel(str));
    }

    public static String[] getAll (JComboBox box)
    {
        ComboBoxModel m = box.getModel();
        int size = m.getSize();
        String[] str = new String[size];
        for (int i=0; i<size; i++)
        {
            str[i] = (String)m.getElementAt(i);
        }
        return str;
    }
    
    public static void pollute (JList box, String[] str)
    {
        box.setModel(new AbstractListModel()
        {
            //String[] strings = res;
            @Override
            public int getSize() { return str.length; }
            @Override
            public Object getElementAt(int i) { return str[i]; }
        });    
    }
}
