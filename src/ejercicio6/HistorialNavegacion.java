package ejercicio6;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase HistorialNavegacion - Implementa una pila (Stack) para el historial de navegación
 * PILARES POO: Abstracción, Encapsulamiento, Polimorfismo
 */
public class HistorialNavegacion {
    // Encapsulamiento: atributo privado
    private Stack<Pagina> pila;
    private Pagina paginaActual;

    /**
     * Constructor que inicializa el historial
     */
    public HistorialNavegacion() {
        this.pila = new Stack<>();
    }

    /**
     * Ingresa una nueva página al historial
     */
    public void ingresarPagina(String url) {
        if (url == null || url.trim().isEmpty()) {
            System.out.println("Error: URL inválida.");
            return;
        }

        // Guardar página actual en la pila antes de navegar
        if (paginaActual != null) {
            pila.push(paginaActual);
        }

        paginaActual = new Pagina(url);
        System.out.println("Nueva página visitada: " + url);
    }

    /**
     * Retrocede a la página anterior (pop del stack)
     */
    public void retroceder() {
        if (pila.isEmpty()) {
            System.out.println("No hay páginas anteriores para retroceder.");
            return;
        }

        paginaActual = pila.pop();
        System.out.println("Retrocedido a: " + paginaActual.getUrl());
    }

    /**
     * Muestra el historial completo de navegación
     */
    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE NAVEGACIÓN ===");
        System.out.println("Página actual: " + (paginaActual != null ? paginaActual.getUrl() : "Ninguna"));

        if (pila.isEmpty()) {
            System.out.println("No hay páginas anteriores en el historial.");
            return;
        }

        System.out.println("\nHistorial (de más reciente a más antigua):");
        List<Pagina> temp = new ArrayList<>(pila);
        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.printf("%d. %s%n", temp.size() - i, temp.get(i).getUrl());
        }
    }

    /**
     * Guarda el historial en un archivo
     */
    public void guardarHistorial(String nombreArchivo) {
        try (java.io.FileWriter fw = new java.io.FileWriter(nombreArchivo);
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {

            bw.write("=== HISTORIAL DE NAVEGACIÓN ===");
            bw.newLine();
            bw.write("Página actual: " + (paginaActual != null ? paginaActual.getUrl() : "Ninguna"));
            bw.newLine();
            bw.newLine();

            if (!pila.isEmpty()) {
                bw.write("Páginas visitadas:");
                bw.newLine();
                List<Pagina> temp = new ArrayList<>(pila);
                for (int i = temp.size() - 1; i >= 0; i--) {
                    bw.write((temp.size() - i) + ". " + temp.get(i).getUrl());
                    bw.newLine();
                }
            }

            System.out.println("Historial guardado en: " + nombreArchivo);
        } catch (java.io.IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    /**
     * Obtiene el tamaño del historial
     */
    public int obtenerTamanoHistorial() {
        return pila.size();
    }

    /**
     * Obtiene la página actual
     */
    public Pagina obtenerPaginaActual() {
        return paginaActual;
    }

    /**
     * Limpia el historial
     */
    public void limpiarHistorial() {
        pila.clear();
        System.out.println("Historial limpiado.");
    }
}
