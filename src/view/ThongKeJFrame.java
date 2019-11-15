/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author ASUS
 */
public class ThongKeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeJFrame
     */
    public ThongKeJFrame() {
        initComponents();
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
        tabs = new javax.swing.JTabbedPane();
        pnlNguoiHoc = new javax.swing.JPanel();
        pnlList = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        pnlTimKiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        pnlBangDiem = new javax.swing.JPanel();
        pnlList1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGridView1 = new javax.swing.JTable();
        pnlTimKiem1 = new javax.swing.JPanel();
        txtTimKiem1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        pnlTongHop = new javax.swing.JPanel();
        pnlKhoaHoc1 = new javax.swing.JPanel();
        lblKhoaHoc1 = new javax.swing.JLabel();
        cboPhieuMuon = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGridView2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        pnlNguoiHoc.setLayout(new java.awt.BorderLayout());

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ PHIẾU MƯỢN", "NGÀY MƯỢN", "NGÀY TRẢ", "MÃ SINH VIÊN", "MÃ NHÂN VIÊN", "MÃ SÁCH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblGridView);

        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("TÌM KIẾM"));

        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pnlNguoiHoc.add(pnlList, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("PHIẾU MƯỢN ĐÃ TRẢ", pnlNguoiHoc);

        pnlBangDiem.setLayout(new java.awt.BorderLayout());

        tblGridView1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ PHIẾU MƯỢN", "NGÀY MƯỢN", "NGÀY TRẢ", "MÃ SINH VIÊN", "MÃ NHÂN VIÊN", "MÃ SÁCH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGridView1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridView1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGridView1);

        pnlTimKiem1.setBorder(javax.swing.BorderFactory.createTitledBorder("TÌM KIẾM"));

        btnTimKiem1.setText("Tìm");
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiem1Layout = new javax.swing.GroupLayout(pnlTimKiem1);
        pnlTimKiem1.setLayout(pnlTimKiem1Layout);
        pnlTimKiem1Layout.setHorizontalGroup(
            pnlTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiem1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem1)
                .addContainerGap())
        );
        pnlTimKiem1Layout.setVerticalGroup(
            pnlTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiem1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlList1Layout = new javax.swing.GroupLayout(pnlList1);
        pnlList1.setLayout(pnlList1Layout);
        pnlList1Layout.setHorizontalGroup(
            pnlList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlList1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlList1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlList1Layout.setVerticalGroup(
            pnlList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlList1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlBangDiem.add(pnlList1, java.awt.BorderLayout.CENTER);

        tabs.addTab("PHIẾU MƯỢN CHƯA TRẢ", pnlBangDiem);

        pnlTongHop.setLayout(new java.awt.BorderLayout());

        lblKhoaHoc1.setText("THÁNG");

        cboPhieuMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPhieuMuon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboPhieuMuonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout pnlKhoaHoc1Layout = new javax.swing.GroupLayout(pnlKhoaHoc1);
        pnlKhoaHoc1.setLayout(pnlKhoaHoc1Layout);
        pnlKhoaHoc1Layout.setHorizontalGroup(
            pnlKhoaHoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhoaHoc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhoaHoc1)
                .addGap(18, 18, 18)
                .addComponent(cboPhieuMuon, 0, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlKhoaHoc1Layout.setVerticalGroup(
            pnlKhoaHoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhoaHoc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKhoaHoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKhoaHoc1)
                    .addComponent(cboPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlTongHop.add(pnlKhoaHoc1, java.awt.BorderLayout.PAGE_START);

        tblGridView2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ PHIẾU MƯỢN", "NGÀY MƯỢN", "NGÀY TRẢ", "MÃ SINH VIÊN", "MÃ NHÂN VIÊN", "MÃ SÁCH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGridView2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridView2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGridView2);

        pnlTongHop.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        tabs.addTab("PHIẾU MƯỢN THEO THÁNG", pnlTongHop);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabs))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboPhieuMuonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboPhieuMuonPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPhieuMuonPopupMenuWillBecomeInvisible

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGridViewMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblGridView1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridView1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGridView1MouseClicked

    private void btnTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem1ActionPerformed

    }//GEN-LAST:event_btnTimKiem1ActionPerformed

    private void tblGridView2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridView2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGridView2MouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JComboBox<String> cboPhieuMuon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblKhoaHoc1;
    private javax.swing.JPanel pnlBangDiem;
    private javax.swing.JPanel pnlKhoaHoc1;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlList1;
    private javax.swing.JPanel pnlNguoiHoc;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JPanel pnlTimKiem1;
    private javax.swing.JPanel pnlTongHop;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTable tblGridView1;
    private javax.swing.JTable tblGridView2;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    // End of variables declaration//GEN-END:variables
}