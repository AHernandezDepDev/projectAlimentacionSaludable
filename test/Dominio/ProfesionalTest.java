package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
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
 * CLASE ProfesionalTest
 * 21/11/2017
 */
public class ProfesionalTest extends PersonaTest{

    Profesional expProfesional;

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
        expProfesional = new Profesional();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPrimerNombre method, of class Usuario.
     */
    @Test
    public void testGetPrimerNombre() {

        String expResult = "Andre";
        expProfesional.setPrimerNombre(expResult);

        String result = expProfesional.getPrimerNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegundoNombre method, of class Usuario.
     */
    @Test
    public void testGetSegundoNombre() {

        String expResult = "Pepe";
        expProfesional.setSegundoNombre(expResult);

        String result = expProfesional.getSegundoNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrimerApellido method, of class Usuario.
     */
    @Test
    public void testGetPrimerApellido() {

        String expResult = "Hernandez";
        expProfesional.setPrimerApellido(expResult);

        String result = expProfesional.getPrimerApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegundoApellido method, of class Usuario.
     */
    @Test
    public void testGetSegundoApellido() {

        String expResult = "Gonzalez";
        expProfesional.setSegundoApellido(expResult);

        String result = expProfesional.getSegundoApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaNacimiento method, of class Usuario.
     */
    @Test
    public void testGetFechaNacimiento() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaNacimientoStr = "20-Jun-1989";
        Date fechaNacimiento = null;

        try {
            fechaNacimiento = formatter.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expProfesional.setFechaNacimiento(fechaNacimiento);

        Date result = expProfesional.getFechaNacimiento();
        assertEquals(fechaNacimiento, result);
    }

    /**
     * Test of getFotoPerfil method, of class Usuario.
     */
    @Test
    public void testGetFotoPerfil() {

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        expProfesional.setFotoPerfil(noPerfil);

        Icon result = expProfesional.getFotoPerfil();
        assertEquals(noPerfil, result);
    }

    /**
     * Test of setPrimerNombre method, of class Usuario.
     */
    @Test
    public void testSetPrimerNombre() {

        String expResult = "Andre";

        expProfesional.setPrimerNombre(expResult);
    }

    /**
     * Test of setSegundoNombre method, of class Usuario.
     */
    @Test
    public void testSetSegundoNombre() {

        String expResult = "Pepe";

        expProfesional.setSegundoNombre(expResult);
    }

    /**
     * Test of setPrimerApellido method, of class Usuario.
     */
    @Test
    public void testSetPrimerApellido() {

        String expResult = "Hernandez";

        expProfesional.setPrimerApellido(expResult);
    }

    /**
     * Test of setSegundoApellido method, of class Usuario.
     */
    @Test
    public void testSetSegundoApellido() {

        String expResult = "Hernandez";

        expProfesional.setSegundoApellido(expResult);
    }

    /**
     * Test of setFechaNacimiento method, of class Usuario.
     */
    @Test
    public void testSetFechaNacimiento() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaNacimientoStr = "20-Jun-1989";
        Date fechaNacimiento = null;

        try {
            fechaNacimiento = formatter.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expProfesional.setFechaNacimiento(fechaNacimiento);
    }

    /**
     * Test of setFotoPerfil method, of class Usuario.
     */
    @Test
    public void testSetFotoPerfil() {

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");

        expProfesional.setFotoPerfil(noPerfil);
    }
    
    /**
     * Test of ingresarFotoPerfilDefecto method, of class Usuario.
     */
    @Test
    public void ingresarFotoPerfilDefecto() {

        expProfesional.ingresarFotoPerfilDefecto();
    }
    
    /**
     * Test of getNombreTituloProfesional method, of class Profesional.
     */
    @Test
    public void testGetNombreTituloProfesional() {

        String expResult = "Licenciado en Nutricion";
        expProfesional.setNombreTituloProfesional(expResult);

        String result = expProfesional.getNombreTituloProfesional();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaGraduacion method, of class Profesional.
     */
    @Test
    public void testGetFechaGraduacion() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaGraduacionStr = "20-Jun-2017";
        Date fechaGraduacion = null;

        try {
            fechaGraduacion = formatter.parse(fechaGraduacionStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expProfesional.setFechaGraduacion(fechaGraduacion);

        Date result = expProfesional.getFechaGraduacion();
        assertEquals(fechaGraduacion, result);
    }

    /**
     * Test of getPaisObtuvoTitulo method, of class Profesional.
     */
    @Test
    public void testGetPaisObtuvoTitulo() {

        String expResult = "Uruguay";
        expProfesional.setPaisObtuvoTitulo(expResult);

        String result = expProfesional.getPaisObtuvoTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreTituloProfesional method, of class Profesional.
     */
    @Test
    public void testSetNombreTituloProfesional() {

        String expResult = "Licenciado en Nutricion";

        expProfesional.setNombreTituloProfesional(expResult);
    }

    /**
     * Test of setFechaGraduacion method, of class Profesional.
     */
    @Test
    public void testSetFechaGraduacion() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaGraduacionStr = "20-Jun-2017";
        Date fechaGraduacion = null;

        try {
            fechaGraduacion = formatter.parse(fechaGraduacionStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        expProfesional.setFechaGraduacion(fechaGraduacion);
    }

    /**
     * Test of setPaisObtuvoTitulo method, of class Profesional.
     */
    @Test
    public void testSetPaisObtuvoTitulo() {

        String expResult = "Uruguay";

        expProfesional.setPaisObtuvoTitulo(expResult);
    }

}
