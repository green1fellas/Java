package game.entities;

import game.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;

    protected float xSpeed, ySpeed;
    protected float xMove, yMove;
    protected float x, y;
    protected int xBounds, yBounds, widthBounds, heightBounds;
    protected Rectangle bounds;
    protected int depth;
    protected boolean active;

    public Entity(Handler handler, float x, float y, int depth){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.bounds = new Rectangle(xBounds, yBounds, widthBounds, heightBounds);
        active = true;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void move();

    public Entity checkEntityCollisions(){
        for(Entity e : handler.getGame().getGameState().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.bounds.intersects(bounds)) {
                return e;
            }
        }
        return null;
    }


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

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isActive(){
        return active;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
