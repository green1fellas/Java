package game.entities.objects;

import game.Handler;
import game.entities.Entity;
import game.entities.creatures.Enemy;
import game.entities.creatures.Player;

import java.awt.*;

public class Bullet extends Entity {

    public Bullet(Handler handler, float x, float y, int depth, int direction) {
        super(handler, x, y, depth);
        xSpeed = 20*direction;
    }

    @Override
    public void tick() {
        bounds = new Rectangle((int)x + 80, (int)y +  50, 10, 2);
        checkOutOfBounds();
        Entity temp = checkEntityCollisions();
        if(temp instanceof Enemy) {
            ((Enemy) temp).setHealth(((Enemy) temp).getHealth() - 10);
            active = false;
        }
        if(temp instanceof Player) {
            ((Player) temp).setHealth(((Player) temp).getHealth() - 2);
            active = false;
        }
        move();
    }

    @Override
    public void render(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect((int) x + 80, (int) y + 50, 10, 2);
        g.setColor(Color.RED);
        g.fillRect((int)x + 80, (int)y + 50, widthBounds, heightBounds);
    }

    @Override
    public void move() {
        xMove();
    }

    private void xMove(){
        xMove = xSpeed;
        x += xMove;
    }

    private void checkOutOfBounds(){
        if (x > handler.getGame().getWidth())
            active = false;
    }
}
