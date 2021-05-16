package game;


import game.input.KeyManager;
import game.input.MouseManager;

public class Handler {

    private Game game;

    public Handler(Game game){
        this.game = game;
    }

    // GETTERS & SETTERS

    public Game getGame() {
        return game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }


    public void setGame(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
}
