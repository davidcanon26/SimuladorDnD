/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Clerigo extends Aventurero {
    private String diosVenerado;

    public Clerigo(String nombre, int nivel, int puntosVida, String diosVenerado) {
        super(nombre, nivel, puntosVida);
        this.diosVenerado = diosVenerado;
    }

    public String getDiosVenerado() {
        return diosVenerado; 
    }
    public void setDiosVenerado(String diosVenerado) {
        this.diosVenerado = diosVenerado; 
    }

    @Override
    public String simularCombate() {
        String accionPrincipal = "El Clérigo " + nombre + " usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.";
        String accionAtributo = "Además, invoca la bendición de " + diosVenerado + " para reforzar la fe del grupo y purificar el campo de batalla.";
        return accionPrincipal + " " + accionAtributo;
    }
}
