/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetserver;

import applications.WebServerGUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Sockserver implements Runnable
{
    private final int port;
    private final int buffSize;
    private final String basePath;
    private ServerSocket server;
    private final WebServerGUI _gui;

//    public Sockserver(int p, String s)
//    {
//        basePath = s;
//        port = p;
//        Thread t = new Thread(this);
//        t.start();
//    }

    public Sockserver (int buffsz, int p, String s, WebServerGUI gui)
    {
        basePath = s;
        port = p;
        buffSize = buffsz;
        Thread t = new Thread(this);
        _gui = gui;
        t.start();
    }
    
    public boolean isRunning()
    {
        return server != null;
    }
    
    public void halt()
    {
        try
        {
            server.close();
            server = null;
        }
        catch (IOException ex)
        {
            Logger.getLogger(Sockserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run()
    {
        System.err.println("started: "+port);
        try
        {
            server = new ServerSocket(port, 100);

            while (true)
            {
                Socket sock = server.accept();
                new WebServerClient(buffSize, sock, basePath, _gui);
            }
        }
        catch (IOException ex)
        {
            System.err.println("bye (socket closed)");
        }
    }
}
