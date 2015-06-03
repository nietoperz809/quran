/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Administrator
 */
public class Sockserver 
{
    private static void startServer(int port) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(port);
        
        while (true)
        {
            Socket sock = serverSocket.accept();
            new Client (sock, "F:\\");
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        //pTest();
        startServer(80);
    }
}
