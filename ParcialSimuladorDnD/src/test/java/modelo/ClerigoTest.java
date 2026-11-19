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
public class ClerigoTest {
    @Test
    void testSimularCombateYSetter() {
        Clerigo c = new Clerigo("Edwin", 5, 45, "Pelor");

        assertEquals("Pelor", c.getDiosVenerado());

        String resultado = c.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 5"));
        assertTrue(resultado.contains("Edwin"));
        assertTrue(resultado.contains("Canalizar Divinidad"));
        assertTrue(resultado.contains("bendición de Pelor"));

        c.setDiosVenerado("Bahamut");
        assertEquals("Bahamut", c.getDiosVenerado());
        assertTrue(c.simularCombate().contains("bendición de Bahamut"));
    }
}
