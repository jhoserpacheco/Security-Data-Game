/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Display.Handler;
import Graphics.Assets;
import Graphics.Text;
import Input.Action;
import Input.Button;
import Main.State;
import Math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN
 * Estado de fin del juego
 */
public class GameOver extends State {

    private Vector2D pos;
    private boolean win;
    private ArrayList<Button> buttons;

    public GameOver(Handler handler, boolean winer) {

        super(handler);
        this.win = winer;

        handler.getGame().getGameState().getBackSound().stop();
        buttons = new ArrayList<>();
        if (win && handler.getLevel() < 8) { //número de niveles 
            //botón avanzar nivel
            buttons.add(new Button(Assets.blueButton, Assets.redButton,
                    (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2), "Siguiente", 10,
                    new Action() {
                @Override
                public void doAction() {
                    handler.setLevel(handler.getLevel() + 1);
                    State.setState(new GameState(handler, handler.getLevel()));
                    handler.getGame().setGameState((GameState)State.getState());
                }
            }
            ));
        }
        if (!win) {
            //botón reintentar

            buttons.add(new Button(Assets.blueButton, Assets.redButton,
                    (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2), "Reintentar", 10,
                    new Action() {
                @Override
                public void doAction() {
                    State.setState(new GameState(handler, handler.getLevel()));
                }
            }
            ));
        }
        //botón Salir
        buttons.add(new Button(Assets.greenButton, Assets.redButton,
                (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2) + 200, "Salir", 50,
                new Action() {
            @Override
            public void doAction() {
                System.exit(1);
            }
        }
        ));
        //botón menú
        buttons.add(new Button(Assets.yellowButton, Assets.redButton,
                (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2) + 100, "Menú", 50,
                new Action() {
            @Override
            public void doAction() {
                try {
                    State.setState(new MenuState(handler));
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        ));

        if (win) {
            pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 220, (int) (handler.getGame().getHeight() / 2) - 100);
        } else {
            pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 150, (int) (handler.getGame().getHeight() / 2) - 100);
        }
    }

    @Override

    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        if (win && handler.getLevel() == 8) {
            Text.DrawText(g, "FELICIDADES,EVITASTE EL HACKEO.", pos, Color.CYAN, Assets.font);
        } else if (win && handler.getLevel() < 8) {
            Text.DrawText(g,"NIVEL SUPERADO!",new Vector2D((int) (handler.getGame().getWidth() / 2) - 120, (int) (handler.getGame().getHeight() / 2) - 150), Color.GREEN, Assets.font);
        } else {

            Text.DrawText(g, "HAS SIDO HACKEADO..", pos, Color.RED, Assets.font);
        }
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
