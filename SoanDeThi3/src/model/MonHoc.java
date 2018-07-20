/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MonHoc {

    private String maMonHoc;
    private String tenMonHoc;
    private int soChuong;
    private String gioiThieu;
    private ArrayList<CauHoi> dsCauHoi;
    private ArrayList<DeThi> dsDeThi;

    public MonHoc() {
    }

    
    public MonHoc(String maMonHoc, String tenMonHoc, int soChuong, String gioiThieu) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soChuong = soChuong;
        this.gioiThieu = gioiThieu;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, int soChuong, String gioiThieu, ArrayList<CauHoi> dsCauHoi, ArrayList<DeThi> dsDeThi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soChuong = soChuong;
        this.gioiThieu = gioiThieu;
        this.dsCauHoi = dsCauHoi;
        this.dsDeThi = dsDeThi;
    }
    

    public void themCauHoi(CauHoi ch) {
        // dsCauHoi.add(ch);
    }

    public void xoaCauHoi(CauHoi ch) {
        //  dsCauHoi.remove(ch);
    }

    public void suaCauHoi(CauHoi ch) {

    }
    
    public void themDeThi(DeThi dt) {
        
    }
    
    public void xoaDeThi(DeThi dt) {
        
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        if(maMonHoc.equals("")) {
            System.out.println("Mã môn học không được để trống");
        }
        else this.maMonHoc=maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
         if(tenMonHoc.equals("")) {
            System.out.println("Tên môn học không được để trống");
        }
        else this.tenMonHoc=tenMonHoc;
    }

    public int getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(int soChuong) {
        if(soChuong<=0) {
            System.out.println("Số chương môn học phải > 0");
        }
        else this.soChuong=soChuong;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
       if(gioiThieu.equals("")) {
            System.out.println("Giới thiệu môn học không được để trống");
        }
        else this.gioiThieu=gioiThieu;
    }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public ArrayList<DeThi> getDsDeThi() {
        return dsDeThi;
    }

    public void setDsDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }   
}
