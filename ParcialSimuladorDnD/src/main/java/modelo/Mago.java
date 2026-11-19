/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Mago extends Aventurero {
    private int espaciosConjuro;

    public Mago(String nombre, int nivel, int puntosVida, int espaciosConjuro) {
        super(nombre, nivel, puntosVida);
        this.espaciosConjuro = espaciosConjuro;
    }

    public int getEspaciosConjuro() {
        return espaciosConjuro;
    }
    public void setEspaciosConjuro(int espaciosConjuro) {
        this.espaciosConjuro = espaciosConjuro; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "Ataque de nivel " + nivel + ": El Mago " + nombre
        + " gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.";
    String accionAtributo = espaciosConjuro > 0
        ? "Además, canaliza sus espacios de conjuro restantes (" + espaciosConjuro + ") para sostener un escudo arcano defensivo."
        : "Sin embargo, al no tener espacios de conjuro disponibles, solo puede recurrir a trucos menores de emergencia.";
    return accionPrincipal + " " + accionAtributo;
    }
}
