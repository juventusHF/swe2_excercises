package ch.juventus.iostreams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileExercises {

    public static void main(String[] args) {
        createDirectory();
        createTextFile();
        renameTextFile();
        listContent();
        deleteAll();
    }

    private static void createDirectory() {
        File file = new File("src/main/resources/newDir");
        boolean created = file.mkdir();
        if(created) {
            System.out.println("New directory created");
        }
    }

    private static void createTextFile() {
        File file = new File("src/main/resources/newDir/newFile.txt");
        boolean created = false;
        try {
            created = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(created) {
            System.out.println("New file created");
        }
    }

    private static void renameTextFile() {
        File file = new File("src/main/resources/newDir/newFile.txt");
        File renamed = new File("src/main/resources/newDir/renamedFile.txt");
        boolean success = file.renameTo(renamed);
        if(success) {
            System.out.println("Successfully renamed file");
        }
        if(renamed.exists()) {
            System.out.println("Renamed file exists");
        }
    }

    private static void listContent() {
        File file = new File("src/main/resources/newDir");
        List<String> filenames = Arrays.asList(file.list());
        System.out.println("Content:");
        filenames.forEach(name -> System.out.println(name));
    }

    private static void deleteAll() {
        File dir = new File("src/main/resources/newDir");
        deleteDir(dir);
        System.out.println("All deleted!");
    }

    private static boolean deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files != null){
            for(File file : files){
                if(file.isDirectory()){
                    deleteDir(file);
                } else {
                    file.delete();
                }
            }
        }
        return dir.delete();
    }
}
