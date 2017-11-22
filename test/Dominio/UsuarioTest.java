package Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * CLASE UsuarioTest
 * 21/11/2017
 */
public class UsuarioTest extends PersonaTest {

    Usuario expUsuario;
    Ingesta expIngesta;
    Alimento expAlimento;
    Consulta expConsulta;
    CargaDeDatosTest cargaDeDatos;
    Profesional expProfesional;
    PlanAlimentacion expPlanAlimentacion;

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
        expUsuario = new Usuario();
        cargaDeDatos = new CargaDeDatosTest();
        expIngesta = new Ingesta();
        expAlimento = new Alimento();
        expConsulta = new Consulta();
        expProfesional = new Profesional();
        expPlanAlimentacion = new PlanAlimentacion();
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
        expUsuario.setPrimerNombre(expResult);

        String result = expUsuario.getPrimerNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegundoNombre method, of class Usuario.
     */
    @Test
    public void testGetSegundoNombre() {

        String expResult = "Pepe";
        expUsuario.setSegundoNombre(expResult);

        String result = expUsuario.getSegundoNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrimerApellido method, of class Usuario.
     */
    @Test
    public void testGetPrimerApellido() {

        String expResult = "Hernandez";
        expUsuario.setPrimerApellido(expResult);

        String result = expUsuario.getPrimerApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegundoApellido method, of class Usuario.
     */
    @Test
    public void testGetSegundoApellido() {

        String expResult = "Gonzalez";
        expUsuario.setSegundoApellido(expResult);

        String result = expUsuario.getSegundoApellido();
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

        expUsuario.setFechaNacimiento(fechaNacimiento);

        Date result = expUsuario.getFechaNacimiento();
        assertEquals(fechaNacimiento, result);
    }

    /**
     * Test of getFotoPerfil method, of class Usuario.
     */
    @Test
    public void testGetFotoPerfil() {

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        expUsuario.setFotoPerfil(noPerfil);

        Icon result = expUsuario.getFotoPerfil();
        assertEquals(noPerfil, result);
    }

    /**
     * Test of setPrimerNombre method, of class Usuario.
     */
    @Test
    public void testSetPrimerNombre() {

        String expResult = "Andre";

        expUsuario.setPrimerNombre(expResult);
    }

    /**
     * Test of setSegundoNombre method, of class Usuario.
     */
    @Test
    public void testSetSegundoNombre() {

        String expResult = "Pepe";

        expUsuario.setSegundoNombre(expResult);
    }

    /**
     * Test of setPrimerApellido method, of class Usuario.
     */
    @Test
    public void testSetPrimerApellido() {

        String expResult = "Hernandez";

        expUsuario.setPrimerApellido(expResult);
    }

    /**
     * Test of setSegundoApellido method, of class Usuario.
     */
    @Test
    public void testSetSegundoApellido() {

        String expResult = "Hernandez";

        expUsuario.setSegundoApellido(expResult);
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

        expUsuario.setFechaNacimiento(fechaNacimiento);
    }

    /**
     * Test of setFotoPerfil method, of class Usuario.
     */
    @Test
    public void testSetFotoPerfil() {

        ImageIcon noPerfil = new ImageIcon("src/Imagenes/noPerfilImagen.png");

        expUsuario.setFotoPerfil(noPerfil);
    }
    
    /**
     * Test of ingresarFotoPerfilDefecto method, of class Usuario.
     */
    @Test
    public void ingresarFotoPerfilDefecto() {

        expUsuario.ingresarFotoPerfilDefecto();
    }

    /**
     * Test of getNacionalidad method, of class Usuario.
     */
    @Test
    public void testGetNacionalidad() {

        String expResult = "Uruguaya";
        expUsuario.setNacionalidad(expResult);

        String result = expUsuario.getNacionalidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaPreferencias method, of class Usuario.
     */
    @Test
    public void testGetListaPreferencias() {

        ArrayList<String> listaPreferencias = new ArrayList<String>();
        String preferenciaA = "Frutas";
        String preferenciaB = "Pastas";
        listaPreferencias.add(preferenciaA);
        listaPreferencias.add(preferenciaB);
        expUsuario.setListaPreferencias(listaPreferencias);

        ArrayList<String> result = expUsuario.getListaPreferencias();
        assertEquals(listaPreferencias, result);
    }

    /**
     * Test of getListaRestricciones method, of class Usuario.
     */
    @Test
    public void testGetListaRestricciones() {

        ArrayList<String> listaRestricciones = new ArrayList<String>();
        String restriccionA = "Harina";
        String restriccionB = "Sal";
        listaRestricciones.add(restriccionA);
        listaRestricciones.add(restriccionB);
        expUsuario.setListaRestricciones(listaRestricciones);

        ArrayList<String> result = expUsuario.getListaRestricciones();
        assertEquals(listaRestricciones, result);
    }

    /**
     * Test of getListaAlimentosIngeridos method, of class Usuario.
     */
    @Test
    public void testGetListaAlimentosIngeridos() {

        expIngesta = cargaDeDatos.cargarIngesta(expIngesta, expAlimento);
        expUsuario.getListaAlimentosIngeridos().add(expIngesta);

        ArrayList<Ingesta> result = expUsuario.getListaAlimentosIngeridos();
        assertEquals(expUsuario.getListaAlimentosIngeridos(), result);
    }

    /**
     * Test of getListaConsultasRealizadas method, of class Usuario.
     */
    @Test
    public void testGetListaConsultasRealizadas() {

        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        expUsuario.getListaConsultasRealizadas().add(expConsulta);

        ArrayList<Consulta> result = expUsuario.getListaConsultasRealizadas();
        assertEquals(expUsuario.getListaConsultasRealizadas(), result);
    }

    /**
     * Test of getListaPlanesDeAlimentacion method, of class Usuario.
     */
    @Test
    public void testGetListaPlanesDeAlimentacion() {

        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);
        expUsuario.getListaPlanesDeAlimentacion().add(expPlanAlimentacion);

        ArrayList<PlanAlimentacion> result = expUsuario.getListaPlanesDeAlimentacion();
        assertEquals(expUsuario.getListaPlanesDeAlimentacion(), result);
    }

    /**
     * Test of setNacionalidad method, of class Usuario.
     */
    @Test
    public void testSetNacionalidad() {

        String expResult = "Uruguaya";

        expUsuario.setNacionalidad(expResult);
    }

    /**
     * Test of setListaPreferencias method, of class Usuario.
     */
    @Test
    public void testSetListaPreferencias() {

        ArrayList<String> listaPreferencias = new ArrayList<String>();
        String preferenciaA = "Frutas";
        String preferenciaB = "Pastas";
        listaPreferencias.add(preferenciaA);
        listaPreferencias.add(preferenciaB);
        expUsuario.setListaPreferencias(listaPreferencias);

    }

    /**
     * Test of setListaRestricciones method, of class Usuario.
     */
    @Test
    public void testSetListaRestricciones() {

        ArrayList<String> listaRestricciones = new ArrayList<String>();
        String restriccionA = "Harina";
        String restriccionB = "Sal";
        listaRestricciones.add(restriccionA);
        listaRestricciones.add(restriccionB);
        expUsuario.setListaRestricciones(listaRestricciones);
    }

    /**
     * Test of setListaAlimentosIngeridos method, of class Usuario.
     */
    @Test
    public void testSetListaAlimentosIngeridos() {

        expIngesta = cargaDeDatos.cargarIngesta(expIngesta, expAlimento);

        expUsuario.getListaAlimentosIngeridos().add(expIngesta);

    }

    /**
     * Test of setListaConsultasRealizadas method, of class Usuario.
     */
    @Test
    public void testSetListaConsultasRealizadas() {

        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);

        expUsuario.getListaConsultasRealizadas().add(expConsulta);
    }

    /**
     * Test of setListaPlanesDeAlimentacion method, of class Usuario.
     */
    @Test
    public void testSetListaPlanesDeAlimentacion() {

        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);

        expUsuario.getListaPlanesDeAlimentacion().add(expPlanAlimentacion);

    }

}
