package ejercicio4;

import java.io.IOException;

/**
 * Programa principal para el Ejercicio 4: Lenguajes de Programación
 */
public class MainEjercicio4 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4: LENGUAJES DE PROGRAMACIÓN ===");

        GestorEncuestaLenguajes gestor = new GestorEncuestaLenguajes();

        try {
            // Cargar datos del archivo
            String rutaArchivo = "TPN°2/lenguajes.in";
            gestor.cargarEncuestas(rutaArchivo);

            // Mostrar resultados
            gestor.mostrarTablaLenguajes();
            gestor.mostrarEstadisticas();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
