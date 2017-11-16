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
    private String listaConsejosLunes;
    private String listaConsejosMartes;
    private String listaConsejosMiercoles;
    private String listaConsejosJueves;
    private String listaConsejosViernes;
    private String listaConsejosSabado;
    private String listaConsejosDomingo;

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

    public String getListaConsejosLunes() {
        return listaConsejosLunes;
    }

    public String getListaConsejosMartes() {
        return listaConsejosMartes;
    }

    public String getListaConsejosMiercoles() {
        return listaConsejosMiercoles;
    }

    public String getListaConsejosJueves() {
        return listaConsejosJueves;
    }

    public String getListaConsejosViernes() {
        return listaConsejosViernes;
    }

    public String getListaConsejosSabado() {
        return listaConsejosSabado;
    }

    public String getListaConsejosDomingo() {
        return listaConsejosDomingo;
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

    public void setListaConsejosLunes(String listaConsejosLunes) {
        this.listaConsejosLunes = listaConsejosLunes;
    }

    public void setListaConsejosMartes(String listaConsejosMartes) {
        this.listaConsejosMartes = listaConsejosMartes;
    }

    public void setListaConsejosMiercoles(String listaConsejosMiercoles) {
        this.listaConsejosMiercoles = listaConsejosMiercoles;
    }

    public void setListaConsejosJueves(String listaConsejosJueves) {
        this.listaConsejosJueves = listaConsejosJueves;
    }

    public void setListaConsejosViernes(String listaConsejosViernes) {
        this.listaConsejosViernes = listaConsejosViernes;
    }

    public void setListaConsejosSabado(String listaConsejosSabado) {
        this.listaConsejosSabado = listaConsejosSabado;
    }

    public void setListaConsejosDomingo(String listaConsejosDomingo) {
        this.listaConsejosDomingo = listaConsejosDomingo;
    }
   
    
}
