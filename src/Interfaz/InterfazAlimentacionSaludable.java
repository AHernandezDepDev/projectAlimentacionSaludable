package Interfaz;

import Dominio.Alimento;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class InterfazAlimentacionSaludable {

    //JFileChooser
    public static String creacionJFileChooser(JInternalFrame JInternalFrame) {
        String rutaFoto;

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

    public static boolean agregarAListaUsuarioRegistrado(SistemaAlimentacionSaludable sistema, Usuario usuarioARegistrar) {
        boolean usuarioARegistrarExiste = true;
        if (!sistema.getListaUsuarios().contains(usuarioARegistrar)) {
            sistema.agregarRegistroUsuario(usuarioARegistrar);
        } else {
            usuarioARegistrarExiste = false;
        }
        return usuarioARegistrarExiste;
    }

    public static boolean agregarAListaProfesionalRegistrado(SistemaAlimentacionSaludable sistema, Profesional usuarioAProfesional) {
        boolean profesionalARegistrarExiste = true;
        if (!sistema.getListaProfesionales().contains(usuarioAProfesional)) {
            sistema.agregarRegistroProfesional(usuarioAProfesional);
        } else {
            profesionalARegistrarExiste = false;
        }
        return profesionalARegistrarExiste;
    }

     public static boolean agregarAListaAlimentoRegistrado(SistemaAlimentacionSaludable sistema, Alimento alimentoARegistrar) {
        boolean alimentoARegistrarExiste = true;
        if (!sistema.getListaAlimentos().contains(alimentoARegistrar)) {
            sistema.agregarRegistroAlimento(alimentoARegistrar);
        } else {
            alimentoARegistrarExiste = false;
        }
        return alimentoARegistrarExiste;
    }
     
    public static void borrarModeloJList(JList listaABorrar, DefaultListModel modelo) {
        int sizeDelModel = modelo.getSize();
        for (int i = 0; i < sizeDelModel; i++) {
            modelo.remove(modelo.getSize() - 1);
        }
        listaABorrar.setModel(modelo);
    }
    
    
}
