/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class HoaDon {
    private String id;
    private String idDonHang;
    private long tongTien;

    public HoaDon() {
    }

    public HoaDon(String id, String idDonHang, long tongTien) {
        this.id = id;
        this.idDonHang = idDonHang;
        this.tongTien = tongTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        this.idDonHang = idDonHang;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idDonHang=" + idDonHang + ", tongTien=" + tongTien + '}';
    }
    
    public Object[] toDatata(){
        return new Object[]{this.id,this.idDonHang,this.tongTien};
    }
}
