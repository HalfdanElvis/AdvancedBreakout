package Controller;
import java.util.ArrayList;

import Model.*;
import View.GameStart;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
public class GameController {
    static Timeline gameplay;
    static boolean gameRunning = false;

    public static void startGameplay(Ball ball, ArrayList<Block> blockList, Platform platform, Group group, Runnable deathEvent) {
        gameplay = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            //Stops the game if a player loses
            if (ball.getY() - ball.getRadius()*2 > GameStart.getSceneHeight()){
                gameplay.stop();
                deathEvent.run();
            }
            ball.updatePosition();
            platform.updatePosition();
            CollisionManager.checkBorderCollision(ball);
            CollisionManager.blockCollision(ball, blockList, group);
            CollisionManager.collisionWithPlatform(ball, platform);
    
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