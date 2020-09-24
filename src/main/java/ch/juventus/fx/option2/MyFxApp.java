package ch.juventus.fx.option2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MyFxApp extends Application {

    private final String STYLESHEET_PATH = "file:///C:/Users/lkrue/Dev/Workspaces/Juventus/2020HS/SWE2/swe2_excercises/src/main/java/ch/juventus/fx/styles/stylesheet.css";
    private Scene scene;
    private GridPane root;
    private ColumnConstraints col0, col1, col2;
    private HBox titleBox, actionBox;
    private Label title, name, actionOutput;
    private TextField nameInput;
    private Button submit;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initRootGrid();
        initColumns();
        addTitle();
        addNameInput();
        addSubmitButton();
        addActionOutput();
        initScene();
        primaryStage.setTitle("Option 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initRootGrid() {
        root = new GridPane();
        root.setPadding(new Insets(25, 25, 10, 25));
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setGridLinesVisible(false);
        root.getStyleClass().add("layout");
    }

    private void initColumns() {
        col0 = new ColumnConstraints();
        col0.setHgrow(Priority.ALWAYS);
        col0.setMinWidth(10);
        col0.setPercentWidth(20);
        col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setMinWidth(10);
        col1.setPercentWidth(40);
        col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        col2.setMinWidth(10);
        col2.setPercentWidth(40);
        root.getColumnConstraints().addAll(col0, col1, col2);
    }

    private void addTitle() {
        titleBox = new HBox();
        title = new Label("Hello world");
        titleBox.setAlignment(Pos.BASELINE_CENTER);
        titleBox.getStyleClass().add("header");
        titleBox.getChildren().add(title);
        root.add(titleBox, 0, 0, 3, 1);
    }

    private void addNameInput() {
        name = new Label("Name:");
        root.add(name, 0, 1, 1, 1);

        nameInput = new TextField();
        root.add(nameInput, 1, 1, 2, 1);
    }

    private void addSubmitButton() {
        actionBox = new HBox();
        actionBox.setAlignment(Pos.BASELINE_RIGHT);
        submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSubmit();
            }
        });
        actionBox.getChildren().add(submit);
        root.add(actionBox, 2, 2, 1, 1);
    }

    private void handleSubmit() {
        actionOutput.setText("Submit button pressed, name is " + nameInput.getText());
    }

    private void addActionOutput() {
        actionOutput = new Label();
        root.add(actionOutput, 0, 4, 3, 1);
    }

    private void initScene() {
        scene = new Scene(root, 400, 200);
        scene.getStylesheets().add(STYLESHEET_PATH);
    }
}
