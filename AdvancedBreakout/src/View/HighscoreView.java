package View;

import Main.GameStart;
import Model.Buttons.BackButton;
import Model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class HighscoreView extends Pane{

    public HighscoreView() {

        BackButton backButton = new BackButton();

        Image image = new Image("/Resources/MainMenuBackground.png");
        ImageView bg = new ImageView(image);
        bg.setFitWidth(GameStart.getSceneWidth());
        bg.setFitHeight(GameStart.getSceneHeight());


        Score.readHighScore();
        String[] Highscores = Score.getHighscore();
        Highscores = Score.arrayRankArrange(Highscores);

        Pane pane = new Pane();
        int paneWidth = 300;
        int paneHeight = 400;
        //pane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.75);");
        pane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.75); "
        + "-fx-border-color:rgb(117, 117, 117); "
        + "-fx-border-width: 4; "
        + "-fx-border-radius: 10; "
        + "-fx-background-radius: 10; ");
        pane.setPrefSize(paneWidth, paneHeight);
        pane.setLayoutX(GameStart.getSceneWidth()/2-paneWidth/2);
        pane.setLayoutY(GameStart.getSceneHeight()/3);
        //getStylesheets().add(getClass().getResource("/Resources/stylesVBox.css").toExternalForm());
        VBox highscoreBox1 = new VBox();
        highscoreBox1.getStyleClass().add("vbox");
        if (Highscores.length<=10 || Highscores.length>10){
            highscoreBox1.setSpacing(10); // Afstand mellem elementer
            highscoreBox1.setLayoutX(paneWidth/8); // Placering på skærmen (x-koordinat)
            highscoreBox1.setLayoutY(pane.getHeight()); // Placering på skærmen (y-koordinat)

            for (int i=0; i<Math.min(10,Highscores.length);i++){
                int rank = i+1;
                String name = Score.cleanString(Highscores[i]);
                System.out.println(name);
                int score = Score.stringToInt(Highscores[i]);
                Label label = new Label(rank+"   "+name+"   "+score);
                label.setStyle("-fx-font-size: 24px; -fx-text-fill: white;-fx-font-family: monospace; "); // Styling
                label.setMinHeight(30);
                label.setMaxHeight(30);
                highscoreBox1.getChildren().add(label);
            }
        }
        //Delete later
        VBox highscoreBox2 = new VBox();
        highscoreBox2.getStyleClass().add("vbox");
        if(Highscores.length<=20 || Highscores.length>20){
            highscoreBox2.setSpacing(10);
            highscoreBox2.setLayoutX(paneWidth/2.5); // Placering på skærmen (x-koordinat)
            highscoreBox2.setLayoutY(pane.getHeight()); // Placering på skærmen (y-koordinat)
            for (int i=10; i<Math.min(20,Highscores.length);i++){
                Label label = new Label(Highscores[i]);
                label.setStyle("-fx-font-size: 18px; -fx-text-fill: white; "); // Styling
                label.setMinHeight(30);
                label.setMaxHeight(30);
                highscoreBox2.getChildren().add(label);
            }
        }
        //Delete later
        VBox highscoreBox3 = new VBox();
        highscoreBox3.getStyleClass().add("vbox");
        if(Highscores.length<=30 || Highscores.length>30){
            highscoreBox3.setSpacing(10);
            highscoreBox3.setLayoutX(paneWidth/1.4); // Placering på skærmen (x-koordinat)
            highscoreBox3.setLayoutY(pane.getHeight()); // Placering på skærmen (y-koordinat)
            for (int i=20; i<Math.min(30,Highscores.length);i++){
                Label label = new Label(Highscores[i]);
                label.setStyle("-fx-font-size: 18px; -fx-text-fill: white; "); // Styling
                label.setMinHeight(30);
                label.setMaxHeight(30);
                highscoreBox3.getChildren().add(label);
            }
        }

        pane.getChildren().addAll(highscoreBox1);
        getChildren().addAll(bg, backButton,pane);
    }
}
