/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soandethi;

import docghidulieu.DocGhiDeThi;
import docghidulieu.DocGhiDuLieu;
import docghidulieu.PhuongThucChung;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.CauHoi;
import model.DeThi;
import model.MonHoc;

/**
 *
 * @author Quan
 */
public class XayDungDeThi extends javax.swing.JFrame {

    static final String PATH = "src/data/dsmonhoc.txt";
    public static XayDungDeThi xayDungDeThi;
    MonHoc monHoc ;
    ArrayList<MonHoc> dsMonHoc;
    DocGhiDuLieu docGhiDuLieu;
    ArrayList<DeThi> dsDeThi;
    DefaultListModel<String> dlDeThi;
    String pathDeThi;
    /**
     * Creates new form QuanLyDeThi
     */
    public XayDungDeThi() {
        initComponents();
        monHoc = new MonHoc();
        xayDungDeThi = this;
        dsMonHoc = new ArrayList<>();
        docGhiDuLieu = new DocGhiDuLieu();
        dsMonHoc = docGhiDuLieu.docFile(PATH);        
        hienThiTenCuaMonHocDuocChon();
        dlDeThi = new DefaultListModel<>();
        pathDeThi = "src/data/"+monHoc.getTenMonHoc();
        layDanhSachDeThi();
        listDeThi.setModel(dlDeThi);
        setTitle("Xây dựng đề thi");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void hienThiTenCuaMonHocDuocChon() {
        System.out.println("Vị trí được chọn " + ChonMonHoc.viTriMonHocDuocChon);
        monHoc = dsMonHoc.get(ChonMonHoc.viTriMonHocDuocChon);
        System.out.println("So chuong mon hoc:"+monHoc.getSoChuong());
        txtTenMonHocDuocChon.setText(monHoc.getTenMonHoc());
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
        jLabel2 = new javax.swing.JLabel();
        btnTaoDeThiMoi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtTenMonHocDuocChon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDeThi = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quản lý đề thi:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mở đề thi có sẵn");

        btnTaoDeThiMoi.setBackground(new java.awt.Color(204, 204, 255));
        btnTaoDeThiMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoDeThiMoi.setForeground(java.awt.Color.red);
        btnTaoDeThiMoi.setText("Tạo đề thi mới");
        btnTaoDeThiMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDeThiMoiActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Ok");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtTenMonHocDuocChon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenMonHocDuocChon.setForeground(java.awt.Color.red);

        jScrollPane1.setViewportView(listDeThi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(btnTaoDeThiMoi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenMonHocDuocChon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMonHocDuocChon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnTaoDeThiMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoDeThiMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDeThiMoiActionPerformed
        // TODO add your handling code here:
        LuaChonCachTaoDeThi luaChonCachTaoDeThi = new LuaChonCachTaoDeThi();
        luaChonCachTaoDeThi.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnTaoDeThiMoiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int n = listDeThi.getSelectedIndex();
        if(n==-1){
            PhuongThucChung.showMessages("Vui lòng chọn một đề thi");
            return;
        }     
        DeThi dt = dsDeThi.get(n);
        SuaDeThi sdt = new SuaDeThi();
        sdt.setVisible(true);
        sdt.dsCauHoiDeThi = dt.getDsCauHoi();
        sdt.dlCauHoiDeThi = new DefaultListModel<>();
        for (CauHoi cauHoi : sdt.dsCauHoiDeThi) {
            sdt.dlCauHoiDeThi.addElement((sdt.dlCauHoiDeThi.size()+1)+". "+cauHoi.getNoiDungCauHoi());
        }
        sdt.listCauHoiDeThi.setModel(sdt.dlCauHoiDeThi);
        
        switch(dt.getKy()){
            case("1"):
                sdt.rdHocKy1.setSelected(true);
                break;
            case("2"):
                sdt.rdHocKy2.setSelected(true);
                break;
            default:
                sdt.rdHocKyHe.setSelected(true);
                break;
        }
        sdt.txtNamHoc.setText(dt.getNamHoc());
        sdt.txtPhut.setText(String.valueOf(dt.getThoiGian()));
        sdt.setDeThi();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(XayDungDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XayDungDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XayDungDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XayDungDeThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XayDungDeThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnTaoDeThiMoi;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listDeThi;
    private javax.swing.JLabel txtTenMonHocDuocChon;
    // End of variables declaration//GEN-END:variables

    private void layDanhSachDeThi() {
        dsDeThi = new ArrayList<>();
        File file = new File(pathDeThi);
        String path1;
        DeThi deThi;
        DocGhiDeThi dgdt = new DocGhiDeThi();
        String[] listFile = file.list();
        for(int i =0; i<listFile.length; i++){
            if(listFile[i].indexOf("DeThi") != -1){
            path1 = pathDeThi+"/"+listFile[i];
            deThi = dgdt.docDeThi(path1);
            dsDeThi.add(deThi);
            dlDeThi.addElement(deThi.getTenDeThi()+"     Kỳ: "+deThi.getKy()+"   Năm học: "+deThi.getNamHoc());
            }
        }
    }
}
