package game.entities;

import game.Handler;
import game.sound.Sound;

import java.awt.*;

public class Ball extends Entity {

    private int turn;
    private Color ballColor;
    private int r, b;

    public Ball(Handler handler, float x, float y) {
        super(handler, x, y);
        width = 20;
        height = 20;
        turn = 0;
        xSpeed = (float) -5;
        ySpeed = (float) -5;

        r = 0;
        b = 255;
    }

    @Override
    public void tick() {
        winCheck();
        move();
    }

    @Override
    public void render(Graphics g) {
        ballColor = new Color(r, 100,b);
        g.setColor(ballColor);
        g.fillOval((int) x, (int) y, width, height);
    }

    @Override
    public void move() {
        xMove = 0;
        yMove = 0;

        if (checkPlayerCollision()) {
            xSpeed *= -1.02;
                if (r < 250) {
                    b -= 4;
                    r += 4;
                }
        } else if(checkWallCollision())
            ySpeed *= -1;

        xMove += xSpeed;
        yMove += ySpeed;

        x += xMove;
        y += yMove;
    }

    private Rectangle getCollisionBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    private boolean checkPlayerCollision() {
        if (handler.getGame().getGameState().getP1().getCollisionBounds().intersects(getCollisionBounds()) && turn == 0) {
            Sound.playSound("paddle.wav");
            turn = 1;
            return true;
        }
        if(handler.getGame().getGameState().getP2().getCollisionBounds().intersects(getCollisionBounds()) && turn == 1){
            Sound.playSound("paddle.wav");
            turn = 0;
            return true;
        }
        return false;
    }
    private boolean checkWallCollision(){
        if(y < 0 || y > handler.getGame().getHeight() - height){
            Sound.playSound("wallhit.wav");
            return true;
        }
        return false;
    }

    private void winCheck() {
        if (x < 0) {
            handler.getGame().getGameState().getP2().score += 1;
            Sound.playSound("outofbounds.wav");
            handler.getGame().getGameState().setRunning(false);
        } else if (x > handler.getGame().getWidth()) {
            Sound.playSound("outofbounds.wav");
            handler.getGame().getGameState().getP1().score += 1;
            handler.getGame().getGameState().setRunning(false);
        }
        if(handler.getGame().getGameState().getP1().score == 3) {
            Sound.playSound("end.wav");
            handler.getGame().getGameState().setGameOver(true);
        }
        else if(handler.getGame().getGameState().getP2().score == 3) {
            Sound.playSound("end.wav");
            handler.getGame().getGameState().setGameOver(true);
        }
    }
}
