/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
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
    
    public List<DonHang> getAll(){
        sql ="select ID, IDSanPham,SoLuong,IDKhuyenMai from DONHANG";
        List<DonHang> lst= new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DonHang dh;
                dh = new DonHang(rs.getString(1),
                        rs.getString(2),
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
        public int Delete(String id){
        sql="delete  from DONHANG where id =? ";
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
        public int Add(DonHang dh){
        sql="insert into DONHANG(ID, IDSanPham,SoLuong,IDKhuyenMai) values(?,?,?,?)";
        try {
            con=DBConnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, dh.getIddonhang());
                ps.setString(2, dh.getIdsanpham());
                ps.setInt(3, dh.getSoluong());
                ps.setString(4, dh.getIdkhuyenmai());
            return ps.executeUpdate();           
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        }
        public int Update(DonHang dh,String id){
            sql= "update HONHANG set ID=?, IDSanPham=?,SoLuong=?,IDKhuyenMai=? where  id = ?";
            try {
                con= DBConnect.getConnection();
                ps=con.prepareStatement(sql);
                ps.setString(1, dh.getIddonhang());
                ps.setString(2, dh.getIdsanpham());
                ps.setInt(3, dh.getSoluong());
                ps.setString(4, dh.getIdkhuyenmai());
                ps.setObject(5, id);
                return ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
}
