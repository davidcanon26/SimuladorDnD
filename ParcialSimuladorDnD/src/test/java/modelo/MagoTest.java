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
public class MagoTest {
    @Test
    void testConEspaciosConjuro() {
        Mago m = new Mago("Elminster", 6, 38, 3);

        assertEquals(3, m.getEspaciosConjuro());

        String resultado = m.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 6"));
        assertTrue(resultado.contains("Elminster"));
        assertTrue(resultado.contains("Bola de Fuego"));
        assertTrue(resultado.contains("espacios de conjuro restantes (3)"));
    }

    @Test
    void testSinEspaciosConjuroYSetter() {
        Mago m = new Mago("Elminster", 6, 38, 2);
        m.setEspaciosConjuro(0);

        assertEquals(0, m.getEspaciosConjuro());

        String resultado = m.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 6"));
        assertTrue(resultado.contains("no tener espacios de conjuro disponibles"));
    }
}
