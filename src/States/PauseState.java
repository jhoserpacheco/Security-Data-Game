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
 */
public class PauseState extends State {

    private ArrayList<Button> buttons;
    private MenuState menuState;
    private Vector2D pos;

    public PauseState(Handler handler) throws InterruptedException {

        super(handler);

        pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 50, (int) (handler.getGame().getHeight() / 2) - 50);
        buttons = new ArrayList<>();

        //botón continuar
        buttons.add(new Button(Assets.blueButton, Assets.redButton,
                handler.getGame().getWidth() / 2 - 100, handler.getGame().getHeight() / 2,
                "Continuar", 20, new Action() {
            @Override
            public void doAction() {

                State.setState(handler.getGame().getGameState());
            }
        }));

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
        //botón mute
        if (handler.isMute()) {
            buttons.add(new Button(Assets.soundOff, Assets.soundOff,
                    handler.getGame().getWidth() / 2 + 200, handler.getGame().getHeight() / 2,
                    "", 20, new Action() {
                @Override
                public void doAction() {
                    handler.getGame().getGameState().getBackSound().play();
                    handler.setMute(false);
                }
            }));
        } else {
            buttons.add(new Button(Assets.soundOn, Assets.soundOn,
                    handler.getGame().getWidth() / 2 + 200, handler.getGame().getHeight() / 2,
                    "", 20, new Action() {
                @Override
                public void doAction() {
                    handler.getGame().getGameState().getBackSound().stop();
                    handler.setMute(true);
                }
            }));
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
        Text.DrawText(g, "Pausa", pos, Color.cyan, Assets.font);
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
