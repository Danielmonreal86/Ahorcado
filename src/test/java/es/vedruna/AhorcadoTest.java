package es.vedruna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AhorcadoTest {

    @Test
    void testIntentarLetraAcertada() {
        Ahorcado juego = new Ahorcado("PERRO");  // Por ejemplo, palabra fija para test
        boolean resultado = juego.intentarLetra('P');
        assertTrue(resultado, "La letra P debería estar en la palabra");
        assertFalse(juego.isPerdido(), "No debería estar perdido aún");
        assertFalse(juego.isGanado(), "No debería estar ganado aún");
    }

    @Test
    void testIntentarLetraFallada() {
        Ahorcado juego = new Ahorcado("PERRO");
        boolean resultado = juego.intentarLetra('Z');
        assertFalse(resultado, "La letra Z no está en la palabra");
        assertEquals(1, juego.getFallos(), "Debe contar un fallo");
    }

    @Test
    void testGanarJuego() {
        Ahorcado juego = new Ahorcado("A");
        juego.intentarLetra('A');
        assertTrue(juego.isGanado(), "El juego debe estar ganado");
        assertFalse(juego.isPerdido(), "No debe estar perdido");
    }
}
