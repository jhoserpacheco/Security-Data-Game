package Math;

/**
 *
 * @author JUAN
 * Clase encargada del vector2D para posiciones de gameObjects
 */
public class Vector2D {
    private double x,y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        x=0;
        y=0;
    }
}
