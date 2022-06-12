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
public class empleado {
    
    private int EmpID;
    private String EmpDNI;
    private String EmpNomb;
    private String EmpApePate;
    private String EmpApeMat;
    private String Genero;
    private String EmpFecNac;
    private String EmpFecIngr;
    private double EmpSalario;
    private String EmpEstd;
    private int EmpFoto;
    private int AreaID;

    public empleado() {
    }

    public empleado(int EmpID, String EmpDNI, String EmpNomb, String EmpApePate, String EmpApeMat, String Genero, String EmpFecNac, String EmpFecIngr, double EmpSalario, String EmpEstd, int EmpFoto, int AreaID) {
        this.EmpID = EmpID;
        this.EmpDNI = EmpDNI;
        this.EmpNomb = EmpNomb;
        this.EmpApePate = EmpApePate;
        this.EmpApeMat = EmpApeMat;
        this.Genero = Genero;
        this.EmpFecNac = EmpFecNac;
        this.EmpFecIngr = EmpFecIngr;
        this.EmpSalario = EmpSalario;
        this.EmpEstd = EmpEstd;
        this.EmpFoto = EmpFoto;
        this.AreaID = AreaID;
    }

    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
    }

    public String getEmpDNI() {
        return EmpDNI;
    }

    public void setEmpDNI(String EmpDNI) {
        this.EmpDNI = EmpDNI;
    }

    public String getEmpNomb() {
        return EmpNomb;
    }

    public void setEmpNomb(String EmpNomb) {
        this.EmpNomb = EmpNomb;
    }

    public String getEmpApePate() {
        return EmpApePate;
    }

    public void setEmpApePate(String EmpApePate) {
        this.EmpApePate = EmpApePate;
    }

    public String getEmpApeMat() {
        return EmpApeMat;
    }

    public void setEmpApeMat(String EmpApeMat) {
        this.EmpApeMat = EmpApeMat;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEmpFecNac() {
        return EmpFecNac;
    }

    public void setEmpFecNac(String EmpFecNac) {
        this.EmpFecNac = EmpFecNac;
    }

    public String getEmpFecIngr() {
        return EmpFecIngr;
    }

    public void setEmpFecIngr(String EmpFecIngr) {
        this.EmpFecIngr = EmpFecIngr;
    }

    public double getEmpSalario() {
        return EmpSalario;
    }

    public void setEmpSalario(double EmpSalario) {
        this.EmpSalario = EmpSalario;
    }

    public String getEmpEstd() {
        return EmpEstd;
    }

    public void setEmpEstd(String EmpEstd) {
        this.EmpEstd = EmpEstd;
    }

    public int getEmpFoto() {
        return EmpFoto;
    }

    public void setEmpFoto(int EmpFoto) {
        this.EmpFoto = EmpFoto;
    }

    public int getAreaID() {
        return AreaID;
    }

    public void setAreaID(int AreaID) {
        this.AreaID = AreaID;
    }
    
    
    
}
