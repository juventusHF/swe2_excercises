package ch.juventus.iostreams;

import ch.juventus.object.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class MyReader {

    public void readFromTextFile(String filePath) throws IOException {
        Reader reader = new BufferedReader(new FileReader(filePath));

        int data = reader.read();
        while(data != -1){
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = reader.read();
        }

        reader.close();
    }

    public void readAtPosition(String filePath) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");

        file.seek(3);

        int data = file.read();
        while(data != -1){
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = file.read();
        }

        file.close();
    }

    public void readJson(String filePath) throws IOException, ParseException {
        Reader reader = new FileReader(filePath);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        System.out.println(jsonObject);

        String name = (String) jsonObject.get("name");
        System.out.println(name);

        long age = (Long) jsonObject.get("age");
        System.out.println(age);

        JSONArray messages = (JSONArray) jsonObject.get("messages");
        messages.forEach(msg -> System.out.println(msg));
    }

    public void deserializeObject(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));

        Person person = (Person) in.readObject();
        System.out.println(person);

        in.close();
    }
}
