/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author nguye
 */
public class HoaDonService {

    public List<HoaDon> getAll() {
        try {
            String sql = "SELECT * FROM Hoadon";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try (ResultSet rs = ps.executeQuery();) {
                    List<HoaDon> list = new ArrayList<>();
                    while (rs.next()) {
                        HoaDon hd = new HoaDon();
                        hd.setId(rs.getString("id"));
                        hd.setNgayLap(rs.getString("NgayLap"));
                        hd.setTrangThai(rs.getInt("TrangThai"));
                        hd.setIdDonHang(rs.getString("IDDonHang"));
                        hd.setTongTien(rs.getLong("TongTien"));

                        list.add(hd);
                    }
                    return list;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(HoaDon hd) {
        try {
            String sql = "INSERT INTO HOADON\n"
                    + "                  (ID, IDDonHang, TongTien, TrangThai, NgayLap)\n"
                    + "VALUES (?, ?, ?, ?, getdate())";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setString(1, hd.getId());
                ps.setString(2, hd.getIdDonHang());
                ps.setLong(3, hd.getTongTien());
                ps.setInt(4, hd.getTrangThai());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getIdHoaDon(String idHD) {
        String sql = "select id from hoadon where id = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getMaDonHang(String idDonHang) {
        String sql = "select iddonhang from hoadon where iddonhang = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setObject(1, idDonHang);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkDonHang(String id) {
        String sql = "select id from donhang where id = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }
}
