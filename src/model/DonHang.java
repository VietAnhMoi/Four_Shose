/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phung
 */
public class DonHang {

    private int iddonhangdh;
    private int soluongdh;
    private int tonggiatridh;
    private String idkhuyenmaidh;
    
    public DonHang() {
    }

    public DonHang(int iddonhangdh, int soluongdh, int tonggiatridh, String idkhuyenmaidh) {
        this.iddonhangdh = iddonhangdh;
        this.soluongdh = soluongdh;
        this.tonggiatridh = tonggiatridh;
        this.idkhuyenmaidh = idkhuyenmaidh;
    }

    public int getIddonhangdh() {
        return iddonhangdh;
    }

    public void setIddonhangdh(int iddonhangdh) {
        this.iddonhangdh = iddonhangdh;
    }

    public int getSoluongdh() {
        return soluongdh;
    }

    public void setSoluongdh(int soluongdh) {
        this.soluongdh = soluongdh;
    }

    public int getTonggiatridh() {
        return tonggiatridh;
    }

    public void setTonggiatridh(int tonggiatridh) {
        this.tonggiatridh = tonggiatridh;
    }

    public String getIdkhuyenmaidh() {
        return idkhuyenmaidh;
    }

    public void setIdkhuyenmaidh(String idkhuyenmaidh) {
        this.idkhuyenmaidh = idkhuyenmaidh;
    }

    public Object[] toDatata() {
        return new Object[]{this.iddonhangdh, this.soluongdh, this.tonggiatridh, this.idkhuyenmaidh};
    }
}
