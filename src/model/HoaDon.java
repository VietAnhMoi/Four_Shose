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
    private int id;
    private int trangThai;
    private String ngayLap;
    private int idDonHang;
    private long tongTien;

    public HoaDon() {
    }

    public HoaDon(int id, int trangThai, String ngayLap, int idDonHang, long tongTien) {
        this.id = id;
        this.trangThai = trangThai;
        this.ngayLap = ngayLap;
        this.idDonHang = idDonHang;
        this.tongTien = tongTien;
    }

   
    public int getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(int idDonHang) {
        this.idDonHang = idDonHang;
    }

    

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", trangThai=" + trangThai + ", ngayLap=" + ngayLap + ", idDonHang=" + idDonHang + ", tongTien=" + tongTien + '}';
    }
    
    
    
    public Object[] toDatata(){
        return new Object[]{this.id,this.idDonHang,this.trangThai==1?"Đã thanh toán":"Chưa thanh toán",this.ngayLap,this.tongTien};
    }
     public Object[] toDatata1(){
        return new Object[]{this.id,this.trangThai==1?"Đã thanh toán":"Chưa thanh toán",this.ngayLap,this.idDonHang,this.tongTien};
    }
}
