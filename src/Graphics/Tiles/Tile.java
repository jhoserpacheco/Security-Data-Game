/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.Tiles;

import Math.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author JUAN
 */
public class Tile {
    
    //Static variables
    public static Tile[] tiles = new Tile[256];
    public static Tile wallTile = new WallTile(0);//Paredes y piso
    public static Tile floorTile = new FloorTile(1); //fondo
    public static Tile doorTile = new DoorTile(2); //Puertas
    public static Tile limitsTile = new limitsTile(3); //borde del mapa
    public static Tile portalTile = new PortalTile(4); //portal fin del juego
    public static Tile fragTile = new FragTile(5); //tile de daño desfragmentado
    
    //Clase
    
    protected BufferedImage texture;
    protected final int id;
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    private boolean solid = false;
    
    public Tile(BufferedImage texture,int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
        
    }
    
    public void update(){
        
    }
    
    public void draw(Graphics g,Vector2D position){
        g.drawImage(texture,(int)position.getX(),(int)position.getY(),TILEWIDTH,TILEHEIGHT,null);
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
    public boolean isSolid(){
        return true;
    }
    
    public int getId(){
        return id;
    }
    
    
    
    public boolean isDestructible(){
        return false;
    }
}
