/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.Tiles;

import Graphics.Assets;


/**
 *
 * @author JUAN
 */
public class FloorTile extends Tile{
    
    public FloorTile(int id) {
        super(Assets.floor, id);
    }
    
    @Override
    public boolean isSolid(){
        return false;
    }
    
}
