/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Graphics.Tiles.Sprite;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author JUAN
 */
public class Assets {

    private static final int width1 = 70, height1 = 127, width2 = 77, height2 = 125;
    public static BufferedImage shootUp = null;
    public static BufferedImage shootDown = null;
    public static BufferedImage shootLeft = null;
    public static BufferedImage shootRight = null;
    public static BufferedImage stand1, stand2, stand3, //definir tiles
            stand4, stand5, stand6, run1, run2, run3, runFlip1,background,secData,
            runFlip2, runFlip3, wall, floor, door, limits, shootTile, keys, space,
            dashRight, dashLeft, dashRight2, dashLeft2, dashRight3, dashLeft3, c, mask, inteface,
            portal, frag, redButton, yellowButton, greenButton, blueButton, jugar, jugarOver, salir1, salirOver;
    public static Font font;
    public static Clip clip;

    public static void init() throws IOException, FontFormatException, LineUnavailableException, UnsupportedAudioFileException {
        Sprite sprite = new Sprite(Loader.ImageLoader("Tiles/SpriteSheet.png"));
        Sprite tiles = new Sprite(Loader.ImageLoader("Tiles/tile.png"));
        Sprite shootTile = new Sprite(Loader.ImageLoader("Tiles/shootTile.png"));
        stand1 = sprite.crop(0, 0, width1, height1);
        stand2 = sprite.crop(width1, 0, width1, height1);
        stand3 = sprite.crop(width1 * 2, 0, width1, height1);
        stand4 = sprite.crop(width1 * 3, 0, width1, height1);
        stand5 = sprite.crop(width1 * 4, 0, width1, height1);
        stand6 = sprite.crop(width1 * 5, 0, width1, height1);
        run1 = sprite.crop(0, height1, width2, height2);
        run2 = sprite.crop(width2, height1, width2, height2);
        run3 = sprite.crop(width2 * 2, height1, width2, height2);
        runFlip1 = sprite.crop(width2 * 3, height1, width2, height2);
        runFlip2 = sprite.crop(width2 * 4, height1, width2, height2);
        runFlip3 = sprite.crop(width2 * 5, height1, width2, height2);
        shootUp = shootTile.crop(0, 0, 54, 94);
        shootDown = shootTile.crop(54, 0, 54, 94);
        shootLeft = shootTile.crop(202, 0, 94, 54);
        shootRight = shootTile.crop(108, 0, 94, 54);
        wall = tiles.crop(64, 160, 32, 32);
        floor = tiles.crop(32, 96, 32, 32);
        door = tiles.crop(160, 32, 32, 32);
        limits = limits = tiles.crop(32, 224, 32, 32);
        portal = tiles.crop(32, 256, 32, 32);
        frag = tiles.crop(160, 192, 32, 32);
        keys = Loader.ImageLoader("Tiles/botones.png");
        space = Loader.ImageLoader("Tiles/Space.png");
        dashRight = Loader.ImageLoader("Tiles/glitchRight.png");
        dashLeft = Loader.ImageLoader("Tiles/glitchLeft.png");
        dashRight2 = Loader.ImageLoader("Tiles/glitchRight2.png");
        dashLeft2 = Loader.ImageLoader("Tiles/glitchLeft2.png");
        dashRight3 = Loader.ImageLoader("Tiles/glitchRight3.png");
        dashLeft3 = Loader.ImageLoader("Tiles/glitchLeft3.png");
        c = Loader.ImageLoader("Tiles/c.png");
        mask = Loader.ImageLoader("Tiles/mask.png");
        inteface = Loader.ImageLoader("Tiles/interface.png");
        redButton = Loader.ImageLoader("Tiles/redButton.png");
        greenButton = Loader.ImageLoader("Tiles/greenButton.png");
        yellowButton = Loader.ImageLoader("Tiles/yellowButton.png");
        blueButton = Loader.ImageLoader("Tiles/blueButton.png");
        font = Loader.loadFont("Tiles/font.ttf", 42);
        jugar = Loader.ImageLoader("Tiles/jugar.png");
        jugarOver = Loader.ImageLoader("Tiles/jugarOver.png");
        salir1 = Loader.ImageLoader("Tiles/salir.png");
        salirOver = Loader.ImageLoader("Tiles/salirOver.png");
        background = Loader.ImageLoader("Tiles/back.jpg");
        secData = Loader.ImageLoader("Tiles/securityData.png");
        clip = Loader.loadSound("Tiles/soundtrack.wav");
    }

}
