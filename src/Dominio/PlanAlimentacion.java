package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class PlanAlimentacion {

    private int idPlanAlimentacion = 1;
    private Profesional planCreadoPorProfesional;
    private Usuario solicitante;
    private String observaciones;
    private ArrayList<Alimento> listaAlimentosLunes = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosMartes = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosMiercoles = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosJueves = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosViernes = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosSabado = new ArrayList<Alimento>();
    private ArrayList<Alimento> listaAlimentosDomingo = new ArrayList<Alimento>();

    public int getIdPlanAlimentacion() {
        return idPlanAlimentacion;
    }

    public Profesional getPlanCreadoPorProfesional() {
        return planCreadoPorProfesional;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public ArrayList<Alimento> getListaAlimentosLunes() {
        return listaAlimentosLunes;
    }

    public ArrayList<Alimento> getListaAlimentosMartes() {
        return listaAlimentosMartes;
    }

    public ArrayList<Alimento> getListaAlimentosMiercoles() {
        return listaAlimentosMiercoles;
    }

    public ArrayList<Alimento> getListaAlimentosJueves() {
        return listaAlimentosJueves;
    }

    public ArrayList<Alimento> getListaAlimentosViernes() {
        return listaAlimentosViernes;
    }

    public ArrayList<Alimento> getListaAlimentosSabado() {
        return listaAlimentosSabado;
    }

    public ArrayList<Alimento> getListaAlimentosDomingo() {
        return listaAlimentosDomingo;
    }

    public void setIdPlanAlimentacion(int idPlanAlimentacion) {
        this.idPlanAlimentacion = idPlanAlimentacion;
    }

    public void setPlanCreadoPorProfesional(Profesional planCreadoPorProfesional) {
        this.planCreadoPorProfesional = planCreadoPorProfesional;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setListaAlimentosLunes(ArrayList<Alimento> listaAlimentosLunes) {
        this.listaAlimentosLunes = listaAlimentosLunes;
    }

    public void setListaAlimentosMartes(ArrayList<Alimento> listaAlimentosMartes) {
        this.listaAlimentosMartes = listaAlimentosMartes;
    }

    public void setListaAlimentosMiercoles(ArrayList<Alimento> listaAlimentosMiercoles) {
        this.listaAlimentosMiercoles = listaAlimentosMiercoles;
    }

    public void setListaAlimentosJueves(ArrayList<Alimento> listaAlimentosJueves) {
        this.listaAlimentosJueves = listaAlimentosJueves;
    }

    public void setListaAlimentosViernes(ArrayList<Alimento> listaAlimentosViernes) {
        this.listaAlimentosViernes = listaAlimentosViernes;
    }

    public void setListaAlimentosSabado(ArrayList<Alimento> listaAlimentosSabado) {
        this.listaAlimentosSabado = listaAlimentosSabado;
    }

    public void setListaAlimentosDomingo(ArrayList<Alimento> listaAlimentosDomingo) {
        this.listaAlimentosDomingo = listaAlimentosDomingo;
    }
    
}
