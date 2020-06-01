package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura bordes
 */
public class limitsTile extends Tile{
    
    public limitsTile( int id) {
        super(Assets.limits, id);
    }
        @Override
    public boolean isSolid(){
        return true;
    }
}
