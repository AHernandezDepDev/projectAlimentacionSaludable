package Dominio;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE AlimentoTest
 * 21/11/2017
 */
public class AlimentoTest {

    Alimento alimentoJUnit;

    public AlimentoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        alimentoJUnit = new Alimento();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Alimento.
     */
    @Test
    public void testGetNombre() {

        String expResult = "Anana";
        alimentoJUnit.setNombre(expResult);
        String result = alimentoJUnit.getNombre();
        //Verificacion
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class Alimento.
     */
    @Test
    public void testGetTipo() {

        String expResult = "Fruta";
        alimentoJUnit.setTipo(expResult);
        String result = alimentoJUnit.getTipo();
        //Verificacion
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDeNutrientes method, of class Alimento.
     */
    @Test
    public void testGetListaDeNutrientes() {

        ArrayList<String> expResult = new ArrayList<String>();
        String nutrienteA = "Proteinas";
        String nutrienteB = "Minerales";
        String nutrienteC = "Hidratos de Carbono";
        expResult.add(nutrienteA);
        expResult.add(nutrienteB);
        expResult.add(nutrienteC);

        ArrayList<String> result = alimentoJUnit.getListaDeNutrientes();

        for (int i = 0; i < result.size(); i++) {
            //Verificacion
            assertEquals(expResult, result.get(i));
        }
    }

    /**
     * Test of getPorcion method, of class Alimento.
     */
    @Test
    public void testGetPorcion() {

        int expResult = 15;
        alimentoJUnit.setPorcion(expResult);
        int result = alimentoJUnit.getPorcion();
        //Verificacion
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Alimento.
     */
    @Test
    public void testSetNombre() {

        String nombre = "Durazno";
        //Verificacion
        alimentoJUnit.setNombre(nombre);
    }

    /**
     * Test of setTipo method, of class Alimento.
     */
    @Test
    public void testSetTipo() {

        String tipo = "Fruta";
        //Verificacion
        alimentoJUnit.setTipo(tipo);
    }

    /**
     * Test of setListaDeNutrientes method, of class Alimento.
     */
    @Test
    public void testSetListaDeNutrientes() {

        ArrayList<String> expResult = new ArrayList<String>();
        String nutrienteA = "Proteinas";
        String nutrienteB = "Minerales";
        String nutrienteC = "Hidratos de Carbono";
        expResult.add(nutrienteA);
        expResult.add(nutrienteB);
        expResult.add(nutrienteC);
        //Verificacion
        alimentoJUnit.setListaDeNutrientes(expResult);
    }

    /**
     * Test of setPorcion method, of class Alimento.
     */
    @Test
    public void testSetPorcion() {
        
        int porcion = 25;
        //Verificacion
        alimentoJUnit.setPorcion(porcion);
    }

}
