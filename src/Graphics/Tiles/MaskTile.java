package Graphics.Tiles;

import Graphics.Assets;


/**
 * Textura mascaras
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
