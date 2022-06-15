/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidad.empleado;
import Modelo.areaMod;
import Modelo.empleadoMod;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author yoshi
 */
public class ModuloEmpAgr extends javax.swing.JPanel {

    private FileInputStream fis;
    private int longitudBytes;
    
    Modelo.empleadoMod empMod = new empleadoMod();
    Modelo.areaMod aM = new areaMod();
    Entidad.empleado e = new empleado();
    
    public ModuloEmpAgr() {
        initComponents();
        txtCodEmp.setEditable(false);
        cargarCboArea();
        titulo();
    }
    
    void cargarCboArea(){
        empMod.cargarComboArea(cboArea);
    }
    
    void titulo(){
        if(ModuloEmp.tipooo==1){
            titulo.setText("");
            titulo.setText("Ingresar Empleado");
            lblAgregar.setText("");
            lblAgregar.setText("Ingresar");
            genCOD();
        }else if(ModuloEmp.tipooo==2){
            titulo.setText("");
            titulo.setText("Modificar Empleado");
            lblAgregar.setText("");
            lblAgregar.setText("Modificar");
            cargarDatosActualizar();
        }
    }
    
    void genCOD(){
        int id = empMod.maxcodEmp();
        
        txtCodEmp.setText("" + (id+1));
    }
    
    //aqui cargamos todos los datos del empleado para proceder a modificar
    void cargarDatosActualizar(){
        int ide = ModuloEmp.idE; 
        System.out.println("idE " + ide);
        e = empMod.datosEmp(ide);
        
        txtCodEmp.setText(""+ ide);
        txtIngrNomb.setText(e.getEmpNomb());
        txtIngrApePa.setText(e.getEmpApePate());
        txtIngrApeMa.setText(e.getEmpApeMat());
        cboGenero.setSelectedItem(e.getGenero());
        txtIngDNI.setText(e.getEmpDNI());
        try {
            SimpleDateFormat formatodeltexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            fecha = (Date) formatodeltexto.parse(e.getEmpFecNac());
            txtFecNac.setDate(fecha);
            
            SimpleDateFormat formatodeltexto2 = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha2 = null;
            fecha2 = (Date) formatodeltexto2.parse(e.getEmpFecIngr());
            txtFecIngr.setDate(fecha2);
        } catch (Exception e) {
        }
        cboArea.setSelectedItem(ModuloEmp.AreaNom);
    }
    
