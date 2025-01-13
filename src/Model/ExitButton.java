package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class ExitButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public ExitButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*8/9;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*0.75/9;
        Button exitButton = new Button();
        exitButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setLayoutX(buttonX);
        exitButton.setLayoutY(buttonY);
    }

    public void pressed() {
        System.exit(0);
    }

}
