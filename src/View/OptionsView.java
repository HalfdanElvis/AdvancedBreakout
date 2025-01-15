package View;

import Model.OptionsModel;
import Model.Buttons.BackButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class OptionsView extends Pane{

    public OptionsView() {

        BackButton backButton = new BackButton();

        Image image = new Image("/Resources/MainMenuBackground.png");
        ImageView bg = new ImageView(image);
        bg.setFitWidth(OptionsModel.getSceneWidth());
        bg.setFitHeight(OptionsModel.getSceneHeight());

        getChildren().addAll(bg, backButton);
    }
}
