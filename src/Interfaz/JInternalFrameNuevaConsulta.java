package Interfaz;

import Dominio.Alimento;
import Dominio.Consulta;
import Dominio.SistemaAlimentacionSaludable;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaConsultaRegistrada;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaConsultaUsuario;
import static Interfaz.InterfazAlimentacionSaludable.alimentoDeConsulta;
import static Interfaz.InterfazAlimentacionSaludable.buscarUsuario;
import static Interfaz.InterfazAlimentacionSaludable.cargarComboAlimentos;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTableConsultas;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class JInternalFrameNuevaConsulta extends javax.swing.JInternalFrame {

    SistemaAlimentacionSaludable sistema;
    JMenu infoMenuUSUARIO;
    Border campoUsuarioConsultas;
    DefaultComboBoxModel modeloComboAlimentos = new DefaultComboBoxModel();
    JDesktopPane panelSistemaPrincipal;
    JMenu menuAutenticadoSistema;

    public JInternalFrameNuevaConsulta(SistemaAlimentacionSaludable sistemaAlimentacionSaludable, JMenu menuAutenticado,
            JMenu infoMenuUsuario, JDesktopPane panelSistema) {

        sistema = sistemaAlimentacionSaludable;
        infoMenuUSUARIO = infoMenuUsuario;
        menuAutenticadoSistema = menuAutenticado;
        panelSistemaPrincipal = panelSistema;
        initComponents();

        iniciarCombo();
        //Borde de los campos de ingreso de datos para el Usuario
        campoUsuarioConsultas = jTextField1.getBorder();
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

    public void iniciarCombo() {
        modeloComboAlimentos = cargarComboAlimentos((DefaultComboBoxModel) jComboBox1.getModel(), sistema);
        jComboBox1.setModel(modeloComboAlimentos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se realiza un control para que no se pueda ingresar una nota vacia
        if (!jTextField1.getText().equals("") && !jTextPane1.getText().equals("")) {

            Consulta nuevaConsulta = new Consulta();

            nuevaConsulta.setSolcitante(buscarUsuario(sistema, infoMenuUSUARIO.getText()));
            nuevaConsulta.setTitularConsulta(jTextField1.getText());
            nuevaConsulta.setDescripcionConsulta(jTextPane1.getText());

            //Seteamos el contador de ID-CONSULTA
            int proximoIDConsulta = tomarUltimoValorContador() + 1;
            nuevaConsulta.setIdConsulta(proximoIDConsulta);

            Alimento alimentoSeleccionado = alimentoDeConsulta(sistema, jComboBox1.getSelectedItem().toString());
            nuevaConsulta.setAlimentoConsultado(alimentoSeleccionado);

            //Agregar consulta al SISTEMA
            agregarAListaConsultaRegistrada(sistema, nuevaConsulta);
            //Agregar consulta al USUARIO asociado
            agregarAListaConsultaUsuario(sistema, nuevaConsulta, infoMenuUSUARIO.getText());
            
            //Abrimos Inernal Frame Principal con la consulta ya registrada en el Sistema
            JInternalFrameConsultaProfesional consultaProfesional = new JInternalFrameConsultaProfesional(sistema, menuAutenticadoSistema,
                    infoMenuUSUARIO, panelSistemaPrincipal);
            panelSistemaPrincipal.add(consultaProfesional);
            consultaProfesional.setVisible(true);

            this.dispose();

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
