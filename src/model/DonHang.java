package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author phung
 */
public class DonHang {
    private String iddonhang;
    private String idsanpham;
    private int soluong;
    private String idkhuyenmai;

    public DonHang() {
    }

    public DonHang(String iddonhang, String idsanpham, int soluong, String idkhuyenmai) {
        this.iddonhang = iddonhang;
        this.idsanpham = idsanpham;
        this.soluong = soluong;
        this.idkhuyenmai = idkhuyenmai;
    }

    public String getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(String iddonhang) {
        this.iddonhang = iddonhang;
    }

    public String getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(String idsanpham) {
        this.idsanpham = idsanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getIdkhuyenmai() {
        return idkhuyenmai;
    }

    public void setIdkhuyenmai(String idkhuyenmai) {
        this.idkhuyenmai = idkhuyenmai;
    }
    
     public Object[] toDatarow() {
        return new Object[] {this.iddonhang,this.idsanpham,this.soluong,this.idkhuyenmai};
    }
    
}
