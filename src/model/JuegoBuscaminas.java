package model;

import exceptions.CasillaYaDescubiertaException;

public class JuegoBuscaminas {
    private Tablero tablero;
    private boolean juegoTerminado;
    private boolean victoria;

    public JuegoBuscaminas() {
        this.tablero = new Tablero();
        this.juegoTerminado = false;
        this.victoria = false;
    }

    public void jugarTurno(int fila, int columna) throws CasillaYaDescubiertaException {
        if (juegoTerminado) return;

        Casilla casilla = tablero.getCasilla(fila, columna);

        if (casilla.estaMarcada()) {
            return; // No se puede descubrir una casilla marcada
        }

        tablero.descubrirCasilla(fila, columna);

        if (casilla.tieneMina()) {
            juegoTerminado = true;
            victoria = false;
        } else if (tablero.todasLasCasillasSegurasDescubiertas()) {
            juegoTerminado = true;
            victoria = true;
        }
    }

    public void marcarCasilla(int fila, int columna) {
        if (juegoTerminado) return;

        Casilla casilla = tablero.getCasilla(fila, columna);
        if (!casilla.estaDescubierta()) {
            casilla.marcar();
        }
    }

    // Getters
    public Tablero getTablero() {
        return tablero;
    }

    public boolean estaJuegoTerminado() {
        return juegoTerminado;
    }

    public boolean esVictoria() {
        return victoria;
    }
}
