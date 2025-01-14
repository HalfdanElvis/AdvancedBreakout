package Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
    private int score; 
    private int[] scoreArray = {10, 15, 25, 40, 60, 100};
    private double hp;
    private Rectangle block;

    public Block(double hp, double x, double y, double width, double height) {
        this.hp = hp;
        block = new Rectangle(x, y, width, height);
        this.score = 10;
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
    public int getScore(){
        return score;
    }
}
