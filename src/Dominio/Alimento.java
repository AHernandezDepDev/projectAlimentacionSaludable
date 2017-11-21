package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE Alimento
 * 17/11/2017
 */
public class Alimento {

    private String nombre;
    private String tipo;
    private ArrayList<String> listaDeNutrientes = new ArrayList<String>();
    private int porcion; 

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getListaDeNutrientes() {
        return listaDeNutrientes;
    }

    public int getPorcion() {
        return porcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setListaDeNutrientes(ArrayList<String> listaDeNutrientes) {
        this.listaDeNutrientes = listaDeNutrientes;
    }

    public void setPorcion(int porcion) {
        this.porcion = porcion;
    }

}
