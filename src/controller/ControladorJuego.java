package controller;

import model.JuegoBuscaminas;
import view.IVista;
import exceptions.CasillaYaDescubiertaException;
import java.io.IOException;

public class ControladorJuego {
    private JuegoBuscaminas modelo;
    private IVista vista;
    private final String ARCHIVO_GUARDADO = "juego_guardado.ser";

    public ControladorJuego(JuegoBuscaminas modelo, IVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarJuego() {
        vista.mostrarMensaje("¡Bienvenido al Buscaminas!");
        vista.mostrarTablero(modelo.getTablero());

        while (!modelo.estaJuegoTerminado()) {
            String input = vista.pedirEntradaUsuario();
            if (!procesarEntrada(input)) {
                // Si la entrada no es válida o es una acción especial, no mostramos el tablero de nuevo.
                // En el caso de una entrada válida, procesarEntrada ya ha actualizado el modelo.
                vista.mostrarTablero(modelo.getTablero());
            }
        }

        if (modelo.esVictoria()) {
            vista.mostrarMensaje("¡Felicitaciones! Has ganado el juego.");
        } else {
            vista.mostrarMensaje("¡Boom! Has descubierto una mina. Fin del juego.");
            vista.mostrarTablero(modelo.getTablero()); // Mostrar el tablero final con la mina revelada
        }

        vista.cerrarScanner();
    }

    private boolean procesarEntrada(String input) {
        String comando = input.toUpperCase();

        if (comando.equals("G")) {
            guardarJuego();
            return true;
        }

        if (comando.equals("L")) {
            cargarJuego();
            return true;
        }

        // El resto del código para procesar las coordenadas es similar al anterior,
        // pero ahora maneja la lógica de la herencia y los posibles errores.
        // [Aquí iría el código de análisis de coordenadas]
        if (comando.length() < 2) {
            vista.mostrarMensajeError("Entrada inválida.");
            return false;
        }

        int fila = -1;
        int columna = -1;
        boolean esMarcar = false;

        if (comando.startsWith("M")) {
            esMarcar = true;
            if (comando.length() < 3) {
                vista.mostrarMensajeError("Formato para marcar: M[fila][columna] (ej. MA5)");
                return false;
            }
            fila = comando.charAt(1) - 'A';
            try {
                columna = Integer.parseInt(comando.substring(2)) - 1;
            } catch (NumberFormatException e) {
                vista.mostrarMensajeError("Columna inválida.");
                return false;
            }
        } else {
            fila = comando.charAt(0) - 'A';
            try {
                columna = Integer.parseInt(comando.substring(1)) - 1;
            } catch (NumberFormatException e) {
                vista.mostrarMensajeError("Columna inválida.");
                return false;
            }
        }

        if (!modelo.getTablero().esCoordenadaValida(fila, columna)) {
            vista.mostrarMensajeError("Coordenadas fuera del rango.");
            return false;
        }

        try {
            if (esMarcar) {
                modelo.marcarCasilla(fila, columna);
            } else {
                modelo.jugarTurno(fila, columna);
            }
        } catch (CasillaYaDescubiertaException e) {
            vista.mostrarMensajeError(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            vista.mostrarMensajeError("Coordenadas fuera del rango del tablero.");
        }
        return false;
    }

    private void guardarJuego() {
        try {
            modelo.guardarJuego(ARCHIVO_GUARDADO);
            vista.mostrarMensaje("Juego guardado exitosamente.");
        } catch (IOException e) {
            vista.mostrarMensajeError("No se pudo guardar el juego: " + e.getMessage());
        }
    }

    private void cargarJuego() {
        try {
            this.modelo = JuegoBuscaminas.cargarJuego(ARCHIVO_GUARDADO);
            vista.mostrarMensaje("Juego cargado exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            vista.mostrarMensajeError("No se pudo cargar el juego: " + e.getMessage());
        }
    }
}