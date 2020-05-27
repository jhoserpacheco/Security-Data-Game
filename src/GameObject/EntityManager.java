/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Graphics.Assets;
import Math.Vector2D;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 * Clase encargada de la carga de entidades globales
 */
public class EntityManager {

    private static ArrayList gameObject;

    public static ArrayList EntityManager(Handler handler, int level) {

        gameObject = new ArrayList<>();

        if (handler.getLevel() == 1) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());
            gameObject.add(0, new Masks(handler, new Vector2D(2400, 200), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 750), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(400, 800), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 1200), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 1200), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 450), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
        if (handler.getLevel() == 2) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());
            gameObject.add(0, new Masks(handler, new Vector2D(2400, 50), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 750), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(400, 800), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 1200), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 1200), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 450), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
        if (handler.getLevel() == 3) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(650, 170), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2240, 80), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2944, 130), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(3968, 300), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(5568, 32), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2816, 448), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }                
        if (handler.getLevel() == 4) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(1472, 64), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(960, 256), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(384, 320), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1088, 1472), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(384, 1216), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(128, 1472), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
        if (handler.getLevel() == 5) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(1600, 1728), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2432, 64), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1920, 64), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1216, 960), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(512, 64), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(192, 512), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
         if (handler.getLevel() == 6) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(576, 1728), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(576, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(64, 1216), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(64, 640), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1728, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1728, 1728), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
        }
        if (handler.getLevel() == 7) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(2432, 64), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1984, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1152, 192), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(768, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(384, 832), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(384, 1472), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
        }
        if (handler.getLevel() == 8) {
            gameObject.clear();
            handler.setPlayer(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
            gameObject.add(handler.getPlayer());

            gameObject.add(0, new Masks(handler, new Vector2D(384, 1472), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(448, 704), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(896, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1536, 128), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(1536, 1536), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2432, 1024), 64, 64, Assets.mask, handler.getGame().getGameState(), true));
        }        
                         
        return gameObject;
    }
}
