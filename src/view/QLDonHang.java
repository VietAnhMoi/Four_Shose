/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CTDonHang;
import model.DonHang;
import model.HoaDon;
import model.KhuyenMai;
import model.SanPham;
import service.CTDonHangService;
import service.DonHangService;
import service.HoaDonService;
import service.KhuyenMaiService;
import service.SanPhamService;

/**
 *
 * @author nguye
 */
public class QLDonHang extends javax.swing.JDialog {

    private DefaultTableModel model = new DefaultTableModel();
    private CTDonHangService serviceCTDH = new CTDonHangService();
    private DonHangService serviceDH = new DonHangService();
    private SanPhamService serviceSP = new SanPhamService();
    private KhuyenMaiService serviceKM = new KhuyenMaiService();
    private HoaDonService serviceHD = new HoaDonService();
    private int index = 0;
    public static String idDonHang = null;
    public static String maKhuyenMai = null;

    public QLDonHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.fillTableSanPham(serviceSP.getAll());
        this.setDonHang(serviceDH.getIDDonHang());
        this.fillComBoKM(serviceKM.getAll());
        this.fillTableHD(serviceHD.getAllHDCho());
//                this.fillTableDHCT(serviceCTDH.getDHCTisNull());
    }

    public QLDonHang() {

    }

    void fillTableSanPham(List<SanPham> lst) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sp : lst) {
            model.addRow(sp.toData1());
        }
    }

    void fillTableDHCT(List<CTDonHang> lst) {
        model = (DefaultTableModel) tblDHChiTiet.getModel();
        model.setRowCount(0);
        for (CTDonHang ctDH : lst) {
            model.addRow(ctDH.toDatatadhct());
        }
    }

    void fillTableHD(List<HoaDon> lst) {
        model = (DefaultTableModel) tblHoaDonCho.getModel();
        model.setRowCount(0);
        for (HoaDon hd : lst) {
            model.addRow(hd.toDatata1());
        }
    }

    SanPham getSanPham(int index) {
        SanPham sp = serviceSP.getAll().get(index);

        return sp;
    }

    CTDonHang addCTDonHang() {
        CTDonHang ctDH = new CTDonHang();
        SanPham sp = getSanPham(index);
        ctDH.setIdsanphamdhct(sp.getIdSP());
        ctDH.setSoluongdhct(1);
        int thanhTien = (int) sp.getGiaTien();
        ctDH.setGiabandhct(thanhTien);
        ctDH.setThanhtiendhct(thanhTien);
        return ctDH;
    }

    void setDonHang(List<DonHang> lst) {
        for (DonHang dh : lst) {
            lblMaDonHang.setText(String.valueOf(dh.getIddonhangdh() + 1));
        }
    }

    void setSLDonHang() {
        int soLuongDH = 0;
        int soLuongDHCT = 0;
        int donGiaDH = 0;
        int donGiaDHCT = 0;
        int thanhTien = 0;
        int tongTien = 0;

        for (int i = 0; i < tblDHChiTiet.getRowCount() - 1; i++) {
            soLuongDHCT = Integer.parseInt(tblDHChiTiet.getValueAt(i, 2).toString());
            soLuongDH += soLuongDHCT;
            thanhTien += Integer.parseInt(tblDHChiTiet.getValueAt(i, 4).toString());
        }
        lblSoLuong.setText(String.valueOf(soLuongDH));
        lblThanhtien.setText(String.valueOf(thanhTien));
        if (!txtKhuyenMaiGia.getText().equals("")) {
            tongTien = thanhTien - Integer.parseInt(txtKhuyenMaiGia.getText());
        } else if (!txtKMPhanTram.getText().equals("")) {
            tongTien = (int) (thanhTien - (thanhTien * Double.parseDouble(txtKMPhanTram.getText())));
        } else if (thanhTien == 0) {
            tongTien = 0;
        } else {
            tongTien += thanhTien;
        }
        lblTongTien.setText(String.valueOf(tongTien));
    }

    void fillComBoKM(List<KhuyenMai> lst) {
        for (KhuyenMai km : lst) {
            cboMaGiamGia.addItem(km.getIdKM());
        }
    }

    DonHang addDonHang() {
        DonHang dh = new DonHang();
        dh.setSoluongdh(Integer.parseInt(lblSoLuong.getText()));
        dh.setTonggiatridh(Integer.parseInt(lblTongTien.getText()));
        if (!txtKMPhanTram.getText().equals("") && !txtKhuyenMaiGia.equals("")) {
            maKhuyenMai = cboMaGiamGia.getSelectedItem().toString();
        }
        return dh;
    }

    HoaDon addHoaDon() {
        HoaDon hd = new HoaDon();
        int idDonHang = Integer.parseInt(lblMaDonHang.getText()) - 1;
        int tongTien = Integer.parseInt(lblTongTien.getText());
        hd.setTrangThai(0);
        hd.setIdDonHang(idDonHang);
        hd.setTongTien(tongTien);
        return hd;
    }

    void clearFormDH() {
        lblSoLuong.setText("");
        lblThanhtien.setText("");
        lblTongTien.setText("");
        cboMaGiamGia.setSelectedIndex(0);
        txtKMPhanTram.setText("");
        txtKhuyenMaiGia.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnTaoDH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cboMaGiamGia = new javax.swing.JComboBox<>();
        lblSoLuong = new javax.swing.JLabel();
        lblThanhtien = new javax.swing.JLabel();
        lblMaDonHang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtKMPhanTram = new javax.swing.JTextField();
        txtKhuyenMaiGia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDHChiTiet = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        btnTimCTDonHang = new javax.swing.JButton();
        btnSuaSL = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btnTimSanPham = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("<");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Trạng thái", "Ngày lập", "Mã đơn hàng", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("Thanh Toán");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Hủy đơn hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Cambria", 3, 24)); // NOI18N
        jLabel1.setText("Quản Lý Đơn Hàng");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel3.setText("Mã đơn hàng : ");

        btnTaoDH.setText("Tạo đơn hàng");
        btnTaoDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDHActionPerformed(evt);
            }
        });

        jLabel4.setText("Thành Tiền");

        jLabel5.setText("Số Lượng :");

        jLabel6.setText("Giảm Giá :");

        jLabel7.setText("Tổng Tiền");

        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboMaGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaGiamGiaItemStateChanged(evt);
            }
        });
        cboMaGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMaGiamGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboMaGiamGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cboMaGiamGiaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboMaGiamGiaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboMaGiamGiaMouseReleased(evt);
            }
        });
        cboMaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaGiamGiaActionPerformed(evt);
            }
        });

        jLabel8.setText("%");

        jLabel9.setText("VND");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKhuyenMaiGia, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txtKMPhanTram))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(278, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnTaoDH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblThanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtKMPhanTram)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtKhuyenMaiGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoDH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblDHChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDHChiTiet);

        btnTimCTDonHang.setText("Tìm");

        btnSuaSL.setText("Sửa số lượng");
        btnSuaSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSLActionPerformed(evt);
            }
        });

        btnXoaSanPham.setText("Xóa sản phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimCTDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimCTDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnSuaSL, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá tiền", "Số lượng tồn", "Trạng thái", "Hãng", "Xuất xứ", "Màu sắc ", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        btnTimSanPham.setText("Tìm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnTimSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(btnTimSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(518, 518, 518)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        index = tblSanPham.getSelectedRow();
        String maSP = tblSanPham.getValueAt(index, 0).toString();
        CTDonHang ctDH = addCTDonHang();
        List<CTDonHang> lst = serviceCTDH.checkSPhaminHDCT(maSP);
        if (serviceCTDH.AddDHCT(ctDH) != 0) {
            if (!lst.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã có");
                if (serviceCTDH.deleteSP()) {
                    this.fillTableDHCT(serviceCTDH.getDHCTisNull());
                    this.setSLDonHang();
                }
            } else {
                this.fillTableDHCT(serviceCTDH.getDHCTisNull());
                this.setSLDonHang();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
        }

//        index = tblSanPham.getSelectedRow();
        //        CTDonHang ctDH = addCTDonHang();
//                if (serviceCTDH.AddDHCT(ctDH) != 0) {
//                    this.fillTableDHCT(serviceCTDH.getDHCTisNull());
//                    this.setSLDonHang();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
//                }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cboMaGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaGiamGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaMouseClicked

    private void cboMaGiamGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaGiamGiaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaMouseEntered

    private void cboMaGiamGiaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaGiamGiaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaMouseReleased

    private void cboMaGiamGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaGiamGiaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaMouseExited

    private void cboMaGiamGiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaGiamGiaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaMousePressed

    private void cboMaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaGiamGiaActionPerformed
        index = cboMaGiamGia.getSelectedIndex();
        KhuyenMai km = serviceKM.getAll().get(index);
        if (km.getKMPhanTram() != 0) {
            txtKMPhanTram.setText(String.valueOf(km.getKMPhanTram()));
            txtKhuyenMaiGia.setText("");

        } else {
            txtKhuyenMaiGia.setText(String.valueOf(km.getKMTheoGia()));
            txtKMPhanTram.setText("");
        }
        this.setSLDonHang();
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaActionPerformed

    private void btnTaoDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDHActionPerformed
        DonHang dh = addDonHang();
        if (tblDHChiTiet.getRowCount() > 0) {
            if (serviceDH.AddDH(dh) != 0) {
                setDonHang(serviceDH.getIDDonHang());
                int idDonHang = Integer.parseInt(lblMaDonHang.getText()) - 1;
                if (serviceCTDH.UpdateDHCT(idDonHang) != 0) {
                    HoaDon hd = addHoaDon();
                    if (serviceHD.insertHDcho(hd)) {
                        JOptionPane.showMessageDialog(this, "Tạo đơn hàng và hóa đơn thành công");
                        this.setDonHang(serviceDH.getIDDonHang());
                        this.fillTableHD(serviceHD.getAllHDCho());
                        this.fillTableDHCT(serviceCTDH.getDHCTisNull());
                        this.clearFormDH();
                    } else {
                        JOptionPane.showMessageDialog(this, "đơn hàng : true , hóa đơn : false");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi thêm sản phẩm vào đơn hàng");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đơn hàng : false , hóa đơn : false");

            }
        } else {
            JOptionPane.showMessageDialog(this, "Đơn hàng chưa có sản phẩm");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoDHActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        index = tblDHChiTiet.getSelectedRow();
        if (index < 0 || index > tblDHChiTiet.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xóa");
        } else {
            CTDonHang ctDH = serviceCTDH.getDHCTisNull().get(index);
            int maDH = ctDH.getIddonhangct();
            if (serviceCTDH.DeleteDHCT(maDH) != 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa");
                this.fillTableDHCT(serviceCTDH.getDHCTisNull());
                this.setSLDonHang();
            } else {
                JOptionPane.showMessageDialog(this, "Không xóa được");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void cboMaGiamGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaGiamGiaItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaGiamGiaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn làm mới đơn hàng không?");
        if (hoi == JOptionPane.YES_OPTION) {
            if (serviceCTDH.DeleteDHCTisNull() != 0) {
                fillTableDHCT(serviceCTDH.getDHCTisNull());
                JOptionPane.showMessageDialog(this, "Đã làm mới đơn hàng");
                clearFormDH();
            } else {
                JOptionPane.showMessageDialog(this, "Đơn hàng đang trống");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa đơn hàng này không?");
        if (hoi == JOptionPane.YES_OPTION) {
            index = tblHoaDonCho.getSelectedRow();
            if (index < 0 || index > tblHoaDonCho.getRowCount() - 1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn đơn hàng để hủy");
            } else {
                int maDH = Integer.parseInt(tblHoaDonCho.getValueAt(index, 3).toString());
                if (serviceDH.deleteHDcho(maDH)) {
                    JOptionPane.showMessageDialog(this, "Đã hủy đơn hàng");
                    this.fillTableHD(serviceHD.getAllHDCho());
                    this.setDonHang(serviceDH.getIDDonHang());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa đơn hàng thất bại");
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSuaSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSLActionPerformed
        index = tblDHChiTiet.getSelectedRow();
        if (index < 0 || index > tblDHChiTiet.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm");
        } else {
            int soLuong = Integer.parseInt(tblDHChiTiet.getValueAt(index, 2).toString());
            String maSP = tblDHChiTiet.getValueAt(index, 0).toString();
            CTDonHang ctDH = serviceCTDH.getDHCTisNull().get(index);
            SanPham sp = serviceSP.getSoLuong(maSP);
            tblDHChiTiet.setRowSelectionInterval(index, index);
            if (soLuong > sp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ");
                fillTableDHCT(serviceCTDH.getDHCTisNull());
            } else {
                if (serviceCTDH.UpdateSoLuongDHCT(soLuong, ctDH.getIddonhangct())) {
                    JOptionPane.showMessageDialog(this, "Dã sửa số lượng sản phẩm");
                    this.fillTableDHCT(serviceCTDH.getDHCTisNull());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa số lượng thất bại");
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaSLActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        index = tblHoaDonCho.getSelectedRow();
        if (index < 0 || index > tblHoaDonCho.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else {
            int maHD = Integer.parseInt(tblHoaDonCho.getValueAt(index, 0).toString());
            if (serviceHD.updatePay(maHD)) {
                JOptionPane.showMessageDialog(this, "Đã thanh toán hóa đơn : " + maHD);
                this.fillTableHD(serviceHD.getAllHDCho());
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi thanh toán hóa đơn : " + maHD);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLDonHang dialog = new QLDonHang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSuaSL;
    private javax.swing.JButton btnTaoDH;
    private javax.swing.JButton btnTimCTDonHang;
    private javax.swing.JButton btnTimSanPham;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> cboMaGiamGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblMaDonHang;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblThanhtien;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblDHChiTiet;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtKMPhanTram;
    private javax.swing.JTextField txtKhuyenMaiGia;
    // End of variables declaration//GEN-END:variables
}
