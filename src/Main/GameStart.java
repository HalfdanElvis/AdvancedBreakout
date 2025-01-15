package Main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GameStart extends Application{
    private static int sceneWidth = 800;
    private static int sceneHeight = 800;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sir Slime's Crazy Adventure");
        Image icon = new Image("/Resources/icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);

        SceneManager.initializeInstance(stage);

        SceneManager.getInstance().switchToMainMenuView();
    }

    public static int getSceneWidth() { return sceneWidth; }
    public static int getSceneHeight() { return sceneHeight; }

    public static void main(String[] args) {
        launch(args);
    }
}
