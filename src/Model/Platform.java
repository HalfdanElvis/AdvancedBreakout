package Model;
import Controller.SceneController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform {
    private double platformWidth;
    private double platformHeight;
    private double velocity;
    private Rectangle platform;
    private boolean isMovingLeft;
    private boolean isMovingRight;

    public Platform(){
        platformWidth = SceneController.getSceneWidth()/4;
        platformHeight = SceneController.getSceneHeight()/30;
        platform = new Rectangle(SceneController.getSceneWidth()/2-platformWidth/2, SceneController.getSceneHeight()*0.8, platformWidth, platformHeight); 
        getRectangle().setFill(Color.GREEN);
        isMovingLeft = false;
        isMovingRight = false;
        velocity = 4;
    }

    public Rectangle getRectangle() {
        return this.platform;
    }

    public double getVelocity() {
        return this.velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public void setMovingLeft(boolean bool) {
        this.isMovingLeft = bool;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void setMovingRight(boolean bool) {
        this.isMovingRight = bool;
    }

    public double getX() {
        return this.platform.getX();
    }

    public void setX(double x) {
        this.platform.setX(x);
    }

    public double getY() {
        return this.platform.getY();
    }

    public void setY(double y) {
        this.platform.setY(y);
    }

    public double getWidth() {
        return this.platform.getWidth();
    }

    public void setWidth(double width) {
        this.platform.setWidth(width);
    }

    public double getHeight() {
        return this.platform.getHeight();
    }

    public void setHeight(double height) {
        this.platform.setHeight(height);
    }

    public void updatePosition() {
        if (isMovingLeft()) {
            setX(getX()-velocity);
        }
        if (isMovingRight()) {
            setX(getX()+velocity);
        }
        if (getX() < 0) {
            setX(0);
        }
        else if (getX()+getWidth() > SceneController.getSceneWidth()) {
            setX(SceneController.getSceneWidth()-getWidth());
        }
    }
}
