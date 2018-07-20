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
public abstract class CauHoi {

    private String noiDungCauHoi;

    private int chuong;
    private int doKho;
    private double diem;
private boolean isTracNghiem;
    public CauHoi() {
    }

    public CauHoi(String noiDungCauHoi, int chuong, int doKho) {
        this.noiDungCauHoi = noiDungCauHoi;
        this.chuong = chuong;
        this.doKho = doKho;
    }
    
    public CauHoi(String noiDungCauHoi, int chuong, int doKho, double diem) {
        this.noiDungCauHoi = noiDungCauHoi;
        this.chuong = chuong;
        this.diem = diem;
        this.doKho = doKho;
    }

    public void themDapAn() {

    }

    public void suaDapAn() {

    }

    public void xoaDapAn() {

    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        if (noiDungCauHoi.equals("")) {
            System.out.println("Nội dung câu hỏi không được để rỗng");
        } else {
            this.noiDungCauHoi = noiDungCauHoi;
        }
    }

    public int getChuong() {
        return chuong;
    }

    public void setChuong(int chuong) {
        if (chuong < 0) {
            System.out.println("Nội dung của chương không được nhỏ hơn 0");
        } else {
            this.chuong = chuong;
        }
    }

    public int getDoKho() {
        return doKho;
    }
    
    public double getDiem() {
        return diem;
    }
    
    public void setDiem(double diem){
        this.diem = diem;
    }

    public void setDoKho(int doKho) {
        if (doKho < 0) {
            System.out.println("Độ khó không được nhỏ hơn 0");
        } else {
            this.doKho = doKho;
        }
    }

    public boolean isIsTracNghiem() {
        return isTracNghiem;
    }

    public void setIsTracNghiem(boolean isTracNghiem) {
        this.isTracNghiem = isTracNghiem;
    }

    public abstract String inCauHoi();

    public abstract String inDeThi();
}
