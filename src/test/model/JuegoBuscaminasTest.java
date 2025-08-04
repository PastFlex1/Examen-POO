package test.model;

import exceptions.CasillaYaDescubiertaException;
import model.JuegoBuscaminas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JuegoBuscaminasTest {

    private JuegoBuscaminas juego;

    @BeforeEach
    void setUp() {
        juego = new JuegoBuscaminas();
    }

    @Test
    void testJuegoNoTerminadoAlInicio() {
        assertFalse(juego.estaJuegoTerminado());
    }

    @Test
    void testDerrotaAlDescubrirMina() {
        int fila = 0, columna = 0;
        // Encontrar una casilla que sea una mina para la prueba
        while (!juego.getTablero().getCasilla(fila, columna).tieneMina()) {
            fila++;
            if (fila >= 10) {
                fila = 0;
                columna++;
            }
        }
        try {
            juego.jugarTurno(fila, columna);
        } catch (CasillaYaDescubiertaException e) {
            fail("Excepción inesperada.");
        }
        assertTrue(juego.estaJuegoTerminado());
        assertFalse(juego.esVictoria());
    }

    @Test
    void testVictoriaAlDescubrirTodasLasCasillasSeguras() {
        // Simular la victoria descubriendo todas las casillas seguras
        for (int i = 0; i < juego.getTablero().getFilas(); i++) {
            for (int j = 0; j < juego.getTablero().getColumnas(); j++) {
                if (!juego.getTablero().getCasilla(i, j).tieneMina()) {
                    try {
                        juego.jugarTurno(i, j);
                    } catch (CasillaYaDescubiertaException e) {
                        // Ignorar si ya está descubierta por la cascada
                    }
                }
            }
        }
        assertTrue(juego.estaJuegoTerminado());
        assertTrue(juego.esVictoria());
    }
}
