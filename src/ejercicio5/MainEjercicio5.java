package ejercicio5;

import java.io.IOException;

/**
 * Programa principal para el Ejercicio 5: Tecitos
 */
public class MainEjercicio5 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 5: TECITOS ===");

        GestorTeConsumo gestor = new GestorTeConsumo();

        try {
            // Cargar datos del archivo
            String rutaArchivo = "TPN°2/tecitos.in";
            gestor.cargarConsumos(rutaArchivo);

            // Mostrar estadísticas y reportes
            gestor.mostrarEstadisticas();
            gestor.mostrarReporte1PorVariedad();
            gestor.mostrarReporte2PorDia();
            gestor.mostrarReporte3PorMomento();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
