package ch.juventus.sockets;

import java.io.Serializable;

public class Request implements Serializable {

    public enum Command {ADD, REMOVE, GET_BY_NAME, QUIT};

    private Command command;
    private Person person;
    private String nameQuery;

    public Request(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
    }
}
