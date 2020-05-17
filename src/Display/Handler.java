/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Graphics.GameCamera;
import Graphics.Tiles.World;
import Input.Keyboard;
import Main.Game;

/**
 *
 * @author JUAN
 */
public class Handler {
    private World world;
    private Game game;
    private Handler handler;   
    
    public Handler(Game game){
        this.game= game;
    }
    
    public void print(){
        System.out.println(handler.getGame().width);
    }
    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    public Keyboard getKeyBoard(){
        return game.getKeyBoard();
    }
    
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
}
