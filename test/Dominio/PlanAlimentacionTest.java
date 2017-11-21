/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PlanAlimentacionTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdPlanAlimentacion method, of class PlanAlimentacion.
     */
    @Test
    public void testGetIdPlanAlimentacion() {
        System.out.println("getIdPlanAlimentacion");
        PlanAlimentacion instance = new PlanAlimentacion();
        int expResult = 0;
        int result = instance.getIdPlanAlimentacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlanCreadoPorProfesional method, of class PlanAlimentacion.
     */
    @Test
    public void testGetPlanCreadoPorProfesional() {
        System.out.println("getPlanCreadoPorProfesional");
        PlanAlimentacion instance = new PlanAlimentacion();
        Profesional expResult = null;
        Profesional result = instance.getPlanCreadoPorProfesional();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSolicitante method, of class PlanAlimentacion.
     */
    @Test
    public void testGetSolicitante() {
        System.out.println("getSolicitante");
        PlanAlimentacion instance = new PlanAlimentacion();
        Usuario expResult = null;
        Usuario result = instance.getSolicitante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservaciones method, of class PlanAlimentacion.
     */
    @Test
    public void testGetObservaciones() {
        System.out.println("getObservaciones");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getObservaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosLunes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosLunes() {
        System.out.println("getListaConsejosLunes");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosLunes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosMartes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosMartes() {
        System.out.println("getListaConsejosMartes");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosMartes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosMiercoles method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosMiercoles() {
        System.out.println("getListaConsejosMiercoles");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosMiercoles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosJueves method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosJueves() {
        System.out.println("getListaConsejosJueves");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosJueves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosViernes method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosViernes() {
        System.out.println("getListaConsejosViernes");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosViernes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosSabado method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosSabado() {
        System.out.println("getListaConsejosSabado");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosSabado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsejosDomingo method, of class PlanAlimentacion.
     */
    @Test
    public void testGetListaConsejosDomingo() {
        System.out.println("getListaConsejosDomingo");
        PlanAlimentacion instance = new PlanAlimentacion();
        String expResult = "";
        String result = instance.getListaConsejosDomingo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaDesdeVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testGetFechaDesdeVigencia() {
        System.out.println("getFechaDesdeVigencia");
        PlanAlimentacion instance = new PlanAlimentacion();
        Date expResult = null;
        Date result = instance.getFechaDesdeVigencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaHastaVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testGetFechaHastaVigencia() {
        System.out.println("getFechaHastaVigencia");
        PlanAlimentacion instance = new PlanAlimentacion();
        Date expResult = null;
        Date result = instance.getFechaHastaVigencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPlanAlimentacion method, of class PlanAlimentacion.
     */
    @Test
    public void testSetIdPlanAlimentacion() {
        System.out.println("setIdPlanAlimentacion");
        int idPlanAlimentacion = 0;
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setIdPlanAlimentacion(idPlanAlimentacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlanCreadoPorProfesional method, of class PlanAlimentacion.
     */
    @Test
    public void testSetPlanCreadoPorProfesional() {
        System.out.println("setPlanCreadoPorProfesional");
        Profesional planCreadoPorProfesional = null;
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setPlanCreadoPorProfesional(planCreadoPorProfesional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSolicitante method, of class PlanAlimentacion.
     */
    @Test
    public void testSetSolicitante() {
        System.out.println("setSolicitante");
        Usuario solicitante = null;
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setSolicitante(solicitante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservaciones method, of class PlanAlimentacion.
     */
    @Test
    public void testSetObservaciones() {
        System.out.println("setObservaciones");
        String observaciones = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setObservaciones(observaciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosLunes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosLunes() {
        System.out.println("setListaConsejosLunes");
        String listaConsejosLunes = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosLunes(listaConsejosLunes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosMartes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosMartes() {
        System.out.println("setListaConsejosMartes");
        String listaConsejosMartes = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosMartes(listaConsejosMartes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosMiercoles method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosMiercoles() {
        System.out.println("setListaConsejosMiercoles");
        String listaConsejosMiercoles = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosMiercoles(listaConsejosMiercoles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosJueves method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosJueves() {
        System.out.println("setListaConsejosJueves");
        String listaConsejosJueves = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosJueves(listaConsejosJueves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosViernes method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosViernes() {
        System.out.println("setListaConsejosViernes");
        String listaConsejosViernes = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosViernes(listaConsejosViernes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosSabado method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosSabado() {
        System.out.println("setListaConsejosSabado");
        String listaConsejosSabado = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosSabado(listaConsejosSabado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsejosDomingo method, of class PlanAlimentacion.
     */
    @Test
    public void testSetListaConsejosDomingo() {
        System.out.println("setListaConsejosDomingo");
        String listaConsejosDomingo = "";
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setListaConsejosDomingo(listaConsejosDomingo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaDesdeVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testSetFechaDesdeVigencia() {
        System.out.println("setFechaDesdeVigencia");
        Date fechaDesdeVigencia = null;
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setFechaDesdeVigencia(fechaDesdeVigencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaHastaVigencia method, of class PlanAlimentacion.
     */
    @Test
    public void testSetFechaHastaVigencia() {
        System.out.println("setFechaHastaVigencia");
        Date fechaHastaVigencia = null;
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.setFechaHastaVigencia(fechaHastaVigencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringPorDefectoDiasPlanAlimentacion method, of class PlanAlimentacion.
     */
    @Test
    public void testStringPorDefectoDiasPlanAlimentacion() {
        System.out.println("stringPorDefectoDiasPlanAlimentacion");
        PlanAlimentacion instance = new PlanAlimentacion();
        instance.stringPorDefectoDiasPlanAlimentacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
