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
public class PicaroTest {
    @Test
    void testConHerramientasLadron() {
        Picaro p = new Picaro("Vex", 5, 42, true);

        assertTrue(p.isHerramientasLadron());

        String resultado = p.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 5"));
        assertTrue(resultado.contains("Vex"));
        assertTrue(resultado.contains("Ataque Furtivo"));
        assertTrue(resultado.contains("herramientas de ladrón"));
    }

    @Test
    void testSinHerramientasLadronYSetter() {
        Picaro p = new Picaro("Vex", 5, 42, true);
        p.setHerramientasLadron(false);

        assertFalse(p.isHerramientasLadron());

        String resultado = p.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 5"));
        assertTrue(resultado.contains("sigilo y reflejos"));
    }
}
