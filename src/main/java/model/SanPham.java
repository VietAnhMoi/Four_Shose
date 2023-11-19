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
    private String IDSP, tenSP, hang;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(String IDSP, String tenSP, String hang, int trangThai) {
        this.IDSP = IDSP;
        this.tenSP = tenSP;
        this.hang = hang;
        this.trangThai = trangThai;
    }

    public boolean isTrangThai() {
        if (trangThai == 0) {
            return false;
        }
        return true;
    }
    
    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
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
     
    public Object[] toData() {
        return new Object[] {IDSP, tenSP, hang, trangThai};
    }
}
