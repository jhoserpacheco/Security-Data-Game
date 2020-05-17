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
public class MaskTile extends Tile{
    
    public MaskTile(int id) {
        super(Assets.mask, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
    @Override
    public boolean isDestructible(){
        return true;
    }
}
