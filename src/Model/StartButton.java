package Model;

import View.GameView;
import javafx.scene.control.Button;

public class StartButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public StartButton() {
        buttonX = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*8/9;
        buttonWidth = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*0.75/9;
        Button startButton = new Button();
        startButton.setPrefSize(buttonWidth, buttonHeight);
        startButton.setLayoutX(buttonX);
        startButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.switchToGameView();
    }

}
