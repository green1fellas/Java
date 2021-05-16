package game.states;

import java.awt.*;

import game.Handler;
import game.entities.EntityManager;
import game.entities.creatures.Enemy;
import game.entities.creatures.Player;
import game.entities.objects.Bullet;
import game.entities.objects.Cloud;
import game.entities.objects.Skyscraper;
import game.gfx.Animation;
import game.gfx.Assets;

public class GameState extends State {

    private EntityManager entityManager;
    private Color sky;
    private Enemy currShooter;

    // Timer
    private long start, end, time;
    private int level = 0;

    public GameState(Handler handler){
        super(handler);
        entityManager = new EntityManager(handler, new Player(handler, 10, 80, 2));
        entityManager.addEntity(new Skyscraper(handler, 0,315, 3));
        entityManager.addEntity(new Cloud(handler, 0,0,3, Assets.clouds));
        entityManager.addEntity(new Cloud(handler,0,0, 0,Assets.clouds2));
        sky = new Color(158,242,255);
        start = System.currentTimeMillis();
        end = start;
    }

    public void tick(){
        time = end - start;
        end = System.currentTimeMillis();
        if(time > 5000*60){
            System.out.println("1 minute passed!");
            handler.getGame().stop();
        }
        enemyCreator();
        addBullet();
        entityManager.tick();
    }

    public void render(Graphics g){
        g.setColor(sky);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        entityManager.render(g);
        if(this.getEntityManager().getPlayer() == null || this.getEntityManager().getPlayer().isDead())
            g.drawString("You lose", handler.getGame().getWidth() / 2 - 25, 150);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void addBullet(){
        if(this.getEntityManager().getPlayer().isShoot()) {
                entityManager.addEntity(new Bullet(handler, this.entityManager.getPlayer().getX() + 18, this.entityManager.getPlayer().getY(), 1, 1));
                this.getEntityManager().getPlayer().setShoot(false);
        }
        if(currShooter != null && currShooter.isShoot()){
            entityManager.addEntity(new Bullet(handler, currShooter.getX()-87, currShooter.getY()-12, 1, -1));
            currShooter.setShoot(false);
        }
    }

    public void enemyCreator(){
        int enemyCount = (int)(Math.random()*4);
        int randSpawnY = (int)(Math.random()*400);
        if(time > 2000 && !entityManager.containsEntity(new Enemy(handler,0,0,0,0,0,null))) {
            for(int i = 0; i < enemyCount; i++) {
                entityManager.addEntity(new Enemy(handler, 700, randSpawnY + (i+1)*50, 2, -1, 2, new Animation(20, Assets.enemy)));
            }
        }
    }

    public Enemy getCurrShooter() {
        return currShooter;
    }

    public void setCurrShooter(Enemy currShooter) {
        this.currShooter = currShooter;
    }
}
