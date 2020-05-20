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
public class PortalTile extends Tile{
    
    public PortalTile(int id) {
        super(Assets.portal, id);
    }
    
    @Override
    public boolean isSolid(){
        return false;
    }
    
    @Override
    public boolean isDestructible(){
        return true;
    }
    
    @Override
    public boolean isWin(){
        return true;
    }
}
