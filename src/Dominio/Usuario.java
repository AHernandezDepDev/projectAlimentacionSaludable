
package Dominio;

import java.util.ArrayList;

/*
 * @author Andre Hernandez ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- PROGRAMACION II
 */

public class Usuario extends Persona{
    
    private String nacionalidad;
    private ArrayList<String> listaPreferencias = new ArrayList<String>();
    private ArrayList<String> listaRestricciones = new ArrayList<String>();

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<String> getListaPreferencias() {
        return listaPreferencias;
    }

    public ArrayList<String> getListaRestricciones() {
        return listaRestricciones;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setListaPreferencias(ArrayList<String> listaPreferencias) {
        this.listaPreferencias = listaPreferencias;
    }

    public void setListaRestricciones(ArrayList<String> listaRestricciones) {
        this.listaRestricciones = listaRestricciones;
    }
    
}
