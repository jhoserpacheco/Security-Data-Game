package Display;

import Main.Game;
import javax.swing.JOptionPane;

/**
 * Inicia la ventana del juego
 */
public class Launcher {

    public static void main(String args[]) {
        String html = "<html><body width= '%1s'><h1>SE HA DETECTADO UNA AMENAZA</h1>"
                + "<h3>Al parecer un hacker ha entrado en su sistema y lo infecto con 6 virus. "
                + "Utilize el software SecurityData para ingresar al sistema y eliminarlos, "
                + "aunque lo mas probable es que la corrupcion haya dañado partes de su sistema.<br><br> "
                + "¿Estas preparado para enfrentarte contra un hacker Black Hat UFPS?<br><br>"
                + "&emsp&emsp&emsp&emsp&emsp&emsp<img src=\"https://upload.wikimedia.org/wikipedia/commons/0/03/UFPS_Logo.png\"width=\"120\" height=\"120\"><br>"
                + "Tenga cuidado con estas partes o podra ser hackeado. <br><br>"
                + "¿Esta seguro de que quiere ingresar?<br><br><h3>";
        
        int w = 300;
        
        int confirmacion = JOptionPane.YES_NO_OPTION;
        int opcion = JOptionPane.showConfirmDialog(null, String.format(html, w, w), "ALERTA DE SEGURIDAD", JOptionPane.WARNING_MESSAGE, confirmacion);
        if (opcion == JOptionPane.YES_OPTION) {
            Handler handler = new Handler(new Game("Security Data", 832, 640));
            handler.getGame().start();
        } else {
            System.exit(0);
        }
    }
}
