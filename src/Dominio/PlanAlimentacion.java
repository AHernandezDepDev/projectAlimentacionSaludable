package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class PlanAlimentacion {

    private Profesional planCreadoPorProfesional;
    private ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();

    public Profesional getPlanCreadoPorProfesional() {
        return planCreadoPorProfesional;
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setPlanCreadoPorProfesional(Profesional planCreadoPorProfesional) {
        this.planCreadoPorProfesional = planCreadoPorProfesional;
    }

    public void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

}
