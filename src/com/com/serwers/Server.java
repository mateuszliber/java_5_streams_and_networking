package com.com.serwers;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server
{
    public static ArrayList<Thread> UsersList = new ArrayList<Thread>();

    public static void main(String[] args) throws IOException
    {

        ServerSocket serv = new ServerSocket(80);

        while(true)
        {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");

            try {
                Socket sock = serv.accept();
                Thread newThread = new ObslugaZadania(sock);
                newThread.start();
                UsersList.add(newThread);
            } catch(Exception noConnection) {
                System.out.println("Brak połaczenia");
            }


        }
    }
}
