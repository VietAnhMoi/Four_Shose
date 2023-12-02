/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phung
 */
public class CTDonHang {

    private int iddonhangct;
    private int iddonhangdhct;
    private int soluongdhct;
    private int giabandhct;
    private int thanhtiendhct;
    private String idsanphamdhct;
    private String tenSanPham;

    public CTDonHang() {
    }

    public CTDonHang(int iddonhangct, int iddonhangdhct, int soluongdhct, int giabandhct, int thanhtiendhct, String idsanphamdhct, String tenSanPham) {
        this.iddonhangct = iddonhangct;
        this.iddonhangdhct = iddonhangdhct;
        this.soluongdhct = soluongdhct;
        this.giabandhct = giabandhct;
        this.thanhtiendhct = thanhtiendhct;
        this.idsanphamdhct = idsanphamdhct;
        this.tenSanPham = tenSanPham;
    }

    public int getIddonhangct() {
        return iddonhangct;
    }

    public void setIddonhangct(int iddonhangct) {
        this.iddonhangct = iddonhangct;
    }

    public int getIddonhangdhct() {
        return iddonhangdhct;
    }

    public void setIddonhangdhct(int iddonhangdhct) {
        this.iddonhangdhct = iddonhangdhct;
    }

    public int getSoluongdhct() {
        return soluongdhct;
    }

    public void setSoluongdhct(int soluongdhct) {
        this.soluongdhct = soluongdhct;
    }

    public int getGiabandhct() {
        return giabandhct;
    }

    public void setGiabandhct(int giabandhct) {
        this.giabandhct = giabandhct;
    }

    public int getThanhtiendhct() {
        return thanhtiendhct;
    }

    public void setThanhtiendhct(int thanhtiendhct) {
        this.thanhtiendhct = thanhtiendhct;
    }

    public String getIdsanphamdhct() {
        return idsanphamdhct;
    }

    public void setIdsanphamdhct(String idsanphamdhct) {
        this.idsanphamdhct = idsanphamdhct;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Object[] toDatatadhct() {
        return new Object[]{this.idsanphamdhct, this.tenSanPham, this.soluongdhct, this.giabandhct, this.thanhtiendhct};
    }

}
