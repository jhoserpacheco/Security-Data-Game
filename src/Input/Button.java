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
    private int fontOffset;

    public Button(BufferedImage mouseOutImg,  BufferedImage mouseInImg,int x, int y, String text,int fontOffset,Action action) {
        mouseIn = false;
        this.mouseOutImg = mouseOutImg;
        this.mouseInImg = mouseInImg;
        this.action = action;
        this.text = text;
        this.fontOffset = fontOffset;
        boundingBox = new Rectangle(x, y, mouseInImg.getWidth()+30, mouseInImg.getHeight()+30);

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
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y,mouseInImg.getWidth()+30,mouseInImg.getHeight()+20, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y,mouseInImg.getWidth()+30,mouseInImg.getHeight()+20, null);
        }
        Text.DrawText(g, text,new Vector2D(boundingBox.getX()+fontOffset,
        boundingBox.getY()+40), Color.WHITE,Assets.font);
    }
    

}
