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
 */
public class EntityManager {

    private static ArrayList gameObject;

    public static ArrayList EntityManager(Handler handler, int level) {

        gameObject = new ArrayList<>();

        if (handler.getLevel() == 1) {
            gameObject.clear();
            gameObject.add(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1, handler.getGame().getGameState(), true));
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
            gameObject.add(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2400,50), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 750), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(400, 800), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 1200), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2300, 1200), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(200, 450), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
        if (handler.getLevel() == 3) {
            gameObject.clear();
            gameObject.add(new Player(handler, new Vector2D(handler.getWorld().getSpawnX(), handler.getWorld().getSpawnY()), 66, 127, Assets.stand1,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(650,170), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2240,80), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2944, 130), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(3968,300), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(5568,32), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            gameObject.add(0, new Masks(handler, new Vector2D(2816,448), 64, 64, Assets.mask,  handler.getGame().getGameState(), true));
            handler.getGame().getGameCamera().move(0, 0);
        }
        return gameObject;
    }
}
