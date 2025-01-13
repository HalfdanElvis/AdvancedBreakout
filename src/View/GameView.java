package View;
import Model.*;
import Model.Buttons.ExitButton;
import Controller.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
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
    private VBox deathWindow;

    public GameView (int sceneWidth, int sceneHeight, Runnable deathEvent){
        createDeathWindow(sceneWidth, sceneHeight, deathEvent);
        setupObjects();

        // Adds the objects to the Scene, important before setupKeyEvents();
        gameView = new Scene(group, sceneWidth, sceneHeight);
        gameView.setFill(Color.BLACK);

        setupKeyEvents();
        
        GameController.startGameplay(ball, blockList, platform, group, () -> {
            deathWindowShow();
        });
    }

    public void createDeathWindow(int sceneWidth, int sceneHeight, Runnable deathEvent) {
        Text deathMsg = new Text("You died. Try again?");
        deathMsg.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setPrefSize(SceneController.getSceneWidth()/3, SceneController.getSceneHeight()*0.75/9);
        mainMenuButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        mainMenuButton.setOnAction(event -> deathEvent.run());
        ExitButton exitButton = new ExitButton();
        deathWindow = new VBox(deathMsg, mainMenuButton, exitButton.getButton());
        deathWindow.setPrefSize(sceneWidth, sceneHeight);
        deathWindow.setStyle("-fx-background-color: rgba(0, 0, 0, 0.37);");
        deathWindow.setVisible(false);
        deathWindow.setAlignment(Pos.CENTER);

    }

    public void deathWindowShow() {
        deathWindow.setVisible(true);
    }

    public void setupObjects() {
        platform = new Platform();
        ball = new Ball(platform);
        group = new Group(platform.getRectangle(), ball.getCircle());
        blockList = Model.GenerateBlocks.generateBlocks(level,rows, columns);
        for (int i = 0; i < blockList.size(); i++){
            group.getChildren().add(blockList.get(i).getRectangle());
        }
        group.getChildren().add(deathWindow);
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
}
