/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Viet Anh
 */
public class Size {
    private String idSize;
    private String size;

    public Size() {
    }

    public Size(String idSize, String size) {
        this.idSize = idSize;
        this.size = size;
    }

    public Size(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
    
}
