package Dominio;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.Icon;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class Persona {

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private DateFormat fechaNacimiento;
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

    public DateFormat getFechaNacimiento() {
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

    public void setFechaNacimiento(DateFormat fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFotoPerfil(Icon fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

}
