/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soandethi;

import docghidulieu.PhuongThucChung;
import javax.swing.JFrame;

/**
 *
 * @author Quan
 */
public class TrangChu extends javax.swing.JFrame {

    /** Creates new form Frame1 */
    public static TrangChu clgt;
    
    public TrangChu() {
        initComponents();
        setTitle("Sinh đề thi tự động");
        clgt = this;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSoanCauHoi = new javax.swing.JButton();
        btnXayDungDeThi = new javax.swing.JButton();
        btnLamBaiThi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDanhGiaKetQua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setResizable(false);

        btnSoanCauHoi.setBackground(new java.awt.Color(204, 255, 255));
        btnSoanCauHoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSoanCauHoi.setText("Soạn câu hỏi");
        btnSoanCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoanCauHoiActionPerformed(evt);
            }
        });

        btnXayDungDeThi.setBackground(new java.awt.Color(204, 204, 255));
        btnXayDungDeThi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXayDungDeThi.setText("Xây dựng đề thi");
        btnXayDungDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXayDungDeThiActionPerformed(evt);
            }
        });

        btnLamBaiThi.setBackground(new java.awt.Color(255, 204, 204));
        btnLamBaiThi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLamBaiThi.setText("Làm bài thi");
        btnLamBaiThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamBaiThiActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 204, 204));
        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHÓM 1");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDanhGiaKetQua.setBackground(new java.awt.Color(255, 255, 204));
        btnDanhGiaKetQua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDanhGiaKetQua.setText("Đánh giá kết quả");
        btnDanhGiaKetQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhGiaKetQuaActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 255, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HỆ THỐNG TẠO ĐỀ THI CHO GIÁO VIÊN");
        jLabel3.setToolTipText("");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addComponent(btnXayDungDeThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamBaiThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDanhGiaKetQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSoanCauHoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnSoanCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXayDungDeThi, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLamBaiThi, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDanhGiaKetQua, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoanCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoanCauHoiActionPerformed
        // TODO add your handling code here:
        ChonMonHoc cmh = new ChonMonHoc();
        cmh.num(1);
        cmh.setVisible(true);
    }//GEN-LAST:event_btnSoanCauHoiActionPerformed

    private void btnXayDungDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXayDungDeThiActionPerformed
        // TODO add your handling code here:
        ChonMonHoc cmh = new ChonMonHoc();
        cmh.num(2);
        cmh.setVisible(true);
    }//GEN-LAST:event_btnXayDungDeThiActionPerformed

    private void btnLamBaiThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamBaiThiActionPerformed
        // TODO add your handling code here:
        PhuongThucChung.showMessages("Chức năng chưa được cập nhật!");
    }//GEN-LAST:event_btnLamBaiThiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cái này nó chỉ hiện lên nút để thoát
      //T
        //this.dispose();
       
        System.exit(0);  // thoát toàn bộ chương trình

    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDanhGiaKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhGiaKetQuaActionPerformed
        // TODO add your handling code here:
//        ChonMonHoc cmh = new ChonMonHoc();
//        cmh.num(4);
//        cmh.setVisible(true);
  PhuongThucChung.showMessages("Chức năng chưa được cập nhật!");
    }//GEN-LAST:event_btnDanhGiaKetQuaActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhGiaKetQua;
    private javax.swing.JButton btnLamBaiThi;
    private javax.swing.JButton btnSoanCauHoi;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXayDungDeThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
