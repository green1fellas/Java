package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

import java.awt.*;

public class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);

    }

    @Override
    public void tick() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {

    }
}
