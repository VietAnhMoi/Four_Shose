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
import model.Hang;
import model.MauSac;
import model.Size;
import model.XuatXu;

/**
 *
 * @author Viet Anh
 */
public class SanPhamService {
    public boolean insert(SanPham x) {
        try {
            String sql = "INSERT INTO dbo.SanPham (ID,TenSanPham,GiaTien,SoLuong,TrangThai,HinhAnh,IDHang,IDXuatXu,IDMauSac,IDSize,MoTa) values (?,?,?,?,?,?,?,?,?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdSP());
                ps.setObject(2, x.getTenSP());
                ps.setObject(3, x.getGiaTien());
                ps.setObject(4, x.getSoLuong());
                ps.setObject(5, x.getTrangThai());
                ps.setObject(6, x.getHinhAnh());
                ps.setObject(7, x.getHang().getId());
                ps.setObject(8, x.getXuatXu().getId());
                ps.setObject(9, x.getMauSac().getId());
                ps.setObject(10, x.getSize().getId());
                ps.setObject(11, x.getMoTa());

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
                ps.setObject(5, x.getHang().getId());
                ps.setObject(6, x.getXuatXu().getId());
                ps.setObject(7, x.getMauSac().getId());
                ps.setObject(8, x.getSize().getId());
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
            String sql = "SELECT SanPham.ID, SanPham.TenSanPham, SanPham.GiaTien, SanPham.SoLuong, SanPham.TrangThai, SanPham.HinhAnh, Hang.TenHang, XUATXU.TenXuatXu, MAUSAC.TenMau, SIZE.TenSize, SanPham.MoTa\n" +
                            " FROM     SanPham  JOIN Hang ON Hang.ID = SanPham.IDHang\n" +
                            " JOIN XUATXU ON XUATXU.ID = SanPham.IDXuatXu\n" +
                            " JOIN MAUSAC ON MAUSAC.ID = SanPham.IDMauSac\n" +
                            " JOIN SIZE ON SIZE.ID = SanPham.IDSIZE";
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
                        x.setHang(new Hang(rs.getString("tenHang")));
                        x.setXuatXu(new XuatXu( rs.getString("TenXuatXu")));
                        x.setSize(new Size(rs.getInt("TenSize")));
                        x.setMauSac(new MauSac( rs.getString("TenMau")));
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
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setSoLuong(rs.getInt("soLuong"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setHang(new Hang(rs.getString("tenHang")));
                        x.setXuatXu(new XuatXu( rs.getString("TenXuatXu")));
                        x.setSize(new Size(rs.getInt("TenSize")));
                        x.setMauSac(new MauSac( rs.getString("TenMau")));
                        x.setMoTa(rs.getString("MoTa"));
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
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setSoLuong(rs.getInt("SoLuong"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setHang(new Hang(rs.getString("Id"), rs.getString("tenHang")));
                        x.setXuatXu(new XuatXu(rs.getString("ID"), rs.getString("TenXuatXu")));
                        x.setSize(new Size(rs.getString("ID"), rs.getInt("TenSize")));
                        x.setMauSac(new MauSac(rs.getString("ID"), rs.getString("TenMau")));
                        x.setMoTa(rs.getString("MoTa"));
                        
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
