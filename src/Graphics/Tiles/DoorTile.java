package Graphics.Tiles;

import Graphics.Assets;

/**
 * Textura de la puerta
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
