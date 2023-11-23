/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
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
                    + "                  (ID, IDDonHang, TongTien)\n"
                    + "VALUES (?, ?, ?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setString(1, hd.getId());
                ps.setString(2, hd.getIdDonHang());
                ps.setLong(3, hd.getTongTien());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
   
}
