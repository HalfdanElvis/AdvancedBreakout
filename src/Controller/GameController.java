package Controller;
import java.util.ArrayList;

import Model.*;
import View.GameView;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
public class GameController {
    static Timeline gameplay;
    static boolean gameRunning = false;

    public static void startGameplay(Ball ball, ArrayList<Block> blockList, Platform platform, Group group, Runnable deathEvent) {
        gameplay = new Timeline(new KeyFrame(Duration.millis(8), e -> {
            //Stops the game if a player loses
            if (ball.getY() - ball.getRadius()*2 > SceneController.getSceneHeight()){
                gameplay.stop();
                gameRunning = false;
                deathEvent.run();
            }
            ball.updatePosition();
            platform.updatePosition();
            CollisionManager.checkBorderCollision(ball);
            CollisionManager.blockCollision(ball, blockList, group);
            CollisionManager.collisionWithPlatform(ball, platform);
            ball.setVelocity(ball.getVelocity()+(ball.getVelocity()*0.0001));
    
        }));
        gameplay.setCycleCount(Timeline.INDEFINITE);
    }

    public static void leftPressed(Platform platform) {
        platform.setMovingLeft(true);
    }

    public static void rightPressed(Platform platform) {
        platform.setMovingRight(true);
    }

    public static void spacePressed() {
        if (!gameRunning) {
            gameplay.play();  
            gameRunning = true;
        }
    }
}