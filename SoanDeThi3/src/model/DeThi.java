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
public class DeThi {
    private String tenDeThi;
    private String monHoc;
    private int thoiGian;
    private String namHoc;
    private String ky;
   // private String hinhThuc;   //Trắc nghiệm, tự luận, cả trắc nghiệm và tự luận
    private ArrayList<CauHoi>dsCauHoi;
    

    public DeThi(int thoiGian, String namHoc, String ky, ArrayList<CauHoi> dsCauHoi) {
        this.thoiGian = thoiGian;
        this.namHoc = namHoc;
        this.ky = ky;
        this.dsCauHoi = dsCauHoi;
        //this.isTracNghiem = isTracNghiem;
    }
    
    
    public DeThi() {
    }
//
//    public boolean isIsTracNghiem() {
//        return isTracNghiem;
//    }
//
//    public void setIsTracNghiem(boolean isTracNghiem) {
//        this.isTracNghiem = isTracNghiem;
//    }
    
    
    public void themCauHoi() {
        
    }
    
    public void suaCauhoi() {
        
    }
    
    public void xoaCauHoi() {
        
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        if(thoiGian<=0 || thoiGian>180) {
            System.out.println("Thời gian phải > 0 phút và < 180 phút");       
        }
        else this.thoiGian=thoiGian;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
       if(namHoc.equals("")) {
           System.out.println("Năm học không được để trống");
       }
       else this.namHoc=namHoc;
    }

    public String getKy() {
        return ky;
    }

    public void setKy(String ky) {
       if(ky.equals("")) {
           System.out.println("Kỳ không được để trống");
       }
       else this.ky=ky;
    }
    
    public void setMonHoc(String monHoc){
        this.monHoc = monHoc;
    }
    
    public String getMonHoc(){
        return monHoc;
    }
    
    public String getTenDeThi(){
        return tenDeThi;
    }
    
    public void setTenDeThi(String tenDeThi){
        this.tenDeThi = tenDeThi;
    }

//    public String getHinhThuc() {
//        return hinhThuc;
//    }
//
//    public void setHinhThuc(String hinhThuc) {
//        if(hinhThuc.equals("")) {
//           System.out.println("Hình thức không được để trống");
//       }
//       else this.hinhThuc=hinhThuc;
//    }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }   
}
