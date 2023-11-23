/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CTSanPham;
import model.MauSac;

/**
 *
 * @author Viet Anh
 */
public class MauSacService {
    public List<MauSac> getAll() {
        try {
            String sql = "select id, tenmau from mauSac";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<MauSac> list = new ArrayList<>();
                    while (rs.next()) {                        
                        MauSac x = new MauSac();
                        x.setId(rs.getString("ID"));
                        x.setMauSac(rs.getString("tenmau"));
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
