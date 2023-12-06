/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CTSanPham;
import model.Hang;
import model.MauSac;
import model.SanPham;
import model.Size;
import model.XuatXu;
import service.CTSanPhamService;
import service.HangService;
import service.MauSacService;
import service.SanPhamService;
import service.SizeService;
import service.XuatXuService;
import utils.Auth;
import utils.XImage;

/**
 *
 * @author Viet Anh
 */
public class QLSanPhamJDialog extends javax.swing.JDialog {

    JFileChooser fileChooser = new JFileChooser();
    private SanPhamService SPDao = new SanPhamService();
    private DefaultTableModel tblModel = new DefaultTableModel();
    private MauSacService mauSacDao = new MauSacService();
    private SizeService sizeDao = new SizeService();
    private XuatXuService xuatXuDao = new XuatXuService();
    private HangService hangService = new HangService();
    private int index = -1;
    public static String a1;
    public static String a2;
    public static String a3;
    public static String a4;

    /**
     * Creates new form QLSanPhamJDialog
     */
    public QLSanPhamJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillTable(SPDao.getAll());
        fillMauSac();
        fillSize();
        fillHang();
        fillXuatXu();
    }

    public void fillTable(List<SanPham> list) {
        tblModel.setRowCount(0);
        tblModel = (DefaultTableModel) tblQLSanPham.getModel();
        for (SanPham x : list) {
            tblModel.addRow(x.toData());
        }
        tblModel.fireTableDataChanged();
    }

    public void fillMauSac() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMauSac.getModel();
        model.removeAllElements();
        List<MauSac> list = mauSacDao.getAll();
        for (MauSac x : list) {
            model.addElement(x.getMauSac());
        }
    }

    public void fillSize() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSize.getModel();
        model.removeAllElements();
        List<Size> list = sizeDao.getAll();
        for (Size x : list) {
            model.addElement(x.getSize());
        }
    }

    public void fillHang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboHang.getModel();
        model.removeAllElements();
        List<Hang> list = hangService.getAll();
        for (Hang x : list) {
            model.addElement(x.getTenHang());
        }
    }

    public void fillXuatXu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboXuatXu.getModel();
        model.removeAllElements();
        List<XuatXu> list = xuatXuDao.getAll();
        for (XuatXu x : list) {
            model.addElement(x.getXuatXu());
        }
    }
    
    public SanPham readForm() {
        String id = txtIDSanPham.getText();
        String ten = txtTenSP.getText();
        double gia = Double.parseDouble(txtGiaTien.getText());
        int sl = Integer.parseInt(txtSoLuong.getText());
        String hinh = lblHinhSP.getToolTipText();
//        Hang hang = new Hang(cboHang.getSelectedItem().toString(), cboHang.getSelectedItem().toString());
//        XuatXu xuatXu = new XuatXu(cboXuatXu.getSelectedItem()+"", cboXuatXu.getSelectedItem().toString());
//        MauSac mauSac = new MauSac(cboMauSac.getSelectedItem()+"", cboMauSac.getSelectedItem().toString());
//        Size size = new Size(cboHang.getSelectedItem()+"", cboSize.getSelectedItem().toString());

//        String hang = cboHang.getSelectedItem().toString();
//        String xuatXu = cboXuatXu.getSelectedItem().toString();
//        String mauSac = cboMauSac.getSelectedItem().toString();
//        String size = cboSize.getSelectedItem().toString();
        String moTa = txtMoTa.getText();

        index = cboHang.getSelectedIndex();
        List<Hang> list = hangService.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (i == index) {
                a1 = list.get(i).getIdHang();
            }
        }

        index = cboXuatXu.getSelectedIndex();
        List<XuatXu> list2 = xuatXuDao.getAll();
        for (int i = 0; i < list2.size(); i++) {
            if (i == index) {
                a2 = list2.get(i).getIdXuatXu();
            }
        }

        index = cboMauSac.getSelectedIndex();
        List<MauSac> list3 = mauSacDao.getAll();
        for (int i = 0; i < list3.size(); i++) {
            if (i == index) {
                a3 = list3.get(i).getIdMauSac();
            }
        }

        index = cboSize.getSelectedIndex();
        List<Size> list4 = sizeDao.getAll();
        for (int i = 0; i < list4.size(); i++) {
            if (i == index) {
                a4 = list4.get(i).getIdSize();
            }
        }

        return new SanPham(id, ten, gia, sl, rdoHoatDong.isSelected() ? 1 : 0, hinh, a1, a2, a3, a4, moTa);
