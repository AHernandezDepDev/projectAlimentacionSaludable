package Interfaz;

import Dominio.Alimento;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import Interfaz.JFramePrincipalAlimentacionSaludable.SeleccionUsuarios;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        rutaFoto = MyFileChooser.getSelectedFile().getAbsolutePath();

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

    public static void borrarModeloJList(JList listaABorrar, DefaultListModel modelo) {
        int sizeDelModel = modelo.getSize();
        for (int i = 0; i < sizeDelModel; i++) {
            modelo.remove(modelo.getSize() - 1);
        }
        listaABorrar.setModel(modelo);
    }

    public static void cargarUsuarioRegistrado(ArrayList<Usuario> listaUsuarios, JMenu menuPefiles, 
            JMenu usuarioAutenticado, JMenuBar menuBarSistema) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario user = listaUsuarios.get(i);
            JMenuItem usuarioRegistradoMenu = new JMenuItem();
            usuarioRegistradoMenu.setText(user.getPrimerNombre() + " " + user.getPrimerNombre());
            usuarioRegistradoMenu.setIcon(user.getFotoPerfil());
            usuarioRegistradoMenu.addMouseListener(new SeleccionUsuarios(usuarioAutenticado, menuBarSistema));
            menuPefiles.add(usuarioRegistradoMenu);
        }
    }

    public static void cargarProfesionalRegistrado(ArrayList<Profesional> listaProfesional, JMenu menuPefiles) {
        for (int i = 0; i < listaProfesional.size(); i++) {
            Profesional prof = listaProfesional.get(i);
            JMenuItem profesionalRegistradoMenu = new JMenuItem();
            profesionalRegistradoMenu.setText(prof.getPrimerNombre() + " " + prof.getPrimerNombre());
            profesionalRegistradoMenu.setIcon(prof.getFotoPerfil());
            menuPefiles.add(profesionalRegistradoMenu);
        }
    }

}
