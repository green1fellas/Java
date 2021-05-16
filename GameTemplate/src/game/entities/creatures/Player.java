package game.entities.creatures;

import game.Handler;

public class Player extends Creature {

    private Handler handler;
    private float x, y;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y);
    }
}