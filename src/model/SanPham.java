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
    private String idSP;
    private String tenSP;
    private double giaTien;
    private int soLuong;
    private int trangThai;
    private String hinhAnh;
    private Hang hang;
    private XuatXu xuatXu;
    private MauSac mauSac;
    private Size size;
    private String moTa;

    public SanPham() {
    }

    public SanPham(String idSP, String tenSP, double giaTien, int soLuong, int trangThai, String hinhAnh, Hang hang, XuatXu xuatXu, MauSac mauSac, Size size, String moTa) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
        this.hang = hang;
        this.xuatXu = xuatXu;
        this.mauSac = mauSac;
        this.size = size;
        this.moTa = moTa;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    

    public boolean isTrangThai() {
        if (trangThai == 0) {
            return false;
        }
        return true;
    }
    
    
    public String isHang() {
        if (trangThai == 0) {
            return "Không Hoạt Động";
        }
        return "Hoạt Động";
    }
    
    public Object[] toData() {
        return new Object[] {idSP, tenSP, hang,giaTien,isHang(),  xuatXu, size, mauSac, soLuong};
    }
}
