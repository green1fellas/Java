package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    // Animations
    private Animation animDown, animUp, animLeft, animRight;

    // Attack timer
    private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;

    // Inventory
    private Inventory inventory;

    public Player(Handler handler, float x, float y){

        super(handler, x,y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        // Animations
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);

        inventory = new Inventory(handler);

        speed = 5;
    }

    public void tick(){

        // Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();

        // Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        // Attack
        checkAttacks();

        // Inventory
        inventory.tick();
    }

    private void checkAttacks(){

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCoolDown)
            return;

        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(inventory.isActive())
            return;

        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width /2 - arSize/2;
            ar.y = cb.y - arSize;
        } else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width /2 - arSize/2;
            ar.y = cb.y + cb.height;
        } else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize/2;
        } else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize/2;
        } else {
            return;
        }

        attackTimer = 0;

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }

    @Override
    public void die(){
        System.out.println("You lose");
    }

    private void getInput(){

        xMove = 0;
        yMove = 0;

        if(inventory.isActive())
            return;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;

    }

    public void render(Graphics g){

        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width , height,null);

//        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//                   (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                    bounds.width, bounds.height);
    }

    public void postRender(Graphics g){
        inventory.render(g);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
            return animRight.getCurrentFrame();
        else if (yMove < 0)
            return animUp.getCurrentFrame();
        else if (yMove > 0)
            return animDown.getCurrentFrame();
        else
            return Assets.player;
    }

    // GETTERS & SETTERS

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
