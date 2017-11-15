
package Dominio;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */

public class Ingesta {
    private Alimento alimentoIngerido;
    private String diaIngesta;
    

    public Alimento getAlimentoIngerido() {
        return alimentoIngerido;
    }

    public String getDiaIngesta() {
        return diaIngesta;
    }

    public void setAlimentoIngerido(Alimento alimentoIngerido) {
        this.alimentoIngerido = alimentoIngerido;
    }

    public void setDiaIngesta(String diaIngesta) {
        this.diaIngesta = diaIngesta;
    }
    
}
