package ch.juventus.fx.exercise1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Date;

public class MyFxController {

    @FXML
    private Label label;

    @FXML
    protected void onClick(ActionEvent event) {
        Date now = new Date();
        label.setText(now.toString());
    }
}
