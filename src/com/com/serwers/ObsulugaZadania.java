package com.com.serwers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class ObslugaZadania extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    ObslugaZadania(Socket klientSocket) throws IOException {
        this.sock = klientSocket;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

    }

    public void run()
    {
        try{
            //tworzenie strumienia danych pobieranych z gniazda sieciowego
            BufferedReader inp;
            inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));

            //komunikacja - czytanie danych ze strumienia
            String str;
            str=inp.readLine();
            System.out.println("<Nadeszlo:> " + str);
            System.out.println("od " +this.sock);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}