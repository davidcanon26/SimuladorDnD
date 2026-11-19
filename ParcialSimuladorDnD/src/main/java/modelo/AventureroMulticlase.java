/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class AventureroMulticlase extends Aventurero {
    public AventureroMulticlase(String nombre, int nivel, int puntosVida) {
        super(nombre, nivel, puntosVida);
    }

    @Override
    public String simularCombate() {
        if (clases.isEmpty()) {
            return nombre + " aún no tiene clases asignadas para combatir.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(nombre).append(" (Nv. total ").append(nivel)
          .append(" | PV: ").append(puntosVida).append(") ===\n");
        for (ClaseNivel cn : clases) {
            sb.append("  • [").append(cn.toString()).append("] ")
              .append(cn.getClase().simularCombate()).append("\n");
        }
        return sb.toString().trim();
    }
}
