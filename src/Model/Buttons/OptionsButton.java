package Model.Buttons;

import Controller.SceneController;
import javafx.scene.control.Button;

public class OptionsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button optionsButton;
    


    public OptionsButton(Runnable buttonEvent) {
        buttonX = SceneController.getSceneWidth()/3;
        buttonY = SceneController.getSceneHeight()-150;
        buttonWidth = SceneController.getSceneWidth()/3;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
        optionsButton = new Button("Options");
        optionsButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        optionsButton.setPrefSize(buttonWidth, buttonHeight);
        optionsButton.setLayoutX(buttonX);
        optionsButton.setLayoutY(buttonY);
        optionsButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return optionsButton;
    }

}
