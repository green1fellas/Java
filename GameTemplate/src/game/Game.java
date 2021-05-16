package game;

import game.gfx.Assets;
import game.display.Display;
import game.input.KeyManager;
import game.input.MouseManager;
import game.states.GameState;
import game.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private String title;
    private int width, height;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    // States
        GameState gameState;

    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    private Handler handler;

    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init(){
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameState = new GameState(handler);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if(State.getState() != null)
            State.getState().render(g);

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
        stop();
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start(); // runs run method
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // GETTERS & SETTERS


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
}
