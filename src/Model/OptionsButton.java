package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class OptionsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public OptionsButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*8/9;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*0.75/9;
        Button optionsButton = new Button();
        optionsButton.setPrefSize(buttonWidth, buttonHeight);
        optionsButton.setLayoutX(buttonX);
        optionsButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.switchToOptions();
    }

}
