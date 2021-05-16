package game;

import game.input.KeyManager;

public class Handler {

    private KeyManager keyManager;
    private Game game;

    public Handler(Game game){
        this.game = game;
        this.keyManager = game.getKeyManager();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }
}
