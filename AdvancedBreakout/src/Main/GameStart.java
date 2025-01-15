package Main;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameStart extends Application{
    private static int sceneWidth = 800;
    private static int sceneHeight = 800;

    @Override
    public void start(Stage stage) {

        SceneManager.initializeInstance(stage);

        SceneManager.getInstance().switchToMainMenuView();
    }

    public static int getSceneWidth() { return sceneWidth; }
    public static int getSceneHeight() { return sceneHeight; }

    public static void main(String[] args) {
        launch(args);
    }
}
