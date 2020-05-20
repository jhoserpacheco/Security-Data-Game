package Display;

import Main.Game;

/**
 *
 * @author JUAN
 */
public class Launcher {

    public static void main(String args[]){
        Handler handler = new Handler(new Game("Security Data",832,640));
        handler.getGame().start();
    }
}
