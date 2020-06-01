package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura portal
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
