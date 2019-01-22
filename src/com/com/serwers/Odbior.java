package com.com.serwers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Odbior extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run() {
        try{
            //tworzenie strumienia danych pobieranych z gniazda sieciowego
            BufferedReader inp;
            inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));

            //komunikacja - czytanie danych ze strumienia
            String str;
            str=inp.readLine();
            System.out.println("<Nadeszlo:> " + str);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}