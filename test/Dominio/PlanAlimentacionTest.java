package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE PlanAlimentacionTest
 * 21/11/2017
 */
public class PlanAlimentacionTest {

    PlanAlimentacion expResultPlanAlimentacion;
    CargaDeDatosTest cargaDeDatos;
    Profesional expProfesional;
    Usuario expUsuario;
    Consulta expConsulta;
    Ingesta expIngesta;
    Alimento expAlimento;

    public PlanAlimentacionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        expResultPlanAlimentacion = new PlanAlimentacion();
        cargaDeDatos = new CargaDeDatosTest();
        expProfesional = new Profesional();
        expUsuario = new Usuario();
        expConsulta = new Consulta();
        expIngesta = new Ingesta();
        expAlimento = new Alimento();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdPlanAlimentacion method, of class PlanAlimentacion.
     */
    @Test
    public void testGetIdPlanAlimentacion() {

        int expResult = 5;
        expResultPlanAlimentacion.setIdPlanAlimentacion(expResult);

        int result = expResultPlanAlimentacion.getIdPlanAlimentacion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlanCreadoPorProfesional method, of class PlanAlimentacion.
     */
    @Test
    public void testGetPlanCreadoPorProfesional() {

        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        expResultPlanAlimentacion.setPlanCreadoPorProfesional(expProfesional);

        Profesional result = expResultPlanAlimentacion.getPlanCreadoPorProfesional();
        assertEquals(expProfesional, result);
    }

    /**
     * Test of getSolicitante method, of class PlanAlimentacion.
     */
    @Test
    public void testGetSolicitante() {

        expUsuario = cargaDeDatos.cargarUsuario(expUsuario,
                expResultPlanAlimentacion, expConsulta);
        expResultPlanAlimentacion.setSolicitante(expUsuario);

        Usuario result = expResultPlanAlimentacion.getSolicitante();
        assertEquals(expUsuario, result);
    }

    /**
     * Test of getObservaciones method, of class PlanAlimentacion.
     */
    @Test
    public void testGetObservaciones() {

        String expResult = "Me gustaria un plan de alimentacion en base a comidas frias";
        expResultPlanAlimentacion.setObservaciones(expResult);

        String result = expResultPlanAlimentacion.getObservaciones();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaConsejosLunes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosLunes() {

        String consejoLunes = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosLunes(consejoLunes);

        String result = expResultPlanAlimentacion.getListaConsejosLunes();
        assertEquals(consejoLunes, result);
    }

    /**
     * Test of getListaConsejosMartes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosMartes() {

        String consejoMartes = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosMartes(consejoMartes);

        String result = expResultPlanAlimentacion.getListaConsejosMartes();
        assertEquals(consejoMartes, result);
    }

    /**
     * Test of getListaConsejosMiercoles method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosMiercoles() {

        String consejoMiercoles = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosMiercoles(consejoMiercoles);

        String result = expResultPlanAlimentacion.getListaConsejosMiercoles();
        assertEquals(consejoMiercoles, result);
    }

    /**
     * Test of getListaConsejosJueves method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosJueves() {

        String consejoJueves = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosJueves(consejoJueves);

        String result = expResultPlanAlimentacion.getListaConsejosJueves();
        assertEquals(consejoJueves, result);
    }

    /**
     * Test of getListaConsejosViernes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosViernes() {

        String consejoViernes = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosViernes(consejoViernes);

        String result = expResultPlanAlimentacion.getListaConsejosViernes();
        assertEquals(consejoViernes, result);
    }

    /**
     * Test of getListaConsejosSabado method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosSabado() {

        String consejoSabado = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosSabado(consejoSabado);

        String result = expResultPlanAlimentacion.getListaConsejosSabado();
        assertEquals(consejoSabado, result);
    }

    /**
     * Test of getListaConsejosDomingo method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosDomingo() {

        String consejoDomingo = "10 gramos de pan con mermelada";
        expResultPlanAlimentacion.setListaConsejosDomingo(consejoDomingo);

        String result = expResultPlanAlimentacion.getListaConsejosDomingo();
        assertEquals(consejoDomingo, result);
    }

    /**
     * Test of getFechaDesdeVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testGetFechaDesdeVigencia() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaDesdeVigenciaStr = "20-Jun-2017";
        Date fechaDesdeVigencia = null;

        try {
            fechaDesdeVigencia = formatter.parse(fechaDesdeVigenciaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultPlanAlimentacion.setFechaDesdeVigencia(fechaDesdeVigencia);

        Date result = expResultPlanAlimentacion.getFechaDesdeVigencia();
        assertEquals(fechaDesdeVigencia, result);
    }

    /**
     * Test of getFechaHastaVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testGetFechaHastaVigencia() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaHastaVigenciaStr = "20-Jun-2017";
        Date fechaHastaVigencia = null;

        try {
            fechaHastaVigencia = formatter.parse(fechaHastaVigenciaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultPlanAlimentacion.setFechaHastaVigencia(fechaHastaVigencia);

        Date result = expResultPlanAlimentacion.getFechaHastaVigencia();
        assertEquals(fechaHastaVigencia, result);
    }

    /**
     * Test of setIdPlanAlimentacion method, of class PlanAlimentacion.
     */
    @Test
    public void testSetIdPlanAlimentacion() {

        int idPlanAlimentacion = 9;
        expResultPlanAlimentacion.setIdPlanAlimentacion(idPlanAlimentacion);

        expResultPlanAlimentacion.setIdPlanAlimentacion(idPlanAlimentacion);
    }

    /**
     * Test of setPlanCreadoPorProfesional method, of class PlanAlimentacion.
     */
    @Test
    public void testSetPlanCreadoPorProfesional() {

        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);

        expResultPlanAlimentacion.setPlanCreadoPorProfesional(expProfesional);
    }

    /**
     * Test of setSolicitante method, of class PlanAlimentacion.
     */
    @Test
    public void testSetSolicitante() {

        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expResultPlanAlimentacion, expConsulta);
        expResultPlanAlimentacion.setSolicitante(expUsuario);
    }

