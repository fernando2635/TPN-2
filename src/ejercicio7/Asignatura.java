package ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase Asignatura - Representa una asignatura de la universidad
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Asignatura {
    // Encapsulamiento: atributos privados
    private String nombre;
    private List<Alumno> alumnos;

    /**
     * Constructor que inicializa una asignatura
     */
    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    // Getters - Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Añade un alumno a la asignatura
     */
    public void agregarAlumno(Alumno alumno) {
        if (alumno != null) {
            alumnos.add(alumno);
        }
    }

    /**
     * Calcula el promedio de la clase
     */
    public double calcularPromedioClase() {
        if (alumnos.isEmpty()) return 0;
        double suma = 0;
        for (Alumno alumno : alumnos) {
            suma += alumno.calcularPromedio();
        }
        return suma / alumnos.size();
    }

    /**
     * Obtiene los alumnos ordenados alfabéticamente
     */
    public List<Alumno> obtenerAlumnosOrdenados() {
        List<Alumno> ordenados = new ArrayList<>(alumnos);
        Collections.sort(ordenados);
        return ordenados;
    }

    /**
     * Genera el reporte de la asignatura
     */
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        sb.append("=".repeat(80)).append("\n");

        List<Alumno> ordenados = obtenerAlumnosOrdenados();
        for (Alumno alumno : ordenados) {
            String condicion = alumno.obtenerCondicion();
            double promedio = alumno.calcularPromedio();
            sb.append(String.format("%-35s - Nota: %.2f - %s%n",
                    alumno.getNombreCompleto(), promedio, condicion));
        }

        sb.append("=".repeat(80)).append("\n");
        sb.append(String.format("Promedio de la clase: %.2f%n", calcularPromedioClase()));

        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre + " (" + alumnos.size() + " alumnos)";
    }
}
