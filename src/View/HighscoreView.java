package View;

import Model.Buttons.BackButton;
import javafx.scene.Group;
import javafx.scene.Scene;

public class HighscoreView{
    private Scene highscoreScene;

    public HighscoreView(int width, int height, Runnable backButtonEvent) {
        // Create a button to start the game
        BackButton backButton = new BackButton(backButtonEvent);

        // Create the menu layout
        Group layout = new Group();
        layout.getChildren().add(backButton.getButton());

        // Create and store the scene
        highscoreScene = new Scene(layout, width, height);
    }

    public Scene getScene() {
        return highscoreScene;
    }
}
