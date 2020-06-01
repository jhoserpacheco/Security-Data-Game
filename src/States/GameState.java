package States;

import Display.Handler;
import GameObject.EntityManager;
import GameObject.GameObject;
import Graphics.Animation;
import java.awt.Graphics;
import Graphics.Assets;
import Graphics.Sound;
import Graphics.Text;
import Graphics.Tiles.Tile;
import Graphics.Tiles.World;
import Input.Keyboard;
import Main.State;
import Math.Vector2D;
import java.awt.Color;
import Main.Worlds;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Estado de juego
 */
public class GameState extends State {

    private World world;
    private Worlds worlds;

    private ArrayList<Animation> dieAnimation = new ArrayList<>();
    private ArrayList<GameObject> gameObject = new ArrayList<>();
    private final Sound backSound, glitchSound,shock;


    //private Timer timer;
    public GameState(Handler handler, int level) { //Carga de los objetos del juego actual
        super(handler);
        State.setState(handler.getGame().getGameState());
        worlds = new Worlds(handler, level);
        world = handler.getWorld();
        Tile.doorTile.setSolid(true);
        backSound = new Sound(Assets.backMusic);
        glitchSound = new Sound(Assets.glitchSound);
        shock = new Sound(Assets.shock);
        handler.setScore(0);
        handler.setGameObject(EntityManager.EntityManager(handler, level));
        gameObject = handler.getGameObject();
        backSound.loop(); //música
        backSound.changeVolume(-15f);
        glitchSound.changeVolume(-8f);
        shock.changeVolume(-4f);
        State.setState(handler.getGame().getGameState());

    }

    @Override
    public void update() {
        dieAnimation = dieAnimation;
        if ((Keyboard.DASH && Keyboard.LEFT && !Keyboard.RIGHT) || (Keyboard.DASH && !Keyboard.LEFT && Keyboard.RIGHT)) {
            glitchSound.start();
        } else {
            glitchSound.stop();
        }
        if (Keyboard.PAUSE) {
            try {

                glitchSound.stop();
                State.setState(new PauseState(handler));
            } catch (InterruptedException ex) {
                Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        world.update(); //actualizando mapa
        for (int i = 0; i < handler.getGameObject().size(); i++) {
            GameObject e = (GameObject) handler.getGameObject().get(i); //actualizando cada entidad del juego
            e.update();
        }

        for (int i = 0; i < dieAnimation.size(); i++) {
            Animation e = dieAnimation.get(i);

            e.update();
            if (!e.isRunning()) {

                dieAnimation.remove(i);
            }
        }
        //timer.update();
    }

    @Override
    public void draw(Graphics g) {

        world.draw(g); //dibujado del mapa
        g.drawImage(Assets.inteface, (int) (580), (int) (40), 200, 50, null);
        drawScore(g);
        if (handler.getLevel() == 1) {
            g.drawImage(Assets.keys, (int) (200 - handler.getGameCamera().getxOffset()), (int) (200 - handler.getGameCamera().getyOffset()), null);
            g.drawImage(Assets.c, (int) (600 - handler.getGameCamera().getxOffset()), (int) (100 - handler.getGameCamera().getyOffset()), null);
        }

        for (int i = 0; i < handler.getGameObject().size(); i++) {
            GameObject e = (GameObject) handler.getGameObject().get(i); //dibujado de cada entidad del juego
            e.draw(g);

        }
        for (int i = 0; i < dieAnimation.size(); i++) {
            Animation e = dieAnimation.get(i);
            g.drawImage(e.GetCurrentFrame(), (int) (handler.getPlayer().getPosition().getX() - handler.getGameCamera().getxOffset()),
                    (int) (handler.getPlayer().getPosition().getY() - handler.getGameCamera().getyOffset()), null);
        }
        //timer.draw(g);
    }

    public void playDieAnimation() { //animación de muerte

        dieAnimation.add(new Animation(handler, Assets.dieAnim,
                120, new Vector2D((int) (handler.getPlayer().getPosition().getX() - handler.getGameCamera().getxOffset()),
                        (int) (handler.getPlayer().getPosition().getY() - handler.getGameCamera().getyOffset()))));

    }

    public void setGameOver(boolean win) { //clase para llamar gameOver dependiendo si pasa de nivel o no
        if (win == false) {
            
            playDieAnimation();
            handler.getPlayer().gameOver(true);
            glitchSound.stop();
            shock.play();
            State.setState(handler.getGame().getGameState());
        } else {
            glitchSound.stop();
            State.setState(new GameOver(handler, win));

        }

    }

    public Sound getBackSound() {
        return backSound;
    }

    public ArrayList<GameObject> getGameObject() {
        return gameObject;
    }

    public void setGameObject(ArrayList<GameObject> GameObject) {
        this.gameObject = GameObject;
    }

    private void drawScore(Graphics g) { //dibujado de interfaz
        Text.DrawText(g, "Nivel " + String.valueOf(handler.getLevel()), new Vector2D(100, 80), Color.yellow, Assets.font);
        if (handler.getScore() != 6) {
            Text.DrawText(g, "Puntaje", new Vector2D(600, 80), Color.CYAN, Assets.font);
        }
        if (handler.getScore() < 6) {

            Text.DrawText(g, String.valueOf(handler.getScore()), new Vector2D(750, 80), Color.yellow, Assets.font);
        } else {
            Text.DrawText(g, "Completado", new Vector2D(590, 80), Color.GREEN, Assets.font);
            Tile.doorTile.setSolid(false);

        }
    }
}
