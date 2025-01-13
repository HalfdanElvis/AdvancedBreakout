import View.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameStart extends Application{
    private static int sceneWidth = 800;
    private static int sceneHeight = 600;
    

    public static double getSceneWidth() {
        return sceneWidth;
    }

    public static double getSceneHeight() {
        return sceneHeight;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BREAKOUT!");

        GameView gameView = new GameView(sceneWidth, sceneHeight);

        stage.setScene(gameView.getScene());

    };
    public static void main(String[] args) {
        launch(args);
    }
}
