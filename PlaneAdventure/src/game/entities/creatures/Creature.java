package game.entities.creatures;

import game.Handler;
import game.entities.Entity;

import java.awt.*;

public class Creature extends Entity {

    protected int health = 100;
    protected int red, green;

    public Creature(Handler handler, float x, float y, int depth) {
        super(handler, x, y, depth);

        widthBounds = 95;
        heightBounds = 58;
        green = 255;
        red = 0;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void move() {
        xMove();
        yMove();
    }

    protected void healthBar(Graphics g, float x, float y){
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 30, 5);
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, (30*health)/100, 5);
        g.setColor(Color.BLACK);
        g.drawRect((int)x, (int)y, 30, 5);
    }

    protected void xMove(){
        x += xMove;
    }

    protected void yMove(){
        y += yMove;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }
}
