package ch.juventus.fx.multiplestages.second;

import ch.juventus.fx.multiplestages.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecondFxController {

    private StageManager stageManager;

    public SecondFxController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    protected void loadFirstStage(ActionEvent event) {
        stageManager.loadFirstStage();
    }
}
