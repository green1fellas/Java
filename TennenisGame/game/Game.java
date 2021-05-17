package game;

// import game.display.Display;
// import game.gfx.Assets;
// import game.input.KeyManager;
// import game.states.GameState;
// import game.states.State;
// import game.states.TitleScreen;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Handler implements Runnable {

    private Display display;
    private Handler handler;
    private KeyManager keyManager;
    private GameState gameState;
    private TitleScreen titleScreen;

    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        keyManager = new KeyManager();
        Assets.init();
        handler = new Handler(this);
        display = new Display(title, width, height);
        titleScreen = new TitleScreen(handler);
        gameState = new GameState(handler);
        State.setCurrentState(titleScreen);
        display.getFrame().addKeyListener(keyManager);
    }

    private void tick(){
        keyManager.tick();

        if(State.getCurrentState() != null)
            State.getCurrentState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);

        if(State.getCurrentState() != null)
            State.getCurrentState().render(g);
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
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000){
                ticks = 0;
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
        thread.start();
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public GameState getGameState() {
        return gameState;
    }

    public TitleScreen getTitleScreen() {
        return titleScreen;
    }
}
