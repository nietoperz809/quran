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
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
    private ServerSocket server;
    private final WebServerGUI _gui;

    public Sockserver (int buffsz, int p, WebServerGUI gui)
    {
        port = p;
        buffSize = buffsz;
        _gui = gui;
        WebServerClient.executor.execute(this);
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
            haltClients();
            server = null;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    private static void haltClients() throws InterruptedException
    {
        WebServerClient.executor.shutdown();
        WebServerClient.executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
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
                new WebServerClient(buffSize, server.accept(), _gui);
            }
        }
        catch (IOException ex)
        {
            System.err.println("bye (socket closed)");
        }
    }
}
