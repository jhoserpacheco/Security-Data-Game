/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Display.Handler;
import Graphics.Tiles.World;
import java.io.File;

/**
 *
 * @author JUAN
 */
public class Worlds {



    public Worlds(Handler handler,int level){
    
        try {
            if (level == 1) {
                handler.setWorld(new World(handler, new File("./generateWorld/world1.txt").getAbsolutePath()));
            }
            if (level == 2) {
                handler.setWorld(new World(handler, new File("./generateWorld/world2.txt").getAbsolutePath()));
            }
            if (level == 3) {
                handler.setWorld(new World(handler, new File("./generateWorld/world3.txt").getAbsolutePath()));
            }
            if (level == 4) {
                handler.setWorld(new World(handler, new File("./generateWorld/world4.txt").getAbsolutePath()));
            }
            if (level == 5) {
                handler.setWorld(new World(handler, new File("./generateWorld/world5.txt").getAbsolutePath()));
            }            
            if (level == 6) {
                handler.setWorld(new World(handler, new File("./generateWorld/world6.txt").getAbsolutePath()));
            }
            if (level == 7) {
                handler.setWorld(new World(handler, new File("./generateWorld/world7.txt").getAbsolutePath()));
            }
            
        } catch (NullPointerException e) {

        }
        
    }
}
