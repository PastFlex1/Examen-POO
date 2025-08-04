package test.model;

import model.CasillaMina;
import model.CasillaNumero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {

    private CasillaMina casillaMina;
    private CasillaNumero casillaNumero;

    @BeforeEach
    void setUp() {
        casillaMina = new CasillaMina();
        casillaNumero = new CasillaNumero();
    }

    @Test
    void testTieneMina() {
        assertTrue(casillaMina.tieneMina());
        assertFalse(casillaNumero.tieneMina());
    }

    @Test
    void testDescubrirCasilla() {
        assertFalse(casillaNumero.estaDescubierta());
        casillaNumero.descubrir();
        assertTrue(casillaNumero.estaDescubierta());
    }

    @Test
    void testMarcarCasilla() {
        assertFalse(casillaNumero.estaMarcada());
        casillaNumero.marcar();
        assertTrue(casillaNumero.estaMarcada());
        casillaNumero.marcar(); // Desmarcar
        assertFalse(casillaNumero.estaMarcada());
    }

    @Test
    void testSetNumeroMinasAdyacentes() {
        assertEquals(0, casillaNumero.getNumeroMinasAdyacentes());
        casillaNumero.setNumeroMinasAdyacentes(3);
        assertEquals(3, casillaNumero.getNumeroMinasAdyacentes());
    }
}
