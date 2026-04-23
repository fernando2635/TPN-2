package ejercicio7;

import java.io.IOException;

/**
 * Programa principal para el Ejercicio 7: Asignaturas y Alumnos
 */
public class MainEjercicio7 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 7: ASIGNATURAS Y ALUMNOS ===");
        System.out.println("Sistema de gestión académica de la UNdeC\n");

        GestorUniversidad gestor = new GestorUniversidad();

        try {
            // Cargar datos del archivo
            String rutaArchivo = "TPN°2/datos_universidad.txt";
            System.out.println("Cargando datos desde: " + rutaArchivo);
            gestor.cargarDatos(rutaArchivo);
            System.out.println("Datos cargados exitosamente.\n");

            // Mostrar información en consola
            gestor.mostrarTodosAlumnos();
            gestor.mostrarAsignaturas();

            // Generar reportes por asignatura
            System.out.println("\n" + "=".repeat(80));
            System.out.println("GENERANDO REPORTES POR ASIGNATURA");
            System.out.println("=".repeat(80));
            gestor.generarReportes("reportes");

            // Mostrar reportes en consola
            System.out.println("\n" + "=".repeat(80));
            System.out.println("REPORTES EN CONSOLA");
            System.out.println("=".repeat(80));
            gestor.mostrarReportesConsola();

        } catch (IOException e) {
            System.err.println("Error al procesar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
