/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangService;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhq
 */
public final class QLkhachhang extends javax.swing.JDialog {

    DefaultTableModel model = new DefaultTableModel();
    KhachHangService KH = new KhachHangService();
    List<KhachHang> lst = new ArrayList();
    int index = -1;
    private String Ten;

    public QLkhachhang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        FillToTable(KH.getAll());
//        showDetail(index);
    }

    public void FillToTable(List<KhachHang> lst) {
        model = (DefaultTableModel) tblbang.getModel();
        model.setRowCount(0);
        for (KhachHang kh : lst) {
            model.addRow(kh.toDatarow());
        }
    }

    public void showDetail(int index) {
        KhachHang kh = KH.getAll().get(index);
        txtten.setText(kh.getTen());
        txtsdt.setText(kh.getSDT());
        txtdiachi.setText(kh.getDiaChi());
        txttimkiem.setText(kh.getID());
    }

    public KhachHang readform() {
        String Ten = txtten.getText();
        String SDT = txtsdt.getText();
        String DiaChi = txtdiachi.getText();
        String TimKiem = txttimkiem.getText();
        return new KhachHang(Ten, SDT, DiaChi, TimKiem);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnkiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txttimkiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText(" Quản Lý Khách Hàng");

        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbang);

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa ");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnkiem.setText("Tìm Kiếm");
        btnkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Khách Hàng");

        jLabel4.setText("Số Điện thoại");

        jLabel5.setText("Địa chỉ");

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtsdt)
                                    .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnthem)
                        .addGap(43, 43, 43)
                        .addComponent(btnsua)
                        .addGap(41, 41, 41)
                        .addComponent(btnxoa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnkiem)))
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnkiem)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        {
            KhachHang kh = readform();
            if (kh.Add(kh) != 0) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                FillToTable(kh.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên không thành công");
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        index = tblbang.getSelectedRow();
        String id = tblbang.getValueAt(index, 0).toString();
        if (KH.Delete(id) != 0) {
            JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công");
            this.FillToTable(KH.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa nhân viên không thành công");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tblbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangMouseClicked
        // TODO add your handling code here:
        index = tblbang.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblbangMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        {
            index = tblbang.getSelectedRow();
            KhachHang kh = readform();
            String id = tblbang.getValueAt(index, 0).toString();
            if (KH.Update(kh, id) > 0) {
                JOptionPane.showMessageDialog(this, "Update thành công");
                FillToTable(KH.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Update không thành công");
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btnkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkiemActionPerformed
        FillToTable(KH.getByTen(txttimkiem.getText()));
    }//GEN-LAST:event_btnkiemActionPerformed

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
            java.util.logging.Logger.getLogger(QLkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLkhachhang dialog = new QLkhachhang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnkiem;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbang;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables

}