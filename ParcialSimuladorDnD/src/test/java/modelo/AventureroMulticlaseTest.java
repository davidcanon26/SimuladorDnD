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
public class AventureroMulticlaseTest {
    @Test
    void testTirarD20EnRangoValido() {
        AventureroMulticlase pj = new AventureroMulticlase("Kael", 12, 80);

        for (int i = 0; i < 200; i++) {
            int tirada = pj.tirarD20();
            assertTrue(tirada >= 1 && tirada <= 20, "La tirada d20 debe estar entre 1 y 20, fue: " + tirada);
        }
    }

    @Test
    void testSimularCombateConD20SinClases() {
        AventureroMulticlase pj = new AventureroMulticlase("Kael", 5, 40);
        String resultado = pj.simularCombateConD20(12);

        assertTrue(resultado.contains("d20: 12 -> Ataque normal"));
        assertTrue(resultado.contains("Aún no tiene clases asignadas para combatir."));
    }

    @Test
    void testSimularCombateConD20FalloCriticoNormalYCritico() {
        AventureroMulticlase pj = new AventureroMulticlase("Pepe", 10, 65);
        pj.agregarClase(new Guerrero("Pepe", 7, 65, true), 7);
        pj.agregarClase(new Mago("Pepe", 3, 65, 2), 3);

        String fallo = pj.simularCombateConD20(1);
        assertTrue(fallo.contains("d20: 1 -> ¡1 NATURAL! FALLO"));
        assertTrue(fallo.contains("[Ataque de nivel 7 - Guerrero] ¡Fallo crítico! El ataque de nivel 7 de Pepe falla y no surte efecto."));
        assertTrue(fallo.contains("[Ataque de nivel 3 - Mago] ¡Fallo crítico! El ataque de nivel 3 de Pepe falla y no surte efecto."));


        String normal = pj.simularCombateConD20(14);
        assertTrue(normal.contains("d20: 14 -> Ataque normal"));
        assertTrue(normal.contains("[Ataque de nivel 7 - Guerrero] Ataque de nivel 7: El Guerrero Pepe"));
        assertTrue(normal.contains("[Ataque de nivel 3 - Mago] Ataque de nivel 3: El Mago Pepe"));
        assertFalse(normal.contains("¡GOLPE CRÍTICO"));

 
        String critico = pj.simularCombateConD20(20);
        assertTrue(critico.contains("d20: 20 -> ¡20 NATURAL! GOLPE CRÍTICO"));
        assertTrue(critico.contains("¡GOLPE CRÍTICO (Ataque de nivel 7)!"));
        assertTrue(critico.contains("¡GOLPE CRÍTICO (Ataque de nivel 3)!"));
        assertTrue(critico.contains("(¡Daño crítico maximizado!)"));
    }

    @Test
    void testSimularCombateAleatorioGeneraEncabezadoValido() {
        AventureroMulticlase pj = new AventureroMulticlase("Lyra", 6, 48);
        pj.agregarClase(new Clerigo("Lyra", 6, 48, "Bahamut"), 6);

        String salida = pj.simularCombate();
        assertTrue(salida.startsWith("=== Lyra (Nv. total 6 | PV: 48 | d20: "));
        assertTrue(salida.contains("[Ataque de nivel 6 - Clerigo]"));
    }
}
