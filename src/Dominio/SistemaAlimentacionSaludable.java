package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE SistemaAlimentacionSaludable
 * 17/11/2017
 */
public class SistemaAlimentacionSaludable {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Profesional> listaProfesionales = new ArrayList<>();
    private ArrayList<Alimento> listaAlimentos = new ArrayList<>();
    private ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = new ArrayList<>();

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<Profesional> getListaProfesionales() {
        return listaProfesionales;
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public ArrayList<PlanAlimentacion> getListaPlanesDeAlimentacion() {
        return listaPlanesDeAlimentacion;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaProfesionales(ArrayList<Profesional> listaProfesionales) {
        this.listaProfesionales = listaProfesionales;
    }

    public void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public void setListaPlanesDeAlimentacion(ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion) {
        this.listaPlanesDeAlimentacion = listaPlanesDeAlimentacion;
    }

    //*************************************************************************//
    public void agregarRegistroUsuario(Usuario nuevoUsuario) {
        this.listaUsuarios.add(nuevoUsuario);
    }

    public void agregarRegistroProfesional(Profesional nuevoProfesional) {
        this.listaProfesionales.add(nuevoProfesional);
    }

    public void agregarRegistroAlimento(Alimento nuevoAlimento) {
        this.listaAlimentos.add(nuevoAlimento);
    }

    public void agregarRegistroConsulta(Consulta nuevaConsulta) {
        this.listaConsultas.add(nuevaConsulta);
    }

    public void agregarRegistroPlanDeAlimentacion(PlanAlimentacion nuevoPlanDeAlimentacion) {
        this.listaPlanesDeAlimentacion.add(nuevoPlanDeAlimentacion);
    }

    
}