    /**
     * Test of setObservaciones method, of class PlanAlimentacion.
     */
    @Test
    public void testSetObservaciones() {

        String observaciones = "Plan de alimentacion en base a lacteos";
        expResultPlanAlimentacion.setObservaciones(observaciones);
    }

    /**
     * Test of setListaConsejosLunes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosLunes() {

        String consejoLunes = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosLunes(consejoLunes);
    }

    /**
     * Test of setListaConsejosMartes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosMartes() {

        String consejoMartes = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosMartes(consejoMartes);
    }

    /**
     * Test of setListaConsejosMiercoles method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosMiercoles() {

        String consejoMiercoles = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosMiercoles(consejoMiercoles);
    }

    /**
     * Test of setListaConsejosJueves method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosJueves() {

        String consejoJueves = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosJueves(consejoJueves);
    }

    /**
     * Test of setListaConsejosViernes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosViernes() {

        String consejoViernes = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosViernes(consejoViernes);
    }

    /**
     * Test of setListaConsejosSabado method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosSabado() {

        String consejoSabado = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosSabado(consejoSabado);
    }

    /**
     * Test of setListaConsejosDomingo method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosDomingo() {

        String consejoDomingo = "10 gramos de pan con mermelada";

        expResultPlanAlimentacion.setListaConsejosDomingo(consejoDomingo);
    }

    /**
     * Test of setFechaDesdeVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testSetFechaDesdeVigencia() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaDesdeVigenciaStr = "20-Jun-2017";
        Date fechaDesdeVigencia = null;

        try {
            fechaDesdeVigencia = formatter.parse(fechaDesdeVigenciaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultPlanAlimentacion.setFechaDesdeVigencia(fechaDesdeVigencia);
    }

    /**
     * Test of setFechaHastaVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testSetFechaHastaVigencia() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaHastaVigenciaStr = "20-Jun-2017";
        Date fechaHastaVigencia = null;

        try {
            fechaHastaVigencia = formatter.parse(fechaHastaVigenciaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expResultPlanAlimentacion.setFechaHastaVigencia(fechaHastaVigencia);
    }

    /**
     * Test of stringPorDefectoDiasPlanAlimentacion method, of class
     * PlanAlimentacion.
     */
    @Test
    public void testStringPorDefectoDiasPlanAlimentacion() {
        String stringDefecto = "Sin sugerencia de plan de alimentacion";
        expResultPlanAlimentacion.stringPorDefectoDiasPlanAlimentacion();
    }

}
