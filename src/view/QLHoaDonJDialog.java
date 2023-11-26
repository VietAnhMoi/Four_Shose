/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CTDonHangJoinHoaDon;
import model.CTHoaDon;
import model.HoaDon;
import service.CTHoaDonService;
import service.HoaDonService;
import utils.Auth;

/**
 *
 * @author nguye
 */
public class QLHoaDonJDialog extends javax.swing.JDialog {

    private DefaultTableModel model = new DefaultTableModel();
    private HoaDonService service = new HoaDonService();
    private List<HoaDon> lst = new ArrayList();
    private int index = -1;
    private CTHoaDonService serviceCT = new CTHoaDonService();

    public static String idDH;
    public static String idKHang;

    public QLHoaDonJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        fillTableHD(service.getAll());
    }

    public QLHoaDonJDialog() {

    }

    void fillTableHD(List<HoaDon> list) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDon hoaDon : list) {
            model.addRow(hoaDon.toDatata());
        }
    }

    void fillTableHDCT(List<CTHoaDon> lst) {
        model = (DefaultTableModel) tblHoaDonCT.getModel();
        model.setRowCount(0);
        for (CTHoaDon cthd : lst) {
            model.addRow(cthd.toDatata());
        }

    }

    CTHoaDon addHdCT(List<CTDonHangJoinHoaDon> lst) {
        CTHoaDon ctHD = new CTHoaDon();
        if (!txtMaKH.getText().equals("")) {
            idKHang = txtMaKH.getText();
        } else {
            idKHang = null;
        }

        try {
            for (CTDonHangJoinHoaDon CTDH : lst) {
                ctHD.setIdHoaDon(CTDH.getIdHoaDon());
                ctHD.setIdSanPham(CTDH.getIdSanPham());
                ctHD.setIdNhanVien(String.valueOf(Auth.user.getId()));
                ctHD.setSoLuong(CTDH.getSoLuong());
                ctHD.setIdKhuyenMai(CTDH.getIdKhuyenMai());
                ctHD.setThanhTien(CTDH.getThanhTien());
                ctHD.setIdCTDonHang(CTDH.getIdCTDH());
//            return ctHD;   

                if (serviceCT.insert(ctHD) != 0) {
                    fillTableHDCT(serviceCT.getAllCTDH(idDH));
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thất bại1");
                }

            }
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thành công");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thất bại");

        }
        return ctHD;

    }

    CTHoaDon readHDCT(List<CTHoaDon> lst) {
        CTHoaDon ctHD = new CTHoaDon();
        for (CTHoaDon cthd : lst) {
            ctHD.setIdHoaDon(cthd.getIdHoaDon());
            ctHD.setIdSanPham(cthd.getIdSanPham());
            ctHD.setIdNhanVien(cthd.getIdNhanVien());
            ctHD.setSoLuong(cthd.getSoLuong());
            ctHD.setIdKhuyenMai(cthd.getIdKhuyenMai());
            ctHD.setThanhTien(cthd.getThanhTien());
            ctHD.setIdKhachHang(ctHD.getIdKhachHang());
            ctHD.setIdCTDonHang(cthd.getIdCTDonHang());
        }
        return ctHD;
    }

    void showDataHoaDon(int index) {
        HoaDon hd = service.getAll().get(index);
        idDH = hd.getIdDonHang();
        long tien = hd.getTongTien();
//        String phanNghin = "###.###";
//        DecimalFormat formatPhanNghin = new DecimalFormat(phanNghin);
        txtMaHD.setText(hd.getId());
        txtNgayLap.setText(hd.getNgayLap());
        if (hd.getTrangThai() == 1) {
            rdoHD_dathanhtoan.setSelected(true);
        } else {
            rdoHDcho.setSelected(true);
        }
        txtMaDH.setText(hd.getIdDonHang());
        txtTongTien.setText(String.valueOf(tien));

    }

    void showDataHoaDonCT(int index) {
        CTHoaDon cthd = serviceCT.getAllCTDH(idDH).get(index);
        String phanNghin = "###.###";
        DecimalFormat formatPhanNghin = new DecimalFormat(phanNghin);

        txtIDHoaDonCT.setText(cthd.getId());
        txtMaHDCT.setText(cthd.getIdHoaDon());
        txtMaSP.setText(cthd.getIdSanPham());
        txtMaNhanVien.setText(cthd.getIdNhanVien());
        txtSoLuong.setText(String.valueOf(cthd.getSoLuong()));
        txtMaKhuyenMai.setText(cthd.getIdKhuyenMai());
        txtThanhTien.setText(formatPhanNghin.format(cthd.getThanhTien()));
        txtMaKH.setText(cthd.getIdKhachHang());
    }

    void clearFormCTHD() {
        txtIDHoaDonCT.setText("");
        txtMaHDCT.setText("");
        txtMaSP.setText("");
        txtMaNhanVien.setText("");
        txtSoLuong.setText("");
        txtMaKhuyenMai.setText("");
        txtThanhTien.setText("");
    }

    HoaDon readFormHoaDon() {
        HoaDon hd = new HoaDon();
        hd.setId(txtMaHD.getText());
        hd.setIdDonHang(txtMaDH.getText());
        if (rdoHD_dathanhtoan.isSelected()) {
            hd.setTrangThai(1);
        } else {
            hd.setTrangThai(0);
        }
        String phanNghin = "######";
//        DecimalFormat formatPhanNghin = new DecimalFormat(phanNghin);
//        long value = Long.parseLong(formatPhanNghin.format(txtTongTien.getText()));
        hd.setTongTien(Long.parseLong(txtTongTien.getText()));

        return hd;
    }

    boolean checkHoaDon() {
        HoaDon hd = this.readFormHoaDon();
        String maHD = hd.getId();
        String maDonHang = hd.getIdDonHang();
        String iddonhang = txtMaDH.getText();
        if (txtMaHD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không đc để trống mã hóa đơn");
            txtMaHD.requestFocus();
            return false;
        }
        if (txtMaDH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không đc để trống mã đơn hàng");
            txtMaDH.requestFocus();
            return false;
        }
        if (txtTongTien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không đc để trống Tổng tiền");
            txtTongTien.requestFocus();
            return false;
        }
        if (service.getIdHoaDon(maHD)) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn đã được tạo");
            return false;
        }
        if (service.getMaDonHang(maDonHang)) {
            JOptionPane.showMessageDialog(this, "Đơn hàng này đã có hóa đơn");
            return false;
        }
        if (!service.checkDonHang(iddonhang)) {
            JOptionPane.showMessageDialog(this, "Đơn hàng này không tồn tại");
            return false;
        }
        if (hd.getTrangThai() == 0) {
            JOptionPane.showMessageDialog(this, "Không thể thêm hóa đơn chưa thanh toán");
            return false;

        }
        return true;
    }

    boolean checkHDCT() {
        index = tblHoaDon.getSelectedRow();
        String idHD = tblHoaDon.getValueAt(index, 0).toString();
        if (serviceCT.getidCTHoaDon(idHD)) {
            JOptionPane.showMessageDialog(this, "Chi tiết hóa đơn này đã được thêm");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        txtTimKiemHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTimKiemHD = new javax.swing.JButton();
        txtTimKiemHDCT = new javax.swing.JTextField();
        btnTimKiemHDCT = new javax.swing.JButton();
        btnXoaHDCT = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIDHoaDonCT = new javax.swing.JTextField();
        txtMaHDCT = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnThemHD = new javax.swing.JButton();
        btnThemHDCT = new javax.swing.JButton();
        txtMaHD = new javax.swing.JTextField();
        txtMaDH = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        rdoHDcho = new javax.swing.JRadioButton();
        rdoHD_dathanhtoan = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnSuaHD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lý Hóa Đơn");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã đơn hàng", "Trạng thái", "Ngày Lập", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HDCT", "Mã hóa đơn", "Mã sản phẩm", "Mã nhân viên", "Số lượng", "Mã giảm giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonCT);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Hóa Đơn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Chi Tiết Hóa Đơn");

        btnTimKiemHD.setText("Tìm Kiếm");
        btnTimKiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHDActionPerformed(evt);
            }
        });

        btnTimKiemHDCT.setText("Tìm Kiếm");

        btnXoaHDCT.setText("Xóa sản phẩm ");
        btnXoaHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDCTActionPerformed(evt);
            }
        });

        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã hóa đơn :");

        jLabel5.setText("Mã đơn hàng :");

        jLabel6.setText("Tổng tiền :");

        jLabel7.setText("Mã HDCT :");

        jLabel8.setText("Mã hóa đơn :");

        jLabel9.setText("Mã nhân viên :");

        jLabel10.setText("Mã sản phẩm");

        jLabel11.setText("Số lượng :");

        jLabel12.setText("Mã giảm giá :");

        jLabel13.setText("Mã khách hàng :");

        jLabel14.setText("VND");

        jLabel15.setText("VND");

        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });

        btnThemHDCT.setText("Hiển thị chi tiết sản phẩm");
        btnThemHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDCTActionPerformed(evt);
            }
        });

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel16.setText("Trạng Thái :");

        txtNgayLap.setVerifyInputWhenFocusTarget(false);

        buttonGroup1.add(rdoHDcho);
        rdoHDcho.setText("Hóa đơn chờ");

        buttonGroup1.add(rdoHD_dathanhtoan);
        rdoHD_dathanhtoan.setText("Đã thanh toán");

        jLabel17.setText("Ngày Lập :");

        jLabel18.setText("Thành Tiền :");

        jLabel19.setText("(Nếu có)");

        btnSuaHD.setText("Sửa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoHDcho, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoHD_dathanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtMaHD)
                                            .addComponent(txtMaDH)
                                            .addComponent(txtNgayLap)
                                            .addComponent(txtTongTien)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(btnTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(btnThemHDCT)
                                .addGap(113, 113, 113)
                                .addComponent(btnXoaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiemHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnTimKiemHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIDHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(186, 186, 186)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDH, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoHDcho)
                            .addComponent(rdoHD_dathanhtoan)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIDHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        index = tblHoaDon.getSelectedRow();
        this.showDataHoaDon(index);
        fillTableHDCT(serviceCT.getAllCTDH(idDH));
        this.clearFormCTHD();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        int index = tblHoaDonCT.getSelectedRow();
        this.showDataHoaDonCT(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonCTMouseClicked

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        HoaDon hd = this.readFormHoaDon();
        if (checkHoaDon()) {
            if (service.insert(hd)) {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
                fillTableHD(service.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemHDActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void btnTimKiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHDActionPerformed
        String idHoaDon = txtTimKiemHD.getText();
        if (!service.searchHD(idHoaDon).isEmpty()) {
            fillTableHD(service.searchHD(idHoaDon));
        } else {
            JOptionPane.showMessageDialog(this, "Không có mã hóa đơn là " + idHoaDon);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemHDActionPerformed

    private void btnThemHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDCTActionPerformed
        if (idDH == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn muốn thêm");
        } else {
            if (checkHDCT()) {
                this.addHdCT(serviceCT.selectCTDonHang(idDH));
                fillTableHDCT(serviceCT.getAllCTDH(idDH));
//            JOptionPane.showMessageDialog(this, "Thêm hóa đơn chi tiết thành công");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemHDCTActionPerformed

    private void tblHoaDonCTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDonCTMouseEntered

    private void btnXoaHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDCTActionPerformed
        index = tblHoaDonCT.getSelectedRow();
        System.out.println(index);
        if (index < 0 || index > tblHoaDonCT.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xóa");
        } else {
            String idHDCT = tblHoaDonCT.getValueAt(index, 0).toString();
            if (serviceCT.deleteCTHD(idHDCT)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillTableHDCT(serviceCT.getAllCTDH(idDH));
                index = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaHDCTActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        index = tblHoaDon.getSelectedRow();
        String idHD = tblHoaDon.getValueAt(index, 0).toString();
        if (service.deleteHoaDon(idHD)) {
            JOptionPane.showMessageDialog(this, "xóa thành công");
            fillTableHD(service.getAll());

        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaHDActionPerformed

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
            java.util.logging.Logger.getLogger(QLHoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLHoaDonJDialog dialog = new QLHoaDonJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnThemHDCT;
    private javax.swing.JButton btnTimKiemHD;
    private javax.swing.JButton btnTimKiemHDCT;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JButton btnXoaHDCT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoHD_dathanhtoan;
    private javax.swing.JRadioButton rdoHDcho;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTextField txtIDHoaDonCT;
    private javax.swing.JTextField txtMaDH;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDCT;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiemHD;
    private javax.swing.JTextField txtTimKiemHDCT;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
