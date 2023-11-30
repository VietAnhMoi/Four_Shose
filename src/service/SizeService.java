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
import model.MauSac;
import model.Size;

/**
 *
 * @author Viet Anh
 */
public class SizeService {
    public List<Size> getAll() {
        try {
            String sql = "select id, tensize from size";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<Size> list = new ArrayList<>();
                    while (rs.next()) {                        
                        Size x = new Size();
                        x.setIdSize(rs.getString("id"));
                        x.setSize(rs.getString("tensize"));
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
