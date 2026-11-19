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
public class ClaseNivelTest {
    @Test
    void testCreacionGettersYSetters() {
        Guerrero guerreroInicial = new Guerrero("Pepe", 5, 40, true);
        ClaseNivel cn = new ClaseNivel(guerreroInicial, 5);

        assertEquals(guerreroInicial, cn.getClase());
        assertEquals(5, cn.getNivelesAsignados());
        assertEquals("Guerrero (Nv. 5)", cn.toString());

        Guerrero guerreroNuevo = new Guerrero("Pepe", 8, 40, false);
        cn.setClase(guerreroNuevo);
        cn.setNivelesAsignados(8);

        assertEquals(guerreroNuevo, cn.getClase());
        assertEquals(8, cn.getNivelesAsignados());
        assertEquals("Guerrero (Nv. 8)", cn.toString());
    }
    
}
