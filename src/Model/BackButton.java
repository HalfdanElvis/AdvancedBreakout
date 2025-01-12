package Model;

import View.GameView;
import javafx.scene.control.Button;

public class BackButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public BackButton() {
        buttonX = GameView.getSceneWidth()*1/9;
        buttonY = GameView.getSceneHeight()*8/9;
        buttonWidth = GameView.getSceneHeight()*3/9;
        buttonY = GameView.getSceneHeight()*0.75/9;
        Button exitButton = new Button("Back Graphic needed");
        exitButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setLayoutX(buttonX);
        exitButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.switchToMenu();
    }

}
