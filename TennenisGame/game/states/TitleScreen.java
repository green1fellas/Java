package game.states;

import game.Handler;
import game.gfx.Assets;
import game.gfx.Text;
import game.sound.Music;
import game.sound.Sound;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TitleScreen extends State {

    private int optionSelected = 0;
    private static Music titleMusic;

    public TitleScreen(Handler handler) {
        super(handler);
        titleMusic = new Music();
        titleMusic.playMusic("metalmusic.wav");
    }

    @Override
    public void tick() {
        if(handler.getKeyManager().justPressed[KeyEvent.VK_S] && optionSelected == 0) {
            Sound.playSound("select.wav");
            optionSelected = 1;
        }
        else if(handler.getKeyManager().justPressed[KeyEvent.VK_W] && optionSelected == 1) {
            Sound.playSound("select.wav");
            optionSelected = 0;
        }

        if(handler.getKeyManager().justPressed[KeyEvent.VK_ENTER] && optionSelected == 0) {
            titleMusic.stopMusic();
            State.setCurrentState(handler.getGame().getGameState());
        }
        else if(handler.getKeyManager().enter && optionSelected == 1)
            System.exit(0);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.titleScreen, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        Text.drawString(g, "Tennenis", 300, 100, false, Color.WHITE, Assets.title);
        if(optionSelected == 0) {
            Text.drawString(g, "> PLAY <", 350, 200, false, Color.WHITE, Assets.basic);
            Text.drawString(g, "  EXIT  ", 350, 250, false, Color.BLACK, Assets.basic);
        }
        else {
            Text.drawString(g, "  PLAY  ", 350, 200, false, Color.BLACK, Assets.basic);
            Text.drawString(g, "> EXIT <", 350, 250, false, Color.WHITE, Assets.basic);
        }
    }
}
