/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Display.Handler;
import Graphics.Assets;
import Input.Action;
import Input.Button;
import Main.State;
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

    public PauseState(Handler handler) throws InterruptedException {

        super(handler);
        handler.getGame().getGameState().getBackSound().stop();
        buttons = new ArrayList<>();
        buttons.add(new Button(Assets.blueButton, Assets.redButton,
                handler.getGame().getWidth() / 2 - 100, handler.getGame().getHeight() / 2,
                "Continuar", 20, new Action() {
            @Override
            public void doAction() {
                handler.getGame().getGameState().getBackSound().play();
                State.setState(handler.getGame().getGameState());
            }
        }));
        buttons.add(new Button(Assets.yellowButton, Assets.greenButton,
                (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2) + 100, "Menú", 50,
                new Action() {
            @Override
            public void doAction() {
                try {
                    menuState = new MenuState(handler);
                    State.setState(menuState);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        ));

    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
