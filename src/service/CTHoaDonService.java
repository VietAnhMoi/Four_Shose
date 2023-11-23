/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CTHoaDon;

/**
 *
 * @author nguye
 */
public class CTHoaDonService {

    public List<CTHoaDon> getAll() {
        try {
            String sql = "SELECT * FROM Hoadonchitiet";
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
}
