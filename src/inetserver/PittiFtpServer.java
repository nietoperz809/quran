/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetserver;

import applications.FtpServerGUI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;
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
    private final FtpServer ftpServer;
    private FtpServerGUI _gui;
    private FtpletContext _fc;
    
    private class Pittilet implements Ftplet
    {
        @Override
        public void init(FtpletContext fc) throws FtpException
        {
            _fc = fc;
            System.out.println("ftp init: ");
        }

        @Override
        public void destroy()
        {
            System.out.println("ftp destroy");
        }

        @Override
        public FtpletResult beforeCommand(FtpSession fs, FtpRequest fr) throws FtpException, IOException
        {
            System.out.println("ftp before: "+fr.getCommand());
            return FtpletResult.DEFAULT;
        }

        @Override
        public FtpletResult afterCommand(FtpSession fs, FtpRequest fr, FtpReply fr1) throws FtpException, IOException
        {
            System.out.println("ftp after: "+fr.getCommand());
            _gui.showBytesTransmitted(_fc.getFtpStatistics().getTotalDownloadSize());
            return FtpletResult.DEFAULT;
        }

        @Override
        public FtpletResult onConnect(FtpSession fs) throws FtpException, IOException
        {
            System.out.println("ftp connect: "+fs.toString());
            return FtpletResult.DEFAULT;
        }

        @Override
        public FtpletResult onDisconnect(FtpSession fs) throws FtpException, IOException
        {
            System.out.println("ftp disconnect: "+fs.getSessionId());
            return FtpletResult.DEFAULT;
        }
    }
    
    /**
     * @param path
     * @param port
     */
    public PittiFtpServer (FtpServerGUI gui, String path, int port) 
    {
        _gui = gui;
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(port);
        
        //Ftplet ftplet = new Pittilet();
        Map<java.lang.String,Ftplet> ftpmap = new HashMap<>();
        ftpmap.put("ftp1", new Pittilet());
        ftpmap.put("ftp2", new Pittilet());
        ftpmap.put("ftp3", new Pittilet());
        ftpmap.put("ftp4", new Pittilet());
        serverFactory.setFtplets(ftpmap);
        
        //java.util.Map<java.lang.String,Ftplet> ftplets = serverFactory.getFtplets();
        //System.out.println(ftplets);
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
            System.out.println("init exception "+ex.getMessage());
            ftpServer = null;
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
            System.out.println("start exception "+ex.getMessage());
            return false;
        }
        return true;
    }
}
