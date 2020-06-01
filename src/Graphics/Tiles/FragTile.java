package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura frag
 */
public class FragTile extends Tile {

    public FragTile(int id) {
        super(Assets.frag, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
    
    @Override
    public boolean isDestructible(){
        return true;
    }
}
