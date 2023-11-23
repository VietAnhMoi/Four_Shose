/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CTDonHangJoinHoaDon;
import model.CTHoaDon;

/**
 *
 * @author nguye
 */
public class CTHoaDonService {

    public List<CTHoaDon> getAll(String maDH) {
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
                        cthd.setIdKhuyenMai(rs.getString("idKhuyenMai"));
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

    public List<CTDonHangJoinHoaDon> selectCTDonHang(String maHD) {
        try {
            String sql = "SELECT CHITIETDONHANG.*, HOADON.ID AS 'Ma hoa don'\n"
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
                        ctDH.setIdKhuyenMai(rs.getString("idKhuyenMai"));
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

    public boolean insert(CTHoaDon ctHd) {
        try {
            String sql = "INSERT INTO CHITIETHOADON\n"
                    + "                  ( IDHoaDon, IDSanPham, IDKhachHang, IDNHanVien, SoLuong, IDKhuyenMai, TongTien)\n"
                    + "VALUES ( ?, ?, ?, ?, ?,?, ?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setString(1, ctHd.getIdHoaDon());
                ps.setString(1, ctHd.getIdSanPham());
                ps.setString(1, ctHd.getIdKhachHang());
                ps.setString(1, ctHd.getIdNhanVien());
                ps.setInt(1, ctHd.getSoLuong());
                ps.setString(1, ctHd.getIdKhuyenMai());
                ps.setLong(1, ctHd.getThanhTien());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
