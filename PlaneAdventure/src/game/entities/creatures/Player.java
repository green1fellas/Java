package game.entities.creatures;

import game.Handler;
import game.gfx.Animation;
import game.gfx.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Creature{

    private Animation playerAnim;
    private boolean shoot = false;

    public Player(Handler handler, float x, float y, int depth){
        super(handler, x, y, depth);
        playerAnim = new Animation(20, Assets.player);
        widthBounds = 80;
        heightBounds = 42;
        xSpeed = 5;
        ySpeed = 5;
    }

    public void tick(){
        super.tick();
        if(isDead())
            active = false;
        bounds = new Rectangle((int)x + 18, (int)y + 35, widthBounds, heightBounds);
        playerAnim.tick();
        getInput();
        move();
    }

    public void render(Graphics g){
        super.render(g);
        g.drawImage(playerAnim.getCurrentFrame(), (int)x, (int)y, null);
        healthBar(g, x+55, y+20);
    }

    private void getInput(){

        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -ySpeed;
        if(handler.getKeyManager().down)
            yMove = ySpeed;
        if(handler.getKeyManager().left)
            xMove = -xSpeed;
        if(handler.getKeyManager().right)
            xMove = xSpeed;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
            shoot = true;
    }

    private boolean outOfBounds(){

        if(x > handler.getGame().getWidth() || x < -106)
            return true;
        return (y > handler.getGame().getHeight()-30 || y < -100);
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public boolean isDead(){
        return health <= 0 || outOfBounds();
    }
}
