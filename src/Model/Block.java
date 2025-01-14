package Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
    private double hp;
    private Rectangle block;
    private long score;
    private static long[] scoreArray = {10, 15, 25, 40, 60, 100};
    private static long[] hpArray = {1, 2, 3, 5, 7, 10};
    private static Color[] colorArray = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.VIOLET};

    public Block(int tier, int level, double x, double y, double width, double height) {
        this.hp = (long) (hpArray[tier] * Math.ceil(level/3.0));
        this.score = (long) (scoreArray[tier] * Math.ceil(level/3.0));
        block = new Rectangle(x, y, width, height);
        this.block.setFill(colorArray[tier]);
    }

    public double getHp() {
        return hp;
    }

    public void looseHp(double attack) {
        hp -= attack;
    }

    public Rectangle getRectangle() {
        return block;
    }

    public double getX() {
        return this.block.getX();
    }

    public double getY() {
        return this.block.getY();
    }

    public void setX(double x) {
        this.block.setX(x);
    }

    public void setY(double x) {
        this.block.setY(x);
    }

    public double getWidth() {
        return this.block.getWidth();
    }

    public double getHeight() {
        return this.block.getHeight();
    }

    public void setWidth(double width) {
        this.block.setWidth(width);
    }

    public void setHeight(double height) {
        this.block.setHeight(height);
    }

    public void setColor(Color color) {
        this.block.setFill(color);
    }

    public long getScore() {
        return this.score;
    }

    public static int getMaxTier() {
        return colorArray.length-1;
    }
}
