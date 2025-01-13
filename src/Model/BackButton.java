package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class BackButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button backButton;
    


    public BackButton(Runnable buttonEvent) {
        buttonX = GameStart.getSceneWidth()*1/9;
        buttonY = GameStart.getSceneHeight()*8/9;
        buttonWidth = GameStart.getSceneHeight()*3/9;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        backButton = new Button("Back Button");
        backButton.setPrefSize(buttonWidth, buttonHeight);
        backButton.setLayoutX(buttonX);
        backButton.setLayoutY(buttonY);
        backButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return backButton;
    }

}
