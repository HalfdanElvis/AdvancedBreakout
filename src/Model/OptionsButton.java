package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class OptionsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button optionsButton;
    


    public OptionsButton(Runnable buttonEvent) {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()-400;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        optionsButton = new Button("Options Button");
        optionsButton.setPrefSize(buttonWidth, buttonHeight);
        optionsButton.setLayoutX(buttonX);
        optionsButton.setLayoutY(buttonY);
        optionsButton.setOnAction(event -> buttonEvent.run());
    }

    public Button getButton() {
        return optionsButton;
    }

}
