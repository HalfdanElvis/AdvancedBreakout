package Model.Buttons;

import Model.OptionsModel;
import Main.SceneManager;
import javafx.scene.control.Button;

public class OptionsButton extends Button{
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;


    public OptionsButton() {
        buttonX = OptionsModel.getSceneWidth()/3;
        buttonY = OptionsModel.getSceneHeight()*0.8;
        buttonWidth = OptionsModel.getSceneWidth()/3;
        buttonHeight = OptionsModel.getSceneHeight()*0.75/9;
        setText("Options");
        getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        setPrefSize(buttonWidth, buttonHeight);
        setLayoutX(buttonX);
        setLayoutY(buttonY);
        setOnAction(event -> {
            SceneManager.getInstance().playbuttonPressSFX();
            SceneManager.getInstance().switchToOptionsView();
        });
    }

}
