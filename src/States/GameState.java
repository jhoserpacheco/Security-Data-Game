/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Display.Handler;
import GameObject.Enemy;
import GameObject.GameObject;
import java.awt.Graphics;
import GameObject.Player;
import Graphics.Assets;
import Graphics.Sound;
import Graphics.Text;
import Graphics.Tiles.Tile;
import Graphics.Tiles.World;
import Main.State;
import Math.Vector2D;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

public class GameState extends State {

    private World world;

    private int score = 0;
    private ArrayList<GameObject> gameObject = new ArrayList<>();
    private Sound backSound;

    public GameState(Handler handler) { //Carga de los objetos del juego actual
        super(handler);
        world = new World(handler, new File("./generateWorld/world1.txt").getAbsolutePath());
        handler.setWorld(world);
        backSound = new Sound(Assets.clip);
        backSound.loop(); //música
        gameObject.add(new Player(handler, new Vector2D(world.getSpawnX(), world.getSpawnY()), 66, 127, Assets.stand1, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(2400, 200), 64, 64, Assets.mask, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(2300, 750), 64, 64, Assets.mask, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(400, 800), 64, 64, Assets.mask, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(200, 1200), 64, 64, Assets.mask, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(2300, 1200), 64, 64, Assets.mask, this, true));
        gameObject.add(0, new Enemy(handler, new Vector2D(200, 450), 64, 64, Assets.mask, this, true));
        handler.getGame().getGameCamera().move(0, 0);

    }

    @Override
    public void update() {

        world.update(); //actualizando mapa
        for (int i = 0; i < gameObject.size(); i++) {
            GameObject e = gameObject.get(i); //actualizando cada entidad del juego
            e.update();
        }

    }

    @Override
    public void draw(Graphics g) {

        world.draw(g); //dibujado del mapa
        g.drawImage(Assets.inteface, (int) (580), (int) (40), 200, 50, null);
        drawScore(g);
        g.drawImage(Assets.keys, (int) (200 - handler.getGameCamera().getxOffset()), (int) (200 - handler.getGameCamera().getyOffset()), null);
        g.drawImage(Assets.c, (int) (600 - handler.getGameCamera().getxOffset()), (int) (100 - handler.getGameCamera().getyOffset()), null);
        //g.drawImage(Assets.space, (int) (1900 - handler.getGameCamera().getxOffset()), (int) (170 - handler.getGameCamera().getyOffset()), null);

        for (int i = 0; i < gameObject.size(); i++) {
            GameObject e = gameObject.get(i); //dibujado de cada entidad del juego
            e.draw(g);
        }

    }

    public ArrayList<GameObject> getGameObject() {
        return gameObject;
    }

    public void setGameObject(ArrayList<GameObject> GameObject) {
        this.gameObject = GameObject;
    }

    public void addScore(int value) {
        score += value;
    }

    private void drawScore(Graphics g) {
        if (score != 6) {
            Text.DrawText(g, "Puntaje", new Vector2D(600, 80), Color.CYAN, Assets.font);
        }
        if (score < 6) {

            Text.DrawText(g, String.valueOf(score), new Vector2D(750, 80), Color.yellow, Assets.font);
        } else {
               Text.DrawText(g, "Completado", new Vector2D(590, 80), Color.GREEN, Assets.font);         
            //handler.getGame().setGameOver(); //temporal
            g.drawImage(Assets.floor, (int) (320 - handler.getGameCamera().getxOffset()), (int) (896 - handler.getGameCamera().getyOffset()), 64, 64, null);
            g.drawImage(Assets.floor, (int) (320 - handler.getGameCamera().getxOffset()), (int) (832 - handler.getGameCamera().getyOffset()), 64, 64, null);
            Tile.doorTile.setSolid(false);

        }
    }
}
