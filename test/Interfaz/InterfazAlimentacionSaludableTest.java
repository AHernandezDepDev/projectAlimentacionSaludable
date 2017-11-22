package Interfaz;

import Dominio.Alimento;
import Dominio.Consulta;
import Dominio.Ingesta;
import Dominio.PlanAlimentacion;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE InterfazAlimentacionSaludableTest
 * 21/11/2017
 */
public class InterfazAlimentacionSaludableTest {

    public InterfazAlimentacionSaludableTest() {
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
     * Test of creacionJFileChooser method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCreacionJFileChooser() {
        System.out.println("cargarJListRegistro");
        JInternalFrame JInternalFrame = null;
        String expResult = "";
        String result = InterfazAlimentacionSaludable.creacionJFileChooser(JInternalFrame);
        assertEquals(expResult, result);
    }

    /**
     * Test of cargarJListRegistro method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJListRegistro() {
        System.out.println("cargarJListRegistro");
        JList lista = null;
        String nuevoRegistro = "";
        DefaultListModel modelo = null;
        InterfazAlimentacionSaludable.cargarJListRegistro(lista, nuevoRegistro, modelo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeStringCargadoEnJList method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testExisteStringCargadoEnJList() {
        System.out.println("existeStringCargadoEnJList");
        DefaultListModel modelo = null;
        String stringAIngresar = "";
        boolean expResult = false;
        boolean result = InterfazAlimentacionSaludable.existeStringCargadoEnJList(modelo, stringAIngresar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of datosEnListaAArrayListString method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testDatosEnListaAArrayListString() {
        System.out.println("datosEnListaAArrayListString");
        DefaultListModel modelo = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = InterfazAlimentacionSaludable.datosEnListaAArrayListString(modelo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaUsuarioRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaUsuarioRegistrado() {
        System.out.println("agregarAListaUsuarioRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        Usuario usuarioARegistrar = null;
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = InterfazAlimentacionSaludable.agregarAListaUsuarioRegistrado(sistema, usuarioARegistrar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaProfesionalRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaProfesionalRegistrado() {
        System.out.println("agregarAListaProfesionalRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        Profesional usuarioAProfesional = null;
        ArrayList<Profesional> expResult = null;
        ArrayList<Profesional> result = InterfazAlimentacionSaludable.agregarAListaProfesionalRegistrado(sistema, usuarioAProfesional);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaAlimentoRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaAlimentoRegistrado() {
        System.out.println("agregarAListaAlimentoRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        Alimento alimentoARegistrar = null;
        ArrayList<Alimento> expResult = null;
        ArrayList<Alimento> result = InterfazAlimentacionSaludable.agregarAListaAlimentoRegistrado(sistema, alimentoARegistrar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaConsultaRegistrada method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaConsultaRegistrada() {
        System.out.println("agregarAListaConsultaRegistrada");
        SistemaAlimentacionSaludable sistema = null;
        Consulta consultaARegistrar = null;
        ArrayList<Consulta> expResult = null;
        ArrayList<Consulta> result = InterfazAlimentacionSaludable.agregarAListaConsultaRegistrada(sistema, consultaARegistrar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaPlanDeAlimentacionRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaPlanDeAlimentacionRegistrado() {
        System.out.println("agregarAListaPlanDeAlimentacionRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        PlanAlimentacion planAlimentacionARegistrar = null;
        ArrayList<PlanAlimentacion> expResult = null;
        ArrayList<PlanAlimentacion> result = InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionRegistrado(sistema, planAlimentacionARegistrar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaConsultaUsuario method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaConsultaUsuario() {
        System.out.println("agregarAListaConsultaUsuario");
        SistemaAlimentacionSaludable sistema = null;
        Consulta consultaARegistrar = null;
        String datosUsuario = "";
        InterfazAlimentacionSaludable.agregarAListaConsultaUsuario(sistema, consultaARegistrar, datosUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAListaPlanDeAlimentacionUsuario method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaPlanDeAlimentacionUsuario() {
        System.out.println("agregarAListaPlanDeAlimentacionUsuario");
        SistemaAlimentacionSaludable sistema = null;
        PlanAlimentacion planDeAlimentacionARegistrar = null;
        String datosUsuario = "";
        InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionUsuario(sistema, planDeAlimentacionARegistrar, datosUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarModeloJList method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testBorrarModeloJList() {
        System.out.println("borrarModeloJList");
        JList listaABorrar = null;
        DefaultListModel modelo = null;
        InterfazAlimentacionSaludable.borrarModeloJList(listaABorrar, modelo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarUsuarioRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarUsuarioRegistrado() {
        System.out.println("cargarUsuarioRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        JMenu menuPefiles = null;
        JMenu usuarioAutenticado = null;
        JDesktopPane panelSistema = null;
        ArrayList<JMenu> listaMenus = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = InterfazAlimentacionSaludable.cargarUsuarioRegistrado(sistema, menuPefiles, usuarioAutenticado, panelSistema, listaMenus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarProfesionalRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarProfesionalRegistrado() {
        System.out.println("cargarProfesionalRegistrado");
        SistemaAlimentacionSaludable sistema = null;
        JMenu menuPefiles = null;
        JMenu profesionalAutenticado = null;
        JDesktopPane panelSistema = null;
        ArrayList<JMenu> listaMenus = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = InterfazAlimentacionSaludable.cargarProfesionalRegistrado(sistema, menuPefiles, profesionalAutenticado, panelSistema, listaMenus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarIngestasUsuarioAutenticado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testIngresarIngestasUsuarioAutenticado() {
        System.out.println("ingresarIngestasUsuarioAutenticado");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuarioAutenticado = "";
        Ingesta nuevaIngesta = null;
        InterfazAlimentacionSaludable.ingresarIngestasUsuarioAutenticado(sistema, datosUsuarioAutenticado, nuevaIngesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarComboAlimentos method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarComboAlimentos() {
        System.out.println("cargarComboAlimentos");
        DefaultComboBoxModel modeloAlimentos = null;
        SistemaAlimentacionSaludable sistema = null;
        DefaultComboBoxModel expResult = null;
        DefaultComboBoxModel result = InterfazAlimentacionSaludable.cargarComboAlimentos(modeloAlimentos, sistema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alimentoDeConsulta method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAlimentoDeConsulta() {
        System.out.println("alimentoDeConsulta");
        SistemaAlimentacionSaludable sistema = null;
        String seleccionAlimento = "";
        Alimento expResult = null;
        Alimento result = InterfazAlimentacionSaludable.alimentoDeConsulta(sistema, seleccionAlimento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTableConsultas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTableConsultas() {
        System.out.println("cargarJTableConsultas");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaConsultas = null;
        String datosUsuario = "";
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTableConsultas(sistema, modeloTablaConsultas, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTablePlanesDeAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTablePlanesDeAlimentacion() {
        System.out.println("cargarJTablePlanesDeAlimentacion");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaPlanesDeAlimentacion = null;
        String datosUsuario = "";
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTablePlanesDeAlimentacion(sistema, modeloTablaPlanesDeAlimentacion, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTableConsultasTodosUsuarios method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTableConsultasTodosUsuarios() {
        System.out.println("cargarJTableConsultasTodosUsuarios");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaConsultas = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTableConsultasTodosUsuarios(sistema, modeloTablaConsultas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTablePlanesAlimentacionTodosUsuarios method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTablePlanesAlimentacionTodosUsuarios() {
        System.out.println("cargarJTablePlanesAlimentacionTodosUsuarios");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaPlanesDeAlimentacion = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTablePlanesAlimentacionTodosUsuarios(sistema, modeloTablaPlanesDeAlimentacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioConsultas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioConsultas() {
        System.out.println("buscarUsuarioConsultas");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuario = "";
        ArrayList<Consulta> expResult = null;
        ArrayList<Consulta> result = InterfazAlimentacionSaludable.buscarUsuarioConsultas(sistema, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioPlanesDeAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioPlanesDeAlimentacion() {
        System.out.println("buscarUsuarioPlanesDeAlimentacion");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuario = "";
        ArrayList<PlanAlimentacion> expResult = null;
        ArrayList<PlanAlimentacion> result = InterfazAlimentacionSaludable.buscarUsuarioPlanesDeAlimentacion(sistema, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarTablaConsultas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testLimpiarTablaConsultas() {
        System.out.println("limpiarTablaConsultas");
        JTable tabla = null;
        InterfazAlimentacionSaludable.limpiarTablaConsultas(tabla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarRespuesta method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarRespuesta() {
        System.out.println("guardarRespuesta");
        SistemaAlimentacionSaludable sistema = null;
        int idConsulta = 0;
        String respuestaProfesional = "";
        String nombreProfesional = "";
        InterfazAlimentacionSaludable.guardarRespuesta(sistema, idConsulta, respuestaProfesional, nombreProfesional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoPlanAlimentacionLunesAJueves method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoPlanAlimentacionLunesAJueves() {
        System.out.println("infoPlanAlimentacionLunesAJueves");
        String planAlimentacionLunes = "";
        String planAlimentacionMartes = "";
        String planAlimentacionMiercoles = "";
        String planAlimentacionJueves = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = InterfazAlimentacionSaludable.infoPlanAlimentacionLunesAJueves(planAlimentacionLunes, planAlimentacionMartes, planAlimentacionMiercoles, planAlimentacionJueves);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoPlanAlimentacionViernesADomingo method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoPlanAlimentacionViernesADomingo() {
        System.out.println("infoPlanAlimentacionViernesADomingo");
        String planAlimentacionViernes = "";
        String planAlimentacionSabado = "";
        String planAlimentacionDomingo = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = InterfazAlimentacionSaludable.infoPlanAlimentacionViernesADomingo(planAlimentacionViernes, planAlimentacionSabado, planAlimentacionDomingo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infoDiaPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoDiaPlanAlimentacion() {
        System.out.println("infoDiaPlanAlimentacion");
        ArrayList<String> infoStringArray = null;
        int posicionDiaPlanAlimentacion = 0;
        String expResult = "";
        String result = InterfazAlimentacionSaludable.infoDiaPlanAlimentacion(infoStringArray, posicionDiaPlanAlimentacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatosAElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosAElavoracionPlanAlimentacion() {
        System.out.println("guardarDatosAElavoracionPlanAlimentacion");
        SistemaAlimentacionSaludable sistema = null;
        int idPlanDeAlimentacion = 0;
        ArrayList<String> planesAlimentacionLunesAJueves = null;
        InterfazAlimentacionSaludable.guardarDatosAElavoracionPlanAlimentacion(sistema, idPlanDeAlimentacion, planesAlimentacionLunesAJueves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatosBElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosBElavoracionPlanAlimentacion() {
        System.out.println("guardarDatosBElavoracionPlanAlimentacion");
        SistemaAlimentacionSaludable sistema = null;
        int idPlanDeAlimentacion = 0;
        ArrayList<String> planesAlimentacionViernesADomingo = null;
        InterfazAlimentacionSaludable.guardarDatosBElavoracionPlanAlimentacion(sistema, idPlanDeAlimentacion, planesAlimentacionViernesADomingo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatosCElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosCElavoracionPlanAlimentacion() {
        System.out.println("guardarDatosCElavoracionPlanAlimentacion");
        SistemaAlimentacionSaludable sistema = null;
        int idPlanDeAlimentacion = 0;
        String nombreProfesional = "";
        Date fechaDesde = null;
        Date fechaHasta = null;
        InterfazAlimentacionSaludable.guardarDatosCElavoracionPlanAlimentacion(sistema, idPlanDeAlimentacion, nombreProfesional, fechaDesde, fechaHasta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProfesionalConsulta method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarProfesionalConsulta() {
        System.out.println("buscarProfesionalConsulta");
        SistemaAlimentacionSaludable sistema = null;
        String nombreProfesional = "";
        Profesional expResult = null;
        Profesional result = InterfazAlimentacionSaludable.buscarProfesionalConsulta(sistema, nombreProfesional);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTableAlimentosIngresados method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTableAlimentosIngresados() {
        System.out.println("cargarJTableAlimentosIngresados");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaConsultas = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTableAlimentosIngresados(sistema, modeloTablaConsultas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaUsuarioOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaUsuarioOK() {
        System.out.println("altaUsuarioOK");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuarioAIngresar = "";
        boolean expResult = false;
        boolean result = InterfazAlimentacionSaludable.altaUsuarioOK(sistema, datosUsuarioAIngresar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaProfesionalOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaProfesionalOK() {
        System.out.println("altaProfesionalOK");
        SistemaAlimentacionSaludable sistema = null;
        String datosProfesionalAIngresar = "";
        boolean expResult = false;
        boolean result = InterfazAlimentacionSaludable.altaProfesionalOK(sistema, datosProfesionalAIngresar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaAlimentoOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaAlimentoOK() {
        System.out.println("altaAlimentoOK");
        SistemaAlimentacionSaludable sistema = null;
        String datosAlimentoAIngresar = "";
        boolean expResult = false;
        boolean result = InterfazAlimentacionSaludable.altaAlimentoOK(sistema, datosAlimentoAIngresar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAlimento method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarAlimento() {
        System.out.println("buscarAlimento");
        SistemaAlimentacionSaludable sistema = null;
        String nombreAlimento = "";
        Alimento expResult = null;
        Alimento result = InterfazAlimentacionSaludable.buscarAlimento(sistema, nombreAlimento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTableAlimentosIngestas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTableAlimentosIngestas() {
        System.out.println("cargarJTableAlimentosIngestas");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaConsultas = null;
        String datosUsuario = "";
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTableAlimentosIngestas(sistema, modeloTablaConsultas, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioIngestas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioIngestas() {
        System.out.println("buscarUsuarioIngestas");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuario = "";
        ArrayList<Ingesta> expResult = null;
        ArrayList<Ingesta> result = InterfazAlimentacionSaludable.buscarUsuarioIngestas(sistema, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuario method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuario = "";
        Usuario expResult = null;
        Usuario result = InterfazAlimentacionSaludable.buscarUsuario(sistema, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeConsultasUsuarioDado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadDeConsultasUsuarioDado() {
        System.out.println("cantidadDeConsultasUsuarioDado");
        String datosUsuarioSistema = "";
        SistemaAlimentacionSaludable sistema = null;
        int expResult = 0;
        int result = InterfazAlimentacionSaludable.cantidadDeConsultasUsuarioDado(datosUsuarioSistema, sistema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadPlanesAlimentacionUsuarioDado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadPlanesAlimentacionUsuarioDado() {
        System.out.println("cantidadPlanesAlimentacionUsuarioDado");
        SistemaAlimentacionSaludable sistema = null;
        String datosUsuarioSistema = "";
        int expResult = 0;
        int result = InterfazAlimentacionSaludable.cantidadPlanesAlimentacionUsuarioDado(sistema, datosUsuarioSistema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeConsultasTodosUsuarios method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadDeConsultasTodosUsuarios() {
        System.out.println("cantidadDeConsultasTodosUsuarios");
        SistemaAlimentacionSaludable sistema = null;
        int expResult = 0;
        int result = InterfazAlimentacionSaludable.cantidadDeConsultasTodosUsuarios(sistema);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarJTableIngestasAlimentos method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCargarJTableIngestasAlimentos() {
        System.out.println("cargarJTableIngestasAlimentos");
        SistemaAlimentacionSaludable sistema = null;
        DefaultTableModel modeloTablaIngestas = null;
        String datosUsuario = "";
        DefaultTableModel expResult = null;
        DefaultTableModel result = InterfazAlimentacionSaludable.cargarJTableIngestasAlimentos(sistema, modeloTablaIngestas, datosUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
