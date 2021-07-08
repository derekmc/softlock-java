
package io.github.derekmc.softlock;

import java.io.*;
import java.net.*;
import java.util.HashMap;

/*
public class Server{
}

public class ServerThread implements Runnable{
    Socket clientSocket;

    public ServerThread(Socket socket);
        clientSocket = socket;
    }
}
*/

public class Main{
    public static void main(String[] args){
        System.out.println();
        int port = 7500;
        System.out.println("Starting server on port " + port);

        BufferedReader in = null;
        PrintWriter out = null;
        String line = null;

        try{
            ServerSocket ss = new ServerSocket(port);
            Socket socket = ss.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while((line = in.readLine()) != null){
                out.println("You said: " + line);
                System.out.println("message=" + line);
            }

            in.close();
            socket.close();
            ss.close();

        } catch(Exception e){
            System.out.println(e);
        }
    }
}
