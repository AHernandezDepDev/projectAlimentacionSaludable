
package Dominio;

import java.util.Date;
import javax.swing.ImageIcon;

/*
 * @author Andre Hernandez ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- PROGRAMACION II
 */

public class Persona {
    
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private ImageIcon fotoPerfil;

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

    public ImageIcon getFotoPerfil() {
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

    public void setFotoPerfil(ImageIcon fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
 
}
