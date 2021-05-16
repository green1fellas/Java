package game.entities.creatures;

import game.Handler;
import game.entities.Entity;
import game.gfx.Animation;

import java.awt.*;

public class Enemy extends Creature {

    private Animation anim;
    private Rectangle topBound, bottomBound;
    private boolean shoot = false;

    public Enemy(Handler handler, float x, float y, int depth, float xSpeed, float ySpeed, Animation anim) {
        super(handler, x, y, depth);
        this.anim = anim;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void tick() {
        super.tick();
        if(outOfBounds()) active = false;
        bounds = new Rectangle((int)x + 4, (int)y + 9, widthBounds, heightBounds);
        topBound = new Rectangle((int)x + 4, (int)y + 9 + 45, widthBounds, heightBounds/3);
        bottomBound = new Rectangle((int)x + 4, (int)y + 9 - 10, widthBounds, heightBounds/3);
        if(health == 0)
            active = false;
        anim.tick();
        follow();
        shoot();
        move();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawImage(anim.getCurrentFrame(), (int)x, (int)y, null);
        healthBar(g, x, y);
    }

    private void follow(){

        xMove = 0;
        xMove += xSpeed;
        yMove = 0;

        if(handler.getGame().getGameState().getEntityManager().getPlayer().getY() > (y - 20) &&
                handler.getGame().getGameState().getEntityManager().getPlayer().getY() < (y + 20))
            ySpeed = 1;
        else
            ySpeed = 2;

        Entity temp = checkEntityCollisions();
        if(temp instanceof Enemy) {
            if (handler.getGame().getGameState().getEntityManager().getPlayer().getY() > (y - 12) && !(temp.getBounds().intersects(topBound)))
                yMove += ySpeed;
            else if (handler.getGame().getGameState().getEntityManager().getPlayer().getY() < (y - 12) && !(temp.getBounds().intersects(bottomBound)))
                yMove -= ySpeed;
        }else {

            if (handler.getGame().getGameState().getEntityManager().getPlayer().getY() > (y - 12))
                yMove += ySpeed;
            else if (handler.getGame().getGameState().getEntityManager().getPlayer().getY() < (y - 12))
                yMove -= ySpeed;
        }
    }

    public void shoot(){
        int randInt = (int)(Math.random()*100);
        if(randInt < 2) {
            shoot = true;
            handler.getGame().getGameState().setCurrShooter(this);
        }
    }

    public boolean outOfBounds(){
        return x < -100;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }
}

