package ejercicio6;

import java.util.Stack;

/**
 * Clase Pagina - Representa una página web visitada
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Pagina {
    // Encapsulamiento: atributos privados
    private String url;
    private long tiempoVisita;

    /**
     * Constructor que inicializa una página web
     */
    public Pagina(String url) {
        this.url = url;
        this.tiempoVisita = System.currentTimeMillis();
    }

    // Getters - Encapsulamiento
    public String getUrl() {
        return url;
    }

    public long getTiempoVisita() {
        return tiempoVisita;
    }

    @Override
    public String toString() {
        return url;
    }
}
