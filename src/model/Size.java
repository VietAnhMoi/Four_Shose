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
    private String id;
    private int size;

    public Size() {
    }

    public Size(String id, int size) {
        this.id = id;
        this.size = size;
    }

    public Size(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "" + size + "";
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
