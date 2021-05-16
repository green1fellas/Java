package game.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static FontLoader fontLoader;
    public static BufferedImage titleScreen;
    public static Font title, basic, small;

    public static void init(){

        fontLoader = new FontLoader();

        titleScreen = ImageLoader.loadImage("/titleScreen.jpg");

        title = fontLoader.loadFont("title.ttf", 50);
        basic = fontLoader.loadFont("Minecraft.ttf", 30);
        small = fontLoader.loadFont("Minecraft.ttf", 15);
    }
}
