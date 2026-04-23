package ejercicio7;

/**
 * Clase Alumno - Representa un alumno de la universidad
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Alumno implements Comparable<Alumno> {
    // Encapsulamiento: atributos privados
    private String apellido;
    private String nombre;
    private int edad;
    private String sexo; // "Masculino" o "Femenino"
    private double[] calificaciones;

    /**
     * Constructor que inicializa un alumno
     */
    public Alumno(String apellido, String nombre, int edad, String sexo, int cantAsignaturas) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.calificaciones = new double[cantAsignaturas];
    }

    // Getters - Encapsulamiento
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    /**
     * Establece la calificación de una asignatura
     */
    public void setCalificacion(int indice, double calificacion) {
        if (indice >= 0 && indice < calificaciones.length && calificacion >= 2 && calificacion <= 10) {
            this.calificaciones[indice] = calificacion;
        }
    }

    /**
     * Calcula el promedio de calificaciones
     */
    public double calcularPromedio() {
        if (calificaciones.length == 0) return 0;
        double suma = 0;
        for (double cal : calificaciones) {
            suma += cal;
        }
        return suma / calificaciones.length;
    }

    /**
     * Obtiene la condición del alumno (Aprobado o Reprobado)
     */
    public String obtenerCondicion() {
        double promedio = calcularPromedio();
        return promedio >= 4 ? "Aprobado" : "Reprobado";
    }

    /**
     * Polimorfismo: compareTo para ordenar alfabéticamente por apellido
     */
    @Override
    public int compareTo(Alumno otro) {
        return this.apellido.compareTo(otro.apellido);
    }

    /**
     * Retorna el nombre completo
     */
    public String getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " - Promedio: " + String.format("%.2f", calcularPromedio());
    }
}
