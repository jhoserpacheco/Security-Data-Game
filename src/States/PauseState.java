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
import com.sun.org.apache.bcel.internal.Constants;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class PauseState extends State {

    private ArrayList<Button> buttons;

    public PauseState(Handler handler) {
        super(handler);
        buttons = new ArrayList<>();
        buttons.add(new Button(Assets.continuar,Assets.continuar,
                handler.getGame().getWidth()/2,handler.getGame().getHeight()/2,
                "",new Action(){
                    @Override
                    public void doAction(){
                        State.setState(new GameState(handler));
                    }
                }));
    
    }

    @Override
    public void update() {
        for(Button b: buttons){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
                for(Button b: buttons){
            b.draw(g);
        }
    }

}
