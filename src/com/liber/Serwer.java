package com.liber;
import java.io.*;
import java.net.*;

public class Serwer
{
    public static final int PORT=50007;

    public static void main(String args[]) throws IOException
    {
        //tworzenie gniazda serwerowego
        ServerSocket serv;
        serv=new ServerSocket(PORT);
        String endProtocol = "shutdown";
        String str = "";

        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: "+serv);
        Socket sock;
        sock=serv.accept();
        System.out.println("Jest polaczenie: "+sock);


        //tworzenie strumienia danych pobieranych z gniazda sieciowego
        BufferedReader inp;
        inp=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());
        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));

        while(!endProtocol.equals(str)) {
            //komunikacja - czytanie danych ze strumienia
            str = inp.readLine();
            System.out.println("<Nadeszlo:> " + str);

            System.out.print("<Wysylamy:> ");
            str=klaw.readLine();
            outp.println(str);
            outp.flush();

        }

        //zamykanie polaczenia
        inp.close();
        sock.close();
        serv.close();
    }
}