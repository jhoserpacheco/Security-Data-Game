/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//Clase encargada de leer las entradas por teclado
public class Keyboard implements KeyListener {

    private final boolean[] keys;

    public static boolean UP, DOWN, LEFT, RIGHT, SHOOT,DASH,PAUSE;

    public Keyboard() {
        keys = new boolean[256];
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        DASH = false;
        PAUSE = false;
    }

    public void update() {
        UP = keys[KeyEvent.VK_UP];
        DOWN = keys[KeyEvent.VK_DOWN];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        SHOOT = keys[KeyEvent.VK_SPACE]; //disparar con X
        DASH = keys[KeyEvent.VK_C];
        PAUSE = keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
