package View;
import Model.*;
import Model.Buttons.*;
import Main.SceneManager;

import java.util.ArrayList;

import Controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.geometry.Pos;


public class GameView extends Pane{
    private Player player;
    private Platform platform;
    private Ball ball;
    private ArrayList<Block> blockList;
    private ArrayList<Card> commonList;
    private ArrayList<Card> rareList;
    private ArrayList<Card> legendaryList;
    private VBox deathScreen;
    private HBox upgradeScreen;
    private VBox upgradeTitle;
    private double sceneWidth = OptionsModel.getSceneWidth();
    private double sceneHeight = OptionsModel.getSceneHeight();

    // HUD
    private Text lives;
    private Text level;
    private Text score;
    private Rectangle HUDBackground;

    public GameView (){
        player = new Player();
        setupObjects(sceneWidth, sceneHeight);
        initializeHUD();
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

        //UpgradeScreen
        initializeUpgradeScreen(sceneWidth, sceneHeight);

        getChildren().addAll(bg, platform, ball);


        blockList = Model.GenerateBlocks.generateBlocks(player.getLevel());
        for (int i = 0; i < blockList.size(); i++){
            getChildren().add(blockList.get(i));
        }

        getChildren().add(upgradeScreen);
        getChildren().add(upgradeTitle);
        getChildren().add(deathScreen);

    }

    public void initializeHUD(){
        HUDBackground = new Rectangle(0,0, sceneWidth, sceneHeight*0.03);
        HUDBackground.setFill(Color.WHITE);
        lives = new Text(sceneWidth*0.9, 20,"Lives: " + (player.getLives()));
        lives.setFill(Color.BLACK);
        level = new Text(sceneWidth*0.4,20,"Level: " + (player.getLevel()));
        score = new Text(0,20,"Score: " +  (player.getCurrentScore()));
        lives.setStyle("-fx-font-size: 24px;");
        level.setStyle("-fx-font-size: 24px;");
        score.setStyle("-fx-font-size: 24px;");
        getChildren().addAll(HUDBackground, lives, level, score);
    }

    public void updateHUD() {
        lives.setText("Lives: " + (player.getLives()));
        level.setText("Level: " + (player.getLevel()));
        score.setText("Score " + (player.getCurrentScore()));
    }

    public void lifeLost(){
        platform.reset();
        ball.reset(platform);
    }

    public void initializeDeathScreen(double sceneWidth, double sceneHeight) {
        Text deathMsg = new Text("You died.");
        deathMsg.setStyle("-fx-font-size: 36px; -fx-fill: white;");
        Text deathScore = new Text("Score: "+player.getCurrentScore());
        deathScore.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        TextField playerNameInput = new TextField();

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()*0.75/9);
        mainMenuButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        mainMenuButton.setOnAction(event -> SceneManager.getInstance().switchToMainMenuView());

        ExitButton exitButton = new ExitButton();

        Text spacing = new Text("");
        spacing.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        Text spacing2 = new Text("");
        spacing2.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        Text name = new Text("Name: ");
        name.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        HBox nameField = new HBox(name, playerNameInput);
        nameField.setAlignment(Pos.CENTER);
        nameField.getChildren().addAll();

