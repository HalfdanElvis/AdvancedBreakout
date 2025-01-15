package Model.Buttons;

import Main.GameStart;
import javafx.scene.control.Button;

public class ExitButton extends Button{
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public ExitButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()-100;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        setText("Exit");
        getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        setPrefSize(buttonWidth, buttonHeight);
        setLayoutX(buttonX);
        setLayoutY(buttonY);
        setOnAction(event -> System.exit(0));
    }

}
