

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CTSanPham;
import model.SanPham;

/**
 *
 * @author Viet Anh
 */
public class CTSanPhamService {
    public List<CTSanPham> getAll() {
        try {
            String sql = "";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<CTSanPham> list = new ArrayList<>();
                    while (rs.next()) {                        
                        CTSanPham x = new CTSanPham();
                        x.setHinhAnh(rs.getString("HinhAnh"));
                        x.setMauSac(rs.getString("MauSac"));
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
}
