package States;

import Display.Display;
import Display.Handler;
import Graphics.Assets;
import Graphics.Tiles.World;
import Input.Action;
import Input.Button;
import Main.Game;
import Main.State;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Estado de menu
 */
public class MenuState extends State {

    private ArrayList<Button> buttons;
    private GameState gameState;

    public MenuState(Handler handler) throws InterruptedException {

        super(handler);

        buttons = new ArrayList<>();
        buttons.add(new Button(Assets.jugar, Assets.jugarOver,
                handler.getGame().getWidth() - Assets.salir1.getWidth() - 100, handler.getGame().getHeight() - 150,
                "", 20, new Action() {
            @Override
            public void doAction() {
                gameState = new GameState(handler, 1);
                State.setState(gameState);
            }
        }));
        buttons.add(new Button(Assets.salir1, Assets.salirOver, 100, handler.getGame().getHeight() - 150,
                "", 20, new Action() {
            @Override
            public void doAction() {
                System.exit(1);
            }
        })
        );
        // boton nivel random 

        buttons.add(new Button(Assets.random, Assets.randomOver,
                handler.getGame().getWidth() - Assets.salir1.getWidth() - 320, handler.getGame().getHeight() - 150,
                "", 20, new Action() {
            @Override
            public void doAction() {
                int nivelRandom = (int) (Math.random() * (8 - 1 + 1)) + 1;
                handler.setLevel(nivelRandom);
                gameState = new GameState(handler, nivelRandom);

                State.setState(gameState);

            }
        }));
    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.background, -110, -150, null);
        g.drawImage(Assets.secData, 100, 0, null);
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
