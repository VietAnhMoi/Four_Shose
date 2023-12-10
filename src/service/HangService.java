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
import model.Hang;
import model.MauSac;

/**
 *
 * @author Viet Anh
 */
public class HangService {
    public List<Hang> getAll() {
        try {
            String sql = "select id, tenHang from Hang";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<Hang> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Hang x = new Hang();
                        x.setIdHang(rs.getString("id"));
                        x.setTenHang(rs.getString("tenHang"));
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
    
    public List<Hang> getByID(String id) {
        try {
            String sql = "select * from Hang where id like ? and tenHang like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                ps.setObject(2, "%" + id + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<Hang> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Hang x = new Hang();
                        x.setIdHang(rs.getString("id"));
                        x.setTenHang(rs.getString("tenHang"));
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
    
    public Hang getByID2(String id) {
        try {
            String sql = "select id, tenHang from Hang where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        Hang x = new Hang();
                        x.setIdHang(rs.getString("id"));
                        x.setTenHang(rs.getString("tenHang"));
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
    
    public boolean insert(Hang x) {
        try {
            String sql = "insert into hang (id, tenHang) values (?,?)";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdHang());
                ps.setObject(2, x.getTenHang());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Hang x) {
        try {
            String sql = "update hang set tenhang = ? where id = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(2, x.getIdHang());
                ps.setObject(1, x.getTenHang());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String ma) {
        try {
            String sql = "delete from hang where id = ?";
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
