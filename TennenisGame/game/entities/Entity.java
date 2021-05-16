package game.entities;

import game.Handler;

import java.awt.*;

public abstract class Entity {

    Handler handler;

    public float xSpeed, ySpeed;
    public int width, height;
    protected float xMove, yMove;
    protected float x, y;

    public Entity(Handler handler, float x, float y){
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void move();

    // GETTERS & SETTERS

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
