/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

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
    int port;
    String basePath;
    ServerSocket server;
    
    public Sockserver (int p, String s)
    {
        port = p;
        basePath = s;
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
    
    public static void main(String[] args) throws Exception
    {
        Sockserver s = new Sockserver (80, "F:\\"); 
        Thread t = new Thread(s);
        t.start();
        Thread.sleep(3000);
        s.halt();
    }

    @Override
    public void run()
    {
        try
        {
            server = new ServerSocket(port);
            
            while (true)
            {
                Socket sock = server.accept();
                new Client (sock, basePath);
            }
        }
        catch (IOException ex)
        {
            System.err.println("bye (socket closed)");
        }
    }
}
