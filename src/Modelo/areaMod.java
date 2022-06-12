/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DB.ConeDB;
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
}
