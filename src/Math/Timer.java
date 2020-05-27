/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import Graphics.Assets;
import Graphics.Text;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author JUAN
 */
public class Timer {

    private double time;
    private double maxTime;
    private Vector2D pos;
    private boolean maxTimeReached;
    private double lastTime = System.currentTimeMillis() / 1000;
    private boolean pause;
    private double timePaused;

    public Timer(double time, double maxTime, Vector2D pos) {
        this.time = time;
        this.maxTime = maxTime;
        this.pos = pos;
        this.maxTimeReached = false;
        this.timePaused = 0;

    }

    public void update() {
        if (!pause) {
            time += (System.currentTimeMillis() / 1000) - lastTime - timePaused;
            lastTime = System.currentTimeMillis() / 1000;
        }else{
            timePaused += (System.currentTimeMillis() / 1000);
            lastTime = 0;
        }

        if (time >= maxTime) {
            maxTimeReached = true;
        }

    }

    public void draw(Graphics g) {
        Text.DrawText(g, String.valueOf((int) time), pos, Color.WHITE, Assets.font);
    }

    public boolean isMaxTimeReached() {
        return maxTimeReached;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }



}
