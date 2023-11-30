/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CTDonHangJoinHoaDon;
import model.CTHoaDon;
import view.QLHoaDonJDialog;

/**
 *
 * @author nguye
 */
public class CTHoaDonService {

    public List<CTHoaDon> getAll() {
        try {
            String sql = "select * from CHITIETHOADON";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try (ResultSet rs = ps.executeQuery();) {
                    List<CTHoaDon> list = new ArrayList<>();
                    while (rs.next()) {
                        CTHoaDon cthd = new CTHoaDon();
                        cthd.setId(rs.getString("id"));
                        cthd.setIdHoaDon(rs.getString("IDHOaDOn"));
                        cthd.setIdSanPham(rs.getString("idSanPham"));
                        cthd.setIdKhachHang(rs.getString("idkhachHang"));
                        cthd.setIdNhanVien(rs.getString("idnhanvien"));
                        cthd.setSoLuong(rs.getInt("soluong"));
                        cthd.setThanhTien(rs.getLong("TongTien"));
                        cthd.setIdCTDonHang(rs.getString("idCTDonHang"));
                        list.add(cthd);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CTHoaDon> getAllCTDH(int maDH) {
        try {
            String sql = "select hdct.* from chitiethoadon hdct join HOADON  hd on hdct.IDHoaDon = hd.ID\n"
                    + "                    where hd.idDonHang = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, maDH);
                try (ResultSet rs = ps.executeQuery();) {
                    List<CTHoaDon> list = new ArrayList<>();
                    while (rs.next()) {
                        CTHoaDon cthd = new CTHoaDon();
                        cthd.setId(rs.getString("id"));
                        cthd.setIdHoaDon(rs.getString("IDHOaDOn"));
                        cthd.setIdSanPham(rs.getString("idSanPham"));
                        cthd.setIdKhachHang(rs.getString("idkhachHang"));
                        cthd.setIdNhanVien(rs.getString("idnhanvien"));
                        cthd.setSoLuong(rs.getInt("soluong"));
                        cthd.setThanhTien(rs.getLong("TongTien"));

                        list.add(cthd);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CTDonHangJoinHoaDon> selectCTDonHang(int maHD) {
        try {
            String sql = "SELECT CHITIETDONHANG.*, HOADON.ID AS 'idhoadon'\n"
                    + "FROM     CHITIETDONHANG INNER JOIN\n"
                    + "                  HOADON ON CHITIETDONHANG.IDDonHang = HOADON.IDDonHang\n"
                    + "				  where CHITIETDONHANG.IDDonHang = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setObject(1, maHD);
                try (ResultSet rs = ps.executeQuery();) {
                    List<CTDonHangJoinHoaDon> list = new ArrayList<>();
                    while (rs.next()) {
                        CTDonHangJoinHoaDon ctDH = new CTDonHangJoinHoaDon();
                        ctDH.setIdCTDH(rs.getString("id"));
                        ctDH.setIdDonHang(rs.getString("IDDonHang"));
                        ctDH.setIdSanPham(rs.getString("idSanPham"));
                        ctDH.setSoLuong(rs.getInt("soluong"));
                        ctDH.setGiaBan(rs.getLong("giaban"));
                        ctDH.setThanhTien(rs.getLong("thanhtien"));
                        ctDH.setIdHoaDon(rs.getString("idhoadon"));

                        list.add(ctDH);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(CTHoaDon ctHd) {
        QLHoaDonJDialog ql = new QLHoaDonJDialog();
        try {
            String sql = "INSERT INTO CHITIETHOADON\n"
                    + "                  ( IDHoaDon, IDSanPham, IDKhachHang, IDNHanVien, SoLuong, TongTien,idCTDonHang)\n"
                    + "VALUES ( ?, ?, ?, ?, ?, ?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

                ps.setString(1, ctHd.getIdHoaDon());
                ps.setString(2, ctHd.getIdSanPham());
//                ps.setString(3, ctHd.getIdKhachHang());
                ps.setString(3, ql.idKHang);

                ps.setString(4, ctHd.getIdNhanVien());
                ps.setInt(5, ctHd.getSoLuong());
                ps.setLong(6, ctHd.getThanhTien());
                ps.setString(7, ctHd.getIdCTDonHang());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean deleteCTHD(String maCTHD) {
        try {
            String sql = "delete from CHITIETHOADON where id = ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setString(1, maCTHD);

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getidCTHoaDon(String idCTHd) {
        String sql = "select * from ChiTietHoaDon where idHoaDon = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setObject(1, idCTHd);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

}
