/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Math.Physics;
import Math.Vector2D;
import States.GameState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class Enemy extends Creature {

    ArrayList<GameObject> gameObject = new ArrayList<>();

    public Enemy(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        gameObject = gameState.getGameObject();
        bounds.x = 0; //inicio de rectangulo colisión en x
        bounds.y = 0;//inicio de rectangulo colisión en y
        bounds.width = texture.getWidth(); //fin de rectangulo colisión en x
        bounds.height = texture.getHeight(); //fin de rectangulo colisión en y  
        gameObject = gameState.getGameObject();
    }

    @Override
    public void update() {
        for (int i = 0; i < gameObject.size(); i++) {
            if (Physics.Collision(this, gameObject.get(i), gameObject)) {
                //System.out.println("hit");
                gameState.addScore(1);
                gameState.getGameObject().remove(gameObject.get(i));
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.drawImage(texture, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), null);
        //g.fillRect((int) (position.getX() + bounds.x - handler.getGameCamera().getxOffset()), (int) (position.getY() + bounds.y - handler.getGameCamera().getyOffset()) + 10, bounds.width, bounds.height); //dibujar rectangulo colisión

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }
}
