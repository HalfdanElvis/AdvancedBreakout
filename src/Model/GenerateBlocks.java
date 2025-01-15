package Model;

import java.util.ArrayList;



public class GenerateBlocks {
    public static ArrayList<Block> generateBlocks(int level, double rows, double columns) {
        level = 1;
        rows += Math.floor(level/5.0);
        columns += Math.floor(level/5.0);
        ArrayList<Block> blockList = new ArrayList<>();
        double space = Model.OptionsModel.getSceneWidth()/Math.sqrt(columns)/Math.sqrt(rows)/40;
        double blockWidth = Model.OptionsModel.getSceneWidth()/columns-space;
        double blockHeight = Model.OptionsModel.getSceneHeight()/3/rows-space;

        double[][] probabilities = new double[(int) rows][Block.getMaxTier()];
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[probabilities.length-1-i] = generateProbabilities(level, Math.floor(level/3)-4+i/rows*8, 0.9);
        }
        //generates blocks randomly based on current level
        for (double i = 0; i < columns; i++) {
            for (double j = 0; j < rows; j++) {
                if (Math.random() > Math.exp(-Math.pow(j, 2)/150/Math.pow(level, 0.25)*10/rows)) {
                    continue;
                }
                int tier = chooseTier(probabilities[(int) j], level-1);
                Block block = new Block(tier, level, (blockWidth+space)*i+space/2, (blockHeight+space)*j+space/2+blockHeight*3, blockWidth, blockHeight);
                blockList.add(block);
            }
        }
        return blockList;
    }

    //generating probabilities for each tier
    public static double[] generateProbabilities(int level, double mean, double spread) {
        double[] probabilities = new double[level];
        double sum = 0;
        for (int tier = 0; tier < probabilities.length; tier++) {
            probabilities[tier] = gaussianProbability(tier, mean, spread);
            sum += probabilities[tier];
        }
        //normalizes them (so the sum is 1)
        for (int tier = 0; tier < probabilities.length; tier++) {
            probabilities[tier] /= sum;
        }
        return probabilities;
    }

    //normal distribution function
    private static double gaussianProbability(double x, double mean, double spread) {
        return Math.exp(-Math.pow(x - mean, 2) / (2 * Math.pow(spread, 2))) / (spread * Math.sqrt(2 * Math.PI));
    }

    //chooses which tier based on the probabilities
    public static int chooseTier(double[] probabilities, int maxTier) {
        maxTier = Math.min(maxTier, Block.getMaxTier());
        double randomValue = Math.random();
        double cumulative = 0;
        for (int tier = 0; tier < probabilities.length; tier++) {
            cumulative += probabilities[tier];
            if (randomValue <= cumulative) {
                return Math.min(tier, maxTier);
            }
        }
        return maxTier;
    }
}