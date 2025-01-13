package View;

import Model.Buttons.BackButton;
import javafx.scene.Group;
import javafx.scene.Scene;
public class OptionsView{
    private Scene optionsScene;

    public OptionsView(int width, int height, Runnable backButtonEvent) {
        // Create a button to start the game
        BackButton backButton = new BackButton(backButtonEvent);

        // Create the menu layout
        Group layout = new Group();
        layout.getChildren().add(backButton.getButton());

        // Create and store the scene
        this.optionsScene = new Scene(layout, width, height);
    }

    public Scene getScene() {
        return optionsScene;
    }
}
