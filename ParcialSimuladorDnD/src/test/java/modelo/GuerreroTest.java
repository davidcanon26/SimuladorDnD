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
public class GuerreroTest {
    @Test
    void testConArmaduraPesada() {
        Guerrero g = new Guerrero("Pepe", 7, 65, true);

        assertEquals("Pepe", g.getNombre());
        assertEquals(7, g.getNivel());
        assertEquals(65, g.getPuntosVida());
        assertTrue(g.isUsaArmaduraPesada());

        String resultado = g.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 7"));
        assertTrue(resultado.contains("Pepe"));
        assertTrue(resultado.contains("Oleada de Acción"));
        assertTrue(resultado.contains("armadura pesada absorbe el impacto frontal"));
    }

    @Test
    void testSinArmaduraPesadaYSetter() {
        Guerrero g = new Guerrero("Pepe", 4, 50, true);
        g.setUsaArmaduraPesada(false);

        assertFalse(g.isUsaArmaduraPesada());

        String resultado = g.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 4"));
        assertTrue(resultado.contains("no llevar armadura pesada"));
    }
}
