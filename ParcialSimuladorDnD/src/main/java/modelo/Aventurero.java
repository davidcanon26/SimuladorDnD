/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public abstract class Aventurero implements IAccionCombate {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected List<ClaseNivel> clases;
    public static final int MAX_CLASES = 4;

    public Aventurero(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.puntosVida = puntosVida;
        this.clases = new ArrayList<>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public List<ClaseNivel> getClases() {
        return clases;
    }

    public void setClases(List<ClaseNivel> clases) {
        this.clases = clases;
    }
    public int getCantidadClases() {
        return clases.size();
    }

    public int getNivelesRepartidos() {
        int suma = 0;
        for (ClaseNivel cn : clases) {
            suma += cn.getNivelesAsignados();
        }
        return suma;
    }
    public int getNivelesRestantes() {
        return nivel - getNivelesRepartidos();
    }

    public boolean tieneClase(Class<?> tipoClase) {
        for (ClaseNivel cn : clases) {
            if (cn.getClase().getClass().equals(tipoClase)) {
                return true;
            }
        }
        return false;
    }
    public boolean agregarClase(Aventurero instanciaClase, int nivelesEnClase) {
        if (instanciaClase == null || nivelesEnClase <= 0) return false;
        if (clases.size() >= MAX_CLASES) return false;
        if (nivelesEnClase > getNivelesRestantes()) return false;
        if (tieneClase(instanciaClase.getClass())) return false;

        clases.add(new ClaseNivel(instanciaClase, nivelesEnClase));
        return true;
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre)
          .append(" | Nivel total: ").append(nivel)
          .append(" (Repartidos: ").append(getNivelesRepartidos()).append("/").append(nivel).append(")")
          .append(" | PV: ").append(puntosVida)
          .append(" | Clases (").append(clases.size()).append("/").append(MAX_CLASES).append("): ");

        if (clases.isEmpty()) {
            sb.append("Ninguna");
        } else {
            for (int i = 0; i < clases.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(clases.get(i).toString());
            }
        }
        return sb.toString();
    }
}
