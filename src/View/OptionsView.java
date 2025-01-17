package View;


import Model.OptionsModel;
import Model.Buttons.BackButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class OptionsView extends Pane{
    static Slider musicSlider = new Slider(0, 1, OptionsModel.getMusicVolume());
    static Slider soundSlider = new Slider(0, 1, OptionsModel.getSoundVolume());
    static double sceneWidth = OptionsModel.getSceneWidth();
    static double sceneHeight = OptionsModel.getSceneHeight();
    public OptionsView() {

        BackButton backButton = new BackButton();

        Image image = new Image("/Resources/MainMenuBackground.png");
        ImageView bg = new ImageView(image);
        bg.setFitWidth(sceneWidth);
        bg.setFitHeight(sceneHeight);
        musicSlider.setPrefWidth(sceneWidth*0.2);
        musicSlider.setLayoutX(sceneWidth*0.2);
        musicSlider.setLayoutY(sceneHeight*0.45);
        musicSlider.setShowTickLabels(true);
        musicSlider.setMajorTickUnit(0.2);
        musicSlider.setShowTickMarks(true);
        musicSlider.setSnapToTicks(true);

        soundSlider.setPrefWidth(sceneWidth*0.2);
        soundSlider.setLayoutX(sceneWidth*0.6);
        soundSlider.setLayoutY(sceneHeight*0.45);
        soundSlider.setShowTickLabels(true);
        soundSlider.setMajorTickUnit(0.2);
        soundSlider.setShowTickMarks(true);
        soundSlider.setSnapToTicks(true);
        
        getChildren().addAll(bg, backButton, musicSlider, soundSlider);
    }

    public static double getMusicVolume() {
        return musicSlider.getValue();
    }

    public static double getSoundVolume() {
        return soundSlider.getValue();
    }
}
