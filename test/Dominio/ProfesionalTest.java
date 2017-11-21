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
public class ProfesionalTest {
    
    public ProfesionalTest() {
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
     * Test of getNombreTituloProfesional method, of class Profesional.
     */
    @Test
    public void testGetNombreTituloProfesional() {
        System.out.println("getNombreTituloProfesional");
        Profesional instance = new Profesional();
        String expResult = "";
        String result = instance.getNombreTituloProfesional();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaGraduacion method, of class Profesional.
     */
    @Test
    public void testGetFechaGraduacion() {
        System.out.println("getFechaGraduacion");
        Profesional instance = new Profesional();
        Date expResult = null;
        Date result = instance.getFechaGraduacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaisObtuvoTitulo method, of class Profesional.
     */
    @Test
    public void testGetPaisObtuvoTitulo() {
        System.out.println("getPaisObtuvoTitulo");
        Profesional instance = new Profesional();
        String expResult = "";
        String result = instance.getPaisObtuvoTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreTituloProfesional method, of class Profesional.
     */
    @Test
    public void testSetNombreTituloProfesional() {
        System.out.println("setNombreTituloProfesional");
        String nombreTituloProfesional = "";
        Profesional instance = new Profesional();
        instance.setNombreTituloProfesional(nombreTituloProfesional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaGraduacion method, of class Profesional.
     */
    @Test
    public void testSetFechaGraduacion() {
        System.out.println("setFechaGraduacion");
        Date fechaGraduacion = null;
        Profesional instance = new Profesional();
        instance.setFechaGraduacion(fechaGraduacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaisObtuvoTitulo method, of class Profesional.
     */
    @Test
    public void testSetPaisObtuvoTitulo() {
        System.out.println("setPaisObtuvoTitulo");
        String paisObtuvoTitulo = "";
        Profesional instance = new Profesional();
        instance.setPaisObtuvoTitulo(paisObtuvoTitulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
