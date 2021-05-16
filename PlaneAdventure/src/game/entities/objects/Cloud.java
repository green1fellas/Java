package game.entities.objects;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cloud extends Entity {

    private BufferedImage img;

    public Cloud(Handler handler, float x, float y, int depth, BufferedImage img) {
        super(handler, x, y, depth);
        xSpeed = 3;
        this.img = img;
    }

    @Override
    public void tick() {
        if(x < (-311))
            x = 0;
        else
            move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, (int)x,(int)y,null);
        g.drawImage(img, (int)x + img.getWidth(),(int)y,null);
        g.drawImage(img, (int)x + img.getWidth()*2,(int)y,null);
        g.drawImage(img, (int)x + img.getWidth()*3,(int)y,null);
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
