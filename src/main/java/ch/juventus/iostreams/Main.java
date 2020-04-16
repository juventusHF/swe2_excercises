package ch.juventus.iostreams;

import ch.juventus.object.Person;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    private static String PATH_WORKSPACE = "C:\\Users\\Linda\\Dev\\Workspaces\\2020\\java_projects\\swe2_exercises\\";
    private static String PATH_PACKAGE = "src\\main\\java\\ch\\juventus\\iostreams\\";

    public static void main(String[] args) {
        // Use FileReader and FileWriter
        readText();
        writeText();
        // Use RandomAccessFile
        readTextFromPosition();
        writeTextAtPosition();
        // File operations
        runFileExercise();
        // Work with Json files
        writeJson();
        readJson();
        // Serialize java object
        serializePerson();
        deserializePerson();
    }

    private static void readText() {
        MyReader myReader = new MyReader();
        // Relative paths can be used like this (relative from your project folder):
        String myFile = PATH_PACKAGE + "inputFile.txt";
        try {
            myReader.readFromTextFile(myFile);
        } catch (IOException e) {
            System.err.println("Error while reading from file:");
            e.printStackTrace();
        }
    }

    private static void readTextFromPosition() {
        MyReader myReader = new MyReader();
        // This is an absolute path:
        String myFile = PATH_WORKSPACE + PATH_PACKAGE + "inputFile.txt";
        try {
            myReader.readAtPosition(myFile);
        } catch (IOException e) {
            System.err.println("Error while reading from file:");
            e.printStackTrace();
        }
    }

    private static void writeText() {
        MyWriter myWriter = new MyWriter();
        String myFile = PATH_PACKAGE + "outputFile.txt";
        try {
            myWriter.writeToTextFile(myFile);
        } catch (IOException e) {
            System.err.println("Error while writing to file:");
            e.printStackTrace();
        }
    }

    private static void writeTextAtPosition() {
        MyWriter myWriter = new MyWriter();
        String myFile = PATH_PACKAGE + "outputFile.txt";
        try {
            myWriter.writeAtPosition(myFile);
        } catch (IOException e) {
            System.err.println("Error while writing to file:");
            e.printStackTrace();
        }
    }

    private static void runFileExercise() {
        FileExercises fileExercises = new FileExercises();
        fileExercises.run();
    }

    private static void writeJson() {
        MyWriter myWriter = new MyWriter();
        String myFile = PATH_PACKAGE + "jsonFile.json";
        try {
            myWriter.writeJson(myFile);
        } catch (IOException e) {
            System.err.println("Error while writing to json file:");
            e.printStackTrace();
        }
    }

    private static void readJson() {
        MyReader myReader = new MyReader();
        String myFile = PATH_PACKAGE + "jsonFile.json";
        try {
            myReader.readJson(myFile);
        } catch (IOException e) {
            System.err.println("Error while reading from json file:");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Error while parsing json file:");
            e.printStackTrace();
        }
    }

    private static void serializePerson() {
        MyWriter myWriter = new MyWriter();
        Person person = new Person("Linda", "Krüger");
        String myFile = PATH_PACKAGE + "person.ser";

        try {
            myWriter.serializeObject(person, myFile);
        } catch (IOException e) {
            System.err.println("Error serializing person into file:");
            e.printStackTrace();
        }
    }

    private static void deserializePerson() {
        MyReader myReader = new MyReader();
        String myFile = PATH_PACKAGE + "person.ser";
        try {
            myReader.deserializeObject(myFile);
        } catch (IOException e) {
            System.err.println("Error deserializing person from file:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error while casting to person:");
            e.printStackTrace();
        }
    }
}
