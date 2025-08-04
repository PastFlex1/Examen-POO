package view;

import model.Tablero;
import java.util.Scanner;
import java.util.InputMismatchException;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

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

    public String pedirEntradaUsuario() {
        System.out.print("Introduce la coordenada (ej. A5) o 'M' para marcar: ");
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMensajeError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
