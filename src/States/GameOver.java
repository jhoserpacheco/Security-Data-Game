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
public class GameOver extends State {

    Vector2D pos;
    boolean win;
    private ArrayList<Button> buttons;
    private MenuState menuState;

    public GameOver(Handler handler, boolean winer) {

        super(handler);
        handler.getGame().getGameState().getBackSound().stop();    
        buttons = new ArrayList<>();
        buttons.add(new Button(Assets.greenButton, Assets.redButton,
                (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2) + 150, "Salir", 50,
                new Action() {
            @Override
            public void doAction() {
                System.exit(1);
            }
        }
        ));
        buttons.add(new Button(Assets.yellowButton, Assets.greenButton,
                (handler.getGame().getWidth() / 2) - 100, (handler.getGame().getHeight() / 2) + 50, "Menú", 50,
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

        win = winer;
        if (win) {
            pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 220, (int) (handler.getGame().getHeight() / 2));
        } else {
            pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 150, (int) (handler.getGame().getHeight() / 2));
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
        if (win) {
            Text.DrawText(g, "FELICIDADES,EVITÓ EL HACKEO.", pos, Color.GREEN, Assets.font);
        } else {

            Text.DrawText(g, "HAS SIDO HACKEADO..", pos, Color.RED, Assets.font);
        }
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
