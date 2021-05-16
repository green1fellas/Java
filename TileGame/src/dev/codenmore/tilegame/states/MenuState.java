package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler){

        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    public void tick() {
        uiManager.tick();

        // Temporary
        handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);
    }

    public void render(Graphics g){
        uiManager.render(g);
    }
}
