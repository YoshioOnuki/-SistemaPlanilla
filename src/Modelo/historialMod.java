package Modelo;

import DB.ConeDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

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
    
    //Haciendo la consulta para mostrar los datos del empleado en una tabla
    public DefaultTableModel consultarEmpleadoHistorial(){
        String []titulos={"ID","NOMBRES","APELLIDOS","SALARIO ANTIGUO","SALARIO NUEVO","AREA"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[6];
        
        String sql = "SELECT h.HistoID,e.EmpNomb,e.EmpApePate,e.EmpApeMat,h.HistSalAnt,h.HistSalNue,a.AreaNom FROM historial h INNER JOIN empleado e ON h.EmpID=e.EmpID INNER JOIN area a ON e.AreaID=a.AreaID WHERE e.EmpEstd='ACTIVO'";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3)+" "+rs.getString(4);
                o[3] = rs.getDouble(5);
                o[4] = rs.getDouble(6);
                o[5] = rs.getString(7);
                
                m.addRow(o);
            }
        } catch (Exception e) {
            System.out.println("error consultar datos del empelado en reportes para mostrar en la tabla: " + e);
        }

        return m;
    }
}
