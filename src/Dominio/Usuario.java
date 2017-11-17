package Dominio;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class Usuario extends Persona {

    private String nacionalidad;
    private ArrayList<String> listaPreferencias = new ArrayList<String>();
    private ArrayList<String> listaRestricciones = new ArrayList<String>();
    private ArrayList<Ingesta> listaAlimentosIngeridos = new ArrayList<Ingesta>();
    private ArrayList<Consulta> listaConsultasRealizadas = new ArrayList<Consulta>();
    private ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = new ArrayList<PlanAlimentacion>();

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
