/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 *
 * @author yoshi
 */
public class ModulosPrinc extends javax.swing.JPanel {

    /**
     * Creates new form Modulos
     */
    public ModulosPrinc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEmpleado = new javax.swing.JPanel();
        lblEmp = new javax.swing.JLabel();
        btnArea = new javax.swing.JPanel();
        lblArea = new javax.swing.JLabel();
        btnReportes = new javax.swing.JPanel();
        lblReporte = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(230, 400));
        setMinimumSize(new java.awt.Dimension(230, 400));
        setPreferredSize(new java.awt.Dimension(230, 400));

        jPanel1.setBackground(new java.awt.Color(194, 222, 209));
        jPanel1.setMaximumSize(new java.awt.Dimension(230, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(230, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 400));

        btnEmpleado.setBackground(new java.awt.Color(53, 66, 89));
        btnEmpleado.setMaximumSize(new java.awt.Dimension(230, 50));
        btnEmpleado.setMinimumSize(new java.awt.Dimension(230, 50));
        btnEmpleado.setPreferredSize(new java.awt.Dimension(230, 50));
        btnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseExited(evt);
            }
        });

        lblEmp.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        lblEmp.setForeground(new java.awt.Color(255, 255, 255));
        lblEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmp.setText("Empleado");

        javax.swing.GroupLayout btnEmpleadoLayout = new javax.swing.GroupLayout(btnEmpleado);
        btnEmpleado.setLayout(btnEmpleadoLayout);
        btnEmpleadoLayout.setHorizontalGroup(
            btnEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEmpleadoLayout.setVerticalGroup(
            btnEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnArea.setBackground(new java.awt.Color(53, 66, 89));
        btnArea.setMaximumSize(new java.awt.Dimension(230, 50));
        btnArea.setMinimumSize(new java.awt.Dimension(230, 50));
        btnArea.setPreferredSize(new java.awt.Dimension(230, 50));
        btnArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAreaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAreaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAreaMouseExited(evt);
            }
        });

        lblArea.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        lblArea.setForeground(new java.awt.Color(255, 255, 255));
        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArea.setText("Área");

        javax.swing.GroupLayout btnAreaLayout = new javax.swing.GroupLayout(btnArea);
        btnArea.setLayout(btnAreaLayout);
        btnAreaLayout.setHorizontalGroup(
            btnAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArea, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnAreaLayout.setVerticalGroup(
            btnAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArea, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnReportes.setBackground(new java.awt.Color(53, 66, 89));
        btnReportes.setMaximumSize(new java.awt.Dimension(230, 50));
        btnReportes.setMinimumSize(new java.awt.Dimension(230, 50));
        btnReportes.setPreferredSize(new java.awt.Dimension(230, 50));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });

        lblReporte.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        lblReporte.setForeground(new java.awt.Color(255, 255, 255));
        lblReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReporte.setText("Reportes");

        javax.swing.GroupLayout btnReportesLayout = new javax.swing.GroupLayout(btnReportes);
        btnReportes.setLayout(btnReportesLayout);
        btnReportesLayout.setHorizontalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnReportesLayout.setVerticalGroup(
            btnReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseClicked
        ModuloEmp mEmp = new ModuloEmp();
        
        mEmp.setSize(new Dimension(970, 600));
        mEmp.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mEmp,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnEmpleadoMouseClicked

    private void btnEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseEntered
        btnEmpleado.setBackground(new Color(0, 0, 0));
        lblEmp.setFont(new Font("SF UI Display", Font.BOLD, 18));
    }//GEN-LAST:event_btnEmpleadoMouseEntered

    private void btnEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseExited
        btnEmpleado.setBackground(new Color(53,66,89));
        lblEmp.setFont(new Font("SF UI Display", Font.BOLD, 16));
    }//GEN-LAST:event_btnEmpleadoMouseExited

    private void btnAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAreaMouseClicked
        ModuloArea mArea = new ModuloArea();
        
        mArea.setSize(new Dimension(970, 600));
        mArea.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mArea, BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnAreaMouseClicked

    private void btnAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAreaMouseEntered
        btnArea.setBackground(new Color(0, 0, 0));
        lblArea.setFont(new Font("SF UI Display", Font.BOLD, 18));
    }//GEN-LAST:event_btnAreaMouseEntered

    private void btnAreaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAreaMouseExited
        btnArea.setBackground(new Color(53,66,89));
        lblArea.setFont(new Font("SF UI Display", Font.BOLD, 16));
    }//GEN-LAST:event_btnAreaMouseExited

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
        
        ModulosRepor modRep = new ModulosRepor();
        modRep.setSize(new Dimension(230, 400));
        modRep.setLocation(0,0);
        Principal.PanelMod.removeAll();
        Principal.PanelMod.add(modRep,BorderLayout.CENTER);
        Principal.PanelMod.revalidate();
        Principal.PanelMod.repaint();
        
        Principal.btnAtras.setVisible(true);
        Principal.btnCerrarSesion.setVisible(false);
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBackground(new Color(0, 0, 0));
        lblReporte.setFont(new Font("SF UI Display", Font.BOLD, 18));
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBackground(new Color(53,66,89));
        lblReporte.setFont(new Font("SF UI Display", Font.BOLD, 16));
    }//GEN-LAST:event_btnReportesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnArea;
    private javax.swing.JPanel btnEmpleado;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblReporte;
    // End of variables declaration//GEN-END:variables

    private Dimension Dimension(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
