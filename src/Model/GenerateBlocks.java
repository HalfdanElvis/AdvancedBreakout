package Model;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GenerateBlocks {
    public static ArrayList<Rectangle> generateBlocks(double rows, double columns) {
        ArrayList<Rectangle> blockList = new ArrayList<>();
        double space = View.GameStart.getSceneWidth()/Math.sqrt(columns)/Math.sqrt(rows)/40;
        double blockWidth = View.GameStart.getSceneWidth()/columns-space;;
        double blockHeight = View.GameStart.getSceneHeight()/3/rows-space;
        for (double i = 0; i < columns; i++) {
            for (double j = 0; j < rows; j++) {
                Rectangle block = new Rectangle((blockWidth+space)*i+space/2, (blockHeight+space)*j+space/2, blockWidth, blockHeight);
                block.setFill(Color.hsb(j*330/rows, 1, 1)); 
                blockList.add(block); 
            }
        }
        return blockList;
    }
}
