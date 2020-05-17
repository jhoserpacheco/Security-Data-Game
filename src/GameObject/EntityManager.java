/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Graphics.Assets;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class EntityManager extends Creature {

    

    public EntityManager(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }

}
