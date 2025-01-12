package Model;

import View.GameView;
import javafx.scene.control.Button;

public class AchievementsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public AchievementsButton() {
        buttonX = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*6/9;
        buttonWidth = GameView.getSceneWidth()/3;
        buttonY = GameView.getSceneHeight()*0.75/9;
        Button achievementsButton = new Button("Achievements Graphic needed");
        achievementsButton.setPrefSize(buttonWidth, buttonHeight);
        achievementsButton.setLayoutX(buttonX);
        achievementsButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.goToAchievements();
    }

}
