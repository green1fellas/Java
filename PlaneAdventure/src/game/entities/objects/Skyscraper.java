package game.entities.objects;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skyscraper extends Entity {

    private BufferedImage skyscraper;

    public Skyscraper(Handler handler, float x, float y, int depth) {
        super(handler, x, y, depth);
        xSpeed = 2;
        skyscraper = Assets.buildings;
    }

    @Override
    public void tick() {
        if(x < (-215))
            x = 0;
        else
            move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(skyscraper, (int)x,(int)y,null);
        g.drawImage(skyscraper, (int)x+ Assets.buildings.getWidth(),(int)y,null);
        g.drawImage(skyscraper, (int)x+Assets.buildings.getWidth()*2,(int)y,null);
        g.drawImage(skyscraper, (int)x+Assets.buildings.getWidth()*3,(int)y,null);
    }

    public void move() {
        xMove();
        yMove();
    }

    private void xMove(){
        xMove = -xSpeed;
        x += xMove;
    }

    private void yMove(){
        y += yMove;
    }
}
