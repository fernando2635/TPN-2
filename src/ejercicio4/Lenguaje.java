package ejercicio4;

/**
 * Clase Lenguaje - Representa un lenguaje de programación
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Lenguaje implements Comparable<Lenguaje> {
    // Encapsulamiento: atributos privados
    private String nombre;
    private int cantidad;

    /**
     * Constructor que inicializa el lenguaje
     */
    public Lenguaje(String nombre) {
        this.nombre = nombre;
        this.cantidad = 0;
    }

    // Getters - Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters - Encapsulamiento
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Incrementa la cantidad de votos para este lenguaje
     */
    public void incrementarVoto() {
        this.cantidad++;
    }

    /**
     * Calcula el porcentaje respecto al total
     */
    public double obtenerPorcentaje(int totalEncuestas) {
        if (totalEncuestas == 0) return 0;
        return (double) cantidad / totalEncuestas * 100;
    }

    /**
     * Polimorfismo: implementación de Comparable para ordenar descendentemente
     */
    @Override
    public int compareTo(Lenguaje otro) {
        // Ordena descendentemente por cantidad
        return Integer.compare(otro.cantidad, this.cantidad);
    }

    @Override
    public String toString() {
        return nombre + ": " + cantidad;
    }
}
