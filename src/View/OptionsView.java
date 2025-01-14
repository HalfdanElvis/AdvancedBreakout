package View;

import Model.Buttons.BackButton;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class OptionsView{
    private Scene optionsScene;

    public OptionsView(int width, int height, Runnable backButtonEvent) {
        // Create a button to start the game
        BackButton backButton = new BackButton(backButtonEvent);
        Image image = new Image("\\Resources\\MainMenuBackground.png");
        ImageView bg = new ImageView(image);


        // Create the menu layout
        Group layout = new Group();
        layout.getChildren().add(bg);
        layout.getChildren().add(backButton.getButton());

        // Create and store the scene
        this.optionsScene = new Scene(layout, width, height);
    }

    public Scene getScene() {
        return optionsScene;
    }
}
