package ch.juventus.iostreams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileExercises {

    private static final String BASE_PATH = "C:\\Users\\Linda\\Dev\\";
    private static final String FOLDER_NAME = "FileExercise\\";
    private static final String FILE_NAME = "myNewFile.txt";

    public void run() {
        createDirectory();
        createTextFile();
        renameTextFile();
        listContent();
        deleteAll();
    }

    private void createDirectory() {
        File file = new File(BASE_PATH + FOLDER_NAME);
        boolean created = file.mkdirs();
        if(created) {
            System.out.println("New directory created");
        }
    }

    private void createTextFile() {
        File file = new File(BASE_PATH + FOLDER_NAME + FILE_NAME);
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

    private void renameTextFile() {
        File file = new File(BASE_PATH + FOLDER_NAME + FILE_NAME);
        File renamed = new File(BASE_PATH + FOLDER_NAME + "\\myRenamedFile.txt");
        boolean success = file.renameTo(renamed);
        if(success) {
            System.out.println("Successfully renamed file");
        }
        if(renamed.exists()) {
            System.out.println("Renamed file exists");
        }
    }

    private void listContent() {
        File file = new File(BASE_PATH + FOLDER_NAME);
        List<String> filenames = Arrays.asList(file.list());
        System.out.println("Content:");
        filenames.forEach(name -> System.out.println(name));
    }

    private void deleteAll() {
        File dir = new File(BASE_PATH + FOLDER_NAME);
        deleteDir(dir);
        System.out.println("All deleted!");
    }

    private boolean deleteDir(File dir){
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
