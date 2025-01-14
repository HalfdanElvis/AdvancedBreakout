package Model.Buttons;

import Controller.SceneController;
import javafx.scene.control.Button;

public class BackButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button backButton;
    


    public BackButton(Runnable buttonEvent) {
        buttonY = SceneController.getSceneHeight()*8/9;
        buttonWidth = SceneController.getSceneHeight()*3/9;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
        buttonX = SceneController.getSceneHeight()-buttonY-buttonHeight;
        backButton = new Button("Back Button");
        backButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        backButton.setPrefSize(buttonWidth, buttonHeight);
        backButton.setLayoutX(buttonX);
        backButton.setLayoutY(buttonY);
        backButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return backButton;
    }

}
