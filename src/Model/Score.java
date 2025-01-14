package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Score {
    public static void scoreAdder(Block block, Player player){
        player.updateCurrentscore(block.getScore());
    }
    
    public static void writeHighScore(Player player){
        String dirFileName = "C:\\Users\\simon\\Documents\\DTU\\proProjekt3Uger\\AdvancedBreakout\\src\\Resources\\HighScore.txt";

        String filename = "HighScore.txt";
        String score = String.valueOf(player.getCurrentscore());
        String name = player.getName();
        try{
            FileWriter highScoreWrite = new FileWriter(dirFileName, true);
            highScoreWrite.write(name+":"+score+";"+"\n");
            highScoreWrite.close();

        } catch (IOException e){
            System.out.println("Error in writing highscore");
            e.printStackTrace();
        }
    }
    public static void readHighScore(){
        
    }
}
