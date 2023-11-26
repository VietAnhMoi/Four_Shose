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
    private String id;
    private String mauSac;

    public MauSac() {
    }

    public MauSac(String id, String mauSac) {
        this.id = id;
        this.mauSac = mauSac;
    }

    public MauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    @Override
    public String toString() {
        return mauSac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    
}
