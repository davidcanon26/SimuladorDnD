/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Bardo extends Aventurero {
    private String instrumentoMusical;

    public Bardo(String nombre, int nivel, int puntosVida, String instrumentoMusical) {
        super(nombre, nivel, puntosVida);
        this.instrumentoMusical = instrumentoMusical;
    }

    public String getInstrumentoMusical() { 
        return instrumentoMusical;
    }
    public void setInstrumentoMusical(String instrumentoMusical) {
        this.instrumentoMusical = instrumentoMusical; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "El Bardo " + nombre + " toca su instrumento para otorgar Inspiración Bárdica a un aliado.";
        String accionAtributo = "Además, hace resonar su " + instrumentoMusical + " con una melodía que eleva la moral del equipo en pleno combate.";
        return accionPrincipal + " " + accionAtributo;
    }
}
