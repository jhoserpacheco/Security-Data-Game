/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Display.Display;
import Display.Handler;
import Graphics.Assets;
import Graphics.GameCamera;
import Input.Keyboard;
import Input.Mouse;
import States.GameOver;
import States.GameState;
import States.MenuState;
import States.PauseState;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game implements Runnable {

    private Display display;
    private final Keyboard keyBoard;
    private final Mouse mouse;
    private GameState gameState;
    private Thread thread;
    private GameCamera gameCamera;
    private Handler handler;
    public static int width, height;
    private boolean running = false;
    private BufferStrategy bs;//definir bufferStrategy (organiza espacios de memoria en el canvas)
    private Graphics g; //objeto tipo gráfico
    private final String title;
    private final int FPS = 60;
    private final double TARGETTIME = 1000000000 / FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;
    private boolean paused = false;
    private State menuState;

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        keyBoard = new Keyboard();
        mouse = new Mouse();

    }

    private void init() throws IOException, FontFormatException, FontFormatException, LineUnavailableException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException { //Método inicializar
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyBoard);
        display.getCanvas().addMouseListener(mouse);
        display.getCanvas().addMouseMotionListener(mouse);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        gameState = new GameState(handler);
        handler.getGame().getGameState().getBackSound().stop();
        menuState = new MenuState(handler);
        State.setState(menuState); //Cambiar para cambiar entre estados
    }

    public GameState getGameState() {
        return gameState;
    }

    //Cámara 
    public GameCamera getGameCamera() {
        return gameCamera;
    }

    //teclado
    public Keyboard getKeyBoard() {
        return keyBoard;
    }

    private void update() throws InterruptedException { //método de refresco de pantalla

        if (State.getState() != null) {
            State.getState().update();
        }

        keyBoard.update();
        if (Keyboard.EXIT) {
            State.setState(new PauseState(handler));
            //System.exit(1);

        }
    }

    private void draw() { //método de dibujado

        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //-------------Dibujar
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().draw(g);
        }
        g.setColor(Color.yellow);
        //g.drawString("" + AVERAGEFPS, 40, 40);
        //-------------fin dibujar----------------
        g.dispose();
        bs.show();

    } //fin dibujado

    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime(); // ver tiempo en nanosegundos
        int frames = 0;
        long time = 0;
        try {
            init();
        } catch (IOException | FontFormatException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (running) {
            //Contador de FPS
            now = System.nanoTime();
            delta += (now - lastTime) / TARGETTIME;
            lastTime = now;
            //-----------
            if (delta >= 1) {
                try {
                    //limitador de FPS
                    update();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000) {
                AVERAGEFPS = frames;
                frames = 0;
            }
        }
        stop();
    }

    public void setGameOver(boolean win) {
        State.setState(null);
        GameOver gameOver = new GameOver(handler, win);
        State.setState(gameOver);
        gameOver.update();
        gameOver.draw(g);
    }

    public synchronized void start() { //método para iniciarlizar la ventana
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() { //clase para parar la ventana
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Display getDisplay() {
        return display;
    }

}
