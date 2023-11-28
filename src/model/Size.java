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
    private int size;

    public Size() {
    }

    public Size(String idSize, int size) {
        this.idSize = idSize;
        this.size = size;
    }

    public Size(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "" + size + "";
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
