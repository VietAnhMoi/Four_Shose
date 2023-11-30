/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DonHang;

/**
 *
 * @author phung
 */
public class DonHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<DonHang> getIDDonHang() {
        sql = "select top 1* from DONHANG order by id desc ";
        List<DonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DonHang dh;
                dh = new DonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                lst.add(dh);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public int DeleteDH(String id) {
//        sql = "delete  from DONHANG where id =? ";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, id);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
    public int AddDH(DonHang dh) {
        sql = "INSERT INTO DONHANG\n"
                + "                  ( SoLuong, TongGiaTri,IDKhuyenMai)\n"
                + "	VALUES ( ?, ?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dh.getSoluongdh());
            ps.setObject(2, dh.getTonggiatridh());
            ps.setObject(3, dh.getIdkhuyenmaidh());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//
//    public int UpdateDH(DonHang dh, String id) {
//        sql = "update DONHANG set ID=?,SoLuong=?,TongGiaTri=?,IDKhuyenMai=? where  id = ?";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, dh.getIddonhangdh());
//            ps.setInt(2, dh.getSoluongdh());
//            ps.setInt(3, dh.getTonggiatridh());
//            ps.setString(4, dh.getIdkhuyenmaidh());
//            ps.setObject(5, id);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
    
     public boolean deleteHDcho(int maDH) {
        try {
            String sql = "exec SP_deleteDonHang ?";
            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setInt(1, maDH);
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
<<<<<<< HEAD
=======
          public List<DonHang> findidDH(String id){
        List<DonHang> lst = new ArrayList<>();
        sql = "select ID,SoLuong,TongGiaTri,IDKhuyenMai from DonHang where id Like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + id + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang(
                         rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4));
                lst.add(dh);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
>>>>>>> 07ab63f86a56c045f2bd617e746da5bf157ec66b
    }
}
