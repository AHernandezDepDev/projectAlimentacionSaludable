package Interfaz;

import Dominio.Alimento;
import Dominio.Consulta;
import Dominio.Ingesta;
import Dominio.SistemaAlimentacionSaludable;
import Dominio.Usuario;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaConsultaRegistrada;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaConsultaUsuario;
import static Interfaz.InterfazAlimentacionSaludable.alimentoDeConsulta;
import static Interfaz.InterfazAlimentacionSaludable.buscarUsuario;
import static Interfaz.InterfazAlimentacionSaludable.buscarUsuarioIngestas;
import static Interfaz.InterfazAlimentacionSaludable.cargarComboAlimentos;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTableConsultas;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTableConsultasTodosUsuarios;
import static Interfaz.InterfazAlimentacionSaludable.guardarRespuesta;
import static Interfaz.InterfazAlimentacionSaludable.limpiarTablaConsultas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE JInternalFrameConsultaProfesional
 * 21/11/2017
 */
public class JInternalFrameConsultaProfesional extends javax.swing.JInternalFrame {

    private final SistemaAlimentacionSaludable sistema;
    private final DefaultComboBoxModel modeloComboAlimentos = new DefaultComboBoxModel();
    private DefaultTableModel modeloTablaConsultas = new DefaultTableModel();
    private final Border campoUsuarioConsultas;

    //Modelo de listas preferencias, restricciones y alimientos ingeridos
    private DefaultListModel modeloListaPreferencias = new DefaultListModel();
    private DefaultListModel modeloListaRestricciones = new DefaultListModel();
    private final DefaultListModel modeloListaAlimentosIngeridos = new DefaultListModel();

    //Modelos de Tabla para cargar Ingestas de Usuario
    private DefaultTableModel modeloAlimentosIngeridos = new DefaultTableModel();

    private int valorIDConsultaClickeado = 0;
    private final int cantidadConsultasUsuario = 0;
    private final JMenu menuUSUARIO;
    private final JMenu infoMenuUSUARIO;
    private final JDesktopPane panelAplicacionSaludable;

    public JInternalFrameConsultaProfesional(SistemaAlimentacionSaludable sistemaAlimentacionSaludable,
            JMenu menuUsuario, JMenu infoMenuUsuario, JDesktopPane panelSistema) {
        sistema = sistemaAlimentacionSaludable;
        menuUSUARIO = menuUsuario;
        infoMenuUSUARIO = infoMenuUsuario;
        panelAplicacionSaludable = panelSistema;
        initComponents();
        iniciarCombo();
        this.setTitle(" Consulta Profesionales ");
        eventoTablaConsultas(jTable1, sistema);

        //Borde de los campos de ingreso de datos para el Usuario
        campoUsuarioConsultas = jTextField1.getBorder();

        if (menuUsuario.getText().trim().equals("Usuario")) {
            jTextPane4.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jPanel5.setVisible(true);
            jPanel4.setVisible(false);

            //Al iniciar el sistema cagamos las 
            //consultas realizadas previamente por el Usuarios autenticado
            limpiarTablaConsultas(jTable1);
            modeloTablaConsultas = cargarJTableConsultas(sistema, 
                    (DefaultTableModel) jTable1.getModel(), infoMenuUSUARIO.getText());
            jTable1.setModel(modeloTablaConsultas);
        }

        if (menuUsuario.getText().trim().equals("Profesional")) {
            jTextField2.setText(infoMenuUsuario.getText());
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jPanel5.setVisible(false);
            jPanel4.setVisible(true);

            //Al iniciar el sistema cagamos todas las consultas 
            //realizadas previamente por los Usuarios
            limpiarTablaConsultas(jTable1);
            modeloTablaConsultas = cargarJTableConsultasTodosUsuarios(sistema, 
                    (DefaultTableModel) jTable1.getModel());
            jTable1.setModel(modeloTablaConsultas);
        }
    }

    public void iniciarCombo() {
        DefaultComboBoxModel modeloAlimentos = 
                cargarComboAlimentos(modeloComboAlimentos, sistema);
        jComboBox1.setModel(modeloAlimentos);
    }

