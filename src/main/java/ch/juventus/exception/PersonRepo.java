package ch.juventus.exception;

import ch.juventus.object.Person;

public class PersonRepo {

    public Person findById(int id) throws PersonNotFoundException {
        throw new PersonNotFoundException("Could not find person with id " + id);
    }

    public void addPerson(Person person) {
        throw new IllegalArgumentException("Invalid person");
    }
}
