package ejercicio1;

/**
 * Clase Punto - Representa un punto en el plano cartesiano
 * PILARES POO: Abstracción (concepto de punto), Encapsulamiento (atributos privados)
 */
public class Punto {
    // Encapsulamiento: atributos privados
    private double x;
    private double y;

    /**
     * Constructor que inicializa las coordenadas del punto
     * @param x coordenada en el eje de abscisas
     * @param y coordenada en el eje de ordenadas
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters - Encapsulamiento
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setters - Encapsulamiento
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calcula la distancia entre este punto y otro punto dado
     * Utiliza la fórmula: distancia = sqrt((x2-x1)² + (y2-y1)²)
     * @param otroPunto el otro punto
     * @return la distancia entre los dos puntos
     */
    public double distanciaEntreDosPuntos(Punto otroPunto) {
        double dx = otroPunto.getX() - this.x;
        double dy = otroPunto.getY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Retorna una representación en string del punto
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
