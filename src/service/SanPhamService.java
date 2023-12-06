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
            String sql = "INSERT INTO [dbo].[SanPham] ([ID],[TenSanPham],[GiaTien],[SoLuong],[TrangThai],[HinhAnh],[IDHang],[IDXuatXu],[IDMauSac],[IDSize],[MoTa]) values (?,?,?,?,?,?,?,?,?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, x.getIdSP());
                ps.setObject(2, x.getTenSP());
                ps.setObject(3, x.getGiaTien());
                ps.setObject(4, x.getSoLuong());
                ps.setObject(5, x.getTrangThai());
                ps.setObject(6, x.getHinhAnh());
                ps.setObject(7, x.getHang());
                ps.setObject(8, x.getXuatXu());
                ps.setObject(9, x.getMauSac());
                ps.setObject(10, x.getSize());
                ps.setObject(11, x.getMoTa());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPham x, String id) {
        try {
            String sql = "UPDATE [dbo].[SanPham] SET [TenSanPham] = ?,[GiaTien] = ?,[SoLuong] = ?\n"
                    + "      ,[TrangThai] = ?,[HinhAnh] = ?,[IDHang] = ?,[IDXuatXu] = ?,[IDMauSac] = ?\n"
                    + "      ,[IDSize] = ?,[MoTa] = ?,id = ? where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(11, x.getIdSP());
                ps.setObject(12, id);
                ps.setObject(1, x.getTenSP());
                ps.setObject(2, x.getGiaTien());
                ps.setObject(3, x.getSoLuong());
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
            String sql = "SELECT SanPham.ID, SanPham.TenSanPham, SanPham.GiaTien, SanPham.SoLuong, SanPham.TrangThai, SanPham.HinhAnh, Hang.TenHang, XUATXU.TenXuatXu, MAUSAC.TenMau, SIZE.TenSize, SanPham.MoTa\n"
                    + "                            FROM     Hang  Inner JOIN SanPham ON Hang.ID = SanPham.IDHang\n"
                    + "                            Inner JOIN XUATXU ON XUATXU.ID = SanPham.IDXuatXu\n"
                    + "                            Inner JOIN MAUSAC ON MAUSAC.ID = SanPham.IDMauSac\n"
                    + "                             Inner JOIN SIZE ON SIZE.ID = SanPham.IDSIZE";
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
                        x.setHang(rs.getString("TenHang"));
                        x.setXuatXu(rs.getString("TenXuatXu"));
                        x.setSize(rs.getString("TenSize"));
                        x.setMauSac(rs.getString("TenMau"));
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
            String sql = "SELECT SanPham.ID, SanPham.TenSanPham, SanPham.GiaTien, SanPham.SoLuong, SanPham.TrangThai, SanPham.HinhAnh, Hang.TenHang, XUATXU.TenXuatXu, MAUSAC.TenMau, SIZE.TenSize, SanPham.MoTa\n"
                    + " FROM     SanPham  JOIN Hang ON Hang.ID = SanPham.IDHang\n"
                    + " JOIN XUATXU ON XUATXU.ID = SanPham.IDXuatXu\n"
                    + " JOIN MAUSAC ON MAUSAC.ID = SanPham.IDMauSac\n"
                    + " JOIN SIZE ON SIZE.ID = SanPham.IDSIZE where sanpham.id like ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
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
                        x.setHang(rs.getString("TenHang"));
                        x.setXuatXu(rs.getString("TenXuatXu"));
                        x.setSize(rs.getString("TenSize"));
                        x.setMauSac(rs.getString("TenMau"));
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
            String sql = "SELECT SanPham.ID, SanPham.TenSanPham, SanPham.GiaTien, SanPham.SoLuong, SanPham.TrangThai, SanPham.HinhAnh, Hang.TenHang, XUATXU.TenXuatXu, MAUSAC.TenMau, SIZE.TenSize, SanPham.MoTa\n"
                    + " FROM     SanPham  JOIN Hang ON Hang.ID = SanPham.IDHang\n"
                    + " JOIN XUATXU ON XUATXU.ID = SanPham.IDXuatXu\n"
                    + " JOIN MAUSAC ON MAUSAC.ID = SanPham.IDMauSac\n"
                    + " JOIN SIZE ON SIZE.ID = SanPham.IDSIZE where sanpham.id like ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, "%" + id + "%");
                try (ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    if (rs.next()) {
                        SanPham x = new SanPham();
                        x.setIdSP(rs.getString("id"));
                        x.setTenSP(rs.getString("TENSANPHAM"));
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setSoLuong(rs.getInt("soLuong"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setHang(rs.getString("TenHang"));
                        x.setXuatXu(rs.getString("TenXuatXu"));
                        x.setSize(rs.getString("TenSize"));
                        x.setMauSac(rs.getString("TenMau"));
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

    public SanPham getSoLuong(String id) {
        try {
            String sql = "SELECT ID ,TenSanPham,SoLuong,GiaTien,TrangThai FROM dbo.SANPHAM where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, id);
                try (ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    if (rs.next()) {
                        SanPham x = new SanPham();
                        x.setIdSP(rs.getString("id"));
                        x.setTenSP(rs.getString("TENSANPHAM"));
                        x.setGiaTien(rs.getDouble("GiaTien"));
                        x.setSoLuong(rs.getInt("SoLuong"));
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

    public boolean updateSoLuongSP(String id, int soLuong) {
        try {
            String sql = "update SanPham set soLuong =? where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, soLuong);
                ps.setObject(2, id);

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLamMoiSL(String id, int soLuong) {
        try {
            String sql = "update SanPham set SoLuong += ? where id = 'sp1' ";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, soLuong);
                ps.setObject(2, id);

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateTrangThai(int trangThai) {
        try {
            String sql = "update SanPham set trangthai = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, trangThai);

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
