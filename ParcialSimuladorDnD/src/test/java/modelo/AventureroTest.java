/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Usuario
 */
public class AventureroTest {
   
    private static class AventureroPrueba extends Aventurero {
        AventureroPrueba(String nombre, int nivel, int puntosVida) {
            super(nombre, nivel, puntosVida);
        }
    }

    @Test
    void testGettersSettersYEstadoInicial() {
        AventureroPrueba av = new AventureroPrueba("Aria", 10, 55);

        assertEquals("Aria", av.getNombre());
        assertEquals(10, av.getNivel());
        assertEquals(55, av.getPuntosVida());
        assertEquals(0, av.getCantidadClases());
        assertEquals(0, av.getNivelesRepartidos());
        assertEquals(10, av.getNivelesRestantes());
        assertTrue(av.getClases().isEmpty());
        assertEquals("Aria aún no tiene clases asignadas para combatir.", av.simularCombate());

        av.setNombre("Aria Vane");
        av.setNivel(12);
        av.setPuntosVida(70);

        assertEquals("Aria Vane", av.getNombre());
        assertEquals(12, av.getNivel());
        assertEquals(70, av.getPuntosVida());
    }

    @Test
    void testAgregarClaseYValidacionesDeNivelesYLimite() {
        AventureroPrueba av = new AventureroPrueba("Pepe", 10, 60);

        assertFalse(av.agregarClase(null, 2));
        assertFalse(av.agregarClase(new Guerrero("Pepe", 0, 60, true), 0));
        assertFalse(av.agregarClase(new Guerrero("Pepe", -1, 60, true), -2));
        assertFalse(av.agregarClase(new Guerrero("Pepe", 11, 60, true), 11));
        assertTrue(av.agregarClase(new Guerrero("Pepe", 5, 60, true), 5));
        assertEquals(1, av.getCantidadClases());
        assertEquals(5, av.getNivelesRepartidos());
        assertEquals(5, av.getNivelesRestantes());
        assertTrue(av.tieneClase(Guerrero.class));
        assertFalse(av.tieneClase(Mago.class));

        assertFalse(av.agregarClase(new Guerrero("Pepe", 2, 60, false), 2));

        assertFalse(av.agregarClase(new Mago("Pepe", 6, 60, 2), 6));

        assertTrue(av.agregarClase(new Mago("Pepe", 2, 60, 2), 2));
        assertTrue(av.agregarClase(new Clerigo("Pepe", 2, 60, "Pelor"), 2));
        assertTrue(av.agregarClase(new Picaro("Pepe", 1, 60, true), 1));

        assertEquals(Aventurero.MAX_CLASES, av.getCantidadClases());
        assertEquals(10, av.getNivelesRepartidos());
        assertEquals(0, av.getNivelesRestantes());

        assertFalse(av.agregarClase(new Bardo("Pepe", 1, 60, "Laúd"), 1));
    }

    @Test
    void testSimularCombateYToStringConClases() {
        AventureroPrueba av = new AventureroPrueba("Pepe", 10, 60);
        av.agregarClase(new Guerrero("Pepe", 7, 60, true), 7);
        av.agregarClase(new Mago("Pepe", 3, 60, 2), 3);

        String combate = av.simularCombate();
        assertTrue(combate.contains("=== Pepe (Nv. total 10 | PV: 60) ==="));
        assertTrue(combate.contains("[Guerrero (Nv. 7)]"));
        assertTrue(combate.contains("Ataque de nivel 7"));
        assertTrue(combate.contains("[Mago (Nv. 3)]"));
        assertTrue(combate.contains("Ataque de nivel 3"));

        String texto = av.toString();
        assertTrue(texto.contains("Nombre: Pepe"));
        assertTrue(texto.contains("Nivel total: 10"));
        assertTrue(texto.contains("(Repartidos: 10/10)"));
        assertTrue(texto.contains("PV: 60"));
        assertTrue(texto.contains("Clases (2/4): Guerrero (Nv. 7), Mago (Nv. 3)"));

        List<ClaseNivel> listaVacia = new ArrayList<>();
        av.setClases(listaVacia);
        assertEquals(0, av.getCantidadClases());
        assertTrue(av.toString().endsWith("Clases (0/4): Ninguna"));
    }
}
