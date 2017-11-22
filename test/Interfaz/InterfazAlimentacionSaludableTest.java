package Interfaz;

import Dominio.Alimento;
import Dominio.CargaDeDatosTest;
import Dominio.Consulta;
import Dominio.Ingesta;
import Dominio.PlanAlimentacion;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    InterfazAlimentacionSaludable expInterfazAlimentacion;
    SistemaAlimentacionSaludable expSistema;
    CargaDeDatosTest cargaDeDatos;
    Usuario expUsuario;
    Profesional expProfesional;
    PlanAlimentacion expPlanAlimentacion;
    Consulta expConsulta;
    Alimento expAlimento;
    Ingesta expIngesta;
    
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
        expInterfazAlimentacion = new InterfazAlimentacionSaludable();
        expSistema = new SistemaAlimentacionSaludable();
        cargaDeDatos = new CargaDeDatosTest();
        expUsuario = new Usuario();
        expProfesional = new Profesional();
        expPlanAlimentacion = new PlanAlimentacion();
        expConsulta = new Consulta();
        expAlimento = new Alimento();
        expIngesta = new Ingesta();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agregarAListaUsuarioRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaUsuarioRegistrado() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario,
                expPlanAlimentacion, expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        ArrayList<Usuario> expResult = expSistema.getListaUsuarios();
        
        ArrayList<Usuario> result = expInterfazAlimentacion.agregarAListaUsuarioRegistrado(expSistema,
                expUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAListaProfesionalRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaProfesionalRegistrado() {
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        
        expSistema.agregarRegistroProfesional(expProfesional);
        
        ArrayList<Profesional> expResult = expSistema.getListaProfesionales();
        
        ArrayList<Profesional> result = expInterfazAlimentacion.agregarAListaProfesionalRegistrado(expSistema,
                expProfesional);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAListaAlimentoRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaAlimentoRegistrado() {
        
        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        
        expSistema.agregarRegistroAlimento(expAlimento);
        
        ArrayList<Alimento> expResult = expSistema.getListaAlimentos();
        
        ArrayList<Alimento> result = expInterfazAlimentacion.agregarAListaAlimentoRegistrado(expSistema,
                expAlimento);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAListaConsultaRegistrada method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaConsultaRegistrada() {
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        
        expSistema.agregarRegistroConsulta(expConsulta);
        
        ArrayList<Consulta> expResult = expSistema.getListaConsultas();
        
        ArrayList<Consulta> result = expInterfazAlimentacion.agregarAListaConsultaRegistrada(expSistema,
                expConsulta);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAListaPlanDeAlimentacionRegistrado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaPlanDeAlimentacionRegistrado() {
        
        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroPlanDeAlimentacion(expPlanAlimentacion);
        
        ArrayList<PlanAlimentacion> expResult = expSistema.getListaPlanesDeAlimentacion();
        
        ArrayList<PlanAlimentacion> result = expInterfazAlimentacion.agregarAListaPlanDeAlimentacionRegistrado(expSistema,
                expPlanAlimentacion);
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarAListaConsultaUsuario method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaConsultaUsuario() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        InterfazAlimentacionSaludable.agregarAListaConsultaUsuario(expSistema, expConsulta, datosUsuario);
    }

    /**
     * Test of agregarAListaPlanDeAlimentacionUsuario method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAgregarAListaPlanDeAlimentacionUsuario() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        
        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionUsuario(expSistema,
                expPlanAlimentacion, datosUsuario);
    }

    /**
     * Test of ingresarIngestasUsuarioAutenticado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testIngresarIngestasUsuarioAutenticado() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        
        expIngesta = cargaDeDatos.cargarIngesta(expIngesta, expAlimento);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        InterfazAlimentacionSaludable.ingresarIngestasUsuarioAutenticado(expSistema,
                datosUsuario, expIngesta);
        
    }

    /**
     * Test of alimentoDeConsulta method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testAlimentoDeConsulta() {
        
        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        String seleccionAlimento = expAlimento.getNombre();
        
        expSistema.agregarRegistroAlimento(expAlimento);
        
        Alimento result = InterfazAlimentacionSaludable.alimentoDeConsulta(expSistema,
                seleccionAlimento);
        assertEquals(expAlimento, result);
    }

    /**
     * Test of buscarUsuarioConsultas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioConsultas() {
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        ArrayList<Consulta> listaConsultas = expUsuario.getListaConsultasRealizadas();
        
        ArrayList<Consulta> result = InterfazAlimentacionSaludable.
                buscarUsuarioConsultas(expSistema, datosUsuario);
        assertEquals(listaConsultas, result);
    }

    /**
     * Test of buscarUsuarioPlanesDeAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioPlanesDeAlimentacion() {
        
        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        ArrayList<PlanAlimentacion> listaPlanesDeAlimentacion = expUsuario.getListaPlanesDeAlimentacion();
        
        ArrayList<PlanAlimentacion> result = InterfazAlimentacionSaludable.
                buscarUsuarioPlanesDeAlimentacion(expSistema, datosUsuario);
        assertEquals(listaPlanesDeAlimentacion, result);
    }

    /**
     * Test of guardarRespuesta method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarRespuesta() {
        
        int idConsulta = 0;
        String respuestaProfesional = "Respuesta Profesional";
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        String nombreProfesional = expProfesional.getPrimerNombre() + " "
                + expProfesional.getPrimerApellido();
        
        InterfazAlimentacionSaludable.guardarRespuesta(expSistema, idConsulta,
                respuestaProfesional, nombreProfesional);
    }

    /**
     * Test of infoPlanAlimentacionLunesAJueves method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoPlanAlimentacionLunesAJueves() {
        
        String planAlimentacionLunes = "Info Lunes";
        String planAlimentacionMartes = "Info Martes";
        String planAlimentacionMiercoles = "Info Miercoles";
        String planAlimentacionJueves = "Info Jueves";
        
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add(planAlimentacionLunes);
        expResult.add(planAlimentacionMartes);
        expResult.add(planAlimentacionMiercoles);
        expResult.add(planAlimentacionJueves);
        
        ArrayList<String> result = InterfazAlimentacionSaludable.
                infoPlanAlimentacionLunesAJueves(planAlimentacionLunes,
                        planAlimentacionMartes, planAlimentacionMiercoles,
                        planAlimentacionJueves);
        assertEquals(expResult, result);
    }

    /**
     * Test of infoPlanAlimentacionViernesADomingo method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoPlanAlimentacionViernesADomingo() {
        
        String planAlimentacionViernes = "Info Viernes";
        String planAlimentacionSabado = "Info Sabado";
        String planAlimentacionDomingo = "Info Domingo";
        
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add(planAlimentacionViernes);
        expResult.add(planAlimentacionSabado);
        expResult.add(planAlimentacionDomingo);
        
        ArrayList<String> result = InterfazAlimentacionSaludable.
                infoPlanAlimentacionViernesADomingo(planAlimentacionViernes,
                        planAlimentacionSabado, planAlimentacionDomingo);
        assertEquals(expResult, result);
    }

    /**
     * Test of infoDiaPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testInfoDiaPlanAlimentacion() {
        
        ArrayList<String> infoStringArray = new ArrayList<String>();
        String infoStringArrayDia1 = "Ensalada con arroz";
        String infoStringArrayDia2 = "Ensalada con papa";
        String infoStringArrayDia3 = "Ensalada con pollo";
        infoStringArray.add(infoStringArrayDia1);
        infoStringArray.add(infoStringArrayDia2);
        infoStringArray.add(infoStringArrayDia3);
        
        int posicionDiaPlanAlimentacion = 0;
        
        String result = InterfazAlimentacionSaludable.
                infoDiaPlanAlimentacion(infoStringArray, posicionDiaPlanAlimentacion);
        assertEquals(infoStringArray.get(posicionDiaPlanAlimentacion), result);
    }

    /**
     * Test of guardarDatosAElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosAElavoracionPlanAlimentacion() {
        
        int idPlanDeAlimentacion = 1;
        
        ArrayList<String> planesAlimentacionLunesAJueves = new ArrayList<String>();
        String datosPlanAlimentacionLunes = "Pollo con ensalda y algo de pescado";
        String datosPlanAlimentacionMartes = "Pollo con ensalda";
        String datosPlanAlimentacionMiercoles = "Pescado y arroz";
        String datosPlanAlimentacionJueves = "Pollo con ensalda y algo de pescado";
        planesAlimentacionLunesAJueves.add(datosPlanAlimentacionLunes);
        planesAlimentacionLunesAJueves.add(datosPlanAlimentacionMartes);
        planesAlimentacionLunesAJueves.add(datosPlanAlimentacionMiercoles);
        planesAlimentacionLunesAJueves.add(datosPlanAlimentacionJueves);
        
        InterfazAlimentacionSaludable.
                guardarDatosAElavoracionPlanAlimentacion(expSistema, idPlanDeAlimentacion,
                        planesAlimentacionLunesAJueves);
    }

    /**
     * Test of guardarDatosBElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosBElavoracionPlanAlimentacion() {
        
        int idPlanDeAlimentacion = 1;
        
        ArrayList<String> planesAlimentacionViernesADomingo = new ArrayList<String>();
        String datosPlanAlimentacionViernes = "Pollo con ensalda y algo de pescado";
        String datosPlanAlimentacionSabado = "Pollo con ensalda";
        String datosPlanAlimentacionDomingo = "Pescado y arroz";
        planesAlimentacionViernesADomingo.add(datosPlanAlimentacionViernes);
        planesAlimentacionViernesADomingo.add(datosPlanAlimentacionSabado);
        planesAlimentacionViernesADomingo.add(datosPlanAlimentacionDomingo);
        
        InterfazAlimentacionSaludable.
                guardarDatosBElavoracionPlanAlimentacion(expSistema,
                        idPlanDeAlimentacion, planesAlimentacionViernesADomingo);
    }

    /**
     * Test of guardarDatosCElavoracionPlanAlimentacion method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testGuardarDatosCElavoracionPlanAlimentacion() {
        
        int idPlanDeAlimentacion = 1;
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        
        String nombreProfesional = expProfesional.getPrimerNombre() + " "
                + expProfesional.getPrimerApellido();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String fechaDesdeStr = "20-Jun-2017";
        String fechaHastaStr = "27-Jun-2017";
        Date fechaDesde = null;
        Date fechaHasta = null;
        
        try {
            fechaDesde = formatter.parse(fechaDesdeStr);
            fechaHasta = formatter.parse(fechaHastaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        InterfazAlimentacionSaludable.
                guardarDatosCElavoracionPlanAlimentacion(expSistema, idPlanDeAlimentacion,
                        nombreProfesional, fechaDesde, fechaHasta);
    }

    /**
     * Test of buscarProfesionalConsulta method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarProfesionalConsulta() {
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        String nombreProfesional = expProfesional.getPrimerNombre() + " "
                + expProfesional.getPrimerApellido();
        
        expSistema.agregarRegistroProfesional(expProfesional);
        
        Profesional result = InterfazAlimentacionSaludable.
                buscarProfesionalConsulta(expSistema, nombreProfesional);
        assertEquals(expProfesional, result);
    }

    /**
     * Test of altaUsuarioOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaUsuarioOK() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        String datosUsuarioAIngresar = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        boolean expResult = true;
        boolean result = InterfazAlimentacionSaludable.altaUsuarioOK(expSistema,
                datosUsuarioAIngresar);
        assertEquals(expResult, result);
    }

    /**
     * Test of altaProfesionalOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaProfesionalOK() {
        
        expProfesional = cargaDeDatos.cargarPorfesional(expProfesional);
        String datosProfesionalAIngresar = expProfesional.getPrimerNombre() + " "
                + expProfesional.getPrimerApellido();
        
        boolean expResult = true;
        boolean result = InterfazAlimentacionSaludable.altaProfesionalOK(expSistema,
                datosProfesionalAIngresar);
        assertEquals(expResult, result);
    }

    /**
     * Test of altaAlimentoOK method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testAltaAlimentoOK() {
        
        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        String datosAlimentoAIngresar = expAlimento.getNombre();
        
        boolean expResult = true;
        boolean result = InterfazAlimentacionSaludable.altaAlimentoOK(expSistema,
                datosAlimentoAIngresar);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarAlimento method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarAlimento() {
        
        expAlimento = cargaDeDatos.cargarAlimento(expAlimento);
        String nombreAlimento = expAlimento.getNombre();
        
        expSistema.agregarRegistroAlimento(expAlimento);
        
        Alimento result = InterfazAlimentacionSaludable.
                buscarAlimento(expSistema, nombreAlimento);
        assertEquals(expAlimento, result);
    }

    /**
     * Test of buscarUsuarioIngestas method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuarioIngestas() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        ArrayList<Ingesta> expResult = expUsuario.getListaAlimentosIngeridos();
        
        ArrayList<Ingesta> result = InterfazAlimentacionSaludable.
                buscarUsuarioIngestas(expSistema, datosUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarUsuario method, of class InterfazAlimentacionSaludable.
     */
    @Test
    public void testBuscarUsuario() {
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuario = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        Usuario result = InterfazAlimentacionSaludable.
                buscarUsuario(expSistema, datosUsuario);
        assertEquals(expUsuario, result);
    }

    /**
     * Test of cantidadDeConsultasUsuarioDado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadDeConsultasUsuarioDado() {
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuarioSistema = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        int expResult = expUsuario.getListaConsultasRealizadas().size();
        int result = InterfazAlimentacionSaludable.
                cantidadDeConsultasUsuarioDado(datosUsuarioSistema, expSistema);
        assertEquals(expResult, result);
    }

    /**
     * Test of cantidadPlanesAlimentacionUsuarioDado method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadPlanesAlimentacionUsuarioDado() {
        
        expPlanAlimentacion = cargaDeDatos.cargarPlanDeAlimentacion(expPlanAlimentacion,
                expConsulta);
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        
        String datosUsuarioSistema = expUsuario.getPrimerNombre() + " "
                + expUsuario.getPrimerApellido();
        
        int expResult = expUsuario.getListaPlanesDeAlimentacion().size();
        int result = InterfazAlimentacionSaludable.
                cantidadPlanesAlimentacionUsuarioDado(expSistema, datosUsuarioSistema);
        assertEquals(expResult, result);
    }

    /**
     * Test of cantidadDeConsultasTodosUsuarios method, of class
     * InterfazAlimentacionSaludable.
     */
    @Test
    public void testCantidadDeConsultasTodosUsuarios() {
        
        expConsulta = cargaDeDatos.cargarConsulta(expConsulta, expAlimento,
                expProfesional, expUsuario);
        
        expUsuario = cargaDeDatos.cargarUsuario(expUsuario, expPlanAlimentacion,
                expConsulta);
        
        expSistema.agregarRegistroUsuario(expUsuario);
        expSistema.agregarRegistroConsulta(expConsulta);
        
        int expResult = expSistema.getListaConsultas().size();
        int result = InterfazAlimentacionSaludable.
                cantidadDeConsultasTodosUsuarios(expSistema);
        assertEquals(expResult, result);
    }
    
}