//        return new SanPham(txtIDSanPham.getText(), txtTenSP.getText(), Double.parseDouble(txtGiaTien.getText()), Integer.parseInt(txtSoLuong.getText()), rdoHoatDong.isSelected() ? 1 : 0, lblHinhSP.getToolTipText(), cboHang.getSelectedItem() + "", cboXuatXu.getSelectedItem() + "", cboMauSac.getSelectedItem() + "", Integer.parseInt(cboSize.getSelectedIndex()+""), txtMoTa.getText());
    }

    public boolean validateForm() {
        if (txtIDSanPham.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sản shẩm");
            return false;
        }

        if (txtTenSP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên sản shẩm");
            return false;
        }

        if (txtGiaTien.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập giá tiền sản phẩm");
            return false;
        }

        try {
            Double.parseDouble(txtGiaTien.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là số");
            return false;
        }

        if (Double.parseDouble(txtGiaTien.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải lớn hơn 0");
            return false;
        }

        if (txtSoLuong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng sản phẩm");
            return false;
        }

        try {
            Integer.parseInt(txtSoLuong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
            return false;
        }

        if (Integer.parseInt(txtSoLuong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            return false;
        }

        if (txtMoTa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mô tả sản phẩm");
            return false;
        }

        return true;
    }

    public void insert() {
        if (validateForm()) {
            if (SPDao.getByID(txtIDSanPham.getText()) == null) { // check mã
                if (SPDao.insert(readForm())) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(SPDao.getAll());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Trùng ID");
                return;
            }
        }
    }

    public void update() {
        if (validateForm()) {
            if (SPDao.getByID(txtIDSanPham.getText()) != null) {
                index = tblQLSanPham.getSelectedRow();
                String id = tblQLSanPham.getValueAt(index, 0).toString();
                if (SPDao.update(readForm(), id)) {
                    JOptionPane.showMessageDialog(this, "Cập nhập thành công");
                    fillTable(SPDao.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhập thất bại");
                }
            }else{
                JOptionPane.showMessageDialog(this, "upadte lỗi");
            }
        }
    }

    public void delete() {
        try {
            if (SPDao.delete(txtIDSanPham.getText())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillTable(SPDao.getAll());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được phép xóa sản phẩm");
        }
    }

    public void findByName() {
        List<SanPham> list = SPDao.findByName(txtTimKiem.getText());
        fillTable(list);
    }

//    public void edit() {
//        int row = tblQLSanPham.getSelectedRow();
//        String ma = (String) tblQLSanPham.getValueAt(row, 0);
//        SanPham x = (SanPham) SPDao.findByName(ma);
//        fillForm(x);
//    }
    public void fillForm(int index) {
        SanPham x = SPDao.getAll().get(index);
        txtGiaTien.setText(String.valueOf(x.getGiaTien()));
        txtMoTa.setText(x.getMoTa());
        txtTenSP.setText(x.getTenSP());
        cboHang.setSelectedItem(x.getHang() + "");
        cboMauSac.setSelectedItem(x.getMauSac() + "");
        cboSize.setSelectedItem(String.valueOf(x.getSize() + ""));
        cboXuatXu.setSelectedItem(x.getXuatXu() + "");
        txtIDSanPham.setText(x.getIdSP());
        txtGiaTien.setText(String.valueOf(x.getGiaTien()));
        rdoHoatDong.setSelected(x.isTrangThai());
        rdoKhongHD.setSelected(!x.isTrangThai());
        txtSoLuong.setText(String.valueOf(x.getSoLuong()));
        if (x.getHinhAnh() != null) {
            lblHinhSP.setToolTipText(x.getHinhAnh());
            lblHinhSP.setIcon(XImage.read(x.getHinhAnh()));
        } else {
            lblHinhSP.setIcon(null);
        }
    }

    void choosePicture() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fileChooser.setDialogTitle("Chọn Ảnh");
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblHinhSP.setToolTipText(file.getName());
            lblHinhSP.setIcon(icon);
        }
    }

    
    public void clear() {
        txtGiaTien.setText("");
        txtIDSanPham.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        txtTenSP.setText("");
        cboHang.setSelectedIndex(-1);
        cboMauSac.setSelectedIndex(-1);
        cboSize.setSelectedIndex(-1);
        cboXuatXu.setSelectedIndex(-1);
        lblHinhSP.setIcon(null);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHinhSP = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhongHD = new javax.swing.JRadioButton();
        cboHang = new javax.swing.JComboBox<>();
        cboXuatXu = new javax.swing.JComboBox<>();
        txtGiaTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIDSanPham = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLSanPham = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setText("Hãng");

        jLabel4.setText("Xuất Xứ");

        jLabel5.setText("Giá Tiền");

        jLabel6.setText("Trạng Thái");

        lblHinhSP.setText("Hình Ảnh Sản Phẩm");
        lblHinhSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhSPMousePressed(evt);
            }
        });

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setSelected(true);
        rdoHoatDong.setText("Hoạt Động");

        buttonGroup1.add(rdoKhongHD);
        rdoKhongHD.setText("Không Hoạt Động");

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel9.setText("Màu Sắc");

        jLabel10.setText("Size");

        jLabel11.setText("Mô Tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel7.setText("IDSanPham");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jButton4.setText("Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setText("Số Lượng");

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoKhongHD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboXuatXu, javax.swing.GroupLayout.Alignment.LEADING, 0, 202, Short.MAX_VALUE)
                            .addComponent(cboHang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaTien)
                            .addComponent(txtIDSanPham))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(lblHinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnThem)
                        .addGap(3, 3, 3)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnXoa, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblHinhSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(jButton4)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoHoatDong)
                            .addComponent(rdoKhongHD))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXoa, jButton2});

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jPanel2.setBackground(new java.awt.Color(153, 204, 0));

        jLabel12.setText("Tên Sản Phẩm");

        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblQLSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên SP", "Hãng", "Giá Bán", "Trạng Thái", "Xuất xứ", "Size", "Màu sắc", "Số Lượng"
            }
        ));
        tblQLSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLSanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("<");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(344, 344, 344))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!Auth.isManager()) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        } else {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblQLSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSanPhamMouseClicked
        int id = tblQLSanPham.rowAtPoint(evt.getPoint());
        String ma = tblQLSanPham.getValueAt(id, 0).toString();
        SanPham x = SPDao.getByID(ma);
        txtGiaTien.setText(String.valueOf(x.getGiaTien()));
        txtMoTa.setText(x.getMoTa());
        txtTenSP.setText(x.getTenSP());
        cboHang.setSelectedItem(x.getHang() + "");
        cboMauSac.setSelectedItem(x.getMauSac() + "");
        cboSize.setSelectedItem(String.valueOf(x.getSize() + ""));
        cboXuatXu.setSelectedItem(x.getXuatXu() + "");
        txtIDSanPham.setText(x.getIdSP());
        txtGiaTien.setText(String.valueOf(x.getGiaTien()));
        rdoHoatDong.setSelected(x.isTrangThai());
        rdoKhongHD.setSelected(!x.isTrangThai());
        txtSoLuong.setText(String.valueOf(x.getSoLuong()));
        if (x.getHinhAnh() != null) {
            lblHinhSP.setToolTipText(x.getHinhAnh());
            lblHinhSP.setIcon(XImage.read(x.getHinhAnh()));
        } else {
            lblHinhSP.setIcon(null);
        }
    }//GEN-LAST:event_tblQLSanPhamMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        findByName();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblHinhSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhSPMousePressed
        choosePicture();
    }//GEN-LAST:event_lblHinhSPMousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSanPhamJDialog dialog = new QLSanPhamJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinhSP;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhongHD;
    private javax.swing.JTable tblQLSanPham;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtIDSanPham;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    

//    public void getIDHang() {
//        index = cboHang.getSelectedIndex();
//        List<Hang> list = hangService.getAll();
//        for (int i = 0; i < list.size(); i++) {
//            if (i == index) {
//                a = list.get(i).getIdHang();
//            }
//        }
//    }
}
