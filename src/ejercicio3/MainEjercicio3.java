package ejercicio3;

import java.io.IOException;

/**
 * Programa principal para el Ejercicio 3: Deportes UNdeC
 */
public class MainEjercicio3 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: DEPORTES UNDEC ===");

        GestorDeportistas gestor = new GestorDeportistas();

        try {
            // Cargar datos del archivo
            String rutaArchivo = "TPN°2/deportes.txt";
            gestor.cargarDeportistas(rutaArchivo);

            // Mostrar todos los reportes
            gestor.mostrarTodosDeportistas();
            System.out.printf("\nPromedio de medallas: %.2f%n", gestor.calcularPromedioMedallas());
            gestor.mostrarDeportistasConMasDelPromedio();
            gestor.mostrarDeportistaMayorMedallas();
            gestor.mostrarDeportistaMenorMedallas();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
