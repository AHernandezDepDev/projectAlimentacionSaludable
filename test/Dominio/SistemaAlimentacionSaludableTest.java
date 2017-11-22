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
 * CLASE SistemaAlimentacionSaludableTest
 * 21/11/2017
 */
public class SistemaAlimentacionSaludableTest {

    SistemaAlimentacionSaludable expSistema;
    Usuario expUsuario;
    Profesional expProfesional;
    Alimento expAlimento;
    Consulta expConsulta;
    PlanAlimentacion expAlimentacion;
    CargaDeDatosTest cargaDeDatos;

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
        expSistema = new SistemaAlimentacionSaludable();
        expUsuario = new Usuario();
        expProfesional = new Profesional();
        expAlimento = new Alimento();
        expConsulta = new Consulta();
        expAlimentacion = new PlanAlimentacion();
        cargaDeDatos = new CargaDeDatosTest();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaUsuarios method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaUsuarios() {

        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expAlimentacion,
                expConsulta);

        expSistema.getListaUsuarios().add(expUsuario);

        ArrayList<Usuario> result = expSistema.getListaUsuarios();
        assertEquals(expSistema.getListaUsuarios(), result);
    }

    /**
     * Test of getListaProfesionales method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaProfesionales() {

        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);

        expSistema.getListaProfesionales().add(expProfesional);

        ArrayList<Profesional> result = expSistema.getListaProfesionales();
        assertEquals(expSistema.getListaProfesionales(), result);
    }

    /**
     * Test of getListaAlimentos method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaAlimentos() {

        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);

        expSistema.getListaAlimentos().add(expAlimento);

        ArrayList<Alimento> result = expSistema.getListaAlimentos();
        assertEquals(expSistema.getListaAlimentos(), result);
    }

    /**
     * Test of getListaConsultas method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaConsultas() {

        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);

        expSistema.getListaConsultas().add(expConsulta);

        ArrayList<Consulta> result = expSistema.getListaConsultas();
        assertEquals(expSistema.getListaConsultas(), result);
    }

    /**
     * Test of getListaPlanesDeAlimentacion method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testGetListaPlanesDeAlimentacion() {

        expAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expAlimentacion, expConsulta);

        expSistema.getListaPlanesDeAlimentacion().add(expAlimentacion);

        ArrayList<PlanAlimentacion> result = expSistema.getListaPlanesDeAlimentacion();
        assertEquals(expSistema.getListaPlanesDeAlimentacion(), result);
    }

    /**
     * Test of setListaUsuarios method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaUsuarios() {

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expAlimentacion,
                expConsulta);
        listaUsuarios.add(expUsuario);
        
        expSistema.setListaUsuarios(listaUsuarios);
    }

    /**
     * Test of setListaProfesionales method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaProfesionales() {

        ArrayList<Profesional> listaProfesionales = new ArrayList<Profesional>();
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        listaProfesionales.add(expProfesional);

        expSistema.setListaProfesionales(listaProfesionales);
    }

    /**
     * Test of setListaAlimentos method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaAlimentos() {
        
        ArrayList<Alimento> listaAlimentos = new ArrayList<Alimento>();

        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        listaAlimentos.add(expAlimento);
        
        expSistema.setListaAlimentos(listaAlimentos);
    }

    /**
     * Test of setListaConsultas method, of class SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaConsultas() {
        
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        listaConsultas.add(expConsulta);

        expSistema.setListaConsultas(listaConsultas);
    }

    /**
     * Test of setListaPlanesDeAlimentacion method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testSetListaPlanesDeAlimentacion() {
        
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<PlanAlimentacion>();

        expAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expAlimentacion, expConsulta);
        listaPlanesAlimentacion.add(expAlimentacion);
        
        expSistema.setListaPlanesDeAlimentacion(listaPlanesAlimentacion);
    }

    /**
     * Test of agregarRegistroUsuario method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroUsuario() {

        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expAlimentacion,
                expConsulta);

        expSistema.agregarRegistroUsuario(expUsuario);
    }

    /**
     * Test of agregarRegistroProfesional method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroProfesional() {

        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);

        expSistema.agregarRegistroProfesional(expProfesional);
    }

    /**
     * Test of agregarRegistroAlimento method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroAlimento() {

        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);

        expSistema.agregarRegistroAlimento(expAlimento);
    }

    /**
     * Test of agregarRegistroConsulta method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroConsulta() {

        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);

        expSistema.agregarRegistroConsulta(expConsulta);
    }

    /**
     * Test of agregarRegistroPlanDeAlimentacion method, of class
     * SistemaAlimentacionSaludable.
     */
    @Test
    public void testAgregarRegistroPlanDeAlimentacion() {

        expAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expAlimentacion, 
                expConsulta);

        expSistema.agregarRegistroPlanDeAlimentacion(expAlimentacion);
    }

}
