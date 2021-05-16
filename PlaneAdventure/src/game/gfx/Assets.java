package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage[] player, enemy, enemy2;
    public static BufferedImage buildings, clouds, clouds2, bullet;

    public static void init(){

        player = new BufferedImage[2];
        enemy = new BufferedImage[2];
        enemy2 = new BufferedImage[2];

        SpriteSheet planesSheet = new SpriteSheet(ImageLoader.loadImage("/textures/planes.png"));
        SpriteSheet buildingsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/skyscrapers.png"));

        player[0] = planesSheet.crop(215, 0, 109, 82);
        player[1] = planesSheet.crop(320,1,109,82);

        enemy[0] = planesSheet.crop(220,210, 106, 82);
        enemy[1] = planesSheet.crop(329, 210, 106, 82);

        enemy2[0] = planesSheet.crop(220,300, 106, 82);
        enemy2[1] = planesSheet.crop(328, 301, 106, 82);

        buildings = buildingsSheet.crop(0,150, 220, 167);
        clouds = ImageLoader.loadImage("/textures/clouds.png");
        clouds2 = ImageLoader.loadImage("/textures/clouds2.png");
        bullet = ImageLoader.loadImage("/textures/bullet.png");

    }
}
