/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.propero.rdp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class RdStarter
{
    private Rdesktop _rd;

    public RdesktopFrame getFrame()
    {
        if (_rd == null)
            return null;
        return _rd.getFrame();
    }
    
    public void startWait()
    {
        start();
        while (_rd.getFrame() == null)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(RdStarter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void start()
    {
        try
        {
            _rd = new Rdesktop();
            new Thread(() ->
            {
                try
                {
                    _rd.startup(null);
                }
                catch (OrderException | RdesktopException ex)
                {
                    Logger.getLogger(RdStarter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        }
        catch (OrderException | RdesktopException ex)
        {
            Logger.getLogger(RdStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
