package View;
import Model.*;
import Model.Buttons.*;
import Main.SceneManager;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;


public class GameView extends Pane{
    private Player player;
    private Platform platform;
    private Ball ball;
    private ArrayList<Block> blockList;
    private VBox deathScreen;
    private double sceneWidth = OptionsModel.getSceneWidth();
    private double sceneHeight = OptionsModel.getSceneHeight();


    private int rows = 6;
    private int columns = 8;
    private int level = 1;
    
    
    

    public GameView (){
        player = new Player();
        setupObjects(sceneWidth, sceneHeight);
    }

    public void initializeDeathScreen(double sceneWidth, double sceneHeight) {
        Text deathMsg = new Text("You died. Try again?");
        deathMsg.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()*0.75/9);
        mainMenuButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        mainMenuButton.setOnAction(event -> SceneManager.getInstance().switchToMainMenuView());

        ExitButton exitButton = new ExitButton();

        Button newGameButton = new Button("New Game");
        newGameButton.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()*0.75/9);
        newGameButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        newGameButton.setOnAction(event -> SceneManager.getInstance().switchToGameView());

        deathScreen = new VBox(deathMsg, newGameButton, mainMenuButton, exitButton);
        deathScreen.setPrefSize(sceneWidth, sceneHeight);
        deathScreen.setStyle("-fx-background-color: rgba(0, 0, 0, 0.55);");
        deathScreen.setVisible(false);
        deathScreen.setAlignment(Pos.CENTER);
    }

    public void deathScreenShow() {
        deathScreen.setVisible(true);
        SceneManager.getInstance().playMusic("/Resources/deathSong.mp3");
    }

    public void setupObjects(double sceneWidth, double sceneHeight) {
        //Background
        Image image = new Image("/Resources/ForestLevel.png");
        ImageView bg = new ImageView(image);
        bg.setFitWidth(sceneWidth);
        bg.setFitHeight(sceneHeight);


        //Platform
        platform = new Platform();

        //Ball
        ball = new Ball(platform);

        //DeathScreen
        initializeDeathScreen(sceneWidth, sceneHeight);

        getChildren().addAll(bg, platform, ball);


        blockList = Model.GenerateBlocks.generateBlocks(level, rows, columns);
        for (int i = 0; i < blockList.size(); i++){
            getChildren().add(blockList.get(i));
        }

        getChildren().add(deathScreen);

    }
    
    public Platform getPlatform() { return platform; }
    public Ball getBall() { return ball; }
    public ArrayList<Block> getBlockList() { return blockList; }
    public Player getplayer() { return player; }
 
}
