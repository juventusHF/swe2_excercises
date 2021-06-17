package ch.juventus.sockets.client;

import ch.juventus.sockets.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

   private final Request request;
   private Socket client;
   private ObjectInputStream in;
   private ObjectOutputStream out;

    public Client(Request request) {
        this.request = request;
    }

    public void start() {

        try {
            client = new Socket("127.0.0.1", 8888);
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());

            sendRequest(out);
            readResponse(in);
            sendQuitRequest(out);
            teardown();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
   }

    private void sendRequest(ObjectOutputStream out) throws IOException {
        System.out.println("CLIENT: send " + request.getCommand().name() + " request to server");
        out.writeObject(request);
    }

    private void readResponse(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("CLIENT: read response from server:");
        if(Request.Command.GET_BY_NAME.equals(request.getCommand())) {
            System.out.println(in.readObject());
        } else {
            System.out.println((String)in.readObject());
        }
    }

    private void sendQuitRequest(ObjectOutputStream out) throws IOException {
        System.out.println("CLIENT: send quit request to close connection");
        out.writeObject(new Request(Request.Command.QUIT));
    }

    private void teardown() throws IOException {
        out.close();
        in.close();
        client.close();
    }
}
