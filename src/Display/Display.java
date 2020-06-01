package Display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Clase encargada de crear la ventana de juego y el espacio de dibujo
 */
public class Display {

    private JFrame frame;
    private String title;
    private int WIDTH, HEIGHT;
    private Canvas canvas;

    public Display(String title, int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        this.title = title;
        createDisplay();
    }

    /**
     * Crea la ventana del juego
     */
    private void createDisplay() { 
        frame = new JFrame(title);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas(); //crear canvas (para dibujar en él)
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));//tamaño defecto
        canvas.setMaximumSize(new Dimension(1366, 768));//tamaño máximo
        canvas.setMinimumSize(new Dimension(600, 600));//tamaño mínimo
        canvas.setFocusable(false); //Recibir inputs
        
        frame.add(canvas);

        frame.pack();
    }    

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JFrame getFrame() {
        return frame;
    } 
}
