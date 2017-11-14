package Interfaz;

import Dominio.Alimento;
import Dominio.Consulta;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import Interfaz.JFramePrincipalAlimentacionSaludable.SeleccionPerfiles;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
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
        rutaFoto = MyFileChooser.getSelectedFile().getAbsolutePath(); //tira exepciones tratar de controlar!!!

        return rutaFoto;
    }

    public static void cargarJListRegistro(JList lista, String nuevoRegistro, DefaultListModel modelo) {
        modelo.addElement(nuevoRegistro.replaceAll(" ", ""));
        lista.setModel(modelo);
    }

    public static boolean existeStringCargadoEnJList(DefaultListModel modelo, String stringAIngresar) {
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

    public static void agregarAListaConsultaUsuario(SistemaAlimentacionSaludable sistema,
            Consulta consultaARegistrar, String datosUsuario) {

        boolean encontreUsuario = false;
        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + usuarioSistema.getPrimerApellido();
            ArrayList<Consulta> consultasUsuario = usuarioSistema.getListaConsultasRealizadas();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                consultasUsuario.add(consultaARegistrar);
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

    public static ArrayList<String> cargarUsuarioRegistrado(SistemaAlimentacionSaludable sistema, JMenu menuPefiles,
            JMenu usuarioAutenticado, JDesktopPane panelSistema, ArrayList<JMenu> listaMenus) {

        ArrayList<String> datosUsuario = new ArrayList<String>();

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario user = sistema.getListaUsuarios().get(i);
            JMenuItem usuarioRegistradoMenu = new JMenuItem();
            usuarioRegistradoMenu.setText(user.getPrimerNombre() + " " + user.getPrimerApellido());
            datosUsuario.add(user.getPrimerNombre() + " " + user.getPrimerApellido());
            usuarioRegistradoMenu.setIcon(user.getFotoPerfil());
            usuarioRegistradoMenu.addMouseListener(new SeleccionPerfiles(usuarioAutenticado, panelSistema, listaMenus));
            menuPefiles.add(usuarioRegistradoMenu);
        }

        return datosUsuario;
    }

    public static ArrayList<String> cargarProfesionalRegistrado(SistemaAlimentacionSaludable sistema, JMenu menuPefiles,
            JMenu profesionalAutenticado, JDesktopPane panelSistema, ArrayList<JMenu> listaMenus) {

        ArrayList<String> datosProfesional = new ArrayList<String>();

        for (int i = 0; i < sistema.getListaProfesionales().size(); i++) {
            Profesional prof = sistema.getListaProfesionales().get(i);
            JMenuItem profesionalRegistradoMenu = new JMenuItem();
            profesionalRegistradoMenu.setText(prof.getPrimerNombre() + " " + prof.getPrimerApellido());
            profesionalRegistradoMenu.setIcon(prof.getFotoPerfil());
            profesionalRegistradoMenu.addMouseListener(new SeleccionPerfiles(profesionalAutenticado, panelSistema, listaMenus));
            menuPefiles.add(profesionalRegistradoMenu);
        }

        return datosProfesional;
    }

    public static void ingresarIngestasUsuarioAutenticado(SistemaAlimentacionSaludable sistema,
            String datosUsuarioAutenticado, ArrayList<String> listaIngestasAlimentos) { //REVISAR LUEGO DE RESPUESTA DE MARTIN!!!

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioRegistrado = sistema.getListaUsuarios().get(i);
            String consultaDatosUsuario = usuarioRegistrado.getPrimerNombre() + " " + usuarioRegistrado.getPrimerApellido();

            if (consultaDatosUsuario.equals(datosUsuarioAutenticado)) {
                for (int j = 0; j < listaIngestasAlimentos.size(); j++) {
                    String ingestaAlimento = listaIngestasAlimentos.get(j);
                    Alimento alimento = new Alimento();
                    alimento.setNombre(ingestaAlimento);
                    usuarioRegistrado.getListaAlimentosIngeridos().add(alimento);
                }
            }
        }
    }

    public static DefaultComboBoxModel cargarComboAlimentos(DefaultComboBoxModel modeloAlimentos,
            SistemaAlimentacionSaludable sistema) {

        DefaultComboBoxModel modeloAlimentosCagado = modeloAlimentos;

        for (int i = 0; i < sistema.getListaAlimentos().size(); i++) {
            Alimento alimentoSistema = sistema.getListaAlimentos().get(i);
            modeloAlimentos.addElement(alimentoSistema.getNombre());
        }

        return modeloAlimentosCagado;
    }

    public static Alimento alimentoDeConsulta(SistemaAlimentacionSaludable sistema, String seleccionAlimento) {

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
            String solicitante = datosUsuario;
            objectConsulta[1] = solicitante;
            String titularConsulta = consulta.getTitularConsulta();
            objectConsulta[2] = titularConsulta;
            String descripcionConsulta = consulta.getDescripcionConsulta();
            objectConsulta[3] = descripcionConsulta;

            String atendidaPorProfesional = "Consulta sin atender";
            if (consulta.getProfesionalRespondeConsulta() != null) {
                Profesional profesionalSistema = consulta.getProfesionalRespondeConsulta();
                atendidaPorProfesional = profesionalSistema.getPrimerNombre() + " " + profesionalSistema.getPrimerApellido();
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

    public static DefaultTableModel cargarJTableConsultasTodosUsuarios(SistemaAlimentacionSaludable sistema,
            DefaultTableModel modeloTablaConsultas) {

        for (int i = 0; i < sistema.getListaUsuarios().size(); i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + usuarioSistema.getPrimerApellido();
            ArrayList<Consulta> consultaUsuarioSistema = usuarioSistema.getListaConsultasRealizadas();

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
                    Profesional profesionalSistema = consulta.getProfesionalRespondeConsulta();
                    atendidaPorProfesional = profesionalSistema.getPrimerNombre() + " " + profesionalSistema.getPrimerApellido();
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

    public static ArrayList<Consulta> buscarUsuarioConsultas(SistemaAlimentacionSaludable sistema, String datosUsuario) {
        ArrayList<Consulta> consultasDeUsuario = new ArrayList<Consulta>();
        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosUsuario.trim())) {
                encontreUsuario = true;
                consultasDeUsuario = usuarioSistema.getListaConsultasRealizadas();
            }
        }

        return consultasDeUsuario;
    }

    public static void limpiarTablaConsultas(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = tabla.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    public static void guardarRespuesta(SistemaAlimentacionSaludable sistema, int idConsulta,
            String respuestaProfesional, String nombreProfesional) {
        boolean consultaEncontrada = false;

        for (int i = 0; i < sistema.getListaConsultas().size() && !consultaEncontrada; i++) {
            Consulta consultaSistema = sistema.getListaConsultas().get(i);
            int idConsultaSistema = consultaSistema.getIdConsulta();

            if (idConsultaSistema == idConsulta) {
                consultaEncontrada = true;
                consultaSistema.setRespuestaConsulta(respuestaProfesional);
                //Buscamos profesional para asociar a la consulta
                Profesional profesionalSistema = buscarProfesionalConsulta(sistema, nombreProfesional);
                consultaSistema.setProfesionalRespondeConsulta(profesionalSistema);
            }
        }
    }

    public static Profesional buscarProfesionalConsulta(SistemaAlimentacionSaludable sistema, String nombreProfesional) {
        Profesional profesionalSistema = null;
        boolean encontreProfesional = false;

        for (int i = 0; i < sistema.getListaProfesionales().size() && !encontreProfesional; i++) {
            Profesional profesional = sistema.getListaProfesionales().get(i);
            String nombreProfesionalSistema = profesional.getPrimerNombre() + " " + profesional.getPrimerApellido();

            if (nombreProfesionalSistema.trim().equals(nombreProfesional.trim())) {
                encontreProfesional = true;
                profesionalSistema = profesional;
            }
        }

        return profesionalSistema;

    }

}
