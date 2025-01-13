package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class StartButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public StartButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*8/9;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*0.75/9;
        Button startButton = new Button();
        startButton.setPrefSize(buttonWidth, buttonHeight);
        startButton.setLayoutX(buttonX);
        startButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.switchToGameView();
    }

}
