/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.io.Serializable;
import javax.swing.JInternalFrame;

/**
 *
 * @author Administrator
 */
public abstract class MDIChild extends JInternalFrame implements Serializable
{
    public static final long serialVersionUID = 1L;
    /**
     * Implement the Deserialisation "Constructor"
     */
    abstract public void initAfterDeserialization();
    
    @Override
    public void dispose()
    {
        super.dispose(); 
        System.err.println("Disposing "+this.getClass().getName());
    }
}
