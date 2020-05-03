package ch.juventus.fx.multiplestages;

import ch.juventus.fx.multiplestages.first.FirstFxController;
import ch.juventus.fx.multiplestages.second.SecondFxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StageManager {

    private final String PROJECT_PATH = "file:///C:/Users/Linda/Dev/Workspaces/2020/java_projects/swe2_exercises/";
    private final String LAYOUT_PATH_FIRST = "src/main/java/ch/juventus/fx/multiplestages/first/firstLayout.fxml";
    private final String LAYOUT_PATH_SECOND = "src/main/java/ch/juventus/fx/multiplestages/second/secondLayout.fxml";

    private static StageManager instance;

    private Stage primaryStage;
    private Stage firstStage;
    private Stage secondStage;

    public static StageManager getInstance(Stage primaryStage) throws IOException {
        if(instance == null) {
            instance = new StageManager(primaryStage);
        }
        return instance;
    }

    private StageManager(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        setupFirstStage();
        setupSecondStage();
    }

    private void setupFirstStage() throws IOException {
        firstStage = new Stage();
        FirstFxController controller = new FirstFxController(this);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(PROJECT_PATH + LAYOUT_PATH_FIRST));
        loader.setController(controller);
        HBox root = loader.load();
        firstStage.setTitle("First Stage");
        firstStage.setX(200);
        firstStage.setY(200);
        Scene scene = new Scene(root, 400, 200);
        firstStage.setScene(scene);
    }

    private void setupSecondStage() throws IOException {
        secondStage = new Stage();
        SecondFxController controller = new SecondFxController(this);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(PROJECT_PATH + LAYOUT_PATH_SECOND));
        loader.setController(controller);
        HBox root = loader.load();
        secondStage.setTitle("Second Stage");
        secondStage.setX(250);
        secondStage.setY(250);
        Scene scene = new Scene(root, 400, 200);
        secondStage.setScene(scene);
    }

    public void loadFirstStage() {
        closeActiveStage();
        primaryStage = firstStage;
        primaryStage.show();
    }

    public void loadSecondStage() {
        closeActiveStage();
        primaryStage = secondStage;
        primaryStage.show();
    }

    private void closeActiveStage() {
        primaryStage.close();
    }
}
