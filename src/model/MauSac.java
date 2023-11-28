/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Viet Anh
 */
public class MauSac {
    private String idMauSac;
    private String mauSac;

    public MauSac() {
    }

    public MauSac(String idMauSac, String mauSac) {
        this.idMauSac = idMauSac;
        this.mauSac = mauSac;
    }
    

    public MauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    @Override
    public String toString() {
        return mauSac;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }
    
    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    
}
