package com.duplex;

import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serv = new ServerSocket(80);

        while(true) {
            //przyjecie polaczenia
            System.out.println("Waiting for connection...");
            Socket sock = serv.accept();
            System.out.println("Listening..");

            TaskMenagment newUser = new TaskMenagment(sock);
            newUser.start();

        }
    }
}
