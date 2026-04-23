package ejercicio5;

/**
 * Clase Te - Representa un producto de té
 * PILARES POO: Abstracción, Encapsulamiento
 */
public class Te {
    // Encapsulamiento: atributos privados
    private String variedad;
    private int dia; // 1-7 (domingo a sábado)
    private int momento; // 1-4 (mañana, mediodía, tarde, noche)

    /**
     * Constructor que inicializa los datos del consumo de té
     */
    public Te(String variedad, int dia, int momento) {
        this.variedad = variedad;
        this.dia = dia;
        this.momento = momento;
    }

    // Getters - Encapsulamiento
    public String getVariedad() {
        return variedad;
    }

    public int getDia() {
        return dia;
    }

    public int getMomento() {
        return momento;
    }

    // Setters - Encapsulamiento
    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 7) {
            this.dia = dia;
        }
    }

    public void setMomento(int momento) {
        if (momento >= 1 && momento <= 4) {
            this.momento = momento;
        }
    }

    /**
     * Obtiene el nombre del día de la semana
     */
    public String getNombreDia() {
        String[] dias = {"DOMINGO", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO"};
        return dias[dia - 1];
    }

    /**
     * Obtiene el nombre de la franja horaria
     */
    public String getNombreMomento() {
        String[] momentos = {"MAÑANA", "MEDIODÍA", "TARDE", "NOCHE"};
        return momentos[momento - 1];
    }

    @Override
    public String toString() {
        return variedad + " | Día: " + getNombreDia() + " | Momento: " + getNombreMomento();
    }
}
