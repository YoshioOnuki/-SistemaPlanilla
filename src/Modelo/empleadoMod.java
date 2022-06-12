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
            System.out.println("Error al validad empleado en el login:  " + e);
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
}

