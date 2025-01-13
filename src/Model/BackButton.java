package Model;

import Controller.SceneController;
import javafx.scene.control.Button;

public class BackButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button backButton;
    


    public BackButton(Runnable buttonEvent) {
        buttonX = SceneController.getSceneWidth()*1/9;
        buttonY = SceneController.getSceneHeight()*8/9;
        buttonWidth = SceneController.getSceneHeight()*3/9;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
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
