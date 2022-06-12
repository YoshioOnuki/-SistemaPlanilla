/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DB.ConeDB;
import Entidad.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yoshi
 */
public class usuarioMod {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConeDB con = new ConeDB();
    Connection acce;
    
    //Validamos los campos del login...
    public Entidad.usuario validarUsuario(String usu, String cont){
        Entidad.usuario entU = new usuario();
        String estado="ACTIVO";
        
        String msql = "SELECT * FROM usuario WHERE Usuario=? AND Contrasenia=? AND UsuEstd=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setString(1, usu);
            ps.setString(2, cont);
            ps.setString(3, estado);
            rs = ps.executeQuery();
            while(rs.next()){
                entU.setUsuID(rs.getInt(1));
                entU.setUsuario(rs.getString(2));
                entU.setContrasenia(rs.getString(3));
                entU.setUsuEstd(rs.getString(4));
            }
            
        } catch (Exception e) {
            System.out.println("Error al validad usuario en el login:  " + e);
        }
        
        return entU;
    }
}
