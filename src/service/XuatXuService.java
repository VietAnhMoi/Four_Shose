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
import model.XuatXu;

/**
 *
 * @author Viet Anh
 */
public class XuatXuService {
    public List<XuatXu> getAll() {
        try {
            String sql = "select id, TENXUATXU from XuatXu";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<XuatXu> list = new ArrayList<>();
                    while (rs.next()) {                        
                        XuatXu x = new XuatXu();
                        x.setIdXuatXu(rs.getString("ID"));
                        x.setXuatXu(rs.getString("TENXUATXU"));
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
    
    public List<XuatXu> getByID(String id) {
        try {
            String sql = "select id, TENXUATXU from XUatXu where id like ? and TENXUATXU like = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                ps.setObject(2, "%" + id + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<XuatXu> list = new ArrayList<>();
                    while (rs.next()) {                        
                        XuatXu x = new XuatXu();
                        x.setIdXuatXu(rs.getString("id"));
                        x.setXuatXu(rs.getString("TENXUATXU"));
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
    
    public XuatXu getByID2(String id) {
        try {
            String sql = "select id, tenxuatxu from XUatXu where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {                        
                        XuatXu x = new XuatXu();
                        x.setIdXuatXu(rs.getString("id"));
                        x.setXuatXu(rs.getString("tenxuatxu"));
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
    
    public boolean insert(XuatXu x) {
        try {
            String sql = "insert into XuatXu (id, tenxuatxu) values (?,?)";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdXuatXu());
                ps.setObject(2, x.getXuatXu());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(XuatXu x) {
        try {
            String sql = "update XuatXu set tenxuatxu = ? where id = ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(2, x.getIdXuatXu());
                ps.setObject(1,  x.getXuatXu());
                
                return ps.executeUpdate() > 0;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(String ma) {
        try {
            String sql = "delete from XuatXu where id = ?";
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
