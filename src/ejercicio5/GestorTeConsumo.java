package ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para gestionar el consumo de té
 * PILARES POO: Encapsulamiento, Abstracción
 */
public class GestorTeConsumo {
    private List<Te> consumos;
    private Map<String, Integer> consumoPorVariedad;
    private Map<Integer, Integer> consumoPorDia; // 1-7
    private Map<Integer, Integer> consumoPorMomento; // 1-4

    public GestorTeConsumo() {
        this.consumos = new ArrayList<>();
        this.consumoPorVariedad = new HashMap<>();
        this.consumoPorDia = new HashMap<>();
        this.consumoPorMomento = new HashMap<>();

        // Inicializar días y momentos
        for (int i = 1; i <= 7; i++) {
            consumoPorDia.put(i, 0);
        }
        for (int i = 1; i <= 4; i++) {
            consumoPorMomento.put(i, 0);
        }
    }

    /**
     * Carga los datos de consumo desde un archivo
     */
    public void cargarConsumos(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String primeraLinea = br.readLine();
            // Primera línea contiene la cantidad (500)

            String linea;
            int contador = 0;
            String variedad = "";
            int dia = 0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                int pos = contador % 3;
                switch (pos) {
                    case 0:
                        variedad = linea;
                        break;
                    case 1:
                        dia = Integer.parseInt(linea);
                        break;
                    case 2:
                        int momento = Integer.parseInt(linea);
                        Te te = new Te(variedad, dia, momento);
                        consumos.add(te);

                        // Actualizar estadísticas
                        consumoPorVariedad.put(variedad, consumoPorVariedad.getOrDefault(variedad, 0) + 1);
                        consumoPorDia.put(dia, consumoPorDia.get(dia) + 1);
                        consumoPorMomento.put(momento, consumoPorMomento.get(momento) + 1);
                        break;
                }
                contador++;
            }
        }
    }

    /**
     * Reporte 1: Cantidad de tés consumidos por variedad (ordenado descendente)
     */
    public void mostrarReporte1PorVariedad() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("REPORTE 1: TSÉS POR VARIEDAD");
        System.out.println("=".repeat(50));

        consumoPorVariedad.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(entry -> System.out.printf("%-40s %d%n", entry.getKey(), entry.getValue()));
    }

    /**
     * Reporte 2: Cantidad de tés consumidos por día de la semana
     */
    public void mostrarReporte2PorDia() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("REPORTE 2: TSÉS POR DÍA DE LA SEMANA");
        System.out.println("=".repeat(50));

        String[] dias = {"DOMINGO", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO"};
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%-15s %d%n", i + " " + dias[i - 1], consumoPorDia.get(i));
        }
    }

    /**
     * Reporte 3: Cantidad de tés consumidos por franja horaria
     */
    public void mostrarReporte3PorMomento() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("REPORTE 3: TSÉS POR FRANJA HORARIA");
        System.out.println("=".repeat(50));

        String[] momentos = {"MAÑANA", "MEDIODÍA", "TARDE", "NOCHE"};
        for (int i = 1; i <= 4; i++) {
            System.out.printf("%-15s %d%n", i + " " + momentos[i - 1], consumoPorMomento.get(i));
        }
    }

    /**
     * Muestra estadísticas generales
     */
    public void mostrarEstadisticas() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ESTADÍSTICAS GENERALES");
        System.out.println("=".repeat(50));
        System.out.println("Total de tés consumidos: " + consumos.size());
        System.out.println("Variedades diferentes: " + consumoPorVariedad.size());
    }

    public List<Te> getConsumos() {
        return consumos;
    }

    public Map<String, Integer> getConsumoPorVariedad() {
        return consumoPorVariedad;
    }

    public Map<Integer, Integer> getConsumoPorDia() {
        return consumoPorDia;
    }

    public Map<Integer, Integer> getConsumoPorMomento() {
        return consumoPorMomento;
    }
}
