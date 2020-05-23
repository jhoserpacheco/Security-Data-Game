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

/**
 *
 * @author JUAN
 */
public class MenuState extends State {

    private ArrayList<Button> buttons;
    private GameState gameState;

    public MenuState(Handler handler) throws InterruptedException {

        super(handler);
        
        buttons = new ArrayList<>();
        buttons.add(new Button(Assets.jugar, Assets.jugarOver,
                handler.getGame().getWidth()-Assets.salir1.getWidth()-100,handler.getGame().getHeight()- 150,
                
                "", 20, new Action() {
            @Override
            public void doAction() {
                gameState = new GameState(handler,handler.getLevel());
                
                State.setState(gameState);
            }
        }));
        buttons.add(new Button(Assets.salir1, Assets.salirOver,100, handler.getGame().getHeight()-150,
                
                "", 20, new Action() {
            @Override
            public void doAction() {
                System.exit(1);
            }
        })
    

    );

    }

    @Override
    public void update() {
        for (Button b : buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.background, 0, 0,null);
        g.drawImage(Assets.secData,100, 0,null);
        for (Button b : buttons) {
            b.draw(g);
        }
    }

}
