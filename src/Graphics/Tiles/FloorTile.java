package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura del piso
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
