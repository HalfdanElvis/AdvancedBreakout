package Model.Buttons;

import Controller.SceneController;
import javafx.scene.control.Button;

public class HighscoreButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button highscoreButton;


    public HighscoreButton(Runnable buttonEvent) {
        buttonX = SceneController.getSceneWidth()/3;
        buttonY = SceneController.getSceneHeight()-225;
        buttonWidth = SceneController.getSceneWidth()/3;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
        highscoreButton = new Button("Highscore");
        highscoreButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        highscoreButton.setPrefSize(buttonWidth, buttonHeight);
        highscoreButton.setLayoutX(buttonX);
        highscoreButton.setLayoutY(buttonY);
        highscoreButton.setOnAction(event -> buttonEvent.run());

    }

    public Button getButton() {
        return highscoreButton;
    }

}
