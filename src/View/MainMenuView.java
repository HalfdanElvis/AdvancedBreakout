package View;
import Model.Buttons.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainMenuView{
    private Scene menuScene;
    private OptionsButton optionsButton;
    private StartButton startButton;
    private HighscoreButton highscoreButton;
    private ExitButton exitButton;

    public MainMenuView(int width, int height, Runnable startButtonEvent, Runnable optionsButtonEvent, Runnable highscoreButtonEvent) {

        // Create a buttons
        startButton = new StartButton(startButtonEvent);
        optionsButton = new OptionsButton(optionsButtonEvent);
        highscoreButton = new HighscoreButton(highscoreButtonEvent);
        exitButton = new ExitButton();

        Image image = new Image("\\Resources\\MainMenuBackground.png");
        ImageView bg = new ImageView(image);

        // Create the menu layout
        Group layout = new Group();
        layout.getChildren().add(bg);
        layout.getChildren().add(startButton.getButton());
        layout.getChildren().add(optionsButton.getButton());
        layout.getChildren().add(highscoreButton.getButton());
        layout.getChildren().add(exitButton.getButton());
       

        // Create and store the scene
        this.menuScene = new Scene(layout, width, height);
    }

    public Scene getScene() {
        return menuScene;
    }
}
