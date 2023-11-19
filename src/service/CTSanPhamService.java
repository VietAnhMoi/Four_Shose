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
            String sql = "SELECT IDSanPham,IDXUATXU,IDMAUSAC,IDSIZE,HINHANH,MOTA FROM dbo.CHITIETSANPHAM";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try (ResultSet rs = ps.executeQuery();) {
                    List<CTSanPham> list = new ArrayList<>();
                    while (rs.next()) {
                        CTSanPham x = new CTSanPham();
                        x.setIdSP(rs.getInt("IDSanPham"));
                        x.setXuatXu(rs.getInt("IDXUATXU"));
                        x.setMauSac(rs.getInt("IDMAUSAC"));
                        x.setSize(rs.getInt("IDSIZE"));
                        x.setHinhAnh(rs.getString("HinhAnh"));
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

    public boolean insert(CTSanPham x) {
        try {
            String sql = "INSERT INTO CHITIETSANPHAM (IDSanPham, IDXUATXU, IDMAUSAC, IDSIZE, HINHANH, MOTA) values (?,?,?,?,?,?)";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setInt(1, x.getIdSP());
                ps.setInt(2, x.getXuatXu());
                ps.setInt(3, x.getMauSac());
                ps.setInt(4, x.getSize());
                ps.setString(5, x.getHinhAnh());
                ps.setString(6, x.getMoTa());

                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
