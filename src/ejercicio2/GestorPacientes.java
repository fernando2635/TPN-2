package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase para gestionar pacientes del hospital
 * PILARES POO: Encapsulamiento, Abstracción
 */
public class GestorPacientes {
    private List<Paciente> pacientes;

    public GestorPacientes() {
        this.pacientes = new ArrayList<>();
    }

    /**
     * Carga pacientes desde un archivo
     */
    public void cargarPacientes(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int contador = 0;
            String apellido = "";
            String nombre = "";
            int edad = 0;
            String sexo = "";
            int condicion = 0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                int pos = contador % 5;
                switch (pos) {
                    case 0:
                        apellido = linea;
                        break;
                    case 1:
                        edad = Integer.parseInt(linea);
                        break;
                    case 2:
                        sexo = linea;
                        break;
                    case 3:
                        condicion = Integer.parseInt(linea);
                        break;
                    case 4:
                        String telefono = linea;
                        pacientes.add(new Paciente(apellido, nombre, edad, sexo, condicion, telefono));
                        break;
                }
                contador++;
            }
        }
    }

    /**
     * Muestra todos los pacientes en forma de tabla
     */
    public void mostrarTabla() {
        System.out.println("\n" + "=".repeat(110));
        System.out.printf("%-25s %-15s %-15s %-12s %-12s %-20s%n",
                "APELLIDO, NOMBRE", "EDAD", "SEXO", "CONDICIÓN", "TELÉFONO", "");
        System.out.println("=".repeat(110));

        for (Paciente p : pacientes) {
            System.out.printf("%-25s %-15d %-15s %-12d %-20s%n",
                    p.toString(), p.getEdad(), p.getSexo(), p.getCondicion(), p.getTelefono());
        }
        System.out.println("=".repeat(110));
    }

    /**
     * Calcula porcentaje de hombres y mujeres
     */
    public void mostrarPorcentajeGenero() {
        long hombres = pacientes.stream().filter(p -> p.getSexo().equalsIgnoreCase("Masculino")).count();
        long mujeres = pacientes.stream().filter(p -> p.getSexo().equalsIgnoreCase("Femenino")).count();
        double totalPacientes = pacientes.size();

        System.out.println("\n=== PORCENTAJE DE GÉNERO ===");
        System.out.printf("Hombres: %.2f%% (%d)%n", (hombres / totalPacientes) * 100, hombres);
        System.out.printf("Mujeres: %.2f%% (%d)%n", (mujeres / totalPacientes) * 100, mujeres);
    }

    /**
     * Número de pacientes por condición
     */
    public void mostrarPacientesPorCondicion() {
        System.out.println("\n=== PACIENTES POR CONDICIÓN ===");
        for (int i = 1; i <= 5; i++) {
            long cantidad = pacientes.stream().filter(p -> p.getCondicion() == i).count();
            System.out.println("Condición " + i + ": " + cantidad + " pacientes");
        }
    }

    /**
     * Pacientes con condición máxima (gravedad 5)
     */
    public void mostrarPacientesCondicionMaxima() {
        System.out.println("\n=== PACIENTES CON CONDICIÓN MÁXIMA (5) ===");
        pacientes.stream()
                .filter(p -> p.getCondicion() == 5)
                .forEach(p -> System.out.println(p.getApellido() + " " + p.getNombre()));
    }

    /**
     * Lista de pacientes ordenada por edad
     */
    public void mostrarPacientesOrdenadosPorEdad() {
        System.out.println("\n=== PACIENTES ORDENADOS POR EDAD ===");
        List<Paciente> pacientesOrdenados = new ArrayList<>(pacientes);
        pacientesOrdenados.sort((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
        pacientesOrdenados.forEach(p -> System.out.printf("%-25s - Edad: %d%n", p.toString(), p.getEdad()));
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
