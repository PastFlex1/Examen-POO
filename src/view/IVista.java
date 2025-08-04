package view;

import model.Tablero;

public interface IVista {
    void mostrarTablero(Tablero tablero);
    String pedirEntradaUsuario();
    void mostrarMensaje(String mensaje);
    void mostrarMensajeError(String mensaje);
    void cerrarScanner();
}
