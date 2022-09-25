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
 * Importa los recursos
 */
public class Assets {

    private static final int width1 = 70, height1 = 127, width2 = 77, height2 = 125, width3 = 66, height3 = 127;
    public static BufferedImage[] dieAnim = new BufferedImage[6];
    public static BufferedImage stand1, stand2, stand3,//definir tiles
            shootUp, shootDown, shootLeft, shootRight,
            stand4, stand5, stand6, run1, run2, run3, runFlip1, background, secData, soundOn, soundOff,
            runFlip2, runFlip3, wall, floor, door, limits, shootTile, keys, space,
            dashRight, dashLeft, dashRight2, dashLeft2, dashRight3, dashLeft3, die1, die2, die3, die4, die5, die6, die7, c, mask, inteface,
            portal, frag, redButton, yellowButton, greenButton, blueButton, jugar, random, randomOver, jugarOver, salir1, salirOver;
    public static Font font;
    public static Clip backMusic, glitchSound, maskSound, shock;

    public static void init() throws IOException, FontFormatException, LineUnavailableException, UnsupportedAudioFileException {
        Sprite sprite = new Sprite(Loader.ImageLoader("Tiles/SpriteSheet.png"));
        Sprite tiles = new Sprite(Loader.ImageLoader("Tiles/tile.png"));
        Sprite die = new Sprite(Loader.ImageLoader("Tiles/dieTile.png"));
        Sprite sTile = new Sprite(Loader.ImageLoader("Tiles/shootTile.png"));
        // SpriteSheet
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

        // Dash
        dashRight = Loader.ImageLoader("Tiles/glitchRight.png");
        dashLeft = Loader.ImageLoader("Tiles/glitchLeft.png");
        dashRight2 = Loader.ImageLoader("Tiles/glitchRight2.png");
        dashLeft2 = Loader.ImageLoader("Tiles/glitchLeft2.png");
        dashRight3 = Loader.ImageLoader("Tiles/glitchRight3.png");
        dashLeft3 = Loader.ImageLoader("Tiles/glitchLeft3.png");

        // Animacion de muerte
        die1 = die.crop(0, 0, width3, height3);
        die2 = die.crop(width3, 0, width3, height3);
        die3 = die.crop(width3 * 2, 0, width3, height3);
        die4 = die.crop(width3 * 3, 0, width3, height3);
        die5 = die.crop(width3 * 4, 0, width3, height3);
        die6 = die.crop(width3 * 5, 0, width3, height3);
        dieAnim[0] = die1;
        dieAnim[1] = die2;
        dieAnim[2] = die3;
        dieAnim[3] = die4;
        dieAnim[4] = die5;
        dieAnim[5] = die6;

        // disparos
        shootLeft = sTile.crop(202, 0, 94, 54);
        shootRight = sTile.crop(108, 0, 94, 54);
        shootUp = sTile.crop(0, 0, 54, 94);
        shootDown = sTile.crop(54, 0, 54, 94);

        // Texturas
        wall = tiles.crop(64, 160, 32, 32);
        floor = tiles.crop(32, 96, 32, 32);
        door = tiles.crop(160, 32, 32, 32);
        limits = limits = tiles.crop(32, 224, 32, 32);
        portal = tiles.crop(32, 256, 32, 32);
        frag = tiles.crop(160, 192, 32, 32);

        //Interfaz
        keys = Loader.ImageLoader("Tiles/botones.png");
        c = Loader.ImageLoader("Tiles/c.png");
        mask = Loader.ImageLoader("Tiles/mask.png");
        inteface = Loader.ImageLoader("Tiles/interface.png");
        redButton = Loader.ImageLoader("Tiles/redButton.png");
        greenButton = Loader.ImageLoader("Tiles/greenButton.png");
        yellowButton = Loader.ImageLoader("Tiles/yellowButton.png");
        blueButton = Loader.ImageLoader("Tiles/blueButton.png");
        jugar = Loader.ImageLoader("Tiles/jugar.png");
        random = Loader.ImageLoader("Tiles/random.png");
        randomOver = Loader.ImageLoader("Tiles/randomOver.png");
        jugarOver = Loader.ImageLoader("Tiles/jugarOver.png");
        salir1 = Loader.ImageLoader("Tiles/salir.png");
        salirOver = Loader.ImageLoader("Tiles/salirOver.png");
        background = Loader.ImageLoader("Tiles/back.jpg");
        secData = Loader.ImageLoader("Tiles/securityData.png");
        soundOn = Loader.ImageLoader("Tiles/soundOn.png");
        soundOff = Loader.ImageLoader("Tiles/soundOff.png");

        // Fuente
        font = Loader.loadFont("Tiles/font.ttf", 42);

        // Soundtrack
        backMusic = Loader.loadSound("Tiles/soundtrack.wav");
        glitchSound = Loader.loadSound("Tiles/glitchSound.wav");
        maskSound = Loader.loadSound("Tiles/maskSound.wav");
        shock = Loader.loadSound("Tiles/shock.wav");
    }

}
