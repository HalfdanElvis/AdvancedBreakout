package Model.Buttons;

import Controller.SceneController;
import javafx.scene.control.Button;


public class StartButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button startButton;
    


    public StartButton(Runnable buttonEvent) {
        buttonX = SceneController.getSceneWidth()/3;
        buttonY = SceneController.getSceneHeight()-375;
        buttonWidth = SceneController.getSceneWidth()/3;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
        startButton = new Button("Start");
        startButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        startButton.setPrefSize(buttonWidth, buttonHeight);
        startButton.setLayoutX(buttonX);
        startButton.setLayoutY(buttonY);
        startButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return startButton;
    }

}
