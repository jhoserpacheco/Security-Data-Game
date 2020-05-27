/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author JUAN
 * Clase encargada de los controles de sonido
 */
public class Sound {
    private Clip clip;
    private FloatControl volume;
    
    public Sound(Clip clip){
        this.clip = clip;
        volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
    }
    
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void stop(){
        clip.setFramePosition(0);
        clip.stop();

    }
    
    public void start(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void loop(){
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void changeVolume(float value){
        volume.setValue(value);
    }
    
    public int getFramePosition(){
        return clip.getFramePosition();
    }
    
}
