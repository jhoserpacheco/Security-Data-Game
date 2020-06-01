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
 * Carga las mascaras
 */
public class Masks extends GameObject {

    private ArrayList<GameObject> gameObject = new ArrayList<>();
    private Sound maskSound;

    public Masks(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        gameObject = handler.getGameObject();
        bounds.x = 0; // Inicio de rectangulo colisión en x
        bounds.y = 0;// Inicio de rectangulo colisión en y
        bounds.width = texture.getWidth(); // Fin de rectangulo colisión en x
        bounds.height = texture.getHeight(); // Fin de rectangulo colisión en y  
        maskSound = new Sound(Assets.maskSound);
    }

    @Override
    public void update() {
        for (int i = 0; i < handler.getGameObject().size(); i++) {
            if (Physics.Collision(this, (GameObject) handler.getGameObject().get(i), handler.getGameObject())) { // Si colisiona con el jugador
                maskSound.play(); // Sonido de captura
                handler.setScore(handler.getScore()+1); // Se agrega al puntaje
                handler.getGameObject().remove((GameObject) handler.getGameObject().get(i)); // Se borra la máscara
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.drawImage(texture, (int) (position.getX() - handler.getGameCamera().getxOffset()),
                (int) (position.getY() - handler.getGameCamera().getyOffset()), null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }
}
