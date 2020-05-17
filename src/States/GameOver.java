/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Display.Handler;
import Graphics.Assets;
import Graphics.Text;
import Main.State;
import Math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author JUAN
 */
public class GameOver extends State {


    Vector2D pos;
    boolean win = false;

    public GameOver(Handler handler, boolean win) {

        super(handler);
        win = win;
        if(win){
        pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 100, (int) (handler.getGame().getHeight() / 2));
        }
        else{
            pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 150, (int) (handler.getGame().getHeight() / 2));      
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        if (win) {
            Text.DrawText(g, "FELICIDADES,EVITÓ EL HACKEO.", pos, Color.GREEN, Assets.font);
        } else {

            Text.DrawText(g,"HAS SIDO HACKEADO..", pos, Color.RED, Assets.font);
        }
    }

}
