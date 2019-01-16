package com.duplex;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

class TaskMenagment extends Thread
{
    Socket sock;
    public static ArrayList<Socket> usersList;

    TaskMenagment(Socket clientSocket) throws IOException {
        this.sock = clientSocket;
        this.usersList = new ArrayList<>();
    }

    public void addUser(Socket sock){
        this.usersList.add(sock);
    }

    public void run() {

        try {
            while (true) {
                BufferedReader inp;
                inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                String message = inp.readLine();
                System.out.println(message);

                PrintWriter outp;
                for (Socket user : usersList) {
                    try {
                        outp = new PrintWriter(user.getOutputStream());
                        outp.println(message);
                        outp.flush();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e + " w run");
        }
    }
}
