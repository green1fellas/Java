package game.entities;

import java.awt.*;
import game.Handler;

public class Player1 extends game.entities.Player {

    public Player1(Handler handler, float x, float y, String id) {
        super(handler, x, y, id);
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics g) {
        color = setColor();
        g.setColor(color);
        g.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void getInput() {

        yMove = 0;

        if (handler.getKeyManager().w && y > 0)
            yMove -= ySpeed;
        if (handler.getKeyManager().s && y < (handler.getGame().getHeight() - height))
            yMove += ySpeed;
    }

    @Override
    public void move() {
        y += yMove;
    }

    public Color setColor(){
        if(handler.getGame().getGameState().getP2().score == 1)
            return new Color(255, 255, 0);
        if(handler.getGame().getGameState().getP2().score == 2)
            return new Color(255, 0 , 0);
        else return new Color(0,255,0);
    }
}
