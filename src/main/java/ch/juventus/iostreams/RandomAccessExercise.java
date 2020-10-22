package ch.juventus.iostreams;

import java.io.IOException;

public class RandomAccessExercise {

    public static void main(String[] args) throws IOException {
        MyReader reader = new MyReader();
        MyWriter writer = new MyWriter();

        reader.readAtPosition("src/main/resources/hello.txt", 4);
        writer.writeAtPosition("src/main/resources/randomAccessOut.txt", 5);
    }
}
