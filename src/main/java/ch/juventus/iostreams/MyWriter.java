package ch.juventus.iostreams;

import ch.juventus.object.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class MyWriter {

    public void writeToTextFile(String filePath) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(filePath));

        StringBuffer outputText = new StringBuffer();
        outputText.append("Hello World!");
        outputText.append("\n");
        outputText.append("I am writing to an output file");

        writer.write(outputText.toString());

        writer.close();
    }

    public void writeAtPosition(String filePath, int position) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");

        file.seek(position);
        file.write("-huhu-".getBytes());

        file.close();
    }

    public void writeJson(String filePath) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name", "linda");
        obj.put("age", 27);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        Writer writer = new FileWriter(filePath);
        writer.write(obj.toJSONString());

        writer.close();
    }

    public void serializeObject(Person person, String filePath) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));

        out.writeObject(person);

        out.close();
    }
}
