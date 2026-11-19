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
public class ExploradorTest {
    @Test
    void testSimularCombateYSetter() {
        Explorador e = new Explorador("Goku", 6, 55, "Bosque");

        assertEquals("Bosque", e.getTerrenoFavorecido());

        String resultado = e.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 6"));
        assertTrue(resultado.contains("Goku"));
        assertTrue(resultado.contains("Marca del Cazador"));
        assertTrue(resultado.contains("entorno de Bosque"));

        e.setTerrenoFavorecido("Montaña");
        assertEquals("Montaña", e.getTerrenoFavorecido());
        assertTrue(e.simularCombate().contains("entorno de Montaña"));
    }
}
