/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MauSac;
import model.Size;

/**
 *
 * @author Viet Anh
 */
public class SizeService {
    public List<Size> getAll() {
        try {
            String sql = "select id, tensize from size";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<Size> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Size x = new Size();
                        x.setIdSize(rs.getString("id"));
                        x.setSize(rs.getString("tensize"));
                        list.add(x);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Size> getByID(String id) {
        try {
            String sql = "select id, tensize from Size where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<Size> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Size x = new Size();
                        x.setIdSize(rs.getString("id"));
                        x.setSize(rs.getString("tensize"));
                        list.add(x);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Size getByID2(String id) {
        try {
            String sql = "select id, tensize from Size where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        Size x = new Size();
                        x.setIdSize(rs.getString("id"));
                        x.setSize(rs.getString("tensize"));
                        return x;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean insert(Size x) {
        try {
            String sql = "insert into Size (id, tensize) values (?,?)";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdSize());
                ps.setObject(2, x.getSize());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Size x) {
        try {
            String sql = "update Size set tensize = ? where id = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(2, x.getIdSize());
                ps.setObject(1,  x.getSize());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String ma) {
        try {
            String sql = "delete from Size where id = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, ma);
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
