package com.comunite;
import java.io.*;
import java.net.*;

public class Server
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

        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());
        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));

        while(!endProtocol.equals(str)) {
            new Odbior(sock).start();
            try {
                System.out.print("<Wysylamy:> \n");
                str = klaw.readLine();
                outp.println(str);
                outp.flush();
            } catch (Exception e){
                System.out.println(e);
            }
        }

        //zamykanie polaczenia
        serv.close();
        sock.close();
    }
}