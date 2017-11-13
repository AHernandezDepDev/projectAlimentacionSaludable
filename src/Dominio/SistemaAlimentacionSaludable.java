package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class SistemaAlimentacionSaludable {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private ArrayList<Profesional> listaProfesionales = new ArrayList<Profesional>();
    private ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();
    private ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();

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

}
