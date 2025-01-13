package Model;

import View.GameView;
import javafx.scene.control.Button;

public class OptionsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public OptionsButton() {
        buttonX = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*8/9;
        buttonWidth = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*0.75/9;
        Button optionsButton = new Button();
        optionsButton.setPrefSize(buttonWidth, buttonHeight);
        optionsButton.setLayoutX(buttonX);
        optionsButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.switchToOptions();
    }

}
