package ch.juventus.fx.multiplestages;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MyFxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        StageManager stageManager = StageManager.getInstance(primaryStage);
        stageManager.loadFirstStage();
    }
}
