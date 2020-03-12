package ch.juventus.fx.option1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;


public class MyFxApp extends Application {

    public static final String PROJECT_PATH = "file:///C:/Users/Linda/Dev/Workspaces/2020/java_projects/swe2_exercises/";
    public static final String LAYOUT_PATH = "src/main/java/ch/juventus/fx/option1/myLayout.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyFxController controller = new MyFxController();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(PROJECT_PATH + LAYOUT_PATH));
        loader.setController(controller);
        GridPane grid = loader.load();
        primaryStage.setTitle("Option 1");
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
