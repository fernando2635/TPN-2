package ejercicio1;

import java.util.Scanner;

/**
 * Programa principal para el Ejercicio 1: Distancia entre puntos
 * Solicita al usuario las coordenadas de dos puntos y calcula la distancia
 */
public class MainEjercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EJERCICIO 1: DISTANCIA ENTRE PUNTOS ===");
        System.out.println();

        // Solicitar coordenadas del primer punto
        System.out.println("Ingrese las coordenadas del PRIMER punto:");
        System.out.print("Coordenada X: ");
        double x1 = scanner.nextDouble();
        System.out.print("Coordenada Y: ");
        double y1 = scanner.nextDouble();

        Punto punto1 = new Punto(x1, y1);

        // Solicitar coordenadas del segundo punto
        System.out.println("\nIngrese las coordenadas del SEGUNDO punto:");
        System.out.print("Coordenada X: ");
        double x2 = scanner.nextDouble();
        System.out.print("Coordenada Y: ");
        double y2 = scanner.nextDouble();

        Punto punto2 = new Punto(x2, y2);

        // Calcular distancia
        double distancia = punto1.distanciaEntreDosPuntos(punto2);

        // Mostrar resultados
        System.out.println("\n=== RESULTADO ===");
        System.out.println("Punto 1: " + punto1);
        System.out.println("Punto 2: " + punto2);
        System.out.printf("Distancia entre los puntos: %.2f%n", distancia);

        scanner.close();
    }
}
