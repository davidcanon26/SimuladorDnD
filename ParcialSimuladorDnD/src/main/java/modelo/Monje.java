/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Monje extends Aventurero {
    private int puntosKi;

    public Monje(String nombre, int nivel, int puntosVida, int puntosKi) {
        super(nombre, nivel, puntosVida);
        this.puntosKi = puntosKi;
    }

    public int getPuntosKi() {
        return puntosKi; 
    }
    public void setPuntosKi(int puntosKi) { 
        this.puntosKi = puntosKi;
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "El Monje " + nombre + " gasta puntos de Ki para ejecutar una Ráfaga de Golpes y un Ataque Aturdidor.";
        String accionAtributo = puntosKi > 0
            ? "Además, concentra su reserva de Ki (" + puntosKi + " pts) para evadir ataques con Paso del Viento."
            : "Sin embargo, ha agotado su Ki y debe regular su respiración antes de volver a canalizarlo.";
        return accionPrincipal + " " + accionAtributo;
    }
}
