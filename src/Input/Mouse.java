/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author JUAN
 */
public class Mouse extends MouseAdapter {

    public static int X, Y;
    public static boolean MLB;

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            MLB = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            MLB = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        X = me.getX();
        Y = me.getY();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        X = me.getX();
        Y = me.getY();
    }

}
