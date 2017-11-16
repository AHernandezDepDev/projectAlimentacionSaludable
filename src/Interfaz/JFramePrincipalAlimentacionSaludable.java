package Interfaz;

import Dominio.Alimento;
import Dominio.Profesional;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import static Interfaz.InterfazAlimentacionSaludable.cargarProfesionalRegistrado;
import static Interfaz.InterfazAlimentacionSaludable.cargarUsuarioRegistrado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class JFramePrincipalAlimentacionSaludable extends javax.swing.JFrame {

    //Instancio Sistema Alimentacion Saludable
    static SistemaAlimentacionSaludable sistemaAlimentacionSaludable = new SistemaAlimentacionSaludable();
    JInternalFrameRegitroUsuario registroUsuario;
    JInternalFrameRegitroProfesional registroProfesional;
    JInternalFrameRegitroDeAlimento registroAlimento;
    JInternalFrameRegitroDeAlimentoIngeridos registroAlimentoIngerido;
    JInternalFrameConsultaProfesional consultaProfesional;
    JInternalFrameSugerenciaPlanAlimentacion sugerenciaPlanesDeAlimetacion;
    static ArrayList<String> datosUsuariosSistema;
    static String datosUsuarioAutenticado;

    public JFramePrincipalAlimentacionSaludable() {
        initComponents();
        this.setTitle("Alimentación Saludable");
        jDesktopPane1.setBorder(new JDesktopPanelBakground());
        this.setExtendedState(JFramePrincipalAlimentacionSaludable.MAXIMIZED_BOTH);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Imagenes/logoAppImagen.png")));
        MenuScroller.setScrollerFor(jMenu7, 4, 1500, 2, 1);
        //Ocultamos menu de USUARIO/PROFESIONAL AUTENTICADO
        jMenu8.setVisible(false);
        //INICIO DE SISTEMA - PERFIL ADMINISTRADOR 
        jMenu3.setVisible(false);
        jMenu4.setVisible(false);
        jMenu5.setVisible(false);
    }

    public static class SeleccionPerfiles implements MouseListener {

        private JMenu menuAutenticado;
        private ArrayList<JMenu> activarMenuPrincipal;
        private JDesktopPane panelSistema;

        public SeleccionPerfiles(JMenu menuACrearUsuarioAutenticado, JDesktopPane panel,
                ArrayList<JMenu> menuPrincipalSistema) {

            menuAutenticado = menuACrearUsuarioAutenticado;
            activarMenuPrincipal = menuPrincipalSistema;
            panelSistema = panel;
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mousePressed(MouseEvent arg0) {

            //Cerramos ventanas de registros que se encuentren abiertas
            panelSistema.removeAll();
            panelSistema.repaint();

            //Controles sobre activacion de menu principal del sistema
            for (int i = 0; i < activarMenuPrincipal.size(); i++) {
                JMenu menuAActivar = activarMenuPrincipal.get(i);
                menuAActivar.setVisible(true);
            }

            JMenuItem itemPressed = ((JMenuItem) arg0.getSource());
            menuAutenticado.setVisible(true);

            for (int i = 0; i < datosUsuariosSistema.size(); i++) {
                if (datosUsuariosSistema.get(i).equals(itemPressed.getText())) {
                    datosUsuarioAutenticado = datosUsuariosSistema.get(i);
                }
            }

            menuAutenticado.setText(itemPressed.getText() + space(20));
            menuAutenticado.setIcon(itemPressed.getIcon());
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
        }

    }

    public static String space(int cantSpace) {
        String miSpace = "";

        for (int i = 0; i < cantSpace; i++) {
            miSpace = miSpace + " ";
        }

        return miSpace;
    }

    public void menuEnabled() {
        jMenu3.setVisible(true);
        jMenu4.setVisible(true);
        jMenu5.setVisible(true);
    }

    public void menuDisabled() {
        jMenu3.setVisible(false);
        jMenu4.setVisible(false);
        jMenu5.setVisible(false);
    }

    public ArrayList<JMenu> listaMenuParametros() {

        ArrayList<JMenu> menusPrincipales = new ArrayList<JMenu>();
        menusPrincipales.add(jMenu3);
        menusPrincipales.add(jMenu4);
        menusPrincipales.add(jMenu5);

        return menusPrincipales;
    }

    /* 
     **********************************************************************
     ********************** CREACION DATOS DE PRUEBA **********************
     **********************************************************************
     */
    public static void crearDatosPruebaSistema(Usuario usuarioA, Profesional profesionalA,
            Alimento alimentoA, SistemaAlimentacionSaludable sistema) {

        //USUARIO A
        usuarioA.setPrimerNombre("André");
        usuarioA.setPrimerApellido("Hernández");
        ImageIcon noPerfilUsuario = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        usuarioA.setFotoPerfil(noPerfilUsuario);
        sistema.agregarRegistroUsuario(usuarioA);

        //PROFESIONAL A
        profesionalA.setPrimerNombre("Jorge");
        profesionalA.setPrimerApellido("Armando");
        profesionalA.setNombreTituloProfesional("Licenciado en Nutrición");
        profesionalA.setPaisObtuvoTitulo("Uruguay");
        ImageIcon noPerfilProfesional = new ImageIcon("src/Imagenes/noPerfilImagen.png");
        profesionalA.setFotoPerfil(noPerfilProfesional);
        sistema.agregarRegistroProfesional(profesionalA);

        //ALIMENTO A
        alimentoA.setNombre("Pera");
        alimentoA.setTipo("Fruta");
        alimentoA.setPorcion(32);
        sistema.agregarRegistroAlimento(alimentoA);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rolUsuarioImagen.png"))); // NOI18N
        jMenu1.setText("Rol del Sistema ");
        jMenu1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adminImagen.png"))); // NOI18N
        jMenuItem12.setText("Administrador");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroUsuarioImagen.png"))); // NOI18N
        jMenuItem1.setText("Usuario ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroProfesionalImagen.png"))); // NOI18N
        jMenuItem2.setText("Profesional");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adminImagen.png"))); // NOI18N
        jMenu7.setText(" ADMINISTRADOR");
        jMenu7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jMenu7.setMargin(new java.awt.Insets(0, 40, 0, 40));
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu7MouseExited(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setBackground(new java.awt.Color(255, 204, 102));
        jMenu8.setForeground(new java.awt.Color(255, 0, 0));
        jMenu8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15)); // NOI18N
        jMenuBar1.add(jMenu8);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroImagen.png"))); // NOI18N
        jMenu2.setText("Registro ");
        jMenu2.setActionCommand("Registro");
        jMenu2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(0, 40, 0, 0));

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroUsuarioImagen.png"))); // NOI18N
        jMenuItem6.setText("Registrar Usuario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroProfesionalImagen.png"))); // NOI18N
        jMenuItem8.setText("Registrar Profesional");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ingestaImagen.png"))); // NOI18N
        jMenu3.setText("Alimento");
        jMenu3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(0, 40, 0, 0));

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registroAlimentoImagen.png"))); // NOI18N
        jMenuItem9.setText("Registrar Alimento");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alimentosIngeridosImagen.png"))); // NOI18N
        jMenuItem5.setText("Alimentos Ingeridos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/directaProfesionalesImagen.png"))); // NOI18N
        jMenu4.setText("Consulta");
        jMenu4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(0, 40, 0, 0));

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevaConsultaImagen.png"))); // NOI18N
        jMenuItem4.setText("Consulta con Profesional");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/responderConsultaImagen.png"))); // NOI18N
        jMenuItem7.setText("Consultas de Usuarios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/planAlimentacionImagen.png"))); // NOI18N
        jMenu5.setText("Plan de Alimentación");
        jMenu5.setActionCommand("Se");
        jMenu5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jMenu5.setMargin(new java.awt.Insets(0, 40, 0, 0));

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sugerenciaPAImagen.png"))); // NOI18N
        jMenuItem3.setText("Sugerencia de Plan de Alimentación");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crearPlanAlimentacionImagen.png"))); // NOI18N
        jMenuItem11.setText("Crear Plan de Alimentación");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salirImagen.png"))); // NOI18N
        jMenu6.setText("Salir");
        jMenu6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(0, 40, 0, 0));

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/singOutImagen.png"))); // NOI18N
        jMenuItem10.setText("Salir de Alimentación Saludable");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Ocultamos menu de USUARIO/PROFESIONAL AUTENTICADO
        jMenu8.setVisible(false);

        if (sistemaAlimentacionSaludable.getListaUsuarios().size() >= 1) {

            //Se deshabilita menu hasta que no haya seleccion de Usuario
            menuDisabled();

            jMenu7.setText(" USUARIO ");
            jMenu7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/registroUsuarioImagen.png")));

            jMenuItem6.setVisible(true);
            jMenuItem8.setVisible(false);
            jMenuItem9.setVisible(true);
            jMenuItem5.setVisible(true);
            jMenuItem4.setVisible(true);
            jMenuItem7.setVisible(false);
            jMenuItem3.setVisible(true);
            jMenuItem11.setVisible(false);

            jMenu2.setVisible(false);

            //Se agrega el Usuario Registrado al Menú de Usuarios Registrados para tener 
            //su propio pérfil de Usuario
            jMenu7.removeAll();
            datosUsuariosSistema = cargarUsuarioRegistrado(sistemaAlimentacionSaludable, jMenu7,
                    jMenu8, jDesktopPane1, listaMenuParametros());

            //Se da reset al jDesktopPane contendor principal
            //por si quedan funcionalidades levantadas de otros perfiles
            //no correspondientes a el de USUARIO
            if (jMenu7.getText().equals(" USUARIO ")) {
                jDesktopPane1.removeAll();
                jDesktopPane1.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen USUARIOS REGISTRADOS en el Sistema por lo que "
                    + "no se puede acceder a el perfil USUARIO. \nDebe realizar el registro de USUARIO "
                    + "con perfil ADMINISTRADOR",
                    "Alimentacion Saludable", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        //Ocultamos menu de USUARIO/PROFESIONAL AUTENTICADO
        jMenu8.setVisible(false);

        if (sistemaAlimentacionSaludable.getListaProfesionales().size() >= 1) {

            //Se deshabilita menu hasta que no haya seleccion de Profesional
            menuDisabled();

            jMenu7.setText(" PROFESIONAL ");
            jMenu7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/registroProfesionalImagen.png")));

            jMenuItem8.setVisible(true);
            jMenuItem6.setVisible(false);
            jMenuItem9.setVisible(true);
            jMenuItem5.setVisible(false);
            jMenuItem5.setVisible(false);
            jMenuItem7.setVisible(true);
            jMenuItem3.setVisible(false);
            jMenuItem11.setVisible(true);
            jMenuItem4.setVisible(false);

            jMenu2.setVisible(false);

            //Se agrega el Profesional Registrado al Menú de Profesionales Registrados para tener 
            //su propio pérfil de Profesional
            jMenu7.removeAll();
            datosUsuariosSistema = cargarProfesionalRegistrado(sistemaAlimentacionSaludable, jMenu7,
                    jMenu8, jDesktopPane1, listaMenuParametros());

            //Se da reset al jDesktopPane contendor principal
            //por si quedan funcionalidades levantadas de otros perfiles
            //no correspondientes a el de PROFESIONAL
            if (jMenu7.getText().equals(" PROFESIONAL ")) {
                jDesktopPane1.removeAll();
                jDesktopPane1.repaint();
                //Ocultamos menu de USUARIO/PROFESIONAL AUTENTICADO
                jMenu8.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen PROFESIONALES REGISTRADOS en el Sistema por lo que "
                    + "no se puede acceder a el perfil PROFESIONAL. \nDebe realizar el registro de PROFESIONAL "
                    + "con perfil ADMINISTRADOR",
                    "Alimentacion Saludable", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        consultaProfesional = new JInternalFrameConsultaProfesional(sistemaAlimentacionSaludable, jMenu7, jMenu8);
        jDesktopPane1.add(consultaProfesional);
        consultaProfesional.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        registroUsuario = new JInternalFrameRegitroUsuario(jMenu7, sistemaAlimentacionSaludable);
        jDesktopPane1.add(registroUsuario);
        registroUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        //SALIR
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea salir de Aplicacion Saludable?",
                "Aplicacion Saludable", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eleccion == 0) {
            dispose();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sugerenciaPlanesDeAlimetacion = new JInternalFrameSugerenciaPlanAlimentacion(sistemaAlimentacionSaludable, 
                jMenu7, jMenu8);
        jDesktopPane1.add(sugerenciaPlanesDeAlimetacion);
        sugerenciaPlanesDeAlimetacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sugerenciaPlanesDeAlimetacion = new JInternalFrameSugerenciaPlanAlimentacion(sistemaAlimentacionSaludable,
                jMenu7, jMenu8);
        jDesktopPane1.add(sugerenciaPlanesDeAlimetacion);
        sugerenciaPlanesDeAlimetacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        registroProfesional = new JInternalFrameRegitroProfesional(sistemaAlimentacionSaludable);
        jDesktopPane1.add(registroProfesional);
        registroProfesional.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        registroAlimento = new JInternalFrameRegitroDeAlimento(sistemaAlimentacionSaludable);
        jDesktopPane1.add(registroAlimento);
        registroAlimento.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        registroAlimentoIngerido = new JInternalFrameRegitroDeAlimentoIngeridos(sistemaAlimentacionSaludable,
                jMenu8, datosUsuarioAutenticado);
        jDesktopPane1.add(registroAlimentoIngerido);
        registroAlimentoIngerido.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //Menu Administrador
        menuDisabled();

        jMenu7.setText(" ADMINISTRADOR ");
        jMenu7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/adminImagen.png")));

        jMenuItem6.setVisible(true);
        jMenuItem8.setVisible(true);
        jMenuItem9.setVisible(true);
        jMenuItem7.setVisible(true);
        jMenuItem11.setVisible(true);

        jMenu2.setVisible(true);

        //Ocultamos menu de USUARIO/PROFESIONAL AUTENTICADO
        jMenu8.setVisible(false);

        //Se da reset al jDesktopPane contendor principal
        if (jMenu7.getText().equals(" ADMINISTRADOR ")) {
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jMenu8.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseEntered
        if (jMenu7.getText().equals(" ADMINISTRADOR ")) {
            jMenu7.setEnabled(false);
            jMenu7.removeAll();
        }
    }//GEN-LAST:event_jMenu7MouseEntered

    private void jMenu7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseExited
        if (jMenu7.getText().equals(" ADMINISTRADOR ")) {
            jMenu7.setEnabled(true);
        }
    }//GEN-LAST:event_jMenu7MouseExited

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        if (jMenu7.getText().equals(" ADMINISTRADOR ")) {
            jMenu7.setEnabled(false);
        }
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        consultaProfesional = new JInternalFrameConsultaProfesional(sistemaAlimentacionSaludable, jMenu7, jMenu8);
        jDesktopPane1.add(consultaProfesional);
        consultaProfesional.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new JFramePrincipalAlimentacionSaludable().setVisible(true);

                Usuario u = new Usuario();
                Profesional p = new Profesional();
                Alimento a = new Alimento();

                crearDatosPruebaSistema(u, p, a, sistemaAlimentacionSaludable);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
