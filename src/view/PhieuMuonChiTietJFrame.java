/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PhieuMuonChiTietDAO;
import dao.SachDAO;
import helper.DialogHelper;
import helper.JdbcHelper;
import helper.ShareHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhieuMuonChiTiet;
import model.Sach;

/**
 *
 * @author ASUS
 */
public class PhieuMuonChiTietJFrame extends javax.swing.JFrame {


    public Integer MaPM;
    PhieuMuonChiTietDAO dao = new PhieuMuonChiTietDAO();
    SachDAO sadao = new SachDAO();
    int index = -1;

    /**
     * Creates new form PhieuMuonChiTietJFrame
     */
    public PhieuMuonChiTietJFrame() {
        initComponents();
        init();
        this.MaPM = MaPM;
    }

    PhieuMuonChiTietJFrame(Integer id) {
       initComponents();
        init();
        this.MaPM = id;
    }



    void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSach.getModel();
        model.removeAllElements();
        try {
            List<Sach> list = sadao.select();
            for (Sach sa : list) {
                model.addElement(sa);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
 void selectComboBox() {
        Sach sa = (Sach) cboSach.getSelectedItem();

    }
     void fillGridView() {
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT pmct.*, sa.TenSach FROM PhieuMuonChiTiet pmct "
                    + " JOIN Sach sa ON sa.MaSach=pmct.MaSach WHERE MaPM=?";
            ResultSet rs = JdbcHelper.executeQuery(sql, MaPM);
            while (rs.next()) {
                Integer soLuong = rs.getInt("SoLuong");
                Object[] row = {
                    rs.getInt("MaPMCT"), rs.getString("MaSach"),
                    rs.getString("TenSach"), soLuong, false
                };
                if (rdoTatCa.isSelected()) {
                    model.addRow(row);
                } else if (rdoDaNhap.isSelected() && soLuong >= 0) {
                    model.addRow(row);
                } else if (rdoChuaNhap.isSelected() && soLuong < 0) {
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            DialogHelper.alert(this, "Lỗi truy vấn học viên!");
        }
    }

    void insert() {
        Sach sa = (Sach) cboSach.getSelectedItem();
        PhieuMuonChiTiet model = new PhieuMuonChiTiet();
        model.setMaPM(MaPM);
        model.setMaSach(sa.getMaSach());
        model.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        try {
            dao.insert(model);
            this.fillComboBox();
            this.fillGridView();
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi thêm phiếu mượn chi tiết vào phiếu mượn!");
            e.printStackTrace();
        }
    }

    void update() {
        for (int i = 0; i < tblGridView.getRowCount(); i++) {
            Integer mapmct = (Integer) tblGridView.getValueAt(i, 0);
            String masach = (String) tblGridView.getValueAt(i, 1);
            Integer soluong = (Integer) tblGridView.getValueAt(i, 3);
            Boolean isDelete = (Boolean) tblGridView.getValueAt(i, 4);
            if (isDelete) {
                dao.delete(mapmct);
            } else {
                PhieuMuonChiTiet model = new PhieuMuonChiTiet();
                model.setMaPMCT(mapmct);
                model.setMaPM(MaPM);
                model.setMaSach(masach);
                model.setSoLuong(soluong);
                dao.update(model);
            }
        }
        this.fillComboBox();
        this.fillGridView();
        DialogHelper.alert(this, "Cập nhật thành công!");
    }

    public int isvalid() {
        
        return -1;

    }
//
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlHVKH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        btnCapNhat = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaNhap = new javax.swing.JRadioButton();
        rdoChuaNhap = new javax.swing.JRadioButton();
        pnlHVKhac = new javax.swing.JPanel();
        cboSach = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlHVKH.setBorder(javax.swing.BorderFactory.createTitledBorder("CHI TIẾT SÁCH"));

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ PMCT", "MÃ SÁCH", "TÊN SÁCH", "SỐ LƯỢNG", "XÓA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGridView);

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaNhap);
        rdoDaNhap.setText("Đã nhập điểm");
        rdoDaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChuaNhap);
        rdoChuaNhap.setText("Chưa nhập điểm");
        rdoChuaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHVKHLayout = new javax.swing.GroupLayout(pnlHVKH);
        pnlHVKH.setLayout(pnlHVKHLayout);
        pnlHVKHLayout.setHorizontalGroup(
            pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoDaNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoChuaNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlHVKHLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        pnlHVKHLayout.setVerticalGroup(
            pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHVKHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addGroup(pnlHVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoTatCa)
                        .addComponent(rdoDaNhap)
                        .addComponent(rdoChuaNhap)))
                .addGap(134, 134, 134))
        );

        pnlHVKhac.setBorder(javax.swing.BorderFactory.createTitledBorder("SÁCH"));

        cboSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSach.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboSachPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cboSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboSachMouseReleased(evt);
            }
        });
        cboSach.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                cboSachComponentHidden(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHVKhacLayout = new javax.swing.GroupLayout(pnlHVKhac);
        pnlHVKhac.setLayout(pnlHVKhacLayout);
        pnlHVKhacLayout.setHorizontalGroup(
            pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoLuong)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addContainerGap())
        );
        pnlHVKhacLayout.setVerticalGroup(
            pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHVKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHVKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHVKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHVKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHVKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlHVKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
                this.insert();

    }//GEN-LAST:event_btnThemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.fillComboBox();
        this.fillGridView();
    }//GEN-LAST:event_formWindowOpened

    private void cboSachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSachMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cboSachMouseReleased

    private void cboSachComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cboSachComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSachComponentHidden

    private void cboSachPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboSachPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
   selectComboBox();
    }//GEN-LAST:event_cboSachPopupMenuWillBecomeInvisible

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_tblGridViewMouseClicked

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaNhapActionPerformed
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_rdoDaNhapActionPerformed

    private void rdoChuaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaNhapActionPerformed
        // TODO add your handling code here:
        this.fillGridView();
    }//GEN-LAST:event_rdoChuaNhapActionPerformed

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
            java.util.logging.Logger.getLogger(PhieuMuonChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuMuonChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuMuonChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuMuonChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuMuonChiTietJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlHVKH;
    private javax.swing.JPanel pnlHVKhac;
    private javax.swing.JRadioButton rdoChuaNhap;
    private javax.swing.JRadioButton rdoDaNhap;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
