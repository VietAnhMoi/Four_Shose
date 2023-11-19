/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

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
    public List<SanPham> getAll() {
        CTSanPham s = new CTSanPham();
        try {
            String sql = "";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<SanPham> list = new ArrayList<>();
                    while (rs.next()) {                        
                        SanPham x = new SanPham();
                        x.setIDSP(rs.getString("IdSP"));
                        x.setTenSP(rs.getString("tenSP"));
                        x.setHang(rs.getString("Hang"));
                        x.setTrangThai(rs.getInt("trangThai"));
                        
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
}
