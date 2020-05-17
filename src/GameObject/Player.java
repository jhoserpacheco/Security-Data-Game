/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Display.Handler;
import Input.Keyboard;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Graphics.Assets;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class Player extends Creature {

    private double time = 0;
    private double lastTime = System.currentTimeMillis();
    ArrayList<GameObject> gameObject = new ArrayList<GameObject>();
    private final double gravity = 9.8;
    private int jump = 20;
    private boolean jumped = false;
    private final float dash = 5f;

    public Player(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        bounds.x = 15; //inicio de rectangulo colisión en x
        bounds.y = 66;//inicio de rectangulo colisión en y
        bounds.width = 38; //fin de rectangulo colisión en x
        bounds.height = 61; //fin de rectangulo colisión en y
        gameObject = gameState.getGameObject();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update() {
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (Keyboard.DASH && Keyboard.RIGHT && !Keyboard.LEFT) {
            position.setX(position.getX() + dash);
        }

        if (Keyboard.DASH && Keyboard.LEFT && !Keyboard.RIGHT) {
            position.setX(position.getX() - dash);
        }
        /**
         * if (Keyboard.SHOOT && Keyboard.LEFT && time > 300) {
         * gameState.getGameObject().add(0, new Shoot(handler, new
         * Vector2D((int) (position.getX() -
         * handler.getGameCamera().getxOffset()), (int) (position.getY() -
         * handler.getGameCamera().getyOffset()) + (texture.getHeight() / 3)),
         * 70, 40, 10, 0, Assets.shootLeft, gameState, false)); time = 0; } if
         * (Keyboard.SHOOT && Keyboard.RIGHT && time > 300) {
         * gameState.getGameObject().add(0, new Shoot(handler, new
         * Vector2D((int) (position.getX() -
         * handler.getGameCamera().getxOffset()), (int) ((position.getY() -
         * handler.getGameCamera().getyOffset()) + (texture.getHeight() / 3))),
         * 70, 40, 10, 0, Assets.shootRight, gameState, true)); time = 0; }
         *
         * if (Keyboard.SHOOT && !Keyboard.RIGHT && !Keyboard.LEFT && time >
         * 300) { gameState.getGameObject().add(0, new Shoot(handler, new
         * Vector2D((int) (position.getX() -
         * handler.getGameCamera().getxOffset()), (int) (position.getY() -
         * handler.getGameCamera().getyOffset()) + (texture.getHeight() / 3)),
         * 70, 40, 10, 0, Assets.shootRight, gameState, true)); time = 0; }
         *
         */
        
            
        
        getInput();
        move();
        handler.getGameCamera().centerOnPlayer(this);
    }

    private void getInput() { //Recibir entradas de teclado 
        xMove = 0;
        yMove = 0;
        if (Keyboard.UP) { //flecha arriba / slto

            if (jump > 0) {
                yMove = (float) -jump;
                jump--;
                setGrounded(false);
            } else {
                yMove = (float) +gravity;

            }
        } else {
            jump = 0;
            if (isGrounded()) {
                jump = 20;
                yMove = (float) +gravity;
            } else {
                jump = 0;
                yMove = (float) +gravity;
            }

        }

        if (Keyboard.RIGHT && Keyboard.LEFT) {
            xMove = 0;
            yMove = (float) +gravity;
        } else {

            if (Keyboard.RIGHT) { //flecha derecha
                xMove = (float) speed;
            }
            if (Keyboard.LEFT) { //flecha izquierda
                xMove = (float) -speed;
            }
        }

    }

    @Override
    public void draw(Graphics g) {

        if (Keyboard.RIGHT && Keyboard.LEFT) {
            if (time > 0 && time < 300) {
                g.drawImage(Assets.stand1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 300 && time < 400) {
                g.drawImage(Assets.stand2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);

            } else if (time >= 400 && time < 500) {
                g.drawImage(Assets.stand3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);

            } else if (time >= 500 && time < 600) {
                g.drawImage(Assets.stand4, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 600 && time < 900) {
                g.drawImage(Assets.stand5, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 900 && time < 1300) {
                g.drawImage(Assets.stand6, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else {
                g.drawImage(Assets.stand1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                time = 0;
            }
        } else {

            //animación de caminar hacia adelante
            if (Keyboard.RIGHT && !Keyboard.DASH) {
                if (time > 0 && time < 200) {
                    g.drawImage(Assets.run1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                }
                if (time >= 200 && time < 400) {
                    g.drawImage(Assets.run2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

                }
                if (time >= 400) {
                    g.drawImage(Assets.run3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                    time = 0;
                }
            }//animación de caminar hacia atrás
            else if (Keyboard.LEFT && !Keyboard.DASH) {
                if (time > 0 && time < 200) {
                    g.drawImage(Assets.runFlip1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                }
                if (time >= 200 && time < 400) {
                    g.drawImage(Assets.runFlip2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

                }
                if (time >= 400) {
                    g.drawImage(Assets.runFlip3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                    time = 0;
                }
            }
            //Animación quieto

        }
        if (!Keyboard.LEFT && !Keyboard.RIGHT) {

            if (time > 0 && time < 300) {
                g.drawImage(Assets.stand1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 300 && time < 400) {
                g.drawImage(Assets.stand2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);

            } else if (time >= 400 && time < 500) {
                g.drawImage(Assets.stand3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);

            } else if (time >= 500 && time < 600) {
                g.drawImage(Assets.stand4, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 600 && time < 900) {
                g.drawImage(Assets.stand5, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else if (time >= 900 && time < 1300) {
                g.drawImage(Assets.stand6, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
            } else {
                g.drawImage(Assets.stand1, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                time = 0;
            }

        }
        // Movimiento al hacer dash derecho
        if ((Keyboard.DASH && Keyboard.RIGHT) && !Keyboard.LEFT) {
            if (time >= 0 && time < 200) {
                g.drawImage(Assets.dashRight, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
            } else if (time >= 200 && time < 400) {
                g.drawImage(Assets.dashRight2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

            } else if (time >= 400 && time < 600) {
                g.drawImage(Assets.dashRight3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

            } else {
                g.drawImage(Assets.dashRight, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                time = 0;
            }
        } // Movimiento al hacer dash izquierdo
        else if ((Keyboard.DASH && Keyboard.LEFT) && !Keyboard.RIGHT) {
            if (time >= 0 && time < 200) {
                g.drawImage(Assets.dashLeft, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
            } else if (time >= 200 && time < 400) {
                g.drawImage(Assets.dashLeft2, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

            } else if (time >= 400 && time < 600) {
                g.drawImage(Assets.dashLeft3, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);

            } else {
                g.drawImage(Assets.dashLeft, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width + 15, height, null);
                time = 0;
            }

        }        //g.fillRect((int)(position.getX()+bounds.x-handler.getGameCamera().getxOffset()),(int)(position.getY()+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height); //dibujar rectangulo colisión

    }

}
