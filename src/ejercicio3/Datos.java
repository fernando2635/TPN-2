package ejercicio3;

/**
 * Clase Datos - Representa información básica de una persona
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Datos {
    // Encapsulamiento: atributos privados
    private String nombreYApellido;
    private int edad;
    private String carrera;

    /**
     * Constructor que inicializa los datos básicos
     */
    public Datos(String nombreYApellido, int edad, String carrera) {
        this.nombreYApellido = nombreYApellido;
        this.edad = edad;
        this.carrera = carrera;
    }

    // Getters - Encapsulamiento
    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    // Setters - Encapsulamiento
    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return nombreYApellido + " | Edad: " + edad + " | Carrera: " + carrera;
    }
}
