/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class GameState extends State {

    private World world;
    private Worlds worlds;

    private ArrayList<Animation> dieAnimation = new ArrayList<>();
    private ArrayList<GameObject> gameObject = new ArrayList<>();
    private final Sound backSound, glitchSound;

    public GameState(Handler handler, int level) { //Carga de los objetos del juego actual
        super(handler);

        worlds = new Worlds(handler, level);
        world = handler.getWorld();
        Tile.doorTile.setSolid(true);
        backSound = new Sound(Assets.backMusic);
        glitchSound = new Sound(Assets.glitchSound);
        handler.setScore(0);
        handler.setGameObject(EntityManager.EntityManager(handler, level));
        gameObject = handler.getGameObject();
        backSound.loop(); //música
        backSound.changeVolume(-15f);
        glitchSound.changeVolume(-8f);

    }

    @Override
    public void update() {

        if ((Keyboard.DASH && Keyboard.LEFT && !Keyboard.RIGHT) || (Keyboard.DASH && !Keyboard.LEFT && Keyboard.RIGHT)) {
            glitchSound.start();
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
            System.out.println("dieUpdate");
            e.update();
            if (!e.isRunning()) {
                System.out.println("dieRemove " + i);
                dieAnimation.remove(i);
            }
        }

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

        //g.drawImage(Assets.space, (int) (1900 - handler.getGameCamera().getxOffset()), (int) (170 - handler.getGameCamera().getyOffset()), null);
        for (int i = 0; i < handler.getGameObject().size(); i++) {
            GameObject e = (GameObject) handler.getGameObject().get(i); //dibujado de cada entidad del juego
            e.draw(g);

        }
        for (int i = 0; i < dieAnimation.size(); i++) {
            Animation e = dieAnimation.get(i);
            g.drawImage(e.GetCurrentFrame(), (int) (handler.getPlayer().getPosition().getX() - handler.getGameCamera().getxOffset()),
                    (int) (handler.getPlayer().getPosition().getY() - handler.getGameCamera().getyOffset()), null);
        }
    }

    public void playDieAnimation() {
        System.out.println("dieAnim");
        dieAnimation.add(new Animation(Assets.dieAnim,
                50, new Vector2D((int) (handler.getPlayer().getPosition().getX() - handler.getGameCamera().getxOffset()),
                        (int) (handler.getPlayer().getPosition().getY() - handler.getGameCamera().getyOffset()))));
    }

    public void setGameOver(boolean win) {

        playDieAnimation();
        glitchSound.stop();

       State.setState(new GameOver(handler, win));
    }

    public Sound getBackSound() {
        return backSound;
    }

    public ArrayList<GameObject> getGameObject(){
        return gameObject;
    }

    public void setGameObject(ArrayList<GameObject> GameObject) {
        this.gameObject = GameObject;
    }

    private void drawScore(Graphics g) {

        if (handler.getScore() != 6) {
            Text.DrawText(g, "Puntaje", new Vector2D(600, 80), Color.CYAN, Assets.font);
        }
        if (handler.getScore() < 6) {

            Text.DrawText(g, String.valueOf(handler.getScore()), new Vector2D(750, 80), Color.yellow, Assets.font);
        } else {
            Text.DrawText(g, "Completado", new Vector2D(590, 80), Color.GREEN, Assets.font);
            if (handler.getLevel() <= 2) {
                g.drawImage(Assets.floor, (int) (320 - handler.getGameCamera().getxOffset()), (int) (896 - handler.getGameCamera().getyOffset()), 64, 64, null);
                g.drawImage(Assets.floor, (int) (320 - handler.getGameCamera().getxOffset()), (int) (832 - handler.getGameCamera().getyOffset()), 64, 64, null);
            } else if (handler.getLevel() == 3) {
                g.drawImage(Assets.floor, (int) (5568 - handler.getGameCamera().getxOffset()), (int) (512 - handler.getGameCamera().getyOffset()), 64, 64, null);
                g.drawImage(Assets.floor, (int) (5568 - handler.getGameCamera().getxOffset()), (int) (448 - handler.getGameCamera().getyOffset()), 64, 64, null);
            }
            Tile.doorTile.setSolid(false);

        }
    }
}
