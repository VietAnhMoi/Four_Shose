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
import model.XuatXu;

/**
 *
 * @author Viet Anh
 */
public class XuatXuService {
    public List<XuatXu> getAll() {
        try {
            String sql = "select id,TENXUATXU from XuatXu";
            try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();) {
                    List<XuatXu> list = new ArrayList<>();
                    while (rs.next()) {                        
                        XuatXu x = new XuatXu();
                        x.setId(rs.getString("ID"));
                        x.setXuatXu(rs.getString("TENXUATXU"));
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
