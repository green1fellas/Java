package game.states;

import java.awt.*;
import game.Handler;

public abstract class State {

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    private static State currentState = null;

    public abstract void tick();

    public abstract void render(Graphics g);

    // GETTERS & SETTERS

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }
}
