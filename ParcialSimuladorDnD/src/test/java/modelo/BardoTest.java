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
public class BardoTest {
    @Test
    void testSimularCombateYSetter() {
        Bardo b = new Bardo("Tilin", 4, 36, "Laúd");

        assertEquals("Laúd", b.getInstrumentoMusical());

        String resultado = b.simularCombate();
        assertTrue(resultado.contains("Ataque de nivel 4"));
        assertTrue(resultado.contains("Tilin"));
        assertTrue(resultado.contains("Inspiración Bárdica"));
        assertTrue(resultado.contains("resonar su Laúd"));

        b.setInstrumentoMusical("Flauta");
        assertEquals("Flauta", b.getInstrumentoMusical());
        assertTrue(b.simularCombate().contains("resonar su Flauta"));
    }
}
