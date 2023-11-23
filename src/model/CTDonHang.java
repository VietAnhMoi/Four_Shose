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
    private String iddonhangct;
    private String iddonhangdhct;
    private int soluongdhct;
    private int giabandhct;
    private int thanhtiendhct;
    private String idsanphamdhct;
    private String idkhuyenmai;

    public CTDonHang() {
    }

    public CTDonHang(String iddonhangct, String iddonhangdhct, int soluongdhct, int giabandhct, int thanhtiendhct, String idsanphamdhct, String idkhuyenmai) {
        this.iddonhangct = iddonhangct;
        this.iddonhangdhct = iddonhangdhct;
        this.soluongdhct = soluongdhct;
        this.giabandhct = giabandhct;
        this.thanhtiendhct = thanhtiendhct;
        this.idsanphamdhct = idsanphamdhct;
        this.idkhuyenmai = idkhuyenmai;
    }

    public String getIddonhangct() {
        return iddonhangct;
    }

    public void setIddonhangct(String iddonhangct) {
        this.iddonhangct = iddonhangct;
    }

    public String getIddonhangdhct() {
        return iddonhangdhct;
    }

    public void setIddonhangdhct(String iddonhangdhct) {
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

    public String getIdkhuyenmai() {
        return idkhuyenmai;
    }

    public void setIdkhuyenmai(String idkhuyenmai) {
        this.idkhuyenmai = idkhuyenmai;
    }
    public Object[] toDatatadhct(){
        return new Object[]{iddonhangct,iddonhangdhct,soluongdhct,giabandhct,thanhtiendhct,idsanphamdhct,idkhuyenmai};
    }
    
}
