package view;

import model.Tablero;
import java.util.Scanner;

public class VistaConsola implements IVista {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void mostrarTablero(Tablero tablero) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        System.out.println(" ---------------------");
        for (int i = 0; i < tablero.getFilas(); i++) {
            System.out.print((char) ('A' + i) + "|");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print(tablero.getCasilla(i, j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String pedirEntradaUsuario() {
        System.out.print("Introduce 'L' para cargar, 'G' para guardar, coordenada (ej. A5) o 'M' para marcar: ");
        return scanner.nextLine().trim();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    @Override
    public void cerrarScanner() {
        scanner.close();
    }
}
