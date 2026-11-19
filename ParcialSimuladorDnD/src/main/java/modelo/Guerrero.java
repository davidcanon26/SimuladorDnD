/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Guerrero extends Aventurero {
    private boolean usaArmaduraPesada;

    public Guerrero(String nombre, int nivel, int puntosVida, boolean usaArmaduraPesada) {
        super(nombre, nivel, puntosVida);
        this.usaArmaduraPesada = usaArmaduraPesada;
    }

    public boolean isUsaArmaduraPesada() {
        return usaArmaduraPesada; 
    }
    public void setUsaArmaduraPesada(boolean usaArmaduraPesada) {
        this.usaArmaduraPesada = usaArmaduraPesada; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "Ataque de nivel " + nivel + ": El Guerrero " + nombre
        + " usa Oleada de Acción para realizar múltiples ataques físicos continuos.";
    String accionAtributo = usaArmaduraPesada
        ? "Además, su armadura pesada absorbe el impacto frontal y le permite embestir sin perder el equilibrio."
        : "Además, al no llevar armadura pesada, se mueve con mayor agilidad para encadenar su siguiente golpe.";
    return accionPrincipal + " " + accionAtributo;
    }
}
