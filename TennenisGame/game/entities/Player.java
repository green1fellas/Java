package game.entities;

import game.Handler;

import java.awt.*;

public abstract class Player extends Entity{

    public float ySpeed = 10;
    public int width = 15, height = 120;
    public int score;
    public String id;
    public Color color;
    public int red, green, blue;

    public Player(Handler handler, float x, float y, String id){
        super(handler, x, y);
        this.id = id;
        yMove = 0;
        score = 0;
        red = 255;
        green = 255;
        blue = 255;
    }

    public abstract void getInput();

    public Rectangle getCollisionBounds(){
        return new Rectangle((int)x, (int)y, width, height);
    }
}
