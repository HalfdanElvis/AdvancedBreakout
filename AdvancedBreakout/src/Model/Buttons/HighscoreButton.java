package Model.Buttons;

import Main.GameStart;
import Main.SceneManager;
import javafx.scene.control.Button;

public class HighscoreButton extends Button{
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;


    public HighscoreButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()-250;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonHeight = GameStart.getSceneHeight()*0.75/9;
        setText("Highscore");
        getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        setPrefSize(buttonWidth, buttonHeight);
        setLayoutX(buttonX);
        setLayoutY(buttonY);
        setOnAction(event -> SceneManager.getInstance().switchToHighscoreView());

    }

}
