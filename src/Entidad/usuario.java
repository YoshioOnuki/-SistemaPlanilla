/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author yoshi
 */
public class usuario {
    private int UsuID;
    private String Usuario;
    private String Contrasenia;
    private String UsuEstd;

    public usuario() {
    }

    public usuario(int UsuID, String Usuario, String Contrasenia, String UsuEstd) {
        this.UsuID = UsuID;
        this.Usuario = Usuario;
        this.Contrasenia = Contrasenia;
        this.UsuEstd = UsuEstd;
    }

    public int getUsuID() {
        return UsuID;
    }

    public void setUsuID(int UsuID) {
        this.UsuID = UsuID;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public String getUsuEstd() {
        return UsuEstd;
    }

    public void setUsuEstd(String UsuEstd) {
        this.UsuEstd = UsuEstd;
    }
    
    
    
}
