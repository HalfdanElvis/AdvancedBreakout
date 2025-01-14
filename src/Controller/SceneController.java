package Controller;

import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneController extends Application{
    private static SceneController instance;
    private static int sceneWidth = 800;
    private static int sceneHeight = 800;
    private GameView gameView;
    private MainMenuView mainMenuView;
    private OptionsView optionsView;
    private HighscoreView highscoreView;
    private Stage stage;
    private MediaPlayer songPlayer;
    private Media mainMenuSong = new Media(getClass().getResource("/Resources/mainMenuSong.mp3").toExternalForm());
    private Media gameplaySong = new Media(getClass().getResource("/Resources/Judas.mp3").toExternalForm());

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("Sir Slime's Crazy Adventure");
        Image icon = new Image("\\Resources\\icon.png");
        stage.getIcons().add(icon);
        
        createGameScene();
        createOptionsScene();
        createHighscoreScene();
        createMainMenuScene();

        stage.setScene(mainMenuView.getScene());
        stage.setResizable(false);
        stage.show();        
    };

    public void setSong(Media song) {
        if (songPlayer != null){
            this.songPlayer.stop();
        }
        songPlayer = new MediaPlayer(song);
        songPlayer.setVolume(0.1);
        songPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
              songPlayer.seek(Duration.ZERO);
            }
        });
        songPlayer.play();
    }

    public MediaPlayer getSongPlayer() {
        return songPlayer;
    }

    public void stopSong() {
        this.songPlayer.stop();
    }

    public void createGameScene() {
        this.gameView = new GameView(sceneWidth, sceneHeight, () -> {
            stopSong();
            stage.setScene(mainMenuView.getScene());
            setSong(mainMenuSong);
        }, () -> {
            stopSong();
            createGameScene();
            stage.setScene(gameView.getScene());
        });
    }

    public void createOptionsScene() {
        this.optionsView = new OptionsView(sceneWidth, sceneHeight, () -> {

            stage.setScene(mainMenuView.getScene());
        });
    }

    public void createHighscoreScene() {
        this.highscoreView = new HighscoreView(sceneWidth, sceneHeight, () -> {
            
            stage.setScene(mainMenuView.getScene());
        });
    }

    public void createMainMenuScene() {
        this.mainMenuView = new MainMenuView(sceneWidth, sceneHeight, () -> {
            
            createGameScene();
            stage.setScene(gameView.getScene()); 
            stopSong();
            setSong(gameplaySong);
        }, () -> {
            
            stage.setScene(optionsView.getScene());
        }, () -> {

            stage.setScene(highscoreView.getScene());
        });
        setSong(mainMenuSong);
    }

    public static double getSceneWidth() {
        return sceneWidth;
    }

    public static double getSceneHeight() {
        return sceneHeight;
    }

    public Stage getStage(){
        return stage;
    }

    public void switchToGameScene() {
        stage.setScene(gameView.getScene());
    }
    
    public void switchToOptionsScene() {
        stage.setScene(optionsView.getScene());
    }

    public void switchToHighscoreScene() {
        stage.setScene(highscoreView.getScene());
    }

    public void switchToMainMenuScene() {
        stage.setScene(mainMenuView.getScene());
    }

    public void switchScene(Scene scene) {
        stage.setScene(scene);
    }

    public GameView getGameView() {
        return gameView;
    }

    public static SceneController getInstance() {
        if (instance == null) {
            instance = new SceneController();
        }
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
