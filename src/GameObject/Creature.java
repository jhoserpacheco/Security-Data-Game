/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Graphics.Tiles.Tile;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author JUAN
 */
public abstract class Creature extends GameObject {

    public static final int DEFAULT_HEALTH = 10;
    protected int health; //vida
    protected float speed, xMove, yMove;
    public static final float DEFAULT_ACC = 4; //aceleración
    private static boolean grounded;

    public Creature(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_ACC;
        xMove = 0;
        yMove = 0;
        grounded = false;

    }

    public void move() {
        yHit();
        xHit();
        moveX();
        moveY();

    }

    public void moveX() {
        if (xMove > 0) {//izquierda
            int tx = (int) (position.getX() + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                position.setX(position.getX() + xMove);//si no está colisionando, moverse hacia izquierda

            } else {

                position.setX(tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1);

            }
        } else if (xMove < 0) { //derecha
            int tx = (int) (position.getX() + xMove + bounds.x) / Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                position.setX(position.getX() + xMove);//si no está colisionando, moverse hacia derecha

            } else {
                position.setX(tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x);

            }

        }
    }

    public void moveY() {
        if (yMove < 0) { //subir
            int ty = (int) (position.getY() + yMove + bounds.y) / Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                position.setY(position.getY() + yMove); //si no está colisionando, moverse hacia arriba

            } else {

                position.setY(ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y);

            }
        } else if (yMove > 0) { //bajar
            int ty = (int) (position.getY() + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if (!collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                position.setY(position.getY() + yMove); //si no está colisionando, moverse hacia abajo
                grounded = false;

            } else {

                position.setY(ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1);

                grounded = true;

            }

        }
    }
//-----------

    public void xHit() {
        if (xMove > 0) {//izquierda
            int tx = (int) (position.getX() + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if ((collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                    && destructibleTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    || destructibleTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                if (winTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                        || winTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                    handler.getGame().setGameOver(true); //si está colisionando, gana el juego
                } else {
                    handler.getGame().setGameOver(false); //si está colisionando, fin del juego
                }
            }
        } else if (xMove < 0) { //derecha
            int tx = (int) (position.getX() + xMove + bounds.x) / Tile.TILEWIDTH;
            if ((collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    && collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                    && destructibleTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                    || destructibleTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                if (winTile(tx, (int) (position.getY() + bounds.y) / Tile.TILEHEIGHT)
                        || winTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                    handler.getGame().setGameOver(true); //si está colisionando, gana el juego                  
                }else{
                handler.getGame().setGameOver(false); //si está colisionando, fin del juego
                }
            }

        }
    }

    public void yHit() {
        if (yMove < 0) { //subir
            int ty = (int) (position.getY() + yMove + bounds.y) / Tile.TILEHEIGHT;
            if ((collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    && collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                    && destructibleTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || destructibleTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                if (winTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                        || winTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                    handler.getGame().setGameOver(true); //si está colisionando, gana el juego              
                } else {
                    handler.getGame().setGameOver(false); //si está colisionando, fin del juego
                }
            }
        } else if (yMove > 0) { //bajar
            int ty = (int) (position.getY() + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if ((collisionWithTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
                    && destructibleTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || destructibleTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                if (winTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty)
                    || winTile((int) (position.getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                    handler.getGame().setGameOver(true); //si está colisionando,gana el juego
                } else {
                    handler.getGame().setGameOver(false); //si está colisionando, fin del juego
                }
            }

        }
    }
//-----------

    /**
     * public void xHit() { if (xMove > 0) {//izquierda int tx = (int)
     * (position.getX() + xMove + bounds.width) / Tile.TILEWIDTH; if
     * (destructibleTile(tx, (int) (position.getY() + bounds.y) /
     * Tile.TILEHEIGHT) && destructibleTile(tx, (int) (position.getY() +
     * bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
     * handler.getGame().setGameOver(); //si está colisionando, fin del juego
     * System.out.println("die left"); } } else if (xMove < 0) { //derecha int
     * tx = (int) (position.getX() + xMove + bounds.x) / Tile.TILEWIDTH; if
     * (destructibleTile(tx, (int) (position.getY() + bounds.y) /
     * Tile.TILEHEIGHT) && destructibleTile(tx, (int) (position.getY() +
     * bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
     * handler.getGame().setGameOver(); //si está colisionando, fin del juego
     * System.out.println("die right"); }
     *
     * }
     * }
     *
     * public void yHit() { if (yMove < 0) { //subir
     * int ty = (int) (position.getY() + yMove + bounds.y) / Tile.TILEHEIGHT;
     * if (destructibleTile((int) (position.getX() + bounds.x) / Tile.TILEWIDTH, ty) && destructibleTile((int) (position.getX() + bounds.x + bounds.width - 12) / Tile.TILEWIDTH, ty)) {
     * handler.getGame().setGameOver(); //si está colisionando, fin del juego
     * System.out.println("die up");
     * }
     * } else if (yMove > 0) { //bajar int ty = (int) (position.getY() + yMove +
     * bounds.y + bounds.height) / Tile.TILEHEIGHT; if (destructibleTile((int)
     * (position.getX() + bounds.x) / Tile.TILEWIDTH, ty) &&
     * destructibleTile((int) (position.getX() + bounds.width) / Tile.TILEWIDTH,
     * ty)) { handler.getGame().setGameOver(); //si está colisionando, fin del
     * juego System.out.println("die down"); }
     *
     * }
     * }
     *
     */
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
