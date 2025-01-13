package View;
import Model.*;
import Controller.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class GameView{
    private int rows = 6;
    private int columns = 8;
    private int level = 1;
    private Group group;
    private Scene gameView;
    private Platform platform;
    private Ball ball;
    private ArrayList<Block> blockList;

    public GameView (int sceneWidth, int sceneHeight, Runnable deathEvent){
        setupObjects();
        gameView = new Scene(group, sceneWidth, sceneHeight);
        gameView.setFill(Color.BLACK);
        setupKeyEvents();

        GameController.startGameplay(ball, blockList, platform, group, deathEvent);
    }

    public void setupObjects() {
        platform = new Platform();
        ball = new Ball(platform);
        group = new Group(platform.getRectangle(), ball.getCircle());

        
        blockList = Model.GenerateBlocks.generateBlocks(level,rows, columns);
        for (int i = 0; i < blockList.size(); i++){
            group.getChildren().add(blockList.get(i).getRectangle());
        }
    }

    public void setupKeyEvents() {
        gameView.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                GameController.leftPressed(platform);
            } else if (event.getCode() == KeyCode.RIGHT) {
                GameController.rightPressed(platform);
            } else if (event.getCode() == KeyCode.SPACE) {
                GameController.spacePressed();
            }
        });

        gameView.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                platform.setMovingLeft(false);
            } else if (event.getCode() == KeyCode.RIGHT) {
                platform.setMovingRight(false);
            }
        });
    }

    public Scene getScene() {

        return gameView;
    }

    public Platform getPlatform() {
        return platform;
    }

    
}
