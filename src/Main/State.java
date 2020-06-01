package Main;

import Display.Handler;
import java.awt.Graphics;

/**
 * Se encarga de los estados
 */
public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }
    //Clase
    public final Handler handler;
    
    public State(Handler handler){
        this.handler = handler ;
    }

    public abstract void update();

    public abstract void draw(Graphics g);
}
