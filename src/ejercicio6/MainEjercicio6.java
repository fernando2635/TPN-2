package ejercicio6;

import java.util.Scanner;

/**
 * Programa principal para el Ejercicio 6: Historial de Navegación
 * Menú interactivo para simular un navegador web con pila
 */
public class MainEjercicio6 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 6: HISTORIAL DE NAVEGACIÓN ===");
        System.out.println("Simulador de navegador web con historial (Pila/Stack)\n");

        HistorialNavegacion historial = new HistorialNavegacion();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            System.out.print("Ingrese la opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la URL de la nueva página: ");
                    String url = scanner.nextLine().trim();
                    historial.ingresarPagina(url);
                    break;

                case "2":
                    historial.retroceder();
                    break;

                case "3":
                    historial.mostrarHistorial();
                    break;

                case "4":
                    System.out.print("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine().trim();
                    if (nombreArchivo.isEmpty()) {
                        nombreArchivo = "historial.txt";
                    }
                    historial.guardarHistorial(nombreArchivo);
                    break;

                case "5":
                    System.out.println("\n¡Hasta luego!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Ingresar nueva página");
        System.out.println("2. Retroceso de página");
        System.out.println("3. Mostrar historial");
        System.out.println("4. Guardar historial en archivo");
        System.out.println("5. Salir");
    }
}
