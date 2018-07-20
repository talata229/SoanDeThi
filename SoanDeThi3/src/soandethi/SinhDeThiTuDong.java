/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soandethi;

import docghidulieu.DocGhiCauHoi;
import docghidulieu.DocGhiDeThi;
import docghidulieu.DocGhiDuLieu;
import docghidulieu.PhuongThucChung;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.CauHoi;
import model.DapAn;
import model.DeThi;
import model.MonHoc;
import model.TracNghiem;
import model.TuLuan;
import static soandethi.SinhDeThiBangTay.PATH;

/**
 *
 * @author Quan
 */
public class SinhDeThiTuDong extends javax.swing.JFrame {

    /**
     * Creates new form SinhDeThiTuDong
     */
    ArrayList<MonHoc> dsMonHoc;
    MonHoc mh;
    DocGhiDuLieu docGhiDuLieu;
    DocGhiCauHoi docGhiCauHoi;

    DeThi dethi;

    Object data[][];

    static final String PATH = "src\\data\\dsmonhoc.txt";
    public String pathTuLuan;
    public String pathTracNghiem;
    public String pathDeThi;

    DefaultListModel<String> dlCauHoiMonHoc;

    ArrayList<TuLuan> dsCauHoiTuLuanMonHoc;
    
    ArrayList<int[]> dsTuLuanTheoDoKho;
    ArrayList<int[]> dsTracNghiemTheoDoKho;
    
    ArrayList<ArrayList> dsCauHoiTuLuanTheoChuong;
    ArrayList<ArrayList> dsCauHoiTracNghiemTheoChuong;
    
    
    ArrayList<TracNghiem> dsCauHoiTracNghiemMonHoc;
    ArrayList<TracNghiem> dsCauHoiTracNghiem_Phu;
    ArrayList<CauHoi> dsCauHoiTongHop;

    ArrayList<CauHoi> dsCauHoiDeThi;
    DefaultListModel<String> dlCauHoiDeThi;
    int n;

    ArrayList<DapAn> dsDapAn;

    int soCauTracNghiem;

    public SinhDeThiTuDong() {
        
        initComponents();
        setTitle("Sinh đề thi tự động");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dsMonHoc = new ArrayList<>();
        
        docGhiDuLieu = new DocGhiDuLieu();
        dsMonHoc = docGhiDuLieu.docFile(PATH);
        mh = new MonHoc();
        mh = dsMonHoc.get(ChonMonHoc.viTriMonHocDuocChon);
        //System.out.println("AHIHI"+mh.getSoChuong());
        int i = 1;
        pathTuLuan = "src\\data\\" + mh.getTenMonHoc() + "\\TuLuan.txt";
        pathTracNghiem = "src\\data\\" + mh.getTenMonHoc() + "\\TracNghiem.txt";
        pathDeThi = "src\\data\\" + mh.getTenMonHoc() + "\\DeThi" + i + ".txt";

        docGhiCauHoi = new DocGhiCauHoi();
        dsCauHoiTuLuanMonHoc = new ArrayList<>();
        
        dsTuLuanTheoDoKho = new ArrayList<>();
        dsTracNghiemTheoDoKho = new ArrayList<>();
        
        dsCauHoiTuLuanTheoChuong = new ArrayList<>();
        dsCauHoiTracNghiemTheoChuong = new ArrayList<>();
        
        dsCauHoiTracNghiemMonHoc = new ArrayList<>();
        dsCauHoiTracNghiem_Phu = new ArrayList<>();

        dsCauHoiTuLuanMonHoc = docGhiCauHoi.docCauHoiTuLuan(pathTuLuan);
        dsCauHoiTracNghiemMonHoc = docGhiCauHoi.docCauHoiTracNghiem(pathTracNghiem);

        dsCauHoiDeThi = new ArrayList<>();
        dlCauHoiDeThi = new DefaultListModel<>();
        
        rdTracNghiemTuLuan.setSelected(true);
        rdTracNghiemTuLuanRieng.setSelected(true);
        rdK1.setSelected(true);
        
        soCauTracNghiem = 0;
        
        hienThiSoChuong();        
        layDsTuLuanVaTracNghiem();
               
        soTl.setText("0");
        soTn.setText("0");
        
    }

    public void hienThiSoChuong() {
        data = new Object[mh.getSoChuong()][5];
        for (int i = 0; i < mh.getSoChuong(); i++) {
            data[i][0] = "Chương " + (i + 1);
            data[i][1] = 0;
            data[i][2] = 1;
            data[i][3] = 0;
            data[i][4] = 1;
            int[] mangInt = {0, 0, 0, 0, 0};
            int[] mangInt1 = {0, 0, 0, 0, 0};
            ArrayList<TuLuan> arl1= new ArrayList<>();
            ArrayList<TracNghiem> arl= new ArrayList<>();
            dsCauHoiTuLuanTheoChuong.add(arl1);
            dsCauHoiTracNghiemTheoChuong.add(arl);
            dsTuLuanTheoDoKho.add(mangInt);
            dsTracNghiemTheoDoKho.add(mangInt1);
            
        }
        Object column[] = {"Chương", "Số câu tự luận", "Độ khó tự luận", "Số câu trắc nghiệm", "Độ khó trắc nghiệm"};

        TableModel clgt = new DefaultTableModel(data, column);
        tbCauHoi.setModel(clgt);

    }
    
