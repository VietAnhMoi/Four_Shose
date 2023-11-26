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
import model.KhuyenMai;
import utils.DBConnect;

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhuyenMai> getAll() {
        try {
            String sql = "SELECT ID,KMPHANTRAM,KMTHEOGIA,NGAYTAO,NGUOITAO FROM dbo.KHUYENMAI";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<KhuyenMai> list = new ArrayList<>();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIdKM(rs.getString("ID"));
                km.setKMPhanTram(rs.getDouble("KMPHANTRAM"));
                km.setKMTheoGia(rs.getInt("KMTHEOGIA"));
                km.setNgayTao(rs.getString("NGAYTAO"));
                km.setNguoiTao(rs.getString("NGUOITAO"));

                list.add(km);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int Add(KhuyenMai km) {
        String sql = "INSERT INTO KHUYENMAI(ID,KMPHANTRAM,KMTHEOGIA,NGAYTAO,NGUOITAO) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, km.getIdKM());
            ps.setDouble(2, km.getKMPhanTram());
            ps.setInt(3, km.getKMTheoGia());
            ps.setString(4, km.getNgayTao());
            ps.setString(5, km.getNguoiTao());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public int Update(KhuyenMai km, String id) {
        String sql = "UPDATE dbo.KHUYENMAI SET KMPHANTRAM=?, KMTHEOGIA=? WHERE ID=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, km.getKMPhanTram());
            ps.setInt(2, km.getKMTheoGia());
            ps.setString(3, km.getIdKM());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int Delete(String id) {
        String sql = "DELETE FROM dbo.KHUYENMAI WHERE ID=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
