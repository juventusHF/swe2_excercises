package ch.juventus.sockets.client;


import ch.juventus.sockets.Person;
import ch.juventus.sockets.Request;

public class ClientExecutor {

    public static void main(String[] args) {
        Client addClient = createAddClient();
        Client removeClient = createRemoveClient();
        Client getByNameClient = createGetByNameClient();

        addClient.start();
        removeClient.start();
        getByNameClient.start();
    }

    private static Client createAddClient() {
        Request request = new Request(Request.Command.ADD);
        request.setPerson(new Person("Linda", "Krüger"));
        return new Client(request);
    }

    private static Client createRemoveClient() {
        Request request = new Request(Request.Command.REMOVE);
        request.setPerson(new Person("Claudio", "Hediger"));
        return new Client(request);
    }

    private static Client createGetByNameClient() {
        Request request = new Request(Request.Command.GET_BY_NAME);
        request.setNameQuery("Vitelli");
        return new Client(request);
    }
}
