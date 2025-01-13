package View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameStart extends Application{
    private static int sceneWidth = 800;
    private static int sceneHeight = 600;
    private GameView gameView;
    private MainMenuView mainMenuView;
    private OptionsView optionsView;
    private HighscoreView highscoreView;
    private Stage stage;

    

    public static double getSceneWidth() {
        return sceneWidth;
    }

    public static double getSceneHeight() {
        return sceneHeight;
    }

    public Stage getStage(){
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("BREAKOUT!");

        gameView = new GameView(sceneWidth, sceneHeight, () -> {
            
            stage.setScene(mainMenuView.getScene());
        });

        optionsView = new OptionsView(sceneWidth, sceneHeight, () -> {
            stage.setScene(mainMenuView.getScene());
        });

        highscoreView = new HighscoreView(sceneWidth, sceneHeight, () -> {
            stage.setScene(mainMenuView.getScene());
        });

        mainMenuView = new MainMenuView(sceneWidth, sceneHeight, () -> {
            
            stage.setScene(gameView.getScene());
        }, () -> {
            
            stage.setScene(optionsView.getScene());
        }, () -> {

            stage.setScene(highscoreView.getScene());
        });

        

        stage.setScene(mainMenuView.getScene());
        stage.show();

    };


    public static void main(String[] args) {
        launch(args);
    }
}
