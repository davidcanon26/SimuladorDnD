/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import modelo.Aventurero;
/**
 *
 * @author Usuario
 */
public class GremioControlador {
    public static final int MAX_AVENTUREROS = 4;
    private static final String ARCHIVO_REGISTRO = "registro_gremio.txt";
    private final List<Aventurero> aventureros;

    public GremioControlador() {
        this.aventureros = new ArrayList<>();
    }

    public boolean puedeRegistrarMas() {
        return aventureros.size() < MAX_AVENTUREROS;
    }

    public int getCantidadAventureros() {
        return aventureros.size();
    }

    public boolean registrarAventurero(Aventurero aventurero) {
        if (!puedeRegistrarMas() || aventurero == null) {
            return false;
        }
        aventureros.add(aventurero);
        guardarEnArchivo("REGISTRO (" + aventureros.size() + "/" + MAX_AVENTUREROS + "): " + aventurero.toString());
        return true;
    }

    public List<Aventurero> getAventureros() {
        return aventureros;
    }

    public List<String> simularCombateGeneral() {
        List<String> resultados = new ArrayList<>();
        for (Aventurero a : aventureros) {
            String accion = a.simularCombate();
            resultados.add(accion);
            guardarEnArchivo("COMBATE: " + accion);
        }
        return resultados;
    }

    private void guardarEnArchivo(String linea) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO_REGISTRO, true))) {
            out.println(linea);
        } catch (IOException e) {
            System.err.println("Error al escribir en " + ARCHIVO_REGISTRO + ": " + e.getMessage());
        }
    }
}
