package model;

import java.util.Random;
import exceptions.CasillaYaDescubiertaException;

public class Tablero {
    private Casilla[][] casillas;
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int NUM_MINAS = 10;

    public Tablero() {
        this.casillas = new Casilla[FILAS][COLUMNAS];
        inicializarTablero();
        colocarMinasAleatoriamente();
        calcularNumerosMinasAdyacentes();
    }

    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinasAleatoriamente() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < NUM_MINAS) {
            int fila = rand.nextInt(FILAS);
            int columna = rand.nextInt(COLUMNAS);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna].colocarMina();
                minasColocadas++;
            }
        }
    }

    private void calcularNumerosMinasAdyacentes() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!casillas[i][j].tieneMina()) {
                    int contador = 0;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int nuevaFila = i + di;
                            int nuevaColumna = j + dj;
                            if (esCoordenadaValida(nuevaFila, nuevaColumna) && casillas[nuevaFila][nuevaColumna].tieneMina()) {
                                contador++;
                            }
                        }
                    }
                    casillas[i][j].setNumeroMinasAdyacentes(contador);
                }
            }
        }
    }

    public boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }

    public Casilla getCasilla(int fila, int columna) {
        if (!esCoordenadaValida(fila, columna)) {
            throw new ArrayIndexOutOfBoundsException("Coordenadas fuera del tablero.");
        }
        return casillas[fila][columna];
    }

    // Método para descubrir una casilla y sus adyacentes si es vacía.
    public void descubrirCasilla(int fila, int columna) throws CasillaYaDescubiertaException {
        Casilla casilla = getCasilla(fila, columna);

        if (casilla.estaDescubierta()) {
            throw new CasillaYaDescubiertaException("La casilla ya ha sido descubierta.");
        }

        casilla.descubrir();

        if (casilla.getNumeroMinasAdyacentes() == 0 && !casilla.tieneMina()) {
            descubrirCasillasVaciasAdyacentes(fila, columna);
        }
    }

    // Lógica para el "revelado en cascada"
    private void descubrirCasillasVaciasAdyacentes(int fila, int columna) {
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue; // No descubrir la misma casilla

                int nuevaFila = fila + di;
                int nuevaColumna = columna + dj;

                if (esCoordenadaValida(nuevaFila, nuevaColumna)) {
                    Casilla adyacente = casillas[nuevaFila][nuevaColumna];
                    if (!adyacente.estaDescubierta() && !adyacente.tieneMina() && !adyacente.estaMarcada()) {
                        adyacente.descubrir();
                        if (adyacente.getNumeroMinasAdyacentes() == 0) {
                            descubrirCasillasVaciasAdyacentes(nuevaFila, nuevaColumna); // Recursividad
                        }
                    }
                }
            }
        }
    }

    public boolean todasLasCasillasSegurasDescubiertas() {
        int casillasSeguras = FILAS * COLUMNAS - NUM_MINAS;
        int casillasDescubiertas = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (casillas[i][j].estaDescubierta() && !casillas[i][j].tieneMina()) {
                    casillasDescubiertas++;
                }
            }
        }
        return casillasDescubiertas == casillasSeguras;
    }

    public int getFilas() {
        return FILAS;
    }

    public int getColumnas() {
        return COLUMNAS;
    }
}
