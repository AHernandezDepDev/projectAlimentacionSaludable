package Interfaz;

import Dominio.Alimento;
import Dominio.SistemaAlimentacionSaludable;
import static Interfaz.InterfazAlimentacionSaludable.agregarAListaAlimentoRegistrado;
import static Interfaz.InterfazAlimentacionSaludable.altaAlimentoOK;
import static Interfaz.InterfazAlimentacionSaludable.borrarModeloJList;
import static Interfaz.InterfazAlimentacionSaludable.cargarJListRegistro;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTableAlimentosIngresados;
import static Interfaz.InterfazAlimentacionSaludable.datosEnListaAArrayListString;
import static Interfaz.InterfazAlimentacionSaludable.existeStringCargadoEnJList;
import static Interfaz.InterfazAlimentacionSaludable.limpiarTablaConsultas;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE JInternalFrameRegitroDeAlimento
 * 21/11/2017
 */
public class JInternalFrameRegitroDeAlimento extends javax.swing.JInternalFrame {

    SistemaAlimentacionSaludable sistema;

    //Modelo de JList Agregar Nutrientes de Alimentos
    private final DefaultListModel modeloJListNutrientesAlimentos = new DefaultListModel();
    private DefaultTableModel modeloTablaAlimentos = new DefaultTableModel();
    private final Border campoAlimento;
    private int porcionAlimentoIngresada;

    public JInternalFrameRegitroDeAlimento(SistemaAlimentacionSaludable sistemaAlimentacionSaludable) {
        sistema = sistemaAlimentacionSaludable;
        initComponents();
        this.setTitle(" Registrar Alimento ");

        //Borde de los campos de ingreso de Alimento
        campoAlimento = jTextField1.getBorder();

        //Cargamos JTable con Alimentos ingresadas
        modeloTablaAlimentos = cargarJTableAlimentosIngresados(sistema, 
                (DefaultTableModel) jTable1.getModel());
        jTable1.setModel(modeloTablaAlimentos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setBackground(new java.awt.Color(211, 234, 216));
        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Alimento");

        jPanel1.setBackground(new java.awt.Color(211, 234, 216));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel1.setText("Tipo de Alimento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel4.setText("Porción indicada (en gramos):");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nutrientes"));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel3.setText("Ingrese Nutrientes del Alimento:");

        jScrollPane1.setViewportView(jList2);

        jButton2.setText("Agregar a Lista de Nutrientes:");
        jButton2.setActionCommand("Agregar a Lista de Nutrientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton4.setText("Registrar Alimento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Porción (grs)", "Nutrientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!jTextField7.getText().equals("")) {
            if (!existeStringCargadoEnJList(modeloJListNutrientesAlimentos, 
                    jTextField7.getText())) {
                
                cargarJListRegistro(jList2, jTextField7.getText(), 
                        modeloJListNutrientesAlimentos);
                
                jTextField7.setText("");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Se deben completar todos los campos para el registro de Aliemento
        if (!jTextField1.getText().equals("") && !jTextField4.getText().equals("") &&
                !jTextField5.getText().equals("")) {

            jTextField1.setBorder(campoAlimento);
            jTextField4.setBorder(campoAlimento);
            jTextField5.setBorder(campoAlimento);

            porcionAlimentoIngresada = Integer.parseInt(jTextField5.getText());

            if (porcionAlimentoIngresada < 0 || porcionAlimentoIngresada > 1000) {
                jTextField5.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                jTextField5.setToolTipText("Porcion ingresada incorrecta. "
                        + "La porcion debe estar entre 1 gramo y 1000 gramos");
            } else {

                Alimento alimentoAIngresar = new Alimento();

                alimentoAIngresar.setNombre(jTextField1.getText());
                alimentoAIngresar.setTipo(jTextField4.getText());

                porcionAlimentoIngresada = Integer.parseInt(jTextField5.getText());

                if (porcionAlimentoIngresada < 0 || porcionAlimentoIngresada > 1000) {
                    jTextField5.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    jTextField5.setToolTipText("Porcion ingresada incorrecta. "
                            + "La porcion debe estar entre 1 gramo y 1000 gramos");
                } else {
                    alimentoAIngresar.setPorcion(porcionAlimentoIngresada);
                }

                alimentoAIngresar.setListaDeNutrientes
        (datosEnListaAArrayListString(modeloJListNutrientesAlimentos));

                //REGISTRAMOS NUEVO ALIMENTO
                if (altaAlimentoOK(sistema, alimentoAIngresar.getNombre())) {
                    agregarAListaAlimentoRegistrado(sistema, alimentoAIngresar);

                    jTextField1.setBorder(campoAlimento);
                    jTextField4.setBorder(campoAlimento);
                    jTextField5.setBorder(campoAlimento);
                } else {
                    jTextField1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    jTextField1.setToolTipText("Alimento existente en el Sistema");
                }

                //Cargamos JTable con Alimentos ingresadas
                limpiarTablaConsultas(jTable1);
                modeloTablaAlimentos = 
                        cargarJTableAlimentosIngresados(sistema, 
                                (DefaultTableModel) jTable1.getModel());
                jTable1.setModel(modeloTablaAlimentos);

                //Refrescamos para proximo registro
                jTextField1.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                borrarModeloJList(jList2, modeloJListNutrientesAlimentos);
            }
        } else {
            jTextField1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            jTextField1.setToolTipText("Ingrese nombre de Alimento");
            jTextField4.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            jTextField4.setToolTipText("Ingrese tipo de Alimento");
            jTextField5.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            jTextField5.setToolTipText("Ingrese porcion de Alimento");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
