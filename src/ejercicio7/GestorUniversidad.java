package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para gestionar alumnos y asignaturas de la universidad
 * PILARES POO: Encapsulamiento, Abstracción, Herencia
 */
public class GestorUniversidad {
    private List<Alumno> alumnos;
    private Map<String, Asignatura> asignaturas;
    private int cantidadAsignaturas;

    public GestorUniversidad() {
        this.alumnos = new ArrayList<>();
        this.asignaturas = new HashMap<>();
        this.cantidadAsignaturas = 0;
    }

    /**
     * Carga los datos del archivo datos_universidad.txt
     */
    public void cargarDatos(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int lineaNum = 0;
            int cantAlumnos = 0;
            List<String> apellidos = new ArrayList<>();
            List<String> nombres = new ArrayList<>();
            List<Integer> edades = new ArrayList<>();
            List<String> sexos = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                lineaNum++;

                // Primera línea: cantidad de alumnos
                if (lineaNum == 1) {
                    cantAlumnos = Integer.parseInt(linea);
                    continue;
                }

                // Líneas de datos de alumnos (apellido, nombre, edad, sexo)
                int posAlumno = (lineaNum - 2) % 4;
                int numAlumno = (lineaNum - 2) / 4;

                if (posAlumno == 0) {
                    apellidos.add(linea);
                } else if (posAlumno == 1) {
                    nombres.add(linea);
                } else if (posAlumno == 2) {
                    edades.add(Integer.parseInt(linea));
                } else if (posAlumno == 3) {
                    sexos.add(linea);
                }

                // Una vez tenemos todos los datos del alumno, crearlo
                if (posAlumno == 3 && apellidos.size() == numAlumno + 1) {
                    // Siguiente línea será la cantidad de asignaturas
                    linea = br.readLine();
                    if (linea != null) {
                        cantidadAsignaturas = Integer.parseInt(linea.trim());
                    }

                    // Leer nombres de asignaturas
                    for (int i = 0; i < cantidadAsignaturas; i++) {
                        linea = br.readLine();
                        if (linea != null) {
                            String nombreAsignatura = linea.trim();
                            asignaturas.putIfAbsent(nombreAsignatura, new Asignatura(nombreAsignatura));
                        }
                    }

                    // Crear alumno
                    Alumno alumno = new Alumno(apellidos.get(numAlumno), nombres.get(numAlumno),
                            edades.get(numAlumno), sexos.get(numAlumno), cantidadAsignaturas);

                    // Leer calificaciones
                    linea = br.readLine();
                    if (linea != null) {
                        String[] calificacionesStr = linea.trim().split(" ");
                        for (int i = 0; i < Math.min(calificacionesStr.length, cantidadAsignaturas); i++) {
                            try {
                                double cal = Double.parseDouble(calificacionesStr[i]);
                                alumno.setCalificacion(i, cal);
                            } catch (NumberFormatException e) {
                                // Ignorar si no es un número válido
                            }
                        }
                    }

                    alumnos.add(alumno);

                    // Agregar alumno a cada asignatura
                    List<String> nombresAsignaturas = new ArrayList<>(asignaturas.keySet());
                    for (int i = 0; i < Math.min(nombresAsignaturas.size(), cantidadAsignaturas); i++) {
                        asignaturas.get(nombresAsignaturas.get(i)).agregarAlumno(alumno);
                    }
                }
            }
        }
    }

    /**
     * Genera reportes para cada asignatura y los guarda en archivos
     */
    public void generarReportes(String directorio) throws IOException {
        for (Asignatura asignatura : asignaturas.values()) {
            String nombreArchivo = directorio + "/" + asignatura.getNombre() + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                bw.write(asignatura.generarReporte());
            }
            System.out.println("Reporte guardado: " + nombreArchivo);
        }
    }

    /**
     * Muestra información de todos los alumnos
     */
    public void mostrarTodosAlumnos() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TODOS LOS ALUMNOS");
        System.out.println("=".repeat(80));
        for (Alumno alumno : alumnos) {
            System.out.printf("%-35s - Edad: %d - Sexo: %s%n",
                    alumno.getNombreCompleto(), alumno.getEdad(), alumno.getSexo());
        }
    }

    /**
     * Muestra todas las asignaturas
     */
    public void mostrarAsignaturas() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ASIGNATURAS");
        System.out.println("=".repeat(80));
        for (Asignatura asignatura : asignaturas.values()) {
            System.out.println(asignatura);
        }
    }

    /**
     * Muestra los reportes de todas las asignaturas en consola
     */
    public void mostrarReportesConsola() {
        for (Asignatura asignatura : asignaturas.values()) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(asignatura.generarReporte());
        }
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Map<String, Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
