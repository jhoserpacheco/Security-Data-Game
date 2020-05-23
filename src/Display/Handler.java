/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import GameObject.GameObject;
import GameObject.Player;
import Graphics.GameCamera;
import Graphics.Tiles.World;
import Input.Keyboard;
import Main.Game;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class Handler {
    private World world;
    private Game game;
    private Handler handler;  
    private int level;
    private ArrayList<GameObject> gameObject;
    private int score;
    private boolean mute = false;
    private Player player;
    
    public Handler(Game game){
        this.game= game;
        
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

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList getGameObject() {
        return gameObject;
    }

    public void setGameObject(ArrayList gameObject) {
        this.gameObject = gameObject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
    
    
}