    private void layDsTuLuanVaTracNghiem(){
        for(int i = 0; i<dsCauHoiTuLuanMonHoc.size(); i++){
            TuLuan tl = dsCauHoiTuLuanMonHoc.get(i);
            dsCauHoiTuLuanTheoChuong.get(tl.getChuong()-1).add(tl);
            dsTuLuanTheoDoKho.get(tl.getChuong())[tl.getDoKho()-1]++;
        }
        
        for(int i = 0; i<dsCauHoiTracNghiemMonHoc.size(); i++){
            TracNghiem tn = dsCauHoiTracNghiemMonHoc.get(i);
            dsCauHoiTracNghiemTheoChuong.get(tn.getChuong()-1).add(tn);
            dsTracNghiemTheoDoKho.get(tn.getChuong())[tn.getDoKho()-1]++;
        }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdTracNghiem = new javax.swing.JRadioButton();
        rdTuLuan = new javax.swing.JRadioButton();
        rdTracNghiemTuLuan = new javax.swing.JRadioButton();
        rdTracNghiemTuLuanChung = new javax.swing.JRadioButton();
        rdTracNghiemTuLuanRieng = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnTaoDeThi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCauHoi = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbTl2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        lbTl1 = new javax.swing.JLabel();
        cbDoKhoTuLuan = new javax.swing.JComboBox<>();
        txtChuongSo = new javax.swing.JLabel();
        txtSoChuong = new javax.swing.JLabel();
        lbTn2 = new javax.swing.JLabel();
        lbTn1 = new javax.swing.JLabel();
        cbDoKhoTracNghiem = new javax.swing.JComboBox<>();
        cbSoCauTuLuan = new javax.swing.JComboBox<>();
        cbSoCauTracNghiem = new javax.swing.JComboBox<>();
        txtChuong = new javax.swing.JLabel();
        soTl = new javax.swing.JLabel();
        soTn = new javax.swing.JLabel();
        lbTl = new javax.swing.JLabel();
        lbtn = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDanhSachCacCauTrongDe = new javax.swing.JList<>();
        btnDiem1Cau = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();
        txtNamHoc = new javax.swing.JTextField();
        rdKh = new javax.swing.JRadioButton();
        rdK2 = new javax.swing.JRadioButton();
        rdK1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChiTietDeThi = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtXuatFile = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Dạng đề thi:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hình thức:");

        buttonGroup1.add(rdTracNghiem);
        rdTracNghiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdTracNghiem.setText("Trắc nghiệm");
        rdTracNghiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTracNghiemMouseClicked(evt);
            }
        });
        rdTracNghiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTracNghiemActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTuLuan);
        rdTuLuan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdTuLuan.setText("Tự luận");
        rdTuLuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTuLuanMouseClicked(evt);
            }
        });
        rdTuLuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTuLuanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTracNghiemTuLuan);
        rdTracNghiemTuLuan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdTracNghiemTuLuan.setText("Cả trắc nghiệm và tự luận");
        rdTracNghiemTuLuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTracNghiemTuLuanMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdTracNghiemTuLuanChung);
        rdTracNghiemTuLuanChung.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdTracNghiemTuLuanChung.setText("Trắc nghiệm và tự luận chung");
        rdTracNghiemTuLuanChung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTracNghiemTuLuanChungMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdTracNghiemTuLuanRieng);
        rdTracNghiemTuLuanRieng.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdTracNghiemTuLuanRieng.setText("Trắc nghiêm và tự luận riêng");
        rdTracNghiemTuLuanRieng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTracNghiemTuLuanRiengMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdTracNghiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdTuLuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdTracNghiemTuLuan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdTracNghiemTuLuanChung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdTracNghiemTuLuanRieng)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdTracNghiem)
                    .addComponent(rdTuLuan)
                    .addComponent(rdTracNghiemTuLuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdTracNghiemTuLuanChung)
                    .addComponent(rdTracNghiemTuLuanRieng)))
        );

        btnTaoDeThi.setBackground(new java.awt.Color(255, 204, 102));
        btnTaoDeThi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoDeThi.setText("Tạo đề thi");
        btnTaoDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDeThiActionPerformed(evt);
            }
        });

        tbCauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Chương", "Số câu tự luận", "Độ khó tự luận", "Số câu trắc nghiệm", "Độ khó trắc nghiệm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCauHoiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCauHoi);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Thiết lập số câu hỏi mỗi chương");

        lbTl2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTl2.setText("Số Câu tự luận:");

        btnOk.setBackground(new java.awt.Color(102, 102, 255));
        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lbTl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTl1.setText("Độ khó tự luận");

        cbDoKhoTuLuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbDoKhoTuLuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDoKhoTuLuanItemStateChanged(evt);
            }
        });
        cbDoKhoTuLuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDoKhoTuLuanActionPerformed(evt);
            }
        });

        txtChuongSo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtChuongSo.setText("Chương");

        lbTn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTn2.setText("Số câu trắc nghiệm ");

        lbTn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTn1.setText("Độ khó trắc nghiệm ");

        cbDoKhoTracNghiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbDoKhoTracNghiem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDoKhoTracNghiemItemStateChanged(evt);
            }
        });

        cbSoCauTuLuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSoCauTuLuanMouseClicked(evt);
            }
        });

        soTl.setText("0");

        soTn.setText("0");

        lbTl.setText("Tự luận:");

        lbtn.setText("Trắc nghiệm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtChuongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(txtChuong))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbTl1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDoKhoTuLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbTl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbSoCauTuLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbTn1)
                                    .addComponent(lbTn2))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbDoKhoTracNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbSoCauTracNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOk)
                                .addGap(100, 100, 100)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoChuong)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnTaoDeThi)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(lbTl)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(soTl))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(lbtn)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(soTn))))
                                        .addGap(27, 27, 27)))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChuongSo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoChuong)
                    .addComponent(txtChuong)
                    .addComponent(soTn)
                    .addComponent(lbtn))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTl1)
                    .addComponent(cbDoKhoTuLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTn1)
                    .addComponent(cbDoKhoTracNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soTl)
                    .addComponent(lbTl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSoCauTuLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTl2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTn2)
                        .addComponent(btnOk)
                        .addComponent(cbSoCauTracNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTaoDeThi)))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Danh sách các câu trong đề");

        jScrollPane1.setViewportView(listDanhSachCacCauTrongDe);
        listDanhSachCacCauTrongDe.getAccessibleContext().setAccessibleDescription("");

        btnDiem1Cau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiem1Cau.setText("Điểm 1 câu");
        btnDiem1Cau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiem1CauActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Điểm TN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.red);
        jLabel10.setText("<HTML><U>Xóa câu hỏi ra khỏi đề thi</U></HTML>");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Thông tin về đề thi:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Thời gian:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Năm học:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Kỳ:");

        jLabel15.setText("Phút");

        txtThoiGian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThoiGianKeyReleased(evt);
            }
        });

        txtNamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamHocActionPerformed(evt);
            }
        });
        txtNamHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamHocKeyReleased(evt);
            }
        });

        buttonGroup3.add(rdKh);
        rdKh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdKh.setText("Kỳ hè");
        rdKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdKhMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdK2);
        rdK2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdK2.setText("2");
        rdK2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdK2MouseClicked(evt);
            }
        });

        buttonGroup3.add(rdK1);
        rdK1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdK1.setText("1");
        rdK1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdK1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Điểm TL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(txtNamHoc)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rdK1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rdK2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rdKh))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(btnDiem1Cau)
                                    .addComponent(jButton3)
                                    .addComponent(jButton1)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDiem1Cau, jButton1, jButton3});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnDiem1Cau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(rdKh)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdK2)
                        .addComponent(rdK1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtChiTietDeThi.setColumns(20);
        txtChiTietDeThi.setRows(5);
        jScrollPane2.setViewportView(txtChiTietDeThi);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("<HTML><U>Xáo trộn đề thi</U></HTML>");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        txtXuatFile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtXuatFile.setForeground(java.awt.Color.blue);
        txtXuatFile.setText("<HTML><U>Xuất ra file</U></HTML>");
        txtXuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtXuatFileMouseClicked(evt);
            }
        });

        jButton5.setBackground(java.awt.Color.red);
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Xóa đề thi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(java.awt.Color.green);
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Lưu đề thi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(204, 255, 204));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Xáo trộn đáp án");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHome))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHome, jButton4, jButton5});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(btnHome))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdTracNghiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTracNghiemMouseClicked
        rdTracNghiemTuLuanChung.setVisible(false);
        rdTracNghiemTuLuanRieng.setVisible(false);
        lbTl.setVisible(false);
        soTl.setVisible(false);
        lbtn.setVisible(true);
        soTn.setVisible(true);
    }//GEN-LAST:event_rdTracNghiemMouseClicked

    private void rdTuLuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTuLuanMouseClicked
        rdTracNghiemTuLuanChung.setVisible(false);
        rdTracNghiemTuLuanRieng.setVisible(false);
        lbtn.setVisible(false);
        soTn.setVisible(false);
        lbTl.setVisible(true);
        soTl.setVisible(true);
    }//GEN-LAST:event_rdTuLuanMouseClicked

    private void rdTracNghiemTuLuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTracNghiemTuLuanMouseClicked
        rdTracNghiemTuLuanChung.setVisible(true);
        rdTracNghiemTuLuanRieng.setVisible(true);
        lbTl.setVisible(true);
        soTl.setVisible(true);
        lbtn.setVisible(true);
        soTn.setVisible(true);
    }//GEN-LAST:event_rdTracNghiemTuLuanMouseClicked

    private void rdTracNghiemTuLuanChungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTracNghiemTuLuanChungMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTracNghiemTuLuanChungMouseClicked

    private void rdTracNghiemTuLuanRiengMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTracNghiemTuLuanRiengMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTracNghiemTuLuanRiengMouseClicked

    private void cbDoKhoTracNghiemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDoKhoTracNghiemItemStateChanged
        if(tbCauHoi.getSelectedRow()!=-1){
            setSoCauHoiTracNghiemChuong();
        }
    }//GEN-LAST:event_cbDoKhoTracNghiemItemStateChanged

    private void cbDoKhoTuLuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDoKhoTuLuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDoKhoTuLuanActionPerformed

    private void cbDoKhoTuLuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDoKhoTuLuanItemStateChanged
        if(tbCauHoi.getSelectedRow()!=-1){
            setSoCauHoiTuLuanChuong();
        }
    }//GEN-LAST:event_cbDoKhoTuLuanItemStateChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            int chuong = Integer.parseInt(txtChuong.getText()) - 1;
            data[chuong][1] = cbSoCauTuLuan.getSelectedItem();
            data[chuong][2] = cbDoKhoTuLuan.getSelectedItem();
            data[chuong][3] = cbSoCauTracNghiem.getSelectedItem();
            data[chuong][4] = cbDoKhoTracNghiem.getSelectedItem();
            tbCauHoi.setValueAt(data[chuong][1], chuong, 1);
            tbCauHoi.setValueAt(data[chuong][2], chuong, 2);
            tbCauHoi.setValueAt(data[chuong][3], chuong, 3);
            tbCauHoi.setValueAt(data[chuong][4], chuong, 4);
            
            int soCauTn = 0;
            int soCauTl = 0;
            for(int i = 0; i<mh.getSoChuong(); i++){
                soCauTn += Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 3)));
                soCauTl += Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 1)));
            }
            soTn.setText(String.valueOf(soCauTn));
            soTl.setText(String.valueOf(soCauTl));
        } catch (Exception e) {
            PhuongThucChung.showMessages("Hãy lựa chọn  một chương");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void tbCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCauHoiMouseClicked
        int chuong = tbCauHoi.getSelectedRow() + 1;
        txtChuong.setText(String.valueOf(chuong));
        cbDoKhoTuLuan.setSelectedIndex((Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(tbCauHoi.getSelectedRow(), 2)))) - 1);
        setSoCauHoiTuLuanChuong();
        cbSoCauTuLuan.setSelectedItem(tbCauHoi.getValueAt(tbCauHoi.getSelectedRow(), 1));
        cbDoKhoTracNghiem.setSelectedIndex((Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(tbCauHoi.getSelectedRow(), 4)))) - 1);
        setSoCauHoiTracNghiemChuong();
        cbSoCauTracNghiem.setSelectedItem(tbCauHoi.getValueAt(tbCauHoi.getSelectedRow(), 3));
           
    }//GEN-LAST:event_tbCauHoiMouseClicked

    private void btnTaoDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDeThiActionPerformed
         if (PhuongThucChung.kiemTraSoNguyen(txtThoiGian.getText().toString())
                    && !txtNamHoc.getText().toString().isEmpty()) {
            dsCauHoiDeThi.clear();
            dlCauHoiDeThi.removeAllElements();
            soCauTracNghiem = 0;
            if(rdTracNghiem.isSelected()){
                taoDeThiTracNghiem();
                soCauTracNghiem = dsCauHoiDeThi.size();
                daoCauHoi();
            }else if(rdTuLuan.isSelected()){
                taoDeThiTuLuan();
                daoCauHoi();
            }else {
                if(kiemTraSoLuongCau()){
                    if(rdTracNghiemTuLuanChung.isSelected()){
                        taoDeThiTracNghiem();
                        taoDeThiTuLuan();
                        daoCauHoi();
                    }else {
                        taoDeThiTracNghiem();
                        soCauTracNghiem = dsCauHoiDeThi.size();
                        taoDeThiTuLuan();
                        daoCauHoiRieng();
                    }
                }else{
                    PhuongThucChung.showMessages("Số câu hỏi không hợp lệ");
                    return;
                }
            }
            listDanhSachCacCauTrongDe.setModel(dlCauHoiDeThi);
            setDeThi();
            PhuongThucChung.showMessages("Đã tạo đề thi");
        }else{
            PhuongThucChung.showMessages("Hãy kiểm tra lại thông tin thời gian và năm học");
            txtThoiGian.requestFocus();
         }
    }//GEN-LAST:event_btnTaoDeThiActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        int i = listDanhSachCacCauTrongDe.getSelectedIndex();
        if (i == -1) {
            PhuongThucChung.showMessages("Vui lòng chọn câu hỏi để thao tác");
        } else {
            if (PhuongThucChung.yesNoOption("Bạn muốn xóa " + listDanhSachCacCauTrongDe.getSelectedValue().toString() + "?")) {
                if(dsCauHoiDeThi.get(i).isIsTracNghiem()){
                    soCauTracNghiem -=1;
                }
                dsCauHoiDeThi.remove(i);
                dlCauHoiDeThi.remove(i);
                for(int j = 0; j<dsCauHoiDeThi.size(); j++){
                    dlCauHoiDeThi.set(j, (j+1)+". "+dsCauHoiDeThi.get(j).getNoiDungCauHoi());
                }
                listDanhSachCacCauTrongDe.setModel(dlCauHoiDeThi);
                setDeThi();
            }
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void txtNamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamHocActionPerformed

    private void cbSoCauTuLuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSoCauTuLuanMouseClicked
        try{
            cbSoCauTuLuan.getSelectedIndex();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_cbSoCauTuLuanMouseClicked

    private void txtXuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtXuatFileMouseClicked
        String noiDung = txtChiTietDeThi.getText();
        if (!noiDung.isEmpty()) {
            File file = PhuongThucChung.saveFile();
            if (file != null) {
                String action = PhuongThucChung.dinhDangFile(file);
                if (action.equals("pdf")) {
                    PhuongThucChung.ghiPdf(noiDung, file);
                } else if (action.equals("txt")) {
                    PhuongThucChung.ghiTxt(noiDung, file);
                } else {
                    PhuongThucChung.showMessages("Định dạng file không hợp lệ");
                }
            } else {
                PhuongThucChung.showMessages("Hủy lưu file");
            }
        } else {
            PhuongThucChung.showMessages("Hãy tạo đề thi");
        }
    }//GEN-LAST:event_txtXuatFileMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int i = dsCauHoiDeThi.size();
        String tg = txtThoiGian.getText();
        String namHoc = txtNamHoc.getText();
        if (i == 0) {
            PhuongThucChung.showMessages("Bạn cần chọn câu hỏi đưa vào đề thi");
        } else if (txtThoiGian.getText().isEmpty() && !PhuongThucChung.kiemTraSoNguyen(tg)) {
            PhuongThucChung.showMessages("Thời gian không hợp lệ");
        } else if (txtNamHoc.getText().isEmpty()) {
            PhuongThucChung.showMessages("Hãy nhập năm học");
        } else {
            LuuDeThi ldt = new LuuDeThi();
            LuuDeThi.btnOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String tenDe = LuuDeThi.txtTen.getText();
                    if(tenDe.isEmpty()){
                        PhuongThucChung.showMessages("Tên đề không được để trống");
                        LuuDeThi.txtTen.requestFocus();
                        return;
                    }
                    pathDeThi = "src\\data\\" + mh.getTenMonHoc()+"\\"+tenDe;
                    System.out.println(pathDeThi);
                    DocGhiDeThi docGhiDeThi = new DocGhiDeThi();
                    String ky = rdK1.isSelected() ? "1" : (rdK2.isSelected() ? "2" : "Hè");
                    docGhiDeThi.luuDeThi(dsCauHoiDeThi, pathDeThi, mh.getTenMonHoc(), ky, txtNamHoc.getText(), txtThoiGian.getText());
                    ldt.dispose();
                    PhuongThucChung.showMessages("Đã Lưu đề thi "+LuuDeThi.txtTen.getText());

                }
            });
            LuuDeThi.btnHuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    ldt.dispose();
                    PhuongThucChung.showMessages("Bạn vừa hủy lưu đề thi");
                }
            });
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        XoaDeThi xdt = new XoaDeThi();
        xdt.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnDiem1CauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiem1CauActionPerformed
        int i = listDanhSachCacCauTrongDe.getSelectedIndex();
        if (i == -1) {
            PhuongThucChung.showMessages("Vui lòng chọn câu hỏi để thao tác");
        }else{
            DiemCauHoi dch= new DiemCauHoi();
            CauHoi ch = dsCauHoiDeThi.get(listDanhSachCacCauTrongDe.getSelectedIndex());
            DiemCauHoi.txtCauHoi.setText(ch.getNoiDungCauHoi());
            DiemCauHoi.txtDiem.setText(String.valueOf(ch.getDiem()));
            DiemCauHoi.btnOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String diem = DiemCauHoi.txtDiem.getText();
                    if((!diem.isEmpty())&&PhuongThucChung.kiemTraSoThuc(diem)){
                        double diem1 = Double.parseDouble(diem);
                        if(diem1<0||diem1>10){
                            PhuongThucChung.showMessages("Điểm không hợp lệ");
                            DiemCauHoi.txtDiem.requestFocus();
                        }else{
                            dsCauHoiDeThi.get(listDanhSachCacCauTrongDe.getSelectedIndex()).setDiem(Double.parseDouble(diem));
                            setDeThi();
                            dch.dispose();
                        }
                    }else{
                        PhuongThucChung.showMessages("Điểm không hợp lệ");
                    }
                }
            });
            
            DiemCauHoi.btnHuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    dch.dispose();
                }
            });
        }
    }//GEN-LAST:event_btnDiem1CauActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DiemCauHoi dch= new DiemCauHoi();
        
        DiemCauHoi.txtCauHoi.setText("Điểm các câu hỏi trắc nghiệm");
        DiemCauHoi.txtDiem.setText("0");
        DiemCauHoi.btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String diem = DiemCauHoi.txtDiem.getText();
                if((!diem.isEmpty())&&PhuongThucChung.kiemTraSoThuc(diem)){
                    double diem1 = Double.parseDouble(diem);
                    if(diem1<0||diem1>10){
                        PhuongThucChung.showMessages("Điểm không hợp lệ");
                        DiemCauHoi.txtDiem.requestFocus();
                    }else{
                        for(int i = 0; i<dsCauHoiDeThi.size(); i++){
                            if(dsCauHoiDeThi.get(i) instanceof TracNghiem){
                                dsCauHoiDeThi.get(i).setDiem(diem1);
                            }
                        }
                        setDeThi();
                        dch.dispose();
                    }
                }else{
                    PhuongThucChung.showMessages("Điểm không hợp lệ");
                    DiemCauHoi.txtDiem.requestFocus();
                }
            }
        });

        DiemCauHoi.btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dch.dispose();
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DiemCauHoi dch= new DiemCauHoi();
        
        DiemCauHoi.txtCauHoi.setText("Điểm các câu hỏi Tự Luận");
        DiemCauHoi.txtDiem.setText("0");
        DiemCauHoi.btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String diem = DiemCauHoi.txtDiem.getText();
                if((!diem.isEmpty())&&PhuongThucChung.kiemTraSoThuc(diem)){
                    double diem1 = Double.parseDouble(diem);
                    if(diem1<0||diem1>10){
                        PhuongThucChung.showMessages("Điểm không hợp lệ");
                        DiemCauHoi.txtDiem.requestFocus();
                    }else{
                        for(int i = 0; i<dsCauHoiDeThi.size(); i++){
                            if(dsCauHoiDeThi.get(i) instanceof TuLuan){
                                dsCauHoiDeThi.get(i).setDiem(diem1);
                            }
                        }
                        setDeThi();
                        dch.dispose();
                    }
                }else{
                    PhuongThucChung.showMessages("Điểm không hợp lệ");
                    DiemCauHoi.txtDiem.requestFocus();
                }
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
         PhuongThucChung.quayVeTrangChu();
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtThoiGianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThoiGianKeyReleased
         // TODO add your handling code here:
         setDeThi();
    }//GEN-LAST:event_txtThoiGianKeyReleased

    private void txtNamHocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamHocKeyReleased
        // TODO add your handling code here:
        setDeThi();
    }//GEN-LAST:event_txtNamHocKeyReleased

    private void rdK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdK1MouseClicked
        // TODO add your handling code here:
        setDeThi();
    }//GEN-LAST:event_rdK1MouseClicked

    private void rdK2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdK2MouseClicked
        // TODO add your handling code here:
        setDeThi();
    }//GEN-LAST:event_rdK2MouseClicked

    private void rdKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdKhMouseClicked
         // TODO add your handling code here:
         setDeThi();
    }//GEN-LAST:event_rdKhMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if(soCauTracNghiem==0){
            daoCauHoi();
        }else {
            daoCauHoiRieng();
        }
        setDeThi();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        daoDapAn();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdTracNghiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTracNghiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTracNghiemActionPerformed

    private void rdTuLuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTuLuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTuLuanActionPerformed

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
            java.util.logging.Logger.getLogger(SinhDeThiTuDong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhDeThiTuDong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhDeThiTuDong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhDeThiTuDong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinhDeThiTuDong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiem1Cau;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnTaoDeThi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbDoKhoTracNghiem;
    private javax.swing.JComboBox<String> cbDoKhoTuLuan;
    private javax.swing.JComboBox<String> cbSoCauTracNghiem;
    private javax.swing.JComboBox<String> cbSoCauTuLuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTl;
    private javax.swing.JLabel lbTl1;
    private javax.swing.JLabel lbTl2;
    private javax.swing.JLabel lbTn1;
    private javax.swing.JLabel lbTn2;
    private javax.swing.JLabel lbtn;
    private javax.swing.JList<String> listDanhSachCacCauTrongDe;
    private javax.swing.JRadioButton rdK1;
    private javax.swing.JRadioButton rdK2;
    private javax.swing.JRadioButton rdKh;
    private javax.swing.JRadioButton rdTracNghiem;
    private javax.swing.JRadioButton rdTracNghiemTuLuan;
    private javax.swing.JRadioButton rdTracNghiemTuLuanChung;
    private javax.swing.JRadioButton rdTracNghiemTuLuanRieng;
    private javax.swing.JRadioButton rdTuLuan;
    private javax.swing.JLabel soTl;
    private javax.swing.JLabel soTn;
    private javax.swing.JTable tbCauHoi;
    private javax.swing.JTextArea txtChiTietDeThi;
    private javax.swing.JLabel txtChuong;
    private javax.swing.JLabel txtChuongSo;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JLabel txtSoChuong;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JLabel txtXuatFile;
    // End of variables declaration//GEN-END:variables

    private void setSoCauHoiTuLuanChuong(){
        int temp = dsTuLuanTheoDoKho.get(Integer.parseInt(txtChuong.getText()))[cbDoKhoTuLuan.getSelectedIndex()];
        DefaultComboBoxModel cc = new DefaultComboBoxModel();
        for(int i = 0; i<=temp; i++){
            cc.addElement((i));
        }
        cbSoCauTuLuan.setModel(cc);
    }
    
    private void setSoCauHoiTracNghiemChuong(){
        int temp = dsTracNghiemTheoDoKho.get(Integer.parseInt(txtChuong.getText()))[cbDoKhoTracNghiem.getSelectedIndex()];
        DefaultComboBoxModel cc = new DefaultComboBoxModel();
        for(int i = 0; i<=temp; i++){
            cc.addElement((i));
        }
        cbSoCauTracNghiem.setModel(cc);
    }

    private void taoDeThiTracNghiem() {
        int soCauTrongChuong;
        int doKhoChuong;
        for(int i = 0; i<dsCauHoiTracNghiemTheoChuong.size(); i++){
            soCauTrongChuong = Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 3)));
            doKhoChuong = Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 4)));
            if(soCauTrongChuong == 0){
                continue;
            }
            ArrayList<TracNghiem> tempList= new ArrayList<>();
            for(int j = 0; j<dsCauHoiTracNghiemTheoChuong.get(i).size(); j++){
                TracNghiem tn = (TracNghiem) dsCauHoiTracNghiemTheoChuong.get(i).get(j);
                if(tn.getDoKho() == doKhoChuong){
                    tempList.add(tn);
                }
            }
            
            if(tempList.size() == soCauTrongChuong){
                for (TracNghiem cauTn : tempList) {
                    dsCauHoiDeThi.add(cauTn);
                }
            }else{
                ArrayList<Integer> v = new ArrayList<>();
                int random = 0;
                for(int k = 0; k<soCauTrongChuong;){
                    Random rd = new Random();
                    random = rd.nextInt(soCauTrongChuong+1);
                    if (!v.contains(random)) {
                        
                        v.add(random);
                        TracNghiem tn1 = tempList.get(random);
                        dsCauHoiDeThi.add(tn1);
                        k++;
                    }
                }
            }
        }
    }
    
     private void taoDeThiTuLuan() {
        int soCauTrongChuong;
        int doKhoChuong;
        for(int i = 0; i<dsCauHoiTuLuanTheoChuong.size(); i++){
            soCauTrongChuong = Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 1)));
            doKhoChuong = Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 2)));
            if(soCauTrongChuong == 0){
                continue;
            }
            ArrayList<TuLuan> tempList= new ArrayList<>();
            for(int j = 0; j<dsCauHoiTuLuanTheoChuong.get(i).size(); j++){
                TuLuan tl = (TuLuan) dsCauHoiTuLuanTheoChuong.get(i).get(j);
                if(tl.getDoKho() == doKhoChuong){
                    tempList.add(tl);
                }
            }
            if(tempList.size() == soCauTrongChuong){
                for (TuLuan tl1 : tempList) {
                    dsCauHoiDeThi.add(tl1);
                }
            }else{
                ArrayList<Integer> v = new ArrayList<>();
                int random = 0;
                for(int k = 0; k<soCauTrongChuong;){
                    Random rd = new Random();
                    random = rd.nextInt(soCauTrongChuong+1);
                    if (!v.contains(random)) {
                        
                        v.add(random);
                        TuLuan tl1 = tempList.get(random);
                        dsCauHoiDeThi.add(tl1);
                        k++;
                    }
                }
            }            
        }
    }
    
    private void setDeThi() {
        CauHoi ch;
        String deThi = "Bài thi môn: " + mh.getTenMonHoc() + "\n";
        deThi += "Kỳ: " + (rdK1.isSelected() ? "1" : (rdK2.isSelected() ? "2" : "Hè")) + " - Năm học:" + txtNamHoc.getText() + "\n";
        deThi += "Thời gian: " + txtThoiGian.getText() + " phút \n\n\n";
        String s = "";
        TuLuan tl;
        TracNghiem tn;
        for (int i = 0; i < dsCauHoiDeThi.size(); i++) {
            s = "";
            ch = dsCauHoiDeThi.get(i);
            if (ch instanceof TuLuan) {
                tl = (TuLuan) ch;
                s += "Câu " + (i + 1) + " (" + tl.getDiem() + " điểm): " + tl.getNoiDungCauHoi() + "\n";

            } else {
                tn = (TracNghiem) ch;
                s += "Câu " + (i + 1) + " (" + tn.getDiem() + " điểm): " + tn.getNoiDungCauHoi() + "\n";
                dsDapAn = new ArrayList<>();
                dsDapAn = tn.getDsDapAn();
                int j = 65;
                for (DapAn da : dsDapAn) {

                    s += (char) j + ".    " + da.getNoiDung() + "\n";
                    j++;
                }
            }
            deThi += s + "\n";
        }
        txtChiTietDeThi.setText(deThi);
    }
    
    private void daoCauHoi(){
        if(dsCauHoiDeThi.size()>1){
            int sz = dsCauHoiDeThi.size();
            CauHoi ch;
            int soViTriXaoTron = 0;
            Random rd = new Random();
            ArrayList<Integer> v = new ArrayList<>();
            int random = 0;
            do{
                for (int i = 0; i < sz;) {
                random = rd.nextInt(sz);
                    if (!v.contains(random)) {
                        ch = dsCauHoiDeThi.get(i);
                        dsCauHoiDeThi.set(i, dsCauHoiDeThi.get(random));
                        dsCauHoiDeThi.set(random, ch);
                        if(random!=i){
                            soViTriXaoTron++;
                        }
                        i++;
                    }
                    
                }
            }while(soViTriXaoTron==0);
            
            
        }
        dlCauHoiDeThi.removeAllElements();
        for(int i = 0; i<dsCauHoiDeThi.size(); i++){
                dlCauHoiDeThi.addElement((dlCauHoiDeThi.size()+1)+". "+dsCauHoiDeThi.get(i).getNoiDungCauHoi());
        }
    }
    
    private void daoCauHoiRieng(){
        CauHoi ch;
        int soViTriXaoTron = 0;
        Random rd = new Random();
        ArrayList<Integer> v = new ArrayList<>();
        int random = 0;
        if(soCauTracNghiem>1){
            do{
                for (int i = 0; i < soCauTracNghiem;) {
                random = rd.nextInt(soCauTracNghiem);
                    if (!v.contains(random)) {
                        ch = dsCauHoiDeThi.get(i);
                        dsCauHoiDeThi.set(i, dsCauHoiDeThi.get(random));
                        dsCauHoiDeThi.set(random, ch);
                        if(random!=i){
                            soViTriXaoTron++;
                        }
                        i++;
                    }
                }
            }while(soViTriXaoTron==0);
        }
        
        if(dsCauHoiDeThi.size()-soCauTracNghiem>1){
            soViTriXaoTron = 0;
            do{
                for(int i = soCauTracNghiem; i<dsCauHoiDeThi.size();){
                    random = rd.nextInt(dsCauHoiDeThi.size());
                    if ((!v.contains(random))&&(random>dsCauHoiDeThi.size()-soCauTracNghiem)) {
                        ch = dsCauHoiDeThi.get(i);
                        dsCauHoiDeThi.set(i, dsCauHoiDeThi.get(random));
                        dsCauHoiDeThi.set(random, ch);
                        if(random!=i){
                            soViTriXaoTron++;
                        }
                        i++;                       
                    }
                    
                }
            }while(soViTriXaoTron==0);
        }
        dlCauHoiDeThi.removeAllElements();
        for(int i = 0; i<dsCauHoiDeThi.size(); i++){
                dlCauHoiDeThi.addElement((dlCauHoiDeThi.size()+1)+". "+dsCauHoiDeThi.get(i).getNoiDungCauHoi());
        }
    }

    private boolean kiemTraSoLuongCau() {
        int tongSoCauTuLuan = 0;
        int tongSoCauTracNghiem = 0;        
        for(int i = 0; i<mh.getSoChuong(); i++){
            tongSoCauTuLuan += Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 1)));
            tongSoCauTracNghiem += Integer.parseInt(String.valueOf(tbCauHoi.getValueAt(i, 3)));            
        }
        if(tongSoCauTracNghiem>0&&tongSoCauTuLuan>0){
            return true;
        }
        return false;
    }

    private void daoDapAn() {
        ArrayList<DapAn> dsDapAnTracNghiem = new ArrayList<>();
        for(int i = 0; i < dsCauHoiDeThi.size(); i++){
            dsDapAnTracNghiem = new ArrayList<>();
            CauHoi ch = dsCauHoiDeThi.get(i);
            if(ch instanceof TracNghiem){
                dsDapAnTracNghiem =  ((TracNghiem) ch).getDsDapAn();
                if(dsDapAnTracNghiem.size()>1){
                    Random rd = new Random();
                    int daDao = 0;
                    int random = 0;                    
                    do{
                        for(int j = 0; j<dsDapAnTracNghiem.size(); j++){
                            random = rd.nextInt(dsDapAnTracNghiem.size());
                            DapAn daTemp = dsDapAnTracNghiem.get(j);
                            dsDapAnTracNghiem.set(j, dsDapAnTracNghiem.get(random));
                            dsDapAnTracNghiem.set(random, daTemp);
                            if(random != j){
                                daDao++;
                            }                                
                        }
                    }while(daDao==0); 
                }
                dsCauHoiDeThi.set(i, ch);
                
            }
        }
        setDeThi();
    }

}
