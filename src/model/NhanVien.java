/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Viet Anh
 */
public class NhanVien {
    private String id;
    private String matKhau;
    private String hoTen;
    private String email;
    private int tinhTrang;
    private int vaiTro;

    public NhanVien() {
    }

    public NhanVien(String id, String matKhau, String hoTen, String email, int tinhTrang, int vaiTro) {
        this.id = id;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.email = email;
        this.tinhTrang = tinhTrang;
        this.vaiTro = vaiTro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    public boolean isVaiTro() {
        if (vaiTro == 0) {
            return false;
        }
        return true;
    }
    public Object[] toData() {
        return new Object[]{this.id, this.hoTen, this.email, this.matKhau, this.tinhTrang,this.vaiTro};
    }
}
