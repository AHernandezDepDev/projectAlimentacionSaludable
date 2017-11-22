
package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * CLASE IngestaTest
 * 21/11/2017
 */

public class IngestaTest {
    
    Ingesta expResultIngesta;
    Alimento expResultAlimento;
    CargaDeDatosTest cargaDeDatos;
    
    public IngestaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expResultIngesta = new Ingesta();
        expResultAlimento = new Alimento();
        cargaDeDatos = new CargaDeDatosTest();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAlimentoIngerido method, of class Ingesta.
     */
    @Test
    public void testGetAlimentoIngerido() {
        
        expResultAlimento = cargaDeDatos.cargarAlimento(expResultAlimento);
        expResultIngesta.setAlimentoIngerido(expResultAlimento);
        
        Alimento result = expResultIngesta.getAlimentoIngerido();
        assertEquals(expResultAlimento, result);
    }

    /**
     * Test of getFechaIngesta method, of class Ingesta.
     */
    @Test
    public void testGetFechaIngesta() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaIngestaStr = "20-Jun-2017";
        Date fechaIngesta = null;

        try {
            fechaIngesta = formatter.parse(fechaIngestaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        expResultIngesta.setFechaIngesta(fechaIngesta);

        Date result = expResultIngesta.getFechaIngesta();
        assertEquals(fechaIngesta, result);
    }

    /**
     * Test of setAlimentoIngerido method, of class Ingesta.
     */
    @Test
    public void testSetAlimentoIngerido() {
        
        expResultAlimento = cargaDeDatos.cargarAlimento(expResultAlimento);
        
        expResultIngesta.setAlimentoIngerido(expResultAlimento);
    }

    /**
     * Test of setFechaIngesta method, of class Ingesta.
     */
    @Test
    public void testSetFechaIngesta() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaIngestaStr = "20-Jun-2017";
        Date fechaIngesta = null;

        try {
            fechaIngesta = formatter.parse(fechaIngestaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        expResultIngesta.setFechaIngesta(fechaIngesta);
    }
    
}
