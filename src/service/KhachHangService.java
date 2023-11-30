/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;
import utils.DBConnect;

/**
 *
 * @author dinhq
 */
public class KhachHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhachHang> getAll() {
        sql = "select ID, TenKhachHang,SDT,DiaChi from KHACHHANG";
        List<KhachHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh;
                kh = new KhachHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                lst.add(kh);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int Delete(String id) {
        sql = "delete  from KHACHHANG where id =? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int Add(KhachHang dh) {
        sql = "insert into KHACHHANG(ID,TenKhachHang,SDT,DiaChi ) values(?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dh.getID());
            ps.setString(2, dh.getTen());
            ps.setString(3, dh.getSDT());
            ps.setString(4, dh.getDiaChi());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int Update(KhachHang kh, String id) {
        sql = "update KHACHHANG set ID=?, TenKhachHang=?,SDT=?,DiaChi=? where  id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getID());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getSDT());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    
    
    public List<KhachHang> getByTen(String ten) {
        sql = "select ID, TenKhachHang,SDT,DiaChi from KHACHHANG where id like ? or TenKhachHang like ?";
        List<KhachHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ten + "%");
            ps.setObject(2, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh;
                kh = new KhachHang(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                lst.add(kh);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
