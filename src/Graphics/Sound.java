/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import javax.sound.sampled.Clip;

/**
 *
 * @author JUAN
 */
public class Sound {
    private Clip clip;
    
    public Sound(Clip clip){
        this.clip = clip;
        
    }
    
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void stop(){
        clip.stop();
    }
    
    public void loop(){
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
}
