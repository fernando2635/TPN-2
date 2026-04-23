package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar deportistas de la UNdeC
 * PILARES POO: Encapsulamiento, Abstracción
 */
public class GestorDeportistas {
    private List<Deportista> deportistas;

    public GestorDeportistas() {
        this.deportistas = new ArrayList<>();
    }

    /**
     * Carga deportistas desde un archivo
     */
    public void cargarDeportistas(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int contador = 0;
            String nombre = "";
            int edad = 0;
            String carrera = "";
            String deporte = "";

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                int pos = contador % 5;
                switch (pos) {
                    case 0:
                        nombre = linea;
                        break;
                    case 1:
                        edad = Integer.parseInt(linea);
                        break;
                    case 2:
                        carrera = linea;
                        break;
                    case 3:
                        deporte = linea;
                        break;
                    case 4:
                        int medallas = Integer.parseInt(linea);
                        deportistas.add(new Deportista(nombre, edad, carrera, deporte, medallas));
                        break;
                }
                contador++;
            }
        }
    }

    /**
     * Calcula el promedio de medallas
     */
    public double calcularPromedioMedallas() {
        if (deportistas.isEmpty()) return 0;
        int totalMedallas = deportistas.stream()
                .mapToInt(Deportista::getNumeroMedallas)
                .sum();
        return (double) totalMedallas / deportistas.size();
    }

    /**
     * Encuentra deportistas con más medallas que el promedio
     */
    public void mostrarDeportistasConMasDelPromedio() {
        double promedio = calcularPromedioMedallas();
        System.out.println("\n=== DEPORTISTAS CON MÁS MEDALLAS QUE EL PROMEDIO ===");
        System.out.printf("Promedio de medallas: %.2f%n", promedio);
        System.out.println();

        deportistas.stream()
                .filter(d -> d.getNumeroMedallas() > promedio)
                .forEach(d -> System.out.printf("%-30s - %d medallas%n", 
                        d.getNombreYApellido(), d.getNumeroMedallas()));
    }

    /**
     * Encuentra deportista con mayor número de medallas
     */
    public void mostrarDeportistaMayorMedallas() {
        if (deportistas.isEmpty()) return;
        
        Deportista max = deportistas.stream()
                .max((d1, d2) -> Integer.compare(d1.getNumeroMedallas(), d2.getNumeroMedallas()))
                .orElse(null);

        if (max != null) {
            System.out.println("\n=== DEPORTISTA CON MAYOR NÓMERO DE MEDALLAS ===");
            System.out.printf("Nombre: %s%n", max.getNombreYApellido());
            System.out.printf("Carrera: %s%n", max.getCarrera());
            System.out.printf("Deporte: %s%n", max.getDeporte());
            System.out.printf("Medallas: %d%n", max.getNumeroMedallas());
        }
    }

    /**
     * Encuentra deportista con menor número de medallas
     */
    public void mostrarDeportistaMenorMedallas() {
        if (deportistas.isEmpty()) return;
        
        Deportista min = deportistas.stream()
                .min((d1, d2) -> Integer.compare(d1.getNumeroMedallas(), d2.getNumeroMedallas()))
                .orElse(null);

        if (min != null) {
            System.out.println("\n=== DEPORTISTA CON MENOR NÓMERO DE MEDALLAS ===");
            System.out.printf("Nombre: %s%n", min.getNombreYApellido());
            System.out.printf("Carrera: %s%n", min.getCarrera());
            System.out.printf("Deporte: %s%n", min.getDeporte());
            System.out.printf("Medallas: %d%n", min.getNumeroMedallas());
        }
    }

    /**
     * Muestra información de todos los deportistas
     */
    public void mostrarTodosDeportistas() {
        System.out.println("\n" + "=".repeat(120));
        System.out.printf("%-35s %-10s %-20s %-20s %-10s%n",
                "NOMBRE Y APELLIDO", "EDAD", "CARRERA", "DEPORTE", "MEDALLAS");
        System.out.println("=".repeat(120));

        deportistas.forEach(d -> System.out.printf("%-35s %-10d %-20s %-20s %-10d%n",
                d.getNombreYApellido(), d.getEdad(), d.getCarrera(), 
                d.getDeporte(), d.getNumeroMedallas()));
        System.out.println("=".repeat(120));
    }

    public List<Deportista> getDeportistas() {
        return deportistas;
    }
}
