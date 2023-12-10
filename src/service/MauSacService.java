/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.MauSac;
import model.XuatXu;
import utils.DBConnect;


/**
 *
 * @author Viet Anh
 */
public class MauSacService {
    public List<MauSac> getAll() {
        try {
            String sql = "select id, tenMau from MauSac";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<MauSac> list = new ArrayList<>();
                    while (rs.next()) {                        
                        MauSac x = new MauSac();
                        x.setIdMauSac(rs.getString("ID"));
                        x.setMauSac(rs.getString("TenMau"));
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
    
    public List<MauSac> getByID(String id) {
        try {
            String sql = "select id, tenMau from MauSac where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<MauSac> list = new ArrayList<>();
                    while (rs.next()) {                        
                        MauSac x = new MauSac();
                        x.setIdMauSac(rs.getString("id"));
                        x.setMauSac(rs.getString("tenMau"));
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
    
    public MauSac getByID2(String id) {
        try {
            String sql = "select id, tenMau from MauSac where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        MauSac x = new MauSac();
                        x.setIdMauSac(rs.getString("id"));
                        x.setMauSac(rs.getString("tenMau"));
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
    
    public boolean insert(MauSac x) {
        try {
            String sql = "insert into MauSac (id, tenMau) values (?,?)";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdMauSac());
                ps.setObject(2, x.getMauSac());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(MauSac x) {
        try {
            String sql = "update MauSac set tenMau = ? where id = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(2, x.getIdMauSac());
                ps.setObject(1,  x.getMauSac());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String ma) {
        try {
            String sql = "delete from MauSac where id = ?";
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
