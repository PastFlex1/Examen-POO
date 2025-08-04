package controller;

import model.JuegoBuscaminas;
import view.VistaConsola;
import exceptions.CasillaYaDescubiertaException;

public class ControladorJuego {
    private JuegoBuscaminas modelo;
    private VistaConsola vista;

    public ControladorJuego(JuegoBuscaminas modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarJuego() {
        vista.mostrarMensaje("¡Bienvenido al Buscaminas!");
        vista.mostrarTablero(modelo.getTablero());

        while (!modelo.estaJuegoTerminado()) {
            String input = vista.pedirEntradaUsuario();
            procesarEntrada(input);
            vista.mostrarTablero(modelo.getTablero());
        }

        if (modelo.esVictoria()) {
            vista.mostrarMensaje("¡Felicitaciones! Has ganado el juego.");
        } else {
            vista.mostrarMensaje("¡Boom! Has descubierto una mina. Fin del juego.");
        }

        vista.cerrarScanner();
    }

    private void procesarEntrada(String input) {
        // Ejemplo de entrada: "A5" o "MA5"
        if (input.length() < 2) {
            vista.mostrarMensajeError("Entrada inválida. Usa el formato A5.");
            return;
        }

        char primeraLetra = input.toUpperCase().charAt(0);
        int fila = -1;
        int columna = -1;
        boolean esMarcar = false;

        if (primeraLetra == 'M') {
            esMarcar = true;
            if (input.length() < 3) {
                vista.mostrarMensajeError("Entrada para marcar inválida. Usa el formato MA5.");
                return;
            }
            primeraLetra = input.toUpperCase().charAt(1);
            try {
                columna = Integer.parseInt(input.substring(2)) - 1;
            } catch (NumberFormatException e) {
                vista.mostrarMensajeError("Formato de columna inválido.");
                return;
            }
        } else {
            try {
                columna = Integer.parseInt(input.substring(1)) - 1;
            } catch (NumberFormatException e) {
                vista.mostrarMensajeError("Formato de columna inválido.");
                return;
            }
        }

        fila = primeraLetra - 'A';

        if (esMarcar) {
            if (modelo.getTablero().esCoordenadaValida(fila, columna)) {
                modelo.marcarCasilla(fila, columna);
            } else {
                vista.mostrarMensajeError("Coordenadas fuera del rango del tablero.");
            }
        } else {
            try {
                if (modelo.getTablero().esCoordenadaValida(fila, columna)) {
                    modelo.jugarTurno(fila, columna);
                } else {
                    vista.mostrarMensajeError("Coordenadas fuera del rango del tablero.");
                }
            } catch (ArrayIndexOutOfBoundsException | CasillaYaDescubiertaException e) {
                vista.mostrarMensajeError(e.getMessage());
            }
        }
    }
}
