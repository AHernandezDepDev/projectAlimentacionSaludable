package Interfaz;

import Dominio.Ingesta;
import Dominio.SistemaAlimentacionSaludable;
import static Interfaz.InterfazAlimentacionSaludable.buscarAlimento;
import static Interfaz.InterfazAlimentacionSaludable.cargarComboAlimentos;
import static Interfaz.InterfazAlimentacionSaludable.cargarJTableAlimentosIngestas;
import static Interfaz.InterfazAlimentacionSaludable.ingresarIngestasUsuarioAutenticado;
import static Interfaz.InterfazAlimentacionSaludable.limpiarTablaConsultas;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * @author André Hernández  ---- Numero de Estudiante: 193234 
 * SEGUNDO OBLIGARORIO      ---- Ingenieria de Software I
 * CLASE JInternalFrameRegitroDeAlimentoIngeridos
 * 21/11/2017
 */
public class JInternalFrameRegitroDeAlimentoIngeridos extends javax.swing.JInternalFrame {

    private final SistemaAlimentacionSaludable sistema;
    private final JMenu usuarioAutenticado;
    private final String datosUsuarioAutenticado;
    private final Border ingestasAlimentos;

    //Modelo de Registro de Alimentos Ingeridos
    private DefaultComboBoxModel modeloIngestaAlimentos = new DefaultComboBoxModel();
    private DefaultTableModel modeloTablaIngestaAlimentos = new DefaultTableModel();

    public JInternalFrameRegitroDeAlimentoIngeridos(SistemaAlimentacionSaludable sistemaAlimentacionSaludable,
            JMenu menuUsuario, String datosUsuario) {

        usuarioAutenticado = menuUsuario;
        datosUsuarioAutenticado = datosUsuario;
        sistema = sistemaAlimentacionSaludable;
        initComponents();
        iniciarCombo();
        iniciarTablaIngestas();
        this.setTitle(" Registrar Ingestas de Alimentos ");

        //Borde de los campos de ingreso de ingestas de Alimentos
        ingestasAlimentos = jComboBox1.getBorder();
    }

    public void iniciarCombo() {
        modeloIngestaAlimentos = cargarComboAlimentos(modeloIngestaAlimentos, 
                sistema);
        jComboBox1.setModel(modeloIngestaAlimentos);
    }

    public void iniciarTablaIngestas() {
        modeloTablaIngestaAlimentos = cargarJTableAlimentosIngestas(sistema, 
                (DefaultTableModel) jTable1.getModel(),
                datosUsuarioAutenticado);
        jTable1.setModel(modeloTablaIngestaAlimentos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setBackground(new java.awt.Color(211, 234, 216));
        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Alimentos Ingeridos");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel3.setText("Alimento Ingerido:");

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
        });

        jButton1.setText("Registrar Ingesta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Ingestas"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día de Ingesta", "Nombre de Alimento", "Tipo", "Porción (en gramos)", "Nutrientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel5.setText("Fecha de Ingesta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSize() != null && jDateChooser1.getDate() != null) {

            jDateChooser1.setBorder(ingestasAlimentos);
            jComboBox1.setBorder(ingestasAlimentos);

            Ingesta ingestaNueva = new Ingesta();

            ingestaNueva.setAlimentoIngerido(buscarAlimento(sistema, 
                    jComboBox1.getSelectedItem().toString()));
            ingestaNueva.setFechaIngesta(jDateChooser1.getDate());
            ingresarIngestasUsuarioAutenticado(sistema, datosUsuarioAutenticado,
                    ingestaNueva);

            //Refrescamos tabla de Ingestas
            limpiarTablaConsultas(jTable1);
            modeloTablaIngestaAlimentos = cargarJTableAlimentosIngestas(sistema, 
                    (DefaultTableModel) jTable1.getModel(),
                    datosUsuarioAutenticado);

            TableRowSorter sorter = new TableRowSorter(modeloTablaIngestaAlimentos);
            jTable1.setModel(modeloTablaIngestaAlimentos);
            jTable1.setRowSorter(sorter);
        } else {
            if (jComboBox1.getSize() == null) {
                jComboBox1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                jComboBox1.setToolTipText("Cargar Alimento en el "
                        + "Sistema para registrar Ingesta");
            } else {
                jDateChooser1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                jDateChooser1.setToolTipText("Debe seleccionar una fecha de Ingesta");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        jComboBox1.removeAllItems();
        iniciarCombo();
    }//GEN-LAST:event_jComboBox1MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
