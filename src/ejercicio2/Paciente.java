package ejercicio2;

/**
 * Clase Paciente - Extiende Persona (Herencia)
 * PILARES POO: Herencia, Encapsulamiento, Polimorfismo
 */
public class Paciente extends Persona {
    // Encapsulamiento: atributo privado adicional
    private int condicion; // 1 a 5 (nivel de gravedad)
    private String telefono;

    /**
     * Constructor que inicializa todos los datos del paciente
     */
    public Paciente(String apellido, String nombre, int edad, String sexo, 
                   int condicion, String telefono) {
        super(apellido, nombre, edad, sexo);
        this.condicion = condicion;
        this.telefono = telefono;
    }

    // Getters
    public int getCondicion() {
        return condicion;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters
    public void setCondicion(int condicion) {
        if (condicion >= 1 && condicion <= 5) {
            this.condicion = condicion;
        }
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Polimorfismo: implementación del método abstracto
     */
    @Override
    public String obtenerInfo() {
        return String.format("%s | Edad: %d | Sexo: %s | Condición: %d | Teléfono: %s",
                toString(), getEdad(), getSexo(), condicion, telefono);
    }
}
