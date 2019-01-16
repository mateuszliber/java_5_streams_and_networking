package com.duplex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Receive extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Receive(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run() {
        try{
            String str = "";
            while(!str.equals("quit")) {
                str = sockReader.readLine();
                System.out.println("<Incoming message:> " + str);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

