package Model;
import View.*;
import javafx.scene.control.Button;

public class Card extends Button {
    private String name;
    private int ballAttack;
    private double ballSpeed;
    private int ballPierce;
    private double ballSize;
    private double platformSpeed;
    private double platformWidth;
    private int lives;



    public Card(String name, int ballAttack, double ballSpeed, int ballPierce, double ballSize, double platformSpeed, double platformWidth, int lives) {
        this.name = name;
        this.ballAttack = ballAttack;
        this.ballSpeed = ballSpeed;
        this.ballPierce = ballPierce;
        this.ballSize = ballSize;
        this.platformSpeed = platformSpeed;
        this.platformWidth = platformWidth;
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public int getBallAttack() {
        return ballAttack;
    }

    public double getBallSpeed() {
        return ballSpeed;
    }

    public int getBallPierce() {
        return ballPierce;
    }

    public double getBallSize() {
        return ballSize;
    }

    public double getPlatformSpeed() {
        return platformSpeed;
    }

    public double getPlatformWidth() {
        return platformWidth;
    }

    public int getLives() {
        return lives;
    }

    public void applyUpgrades(Ball ball, Platform platform, Player player) {
        ball.addAttack(ballAttack);
        ball.addOGVelocity(ballSpeed);
        ball.addMaxPierce(ballPierce);
        ball.addRadius(ballSize);
        platform.addVelocity(platformSpeed);
        platform.addPlatformWidth(platformWidth);
        player.addLives(lives);
    }
}