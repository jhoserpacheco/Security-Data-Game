package Graphics;

import Math.Vector2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Clase encargada de dibujar texto en la pantalla
 */
public class Text {
    public static void DrawText(Graphics g,String text,Vector2D pos,Color color,Font font){
        g.setColor(color);
        g.setFont(font);
        Vector2D position = new Vector2D(pos.getX(),pos.getY());
        
        g.drawString(text,(int)position.getX(),(int)position.getY());        
    }
}
