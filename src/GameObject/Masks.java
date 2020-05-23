/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Graphics.Assets;
import Graphics.Sound;
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
public class Masks extends GameObject {

    private ArrayList<GameObject> gameObject = new ArrayList<>();
    private Sound maskSound;

    public Masks(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        gameObject = handler.getGameObject();
        bounds.x = 0; //inicio de rectangulo colisión en x
        bounds.y = 0;//inicio de rectangulo colisión en y
        bounds.width = texture.getWidth(); //fin de rectangulo colisión en x
        bounds.height = texture.getHeight(); //fin de rectangulo colisión en y  
        maskSound = new Sound(Assets.maskSound);
    }

    @Override
    public void update() {
        for (int i = 0; i < handler.getGameObject().size(); i++) {
            if (Physics.Collision(this, (GameObject) handler.getGameObject().get(i), handler.getGameObject())) {
                //System.out.println("hit");
                maskSound.play();
                
                handler.setScore(handler.getScore()+1);
                handler.getGameObject().remove((GameObject) handler.getGameObject().get(i));
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
