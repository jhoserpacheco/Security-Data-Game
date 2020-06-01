package GameObject;

import Display.Handler;
import Graphics.Tiles.Tile;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * NO IMPLEMENTADO. Se encarga del disparo
 */
public class Shoot extends Creature {

    ArrayList<GameObject> gameObject = new ArrayList<>();

    public Shoot(Handler handler, Vector2D position, int width, int height, int xDir, int yDir, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        height = height;
        width = width;
        xDir = xDir;
        yDir = yDir;
        handler = handler;
        gameObject = gameState.getGameObject();
        direction = direction;
        bounds.x = 0; // Inicio de rectangulo colisión en x
        bounds.y = 0; // Inicio de rectangulo colisión en y
        bounds.width = texture.getWidth() - 30; // Fin de rectangulo colisión en x
        bounds.height = 5; // Fin de rectangulo colisión en y

    }

    @Override
    public void update() {

        if (direction) {
            position.setX(position.getX() + 10);
        }
        if (!direction) {
            position.setX(position.getX() - 10);
        }

        if (position.getX() < 0 || position.getX() > 800
                || collisionWithTile((int) (((position.getX()
                        + xMove + bounds.width + handler.getGameCamera().getxOffset())
                        / Tile.TILEWIDTH)), (int) (((position.getY()
                        + bounds.y + handler.getGameCamera().getyOffset())
                        / Tile.TILEHEIGHT)))) {

            gameState.getGameObject().remove(this);

        }

    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(texture, (int) (position.getX()), (int) (position.getY()), width, height, null);
        g.fillRect((int) (position.getX() + bounds.x), (int) (position.getY() + bounds.y) + 10, bounds.width, bounds.height); //dibujar rectangulo colisión

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }

}
