package Model.Buttons;

import Main.*;
import javafx.scene.control.Button;

public class BackButton extends Button{
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;    

    public BackButton() {
        buttonY = GameStart.getSceneHeight()*8/9;
        buttonWidth = GameStart.getSceneHeight()*3/9;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        buttonX = GameStart.getSceneHeight()-buttonY-buttonHeight;
        setText("Back");
        getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        setPrefSize(buttonWidth, buttonHeight);
        setLayoutX(buttonX);
        setLayoutY(buttonY);
        setOnAction(event -> SceneManager.getInstance().switchToMainMenuView());
    }

}
