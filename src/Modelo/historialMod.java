package Modelo;

import DB.ConeDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yosh
 */
public class historialMod {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConeDB con = new ConeDB();
    Connection acce;
    
    public int addHistorial(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO historial(HistSalAnt,HistSalNue,HistFec,EmpID) VALUES(?,?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error al ingresar historial " + e);
        }
        
        return r;
    }
}
