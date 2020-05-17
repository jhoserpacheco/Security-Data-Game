/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author JUAN
 */
public abstract class GameObject {

    protected BufferedImage texture;
    protected Vector2D position;
    protected GameState gameState;
    protected Handler handler;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean direction;
    protected boolean die;

    public GameObject(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        this.handler = handler;
        this.position = position;
        this.texture = texture;
        this.gameState = gameState;
        this.width = width;
        this.height = height;
        this.direction = direction;

        bounds = new Rectangle(0, 0, width, height);

    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



}
