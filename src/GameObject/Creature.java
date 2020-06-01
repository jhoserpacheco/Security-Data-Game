package GameObject;

import Display.Handler;
import Graphics.Tiles.Tile;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Movimiento de los criaturas moviles (incluye el jugador)
 */
public abstract class Creature extends GameObject {

    public static final int DEFAULT_HEALTH = 10;
    protected float speed, xMove, yMove; //parámetros de velocidad del jugador
    public static final float DEFAULT_ACC = 5; //aceleración
    private static boolean grounded; //tocando el suelo

    public Creature(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        speed = DEFAULT_ACC;
        xMove = 0;
        yMove = 0;
        grounded = false;

    }

    /**
     * Ejecuta movimientos y detecta colisiones
     */
    public void move() {
        yHit();
        xHit();
        moveX();
        moveY();

    }

    /**
     * Movimiento horizontal
     */
    public void moveX() {
        // Izquierda
        if (xMove > 0) {
            int tx = (int) (position.getX() + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            
            if (!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                position.setX(position.getX() + xMove);// Si no está colisionando se mueve hacia la izquierda

            } else {

                position.setX(tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1);

            }
        // Derecha
        } else if (xMove < 0) {
            int tx = (int) (position.getX() + xMove + bounds.x) / Tile.TILEWIDTH;
            
            if (!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                position.setX(position.getX() + xMove);// Si no está colisionando se mueve hacia la derecha

            } else {
                position.setX(tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x);

            }
        }
    }

    /**
     * Movimiento vertical
     */
    public void moveY() {
        // Arriba
        if (yMove < 0) {
            int ty = (int) (position.getY() + yMove + bounds.y) / Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                position.setY(position.getY() + yMove);// Si no está colisionando se mueve hacia arriba

            } else {

                position.setY(ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y);

            }
        // Abajo
        } else if (yMove > 0) {
            int ty = (int) (position.getY() + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                position.setY(position.getY() + yMove);// Si no está colisionando se mueve hacia abajo
                grounded = false;

            } else {

                position.setY(ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1);

                grounded = true;

            }

        }
    }
    
//-----------

    public void xHit() {
        if (xMove > 0) {//izquierda Tile muerte
            int tx = (int) (position.getX() + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if ((collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                    && destructibleTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    || destructibleTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                if (winTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                        || winTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                    handler.getGame().getGameState().setGameOver(true); //si está colisionando, gana el juego
                } else {
                    handler.getGame().getGameState().setGameOver(false); //si está colisionando, fin del juego
                }
            }
        } else if (xMove < 0) { //derecha Tile muerte
            int tx = (int) (position.getX() + xMove + bounds.x) / Tile.TILEWIDTH;
            if ((collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                    && destructibleTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    || destructibleTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                if (winTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                        || winTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                    handler.getGame().getGameState().setGameOver(true); //si está colisionando, gana el juego                  
                } else {
                    handler.getGame().getGameState().setGameOver(false); //si está colisionando, fin del juego
                }
            }

        }
    }

    public void yHit() {
        if (yMove < 0) { //subir Tile muerte
            int ty = (int) (position.getY() + yMove + bounds.y) / Tile.TILEHEIGHT;
            if ((collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                    && destructibleTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || destructibleTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                if (winTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                        || winTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                    handler.getGame().getGameState().setGameOver(true); //si está colisionando, gana el juego              
                } else {
                    handler.getGame().getGameState().setGameOver(false); //si está colisionando, fin del juego
                }
            }
        } else if (yMove > 0) { //bajar Tile muerte
            int ty = (int) (position.getY() + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if ((collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                    && destructibleTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || destructibleTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                if (winTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                        || winTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                    handler.getGame().getGameState().setGameOver(true); //si está colisionando,gana el juego
                } else {
                    handler.getGame().getGameState().setGameOver(false); //si está colisionando, fin del juego

                }
            }

        }
    }

    public static boolean isGrounded() {
        return grounded;
    }

    public static void setGrounded(boolean grounded) {
        Creature.grounded = grounded;
    }

    public boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public boolean winTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isWin();
    }

    public boolean destructibleTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isDestructible();
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {

    }
}
