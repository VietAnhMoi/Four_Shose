/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Viet Anh
 */
public class XuatXu {
    private String idXuatXu;
    private String xuatXu;

    public XuatXu() {
    }

    public XuatXu(String idXuatXu, String xuatXu) {
        this.idXuatXu = idXuatXu;
        this.xuatXu = xuatXu;
    }

    public XuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
//    @Override
//    public String toString() {
//        return xuatXu;
//    }

    @Override
    public String toString() {
        return xuatXu;
    }

    public String getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(String idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    
}
