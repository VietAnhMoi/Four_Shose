/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.MauSac;
import utils.DBConnect;


/**
 *
 * @author Viet Anh
 */
public class MauSacService {
    public List<MauSac> getAll() {
        try {
            String sql = "select id, tenMau from MauSac";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<MauSac> list = new ArrayList<>();
                    while (rs.next()) {                        
                        MauSac x = new MauSac();
                        x.setIdMauSac(rs.getString("ID"));
                        x.setMauSac(rs.getString("TenMau"));
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
