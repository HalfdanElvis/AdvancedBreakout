package Model;

import View.GameStart;
import javafx.scene.control.Button;

public class AchievementsButton {
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;
    


    public AchievementsButton() {
        buttonX = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*6/9;
        buttonWidth = GameStart.getSceneWidth()/3;
        buttonY = GameStart.getSceneHeight()*0.75/9;
        Button achievementsButton = new Button("Achievements Graphic needed");
        achievementsButton.setPrefSize(buttonWidth, buttonHeight);
        achievementsButton.setLayoutX(buttonX);
        achievementsButton.setLayoutY(buttonY);
    }

    public void pressed() {
        //GameStart.goToAchievements();
    }

}
