package Graphics;

import Display.Handler;
import Main.State;
import Math.Vector2D;
import States.GameOver;
import java.awt.image.BufferedImage;

/**
 * Se encarga de las animaciones estáticas
 */
public class Animation {

    private BufferedImage[] frames;
    private int velocity;
    private int index;
    private boolean running;
    private Vector2D position;
    private long time, lastTime;
    private Handler handler;

    public Animation(Handler handler,BufferedImage[] frames, int velocity, Vector2D position) {
        this.handler = handler;
        this.frames = frames;
        this.velocity = velocity;
        this.position = position;
        index = 0;
        running = true;
        time = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        time += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (time >= velocity) {
            time = 0;
            index++;
            if (index >= frames.length) {
                running = false;
                State.setState(new GameOver(handler,false));
            }

        }
    }

    public boolean isRunning() {
        return running;
    }

    public Vector2D getPosition() {
        return position;
    }

    public BufferedImage GetCurrentFrame() {
        return frames[index];
    }
}
