package Dominio;

import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE Persona
 * 17/11/2017
 */
public abstract class Persona {

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Icon fotoPerfil;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Icon getFotoPerfil() {
        return fotoPerfil;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFotoPerfil(Icon fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    //Setear FOTO DE PERFIL por DEFECTO
    public void ingresarFotoPerfilDefecto() {
        this.setFotoPerfil(new ImageIcon(getClass().getResource("/Imagenes/noPerfilImagen.png")));
    }

}
