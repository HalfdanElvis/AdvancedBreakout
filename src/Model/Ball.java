package Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball {
    private double velocity = 7;
    private Circle ball;
    private double angle;
    private boolean inPlatform;

    public Ball (Platform platform){
        ball = new Circle(platform.getX()+platform.getWidth()/2,platform.getY()-8, 8);
        getCircle().setFill(Color.GOLDENROD);
        randomizeAngle();
    }

    public boolean isInPlatform() {
        return inPlatform;
    }

    public void setInPlatform(boolean inPlatform) {
        this.inPlatform = inPlatform;
    }

    public Circle getCircle() {
        return ball;
    }

    public double getX() {
        return this.ball.getCenterX();
    }

    public void setX(double x) {
        this.ball.setCenterX(x);
    }

    public double getY() {
        return this.ball.getCenterY();
    }

    public void setY(double y) {
        this.ball.setCenterY(y);
    }

    public double getRadius() {
        return this.ball.getRadius();
    }

    public void setRadius(double radius) {
        this.ball.setRadius(radius);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public void randomizeAngle() {
        this.angle = -120+(int)(Math.random()*60);
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void updatePosition() {
        setX(getX() + this.velocity*Math.cos(this.angle*Math.PI/180));
        setY(getY() + this.velocity*Math.sin(this.angle*Math.PI/180));
    }

    public void sideHit() {
        angle = 180-angle;
    }

    public void topBottomHit() {
        angle *= -1;
    }
}
