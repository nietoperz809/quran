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
    private static final TreeSet<WebServerClient> _clients = new TreeSet<>();

    public Sockserver (int buffsz, int p, WebServerGUI gui)
    {
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
            haltClients();
            server = null;
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public static void removClient (WebServerClient ws)
    {
        _clients.remove(ws);
    }
    
    private static void haltClients()
    {
        Iterator<WebServerClient> it = _clients.iterator();
        
        while (it.hasNext())
        {
            WebServerClient ws = it.next();
            if (ws.isRunning())
            {
                ws.closeSocket();
            }
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
                WebServerClient ws = new WebServerClient(buffSize, sock, _gui);
                _clients.add(ws);
            }
        }
        catch (IOException ex)
        {
            System.err.println("bye (socket closed)");
        }
    }
}
