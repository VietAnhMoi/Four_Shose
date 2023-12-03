/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CTDonHang;
import view.QLDonHang;

/**
 *
 * @author phung
 */
public class CTDonHangService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

//    public List<CTDonHang> getAllDHCT() {
//        sql = "select ID,IDDonHang,SoLuong,GiaBan,ThanhTien,IDSanPham,IDKhuyenMai from CHITIETDONHANG";
//        List<CTDonHang> lst = new ArrayList<>();
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                CTDonHang dhct;
//                dhct = new CTDonHang(rs.getString(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getInt(4),
//                        rs.getInt(5),
//                        rs.getString(6),
//                        rs.getString(7)
//                );
//                lst.add(dhct);
//            }
//            return lst;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public int DeleteDHCT(int id) {
        sql = "delete  from CHITIETDONHANG where id =? ";
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

    public int AddDHCTisNull(CTDonHang dhct) {
        String idDonHang = null;
        sql = "INSERT INTO CHITIETDONHANG\n"
                + "                  ( IDDonHang, SoLuong, GiaBan, ThanhTien, IDSanPham)\n"
                + "VALUES ( ?, ?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idDonHang);
            ps.setInt(2, dhct.getSoluongdhct());
            ps.setInt(3, dhct.getGiabandhct());
            ps.setInt(4, dhct.getThanhtiendhct());
            ps.setString(5, dhct.getIdsanphamdhct());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int AddDHCTisNotNull(CTDonHang dhct, int idDonHang) {
//        String idDonHang = null;
        sql = "INSERT INTO CHITIETDONHANG\n"
                + "                  ( IDDonHang, SoLuong, GiaBan, ThanhTien, IDSanPham)\n"
                + "VALUES ( ?, ?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);
            ps.setInt(2, dhct.getSoluongdhct());
            ps.setInt(3, dhct.getGiabandhct());
            ps.setInt(4, dhct.getThanhtiendhct());
            ps.setString(5, dhct.getIdsanphamdhct());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//

    public int UpdateDHCT(int idDonHang) {
        sql = "update CHITIETDONHANG set IDDonHang = ? where IDDonHang is null";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<CTDonHang> getDHCTisNull() {
        sql = "select ctDH.*, sp.TenSanPham from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
                + "where ctDH.IDDonHang is null ";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CTDonHang> getHDCTisNotNull(int idDonHang) {
        sql = "select ctDH.*, sp.TenSanPham from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID where IDDonHang  = ?";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);
            rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int DeleteDHCTisNull(String maSP, int soLuong) {
        sql = "exec SP_LamMoiCTDonHang ? , ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setInt(2, soLuong);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int DeleteDHCTisNotNull(String maSP, int soLuong, int idDonHang) {
        sql = "exec SP_deleteHoaDonCho ? , ?, ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setInt(2, soLuong);
            ps.setInt(3, idDonHang);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean UpdateSoLuongDHCT(int soLuong, int thanhTien, int idDHCT) {
        sql = "update CHITIETDONHANG set soLuong = ? ,thanhtien =?  where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, thanhTien);
            ps.setInt(3, idDHCT);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CTDonHang> checkSPhaminHDCTisNull(String maSP) {
        sql = "select ctDH.*, sp.TenSanPham from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
                + "                where ctDH.IDDonHang is null and ctDH.idsanpham = ?";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public boolean checkSPhaminHDCTisNull(String maSP) {
//        try {
//            String sql = "select ctDH.*, sp.TenSanPham from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
//                    + "                where ctDH.IDDonHang is null and ctDH.idsanpham = ?";
//            try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//                ps.setString(1, maSP);
//                rs = ps.executeQuery();
//                
//                return rs.next();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public List<CTDonHang> checkSPhaminHDCTisNotNull(String maSP, int idDonHang) {
        sql = "select ctDH.*, sp.TenSanPham from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
                + "                where ctDH.IDDonHang =? and ctDH.idsanpham = ?";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);
            ps.setString(2, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteSPisNull() {
        sql = "delete from CHITIETDONHANG where id = (select  top 1 ctDH.ID from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
                + "                where ctDH.IDDonHang is null\n"
                + "				order by ctDH.ID desc)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSPisNotNull(int idDonHang) {
        sql = "delete from CHITIETDONHANG where id = (select  top 1 ctDH.ID from CHITIETDONHANG ctDH join SanPham sp on ctDH.IDSanPham = sp.ID\n"
                + "                             where ctDH.IDDonHang = ?\n"
                + "              			order by ctDH.ID desc)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CTDonHang> selectHDjoinCTDH(int idDonHang) {
        sql = "select ctDH.*,sp.tenSanPham from chitietdonhang ctDH join sanpham sp on ctDH.idSanPham = sp.id "
                + "join HoaDon HD on HD.idDonHang = ctDH.idDonHang "
                + "where Hd.idDonHang =? ";
        List<CTDonHang> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDonHang);
            rs = ps.executeQuery();
            while (rs.next()) {
                CTDonHang dhct = new CTDonHang(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));

                lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
