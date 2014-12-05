/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import javax.swing.JInternalFrame;

/**
 *
 * @author Administrator
 */
public abstract class PittiFrame extends JInternalFrame
{
    abstract public void initAfterDeserialization();
}
