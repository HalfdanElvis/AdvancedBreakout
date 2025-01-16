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
    static String[] arrayHighScore;
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
            highScoreWrite.write(name+score+"\n");
            highScoreWrite.close();

        } catch (IOException e){
            System.out.println("Error in writing highscore");
            e.printStackTrace();
        }
    }
    public static void readHighScore(){
        Path path = Paths.get("Score.java").toAbsolutePath().getParent();
        String pathToFile=String.valueOf(path);
        pathToFile = pathToFile+"/Resources/HighScore.txt";
        try{
            String highscores = Files.readString(Paths.get(pathToFile));
            if(highscores == ""){
                highscores="There are no highscores yet";
            }
            String dividers = "\n";
            arrayHighScore = highscores.split(dividers);
        } catch(IOException e){
            System.out.println("Error in reading highscore");
            e.printStackTrace();
        }
    }
    public static int stringToInt(String s){
        int clean = Integer.parseInt(s.replaceAll("\\D+",""));
        return clean;
    }
    public static String cleanString(String string){
        String clean = string.replaceAll("[0-9]","") ;
        clean = clean.replace(".","");
        return clean;
    }
    public static String[] arrayRankArrange(String[] string){
        int[] arrInt = new int[string.length];
        for (int l=0; l<string.length;l++){
            arrInt[l] = stringToInt(string[l]);
        }
        int temp;
        String temp2;
        for (int i =0; i<arrInt.length;i++){
            for(int j=i+1; j<arrInt.length;j++){
                if(arrInt[i] < arrInt[j]) {    
                    temp = arrInt[i];    
                    temp2 = string[i];
                    arrInt[i] = arrInt[j];  
                    string[i] = string[j];  
                    arrInt[j] = temp;    
                    string[j] = temp2;
                }     
            }
        }
        return string;
    }
        
    public static String[] getHighscore(){
        return arrayHighScore;
    }
}
