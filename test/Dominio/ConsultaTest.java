package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE ConsultaTest
 * 21/11/2017
 */
public class ConsultaTest {

    Consulta consultaJUnit;
    Profesional expResultProfesional;
    Alimento expResultAlimento;
    Usuario expResultUsuario;
    PlanAlimentacion expResultPlanAlimentacion;
    Ingesta expResultIngesta;
    CargaDeDatosTest cargaDeDatos;

    public ConsultaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        consultaJUnit = new Consulta();
        expResultProfesional = new Profesional();
        expResultAlimento = new Alimento();
        expResultUsuario = new Usuario();
        expResultIngesta = new Ingesta();
        cargaDeDatos = new CargaDeDatosTest();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getProfesionalRespondeConsulta method, of class Consulta.
     */
    @Test
    public void testGetProfesionalRespondeConsulta() {

        expResultProfesional = cargaDeDatos.cargarPorfesional(expResultProfesional);
        consultaJUnit.setProfesionalRespondeConsulta(expResultProfesional);
        
        Profesional result = consultaJUnit.getProfesionalRespondeConsulta();
        assertEquals(expResultProfesional, result);
    }

    /**
     * Test of getAlimentoConsultado method, of class Consulta.
     */
    @Test
    public void testGetAlimentoConsultado() {

        expResultAlimento = cargaDeDatos.cargarAlimento(expResultAlimento);
        consultaJUnit.setAlimentoConsultado(expResultAlimento);

        Alimento result = consultaJUnit.getAlimentoConsultado();
        assertEquals(expResultAlimento, result);
    }

    /**
     * Test of getTitularConsulta method, of class Consulta.
     */
    @Test
    public void testGetTitularConsulta() {

        String titularConsulta = "Ayuda con perdidad de Peso";
        consultaJUnit.setTitularConsulta(titularConsulta);

        String result = consultaJUnit.getTitularConsulta();
        assertEquals(titularConsulta, result);
    }

    /**
     * Test of getDescripcionConsulta method, of class Consulta.
     */
    @Test
    public void testGetDescripcionConsulta() {
        String descripcionConsulta = "Quiero saber sobre propiedades de la Manzana";
        consultaJUnit.setDescripcionConsulta(descripcionConsulta);

        String result = consultaJUnit.getDescripcionConsulta();
        assertEquals(descripcionConsulta, result);
    }

    /**
     * Test of getRespuestaConsulta method, of class Consulta.
     */
    @Test
    public void testGetRespuestaConsulta() {
        String respuestaConsulta = "Las propiedades son: Perder peso, saludable, fresca";
        consultaJUnit.setRespuestaConsulta(respuestaConsulta);

        String result = consultaJUnit.getRespuestaConsulta();
        assertEquals(respuestaConsulta, result);
    }

    /**
     * Test of getSolcitante method, of class Consulta.
     */
    @Test
    public void testGetSolcitante() {
        
        expResultUsuario = cargaDeDatos.cargarUsuario(expResultUsuario, 
                expResultPlanAlimentacion, consultaJUnit);
        
        consultaJUnit.setSolcitante(expResultUsuario);
        
        Usuario result = consultaJUnit.getSolcitante();
        assertEquals(expResultUsuario, result);
    }

    /**
     * Test of getIdConsulta method, of class Consulta.
     */
    @Test
    public void testGetIdConsulta() {

        int expResult = 1;
        consultaJUnit.setIdConsulta(expResult);

        int result = consultaJUnit.getIdConsulta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProfesionalRespondeConsulta method, of class Consulta.
     */
    @Test
    public void testSetProfesionalRespondeConsulta() {
        
        expResultProfesional = cargaDeDatos.cargarPorfesional(expResultProfesional);
        
        consultaJUnit.setProfesionalRespondeConsulta(expResultProfesional);
    }

    /**
     * Test of setAlimentoConsultado method, of class Consulta.
     */
    @Test
    public void testSetAlimentoConsultado() {
        
        expResultAlimento = cargaDeDatos.cargarAlimento(expResultAlimento);
        
        consultaJUnit.setAlimentoConsultado(expResultAlimento);
    }

    /**
     * Test of setTitularConsulta method, of class Consulta.
     */
    @Test
    public void testSetTitularConsulta() {
        String titularConsulta = "Ayuda con perdidad de Peso";
        consultaJUnit.setTitularConsulta(titularConsulta);
    }

    /**
     * Test of setDescripcionConsulta method, of class Consulta.
     */
    @Test
    public void testSetDescripcionConsulta() {
        String descripcionConsulta = "Quiero saber sobre propiedades de la Manzana";
        consultaJUnit.setDescripcionConsulta(descripcionConsulta);
    }

    /**
     * Test of setRespuestaConsulta method, of class Consulta.
     */
    @Test
    public void testSetRespuestaConsulta() {
        String respuestaConsulta = "Las propiedades son: Perder peso, saludable, fresca";
        consultaJUnit.setRespuestaConsulta(respuestaConsulta);
    }

    /**
     * Test of setSolcitante method, of class Consulta.
     */
    @Test
    public void testSetSolcitante() {
       
        expResultUsuario = cargaDeDatos.cargarUsuario(expResultUsuario, 
                expResultPlanAlimentacion, consultaJUnit);
        
        consultaJUnit.setSolcitante(expResultUsuario);
    }

    /**
     * Test of setIdConsulta method, of class Consulta.
     */
    @Test
    public void testSetIdConsulta() {
        int expResult = 1;
        consultaJUnit.setIdConsulta(expResult);

    }

}
