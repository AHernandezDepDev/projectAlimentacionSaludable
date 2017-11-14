package Dominio;

import java.util.ArrayList;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class Consulta {

    private Profesional profesionalRespondeConsulta;
    private Alimento alimentoConsultado;
    private String titularConsulta;
    private String descripcionConsulta;
    private String respuestaConsulta;
    private int idConsulta = 1;

    public Profesional getProfesionalRespondeConsulta() {
        return profesionalRespondeConsulta;
    }

    public Alimento getAlimentoConsultado() {
        return alimentoConsultado;
    }

    public String getTitularConsulta() {
        return titularConsulta;
    }

    public String getDescripcionConsulta() {
        return descripcionConsulta;
    }

    public String getRespuestaConsulta() {
        return respuestaConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setProfesionalRespondeConsulta(Profesional profesionalRespondeConsulta) {
        this.profesionalRespondeConsulta = profesionalRespondeConsulta;
    }

    public void setAlimentoConsultado(Alimento alimentoConsultado) {
        this.alimentoConsultado = alimentoConsultado;
    }

    public void setTitularConsulta(String titularConsulta) {
        this.titularConsulta = titularConsulta;
    }

    public void setDescripcionConsulta(String descripcionConsulta) {
        this.descripcionConsulta = descripcionConsulta;
    }

    public void setRespuestaConsulta(String respuestaConsulta) {
        this.respuestaConsulta = respuestaConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

}
