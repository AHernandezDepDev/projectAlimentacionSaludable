package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE Usuario
 * 17/11/2017
 */
public class Usuario extends Persona {

    private String nacionalidad;
    private ArrayList<String> listaPreferencias = new ArrayList<>();
    private ArrayList<String> listaRestricciones = new ArrayList<>();
    private ArrayList<Ingesta> listaAlimentosIngeridos = new ArrayList<>();
    private ArrayList<Consulta> listaConsultasRealizadas = new ArrayList<>();
    private ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = new ArrayList<>();

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<String> getListaPreferencias() {
        return listaPreferencias;
    }

    public ArrayList<String> getListaRestricciones() {
        return listaRestricciones;
    }

    public ArrayList<Ingesta> getListaAlimentosIngeridos() {
        return listaAlimentosIngeridos;
    }

    public ArrayList<Consulta> getListaConsultasRealizadas() {
        return listaConsultasRealizadas;
    }

    public ArrayList<PlanAlimentacion> getListaPlanesDeAlimentacion() {
        return listaPlanesDeAlimentacion;
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

    public void setListaAlimentosIngeridos(ArrayList<Ingesta> listaAlimentosIngeridos) {
        this.listaAlimentosIngeridos = listaAlimentosIngeridos;
    }

    public void setListaConsultasRealizadas(ArrayList<Consulta> listaConsultasRealizadas) {
        this.listaConsultasRealizadas = listaConsultasRealizadas;
    }

    public void setListaPlanesDeAlimentacion(ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion) {
        this.listaPlanesDeAlimentacion = listaPlanesDeAlimentacion;
    }

}
