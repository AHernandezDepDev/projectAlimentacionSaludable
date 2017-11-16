package Interfaz;

import Dominio.Alimento;
import Dominio.Ingesta;
import Dominio.PlanAlimentacion;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionRegistrado;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionUsuario;
import static Interfaz.InterfazAlimentacionSaludable.buscarUsuario;
import static Interfaz.InterfazAlimentacionSaludable.cargarJListRegistro;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTablePlanesAlimentacionTodosUsuarios;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTablePlanesDeAlimentacion;
import static Interfaz.InterfazAlimentacionSaludable.guardarElavoracionPlanAlimentacion;
import static Interfaz.InterfazAlimentacionSaludable.infoPlanAlimentacionLunesAJueves;
import static Interfaz.InterfazAlimentacionSaludable.infoPlanAlimentacionViernesADomingo;
import static Interfaz.InterfazAlimentacionSaludable.limpiarTablaConsultas;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class JInternalFrameSugerenciaPlanAlimentacion extends javax.swing.JInternalFrame {

    SistemaAlimentacionSaludable sistema;
    JMenu menuAutenticado;
    JMenu infoUsuarioAutenticado;
    int valorIDPlanAlimentacionClickeado = 0;

    DefaultTableModel modeloTablaPlanesDeAlimentacion = new DefaultTableModel();

    //Modelo de listas preferencias, restricciones y alimientos ingeridos
    DefaultListModel modeloListaPreferencias = new DefaultListModel();
    DefaultListModel modeloListaRestricciones = new DefaultListModel();
    DefaultListModel modeloListaAlimentosIngeridos = new DefaultListModel();

    //Modelos de Listas por dia - Alimentos Ingeridos
    DefaultListModel modeloAlimentosIngeridosLunes = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosMartes = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosMiercoles = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosJueves = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosViernes = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosSabado = new DefaultListModel();
    DefaultListModel modeloAlimentosIngeridosDomingo = new DefaultListModel();

    public JInternalFrameSugerenciaPlanAlimentacion(SistemaAlimentacionSaludable sistemaAlimentacionSaludable,
            JMenu munuAutenticadoSistema, JMenu menuInfoUsuario) {

        sistema = sistemaAlimentacionSaludable;
        menuAutenticado = munuAutenticadoSistema;
        infoUsuarioAutenticado = menuInfoUsuario;
        initComponents();
        this.setTitle(" Sugerencia de Planes de Alimentación Pofesional ");
        eventoTablaPlanesDeAlimentacion(jTable1, sistema);

        if (menuAutenticado.getText().equals(" USUARIO ")) {
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jPanel13.setVisible(false);
            jPanel5.setVisible(true);

            //Para el Usuario las respuesta de los Profesionales
            //al momento de responder su solicitud de Plan de Alimentacion
            //no pueden ser editables.
            jTextPane2.setEnabled(false);
            jTextPane3.setEnabled(false);
            jTextPane4.setEnabled(false);
            jTextPane5.setEnabled(false);
            jTextPane6.setEnabled(false);
            jTextPane7.setEnabled(false);
            jTextPane8.setEnabled(false);

            //Al iniciar el sistema cagamos los Planes de Alimentacion
            //solicitados por Usuarios y formulados por Profesionales
            limpiarTablaConsultas(jTable1);
            modeloTablaPlanesDeAlimentacion = cargarJTablePlanesDeAlimentacion(sistema,
                    (DefaultTableModel) jTable1.getModel(), infoUsuarioAutenticado.getText());
            jTable1.setModel(modeloTablaPlanesDeAlimentacion);
        }

        if (menuAutenticado.getText().equals(" PROFESIONAL ")) {
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jPanel13.setVisible(true);
            jPanel5.setVisible(false);

            //Habilitamos para que los Profesionales
            //puedan elvorar con detalle el Plan de Alimentacion
            jTextPane2.setEnabled(true);
            jTextPane3.setEnabled(true);
            jTextPane4.setEnabled(true);
            jTextPane5.setEnabled(true);
            jTextPane6.setEnabled(true);
            jTextPane7.setEnabled(true);
            jTextPane8.setEnabled(true);

            //Al iniciar el sistema cagamos los Planes de Alimentacion
            //solicitados por Usuarios y formulados por Profesionales
            limpiarTablaConsultas(jTable1);
            modeloTablaPlanesDeAlimentacion = cargarJTablePlanesAlimentacionTodosUsuarios(sistema,
                    (DefaultTableModel) jTable1.getModel());
            jTable1.setModel(modeloTablaPlanesDeAlimentacion);
        }
    }

    public int tomarUltimoValorContador() {
        int maxId = 0;

        for (int i = 0; i < sistema.getListaPlanesDeAlimentacion().size(); i++) {
            PlanAlimentacion planAlimentacionSistema = sistema.getListaPlanesDeAlimentacion().get(i);
            int idConsulta = planAlimentacionSistema.getIdPlanAlimentacion();

            if (idConsulta > maxId) {
                maxId = idConsulta;
            }
        }

        return maxId;
    }

    public void cargarJListUsuario(String datosSolicitante, String segunDatosUsuario) {

        boolean encontreUsuario = false;

        for (int i = 0; i < sistema.getListaUsuarios().size() && !encontreUsuario; i++) {
            Usuario usuarioSistema = sistema.getListaUsuarios().get(i);
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosSolicitante.trim())) {
                encontreUsuario = true;

                if (segunDatosUsuario.endsWith("PREFERENCIAS")) {
                    ArrayList<String> listaPreferencias = usuarioSistema.getListaPreferencias();
                    modeloListaPreferencias = cargarModeloPreferenciasRestricciones(listaPreferencias);
                    jList1.setModel(modeloListaPreferencias);
                } else {
                    ArrayList<String> listaRestricciones = usuarioSistema.getListaRestricciones();
                    modeloListaRestricciones = cargarModeloPreferenciasRestricciones(listaRestricciones);;
                    jList2.setModel(modeloListaRestricciones);
                }
            }
        }

    }

    public DefaultListModel cargarModeloPreferenciasRestricciones(ArrayList<String> datosUsuarioPreferenciasRestricciones) {
        DefaultListModel modelo = new DefaultListModel();

        for (int i = 0; i < datosUsuarioPreferenciasRestricciones.size(); i++) {
            String datosListaUsuario = datosUsuarioPreferenciasRestricciones.get(i);
            modelo.addElement(datosListaUsuario.toString());
        }

        return modelo;
    }

    public void borrarModeloJList(JList listaABorrar, DefaultListModel modelo) {
        int sizeDelModel = modelo.getSize();

        for (int i = 0; i < sizeDelModel; i++) {
            modelo.remove(modelo.getSize() - 1);
        }
        listaABorrar.setModel(modelo);
    }

    public void cargarInfoIngestasUsuarios(Usuario usuarioConsultado) {

        ArrayList<Ingesta> listaIngestas = usuarioConsultado.getListaAlimentosIngeridos();

        for (int i = 0; i < listaIngestas.size(); i++) {
            Ingesta ingestaSistema = listaIngestas.get(i);
            Alimento alimentoIngerido = ingestaSistema.getAlimentoIngerido();
            String diaIngesa = ingestaSistema.getDiaIngesta();

            switch (diaIngesa) {
                case "Lunes":
                    cargarJListRegistro(jList3, alimentoIngerido.getNombre(), modeloAlimentosIngeridosLunes);
                    break;
                case "Martes":
                    cargarJListRegistro(jList4, alimentoIngerido.getNombre(), modeloAlimentosIngeridosMartes);
                    break;
                case "Miercoles":
                    cargarJListRegistro(jList5, alimentoIngerido.getNombre(), modeloAlimentosIngeridosMiercoles);
                    break;
                case "Jueves":
                    cargarJListRegistro(jList6, alimentoIngerido.getNombre(), modeloAlimentosIngeridosJueves);
                    break;
                case "Viernes":
                    cargarJListRegistro(jList7, alimentoIngerido.getNombre(), modeloAlimentosIngeridosViernes);
                    break;
                case "Sabado":
                    cargarJListRegistro(jList8, alimentoIngerido.getNombre(), modeloAlimentosIngeridosSabado);
                    break;
                case "Domingo":
                    cargarJListRegistro(jList9, alimentoIngerido.getNombre(), modeloAlimentosIngeridosDomingo);
                    break;
            }
        }
    }

    public PlanAlimentacion buscarPlanDeAlimentacionClickeado(SistemaAlimentacionSaludable sistema,
            int idClickPlanDeAlimentacion) {

        PlanAlimentacion planAlimentacionClickeado = null;
        boolean encontroPlanDeAlimentacion = false;

        for (int i = 0; i < sistema.getListaPlanesDeAlimentacion().size() && !encontroPlanDeAlimentacion; i++) {
            PlanAlimentacion planAlimentacionSistema = sistema.getListaPlanesDeAlimentacion().get(i);
            int idPlanDeAlimentacionSistema = planAlimentacionSistema.getIdPlanAlimentacion();

            if (idPlanDeAlimentacionSistema == idClickPlanDeAlimentacion) {
                planAlimentacionClickeado = planAlimentacionSistema;
            }
        }

        return planAlimentacionClickeado;
    }

    public void cargarDetallePlanAlimentacionLunesAJueves(String sugerenciaLunes, String sugerenciaMartes,
            String sugerenciaMiercoles, String sugerenciaJueves) {

        jTextPane2.setText(sugerenciaLunes);
        jTextPane3.setText(sugerenciaMartes);
        jTextPane4.setText(sugerenciaMiercoles);
        jTextPane5.setText(sugerenciaJueves);
    }

    public void cargarDetallePlanAlimentacionViernesADomingo(String sugerenciaViernes, String sugerenciaSabado,
            String sugerenciaDomingo) {

        jTextPane6.setText(sugerenciaViernes);
        jTextPane7.setText(sugerenciaSabado);
        jTextPane8.setText(sugerenciaDomingo);
    }

    public void eventoTablaPlanesDeAlimentacion(final JTable tablaPlanesAlimetacion,
            final SistemaAlimentacionSaludable sistema) {
        tablaPlanesAlimetacion.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Object idPlanAlimentacion = tablaPlanesAlimetacion.getValueAt(tablaPlanesAlimetacion.getSelectedRow(), 0);
                valorIDPlanAlimentacionClickeado = (int) idPlanAlimentacion;

                //Buscamos el plan de Alimentacion y la cargamos en Detalles
                PlanAlimentacion planDeAlimentacionDetalles = buscarPlanDeAlimentacionClickeado(sistema,
                        valorIDPlanAlimentacionClickeado);

                Usuario solicitante = planDeAlimentacionDetalles.getSolicitante();
                String datosSolicitante = solicitante.getPrimerNombre() + " " + solicitante.getPrimerApellido();

                String sugerenciaLunes = planDeAlimentacionDetalles.getListaConsejosLunes();
                String sugerenciaMartes = planDeAlimentacionDetalles.getListaConsejosMartes();
                String sugerenciaMiercoles = planDeAlimentacionDetalles.getListaConsejosMiercoles();
                String sugerenciaJueves = planDeAlimentacionDetalles.getListaConsejosJueves();
                String sugerenciaViernes = planDeAlimentacionDetalles.getListaConsejosViernes();
                String sugerenciaSabado = planDeAlimentacionDetalles.getListaConsejosSabado();
                String sugerenciaDomingo = planDeAlimentacionDetalles.getListaConsejosDomingo();

                cargarDetallePlanAlimentacionLunesAJueves(sugerenciaLunes, sugerenciaMartes,
                        sugerenciaMiercoles, sugerenciaJueves);

                cargarDetallePlanAlimentacionViernesADomingo(sugerenciaViernes, sugerenciaSabado,
                        sugerenciaDomingo);

                //Buscamos lista de preferencias, restricciones y alimentos ingeridos y cargamos
                borrarModeloJList(jList1, modeloListaPreferencias);
                borrarModeloJList(jList2, modeloListaRestricciones);
                cargarJListUsuario(datosSolicitante, "PREFERENCIAS");
                cargarJListUsuario(datosSolicitante, "RESTRICCIONES");
                cargarInfoIngestasUsuarios(solicitante);
            }
        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Historial de Planes de Alimentación");
        jPanel1.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Solicitante", "Sugerido por Profesional", "Observaciones", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(249, 220, 220));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Información de Usuario");

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Preferencias"));

        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Restricciones"));

        jScrollPane7.setViewportView(jList2);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Alimentos Ingeridos"));

        jScrollPane8.setViewportView(jList3);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Lunes", jPanel23);

        jScrollPane9.setViewportView(jList4);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Martes", jPanel24);

        jScrollPane10.setViewportView(jList5);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Miercoles", jPanel25);

        jScrollPane11.setViewportView(jList6);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Jueves", jPanel26);

        jScrollPane12.setViewportView(jList7);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Viernes", jPanel14);

        jScrollPane13.setViewportView(jList8);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Sabado", jPanel15);

        jScrollPane14.setViewportView(jList9);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Domingo", jPanel16);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3)
                .addGap(21, 21, 21))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3))
                .addContainerGap())
        );

        jPanel1.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Detalle de Planes de Alimentación");
        jLabel10.setToolTipText("");

        jButton2.setText("Guardar Respuesta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar Respuesta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Lunes      ", jPanel4);

        jScrollPane5.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Martes     ", jPanel6);

        jScrollPane6.setViewportView(jTextPane4);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Miercoles     ", jPanel8);

        jScrollPane15.setViewportView(jTextPane5);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Jueves     ", jPanel9);

        jScrollPane16.setViewportView(jTextPane6);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Viernes     ", jPanel10);

        jScrollPane17.setViewportView(jTextPane7);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Sabado     ", jPanel11);

        jScrollPane18.setViewportView(jTextPane8);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Domingo     ", jPanel12);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("     Martes     ");

        jPanel3.add(jPanel7);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 243));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Solicitar Nuevo Plan de Alimentación");

        jButton1.setText("Solicitar Plan de Alimentación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Observaciónes:");

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel13))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 144, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardarElavoracionPlanAlimentacion(sistema, valorIDPlanAlimentacionClickeado,
                infoPlanAlimentacionLunesAJueves(jTextPane2.getText(), jTextPane3.getText(),
                        jTextPane4.getText(), jTextPane5.getText()),
                infoPlanAlimentacionViernesADomingo(jTextPane6.getText(), jTextPane7.getText(), jTextPane8.getText()),
                infoUsuarioAutenticado.getText());

        jTextPane2.setEnabled(false);
        jTextPane3.setEnabled(false);
        jTextPane4.setEnabled(false);
        jTextPane5.setEnabled(false);
        jTextPane6.setEnabled(false);
        jTextPane7.setEnabled(false);
        jTextPane8.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Habilitamos para que los Profesionales
        //puedan elvorar con detalle el Plan de Alimentacion
        jTextPane2.setEnabled(true);
        jTextPane3.setEnabled(true);
        jTextPane4.setEnabled(true);
        jTextPane5.setEnabled(true);
        jTextPane6.setEnabled(true);
        jTextPane7.setEnabled(true);
        jTextPane8.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se realiza un control para que no se pueda ingresar una nota vacia
        if (!jTextPane1.getText().equals("")) {

            PlanAlimentacion planDeAlimentacion = new PlanAlimentacion();

            planDeAlimentacion.setObservaciones(jTextPane1.getText());
            planDeAlimentacion.setSolicitante(buscarUsuario(sistema, infoUsuarioAutenticado.getText()));

            //Seteamos el contador de ID-PLANdeALIMENTACION
            int proximoIDPlanAlimentacion = tomarUltimoValorContador() + 1;
            planDeAlimentacion.setIdPlanAlimentacion(proximoIDPlanAlimentacion);

            //Agregar Solicitud de Plan de Alimentacion al SISTEMA
            agregarAListaPlanDeAlimentacionRegistrado(sistema, planDeAlimentacion);
            //Agregar Plan de Alimentacion al USUARIO que lo solicita
            agregarAListaPlanDeAlimentacionUsuario(sistema, planDeAlimentacion, infoUsuarioAutenticado.getText());

            //Refrescamos para proxima solicitud de creacion de Plan de Alimentacion
            jTextPane1.setText("");

            //Cargamos JTable con Consultas ingresadas
            limpiarTablaConsultas(jTable1);
            modeloTablaPlanesDeAlimentacion = cargarJTablePlanesDeAlimentacion(sistema,
                    (DefaultTableModel) jTable1.getModel(), infoUsuarioAutenticado.getText());
            jTable1.setModel(modeloTablaPlanesDeAlimentacion);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JList<String> jList8;
    private javax.swing.JList<String> jList9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    // End of variables declaration//GEN-END:variables
}
