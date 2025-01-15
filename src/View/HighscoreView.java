package View;

import Main.GameStart;
import Model.Buttons.BackButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HighscoreView extends Pane{

    public HighscoreView() {

        BackButton backButton = new BackButton();

        Image image = new Image("/Resources/MainMenuBackground.png");
        ImageView bg = new ImageView(image);
        bg.setFitWidth(GameStart.getSceneHeight());
        bg.setFitHeight(GameStart.getSceneWidth());

        getChildren().addAll(bg, backButton);
    }
}
