package com.comunite;

import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        //nawiazanie polaczenia z serwerem
        Socket sock;
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);

        //tworzenie watka odbierajacego
        new Odbior(sock).start();

        //zamykanie polaczenia
        sock.close();
    }
}