    void agregarEmpleado(){
        if(txtCodEmp.getText().equals("") || txtIngrNomb.getText().equals("") ||txtIngrApePa.getText().equals("") ||txtFecNac.getDate()==null ||txtFecIngr.getDate()==null||txtIngrApeMa.getText().equals("") ||txtIngDNI.getText().equals("") || cboArea.getSelectedIndex()==0 || cboGenero.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Campos de textos vacios");
            txtIngDNI.requestFocus();
        }else{
            Date f = txtFecNac.getDate();
            DateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
            String fechana = f2.format(f);
            
            Date f3 = txtFecIngr.getDate();
            DateFormat f22 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaingreso = f22.format(f3);
            
            String dni = txtIngDNI.getText();
            int iE = Integer.parseInt(txtCodEmp.getText());
            String nom = txtIngrNomb.getText();
            String apep = txtIngrApePa.getText();
            String apem = txtIngrApeMa.getText();
            String gen = cboGenero.getSelectedItem().toString();
            String area = cboArea.getSelectedItem().toString();
            int iA = aM.obtenerID(area);
            int foto=0;
            String est = "ACTIVO";
            
            Object[] ob = new Object[11];

            ob[0] = dni;
            ob[1] = nom;
            ob[2] = apep;
            ob[3] = apem;
            ob[4] = gen;
            ob[5] = fechana;
            ob[6] = fechaingreso;
            ob[7] = null;
            ob[8] = est;
            ob[9] = null;
            ob[10] = iA;

            int r1 = empMod.addEmpleado(ob);
            
            if(r1>0){
                JOptionPane.showMessageDialog(null, "Datos de empleado ingresados correctamente");
            }
            
            ModuloEmp mEmp = new ModuloEmp();

            mEmp.setSize(new Dimension(970, 600));
            mEmp.setLocation(0,0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mEmp, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();

            
        }
    }
    
    void actualizarEmpleado(){
        if(txtCodEmp.getText().equals("") || txtIngrNomb.getText().equals("") ||txtIngrApePa.getText().equals("") ||txtFecNac.getDate()==null ||txtFecIngr.getDate()==null||txtIngrApeMa.getText().equals("") ||txtIngDNI.getText().equals("") || cboArea.getSelectedIndex()==0 || cboGenero.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Campos de textos vacios");
            txtIngDNI.requestFocus();
        }else{
            Date f = txtFecNac.getDate();
            DateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
            String fechana = f2.format(f);
            
            String dni = txtIngDNI.getText();
            int iE = Integer.parseInt(txtCodEmp.getText());
            String nom = txtIngrNomb.getText();
            String apep = txtIngrApePa.getText();
            String apem = txtIngrApeMa.getText();
            String gen = cboGenero.getSelectedItem().toString();
            int foto=0;
            
            Object[] ob = new Object[7];

            ob[0] = dni;
            ob[1] = nom;
            ob[2] = apep;
            ob[3] = apem;
            ob[4] = gen;
            ob[5] = fechana;
            ob[6] = iE;

            int r1 = empMod.updateEmpleado2(ob);
            
            if(r1>0){
                JOptionPane.showMessageDialog(null, "Datos de empleado actualizadoos correctamente");
            }
            
            ModuloEmp mEmp = new ModuloEmp();

            mEmp.setSize(new Dimension(970, 600));
            mEmp.setLocation(0,0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mEmp, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();

            
        }
    }
    
    public void guardarFoto(){
        
        try {
            
            
            
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIngDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIngrNomb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIngrApePa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIngrApeMa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodEmp = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblFotoUser = new javax.swing.JLabel();
        btnIngrFoto = new javax.swing.JButton();
        btnAgregar = new javax.swing.JPanel();
        lblAgregar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFecNac = new com.toedter.calendar.JDateChooser();
        txtFecIngr = new com.toedter.calendar.JDateChooser();

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

        jLabel6.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/EXIT (1).png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 25));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 25));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 25));

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        titulo.setBackground(new java.awt.Color(0, 23, 35));
        titulo.setFont(new java.awt.Font("SF UI Display", 1, 30)); // NOI18N
        titulo.setText("Empleados");

        jLabel1.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel1.setText("DNI:");

        txtIngDNI.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtIngDNI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.lightGray, null));
        txtIngDNI.setMaximumSize(new java.awt.Dimension(230, 26));
        txtIngDNI.setMinimumSize(new java.awt.Dimension(230, 26));
        txtIngDNI.setPreferredSize(new java.awt.Dimension(230, 26));
        txtIngDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngDNIActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        txtIngrNomb.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtIngrNomb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.lightGray, null));
        txtIngrNomb.setMaximumSize(new java.awt.Dimension(230, 26));
        txtIngrNomb.setMinimumSize(new java.awt.Dimension(230, 26));
        txtIngrNomb.setPreferredSize(new java.awt.Dimension(230, 26));
        txtIngrNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngrNombActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel4.setText("Apellido Paterno:");

        txtIngrApePa.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtIngrApePa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.lightGray, null));
        txtIngrApePa.setMaximumSize(new java.awt.Dimension(230, 26));
        txtIngrApePa.setMinimumSize(new java.awt.Dimension(230, 26));
        txtIngrApePa.setPreferredSize(new java.awt.Dimension(230, 26));
        txtIngrApePa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngrApePaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel5.setText("Apellido Materno:");

        txtIngrApeMa.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtIngrApeMa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.lightGray, null));
        txtIngrApeMa.setMaximumSize(new java.awt.Dimension(230, 26));
        txtIngrApeMa.setMinimumSize(new java.awt.Dimension(230, 26));
        txtIngrApeMa.setPreferredSize(new java.awt.Dimension(230, 26));
        txtIngrApeMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngrApeMaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento:");

        jLabel7.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel7.setText("Género:");

        cboGenero.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));
        cboGenero.setMaximumSize(new java.awt.Dimension(230, 26));
        cboGenero.setMinimumSize(new java.awt.Dimension(230, 26));
        cboGenero.setPreferredSize(new java.awt.Dimension(230, 26));

        jLabel8.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel8.setText("Área:");

        cboArea.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        cboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cboArea.setMaximumSize(new java.awt.Dimension(230, 26));
        cboArea.setMinimumSize(new java.awt.Dimension(230, 26));
        cboArea.setPreferredSize(new java.awt.Dimension(230, 26));

        jLabel10.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de ingreso:");

        jLabel12.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel12.setText("Codigo de Empleado:");

        txtCodEmp.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtCodEmp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.lightGray, null));
        txtCodEmp.setMaximumSize(new java.awt.Dimension(210, 26));
        txtCodEmp.setMinimumSize(new java.awt.Dimension(210, 26));
        txtCodEmp.setPreferredSize(new java.awt.Dimension(210, 26));
        txtCodEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(219, 223, 253));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 250));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 220));

        lblFotoUser.setForeground(new java.awt.Color(205, 194, 174));
        lblFotoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/FotoUser.png"))); // NOI18N
        lblFotoUser.setMaximumSize(new java.awt.Dimension(220, 220));
        lblFotoUser.setMinimumSize(new java.awt.Dimension(220, 220));
        lblFotoUser.setPreferredSize(new java.awt.Dimension(220, 220));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFotoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFotoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnIngrFoto.setBackground(new java.awt.Color(205, 194, 174));
        btnIngrFoto.setForeground(new java.awt.Color(205, 194, 174));
        btnIngrFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/btnFoto.png"))); // NOI18N
        btnIngrFoto.setMaximumSize(new java.awt.Dimension(60, 60));
        btnIngrFoto.setMinimumSize(new java.awt.Dimension(60, 60));
        btnIngrFoto.setPreferredSize(new java.awt.Dimension(60, 60));
        btnIngrFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngrFotoMouseClicked(evt);
            }
        });
        btnIngrFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngrFotoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(205, 194, 174));
        btnAgregar.setMaximumSize(new java.awt.Dimension(160, 50));
        btnAgregar.setMinimumSize(new java.awt.Dimension(160, 50));
        btnAgregar.setPreferredSize(new java.awt.Dimension(160, 50));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });

        lblAgregar.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        lblAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregar.setText("Ingresar");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        jLabel13.setText("Seleccione un foto.");

        txtFecNac.setMaximumSize(new java.awt.Dimension(230, 26));
        txtFecNac.setMinimumSize(new java.awt.Dimension(230, 26));
        txtFecNac.setPreferredSize(new java.awt.Dimension(230, 26));

        txtFecIngr.setMaximumSize(new java.awt.Dimension(230, 26));
        txtFecIngr.setMinimumSize(new java.awt.Dimension(230, 26));
        txtFecIngr.setPreferredSize(new java.awt.Dimension(230, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(104, 104, 104)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFecIngr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIngrNomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtIngrApePa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtIngDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtIngrApeMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(69, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(btnIngrFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(24, 24, 24)
                        .addComponent(txtCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(titulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIngDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIngrNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIngrApePa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIngrApeMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(txtFecIngr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIngrFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        ModuloEmp mEmp = new ModuloEmp();

        mEmp.setSize(new Dimension(970, 600));
        mEmp.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mEmp, BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(237, 19, 19));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(53,66,89));
    }//GEN-LAST:event_btnExitMouseExited

    private void txtIngDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngDNIActionPerformed

    private void txtIngrNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngrNombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngrNombActionPerformed

    private void txtIngrApePaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngrApePaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngrApePaActionPerformed

    private void txtIngrApeMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngrApeMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngrApeMaActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if(ModuloEmp.tipooo==1){
            agregarEmpleado();
        }else if(ModuloEmp.tipooo==2){
            actualizarEmpleado();
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        btnAgregar.setBackground(new Color(194, 222, 209));
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        btnAgregar.setBackground(new Color(205,194,174));
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnIngrFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngrFotoActionPerformed
        JFileChooser se = new JFileChooser();
        //se.setMultiSelectionEnabled(false);
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        
        if(estado == JFileChooser.APPROVE_OPTION){
            try {
                
                fis = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_DEFAULT);
                lblFotoUser.setIcon(new ImageIcon(icono));
                lblFotoUser.updateUI();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error en el primer catch");
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Error en el segundo catch");
            }
            
        }
    }//GEN-LAST:event_btnIngrFotoActionPerformed

    private void btnIngrFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngrFotoMouseClicked
        
    }//GEN-LAST:event_btnIngrFotoMouseClicked

    private void txtCodEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEmpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JButton btnIngrFoto;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblFotoUser;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtCodEmp;
    private com.toedter.calendar.JDateChooser txtFecIngr;
    private com.toedter.calendar.JDateChooser txtFecNac;
    private javax.swing.JTextField txtIngDNI;
    private javax.swing.JTextField txtIngrApeMa;
    private javax.swing.JTextField txtIngrApePa;
    private javax.swing.JTextField txtIngrNomb;
    // End of variables declaration//GEN-END:variables
}
