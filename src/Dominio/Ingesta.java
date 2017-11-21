
package Dominio;

import java.util.Date;


/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE Ingesta
 * 17/11/2017
 */

public class Ingesta {
    private Alimento alimentoIngerido;
    private Date fechaIngesta;

    public Alimento getAlimentoIngerido() {
        return alimentoIngerido;
    }

    public Date getFechaIngesta() {
        return fechaIngesta;
    }

    public void setAlimentoIngerido(Alimento alimentoIngerido) {
        this.alimentoIngerido = alimentoIngerido;
    }

    public void setFechaIngesta(Date fechaIngesta) {
        this.fechaIngesta = fechaIngesta;
    }
    
}