    public int tomarUltimoValorContador() {
        int maxId = 0;

        for (int i = 0; i < sistema.getListaConsultas().size(); i++) {
            Consulta consulta = sistema.getListaConsultas().get(i);
            int idConsulta = consulta.getIdConsulta();

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
            String datosUsuarioSistema = usuarioSistema.getPrimerNombre() + " " + 
                    usuarioSistema.getPrimerApellido();

            if (datosUsuarioSistema.trim().equals(datosSolicitante.trim())) {
                encontreUsuario = true;

                if (segunDatosUsuario.endsWith("PREFERENCIAS")) {
                    ArrayList<String> listaPreferencias = 
                            usuarioSistema.getListaPreferencias();
                    modeloListaPreferencias = 
                            cargarModeloPreferenciasRestricciones(listaPreferencias);
                    jList1.setModel(modeloListaPreferencias);
                } else {
                    ArrayList<String> listaRestricciones = 
                            usuarioSistema.getListaRestricciones();
                    modeloListaRestricciones = 
                            cargarModeloPreferenciasRestricciones(listaRestricciones);;
                    jList2.setModel(modeloListaRestricciones);
                }
            }
        }

    }


    public DefaultListModel cargarModeloPreferenciasRestricciones(
            ArrayList<String> datosUsuarioPreferenciasRestricciones) {
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

    public void eventoTablaConsultas(final JTable tablaConsultas, 
            final SistemaAlimentacionSaludable sistema) {
        tablaConsultas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Object valorIDConsulta = tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 0);
                valorIDConsultaClickeado = (int) valorIDConsulta;

                //Buscamos la consulta y la cargamos en Detalles
                Consulta consultaAVerDetalles = buscarConsultaClickeada(sistema, 
                        valorIDConsultaClickeado);

                Usuario solicitante = consultaAVerDetalles.getSolcitante();
                String datosSolicitante = solicitante.getPrimerNombre() + " " + 
                        solicitante.getPrimerApellido();

                String titularConsulta = consultaAVerDetalles.getTitularConsulta();
                String descripcionConsulta = consultaAVerDetalles.getDescripcionConsulta();
                String atendidaPorProfesional = "Consulta sin atender";
                String respuestaConsulta = "Sin respuesta Profesional";

                if (consultaAVerDetalles.getProfesionalRespondeConsulta() != null) {
                    atendidaPorProfesional = consultaAVerDetalles.getProfesionalRespondeConsulta().getPrimerNombre() + " "
                            + consultaAVerDetalles.getProfesionalRespondeConsulta().getPrimerApellido();
                }

                String alimentoConsultado = consultaAVerDetalles.getAlimentoConsultado().getNombre();

                if (consultaAVerDetalles.getRespuestaConsulta() != null) {
                    respuestaConsulta = consultaAVerDetalles.getRespuestaConsulta();
                }

                cargarDatosConsultaDetalle(titularConsulta, descripcionConsulta,
                        atendidaPorProfesional, alimentoConsultado, respuestaConsulta);

                //Buscamos lista de preferencias, restricciones y alimentos ingeridos y cargamos
                borrarModeloJList(jList1, modeloListaPreferencias);
                borrarModeloJList(jList2, modeloListaRestricciones);
                cargarJListUsuario(datosSolicitante, "PREFERENCIAS");
                cargarJListUsuario(datosSolicitante, "RESTRICCIONES");
                
                //Cargamos Ingestas de Usuarios
                limpiarTablaConsultas(jTable2);
                modeloAlimentosIngeridos = cargarJTableIngestasAlimentos(sistema, 
                        (DefaultTableModel) jTable2.getModel(), datosSolicitante);
                TableRowSorter sorter = new TableRowSorter(modeloAlimentosIngeridos);
                jTable2.setModel(modeloAlimentosIngeridos);
                jTable2.setRowSorter(sorter);
            }
        }
        );
    }
    
    public DefaultTableModel cargarJTableIngestasAlimentos(SistemaAlimentacionSaludable sistema,
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


    public Consulta buscarConsultaClickeada(SistemaAlimentacionSaludable sistema, 
            int idClickConsulta) {
        
        Consulta consultaClickeada = null;
        boolean encontroConsulta = false;

        for (int i = 0; i < sistema.getListaConsultas().size() && !encontroConsulta; i++) {
            Consulta consultaSistema = sistema.getListaConsultas().get(i);
            int idConsultaSistema = consultaSistema.getIdConsulta();

            if (idConsultaSistema == idClickConsulta) {
                consultaClickeada = consultaSistema;
            }
        }

        return consultaClickeada;
    }

    public void cargarDatosConsultaDetalle(String titularConsulta, 
            String descripcionConsulta,String atendidaPorProfesional, 
            String alimentoConsultado, String respuestaConsulta) {

        jTextPane2.setText(titularConsulta);
        jEditorPane1.setText(descripcionConsulta);
        jTextField2.setText(atendidaPorProfesional);
        jTextField3.setText(alimentoConsultado);
        jTextPane4.setText(respuestaConsulta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(211, 234, 216));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(211, 234, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Historial de Consultas");
        jPanel1.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Solicitante", "Titular", "Descripción", "Atendida por Profesional", "Alimento Consultado", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jPanel4.setBackground(new java.awt.Color(211, 234, 216));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Información de Usuario");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Preferencias"));

        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Restricciones"));

        jScrollPane7.setViewportView(jList2);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día de Ingesta", "Nombre de Alimento", "Tipo", "Porción (gramos)", "Nutrientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane8.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 157, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(211, 234, 216));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(211, 234, 216));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Detalle de Consulta");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Titular de Consulta: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Descripción de Consulta: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Atendida por Profesional:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Alimento Consultado:");

        jTextPane2.setEnabled(false);
        jScrollPane3.setViewportView(jTextPane2);

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Respuesta de Profesional:");

        jScrollPane5.setViewportView(jTextPane4);

        jEditorPane1.setEnabled(false);
        jScrollPane6.setViewportView(jEditorPane1);

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane5)
                        .addContainerGap())))
        );

        jPanel3.add(jPanel7);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(211, 234, 216));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Crear nueva Consulta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Titular de Consulta: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripción de Consulta: ");

        jScrollPane2.setViewportView(jTextPane1);

        jButton1.setText("Enviar Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Alimento Consultado:");

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se realiza un control para que no se pueda ingresar una nota vacia
        if (!jTextField1.getText().equals("") && !jTextPane1.getText().equals("")) {

            Consulta nuevaConsulta = new Consulta();

            nuevaConsulta.setSolcitante(buscarUsuario(sistema, 
                    infoMenuUSUARIO.getText()));
            nuevaConsulta.setTitularConsulta(jTextField1.getText());
            nuevaConsulta.setDescripcionConsulta(jTextPane1.getText());

            //Seteamos el contador de ID-CONSULTA
            int proximoIDConsulta = tomarUltimoValorContador() + 1;
            nuevaConsulta.setIdConsulta(proximoIDConsulta);

            Alimento alimentoSeleccionado = alimentoDeConsulta(sistema,
                    jComboBox1.getSelectedItem().toString());
            nuevaConsulta.setAlimentoConsultado(alimentoSeleccionado);

            //Agregar consulta al SISTEMA
            agregarAListaConsultaRegistrada(sistema, nuevaConsulta);
            //Agregar consulta al USUARIO asociado
            agregarAListaConsultaUsuario(sistema, nuevaConsulta, 
                    infoMenuUSUARIO.getText());

            //Refrescamos para proximo consulta
            jTextField1.setText("");
            jTextField1.setBorder(campoUsuarioConsultas);
            jTextPane1.setText("");
            jTextPane1.setBorder(campoUsuarioConsultas);

            //Cargamos JTable con Consultas ingresadas
            limpiarTablaConsultas(jTable1);
            modeloTablaConsultas = cargarJTableConsultas(sistema, 
                    (DefaultTableModel) jTable1.getModel(), infoMenuUSUARIO.getText());
            jTable1.setModel(modeloTablaConsultas);

        } else {
            if (jTextField1.getText().equals("")) {
                jTextField1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                jTextField1.setToolTipText("Ingrese Titular de Consulta");
            } else {
                jTextPane1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                jTextPane1.setToolTipText("Ingrese Descripción de Consulta");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardarRespuesta(sistema, valorIDConsultaClickeado, jTextPane4.getText(),
                infoMenuUSUARIO.getText());
        jTextPane4.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextPane4.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        jComboBox1.removeAll();
        iniciarCombo();
    }//GEN-LAST:event_jComboBox1MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration//GEN-END:variables
}
