package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileReader; 

public class Score {
    String[] arrayHighScores;
    public static void scoreAdder(Block block, Player player){
        player.updateCurrentscore(block.getScore());
    }
    
    public static void writeHighScore(Player player){
        Path path = Paths.get("Score.java").toAbsolutePath().getParent();
        String pathToFile=String.valueOf(path);
        pathToFile = pathToFile+"/Resources/HighScore.txt";
        String score = String.valueOf(player.getCurrentscore());
        String name = player.getName();
        try{
            FileWriter highScoreWrite = new FileWriter(pathToFile, true);
            highScoreWrite.write(name+":"+score+"\n");
            highScoreWrite.close();

        } catch (IOException e){
            System.out.println("Error in writing highscore");
            e.printStackTrace();
        }
    }
    public void readHighScore(){
        String dirFileName = "/Resources/HighScore.txt";
        try{
            FileReader highScoreRead = new FileReader(dirFileName);
            highScoreRead.close();
            String highscores = String.valueOf(highScoreRead);
            String dividers = "\n";
            arrayHighScores = highscores.split(dividers);
        } catch(IOException e){
            System.out.println("Error in reading highscore");
            e.printStackTrace();
        }
    }
    public String[] getHighscore(){
        return arrayHighScores;
    }
}
