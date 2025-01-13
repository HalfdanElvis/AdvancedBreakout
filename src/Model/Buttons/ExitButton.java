package Model.Buttons;

import Controller.SceneController;
import javafx.scene.control.Button;

public class ExitButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    private Button exitButton;
    


    public ExitButton() {
        buttonX = SceneController.getSceneWidth()/3;
        buttonY = SceneController.getSceneHeight()-75;
        buttonWidth = SceneController.getSceneWidth()/3;
        buttonHeight = SceneController.getSceneHeight()*0.75/9;
        exitButton = new Button("Exit");
        exitButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        exitButton.setPrefSize(buttonWidth, buttonHeight);
        exitButton.setLayoutX(buttonX);
        exitButton.setLayoutY(buttonY);
        exitButton.setOnAction(event -> System.exit(0));
    }

    public Button getButton() {
        return exitButton;
    }
    

}
