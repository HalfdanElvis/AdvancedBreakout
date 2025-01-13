package View;
import Model.*;
import Controller.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.stage.Stage;

public class GameView{
    private int rows = 6;
    private int columns = 8;
    private Group group;
    private Scene gameScene;

    public GameView (int sceneWidth, int sceneHeight, Runnable deathEvent){
        Platform platform = new Platform();
        Ball ball = new Ball(platform);
        group = new Group(platform.getRectangle(), ball.getCircle());

        
        ArrayList<Rectangle> blockList = Model.GenerateBlocks.generateBlocks(rows, columns);
        group.getChildren().addAll(blockList);

        gameScene = new Scene(group, sceneWidth, sceneHeight);
        gameScene.setFill(Color.BLACK);

        GameController.startGameplay(ball, blockList, platform, group, deathEvent);

        // Set up keyevents for GameView
        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                GameController.leftPressed(platform);
            } else if (event.getCode() == KeyCode.RIGHT) {
                GameController.rightPressed(platform);
            } else if (event.getCode() == KeyCode.SPACE) {
                GameController.spacePressed();
            }
        });

        gameScene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                platform.setMovingLeft(false);
            } else if (event.getCode() == KeyCode.RIGHT) {
                platform.setMovingRight(false);
            }
        });
    }

    public Scene getScene() {
        return gameScene;
    }

    
}
