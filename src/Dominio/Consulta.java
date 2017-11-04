package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class Consulta {

    private Profesional profesionalRespondeConsulta;
    private Alimento alimentoConsultado;
    private ArrayList<String> listaVentajas = new ArrayList<String>();
    private ArrayList<String> listaDesventajas = new ArrayList<String>();

    public Profesional getProfesionalRespondeConsulta() {
        return profesionalRespondeConsulta;
    }

    public Alimento getAlimentoConsultado() {
        return alimentoConsultado;
    }

    public ArrayList<String> getListaVentajas() {
        return listaVentajas;
    }

    public ArrayList<String> getListaDesventajas() {
        return listaDesventajas;
    }

    public void setProfesionalRespondeConsulta(Profesional profesionalRespondeConsulta) {
        this.profesionalRespondeConsulta = profesionalRespondeConsulta;
    }

    public void setAlimentoConsultado(Alimento alimentoConsultado) {
        this.alimentoConsultado = alimentoConsultado;
    }

    public void setListaVentajas(ArrayList<String> listaVentajas) {
        this.listaVentajas = listaVentajas;
    }

    public void setListaDesventajas(ArrayList<String> listaDesventajas) {
        this.listaDesventajas = listaDesventajas;
    }

}
