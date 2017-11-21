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
public class SistemaAlimentacionSaludableTest {
    
    public SistemaAlimentacionSaludableTest() {
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
     * Test of getListaUsuarios method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaUsuarios() {
        System.out.println("getListaUsuarios");
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = instance.getListaUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaProfesionales method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaProfesionales() {
        System.out.println("getListaProfesionales");
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        ArrayList<Profesional> expResult = null;
        ArrayList<Profesional> result = instance.getListaProfesionales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaAlimentos method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaAlimentos() {
        System.out.println("getListaAlimentos");
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        ArrayList<Alimento> expResult = null;
        ArrayList<Alimento> result = instance.getListaAlimentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConsultas method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaConsultas() {
        System.out.println("getListaConsultas");
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        ArrayList<Consulta> expResult = null;
        ArrayList<Consulta> result = instance.getListaConsultas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPlanesDeAlimentacion method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaPlanesDeAlimentacion() {
        System.out.println("getListaPlanesDeAlimentacion");
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        ArrayList<PlanAlimentacion> expResult = null;
        ArrayList<PlanAlimentacion> result = instance.getListaPlanesDeAlimentacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaUsuarios method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaUsuarios() {
        System.out.println("setListaUsuarios");
        ArrayList<Usuario> listaUsuarios = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.setListaUsuarios(listaUsuarios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProfesionales method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaProfesionales() {
        System.out.println("setListaProfesionales");
        ArrayList<Profesional> listaProfesionales = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.setListaProfesionales(listaProfesionales);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaAlimentos method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaAlimentos() {
        System.out.println("setListaAlimentos");
        ArrayList<Alimento> listaAlimentos = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.setListaAlimentos(listaAlimentos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaConsultas method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaConsultas() {
        System.out.println("setListaConsultas");
        ArrayList<Consulta> listaConsultas = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.setListaConsultas(listaConsultas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPlanesDeAlimentacion method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaPlanesDeAlimentacion() {
        System.out.println("setListaPlanesDeAlimentacion");
        ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.setListaPlanesDeAlimentacion(listaPlanesDeAlimentacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRegistroUsuario method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroUsuario() {
        System.out.println("agregarRegistroUsuario");
        Usuario nuevoUsuario = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.agregarRegistroUsuario(nuevoUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRegistroProfesional method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroProfesional() {
        System.out.println("agregarRegistroProfesional");
        Profesional nuevoProfesional = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.agregarRegistroProfesional(nuevoProfesional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRegistroAlimento method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroAlimento() {
        System.out.println("agregarRegistroAlimento");
        Alimento nuevoAlimento = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.agregarRegistroAlimento(nuevoAlimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRegistroConsulta method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroConsulta() {
        System.out.println("agregarRegistroConsulta");
        Consulta nuevaConsulta = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.agregarRegistroConsulta(nuevaConsulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRegistroPlanDeAlimentacion method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroPlanDeAlimentacion() {
        System.out.println("agregarRegistroPlanDeAlimentacion");
        PlanAlimentacion nuevoPlanDeAlimentacion = null;
        SistemaAlimentacionSaludable instance = new SistemaAlimentacionSaludable();
        instance.agregarRegistroPlanDeAlimentacion(nuevoPlanDeAlimentacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
