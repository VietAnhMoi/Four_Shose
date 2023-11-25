/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class CTHoaDon {

    private String id;
    private String idHoaDon;
    private String idSanPham;
    private String idKhachHang;
    private String idNhanVien;
    private int soLuong;
    private String idKhuyenMai;
    private long thanhTien;
    private String idCTDonHang;

    public CTHoaDon() {
    }

    public String getIdCTDonHang() {
        return idCTDonHang;
    }

    public void setIdCTDonHang(String idCTDonHang) {
        this.idCTDonHang = idCTDonHang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "CTHoaDon{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idSanPham=" + idSanPham + ", idKhachHang=" + idKhachHang + ", idNhanVien=" + idNhanVien + ", soLuong=" + soLuong + ", idKhuyenMai=" + idKhuyenMai + ", thanhTien=" + thanhTien + '}';
    }

    public Object[] toDatata() {
        return new Object[]{this.id, this.idHoaDon, this.idSanPham, this.idNhanVien, this.soLuong, this.idKhuyenMai, this.thanhTien};
    }

}
