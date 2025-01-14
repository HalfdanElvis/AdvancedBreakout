package Model;

public class Score {
    public static void scoreAdder(Block block, Player player){
        player.updateCurrentscore(block.getScore());
    }
}
