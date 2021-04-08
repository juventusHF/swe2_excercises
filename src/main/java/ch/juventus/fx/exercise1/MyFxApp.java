package ch.juventus.fx.exercise1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;


public class MyFxApp extends Application {

    public static final String PROJECT_PATH = "file:///C:/Users/lkrue/Dev/Workspaces/Juventus/2020HS/SWE2/swe2_excercises/";
    public static final String LAYOUT_PATH = "src/main/java/ch/juventus/fx/exercise1/myLayout.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyFxController controller = new MyFxController();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL(PROJECT_PATH + LAYOUT_PATH));
        loader.setController(controller);
        VBox root = loader.load();
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Exercise1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
