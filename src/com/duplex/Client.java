package com.duplex;

import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT=80;
    public static final String HOST = "127.0.0.1";
    Socket sock;
    String exitCondition = "";

    void connect(){
        try {
            this.sock = new Socket(HOST, PORT);
            task();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void task() throws IOException
    {

        BufferedReader keyboard;
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;

        try {
            outp = new PrintWriter(sock.getOutputStream());
        } catch (Exception e){
            outp = new PrintWriter(System.out);
            System.out.println(e);
        }
        while(!exitCondition.equals("quit")){
            new Receive(sock).start();

            try{
                String message = keyboard.readLine();
                exitCondition = message;

                outp.println(message);
                outp.flush();

            } catch (Exception e){
                System.out.println(e);
            }
        }

        try {
            keyboard.close();
            outp.close();
            sock.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

