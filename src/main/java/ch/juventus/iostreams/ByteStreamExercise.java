package ch.juventus.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExercise {

    public static void main(String[] args) throws IOException {
        copy("src/main/resources/hello.txt", "src/main/resources/new.txt");
    }

    private static void copy(String from, String to) throws IOException {
        FileInputStream inputStream = new FileInputStream(from);
        FileOutputStream outputStream = new FileOutputStream(to);

        int b;
        while ((b = inputStream.read()) != -1 ) {
            outputStream.write(b);
        }
        inputStream.close();
        outputStream.close();
    }
}
