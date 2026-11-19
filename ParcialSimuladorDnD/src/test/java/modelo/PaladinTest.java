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
public class PaladinTest {
    @Test
    void testSimularCombateYSetter() {
        Paladin p = new Paladin("Arthur", 8, 72, 18);

        assertEquals(18, p.getPuntosFuerza());

        String resultado = p.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 8"));
        assertTrue(resultado.contains("Arthur"));
        assertTrue(resultado.contains("Castigo Divino"));
        assertTrue(resultado.contains("18 puntos de fuerza"));

        p.setPuntosFuerza(20);
        assertEquals(20, p.getPuntosFuerza());
        assertTrue(p.simularCombate().contains("20 puntos de fuerza"));
    }
}
