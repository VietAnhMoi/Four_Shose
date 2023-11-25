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
/**
 *
 * @author phung
 */
public class CTDonHangService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<CTDonHang> getAllDHCT(){
        sql ="select ID,IDDonHang,SoLuong,GiaBan,ThanhTien,IDSanPham,IDKhuyenMai from CHITIETDONHANG";
        List<CTDonHang> lst= new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                CTDonHang dhct;
                dhct = new CTDonHang(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)
                );
               lst.add(dhct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public int DeleteDHCT(String id){
        sql="delete  from CHITIETDONHANG where id =? ";
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }       
    }
        public int AddDHCT(CTDonHang dhct){
        sql="insert into CHITIETDONHANG (ID,IDDonHang,SoLuong,GiaBan,ThanhTien,IDSanPham,IDKhuyenMai) values(?,?,?,?,?,?,?)";
        try {
            con=DBConnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, dhct.getIddonhangct());
                ps.setString(2, dhct.getIddonhangdhct());
                ps.setInt(3, dhct.getSoluongdhct());
                ps.setInt(4, dhct.getGiabandhct());
                ps.setInt(5, dhct.getThanhtiendhct());
                ps.setString(6, dhct.getIdsanphamdhct());
                ps.setString(7, dhct.getIdkhuyenmai());
            return ps.executeUpdate();           
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        }
        public int UpdateDHCT(CTDonHang dhct,String id){
            sql= "update CHITIETDONHANG set ID=?,IDDonHang=?,SoLuong=?,GiaBan=?,ThanhTien=?,IDSanPham=?,IDKhuyenMai=? where  id = ?";
            try {
                con= DBConnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, dhct.getIddonhangct());
                ps.setString(2, dhct.getIddonhangdhct());
                ps.setInt(3, dhct.getSoluongdhct());
                ps.setInt(4, dhct.getGiabandhct());
                ps.setInt(5, dhct.getThanhtiendhct());
                ps.setString(6, dhct.getIdsanphamdhct());
                ps.setString(7, dhct.getIdkhuyenmai());
                ps.setObject(8, id);
                return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        
}