        Button newGameButton = new Button("New Game");
        newGameButton.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()*0.75/9);
        newGameButton.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        newGameButton.setOnAction(event -> SceneManager.getInstance().switchToGameView());

        deathScreen = new VBox(deathMsg, deathScore, spacing, nameField, spacing2, newGameButton, mainMenuButton, exitButton);
        deathScreen.setPrefSize(sceneWidth, sceneHeight);
        deathScreen.setStyle("-fx-background-color: rgba(0, 0, 0, 0.55);");
        deathScreen.setVisible(false);
        deathScreen.setAlignment(Pos.CENTER);
    }

    public void deathScreenShow() {
        deathScreen.setVisible(true);
        SceneManager.getInstance().playMusic("/Resources/deathSong.mp3");
    }

    public void initializeUpgradeScreen(double sceneWidth, double sceneHeight) {
        Text upgradeMsg = new Text("Choose an upgrade");
        upgradeMsg.setStyle("-fx-font-size: 36px; -fx-fill: white;");

        commonList = Model.GenerateCards.generateCommonCards();
        rareList = Model.GenerateCards.generateRareCards();
        legendaryList = Model.GenerateCards.generateLegendaryCards();

        Card upgradeButton1 = Model.Upgrade.getUpgrade(commonList, rareList, legendaryList);
        if (commonList.contains(upgradeButton1)) commonList.remove(upgradeButton1);
        else if (rareList.contains(upgradeButton1)) rareList.remove(upgradeButton1);
        else if (legendaryList.contains(upgradeButton1)) legendaryList.remove(upgradeButton1);
        upgradeButton1.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()/2);
        upgradeButton1.setText(upgradeButton1.getName());
        upgradeButton1.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        upgradeButton1.setOnAction(event -> {
            upgradeButton1.applyUpgrades(ball, platform, player);
            SceneManager.getInstance().levelUp();
        });
        Card upgradeButton2 = Model.Upgrade.getUpgrade(commonList, rareList, legendaryList);
        if (commonList.contains(upgradeButton2)) commonList.remove(upgradeButton2);
        else if (rareList.contains(upgradeButton2)) rareList.remove(upgradeButton2);
        else if (legendaryList.contains(upgradeButton2)) legendaryList.remove(upgradeButton2);
        upgradeButton2.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()/2);
        upgradeButton2.setText(upgradeButton2.getName());
        upgradeButton2.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        upgradeButton2.setOnAction(event -> {
            upgradeButton2.applyUpgrades(ball, platform, player);
            SceneManager.getInstance().levelUp();
        });

        Card upgradeButton3 = Model.Upgrade.getUpgrade(commonList, rareList, legendaryList);
        if (commonList.contains(upgradeButton3)) commonList.remove(upgradeButton3);
        else if (rareList.contains(upgradeButton3)) rareList.remove(upgradeButton3);
        else if (legendaryList.contains(upgradeButton3)) legendaryList.remove(upgradeButton3);
        upgradeButton3.setPrefSize(OptionsModel.getSceneWidth()/3, OptionsModel.getSceneHeight()/2);
        upgradeButton3.setText(upgradeButton3.getName());
        upgradeButton3.getStylesheets().add(getClass().getResource("/Resources/styles.css").toExternalForm());
        upgradeButton3.setOnAction(event -> {
            upgradeButton3.applyUpgrades(ball, platform, player);
            SceneManager.getInstance().levelUp();
        });

        upgradeScreen = new HBox(upgradeButton1, upgradeButton2, upgradeButton3);
        upgradeScreen.setPrefSize(sceneWidth, sceneHeight);
        upgradeScreen.setStyle("-fx-background-color: rgba(0, 0, 0, 0.55);");
        upgradeScreen.setVisible(false);
        upgradeScreen.setAlignment(Pos.CENTER);
        
        upgradeTitle = new VBox(upgradeMsg);
        upgradeTitle.setPrefSize(sceneWidth, sceneHeight/3);
        upgradeTitle.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        upgradeTitle.setVisible(false);
        upgradeTitle.setAlignment(Pos.CENTER);    
        
    }

    public void newLevel() {
        player.levelUp();
        updateHUD();
        blockList = Model.GenerateBlocks.generateBlocks(player.getLevel());
        for (int i = 0; i < blockList.size(); i++){
            getChildren().add(blockList.get(i));
        }

        initializeDeathScreen(sceneWidth, sceneHeight);
        getChildren().add(deathScreen);

        
        upgradeScreen.setVisible(false);
        upgradeTitle.setVisible(false);

        platform.reset();
        ball.reset(platform);
    }

    public void upgradeScreenShow() {
        upgradeScreen.setVisible(true);
        upgradeTitle.setVisible(true);
    }
    
    public Platform getPlatform() { return platform; }
    public Ball getBall() { return ball; }
    public ArrayList<Block> getBlockList() { return blockList; }
    public Player getplayer() { return player; }
    public ArrayList<Card> getCommonList() { return commonList; }
    public ArrayList<Card> getRareList() { return rareList; }
    public ArrayList<Card> getLegendaryList() { return legendaryList; }
    public VBox getUpgradeTitle() { return upgradeTitle; }
    public HBox getUpgradeScreen() { return upgradeScreen; }
    public double getHudHeight() { return HUDBackground.getHeight(); }
}
