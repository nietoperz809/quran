/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetserver;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;

/**
 *
 * @author Administrator
 */
public class PittiFtpServer
{
    private FtpServer ftpServer;
    
    /**
     * @param path
     * @param port
     */
    public PittiFtpServer (String path, int port) 
    {
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(port);
        serverFactory.addListener("default", factory.createListener());
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());
        UserManager um = userManagerFactory.createUserManager();
        BaseUser user = new BaseUser();
        user.setName("admin");
        user.setPassword("admin");
        user.setEnabled(true);
        user.setHomeDirectory(path);
        try
        {
            um.save(user);
        }
        catch (FtpException ex)
        {
            Logger.getLogger(PittiFtpServer.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        serverFactory.setUserManager(um);
        ftpServer = serverFactory.createServer();
    }

    public boolean stop()
    {
        if (ftpServer == null)
            return false;
        ftpServer.stop();
        return true;
    }
  
    public boolean isRunning()
    {
        return !(ftpServer.isStopped() | ftpServer.isSuspended());
    }
    
    public boolean start()
    {
        try
        {
            ftpServer.start();
        }
        catch (Exception ex)
        {
            Logger.getLogger(PittiFtpServer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
