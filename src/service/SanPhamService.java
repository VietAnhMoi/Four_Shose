/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.CTSanPham;
import model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viet Anh
 */
public class SanPhamService {
    public boolean insert(SanPham x) {
        try {
            String sql = "INSERT INTO dbo.SanPham (ID,TenSanPham,GiaTien,TrangThai,HinhAnh,IDHang,IDXuatXu,IDMauSac,IDSize,MoTa) values (?,?,?,?,?,?,?,?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdSP());
                ps.setObject(2, x.getTenSP());
                ps.setObject(3, x.getGiaTien());
                ps.setObject(4, x.getTrangThai());
                ps.setObject(5, x.getHinhAnh());
                ps.setObject(6, x.getHang());
                ps.setObject(7, x.getXuatXu());
                ps.setObject(8, x.getMauSac());
                ps.setObject(9, x.getSize());
                ps.setObject(10, x.getMoTa());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPham x) {
        try {
            String sql = "UPDATE SanPham SET TenSanPham = ?,GiaTien = ?,TrangThai = ?,HinhAnh = ?,IDHang = ?,IDXuatXu = ?,IDMauSac = ?,IDSize = ?,MoTa = ? from sanpham where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(10, x.getIdSP());
                ps.setObject(1, x.getTenSP());
                ps.setObject(2, x.getGiaTien());
                ps.setObject(3, x.getTrangThai());
                ps.setObject(4, x.getHinhAnh());
                ps.setObject(5, x.getHang());
                ps.setObject(6, x.getXuatXu());
                ps.setObject(7, x.getMauSac());
                ps.setObject(8, x.getSize());
                ps.setObject(9, x.getMoTa());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            String sql = " delete from sanpham where id like ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SanPham> getAll() {
        try {
            String sql = "SELECT SanPham.*, SIZE.TenSize FROM SanPham INNER JOIN SIZE ON SanPham.IDSize = SIZE.ID";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try (ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    while (rs.next()) {
                        SanPham x = new SanPham();
                        x.setIdSP(rs.getString("id"));
                        x.setTenSP(rs.getString("TENSANPHAM"));
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setSoLuong(rs.getInt("soLuong"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setHang(rs.getString("IDHang"));
                        x.setXuatXu(rs.getString("IDXuatXu"));
                        x.setMauSac(rs.getString("IDMauSac"));
                        x.setMoTa(rs.getString("MoTa"));
                        x.setSize(rs.getInt("TenSize"));

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

    public List<SanPham> findByName(String id) {
        try {
            String sql = "SELECT * FROM dbo.SANPHAM where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                try(ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    while (rs.next()) {                        
                        SanPham x = new SanPham();
                        x.setIdSP(rs.getString("id"));
                        x.setTenSP(rs.getString("TENSANPHAM"));
                        x.setHang(rs.getString("IDHang"));
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setHang(rs.getString("IDHang"));
                        x.setXuatXu(rs.getString("IDXuatXu"));
                        x.setMauSac(rs.getString("IDMauSac"));
                        x.setSize(rs.getInt("IDSize"));
                        x.setMoTa(rs.getString("MoTa"));
                        
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
    
    public SanPham getByID(String id) {
        try {
            String sql = "SELECT ID ,TenSanPham, IDHang,GiaTien,TrangThai FROM dbo.SANPHAM where id like ?";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try(ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    if (rs.next()) {                        
                        SanPham x = new SanPham();
                        x.setIdSP(rs.getString("id"));
                        x.setTenSP(rs.getString("TENSANPHAM"));
                        x.setHang(rs.getString("IDHang"));
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        
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
