/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DB.ConeDB;
import Entidad.area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoshi
 */
public class areaMod {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConeDB con = new ConeDB();
    Connection acce;
        
    
    //Haciendo la consulta para mostrar los datos de las areas en una tabla
    public DefaultTableModel consultarArea(String b){
        String []titulos={"ID","NOMBRE DE AREA"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[2];
        
        String sql = "SELECT AreaID,AreaNom FROM area WHERE (AreaID LIKE '%" + b + "%' OR AreaNom LIKE '%" + b +"%')";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                
                m.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("error consultar datos del paciente para mostrar en la tabla: " + e);
        }

        return m;
    }
    
    //aqui obtenemos todos los datos persona para poder modificarlos
    public Entidad.area datosArea(int idarea){
        Entidad.area ea = new area();
        
        String sql = "SELECT * FROM area WHERE AreaID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setInt(1, idarea);
            rs = ps.executeQuery();
            while(rs.next()){
                ea.setAreaID(rs.getInt(1));
                ea.setAreaNom(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos de area:  " + e);
        }
        
        return ea;
    }
    
    public int addArea(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO area(AreaNom) VALUES(?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al ingresar Área " + e);
        }
        
        return r;
    }
    
    public int updateArea(Object[] o) {
        int r = 0;
        String sql = "UPDATE area SET AreaNom=? WHERE AreaID=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error actualizar Área" + e);
        }
        
        return r;
    } 
    
    public int obtenerID(String nom){
        int c=0;
        
        String sql = "SELECT AreaID FROM area WHERE AreaNom=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setString(1, nom);
            rs = ps.executeQuery();
            while(rs.next()){
                c = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos de area:  " + e);
        }
        
        return c;
    }
}
