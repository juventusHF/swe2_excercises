package ch.juventus.sockets.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("SERVER listening");
        while(true){
            new ClientHandler(server.accept()).start();
        }
    }

}
