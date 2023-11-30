/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import java.sql.*;

/**
 *
 * @author Viet Anh
 */
public class NhanVienService {
    String INSERT_SQL = "INSERT INTO [dbo].[NHANVIEN] ([ID], MatKhau,[HoTenNV],[Email],[TinhTrang],[VaiTro]) VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[NHANVIEN] SET MatKhau = ? [HoTenNV] = ?,[Email] = ?,[TinhTrang] = ?,[VaiTro] = ? where ID = ?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE ID=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE ID=?";

    public int insert(NhanVien x) {
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_SQL);) {
                ps.setObject(1, x.getId());
                ps.setObject(2, x.getMatKhau());
                ps.setObject(3, x.getHoTen());
                ps.setObject(4, x.getEmail());
                ps.setObject(5, x.getTinhTrang());
                ps.setObject(6, x.getVaiTro());
                
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(NhanVien x, String id) {
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_SQL);) {
                ps.setObject(6, x.getId());
                ps.setObject(1, x.getMatKhau());
                ps.setObject(2, x.getHoTen());
                ps.setObject(3, x.getEmail());
                ps.setObject(4, x.getTinhTrang());
                ps.setObject(5, x.getVaiTro());
                
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String id) {
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_SQL);) {
                ps.setObject(1, id);
                
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<NhanVien> getAll() {
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<NhanVien> list = new ArrayList<>();
                    while (rs.next()) {                        
                        NhanVien x = new NhanVien();
                        x.setId(rs.getString("ID"));
                        x.setMatKhau(rs.getString("MatKhau"));
                        x.setHoTen(rs.getString("HoTenNV"));
                        x.setEmail(rs.getString("Email"));
                        x.setTinhTrang(rs.getInt("TinhTrang"));
                        x.setVaiTro(rs.getInt("VaiTro"));
                        
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
    
    public NhanVien getByID(String id) {
        try {
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_SQL);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    List<NhanVien> list = new ArrayList<>();
                    while (rs.next()) {                        
                        NhanVien x = new NhanVien();
                        x.setId(rs.getString("ID"));
                        x.setMatKhau(rs.getString("MatKhau"));
                        x.setHoTen(rs.getString("HoTenNV"));
                        x.setEmail(rs.getString("Email"));
                        x.setTinhTrang(rs.getInt("TinhTrang"));
                        x.setVaiTro(rs.getInt("VaiTro"));
                        
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
}
