package Display;

import Main.Game;

/**
 *
 * @author JUAN
 * Clase main que inicia la ventana de juego
 */
public class Launcher {

    public static void main(String args[]){
        Handler handler = new Handler(new Game("Security Data",832,640)); //Nombr de la ventana y resolución
        handler.getGame().start();
    }
}
