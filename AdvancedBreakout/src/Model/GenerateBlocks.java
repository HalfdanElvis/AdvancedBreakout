package Model;

import java.util.ArrayList;

import Main.GameStart;
import javafx.scene.paint.Color;

public class GenerateBlocks {
    public static ArrayList<Block> generateBlocks(int level, double rows, double columns) {
        ArrayList<Block> blockList = new ArrayList<>();
        double space = GameStart.getSceneWidth()/Math.sqrt(columns)/Math.sqrt(rows)/40;
        double blockWidth = GameStart.getSceneWidth()/columns-space;;
        double blockHeight = GameStart.getSceneHeight()/3/rows-space;
        for (double i = 0; i < columns; i++) {
            for (double j = 0; j < rows; j++) {
                Block block = new Block(Math.floor(level*1.5), (blockWidth+space)*i+space/2, (blockHeight+space)*j+space/2+blockHeight*3, blockWidth, blockHeight);
                block.setColor(Color.hsb(j*330/rows, 1, 1)); 
                blockList.add(block); 
            }
        }
        return blockList;
    }
}