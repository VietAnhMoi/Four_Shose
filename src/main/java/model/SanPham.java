/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Viet Anh
 */
public class SanPham {
    private int idSP;
    private String tenSP, hang;
    private int trangThai;
    private double giaTien;

    public SanPham() {
    }

    public SanPham(int idSP, String tenSP, String hang, int trangThai, double giaTien) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.hang = hang;
        this.trangThai = trangThai;
        this.giaTien = giaTien;
    }

    public SanPham(String tenSP, String hang, int trangThai, double giaTien) {
        this.tenSP = tenSP;
        this.hang = hang;
        this.trangThai = trangThai;
        this.giaTien = giaTien;
    }
    
    

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

//    public String isHang() {
//        if (hang.equals(1)) {
//            return "Mỹ";
//        } else if (hang.equals(2)) {
//            return "Việt Nam";
//        } else if (hang.equals(3)) {
//            return "Trung Quốc";
//        } else {
//            return "Nhật Bản";
//        }
//    }
//     
    public Object[] toData() {
        return new Object[] {idSP, tenSP, hang,giaTien, trangThai};
    }
}
