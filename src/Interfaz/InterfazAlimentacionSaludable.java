package Interfaz;

import Dominio.Alimento;
import Dominio.Consulta;
import Dominio.Ingesta;
import Dominio.PlanAlimentacion;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import Interfaz.JFramePrincipalAlimentacionSaludable.SeleccionPerfiles;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE InterfazAlimentacionSaludable
 * 21/11/2017
 */
public class InterfazAlimentacionSaludable {

    //JFileChooser
    public static String creacionJFileChooser(JInternalFrame JInternalFrame) {
        
        String rutaFoto = "";

        JFileChooser MyFileChooser = new JFileChooser();
        //Se elimina opción "Mostrar todos los archivos"
        MyFileChooser.setAcceptAllFileFilterUsed(false);
        //Solo se pueden abrir arcivos "jpg"
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "JPG");
        MyFileChooser.setFileFilter(filter);
        MyFileChooser.showOpenDialog(JInternalFrame);
        rutaFoto = MyFileChooser.getSelectedFile().getAbsolutePath();

        return rutaFoto;
    }

    public static void cargarJListRegistro(JList lista, String nuevoRegistro, 
            DefaultListModel modelo) {
        
        modelo.addElement(nuevoRegistro.replaceAll(" ", ""));
        lista.setModel(modelo);
    }

    public static boolean existeStringCargadoEnJList(DefaultListModel modelo, 
            String stringAIngresar) {
        
        boolean existeString = false;

        for (int i = 0; i < modelo.getSize() && !existeString; i++) {
            String stringYaCargado = (String) modelo.getElementAt(i);
            String stringYaCargadoSinSpace = stringYaCargado.replaceAll(" ", "");
            String stringAIngresarSinSpace = stringAIngresar.replaceAll(" ", "");
            if (stringYaCargadoSinSpace.toUpperCase().equals(stringAIngresarSinSpace.toUpperCase())) {
                existeString = true;
            }
        }

        return existeString;
    }

    public static ArrayList<String> datosEnListaAArrayListString(DefaultListModel modelo) {
        
        ArrayList<String> listaDatos = new ArrayList<String>();

        for (int i = 0; i < modelo.getSize(); i++) {
            listaDatos.add((String) modelo.get(i));
        }

        return listaDatos;
    }

    public static ArrayList<Usuario> agregarAListaUsuarioRegistrado(SistemaAlimentacionSaludable sistema,
            Usuario usuarioARegistrar) {

        sistema.agregarRegistroUsuario(usuarioARegistrar);
        return sistema.getListaUsuarios();
    }

    public static ArrayList<Profesional> agregarAListaProfesionalRegistrado(SistemaAlimentacionSaludable sistema,
            Profesional usuarioAProfesional) {

        sistema.agregarRegistroProfesional(usuarioAProfesional);
        return sistema.getListaProfesionales();
    }

    public static ArrayList<Alimento> agregarAListaAlimentoRegistrado(SistemaAlimentacionSaludable sistema,
            Alimento alimentoARegistrar) {

        sistema.agregarRegistroAlimento(alimentoARegistrar);
        return sistema.getListaAlimentos();
    }

    public static ArrayList<Consulta> agregarAListaConsultaRegistrada(SistemaAlimentacionSaludable sistema,
            Consulta consultaARegistrar) {

        sistema.agregarRegistroConsulta(consultaARegistrar);
        return sistema.getListaConsultas();
    }

    public static ArrayList<PlanAlimentacion> agregarAListaPlanDeAlimentacionRegistrado(SistemaAlimentacionSaludable sistema,
            PlanAlimentacion planAlimentacionARegistrar) {

        sistema.agregarRegistroPlanDeAlimentacion(planAlimentacionARegistrar);
        return sistema.getListaPlanesDeAlimentacion();
    }

    public static void agregarAListaConsultaUsuario(SistemaAlimentacionSaludable sistema,
            Consulta consultaARegistrar, String datosUsuario) {

        boolean encontreUsuario = false;
        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();
            ArrayList<Consulta> consultasUsuario = usuarioSistema.getListaConsultasRealizadas();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                consultasUsuario.add(consultaARegistrar);
            }
        }
    }

    public static void agregarAListaPlanDeAlimentacionUsuario(SistemaAlimentacionSaludable sistema,
            PlanAlimentacion planDeAlimentacionARegistrar, String datosUsuario) {

        boolean encontreUsuario = false;
        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();
            ArrayList<PlanAlimentacion> planesAlimentacionUsuario = 
                    usuarioSistema.getListaPlanesDeAlimentacion();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                planesAlimentacionUsuario.add(planDeAlimentacionARegistrar);
            }
        }
    }

    public static void borrarModeloJList(JList listaABorrar, DefaultListModel modelo) {
        
        int sizeDelModel = modelo.getSize();

        for (int i = 0; i < sizeDelModel; i++) {
            modelo.remove(modelo.getSize() - 1);
        }
        listaABorrar.setModel(modelo);
    }

    public static ArrayList<String> cargarUsuarioRegistrado(SistemaAlimentacionSaludable sistema, 
            JMenu menuPefiles, JMenu usuarioAutenticado, 
            JDesktopPane panelSistema, ArrayList<JMenu> listaMenus) {

        ArrayList<String> datosUsuario = new ArrayList<String>();

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario user = sistema.getListaUsuarios().get(i);
            JMenuItem usuarioRegistradoMenu = new JMenuItem();
            usuarioRegistradoMenu.setText(user.getPrimerNombre() + " " + 
                    user.getPrimerApellido());
            datosUsuario.add(user.getPrimerNombre() + " " + user.getPrimerApellido());
            usuarioRegistradoMenu.setIcon(user.getFotoPerfil());
            usuarioRegistradoMenu.addMouseListener(new SeleccionPerfiles(usuarioAutenticado,
                    panelSistema, listaMenus));
            menuPefiles.add(usuarioRegistradoMenu);
        }

        return datosUsuario;
    }

    public static ArrayList<String> cargarProfesionalRegistrado(SistemaAlimentacionSaludable sistema,
            JMenu menuPefiles, JMenu profesionalAutenticado, 
            JDesktopPane panelSistema, ArrayList<JMenu> listaMenus) {

        ArrayList<String> datosProfesional = new ArrayList<String>();

        for (int i = 0; i < sistema.getListaProfesionales().size(); i++) {
            Profesional prof = sistema.getListaProfesionales().get(i);
            JMenuItem profesionalRegistradoMenu = new JMenuItem();
            profesionalRegistradoMenu.setText(prof.getPrimerNombre() + " " + 
                    prof.getPrimerApellido());
            profesionalRegistradoMenu.setIcon(prof.getFotoPerfil());
            profesionalRegistradoMenu.addMouseListener(new SeleccionPerfiles(profesionalAutenticado,
                    panelSistema, listaMenus));
            menuPefiles.add(profesionalRegistradoMenu);
        }

        return datosProfesional;
    }

    public static void ingresarIngestasUsuarioAutenticado(SistemaAlimentacionSaludable sistema,
            String datosUsuarioAutenticado, Ingesta nuevaIngesta) {

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioRegistrado = sistema.getListaUsuarios().get(i);
            String consultaDatosUsuario = usuarioRegistrado.getPrimerNombre() + " " +
                    usuarioRegistrado.getPrimerApellido();
            ArrayList<Ingesta> listaIngestasUsuario =
                    usuarioRegistrado.getListaAlimentosIngeridos();

            if (consultaDatosUsuario.trim().equals(datosUsuarioAutenticado.trim())) {
                listaIngestasUsuario.add(nuevaIngesta);
            }
        }
    }

    public static DefaultComboBoxModel cargarComboAlimentos(DefaultComboBoxModel modeloAlimentos,
            SistemaAlimentacionSaludable sistema) {

        DefaultComboBoxModel modeloAlimentosCargado = modeloAlimentos;

        for (int i = 0; i < sistema.getListaAlimentos().size(); i++) {
            Alimento alimentoSistema = sistema.getListaAlimentos().get(i);
            modeloAlimentos.addElement(alimentoSistema.getNombre());
        }

        return modeloAlimentosCargado;
    }

    public static Alimento alimentoDeConsulta(SistemaAlimentacionSaludable sistema, 
            String seleccionAlimento) {

        Alimento alimentoDeConsultaNueva = null;
        boolean encontroAlimento = false;

        for (int i = 0; i < sistema.getListaAlimentos().size() && !encontroAlimento; i++) {
            Alimento alimentoSistema = sistema.getListaAlimentos().get(i);
            String nombreAlimentoSistema = alimentoSistema.getNombre().toUpperCase();

            if (nombreAlimentoSistema.equals(seleccionAlimento.toUpperCase())) {
                alimentoDeConsultaNueva = alimentoSistema;
            }
        }

        return alimentoDeConsultaNueva;
    }

    public static DefaultTableModel cargarJTableConsultas(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaConsultas, String datosUsuario) {

        ArrayList<Consulta> consultasDeUsuario = buscarUsuarioConsultas(sistema, datosUsuario);

        for (int i = 0; i < consultasDeUsuario.size(); i++) {
            Object[] objectConsulta = new Object[7];

            Consulta consulta = consultasDeUsuario.get(i);

            int idConsulta = consulta.getIdConsulta();
            objectConsulta[0] = idConsulta;
            String solicitante = datosUsuario.trim();
            objectConsulta[1] = solicitante;
            String titularConsulta = consulta.getTitularConsulta();
            objectConsulta[2] = titularConsulta;
            String descripcionConsulta = consulta.getDescripcionConsulta();
            objectConsulta[3] = descripcionConsulta;

            String atendidaPorProfesional = "Consulta sin atender";
            if (consulta.getProfesionalRespondeConsulta() != null) {
                Profesional profesionalSistema = consulta.getProfesionalRespondeConsulta();
                atendidaPorProfesional = profesionalSistema.getPrimerNombre() + " " +
                        profesionalSistema.getPrimerApellido();
            }

            objectConsulta[4] = atendidaPorProfesional;
            String alimentoConsultado = consulta.getAlimentoConsultado().getNombre();
            objectConsulta[5] = alimentoConsultado;
            String botonVerDetalles = "Click para ver Detalles";
            objectConsulta[6] = botonVerDetalles;

            modeloTablaConsultas.addRow(objectConsulta);
        }

        return modeloTablaConsultas;
    }

    public static DefaultTableModel cargarJTablePlanesDeAlimentacion(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaPlanesDeAlimentacion, String datosUsuario) {

        ArrayList<PlanAlimentacion> planesDeAlimentacionUsuario =
                buscarUsuarioPlanesDeAlimentacion(sistema, datosUsuario);

        for (int i = 0; i < planesDeAlimentacionUsuario.size(); i++) {
            Object[] objectPlanesDeAlimentacion = new Object[5];

            PlanAlimentacion planDeAlimentacion = planesDeAlimentacionUsuario.get(i);

            int idPlanAlimentacion = planDeAlimentacion.getIdPlanAlimentacion();
            objectPlanesDeAlimentacion[0] = idPlanAlimentacion;
            String solicitante = datosUsuario.trim();
            objectPlanesDeAlimentacion[1] = solicitante;

            String atendidaPorProfesional = "Solicitud enviada";
            if (planDeAlimentacion.getPlanCreadoPorProfesional() != null) {
                Profesional profesionalSistema = 
                        planDeAlimentacion.getPlanCreadoPorProfesional();
                atendidaPorProfesional = profesionalSistema.getPrimerNombre() + " " +
                        profesionalSistema.getPrimerApellido();
            }

            objectPlanesDeAlimentacion[2] = atendidaPorProfesional;
            String observaciones = planDeAlimentacion.getObservaciones();
            objectPlanesDeAlimentacion[3] = observaciones;
            String botonVerDetalles = "Click para ver Detalles";
            objectPlanesDeAlimentacion[4] = botonVerDetalles;

            modeloTablaPlanesDeAlimentacion.addRow(objectPlanesDeAlimentacion);
        }

        return modeloTablaPlanesDeAlimentacion;
    }

    public static DefaultTableModel cargarJTableConsultasTodosUsuarios(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaConsultas) {

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();
            ArrayList<Consulta> consultaUsuarioSistema = 
                    usuarioSistema.getListaConsultasRealizadas();

            for (int j = 0; j < consultaUsuarioSistema.size(); j++) {
                Object[] objectConsulta = new Object[7];
                Consulta consulta = consultaUsuarioSistema.get(j);

                int idConsulta = consulta.getIdConsulta();
                objectConsulta[0] = idConsulta;
                String solicitante = datosUsuarioSistema;
                objectConsulta[1] = solicitante;
                String titularConsulta = consulta.getTitularConsulta();
                objectConsulta[2] = titularConsulta;
                String descripcionConsulta = consulta.getDescripcionConsulta();
                objectConsulta[3] = descripcionConsulta;

                String atendidaPorProfesional = "Consulta sin atender";
                if (consulta.getProfesionalRespondeConsulta() != null) {
                    Profesional profesionalSistema = 
                            consulta.getProfesionalRespondeConsulta();
                    atendidaPorProfesional = profesionalSistema.getPrimerNombre() + " " + 
                            profesionalSistema.getPrimerApellido();
                }

                objectConsulta[4] = atendidaPorProfesional;
                String alimentoConsultado = consulta.getAlimentoConsultado().getNombre();
                objectConsulta[5] = alimentoConsultado;
                String botonVerDetalles = "Click para ver Detalles";
                objectConsulta[6] = botonVerDetalles;

                modeloTablaConsultas.addRow(objectConsulta);
            }
        }

        return modeloTablaConsultas;
    }

    public static DefaultTableModel cargarJTablePlanesAlimentacionTodosUsuarios(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaPlanesDeAlimentacion) {

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();
            ArrayList<PlanAlimentacion> planesAlimentacionUsuarioSistema =
                    usuarioSistema.getListaPlanesDeAlimentacion();

            for (int j = 0; j < planesAlimentacionUsuarioSistema.size(); j++) {
                Object[] objectPlanDeAlimentacion = new Object[5];
                PlanAlimentacion planAlimentacion = planesAlimentacionUsuarioSistema.get(j);

                int idPlanAlimentacion = planAlimentacion.getIdPlanAlimentacion();
                objectPlanDeAlimentacion[0] = idPlanAlimentacion;
                String solicitante = datosUsuarioSistema;
                objectPlanDeAlimentacion[1] = solicitante;

                String atendidaPorProfesional = "Solicitud enviada";
                if (planAlimentacion.getPlanCreadoPorProfesional() != null) {
                    Profesional profesional = planAlimentacion.getPlanCreadoPorProfesional();
                    atendidaPorProfesional = profesional.getPrimerNombre() + " " +
                            profesional.getPrimerApellido();
                }

                objectPlanDeAlimentacion[2] = atendidaPorProfesional;
                String observaciones = planAlimentacion.getObservaciones();
                objectPlanDeAlimentacion[3] = observaciones;
                String botonVerDetalles = "Click para ver Detalles";
                objectPlanDeAlimentacion[4] = botonVerDetalles;

                modeloTablaPlanesDeAlimentacion.addRow(objectPlanDeAlimentacion);
            }
        }

        return modeloTablaPlanesDeAlimentacion;
    }

    public static ArrayList<Consulta> buscarUsuarioConsultas(SistemaAlimentacionSaludable sistema,
            String datosUsuario) {
        
        ArrayList<Consulta> consultasDeUsuario = new ArrayList<Consulta>();
        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                encontreUsuario = true;
                consultasDeUsuario = usuarioSistema.getListaConsultasRealizadas();
            }
        }

        return consultasDeUsuario;
    }

    public static ArrayList<PlanAlimentacion> buscarUsuarioPlanesDeAlimentacion(SistemaAlimentacionSaludable sistema,
            String datosUsuario) {

        ArrayList<PlanAlimentacion> planDeAlimentacionUsuario = new ArrayList<PlanAlimentacion>();
        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " +
                    usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                encontreUsuario = true;
                planDeAlimentacionUsuario = usuarioSistema.getListaPlanesDeAlimentacion();
            }
        }

        return planDeAlimentacionUsuario;
    }

    public static void limpiarTablaConsultas(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = tabla.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    public static void guardarRespuesta(SistemaAlimentacionSaludable sistema, 
            int idConsulta, String respuestaProfesional, String nombreProfesional) {
        
        boolean consultaEncontrada = false;

        for (int i = 0; i < sistema.getListaConsultas().size() && !consultaEncontrada; i++) {
            Consulta consultaSistema = sistema.getListaConsultas().get(i);
            int idConsultaSistema = consultaSistema.getIdConsulta();

            if (idConsultaSistema == idConsulta) {
                consultaEncontrada = true;
                consultaSistema.setRespuestaConsulta(respuestaProfesional);
                //Buscamos profesional para asociar a la consulta
                Profesional profesionalSistema = 
                        buscarProfesionalConsulta(sistema, nombreProfesional);
                consultaSistema.setProfesionalRespondeConsulta(profesionalSistema);
            }
        }
    }

    public static ArrayList<String> infoPlanAlimentacionLunesAJueves(String planAlimentacionLunes,
            String planAlimentacionMartes, String planAlimentacionMiercoles, 
            String planAlimentacionJueves) {

        ArrayList<String> listaInfoPlanesAlimentacion = new ArrayList<String>();
        listaInfoPlanesAlimentacion.add(planAlimentacionLunes);
        listaInfoPlanesAlimentacion.add(planAlimentacionMartes);
        listaInfoPlanesAlimentacion.add(planAlimentacionMiercoles);
        listaInfoPlanesAlimentacion.add(planAlimentacionJueves);
        return listaInfoPlanesAlimentacion;
    }

    public static ArrayList<String> infoPlanAlimentacionViernesADomingo(String planAlimentacionViernes,
            String planAlimentacionSabado, String planAlimentacionDomingo) {

        ArrayList<String> listaInfoPlanesAlimentacion = new ArrayList<String>();
        listaInfoPlanesAlimentacion.add(planAlimentacionViernes);
        listaInfoPlanesAlimentacion.add(planAlimentacionSabado);
        listaInfoPlanesAlimentacion.add(planAlimentacionDomingo);
        return listaInfoPlanesAlimentacion;
    }

    public static String infoDiaPlanAlimentacion(ArrayList<String> infoStringArray,
            int posicionDiaPlanAlimentacion) {
        
        String diaPlanAlimentacion = "";
        diaPlanAlimentacion = infoStringArray.get(posicionDiaPlanAlimentacion);
        return diaPlanAlimentacion;
    }

    public static void guardarDatosAElavoracionPlanAlimentacion(SistemaAlimentacionSaludable sistema,
            int idPlanDeAlimentacion, ArrayList<String> planesAlimentacionLunesAJueves) {

        boolean planDeAlimentacionEncontrado = false;

        for (int i = 0; i < sistema.getListaPlanesDeAlimentacion().size() && !planDeAlimentacionEncontrado; i++) {
            PlanAlimentacion planAlimentacionSistema = 
                    sistema.getListaPlanesDeAlimentacion().get(i);
            int idPlanAlimentacionSistema = 
                    planAlimentacionSistema.getIdPlanAlimentacion();

            if (idPlanAlimentacionSistema == idPlanDeAlimentacion) {
                planDeAlimentacionEncontrado = true;

                planAlimentacionSistema.setListaConsejosLunes
        (infoDiaPlanAlimentacion(planesAlimentacionLunesAJueves, 0));
                planAlimentacionSistema.setListaConsejosMartes
        (infoDiaPlanAlimentacion(planesAlimentacionLunesAJueves, 1));
                planAlimentacionSistema.setListaConsejosMiercoles
        (infoDiaPlanAlimentacion(planesAlimentacionLunesAJueves, 2));
                planAlimentacionSistema.setListaConsejosJueves
        (infoDiaPlanAlimentacion(planesAlimentacionLunesAJueves, 3));
            }
        }
    }

    public static void guardarDatosBElavoracionPlanAlimentacion(SistemaAlimentacionSaludable sistema,
            int idPlanDeAlimentacion, ArrayList<String> planesAlimentacionViernesADomingo) {

        boolean planDeAlimentacionEncontrado = false;

        for (int i = 0; i < sistema.getListaPlanesDeAlimentacion().size() && !planDeAlimentacionEncontrado; i++) {
            PlanAlimentacion planAlimentacionSistema = 
                    sistema.getListaPlanesDeAlimentacion().get(i);
            int idPlanAlimentacionSistema = 
                    planAlimentacionSistema.getIdPlanAlimentacion();

            if (idPlanAlimentacionSistema == idPlanDeAlimentacion) {
                planDeAlimentacionEncontrado = true;

                planAlimentacionSistema.setListaConsejosViernes
        (infoDiaPlanAlimentacion(planesAlimentacionViernesADomingo, 0));
                planAlimentacionSistema.setListaConsejosSabado
        (infoDiaPlanAlimentacion(planesAlimentacionViernesADomingo, 1));
                planAlimentacionSistema.setListaConsejosDomingo
        (infoDiaPlanAlimentacion(planesAlimentacionViernesADomingo, 2));
            }
        }
    }

    public static void guardarDatosCElavoracionPlanAlimentacion(SistemaAlimentacionSaludable sistema,
            int idPlanDeAlimentacion, String nombreProfesional,
            Date fechaDesde, Date fechaHasta) {

        boolean planDeAlimentacionEncontrado = false;

        for (int i = 0; i < sistema.getListaPlanesDeAlimentacion().size() && !planDeAlimentacionEncontrado; i++) {
            PlanAlimentacion planAlimentacionSistema = 
                    sistema.getListaPlanesDeAlimentacion().get(i);
            int idPlanAlimentacionSistema = 
                    planAlimentacionSistema.getIdPlanAlimentacion();

            if (idPlanAlimentacionSistema == idPlanDeAlimentacion) {
                planDeAlimentacionEncontrado = true;

                //Buscamos profesional para asociar a la consulta
                Profesional profesionalSistema = 
                        buscarProfesionalConsulta(sistema, nombreProfesional);
                planAlimentacionSistema.setPlanCreadoPorProfesional(profesionalSistema);
                
                planAlimentacionSistema.setFechaDesdeVigencia(fechaDesde);
                planAlimentacionSistema.setFechaHastaVigencia(fechaHasta);
            }
        }
    }

    public static Profesional buscarProfesionalConsulta(SistemaAlimentacionSaludable sistema, 
            String nombreProfesional) {
        
        Profesional profesionalSistema = null;
        boolean encontreProfesional = false;

        for (int i = 0; i < sistema.getListaProfesionales().size() && !encontreProfesional; i++) {
            Profesional profesional = sistema.getListaProfesionales().get(i);
            String nombreProfesionalSistema = profesional.getPrimerNombre() + " " +
                    profesional.getPrimerApellido();

            if (nombreProfesionalSistema.trim().equals(nombreProfesional.trim())) {
                encontreProfesional = true;
                profesionalSistema = profesional;
            }
        }

        return profesionalSistema;

    }

    public static DefaultTableModel cargarJTableAlimentosIngresados(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaConsultas) {

        for (int i = 0; i < sistema.getListaAlimentos().size(); i++) {
            Object[] objectConsulta = new Object[4];

            Alimento alimento = sistema.getListaAlimentos().get(i);

            String nombreAlimento = alimento.getNombre();
            objectConsulta[0] = nombreAlimento;
            String tipoAlimento = alimento.getTipo();
            objectConsulta[1] = tipoAlimento;
            int porcionAlimento = alimento.getPorcion();
            objectConsulta[2] = porcionAlimento;

            ArrayList<String> nutrientesAlimento = alimento.getListaDeNutrientes();
            String nutrientesTodosAlimento = "";
            for (int j = 0; j < nutrientesAlimento.size(); j++) {
                String nutriente = nutrientesAlimento.get(j);
                nutrientesTodosAlimento = nutrientesTodosAlimento + "," + nutriente;
            }
            objectConsulta[3] = nutrientesTodosAlimento;

            modeloTablaConsultas.addRow(objectConsulta);
        }

        return modeloTablaConsultas;
    }

    public static boolean altaUsuarioOK(SistemaAlimentacionSaludable sistema, 
            String datosUsuarioAIngresar) {
        
        boolean usuarioSePuedeIngresar = true;

        for (int i = 0; i < sistema.getListaUsuarios().size() && usuarioSePuedeIngresar; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " +
                    usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuarioAIngresar.trim())) {
                usuarioSePuedeIngresar = false;
            }
        }

        return usuarioSePuedeIngresar;
    }

    public static boolean altaProfesionalOK(SistemaAlimentacionSaludable sistema, 
            String datosProfesionalAIngresar) {
        
        boolean profesionalSePuedeIngresar = true;

        for (int i = 0; i < sistema.getListaProfesionales().size() && profesionalSePuedeIngresar; i++) {
            Profesional profesionalSistema = sistema.getListaProfesionales().get(i);
            String datosProfesionalSistema = profesionalSistema.getPrimerNombre() + " " +
                    profesionalSistema.getPrimerApellido();

            if (datosProfesionalSistema.trim().equals(datosProfesionalAIngresar.trim())) {
                profesionalSePuedeIngresar = false;
            }
        }

        return profesionalSePuedeIngresar;
    }

    public static boolean altaAlimentoOK(SistemaAlimentacionSaludable sistema, 
            String datosAlimentoAIngresar) {
        
        boolean alimentoSePuedeIngresar = true;

        for (int i = 0; i < sistema.getListaAlimentos().size() && alimentoSePuedeIngresar; i++) {
            Alimento alimentoSistema = sistema.getListaAlimentos().get(i);
            String datosAlimentoSistema = alimentoSistema.getNombre();

            if (datosAlimentoSistema.trim().equals(datosAlimentoAIngresar.trim())) {
                alimentoSePuedeIngresar = false;
            }
        }

        return alimentoSePuedeIngresar;
    }

    public static Alimento buscarAlimento(SistemaAlimentacionSaludable sistema, 
            String nombreAlimento) {
        
        Alimento alimento = null;
        boolean encontreAlimento = false;

        for (int i = 0; i < sistema.getListaAlimentos().size() && !encontreAlimento; i++) {
            Alimento alimentoSistema = sistema.getListaAlimentos().get(i);
            String nombreAlimentoSistema = alimentoSistema.getNombre();

            if (nombreAlimento.trim().equals(nombreAlimentoSistema.trim())) {
                alimento = alimentoSistema;
                encontreAlimento = true;
            }
        }

        return alimento;
    }

    public static DefaultTableModel cargarJTableAlimentosIngestas(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaConsultas, String datosUsuario) {

        ArrayList<Ingesta> ingestasDeUsuario = buscarUsuarioIngestas(sistema, datosUsuario);

        for (int i = 0; i < ingestasDeUsuario.size(); i++) {
            Object[] objectConsulta = new Object[5];

            Ingesta ingesta = ingestasDeUsuario.get(i);
            Date fechaIngesta = ingesta.getFechaIngesta();
            String fechaIngestaSimpleFormat = 
                    new SimpleDateFormat("dd-MM-yyyy").format(fechaIngesta);
            objectConsulta[0] = fechaIngestaSimpleFormat;

            Alimento alimentoDeIngesta = ingesta.getAlimentoIngerido();
            String nombreAlimentoIngerido = alimentoDeIngesta.getNombre();
            objectConsulta[1] = nombreAlimentoIngerido;

            String tipoAlimentoIngerido = alimentoDeIngesta.getTipo();
            objectConsulta[2] = tipoAlimentoIngerido;

            int porcionAlimentoIngerido = alimentoDeIngesta.getPorcion();
            objectConsulta[3] = porcionAlimentoIngerido;

            ArrayList<String> listaNutrientesAlimento = 
                    alimentoDeIngesta.getListaDeNutrientes();
            String nutrientes = "";

            for (int j = 0; j < listaNutrientesAlimento.size(); j++) {
                String nutrienteAlimento = listaNutrientesAlimento.get(j);
                nutrientes = nutrientes + "," + nutrienteAlimento;
            }

            objectConsulta[4] = nutrientes;

            modeloTablaConsultas.addRow(objectConsulta);
        }

        return modeloTablaConsultas;
    }

    public static ArrayList<Ingesta> buscarUsuarioIngestas(SistemaAlimentacionSaludable sistema, 
            String datosUsuario) {
        
        ArrayList<Ingesta> ingestasDeUsuario = new ArrayList<Ingesta>();
        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                encontreUsuario = true;
                ingestasDeUsuario = usuarioSistema.getListaAlimentosIngeridos();
            }
        }

        return ingestasDeUsuario;
    }

    public static Usuario buscarUsuario(SistemaAlimentacionSaludable sistema, 
            String datosUsuario) {
        
        Usuario usuarioSistema = null;
        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuario = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuario.getPrimerNombre() + " " +
                    usuario.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                encontreUsuario = true;
                usuarioSistema = usuario;
            }
        }

        return usuarioSistema;
    }

    public static int cantidadDeConsultasUsuarioDado(String datosUsuarioSistema, 
            SistemaAlimentacionSaludable sistema) {
        
        int cantConsultas = 0;

        Usuario usuario = buscarUsuario(sistema, datosUsuarioSistema);
        ArrayList<Consulta> listaConsultasUsuario = usuario.getListaConsultasRealizadas();
        cantConsultas = listaConsultasUsuario.size();

        return cantConsultas;
    }

    public static int cantidadPlanesAlimentacionUsuarioDado(SistemaAlimentacionSaludable sistema,
            String datosUsuarioSistema) {
        
        int cantPlanesDeAlimentacion = 0;

        Usuario usuario = buscarUsuario(sistema, datosUsuarioSistema);
        ArrayList<PlanAlimentacion> listaPlanesDeAlimentacionUsuario = 
                usuario.getListaPlanesDeAlimentacion();
        cantPlanesDeAlimentacion = listaPlanesDeAlimentacionUsuario.size();

        return cantPlanesDeAlimentacion;
    }

    public static int cantidadDeConsultasTodosUsuarios(SistemaAlimentacionSaludable sistema) {
        int cantConsultas = 0;

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            ArrayList<Consulta> listaConsultasUsuario = 
                    usuarioSistema.getListaConsultasRealizadas();
            cantConsultas = cantConsultas + listaConsultasUsuario.size();
        }

        return cantConsultas;
    }

    public static DefaultTableModel cargarJTableIngestasAlimentos(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaIngestas, String datosUsuario) {

        ArrayList<Ingesta> ingestasDeUsuario = 
                buscarUsuarioIngestas(sistema, datosUsuario);

        for (int i = 0; i < ingestasDeUsuario.size(); i++) {
            Object[] objectIngesta = new Object[7];

            Ingesta ingestaUsuario = ingestasDeUsuario.get(i);

            Date fechaIngesta = ingestaUsuario.getFechaIngesta();
            String fechaIngestaSimpleFormat = 
                    new SimpleDateFormat("dd-MM-yyyy").format(fechaIngesta);
            objectIngesta[0] = fechaIngestaSimpleFormat;

            String nombreIngesta = ingestaUsuario.getAlimentoIngerido().getNombre();
            objectIngesta[1] = nombreIngesta;
            String tipoAlimento = ingestaUsuario.getAlimentoIngerido().getTipo();
            objectIngesta[2] = tipoAlimento;
            int porcionAlimento = ingestaUsuario.getAlimentoIngerido().getPorcion();
            objectIngesta[3] = porcionAlimento;

            ArrayList<String> listaNutrientesAlimento = 
                    ingestaUsuario.getAlimentoIngerido().getListaDeNutrientes();
            String datosListaNutrientesAlimento = "";

            for (int j = 0; j < listaNutrientesAlimento.size(); j++) {
                datosListaNutrientesAlimento = datosListaNutrientesAlimento + "," +
                        listaNutrientesAlimento.get(j);
            }
            objectIngesta[4] = datosListaNutrientesAlimento;

            modeloTablaIngestas.addRow(objectIngesta);
        }

        return modeloTablaIngestas;
    }

}
