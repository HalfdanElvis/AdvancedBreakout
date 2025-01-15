package Controller;
import java.util.ArrayList;

import Main.GameStart;
import Model.*;
import View.*;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
public class GameController {
    private GameView gameView;
    private Scene scene;
    static Timeline gameplay;
    static boolean gameRunning = false;

    public GameController(GameView gameView, Scene scene) {
        this.gameView = gameView;
        this.scene = scene;
        setupControls();
        startGameplay();
    }

    public void startGameplay() {
        gameplay = new Timeline(new KeyFrame(Duration.millis(8), e -> {
            update();
        }));
        gameplay.setCycleCount(Timeline.INDEFINITE);
    }

    public void update() {

        Ball ball = gameView.getBall();

        // checks for death
        if (ball.getY() - ball.getRadius()*2 > GameStart.getSceneHeight()){
            Score.writeHighScore(gameView.getplayer());
            gameplay.stop();
            gameRunning = false;
            gameView.deathScreenShow();
        }

        // Updates ball and platform position
        ball.updatePosition();
        gameView.getPlatform().updatePosition();

        // Checks balls collisions
        checkBorderCollision(ball);
        blockCollision(ball, gameView.getBlockList(), gameView);
        collisionWithPlatform(ball, gameView.getPlatform());

        // Increases ball speed
        ball.setVelocity(ball.getVelocity()+(ball.getVelocity()*0.0001));

    }

    public void setupControls() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                leftPressed();
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightPressed();
            } else if (event.getCode() == KeyCode.SPACE) {
                spacePressed();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                leftReleased();
            } else if (event.getCode() == KeyCode.RIGHT) {
                rightReleased();
            }
        });
    }

    // KeyPresses
    public void leftPressed() { gameView.getPlatform().setMovingLeft(true); }
    public void rightPressed() { gameView.getPlatform().setMovingRight(true); }
    public void leftReleased() { gameView.getPlatform().setMovingLeft(false); }
    public void rightReleased() { gameView.getPlatform().setMovingRight(false); }
    public static void spacePressed() {
        if (!gameRunning) {
            gameplay.play();  
            gameRunning = true;
        }
    }

    // Maybe import collision Manger?
    public static void collisionWithPlatform(Ball ball, Platform platform) {
        if (ball.getBoundsInParent().intersects(platform.getBoundsInParent())){
            if (!ball.isInPlatform()) {
                if (ball.getY()<platform.getY()+platform.getHeight()){
                    ball.setCurrentPierce(ball.getMaxPierce());
                    ball.setInPlatform(true); 
                    // Finds how far along the platform the collison is
                    double collisionPoint = ((ball.getX()-platform.getX())/platform.getWidth());
                    // Inlcudes the balls size in the calculation of angle on edges
                    if(collisionPoint < 0.3){
                        collisionPoint += ball.getRadius()/platform.getWidth();
                    } else if (collisionPoint > 0.7){
                        collisionPoint -= ball.getRadius()/platform.getWidth();
                    }

                    ball.setAngle(-(1 - collisionPoint) * 180);
                   
                    //adjusts for exteme angels
                    if (ball.getAngle() < -160) {ball.setAngle(-160);}
                    if (ball.getAngle() > -20) {ball.setAngle(-20);}
                }
            }
        }
        else {
            ball.setInPlatform(false);
        }
    }

    public static void checkBorderCollision (Ball ball) {
        if ((ball.getX() - ball.getRadius() <= 0)) {
            ball.sideHit();
            ball.setX(ball.getRadius());
        }
        else if ((ball.getX() + ball.getRadius() >= GameStart.getSceneWidth())) {
            ball.sideHit();
            ball.setX(GameStart.getSceneWidth()-ball.getRadius());
        }

        if ((ball.getY() - ball.getRadius() <= 0)) {
            ball.topBottomHit();
            ball.setY(ball.getRadius());
        }
    }

    public static void blockCollision(Ball ball, ArrayList<Block> blockList, GameView gameView) {
        int hitTop = 0;
        int hitBottom = 0;
        int hitRight = 0;
        int hitLeft = 0;
        int hitCount = 0;
        int deathCount = 0;
        for (int i = blockList.size()-1; i >= 0; i--){
            Block block = blockList.get(i);
            if (ball.getBoundsInParent().intersects(block.getBoundsInParent())) {
                hitCount++;
                if (ball.getY() < block.getY()) {
                    hitTop++;
                }
                if (ball.getY() > block.getY() + block.getHeight()) {
                    hitBottom++;
                }
                if (ball.getX() > block.getX() + block.getWidth()) {
                    hitRight++;
                }
                if (ball.getX() < block.getX()) {
                    hitLeft++;
                }
                if (block.getHp()-ball.getAttack() <= 0) {
                    Score.scoreAdder(blockList.get(i), gameView.getplayer());
                    blockList.remove(i);
                    gameView.getChildren().remove(block); 
                    deathCount++;
                    ball.setCurrentPierce(ball.getCurrentPierce()-1);
                } else {
                    blockList.get(i).looseHp(ball.getAttack());
                    ball.setCurrentPierce(0);
                }
            }
        }
        if (deathCount != hitCount || ball.getCurrentPierce()+1 < hitCount) {
            if (hitCount == 1) {
                if (hitLeft == 1 && hitTop == 1) {
                    if (ball.getAngle() > 0 && ball.getAngle() < 90) {
                        ball.sideHit();
                        ball.topBottomHit();
                    }
                    else if (ball.getAngle() < 0 && ball.getAngle() > -90) {
                        ball.sideHit();
                    }
                    else {
                        ball.topBottomHit();
                    }
                }
                else if (hitLeft == 1 && hitBottom == 1) {
                    if (ball.getAngle() < 0 && ball.getAngle() > -90) {
                        ball.sideHit();
                        ball.topBottomHit();
                    }
                    else if (ball.getAngle() > 0 && ball.getAngle() < 90) {
                        ball.sideHit();
                    }
                    else {
                        ball.topBottomHit();
                    }
                }
                else if (hitRight == 1 && hitTop == 1) {
                    if (ball.getAngle() > 90 && ball.getAngle() < 180) {
                        ball.sideHit();
                        ball.topBottomHit();
                    }
                    else if (ball.getAngle() < -90 && ball.getAngle() > -180) {
                        ball.sideHit();
                    }
                    else {
                        ball.topBottomHit();
                    }
                }
                else if (hitRight == 1 && hitBottom == 1) {
                    if (ball.getAngle() < -90 && ball.getAngle() > -180) {
                        ball.sideHit();
                        ball.topBottomHit();
                    }
                    else if (ball.getAngle() > 90 && ball.getAngle() < 180) {
                        ball.sideHit();
                    }
                    else {
                        ball.topBottomHit();
                    }
                }
                else if (hitRight == 1 || hitLeft == 1) {
                    ball.sideHit();
                }
                else {
                    ball.topBottomHit();
                }
            }
            else if (hitCount >= 2) {
                if ((Math.max(hitTop, hitBottom)) >= (Math.max(hitLeft, hitRight))) {
                    ball.topBottomHit();
                }
                if ((Math.max(hitTop, hitBottom)) <= (Math.max(hitLeft, hitRight))) {
                    ball.sideHit();
                }
            }
            if (ball.getAngle() > 180) {
                ball.setAngle(ball.getAngle()-360);
            }
            else if (ball.getAngle() < -180) {
                ball.setAngle(ball.getAngle()+360);
            }
        }
    }

}