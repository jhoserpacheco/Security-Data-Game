/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Display.Handler;
import Graphics.Assets;
import Graphics.Text;
import Main.Game;
import Main.State;
import Math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author JUAN
 */
public class GameOver extends State {

    private int switcher = 1;
    Vector2D pos;

    public GameOver(Handler handler) {
        super(handler);
        pos = new Vector2D((int) (handler.getGame().getWidth() / 2) - 100, (int) (handler.getGame().getHeight() / 2));
    }

    @Override
    public void update() {
        if (switcher == 1) {
            pos.setY(pos.getY() + 4);
            switcher = 2;
        }
        if (switcher == 2) {
            pos.setY(pos.getY() - 4);
            switcher = 1;
        }

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        Text.DrawText(g, "FIN DEL JUEGO", pos, Color.GREEN, Assets.font);
    }

}
