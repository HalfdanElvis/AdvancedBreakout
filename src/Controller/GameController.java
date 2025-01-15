package Controller;

import Model.*;
import View.*;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
public class GameController {
    private GameView gameView;
    private Scene scene;
    static Timeline gameplay;
    static boolean gameRunning = false;

    public GameController(GameView gameView, Scene scene) {
        this.gameView = gameView;
        this.scene = scene;
        setupControls();
        startGameplay();
    }

    public void startGameplay() {
        gameplay = new Timeline(new KeyFrame(Duration.millis(8), e -> {
            update();
        }));
        gameplay.setCycleCount(Timeline.INDEFINITE);
    }

    public void update() {

        Ball ball = gameView.getBall();

        // checks for death
        if (ball.getY() - ball.getRadius()*2 > OptionsModel.getSceneHeight()){
            gameplay.stop();
            gameRunning = false;
            gameView.deathScreenShow();
        }

        // Updates ball and platform position
        ball.updatePosition();
        gameView.getPlatform().updatePosition();

        // Checks balls collisions
        CollisionManager.checkBorderCollision(ball);
        CollisionManager.blockCollision(ball, gameView.getBlockList(), gameView);
        CollisionManager.collisionWithPlatform(ball, gameView.getPlatform());

        // Increases ball speed
        ball.setVelocity(ball.getVelocity()+(ball.getVelocity()*0.0001));

    }

    public void setupControls() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                leftPressed();
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightPressed();
            } else if (event.getCode() == KeyCode.SPACE) {
                spacePressed();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                leftReleased();
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightReleased();
            }
        });
    }

    // KeyPresses
    public void leftPressed() { gameView.getPlatform().setMovingLeft(true); }
    public void rightPressed() { gameView.getPlatform().setMovingRight(true); }
    public void leftReleased() { gameView.getPlatform().setMovingLeft(false); }
    public void rightReleased() { gameView.getPlatform().setMovingRight(false); }
    public static void spacePressed() {
        if (!gameRunning) {
            gameplay.play();  
            gameRunning = true;
        }
    }

    // Maybe import collision Manger?
 

    

}