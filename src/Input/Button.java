/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import Graphics.Assets;
import Graphics.Text;
import Math.Vector2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author JUAN
 */
public class Button {

    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private String text;
    private Action action;

    public Button(BufferedImage mouseOutImg,  BufferedImage mouseInImg,int x, int y, String text,Action action) {
        this.mouseOutImg = mouseOutImg;
        this.mouseInImg = mouseInImg;
        this.action = action;
        this.text = text;
        boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), mouseInImg.getHeight());

    }

    public void update() {
        if (boundingBox.contains(Mouse.X, Mouse.Y)) {
            mouseIn = true;
        } else {
            mouseIn = false;
        }
        if (mouseIn && Mouse.MLB) {
            action.doAction();
        }

    }

    public void draw(Graphics g) {
        if (mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }
        Text.DrawText(g, text,new Vector2D(boundingBox.getX()+boundingBox.getWidth(),
        boundingBox.getY()+boundingBox.getHeight()), Color.WHITE,Assets.font);
    }
    

}
