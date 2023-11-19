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
import model.Hang;
import model.Size;

/**
 *
 * @author Viet Anh
 */
public class HangService {
    public List<Hang> getAll() {
        try {
            String sql = "select Hang from SanPham";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<Hang> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Hang x = new Hang();
                        x.setTenHang(rs.getString("Hang"));
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
