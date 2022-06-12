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
public class area {
    
    private int AreaID;
    private String AreaNom;

    public area() {
    }

    public area(int AreaID, String AreaNom) {
        this.AreaID = AreaID;
        this.AreaNom = AreaNom;
    }

    public int getAreaID() {
        return AreaID;
    }

    public void setAreaID(int AreaID) {
        this.AreaID = AreaID;
    }

    public String getAreaNom() {
        return AreaNom;
    }

    public void setAreaNom(String AreaNom) {
        this.AreaNom = AreaNom;
    }
    
    
    
}
