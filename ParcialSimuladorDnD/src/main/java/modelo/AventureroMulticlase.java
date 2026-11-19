/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Random;
/**
 *
 * @author Usuario
 */
public class AventureroMulticlase extends Aventurero {
    private static final Random RANDOM = new Random();
    public AventureroMulticlase(String nombre, int nivel, int puntosVida) {
        super(nombre, nivel, puntosVida);
    }

    public int tirarD20() {
        return RANDOM.nextInt(20) + 1; // 1 a 20
    }

    public String simularCombateConD20(int d20) {
        String estadoTirada;
        if (d20 == 20) {
            estadoTirada = "¡20 NATURAL! GOLPE CRÍTICO";
        } else if (d20 == 1) {
            estadoTirada = "¡1 NATURAL! FALLO";
        } else {
            estadoTirada = "Ataque normal";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(nombre)
          .append(" (Nv. total ").append(nivel)
          .append(" | PV: ").append(puntosVida)
          .append(" | d20: ").append(d20)
          .append(" -> ").append(estadoTirada).append(") ===\n");

        if (clases.isEmpty()) {
            sb.append("  • Aún no tiene clases asignadas para combatir.");
            return sb.toString();
        }

        for (ClaseNivel cn : clases) {
            sb.append("  • [").append(cn.toString()).append("] ");
            if (d20 == 1) {
                sb.append("¡Fallo crítico! ").append(nombre)
                  .append(" tropieza o falla su maniobra con ").append(cn.getClase().getClass().getSimpleName())
                  .append(" y el ataque no conecta.");
            } else if (d20 == 20) {
                sb.append("¡GOLPE CRÍTICO! ").append(cn.getClase().simularCombate())
                  .append(" (¡Potencia y daño crítico maximizados!)");
            } else {
                sb.append(cn.getClase().simularCombate());
            }
            sb.append("\n");
        }

        return sb.toString().trim();
    }

    @Override
    public String simularCombate() {
        return simularCombateConD20(tirarD20());
    }
}
