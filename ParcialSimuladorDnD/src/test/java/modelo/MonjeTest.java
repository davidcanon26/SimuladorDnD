/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Usuario
 */
public class MonjeTest {
    @Test
    void testConPuntosKi() {
        Monje monje = new Monje("kenji", 9, 60, 5);

        assertEquals(5, monje.getPuntosKi());

        String resultado = monje.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 9"));
        assertTrue(resultado.contains("kenji"));
        assertTrue(resultado.contains("Ráfaga de Golpes"));
        assertTrue(resultado.contains("reserva de Ki (5 pts)"));
    }

    @Test
    void testSinPuntosKiYSetter() {
        Monje monje = new Monje("kenji", 9, 60, 4);
        monje.setPuntosKi(0);

        assertEquals(0, monje.getPuntosKi());

        String resultado = monje.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 9"));
        assertTrue(resultado.contains("ha agotado su Ki"));
    }
}
