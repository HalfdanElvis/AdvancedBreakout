package Controller;
import View.GameView;
import View.HighscoreView;
import View.MainMenuView;
import View.OptionsView;
import javafx.application.Application;
import javafx.stage.Stage;

public class SceneController extends Application{
    private static int sceneWidth = 800;
    private static int sceneHeight = 800;
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
        this.stage = stage;
        stage.setTitle("BREAKOUT!");

        createGameScene();
        createOptionsScene();
        createHighscoreScene();
        createMainMenuScene();

        stage.setScene(mainMenuView.getScene());
        stage.setResizable(false);
        stage.show();

    };

    public void createGameScene() {
        gameView = new GameView(sceneWidth, sceneHeight, () -> {
            stage.setScene(mainMenuView.getScene());
        });
    }

    public void createOptionsScene() {
        optionsView = new OptionsView(sceneWidth, sceneHeight, () -> {
            stage.setScene(mainMenuView.getScene());
        });
    }

    public void createHighscoreScene() {
        highscoreView = new HighscoreView(sceneWidth, sceneHeight, () -> {
            stage.setScene(mainMenuView.getScene());
        });
    }

    public void createMainMenuScene() {
        mainMenuView = new MainMenuView(sceneWidth, sceneHeight, () -> {
            
            createGameScene();
            stage.setScene(gameView.getScene()); 
        }, () -> {
            
            stage.setScene(optionsView.getScene());
        }, () -> {

            stage.setScene(highscoreView.getScene());
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}
