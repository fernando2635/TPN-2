package ejercicio2;

import java.io.IOException;

/**
 * Programa principal para el Ejercicio 2: Hospital La Hermandad
 */
public class MainEjercicio2 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: HOSPITAL LA HERMANDAD ===");

        GestorPacientes gestor = new GestorPacientes();

        try {
            // Cargar datos del archivo
            String rutaArchivo = "TPN°2/entradaHospital.txt";
            gestor.cargarPacientes(rutaArchivo);

            // Mostrar todos los reportes
            gestor.mostrarTabla();
            gestor.mostrarPorcentajeGenero();
            gestor.mostrarPacientesPorCondicion();
            gestor.mostrarPacientesCondicionMaxima();
            gestor.mostrarPacientesOrdenadosPorEdad();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
