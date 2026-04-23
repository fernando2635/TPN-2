package ejercicio3;

/**
 * Clase Deportista - Extiende Datos (Herencia)
 * PILARES POO: Herencia, Encapsulamiento, Polimorfismo
 */
public class Deportista extends Datos {
    // Encapsulamiento: atributos privados adicionales
    private String deporte;
    private int numeroMedallas;

    /**
     * Constructor que inicializa todos los datos del deportista
     */
    public Deportista(String nombreYApellido, int edad, String carrera, 
                     String deporte, int numeroMedallas) {
        super(nombreYApellido, edad, carrera);
        this.deporte = deporte;
        this.numeroMedallas = numeroMedallas;
    }

    // Getters
    public String getDeporte() {
        return deporte;
    }

    public int getNumeroMedallas() {
        return numeroMedallas;
    }

    // Setters
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setNumeroMedallas(int numeroMedallas) {
        this.numeroMedallas = numeroMedallas;
    }

    /**
     * Polimorfismo: sobrescritura del método toString
     */
    @Override
    public String toString() {
        return super.toString() + " | Deporte: " + deporte + " | Medallas: " + numeroMedallas;
    }
}
