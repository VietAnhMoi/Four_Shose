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
    private String id;
    private String xuatXu;

    public XuatXu() {
    }

    public XuatXu(String id, String xuatXu) {
        this.id = id;
        this.xuatXu = xuatXu;
    }

    public XuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
    @Override
    public String toString() {
        return xuatXu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    
}
