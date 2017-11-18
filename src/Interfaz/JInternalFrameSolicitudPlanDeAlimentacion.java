package Interfaz;

import Dominio.Consulta;
import Dominio.PlanAlimentacion;
import Dominio.SistemaAlimentacionSaludable;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionRegistrado;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaPlanDeAlimentacionUsuario;
import static Interfaz.InterfazAlimentacionSaludable.buscarUsuario;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.border.Border;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 */
public class JInternalFrameSolicitudPlanDeAlimentacion extends javax.swing.JInternalFrame {

    SistemaAlimentacionSaludable sistema;
    JMenu infoMenuUSUARIO;
    Border campoUsuarioPlanAlimentacion;
    JDesktopPane panelSistemaPrincipal;
    JMenu menuAutenticadoSistema;

    public JInternalFrameSolicitudPlanDeAlimentacion(SistemaAlimentacionSaludable sistemaAlimentacionSaludable, JMenu menuAutenticado,
            JMenu infoMenuUsuario, JDesktopPane panelSistema) {

        sistema = sistemaAlimentacionSaludable;
        infoMenuUSUARIO = infoMenuUsuario;
        menuAutenticadoSistema = menuAutenticado;
        panelSistemaPrincipal = panelSistema;
        initComponents();
        this.setTitle(" Solicitud de nuevo Plan de Alimentación ");

        //Borde de los campos de ingreso de datos para el Usuario
        campoUsuarioPlanAlimentacion = jTextPane1.getBorder();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setClosable(true);
        setIconifiable(true);

        jPanel5.setBackground(new java.awt.Color(211, 234, 216));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se realiza un control para que no se pueda ingresar una nota vacia
        if (!jTextPane1.getText().equals("")) {
            
            jTextPane1.setBorder(campoUsuarioPlanAlimentacion);

            PlanAlimentacion planDeAlimentacion = new PlanAlimentacion();
            planDeAlimentacion.stringPorDefectoDiasPlanAlimentacion();
            
            planDeAlimentacion.setObservaciones(jTextPane1.getText());
            planDeAlimentacion.setSolicitante(buscarUsuario(sistema, infoMenuUSUARIO.getText()));

            //Seteamos el contador de ID-PLANdeALIMENTACION
            int proximoIDPlanAlimentacion = tomarUltimoValorContador() + 1;
            planDeAlimentacion.setIdPlanAlimentacion(proximoIDPlanAlimentacion);

            //Agregar Solicitud de Plan de Alimentacion al SISTEMA
            agregarAListaPlanDeAlimentacionRegistrado(sistema, planDeAlimentacion);
            //Agregar Plan de Alimentacion al USUARIO que lo solicita
            agregarAListaPlanDeAlimentacionUsuario(sistema, planDeAlimentacion, infoMenuUSUARIO.getText());

            //Abrimos Inernal Frame Principal con la consulta ya registrada en el Sistema
            JInternalFrameSugerenciaPlanAlimentacion solicitudPlanAlimentacion
                    = new JInternalFrameSugerenciaPlanAlimentacion(sistema, menuAutenticadoSistema, infoMenuUSUARIO);

            panelSistemaPrincipal.add(solicitudPlanAlimentacion);
            solicitudPlanAlimentacion.setVisible(true);

            this.dispose();
        } else {
            jTextPane1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            jTextPane1.setToolTipText("Ingrese Observaciones para la solicitud del Plan de Alimentación");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
