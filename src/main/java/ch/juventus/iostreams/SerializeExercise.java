package ch.juventus.iostreams;

import ch.juventus.object.Person;

import java.io.IOException;

public class SerializeExercise {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyReader reader = new MyReader();
        MyWriter writer = new MyWriter();

        Person person = new Person("Linda", "Krüger");
        writer.serializeObject(person, "src/main/resources/person.ser");
        reader.deserializeObject("src/main/resources/person.ser");
    }
}
