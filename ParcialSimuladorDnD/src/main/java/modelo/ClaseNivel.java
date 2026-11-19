/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class ClaseNivel {
    private Aventurero clase;
    private int nivelesAsignados;

    public ClaseNivel(Aventurero clase, int nivelesAsignados) {
        this.clase = clase;
        this.nivelesAsignados = nivelesAsignados;
    }

    public Aventurero getClase() {
        return clase;
    }

    public void setClase(Aventurero clase) {
        this.clase = clase;
    }

    public int getNivelesAsignados() {
        return nivelesAsignados;
    }

    public void setNivelesAsignados(int nivelesAsignados) {
        this.nivelesAsignados = nivelesAsignados;
    }

    @Override
    public String toString() {
        String nombreClase = clase.getClass().getSimpleName();
        return nombreClase + " (Nv. " + nivelesAsignados + ")";
    }
}
