package Model.Buttons;

import Main.SceneManager;
import Model.OptionsModel;
import View.OptionsView;
import javafx.scene.control.Button;

public class BackButton extends Button{
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;    

    public BackButton() {
        buttonY = OptionsModel.getSceneHeight()*8/9;
        buttonWidth = OptionsModel.getSceneHeight()*3/9;
        buttonHeight = OptionsModel.getSceneHeight()*0.75/9;
        buttonX = OptionsModel.getSceneHeight()-buttonY-buttonHeight;
        setText("Back");
        getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        setPrefSize(buttonWidth, buttonHeight);
        setLayoutX(buttonX);
        setLayoutY(buttonY);
        setOnAction(event -> {
            SceneManager.getInstance().playbuttonPressSFX();
            SceneManager.getInstance().switchToMainMenuView();
            
        });
    }

}
