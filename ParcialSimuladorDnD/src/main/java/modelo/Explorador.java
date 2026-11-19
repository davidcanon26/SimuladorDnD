/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Explorador extends Aventurero {
    private String terrenoFavorecido;

    public Explorador(String nombre, int nivel, int puntosVida, String terrenoFavorecido) {
        super(nombre, nivel, puntosVida);
        this.terrenoFavorecido = terrenoFavorecido;
    }

    public String getTerrenoFavorecido() {
        return terrenoFavorecido;
    }
    public void setTerrenoFavorecido(String terrenoFavorecido) {
        this.terrenoFavorecido = terrenoFavorecido; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "El Explorador " + nombre + " aplica Marca del Cazador sobre el objetivo para maximizar su daño sostenido.";
        String accionAtributo = "Además, domina el entorno de " + terrenoFavorecido + " para rastrear al enemigo y colocarse en posición ventajosa.";
        return accionPrincipal + " " + accionAtributo;
    }
}
