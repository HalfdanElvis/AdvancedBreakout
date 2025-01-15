package Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    private double hp;

    public Block(double hp, double x, double y, double width, double height) {
        super(x, y, width, height);
        this.hp = hp;
    }

    public double getHp() {
        return hp;
    }

    public void looseHp(double attack) {
        hp -= attack;
    }

    public void setColor(Color color) {
        setFill(color);
    }  
}
