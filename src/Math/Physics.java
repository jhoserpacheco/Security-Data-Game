package Math;

import GameObject.GameObject;
import java.util.ArrayList;

/**
 *
 * @author JUAN
 * Clase encargada de las colisiones
 */
public class Physics {
    public static boolean Collision(GameObject player,GameObject object,ArrayList<GameObject> gameObject){
        for(int i = 0; i < gameObject.size();i++){
            if(object.getBounds().intersects(gameObject.get(i).getBounds()) && !gameObject.get(i).equals(object) && !gameObject.get(i).equals(player)){
                return true;
            }
        }
       return false; 
    }

}
