/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class CTDonHangJoinHoaDon {
    private String idCTDH;
    private String idDonHang;
    private int soLuong;
    private long giaBan;
    private long thanhTien;
    private String idSanPham;
    private String idKhuyenMai;
    private String idHoaDon;

    public CTDonHangJoinHoaDon() {
    }

    public String getIdCTDH() {
        return idCTDH;
    }

    public void setIdCTDH(String idCTDH) {
        this.idCTDH = idCTDH;
    }

    public String getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(String idDonHang) {
        this.idDonHang = idDonHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public String toString() {
        return "CTDonHangJoinHoaDon{" + "idCTDH=" + idCTDH + ", idDonHang=" + idDonHang + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", thanhTien=" + thanhTien + ", idSanPham=" + idSanPham + ", idKhuyenMai=" + idKhuyenMai + ", idHoaDon=" + idHoaDon + '}';
    }
    
}
