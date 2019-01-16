package com.duplex;

import java.io.*;
import java.net.*;

public class Klient
{
    private int PORT;
    private String HOST;

    Socket sock;

    Klient(int PORT, String HOST) {
        this.PORT = PORT;
        this.HOST = HOST;
    }

    void connect(){
        //nawiazanie polaczenia z serwerem
        try {
            this.sock = new Socket(HOST, PORT);
            System.out.println("Nawiazalem polaczenie: " + sock);
            messaging();
        }catch(Exception e){
            System.out.println("Połączenie zostało przerwane\n" + e);
        }
    }

    private void messaging() throws IOException{

        String exit ="";
        //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
        BufferedReader klaw= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;

        try {
            outp = new PrintWriter(sock.getOutputStream());
        }catch (Exception e){
            outp = new PrintWriter(System.out);
            System.out.println(e);
        }

        while(!exit.equals("exit")) {
            new Odbior(sock).start();
            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            System.out.print("<Wysylamy:> ");
            try {
                String str = klaw.readLine();
                exit = str;
                outp.println(str);
                outp.flush();
            }catch (SocketException e){
                System.out.println(e);
                break;
            }catch(IOException e){
                System.out.println(e);
            }

        }

        //zamykanie polaczenia
        try {
            klaw.close();
            outp.close();
            sock.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
