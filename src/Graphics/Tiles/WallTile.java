package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura muros
 */
public class WallTile extends Tile{
    
    public WallTile(int id) {
        super(Assets.wall, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
