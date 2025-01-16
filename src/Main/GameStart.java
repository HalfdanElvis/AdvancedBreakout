package Main;

import java.io.IOException;

import Model.OptionsModel;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameStart extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sir Slime's Crazy Adventure");
        Image icon = new Image("/Resources/icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(0);
        stage.setY(0);
        stage.setWidth(Model.OptionsModel.getSceneWidth());
        stage.setHeight(Model.OptionsModel.getSceneHeight());

        SceneManager.initializeInstance(stage);

        SceneManager.getInstance().switchToMainMenuView();
    }

    public static void main(String[] args) throws IOException {
        OptionsModel.loadOptions();
        launch(args);
    }
}
