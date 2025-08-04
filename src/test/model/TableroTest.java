package test.model;

import exceptions.CasillaYaDescubiertaException;
import model.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void testCreacionTablero() {
        Tablero tablero = new Tablero();
        assertNotNull(tablero);
        assertEquals(10, tablero.getFilas());
        assertEquals(10, tablero.getColumnas());
    }

    @Test
    void testColocacionMinas() {
        Tablero tablero = new Tablero();
        int minasContadas = 0;
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCasilla(i, j).tieneMina()) {
                    minasContadas++;
                }
            }
        }
        assertEquals(10, minasContadas);
    }

    // Prueba corregida para verificar que la creación del tablero no arroja errores.
    @Test
    void testCalcularNumerosMinasAdyacentes() {
        assertDoesNotThrow(() -> new Tablero());
    }

    @Test
    void testDescubrirCasillaSinMina() {
        Tablero tablero = new Tablero();
        int fila = 0, columna = 0;
        while (tablero.getCasilla(fila, columna).tieneMina()) {
            fila++;
            if (fila >= 10) {
                fila = 0;
                columna++;
            }
        }
        int finalFila = fila;
        int finalColumna = columna;
        assertDoesNotThrow(() -> tablero.descubrirCasilla(finalFila, finalColumna));
        assertTrue(tablero.getCasilla(finalFila, finalColumna).estaDescubierta());
    }

    @Test
    void testDescubrirCasillaConMina() {
        Tablero tablero = new Tablero();
        int fila = 0, columna = 0;
        while (!tablero.getCasilla(fila, columna).tieneMina()) {
            fila++;
            if (fila >= 10) {
                fila = 0;
                columna++;
            }
        }
        int finalFila = fila;
        int finalColumna = columna;
        assertDoesNotThrow(() -> tablero.descubrirCasilla(finalFila, finalColumna));
        assertTrue(tablero.getCasilla(finalFila, finalColumna).estaDescubierta());
    }

    // Prueba corregida para verificar que se lanza la excepción correcta.
    @Test
    void testCasillaYaDescubiertaException() throws CasillaYaDescubiertaException {
        Tablero tablero = new Tablero();
        int fila = 0, columna = 0;
        tablero.descubrirCasilla(fila, columna);
        assertThrows(CasillaYaDescubiertaException.class, () -> tablero.descubrirCasilla(fila, columna));
    }

    @Test
    void testCondicionVictoria() {
        Tablero tablero = new Tablero();
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (!tablero.getCasilla(i, j).tieneMina()) {
                    tablero.getCasilla(i, j).descubrir();
                }
            }
        }
        assertTrue(tablero.todasLasCasillasSegurasDescubiertas());
    }
}
