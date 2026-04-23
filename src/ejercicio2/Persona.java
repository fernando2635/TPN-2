package ejercicio2;

/**
 * Clase abstracta Persona - Base para la jerarquía de clases
 * PILARES POO: Abstracción, Encapsulamiento, Herencia
 */
public abstract class Persona {
    // Encapsulamiento: atributos privados
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo; // "Masculino" o "Femenino"

    /**
     * Constructor protegido para la clase abstracta
     */
    public Persona(String apellido, String nombre, int edad, String sexo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    // Getters - Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    // Setters - Encapsulamiento
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Método abstracto que debe implementar cada subclase
     */
    public abstract String obtenerInfo();

    @Override
    public String toString() {
        return apellido + " " + nombre;
    }
}
