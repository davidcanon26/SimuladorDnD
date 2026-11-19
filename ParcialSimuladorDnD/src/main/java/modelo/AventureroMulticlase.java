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
        return RANDOM.nextInt(20) + 1; 
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
            Aventurero instanciaClase = cn.getClase();
            int nivelDeClase = cn.getNivelesAsignados();

            sb.append("  • [Ataque de nivel ").append(nivelDeClase)
              .append(" - ").append(instanciaClase.getClass().getSimpleName()).append("] ");

            if (d20 == 1) {
                sb.append("¡Fallo crítico! El ataque de nivel ").append(nivelDeClase)
                  .append(" de ").append(nombre).append(" falla y no surte efecto.");
            } else if (d20 == 20) {
                sb.append("¡GOLPE CRÍTICO (Ataque de nivel ").append(nivelDeClase).append(")! ")
                  .append(instanciaClase.simularCombate())
                  .append(" (¡Daño crítico maximizado!)");
            } else {
                sb.append(instanciaClase.simularCombate());
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
