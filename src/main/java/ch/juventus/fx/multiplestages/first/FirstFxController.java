package ch.juventus.fx.multiplestages.first;

import ch.juventus.fx.multiplestages.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FirstFxController {

    private StageManager stageManager;

    public FirstFxController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    protected void loadSecondStage(ActionEvent event) {
        stageManager.loadSecondStage();
    }
}
