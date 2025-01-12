package Model;

import View.GameView;
import javafx.scene.control.Button;

public class ExitButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public ExitButton() {
        buttonX = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*8/9;
        buttonWidth = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*0.75/9;
        Button exitButton = new Button();
        exitButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setLayoutX(buttonX);
        exitButton.setLayoutY(buttonY);
    }

    public void pressed() {
        System.exit(0);
    }

}
