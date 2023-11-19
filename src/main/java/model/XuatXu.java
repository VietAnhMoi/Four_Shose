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
    private int id;
    private String xuatXu;

    public XuatXu() {
    }

    public XuatXu(int id, String xuatXu) {
        this.id = id;
        this.xuatXu = xuatXu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
    
}
