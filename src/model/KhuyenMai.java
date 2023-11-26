/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author ADMIN
 */
public class KhuyenMai {
    private String idKM;
    private double KMPhanTram;
    private int KMTheoGia;
    private String NgayTao;
    private String NguoiTao;

    public KhuyenMai() {
    }

    public KhuyenMai(String idKM, double KMPhanTram, int KMTheoGia, String NgayTao, String NguoiTao) {
        this.idKM = idKM;
        this.KMPhanTram = KMPhanTram;
        this.KMTheoGia = KMTheoGia;
        this.NgayTao = NgayTao;
        this.NguoiTao = NguoiTao;
    }

    

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public double getKMPhanTram() {
        return KMPhanTram;
    }

    public void setKMPhanTram(double KMPhanTram) {
        this.KMPhanTram = KMPhanTram;
    }

    public int getKMTheoGia() {
        return KMTheoGia;
    }

    public void setKMTheoGia(int KMTheoGia) {
        this.KMTheoGia = KMTheoGia;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

   

    public Object[] toData() {
        return new Object[]{this.idKM, this.KMPhanTram, this.KMTheoGia, this.NgayTao, this.NguoiTao};
    }
}


