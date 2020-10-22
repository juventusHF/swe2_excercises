package ch.juventus.iostreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class NioExercises {

    public static void main(String[] args) throws IOException {
        createDirectory();
        createTextFile();
        renameTextFile();
        listContent();
        deleteAll();
    }

    private static void createDirectory() throws IOException {
        Path dir = Paths.get("src/main/resources/newDir");
        Files.createDirectory(dir);
        if(Files.exists(dir)) {
            System.out.println("New directory created");
        }
    }

    private static void createTextFile() throws IOException {
        Path file = Paths.get("src/main/resources/newDir/newFile.txt");
        Files.createFile(file);
        if(Files.exists(file)) {
            System.out.println("New file created");
        }
    }

    private static void renameTextFile() throws IOException {
        Path file = Paths.get("src/main/resources/newDir/newFile.txt");
        Path renamed = Paths.get("src/main/resources/newDir/renamedFile.txt");
        Files.move(file, renamed);
        if(Files.exists(renamed)) {
            System.out.println("Renamed file exists");
        }
    }

    private static void listContent() throws IOException {
        Path dir = Paths.get("src/main/resources/newDir");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
        System.out.println("Content:");
        for (Path path : directoryStream) {
            System.out.println(path.toString());
        }
    }

    private static void deleteAll() throws IOException {
        Path dir = Paths.get("src/main/resources/newDir");
        deleteDir(dir);
        System.out.println("All deleted!");
    }

    private static void deleteDir(Path dir) throws IOException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
        for (Path path : directoryStream) {
            if(Files.isDirectory(path)) {
                deleteDir(path);
            } else {
                Files.delete(path);
            }
        }
        Files.delete(dir);
    }
}
