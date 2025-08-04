package model;

import exceptions.CasillaYaDescubiertaException;
import java.io.*;

public class JuegoBuscaminas implements Serializable {
    private Tablero tablero;
    private boolean juegoTerminado;
    private boolean victoria;

    public JuegoBuscaminas() {
        this.tablero = new Tablero();
        this.juegoTerminado = false;
        this.victoria = false;
    }

    // Método para guardar el estado del juego
    public void guardarJuego(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        }
    }

    // Método estático para cargar el juego desde un archivo
    public static JuegoBuscaminas cargarJuego(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (JuegoBuscaminas) ois.readObject();
        }
    }

    public void jugarTurno(int fila, int columna) throws CasillaYaDescubiertaException {
        if (juegoTerminado) return;

        Casilla casilla = tablero.getCasilla(fila, columna);
        if (casilla.estaMarcada()) return;

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
