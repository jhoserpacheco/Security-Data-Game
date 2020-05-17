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
public class DoorTile extends Tile{
    private boolean solid = true;
    public DoorTile(int id) {
        super(Assets.door, id);
        
    }
    @Override
    public boolean isSolid(){
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    

    
    
}
