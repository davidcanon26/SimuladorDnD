/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Picaro extends Aventurero {
    private boolean herramientasLadron;

    public Picaro(String nombre, int nivel, int puntosVida, boolean herramientasLadron) {
        super(nombre, nivel, puntosVida);
        this.herramientasLadron = herramientasLadron;
    }

    public boolean isHerramientasLadron() {
        return herramientasLadron;
    }
    public void setHerramientasLadron(boolean herramientasLadron) {
        this.herramientasLadron = herramientasLadron; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal ="Ataque de nivel " + nivel + ":El Pícaro " + nombre + " aprovecha la ventaja táctica para asestar un Ataque Furtivo masivo y se reposiciona.";
        String accionAtributo = herramientasLadron
            ? "Además, usa sus herramientas de ladrón para sabotear mecanismos o trampas cercanas durante su maniobra."
            : "Además, confía únicamente en su sigilo y reflejos para desaparecer de la línea de visión.";
        return accionPrincipal + " " + accionAtributo;
    }
}
