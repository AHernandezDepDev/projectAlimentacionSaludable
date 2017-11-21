
package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE CargaDeDatosTest
 * 21/11/2017
 */

public class CargaDeDatosTest {
    
     public PlanAlimentacion cargarPlanDeAlimentacion(PlanAlimentacion expResultPlanAlimentacion,
             Consulta consultaJUnit) {
         
        expResultPlanAlimentacion = new PlanAlimentacion();

        expResultPlanAlimentacion.setSolicitante(consultaJUnit.getSolcitante());
        expResultPlanAlimentacion.setPlanCreadoPorProfesional(consultaJUnit.getProfesionalRespondeConsulta());
        expResultPlanAlimentacion.setObservaciones("Ninguna");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaVigenciaDesdeStr = "20-Nov-2017";
        String fechaVigenciaHastaStr = "27-Nov-2017";
        Date fechaVigenciaDesde = null;
        Date fechaVigenciaHasta = null;

        try {
            fechaVigenciaDesde = formatter.parse(fechaVigenciaDesdeStr);
            fechaVigenciaHasta = formatter.parse(fechaVigenciaHastaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultPlanAlimentacion.setFechaDesdeVigencia(fechaVigenciaDesde);
        expResultPlanAlimentacion.setFechaHastaVigencia(fechaVigenciaHasta);

        expResultPlanAlimentacion.setIdPlanAlimentacion(1);
        expResultPlanAlimentacion.setListaConsejosLunes("Consejo Lunes");
        expResultPlanAlimentacion.setListaConsejosMartes("Consejo Martes");
        expResultPlanAlimentacion.setListaConsejosMiercoles("Consejo Miercoles");
        expResultPlanAlimentacion.setListaConsejosJueves("Consejo Jueves");
        expResultPlanAlimentacion.setListaConsejosViernes("Consejo Viernes");
        expResultPlanAlimentacion.setListaConsejosSabado("Consejo Sabado");
        expResultPlanAlimentacion.setListaConsejosDomingo("Consejo Domingo");

        return expResultPlanAlimentacion;
    }

    public Ingesta cargarIngesta(Ingesta expResultIngesta, Alimento expResultAlimento) {
        
        expResultIngesta.setAlimentoIngerido(expResultAlimento);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaIngestaStr = "20-Nov-2017";
        Date fechaIngesta = null;

        try {
            fechaIngesta = formatter.parse(fechaIngestaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultIngesta.setFechaIngesta(fechaIngesta);

        return expResultIngesta;
    }

    public Usuario cargarUsuario(Usuario expResultUsuario, PlanAlimentacion expResultPlanAlimentacion,
             Consulta consultaJUnit, Alimento expResultAlimento, Ingesta expResultIngesta) {

        ArrayList<String> listaPreferencias = new ArrayList<String>();
        ArrayList<String> listaRestricciones = new ArrayList<String>();
        ArrayList<PlanAlimentacion> listaPlanAlimentacion = new ArrayList<PlanAlimentacion>();
        ArrayList<Ingesta> listaIngesta = new ArrayList<Ingesta>();
        ArrayList<Consulta> listaConsulta = new ArrayList<Consulta>();

        String preferenciaA = "Frutas";
        String preferenciaB = "Pastas";
        listaPreferencias.add(preferenciaA);
        listaPreferencias.add(preferenciaB);

        String restriccionA = "Harina";
        String restriccionB = "Sal";
        listaRestricciones.add(restriccionA);
        listaRestricciones.add(restriccionB);

        expResultUsuario.setPrimerNombre("Andre");
        expResultUsuario.setSegundoNombre("Pepe");
        expResultUsuario.setPrimerApellido("Hernandez");
        expResultUsuario.setSegundoApellido("Valbuena");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaNacimientoStr = "7-Jun-1978";
        Date fechaNacimiento = null;

        try {
            fechaNacimiento = formatter.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultUsuario.setFechaNacimiento(fechaNacimiento);

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        expResultUsuario.setFotoPerfil(noPerfil);

        expResultUsuario.setListaPreferencias(listaPreferencias);
        expResultUsuario.setListaRestricciones(listaRestricciones);
        
          listaPlanAlimentacion.add(cargarPlanDeAlimentacion(expResultPlanAlimentacion,
             consultaJUnit));
        listaIngesta.add(cargarIngesta(expResultIngesta, expResultAlimento));
        listaConsulta.add(consultaJUnit);
        
        expResultUsuario.setListaAlimentosIngeridos(listaIngesta);
        expResultUsuario.setListaPlanesDeAlimentacion(listaPlanAlimentacion);
        expResultUsuario.setListaConsultasRealizadas(listaConsulta);

        return expResultUsuario;
    }

    public Profesional cargarPorfesional(Profesional expResultProfesional) {

        expResultProfesional.setPrimerNombre("Andre");
        expResultProfesional.setSegundoNombre("Pepe");
        expResultProfesional.setPrimerApellido("Hernandez");
        expResultProfesional.setSegundoApellido("Valbuena");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaNacimientoStr = "7-Jun-1978";
        String fechaTituloStr = "17-Jun-2013";
        Date fechaNacimiento = null;
        Date fechaObtuvoTitulo = null;

        try {
            fechaNacimiento = formatter.parse(fechaNacimientoStr);
            fechaObtuvoTitulo = formatter.parse(fechaTituloStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultProfesional.setFechaNacimiento(fechaNacimiento);

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        expResultProfesional.setFotoPerfil(noPerfil);

        expResultProfesional.setNombreTituloProfesional("Licenciado en Nutricion");
        expResultProfesional.setFechaGraduacion(fechaObtuvoTitulo);
        expResultProfesional.setPaisObtuvoTitulo("Uruguay");

        return expResultProfesional;
    }

    public Alimento cargarAlimento(Alimento expResultAlimento) {

        ArrayList<String> listaNutrientes = new ArrayList<String>();
        String nutrienteA = "Azucar";
        String nutrienteB = "Minerales";
        listaNutrientes.add(nutrienteA);
        listaNutrientes.add(nutrienteB);

        expResultAlimento.setNombre("Manzana");
        expResultAlimento.setTipo("Fruta");
        expResultAlimento.setPorcion(25);
        expResultAlimento.setListaDeNutrientes(listaNutrientes);

        return expResultAlimento;
    }

}
