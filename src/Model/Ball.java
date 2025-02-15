package Model;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class Ball extends Circle {
    private double ogVelocity = 3.5;
    private double velocity = ogVelocity;
    private double attack = 1;
    private double maxPierce = 0;
    private double currentPierce = maxPierce;
    private double angle;
    private boolean inPlatform = false;
    private static double defaultRadius = 20;

    public Ball (Platform platform){
        super(platform.getX()+platform.getWidth()/2, platform.getY()-defaultRadius, defaultRadius);
        Image ballIcon = new Image("\\Resources\\SlimeSprite.png");
        setFill(new ImagePattern(ballIcon));
        randomizeAngle();
    }

    public boolean isInPlatform() {
        return inPlatform;
    }

    public void addOGVelocity(double n) {
        this.ogVelocity += n;
    }

    public void setInPlatform(boolean inPlatform) {
        this.inPlatform = inPlatform;
    }

    public double getX() {
        return getCenterX();
    }

    public void setX(double x) {
        setCenterX(x);
    }

    public double getY() {
        return getCenterY();
    }

    public void setY(double y) {
        setCenterY(y);
    }

    public void addRadius(double n) {
        this.setRadius(this.getRadius()+n);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public void randomizeAngle() {
        this.angle = (int)-120+(Math.random()*60);
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void addVelocity(double velocity) {
        this.velocity += velocity;
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

    public double getAttack() {
        return this.attack;
    }

    public void addAttack(double attack) {
        this.attack += attack;
    }

    public double getCurrentPierce() {
        return this.currentPierce;
    }

    public void setCurrentPierce(double piercing) {
        this.currentPierce = piercing;
    }

    public double getMaxPierce() {
        return maxPierce;
    }

    public void addMaxPierce(double maxPierce) {
        this.maxPierce += maxPierce;
        this.currentPierce = maxPierce;
    }

    public void reset(Platform platform) {
        setX(platform.getX()+(platform.getWidth()/2));
        setY(platform.getY()-getRadius());
        setVelocity(ogVelocity);
        this.currentPierce = maxPierce;
        randomizeAngle();
    }
}