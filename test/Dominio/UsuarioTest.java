/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getNacionalidad method, of class Usuario.
     */
    @Test
    public void testGetNacionalidad() {
        System.out.println("getNacionalidad");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getNacionalidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPreferencias method, of class Usuario.
     */
    @Test
    public void testGetListaPreferencias() {
        System.out.println("getListaPreferencias");
        Usuario instance = new Usuario();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getListaPreferencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaRestricciones method, of class Usuario.
     */
    @Test
    public void testGetListaRestricciones() {
        System.out.println("getListaRestricciones");
        Usuario instance = new Usuario();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getListaRestricciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaAlimentosIngeridos method, of class Usuario.
     */
    @Test
    public void testGetListaAlimentosIngeridos() {
        System.out.println("getListaAlimentosIngeridos");
        Usuario instance = new Usuario();
        ArrayList<Ingesta> expResult = null;
        ArrayList<Ingesta> result = instance.getListaAlimentosIngeridos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsultasRealizadas method, of class Usuario.
     */
    @Test
    public void testGetListaConsultasRealizadas() {
        System.out.println("getListaConsultasRealizadas");
        Usuario instance = new Usuario();
        ArrayList<Consulta> expResult = null;
        ArrayList<Consulta> result = instance.getListaConsultasRealizadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPlanesDeAlimentacion method, of class Usuario.
     */
    @Test
    public void testGetListaPlanesDeAlimentacion() {
        System.out.println("getListaPlanesDeAlimentacion");
        Usuario instance = new Usuario();
        ArrayList<PlanAlimentacion> expResult = null;
        ArrayList<PlanAlimentacion> result = instance.getListaPlanesDeAlimentacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNacionalidad method, of class Usuario.
     */
    @Test
    public void testSetNacionalidad() {
        System.out.println("setNacionalidad");
        String nacionalidad = "";
        Usuario instance = new Usuario();
        instance.setNacionalidad(nacionalidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPreferencias method, of class Usuario.
     */
    @Test
    public void testSetListaPreferencias() {
        System.out.println("setListaPreferencias");
        ArrayList<String> listaPreferencias = null;
        Usuario instance = new Usuario();
        instance.setListaPreferencias(listaPreferencias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRestricciones method, of class Usuario.
     */
    @Test
    public void testSetListaRestricciones() {
        System.out.println("setListaRestricciones");
        ArrayList<String> listaRestricciones = null;
        Usuario instance = new Usuario();
        instance.setListaRestricciones(listaRestricciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaAlimentosIngeridos method, of class Usuario.
     */
    @Test
    public void testSetListaAlimentosIngeridos() {
        System.out.println("setListaAlimentosIngeridos");
        ArrayList<Ingesta> listaAlimentosIngeridos = null;
        Usuario instance = new Usuario();
        instance.setListaAlimentosIngeridos(listaAlimentosIngeridos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsultasRealizadas method, of class Usuario.
     */
    @Test
    public void testSetListaConsultasRealizadas() {
        System.out.println("setListaConsultasRealizadas");
        ArrayList<Consulta> listaConsultasRealizadas = null;
        Usuario instance = new Usuario();
        instance.setListaConsultasRealizadas(listaConsultasRealizadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPlanesDeAlimentacion method, of class Usuario.
     */
    @Test
    public void testSetListaPlanesDeAlimentacion() {
        System.out.println("setListaPlanesDeAlimentacion");
        ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = null;
        Usuario instance = new Usuario();
        instance.setListaPlanesDeAlimentacion(listaPlanesDeAlimentacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
