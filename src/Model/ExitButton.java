package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class ExitButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button exitButton;
    


    public ExitButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()-50;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*0.75/9;
        exitButton = new Button("Exit");
        exitButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setLayoutX(buttonX);
        exitButton.setLayoutY(buttonY);
        exitButton.setOnAction(event -> System.exit(0));
    }

    public Button getButton() {
        return exitButton;
    }
    

}
