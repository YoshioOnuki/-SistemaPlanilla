/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidad.area;
import Entidad.empleado;
import Modelo.empleadoMod;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author yoshi
 */
public class ModuloEmp extends javax.swing.JPanel {

    DefaultTableModel m = new DefaultTableModel();
    
    Modelo.empleadoMod empMod = new empleadoMod();
    Entidad.empleado emp = new empleado();
    
    public static int idE, tipooo;
    public static String AreaNom;
    
    public ModuloEmp() {
        initComponents();
        placeholders();
        buscarEmpleado();
    }
    
    void placeholders(){
        Textp txte = new Textp("Buscar DNI/Nombre", txtBuscarEmp);
    }

    
    void OpcEmpSal(int opc){
        int fila = tablaEmp.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            //codEmp = Integer.parseInt(tablaEmp.getValueAt(fila, 0).toString());
            
            if(opc == 1){
                idE = Integer.parseInt(tablaEmp.getValueAt(fila, 0).toString());
                AreaNom = tablaEmp.getValueAt(fila,6).toString();
                
                ModuloEmpSal mEmpSal = new ModuloEmpSal();

                mEmpSal.setSize(new Dimension(970, 600));
                mEmpSal.setLocation(0,0);
                Principal.PanelPrincipal.removeAll();
                Principal.PanelPrincipal.add(mEmpSal, BorderLayout.CENTER);
                Principal.PanelPrincipal.revalidate();
                Principal.PanelPrincipal.repaint();
            }
        }
    }
    void OpcEmpActualizar(){
        int fila = tablaEmp.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            AreaNom = tablaEmp.getValueAt(fila,6).toString();
            idE = Integer.parseInt(tablaEmp.getValueAt(fila, 0).toString());

            ModuloEmpAgr mEmpAgr = new ModuloEmpAgr();

            mEmpAgr.setSize(new Dimension(970, 600));
            mEmpAgr.setLocation(0,0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mEmpAgr, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();
        }
    }
    void OpcEmUsua(int opc){
        int fila = tablaEmp.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            String a = tablaEmp.getValueAt(fila, 6).toString();
            idE = Integer.parseInt(tablaEmp.getValueAt(fila, 0).toString());
            if(opc == 2){
                if(a.equals("Recursos Humanos")){
                    if(empMod.validarEmpUsuario(idE)==0){
                        ModuloEmpUsua mEmpUsua = new ModuloEmpUsua();

                        mEmpUsua.setSize(new Dimension(970, 600));
                        mEmpUsua.setLocation(0,0);
                        Principal.PanelPrincipal.removeAll();
                        Principal.PanelPrincipal.add(mEmpUsua, BorderLayout.CENTER);
                        Principal.PanelPrincipal.revalidate();
                        Principal.PanelPrincipal.repaint(); 
                    }else{
                        JOptionPane.showMessageDialog(null, "El empleado ya cuenta con un Usuario registrado");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione un empleado del area de Resursos Humanos");
                }
                
            }
        }
    }
    
    void buscarEmpleado(){
        try {
            m = empMod.consultarEmpleado(txtBuscarEmp.getText());
            tablaEmp.setModel(m);
            
            TableColumn t = tablaEmp.getColumn("DNI");
            t.setPreferredWidth(80);
            t.setMaxWidth(80);
            t.setMinWidth(80);
            
            TableColumn t2 = tablaEmp.getColumn("ID");
            t2.setPreferredWidth(50);
            t2.setMaxWidth(50);
            t2.setMinWidth(50);
            
            TableColumn t3 = tablaEmp.getColumn("SALARIO");
            t3.setPreferredWidth(80);
            t3.setMaxWidth(80);
            t3.setMinWidth(80);
            
            
            tablaEmp.setRowHeight(25);
        } catch (Exception e) {
            System.out.println("Error al mostrar paciente: " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEmp = new javax.swing.JPopupMenu();
        actualizar = new javax.swing.JMenuItem();
        menuSal = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNuevoEmp = new javax.swing.JPanel();
        lblAgregar = new javax.swing.JLabel();
        Tabla = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarEmp = new javax.swing.JTextField();

        menuEmp.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N

        actualizar.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        actualizar.setText("Actualizar Empleado");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        menuEmp.add(actualizar);

        menuSal.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        menuSal.setText("Actualizar Salario");
        menuSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalActionPerformed(evt);
            }
        });
        menuEmp.add(menuSal);

        menuUsuario.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        menuUsuario.setText("Asignar un Usuario");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        menuEmp.add(menuUsuario);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(970, 600));
        setMinimumSize(new java.awt.Dimension(970, 600));
        setPreferredSize(new java.awt.Dimension(970, 600));

        jPanel6.setBackground(new java.awt.Color(53, 66, 89));
        jPanel6.setMaximumSize(new java.awt.Dimension(970, 25));
        jPanel6.setMinimumSize(new java.awt.Dimension(970, 25));

        btnExit.setBackground(new java.awt.Color(53, 66, 89));
        btnExit.setMaximumSize(new java.awt.Dimension(40, 25));
        btnExit.setMinimumSize(new java.awt.Dimension(40, 25));
        btnExit.setPreferredSize(new java.awt.Dimension(40, 25));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/EXIT (1).png"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 25));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 25));
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 25));

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 930, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 23, 35));
        jLabel2.setFont(new java.awt.Font("SF UI Display", 1, 30)); // NOI18N
        jLabel2.setText("Empleados");

        btnNuevoEmp.setBackground(new java.awt.Color(205, 194, 174));
        btnNuevoEmp.setMaximumSize(new java.awt.Dimension(140, 50));
        btnNuevoEmp.setMinimumSize(new java.awt.Dimension(140, 50));
        btnNuevoEmp.setPreferredSize(new java.awt.Dimension(140, 50));
        btnNuevoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoEmpMouseExited(evt);
            }
        });

        lblAgregar.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        lblAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregar.setText("Nuevo");

        javax.swing.GroupLayout btnNuevoEmpLayout = new javax.swing.GroupLayout(btnNuevoEmp);
        btnNuevoEmp.setLayout(btnNuevoEmpLayout);
        btnNuevoEmpLayout.setHorizontalGroup(
            btnNuevoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNuevoEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnNuevoEmpLayout.setVerticalGroup(
            btnNuevoEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNuevoEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabla.setMaximumSize(new java.awt.Dimension(890, 360));
        Tabla.setMinimumSize(new java.awt.Dimension(890, 360));
        Tabla.setPreferredSize(new java.awt.Dimension(890, 360));

        tablaEmp.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        tablaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEmp.setComponentPopupMenu(menuEmp);
        Tabla.setViewportView(tablaEmp);

        jPanel2.setBackground(new java.awt.Color(205, 194, 174));
        jPanel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(190, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(190, 50));

        txtBuscarEmp.setBackground(new java.awt.Color(205, 194, 174));
        txtBuscarEmp.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        txtBuscarEmp.setBorder(null);
        txtBuscarEmp.setMaximumSize(new java.awt.Dimension(120, 18));
        txtBuscarEmp.setMinimumSize(new java.awt.Dimension(120, 18));
        txtBuscarEmp.setPreferredSize(new java.awt.Dimension(120, 18));
        txtBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpActionPerformed(evt);
            }
        });
        txtBuscarEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarEmpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(536, 536, 536)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(237, 19, 19));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(53,66,89));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnNuevoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEmpMouseClicked
        tipooo = 1;
        ModuloEmpAgr mEmpAgr = new ModuloEmpAgr();

        mEmpAgr.setSize(new Dimension(970, 600));
        mEmpAgr.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mEmpAgr, BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnNuevoEmpMouseClicked

    private void btnNuevoEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEmpMouseEntered
        btnNuevoEmp.setBackground(new Color(194, 222, 209));
    }//GEN-LAST:event_btnNuevoEmpMouseEntered

    private void btnNuevoEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEmpMouseExited
        btnNuevoEmp.setBackground(new Color(205,194,174));
    }//GEN-LAST:event_btnNuevoEmpMouseExited

    private void txtBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpActionPerformed
        
    }//GEN-LAST:event_txtBuscarEmpActionPerformed

    private void menuSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalActionPerformed
        int opc = 1;
        OpcEmpSal(opc);
    }//GEN-LAST:event_menuSalActionPerformed

    private void txtBuscarEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEmpKeyTyped
        buscarEmpleado();
    }//GEN-LAST:event_txtBuscarEmpKeyTyped

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        int opc = 2;
        OpcEmUsua(opc);
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        tipooo = 2;
        OpcEmpActualizar();
    }//GEN-LAST:event_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JMenuItem actualizar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnNuevoEmp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JPopupMenu menuEmp;
    private javax.swing.JMenuItem menuSal;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JTable tablaEmp;
    private javax.swing.JTextField txtBuscarEmp;
    // End of variables declaration//GEN-END:variables
}
