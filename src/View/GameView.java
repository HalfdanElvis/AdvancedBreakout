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

public class GameView extends Application{
    
    Group group;
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
        stage.setTitle("BREAKOUT");
        Platform platform = new Platform();
        Ball ball = new Ball(platform);
        group = new Group(platform.getRectangle(), ball.getCircle());

        int rows = 6;
        int columns = 8;
        if (getParameters().getRaw().size() >= 2) {
            rows = GameController.getRows(getParameters().getRaw().get(0));
            columns = GameController.getColumns(getParameters().getRaw().get(1));
        }

        ArrayList<Rectangle> blockList = Model.GenerateBlocks.generateBlocks(rows, columns);
        group.getChildren().addAll(blockList);

        Scene scene = new Scene(group, sceneWidth, sceneHeight);
        scene.setFill(Color.BLACK);

        GameController.startGameplay(ball, blockList, platform, group);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                GameController.leftPressed(platform);
            } else if (event.getCode() == KeyCode.RIGHT) {
                GameController.rightPressed(platform);
            } else if (event.getCode() == KeyCode.SPACE) {
                GameController.spacePressed();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                platform.setMovingLeft(false);
            } else if (event.getCode() == KeyCode.RIGHT) {
                platform.setMovingRight(false);
            }
        });  
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void startGame(String[] args) {
        launch(args);
    }
}
