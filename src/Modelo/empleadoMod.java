/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DB.ConeDB;
import Entidad.empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoshi
 */
public class empleadoMod {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConeDB con = new ConeDB();
    Connection acce;
    
    //Validamos los campos del login...
    public Entidad.empleado validarEmpleado(int idE){
        Entidad.empleado entE = new empleado();
        String estado="ACTIVO";
        
        String msql = "SELECT * FROM empleado WHERE EmpID=? AND EmpEstd=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idE);
            ps.setString(2, estado);
            rs = ps.executeQuery();
            while(rs.next()){
                entE.setEmpID(rs.getInt(1));
                entE.setEmpDNI(rs.getString(2));
                entE.setEmpNomb(rs.getString(3));
                entE.setEmpApePate(rs.getString(4));
                entE.setEmpApeMat(rs.getString(5));
                entE.setGenero(rs.getString(6));
                entE.setEmpFecNac(rs.getString(7));
                entE.setEmpFecIngr(rs.getString(8));
                entE.setEmpSalario(rs.getDouble(9));
                entE.setEmpEstd(rs.getString(10));
                entE.setEmpFoto(rs.getInt(11));
                entE.setAreaID(rs.getInt(12));
            }
            
        } catch (Exception e) {
            System.out.println("Error al validar empleado en el modulo de empleado:  " + e);
        }
        
        return entE;
    }
    
    //Haciendo la consulta para mostrar los datos del empleado en una tabla
    public DefaultTableModel consultarEmpleado(String b){
        String []titulos={"ID","DNI","NOMBRES","APELLIDOS","FECHA INGRESO","SALARIO","AREA"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[7];
        
        String sql = "SELECT e.EmpID,e.EmpDNI,e.EmpNomb,e.EmpApePate,e.EmpApeMat,e.EmpFecIngr,e.EmpSalario,a.AreaNom FROM empleado e INNER JOIN area a ON e.AreaID=a.AreaID WHERE e.EmpEstd='ACTIVO' AND (e.EmpDNI LIKE '%" + b + "%' OR e.EmpNomb LIKE '%" + b +"%')";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4)+" "+rs.getString(5);
                o[4] = rs.getString(6);
                o[5] = rs.getDouble(7);
                o[6] = rs.getString(8);
                
                m.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("error consultar datos del paciente para mostrar en la tabla: " + e);
        }

        return m;
    }
    
    //Haciendo la consulta para mostrar los datos del empleado en una tabla
    public DefaultTableModel consultarEmpleado2(String b){
        String []titulos={"ID","DNI","NOMBRES","APELLIDOS","FECHA NACIMIENTO","GENERO","FECHA INGRESO","SALARIO","ESTADO","AREA"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[10];
        
        String sql = "SELECT e.EmpID,e.EmpDNI,e.EmpNomb,e.EmpApePate,e.EmpApeMat,e.EmpFecNac,e.Genero,e.EmpFecIngr,e.EmpSalario,e.EmpEstd,a.AreaNom FROM empleado e INNER JOIN area a ON e.AreaID=a.AreaID WHERE e.EmpEstd='ACTIVO' AND (a.AreaNom LIKE '%" + b + "%')";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4)+" "+rs.getString(5);
                o[4] = rs.getString(6);
                o[5] = rs.getString(7);
                o[6] = rs.getString(8);
                o[7] = rs.getDouble(9);
                o[8] = rs.getString(10);
                o[9] = rs.getString(11);
                
                m.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("error consultar datos del empelado en reportes para mostrar en la tabla: " + e);
        }

        return m;
    }
    
    public Entidad.empleado datosEmp(int idEmp){
        Entidad.empleado entE = new empleado();
        
        String sql = "SELECT * FROM empleado WHERE EmpID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setInt(1, idEmp);
            rs = ps.executeQuery();
            while(rs.next()){
                entE.setEmpID(rs.getInt(1));
                entE.setEmpDNI(rs.getString(2));
                entE.setEmpNomb(rs.getString(3));
                entE.setEmpApePate(rs.getString(4));
                entE.setEmpApeMat(rs.getString(5));
                entE.setGenero(rs.getString(6));
                entE.setEmpFecNac(rs.getString(7));
                entE.setEmpFecIngr(rs.getString(8));
                entE.setEmpSalario(rs.getDouble(9));
                entE.setEmpEstd(rs.getString(10));
                entE.setEmpFoto(rs.getInt(11));
                entE.setAreaID(rs.getInt(12));
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos de area:  " + e);
        }
        
        return entE;
    }
    
    public int validarEmpUsuario(int idEmp){
        int c=0;
        
        String sql = "SELECT UsuID FROM usuario WHERE EmpID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setInt(1, idEmp);
            rs = ps.executeQuery();
            while(rs.next()){
                c = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos de area:  " + e);
        }
        
        return c;
    }
    
    public void cargarComboArea(JComboBox cbo){
        
        String sql = "SELECT AreaNom FROM area";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            cbo.removeAllItems();
            cbo.addItem("Seleccione");
            
            while(rs.next()){
                cbo.addItem(rs.getString(1));
            }
            
        } catch (Exception e) {
            System.out.println("Error en combo Area: " + e);
        }
    }
    
    public int updateEmpleado(Object[] o) {
        int r = 0;
        String sql = "UPDATE empleado SET EmpSalario=?, AreaID=? WHERE EmpID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error actualizar salirio de los empleados" + e);
        }
        
        return r;
    } 
    
    public int addEmpleado(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO empleado(EmpDNI,EmpNomb,EmpApePate,EmpApeMat,Genero,EmpFecNac,EmpFecIngr,EmpSalario,EmpEstd,EmpFoto,AreaID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            ps.setObject(10, o[9]);
            ps.setObject(11, o[10]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al ingresar empleado  " + e);
        }
        
        return r;
    }
    
    public int maxcodEmp(){
        int c=0;
        
        String sql = "SELECT max(EmpID) FROM empleado";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos de del ultimo id del empleado:  " + e);
        }
        
        return c;
    }
    
    public int updateEmpleado2(Object[] o) {
        int r = 0;
        String sql = "UPDATE empleado SET EmpDNI=?, EmpNomb=?, EmpApePate=?, EmpApeMat=?, Genero=?, EmpFecNac=? WHERE EmpID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error actualizar empeladoooo de los empleados" + e);
        }
        
        return r;
    } 
}

