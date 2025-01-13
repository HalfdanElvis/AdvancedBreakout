package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class StartButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button startButton;


    public StartButton(Runnable buttonEvent) {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()-200;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        startButton = new Button("Start Button");
        startButton.setPrefSize(buttonWidth, buttonHeight);
        startButton.setLayoutX(buttonX);
        startButton.setLayoutY(buttonY);
        startButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return startButton;
    }

}
