package ch.juventus.sockets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonStore {

    private static PersonStore instance;

    private Set<Person> people;

    public static PersonStore getInstance() {
        if(instance == null) {
            instance = new PersonStore();
        }
        return instance;
    }

    private PersonStore() {
        people = new HashSet<>();
        people.add(new Person("Alan", "Benet"));
        people.add(new Person("David", "Bürgler"));
        people.add(new Person("Claudio", "Hediger"));
        people.add(new Person("Joel", "Iselin"));
        people.add(new Person("Roland", "Jaggi"));
        people.add(new Person("Michael", "Meier"));
        people.add(new Person("Gianmarco", "Vitelli"));
        people.add(new Person("Michael", "Wettstein"));
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(Person person) {
        people.remove(person);
    }

    public Set<Person> getPeopleByLastName(String lastName) {
        if (lastName == null) return Collections.emptySet();
        return people.stream()
                .filter(person -> person.getLastName().equals(lastName))
                .collect(Collectors.toSet());
    }
}
