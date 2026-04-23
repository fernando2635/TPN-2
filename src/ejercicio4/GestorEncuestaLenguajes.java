package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para gestionar la encuesta de lenguajes de programación
 * PILARES POO: Encapsulamiento, Abstracción
 */
public class GestorEncuestaLenguajes {
    private Map<String, Lenguaje> lenguajes;
    private int totalEncuestas;

    public GestorEncuestaLenguajes() {
        this.lenguajes = new HashMap<>();
        this.totalEncuestas = 0;
    }

    /**
     * Carga las encuestas desde un archivo
     */
    public void cargarEncuestas(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String primeraLinea = br.readLine();
            if (primeraLinea != null) {
                totalEncuestas = Integer.parseInt(primeraLinea.trim());
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                // Agregar o incrementar el lenguaje
                lenguajes.putIfAbsent(linea, new Lenguaje(linea));
                lenguajes.get(linea).incrementarVoto();
            }
        }
    }

    /**
     * Obtiene la lista de lenguajes ordenada descendentemente por cantidad
     */
    public List<Lenguaje> obtenerLenguajesOrdenados() {
        List<Lenguaje> lista = new ArrayList<>(lenguajes.values());
        lista.sort(null); // Usa el compareTo de Lenguaje
        return lista;
    }

    /**
     * Muestra la tabla de lenguajes ordenada con porcentajes
     */
    public void mostrarTablaLenguajes() {
        List<Lenguaje> ordenados = obtenerLenguajesOrdenados();

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("Total de encuestas: %d%n", totalEncuestas);
        System.out.println("=".repeat(60));
        System.out.printf("%-30s %-15s %-15s%n", "LENGUAJE", "CANTIDAD", "PORCENTAJE");
        System.out.println("-".repeat(60));

        for (Lenguaje lenguaje : ordenados) {
            if (!lenguaje.getNombre().equalsIgnoreCase("OTROS")) {
                System.out.printf("%-30s %-15d %-15.2f%%%n",
                        lenguaje.getNombre(),
                        lenguaje.getCantidad(),
                        lenguaje.obtenerPorcentaje(totalEncuestas));
            }
        }

        // Mostrar OTROS al final
        Lenguaje otros = lenguajes.get("OTROS");
        if (otros != null) {
            System.out.println("-".repeat(60));
            System.out.printf("%-30s %-15d %-15.2f%%%n",
                    "OTROS",
                    otros.getCantidad(),
                    otros.obtenerPorcentaje(totalEncuestas));
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Calcula estadísticas generales
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de lenguajes diferentes: " + lenguajes.size());
        System.out.println("Total de encuestas: " + totalEncuestas);

        List<Lenguaje> ordenados = obtenerLenguajesOrdenados();
        if (!ordenados.isEmpty()) {
            System.out.println("\nLenguaje más popular: " + ordenados.get(0).getNombre() +
                    " (" + ordenados.get(0).getCantidad() + " votos)");
            System.out.println("Lenguaje menos popular: " + ordenados.get(ordenados.size() - 1).getNombre() +
                    " (" + ordenados.get(ordenados.size() - 1).getCantidad() + " votos)");
        }
    }

    public int getTotalEncuestas() {
        return totalEncuestas;
    }

    public Map<String, Lenguaje> getLenguajes() {
        return lenguajes;
    }
}
