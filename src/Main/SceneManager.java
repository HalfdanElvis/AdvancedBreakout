package Main;

import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import View.*;

import java.io.IOException;

import Controller.*;
import Model.OptionsModel;

public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private Scene currentScene;

    // Sounds
    private MediaPlayer musicPlayer;
    private String musicFilePath;
    private AudioClip hit = new AudioClip(getClass().getResource("/Resources/hit.wav").toExternalForm());
    private AudioClip blockBreak = new AudioClip(getClass().getResource("/Resources/blockBreak.wav").toExternalForm());
    private AudioClip buttonPress = new AudioClip(getClass().getResource("/Resources/buttonPress.wav").toExternalForm());
    
    

    // Views
    private MainMenuView mainMenuView;
    private GameView gameView;
    private OptionsView optionsView;
    private PauseView pauseView;
    private HighscoreView highscoreView;

    // Controllers
    private GameController gameController;

    private SceneManager(Stage stage) {
        this.stage = stage;
    }

    // Singleton instance to get SceneManager
    public static SceneManager getInstance() {
        return instance;
    }

    public static void initializeInstance(Stage stage) {
        if (instance == null) {
            instance = new SceneManager(stage);
        }
    }

    // Switch to GameView
    public void switchToGameView() {
        gameView = new GameView();
        currentScene = new Scene(gameView, OptionsModel.getSceneWidth(), OptionsModel.getSceneHeight());
        gameController = new GameController(gameView, currentScene);  
        playMusic("/Resources/Judas.mp3");
        stage.setScene(currentScene);
        stage.show();
    }

    // Switch to MainMenuView
    public void switchToMainMenuView() {
        updateVolume();
        mainMenuView = new MainMenuView();
        currentScene = new Scene(mainMenuView, OptionsModel.getSceneWidth(), OptionsModel.getSceneHeight());
        playMusic("/Resources/mainMenuSong.mp3");
        stage.setScene(currentScene);
        stage.show();
    }

    public void levelUp() {
        gameView.newLevel();
        gameController.setGameRunning(false);
    }

    // Switch to OptionsView
    public void switchToOptionsView() {
        optionsView = new OptionsView();
        currentScene = new Scene(optionsView, OptionsModel.getSceneWidth(), OptionsModel.getSceneHeight());
        stage.setScene(currentScene);
        stage.show();
    }

    // Switch to PauseView
    public void switchToPauseView() {
        pauseView = new PauseView();
        currentScene = new Scene(pauseView, OptionsModel.getSceneWidth(), OptionsModel.getSceneHeight());
        stage.setScene(currentScene);
        stage.show();
    }

    // Switch to HighscoreView
    public void switchToHighscoreView() {
        highscoreView = new HighscoreView();
        currentScene = new Scene(highscoreView, OptionsModel.getSceneWidth(), OptionsModel.getSceneHeight());
        stage.setScene(currentScene);
        stage.show();
    }

    public void playMusic(String musicFilePath) {

        if (musicPlayer == null){
            this.musicFilePath = musicFilePath;
            Media media = new Media(getClass().getResource(musicFilePath).toExternalForm());
            musicPlayer = new MediaPlayer(media);
            musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            musicPlayer.setVolume(OptionsModel.getMusicVolume());
            musicPlayer.play();
        }

        if (musicPlayer != null){
            if (!(this.musicFilePath.equals(musicFilePath))) {
                this.musicFilePath = musicFilePath;
                stopMusic();
                Media media = new Media(getClass().getResource(musicFilePath).toExternalForm());
                musicPlayer = new MediaPlayer(media);
                musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                musicPlayer.setVolume(OptionsModel.getMusicVolume());
                musicPlayer.play();
            }
        }
    }

    public void updateVolume() {
        OptionsModel.setMusicVolume(OptionsView.getMusicVolume());
        OptionsModel.setSoundVolume(OptionsView.getSoundVolume());
        if (musicPlayer != null){
            musicPlayer.setVolume(OptionsModel.getMusicVolume());
        }
        try {
            OptionsModel.updateOptions();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        hit.setVolume(OptionsModel.getSoundVolume());
        blockBreak.setVolume(OptionsModel.getSoundVolume());
        buttonPress.setVolume(OptionsModel.getSoundVolume());
    }

    public void stopMusic() {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
    }

    public void playHitSFX() {
        hit.play();
    }

    public void playBlockBreakSFX(){
        blockBreak.play();
    }

    public void playbuttonPressSFX(){
        buttonPress.play();
    }

}
