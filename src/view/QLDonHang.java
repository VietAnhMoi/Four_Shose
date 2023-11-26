/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CTDonHang;
import model.DonHang;
import service.CTDonHangService;
import service.DonHangService;


/**
 *
 * @author phung
 */
public class QLDonHang extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    DonHangService qldh = new DonHangService();
    CTDonHangService qldhct = new CTDonHangService();
    List<DonHang> lstdh= new ArrayList<>();
    List<CTDonHang> lstctdh = new ArrayList<>();
    int index = 0;
    /**
     * Creates new form QLDonHang
     */
    public QLDonHang() {
        initComponents();
        setLocationRelativeTo(null);
        FillToTableDH(qldh.getAllDH());
        FillToTableDHCT(qldhct.getAllDHCT());
        showDetailDH(index);
        showDetailDHCT(index);
    }

    QLDonHang(TrangChu aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void FillToTableDH(List<DonHang> lstdh){
        model =(DefaultTableModel) tblDonHang.getModel();
        model.setRowCount(0);
        for(DonHang dh: lstdh){
            model.addRow(dh.toDatata());
        }       
    }
    public void FillToTableDHCT(List<CTDonHang> lstdhct){
        model =(DefaultTableModel) tblDonHangChiTiet.getModel();
        model.setRowCount(0);
        for(CTDonHang dhct: lstdhct){
            model.addRow(dhct.toDatatadhct());
        }       
    }
        public void showDetailDH(int index) {
        DonHang dh =qldh.getAllDH().get(index);
        txtIdDonHangDH.setText(dh.getIddonhangdh());
        txtSoLuongDH.setText(dh.getSoluongdh()+"");
        txtTongTienDH.setText(dh.getTonggiatridh()+"");
        txtIdKhuyenMaiDH.setText(dh.getIdkhuyenmaidh());
    }
        public void showDetailDHCT(int index) {
        CTDonHang dhct =qldhct.getAllDHCT().get(index);
        txtIDDonHangCT.setText(dhct.getIddonhangct());
        txtIDDonHangDHCT.setText(dhct.getIddonhangdhct());
        txtSoLuong.setText(dhct.getSoluongdhct()+"");
        txtGiaBanDHCT.setText(dhct.getGiabandhct()+"");
        txtThanhTienDHCT.setText(dhct.getThanhtiendhct()+"");
        txtIDSanPhamDHCT.setText(dhct.getIdsanphamdhct());
        txtIDKhuyenMaiDHCT.setText(dhct.getIdkhuyenmai());
    }
        public CTDonHang readformdhct(){
        String iddonhangct =txtIDDonHangCT.getText();
        String iddonhangdhct =txtIDDonHangDHCT.getText();
        int soluongdhct=Integer.parseInt(txtSoLuong.getText());
        int giabandhct=Integer.parseInt(txtGiaBanDHCT.getText());
        int thanhtiendhct=Integer.parseInt(txtThanhTienDHCT.getText());
        String idsanphamdhct=txtIDSanPhamDHCT.getText();
        String idkhuyenmai=txtIDKhuyenMaiDHCT.getText();
        return new CTDonHang(iddonhangct, iddonhangdhct, soluongdhct, giabandhct, thanhtiendhct, idsanphamdhct, idkhuyenmai);    
    }
        boolean checkrongdhct(){
        if(txtIDDonHangCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Id đơn hàng chi tiết không được để trống");
           txtIDDonHangCT.requestFocus();
            return false;
        }
        if(txtIDDonHangDHCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Id đơn hàng không được để trống");
           txtIDDonHangDHCT.requestFocus();
            return false;
        }
        if(txtSoLuong.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống");
            txtSoLuong.requestFocus();
            return false;
        }
        if(txtGiaBanDHCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Giá bán không được để trống");
            txtGiaBanDHCT.requestFocus();
            return false;
        }
        if(txtThanhTienDHCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Thành tiền không được để trống");
            txtThanhTienDHCT.requestFocus();
            return false;
    }
        if(txtIDSanPhamDHCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "ID sản phẩm không được để trống");
            txtIDSanPhamDHCT.requestFocus();
            return false;
    }
        if(txtIDKhuyenMaiDHCT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không được để trống");
            txtIDKhuyenMaiDHCT.requestFocus();
            return false;
        }
        return true;
    }
        public DonHang readformdh(){
        String iddonhangdh =txtIdDonHangDH.getText();
        int soluongdh=Integer.parseInt(txtSoLuongDH.getText());
        int tonggiatridh=Integer.parseInt(txtTongTienDH.getText());
        String idkhuyenmaidh=txtIdKhuyenMaiDH.getText();
        return new DonHang(iddonhangdh, soluongdh, tonggiatridh, idkhuyenmaidh);    
    }
        boolean checkrong(){
        if(txtIdDonHangDH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Id đơn hàng không được để trống");
            txtIdDonHangDH.requestFocus();
            return false;
        }
        if(txtSoLuongDH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống");
            txtSoLuongDH.requestFocus();
            return false;
        }
        if(txtTongTienDH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Tổng giá trị không được để trống");
            txtTongTienDH.requestFocus();
            return false;
    }
        if(txtIdKhuyenMaiDH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không được để trống");
            txtIdKhuyenMaiDH.requestFocus();
            return false;
        }
        return true;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdDonHangDH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuongDH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTongTienDH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdKhuyenMaiDH = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiemDH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnTimDH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        btnThemDH = new javax.swing.JButton();
        txtSuaDH = new javax.swing.JButton();
        btnXoaDH = new javax.swing.JButton();
        btnMoiDH = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIDDonHangCT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIDDonHangDHCT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGiaBanDHCT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIDSanPhamDHCT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtThanhTienDHCT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIDKhuyenMaiDHCT = new javax.swing.JTextField();
        btnThemDHCT = new javax.swing.JButton();
        btnSuaDHCT = new javax.swing.JButton();
        btnXoaDHCT = new javax.swing.JButton();
        btnMoiDHCT = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnTimDHCT = new javax.swing.JButton();
        txtTimKiemDHCT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonHangChiTiet = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 3, 24)); // NOI18N
        jLabel1.setText("Quản Lý Đơn Hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Đơn Hàng");

        jLabel3.setText("ID Đơn Hàng:");

        jLabel4.setText("Số Lượng:");

        jLabel5.setText("Tổng Tiền:");

        jLabel6.setText("ID Khuyến Mãi:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Tìm Kiếm:");

        btnTimDH.setText("Tìm");

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Đơn Hàng", "Số Lượng", "Tổng Tiền", "ID Khuyến Mãi"
            }
        ));
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(txtTimKiemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnTimDH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTimKiemDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemDH.setText("Thêm");
        btnThemDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDHActionPerformed(evt);
            }
        });

        txtSuaDH.setText("Sửa");
        txtSuaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaDHActionPerformed(evt);
            }
        });

        btnXoaDH.setText("Xóa");
        btnXoaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDHActionPerformed(evt);
            }
        });

        btnMoiDH.setText("Mới");
        btnMoiDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIdDonHangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSoLuongDH, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTongTienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdKhuyenMaiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel2)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiDH)
                            .addComponent(btnXoaDH)
                            .addComponent(txtSuaDH)
                            .addComponent(btnThemDH)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtIdDonHangDH, txtIdKhuyenMaiDH, txtSoLuongDH, txtTongTienDH});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoiDH, btnThemDH, btnXoaDH, txtSuaDH});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdDonHangDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuongDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuaDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTienDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdKhuyenMaiDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiDH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtIdDonHangDH, txtIdKhuyenMaiDH, txtSoLuongDH, txtTongTienDH});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMoiDH, btnThemDH, btnXoaDH, txtSuaDH});

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel8.setText("Đơn Hàng Chi Tiết");

        jLabel9.setText("ID Đơn Hàng CT:");

        jLabel10.setText("ID Đơn Hàng:");

        txtIDDonHangDHCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDDonHangDHCTActionPerformed(evt);
            }
        });

        jLabel11.setText("Số Lượng:");

        jLabel12.setText("Giá Bán:");

        jLabel13.setText("Thành Tiền:");

        jLabel14.setText("ID Sản Phẩm:");

        jLabel15.setText("ID Khuyến Mãi:");

        btnThemDHCT.setText("Thêm");
        btnThemDHCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDHCTActionPerformed(evt);
            }
        });

        btnSuaDHCT.setText("Sửa");
        btnSuaDHCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDHCTActionPerformed(evt);
            }
        });

        btnXoaDHCT.setText("Xóa");
        btnXoaDHCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaDHCTMouseClicked(evt);
            }
        });

        btnMoiDHCT.setText("Mới");
        btnMoiDHCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDHCTActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimDHCT.setText("Tìm");

        jLabel16.setText("Tìm Kiếm:");

        tblDonHangChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Đơn Hàng CT", "ID Đơn Hàng", "Số Lượng", "Giá Bán", "Thành Tiền", "ID Sản Phẩm", "ID Khuyến Mãi"
            }
        ));
        tblDonHangChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonHangChiTiet);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimDHCT)
                        .addGap(40, 40, 40))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimDHCT)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBanDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtIDDonHangDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDSanPhamDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThanhTienDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDKhuyenMaiDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDDonHangCT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemDHCT)
                    .addComponent(btnSuaDHCT)
                    .addComponent(btnXoaDHCT)
                    .addComponent(btnMoiDHCT))
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtGiaBanDHCT, txtIDDonHangCT, txtIDDonHangDHCT, txtSoLuong});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtIDKhuyenMaiDHCT, txtIDSanPhamDHCT, txtThanhTienDHCT});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoiDHCT, btnSuaDHCT, btnThemDHCT, btnXoaDHCT});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIDDonHangCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtThanhTienDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDHCT))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtIDSanPhamDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaDHCT)
                            .addComponent(txtIDDonHangDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtIDKhuyenMaiDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaDHCT))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGiaBanDHCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiDHCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtGiaBanDHCT, txtIDDonHangCT, txtIDDonHangDHCT, txtSoLuong});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtIDKhuyenMaiDHCT, txtIDSanPhamDHCT, txtThanhTienDHCT});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMoiDHCT, btnSuaDHCT, btnThemDHCT, btnXoaDHCT});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(496, 496, 496))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDDonHangDHCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDDonHangDHCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDDonHangDHCTActionPerformed

    private void btnThemDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDHActionPerformed
        // TODO add your handling code here:
        if(checkrong()){
            DonHang dh = readformdh();
            if(qldh.AddDH(dh)!=0){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                FillToTableDH(qldh.getAllDH());
        }else{
           JOptionPane.showMessageDialog(this, "Thêm không thành công"); 
        }       }
    }//GEN-LAST:event_btnThemDHActionPerformed

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        // TODO add your handling code here:
        index = tblDonHang.getSelectedRow();
        showDetailDH(index);
    }//GEN-LAST:event_tblDonHangMouseClicked

    private void tblDonHangChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangChiTietMouseClicked
        // TODO add your handling code here:
        index = tblDonHangChiTiet.getSelectedRow();
        showDetailDHCT(index);
    }//GEN-LAST:event_tblDonHangChiTietMouseClicked

    private void txtSuaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaDHActionPerformed
        // TODO add your handling code here:
        if(checkrong()){
            index = tblDonHang.getSelectedRow();
            DonHang dh = readformdh();
            String id =tblDonHang.getValueAt(index, 0).toString();
          if(qldh.UpdateDH(dh, id)>0){
            JOptionPane.showMessageDialog(this, "Update thành công");
            FillToTableDH(qldh.getAllDH());
        }else{
            JOptionPane.showMessageDialog(this, "Update không thành công");
        }        }
    }//GEN-LAST:event_txtSuaDHActionPerformed

    private void btnXoaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDHActionPerformed
        // TODO add your handling code here:
        index =tblDonHang.getSelectedRow();
        String id =tblDonHang.getValueAt(index, 0).toString();       
            if(qldh.DeleteDH(id)!=0){
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            this.FillToTableDH(qldh.getAllDH());
            }else{
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
            }
    }//GEN-LAST:event_btnXoaDHActionPerformed

    private void btnMoiDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDHActionPerformed
        // TODO add your handling code here:
        txtIdDonHangDH.setText("");
        txtSoLuongDH.setText("");
        txtTongTienDH.setText("");
        txtIdKhuyenMaiDH.setText("");
    }//GEN-LAST:event_btnMoiDHActionPerformed

    private void btnThemDHCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDHCTActionPerformed
        // TODO add your handling code here:
        if(checkrongdhct()){
            CTDonHang dhct = readformdhct();
            if(qldhct.AddDHCT(dhct)!=0){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                FillToTableDHCT(qldhct.getAllDHCT());
        }else{
           JOptionPane.showMessageDialog(this, "Thêm không thành công"); 
        }       }
    }//GEN-LAST:event_btnThemDHCTActionPerformed

    private void btnSuaDHCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDHCTActionPerformed
        // TODO add your handling code here:
        if(checkrongdhct()){
            index = tblDonHangChiTiet.getSelectedRow();
            CTDonHang dhct = readformdhct();
            String id =tblDonHangChiTiet.getValueAt(index, 0).toString();
          if(qldhct.UpdateDHCT(dhct, id)>0){
            JOptionPane.showMessageDialog(this, "Update thành công");
            FillToTableDHCT(qldhct.getAllDHCT());
        }else{
            JOptionPane.showMessageDialog(this, "Update không thành công");
        }        }
    }//GEN-LAST:event_btnSuaDHCTActionPerformed

    private void btnXoaDHCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaDHCTMouseClicked
        // TODO add your handling code here:
        index =tblDonHangChiTiet.getSelectedRow();
        String id =tblDonHangChiTiet.getValueAt(index, 0).toString();       
            if(qldhct.DeleteDHCT(id)!=0){
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            this.FillToTableDHCT(qldhct.getAllDHCT());
            }else{
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
            }
    }//GEN-LAST:event_btnXoaDHCTMouseClicked

    private void btnMoiDHCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDHCTActionPerformed
        // TODO add your handling code here:
        txtIDDonHangCT.setText("");
        txtIDDonHangDHCT.setText("");
        txtSoLuong.setText("");
        txtGiaBanDHCT.setText("");
        txtThanhTienDHCT.setText("");
        txtIDSanPhamDHCT.setText("");
        txtIDKhuyenMaiDHCT.setText("");
    }//GEN-LAST:event_btnMoiDHCTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDonHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoiDH;
    private javax.swing.JButton btnMoiDHCT;
    private javax.swing.JButton btnSuaDHCT;
    private javax.swing.JButton btnThemDH;
    private javax.swing.JButton btnThemDHCT;
    private javax.swing.JButton btnTimDH;
    private javax.swing.JButton btnTimDHCT;
    private javax.swing.JButton btnXoaDH;
    private javax.swing.JButton btnXoaDHCT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblDonHangChiTiet;
    private javax.swing.JTextField txtGiaBanDHCT;
    private javax.swing.JTextField txtIDDonHangCT;
    private javax.swing.JTextField txtIDDonHangDHCT;
    private javax.swing.JTextField txtIDKhuyenMaiDHCT;
    private javax.swing.JTextField txtIDSanPhamDHCT;
    private javax.swing.JTextField txtIdDonHangDH;
    private javax.swing.JTextField txtIdKhuyenMaiDH;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongDH;
    private javax.swing.JButton txtSuaDH;
    private javax.swing.JTextField txtThanhTienDHCT;
    private javax.swing.JTextField txtTimKiemDH;
    private javax.swing.JTextField txtTimKiemDHCT;
    private javax.swing.JTextField txtTongTienDH;
    // End of variables declaration//GEN-END:variables
}
