package com.duplex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Odbior extends Thread {
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run(){

        try {
            String str = "";
            while (!str.equals("exit")) {
                str = sockReader.readLine();
                System.out.println("<Nadeszlo:> " + str);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
