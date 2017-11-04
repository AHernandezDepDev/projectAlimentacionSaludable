package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class SistemaAlimentacionSaludable {

    private ArrayList<String> listaUsuarios = new ArrayList<String>();
    private ArrayList<String> listaProfesionales = new ArrayList<String>();
    private ArrayList<String> listaAlimentos = new ArrayList<String>();

    public ArrayList<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<String> getListaProfesionales() {
        return listaProfesionales;
    }

    public ArrayList<String> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaUsuarios(ArrayList<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaProfesionales(ArrayList<String> listaProfesionales) {
        this.listaProfesionales = listaProfesionales;
    }

    public void setListaAlimentos(ArrayList<String> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

}
