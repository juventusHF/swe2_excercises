package ch.juventus.sockets.server;

import ch.juventus.sockets.Person;
import ch.juventus.sockets.PersonStore;
import ch.juventus.sockets.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

public class ClientHandler extends Thread {

    private final Socket client;
    private final PersonStore store;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ClientHandler(Socket socket) {
        this.client = socket;
        this.store = PersonStore.getInstance();
    }

    public void run() {
        try {
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            Request request;
            while((request = (Request) in.readObject()) != null) {
                if(Request.Command.ADD.equals(request.getCommand())) {
                    System.out.println("SERVER: handle add request");
                    handleAdd(request.getPerson());
                    out.writeObject("New person added.");
                }
                if(Request.Command.REMOVE.equals(request.getCommand())) {
                    System.out.println("SERVER: handle remove request");
                    handleRemove(request.getPerson());
                    out.writeObject("Person removed.");
                }
                if(Request.Command.GET_BY_NAME.equals(request.getCommand())) {
                    System.out.println("SERVER: handle get by name request");
                    Set<Person> matchingPeople = handleGetByName(request.getNameQuery());
                    out.writeObject(matchingPeople);
                }
                if(Request.Command.QUIT.equals(request.getCommand())) {
                    System.out.println("SERVER: handle quit request");
                    handleQuit();
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private void handleAdd(Person person) {
        System.out.println("SERVER: add person to store " + person.toString());
        store.addPerson(person);
    }

    private void handleRemove(Person person) {
        System.out.println("SERVER: remove person from store " + person.toString());
        store.removePerson(person);
    }

    private Set<Person> handleGetByName(String name) {
        System.out.println("SERVER: find people in store with name " + name);
        return store.getPeopleByLastName(name);
    }

    private void handleQuit() {
        System.out.println("SERVER: close connection");
        try {
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
