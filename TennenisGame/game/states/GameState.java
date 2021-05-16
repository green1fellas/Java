package game.states;

import game.entities.Ball;
import game.entities.Player;
import game.entities.Player1;
import game.Handler;
import game.entities.Player2;
import game.gfx.Assets;
import game.gfx.Text;
import game.sound.Sound;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameState extends State {

    private boolean running;
    private boolean gameOver;
    private Player p1, p2;
    private Ball ball;

    public GameState(Handler handler){
        super(handler);
        init();
    }

    private void init(){
        running = false;
        gameOver = false;
        p1 = new Player1(handler,50,handler.getGame().getHeight()/2f - 60, "Player 1");
        p2 = new Player2(handler, handler.getGame().getWidth() - 58, handler.getGame().getHeight()/2f - 60, "Player 2");
        ball = new Ball(handler, handler.getGame().getWidth()/2f - 10, handler.getGame().getHeight()/2f - 10);
    }

    @Override
    public void tick() {

        if(!gameOver) {
            if (running) {
                p1.tick();
                p2.tick();
                ball.tick();
            } else {
                ball = new Ball(handler, handler.getGame().getWidth()/2f - 10, handler.getGame().getHeight()/2f - 10);
                this.getP1().setY(handler.getGame().getHeight()/2f - 60);
                this.getP2().setY(handler.getGame().getHeight()/2f - 60);
                if (handler.getKeyManager().justPressed[KeyEvent.VK_ENTER]) {
                    Sound.playSound("lazer.wav");
                    running = true;
                }
            }
        } else if(handler.getKeyManager().justPressed[KeyEvent.VK_ENTER]) {
            State.setCurrentState(new TitleScreen(handler));
            init();
        }
    }

    @Override
    public void render(Graphics g) {

        if(!gameOver) {
            if (!running)
                Text.drawString(g, "Press enter to start", handler.getGame().getWidth() / 2, 150, true, Color.WHITE, Assets.small);

            ball.render(g);
            p1.render(g);
            p2.render(g);
        } else if(this.getP1().score > this.getP2().score) {
            Text.drawString(g, "Player 1 wins !", handler.getGame().getWidth() / 2, 150, true, Color.WHITE, Assets.small);
            Text.drawString(g, "Press enter to continue", handler.getGame().getWidth() / 2, 200, true, Color.WHITE, Assets.small);
        } else if(this.getP1().score < this.getP2().score) {
            Text.drawString(g, "Player 2 wins !", handler.getGame().getWidth() / 2, 150, true, Color.WHITE, Assets.small);
            Text.drawString(g, "Press enter to continue", handler.getGame().getWidth() / 2, 200, true, Color.WHITE, Assets.small);
        }
        Text.drawString(g,"score:   " + this.getP1().score, (int)this.p1.getX() + 20, 40, false, Color.WHITE, Assets.small);
        Text.drawString(g,"score:   " + this.getP2().score, (int)this.p2.getX() - 75, 40, false, Color.WHITE, Assets.small);
    }

    // GETTERS & SETTERS

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Ball getBall() {
        return ball;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
