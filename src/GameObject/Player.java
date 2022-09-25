package GameObject;

import Display.Handler;
import Input.Keyboard;
import Math.Vector2D;
import States.GameState;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Graphics.Assets;
import Graphics.Tiles.World;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

/**
 * Acciones y animaciones del jugador
 */
public class Player extends Creature {

    private double time = 0;
    private double lastTime = System.currentTimeMillis();
    ArrayList<GameObject> gameObject;
    private final double gravity = 9.8;
    private int jump = 20;
    private final float dash = 5f;
    private boolean gameOverP;

    public Player(Handler handler, Vector2D position, int width, int height, BufferedImage texture, GameState gameState, boolean direction) {
        super(handler, position, width, height, texture, gameState, direction);
        gameObject = handler.getGameObject();
        bounds.x = 20; // Inicio de rectangulo de colisión en x
        bounds.y = 66;// Inicio de rectangulo de colisión en y
        bounds.width = 25; // Fin de rectangulo de colisión en x
        bounds.height = 61; // Fin de rectangulo de colisión en y
        gameOverP = false;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.getX(), (int) position.getY(), texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update() {
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (!gameOver(gameOverP)) { // Si no ha perdido
            if (Keyboard.DASH && Keyboard.RIGHT && !Keyboard.LEFT) { // Moverse a la derecha con dash
                position.setX(position.getX() + dash);
            }

            if (Keyboard.DASH && Keyboard.LEFT && !Keyboard.RIGHT) { // Moverse a la izquierda con dash
                position.setX(position.getX() - dash);
            }
            // NO IMPLEMENTADO. Relacionado con el disparo
            if (Keyboard.SHOOT && Keyboard.LEFT && !Keyboard.RIGHT) {
                gameState.getGameObject().add(0, new Shoot(handler, new Vector2D((int) (position.getX()
                        - handler.getGameCamera().getxOffset()), (int) (position.getY()
                        - handler.getGameCamera().getyOffset()) + (texture.getHeight()
                        / 3)), 70, 40, 10, 0, Assets.shootLeft, gameState, false));
                time = 0;

                this.setPosition(new Vector2D(position.getX() - 65, position.getY()));

            }
            if (Keyboard.SHOOT && Keyboard.RIGHT && !Keyboard.LEFT) {
                gameState.getGameObject().add(0, new Shoot(handler, new Vector2D((int) (position.getX()
                        - handler.getGameCamera().getxOffset()), (int) ((position.getY()
                        - handler.getGameCamera().getyOffset()) + (texture.getHeight()
                        / 3))), 70, 40, 10, 0, Assets.shootRight, gameState, false));
                time = 0;

                this.setPosition(new Vector2D(position.getX() + 65, position.getY()));
            }/*
            if (Keyboard.SHOOT && Keyboard.DASH) {
            }*/
            getInput();
            move();
            handler.getGameCamera().centerOnPlayer(this);
        }
    }

    /**
     * Keybinds
     */
    private void getInput() {
        if (!gameOver(gameOverP)) {
            xMove = 0;
            yMove = 0;
            if (Keyboard.UP) {

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

                if (Keyboard.RIGHT) {
                    xMove = (float) speed;
                }
                if (Keyboard.LEFT) {
                    xMove = (float) -speed;
                }
            }
        }
    }

    public boolean gameOver(boolean gameOver) {
        gameOverP = gameOver;
        return gameOverP;
    }

    @Override
    public void draw(Graphics g) {
        //Animaciones del jugador

        if (!gameOver(gameOverP)) { // Si no ha perdido
            // Animación cuando aprieta derecha e izquierda a la vez
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

                // Animación de caminar hacia adelante
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
                } // Animación de caminar hacia atrás
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

                // Animación quieto
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

            }
            //dibujar rectangulo colisión
            //g.fillRect((int)(position.getX()+bounds.x-handler.getGameCamera().getxOffset()),(int)(position.getY()+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height); 
            if ((Keyboard.SHOOT && Keyboard.RIGHT) && !Keyboard.LEFT) {
                if (time > 0 && time < 200) {
                    g.drawImage(Assets.shootRight, (int) (position.getX() + handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else if (time >= 200 && time < 400) {
                    g.drawImage(Assets.shootRight, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else if (time >= 400 && time < 600) {
                    g.drawImage(Assets.shootRight, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else {
                    g.drawImage(Assets.shootRight, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                    time = 0;

                }

            } else if ((Keyboard.SHOOT && Keyboard.LEFT) && !Keyboard.RIGHT) {
                if (time > 0 && time < 200) {
                    g.drawImage(Assets.shootLeft, (int) (position.getX() + handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else if (time >= 200 && time < 400) {
                    g.drawImage(Assets.shootLeft, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else if (time >= 400 && time < 600) {
                    g.drawImage(Assets.shootLeft, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                } else {
                    g.drawImage(Assets.shootLeft, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
                    time = 0;
                }
            }
        }
    }

}
