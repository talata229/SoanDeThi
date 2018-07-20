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
public class TracNghiem extends CauHoi {

    private ArrayList<DapAn> dsDapAn;

    public TracNghiem() {
    }

    public TracNghiem(String noiDungCauHoi, int chuong, int doKho) {
        super(noiDungCauHoi, chuong, doKho);
    }

    public TracNghiem(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    public TracNghiem(String noiDungCauHoi, int chuong, int doKho,ArrayList<DapAn> dsDapAn) {
        super(noiDungCauHoi, chuong, doKho);
        this.dsDapAn = dsDapAn;
    }
    
    public TracNghiem(String noiDungCauHoi, int chuong, int doKho, double diem, ArrayList<DapAn> dsDapAn) {
        super(noiDungCauHoi, chuong, doKho, diem);
        this.dsDapAn = dsDapAn;
    }
    
    public ArrayList<DapAn> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    @Override
    public String inCauHoi() {
        String string = "";
        int dapAnABC = 64;
        String ketQua = "";
        string += super.getNoiDungCauHoi() + "\n";
        for (int i = 0; i < dsDapAn.size(); i++) {
            dapAnABC++;
            string += (char) dapAnABC;
            string += " : " + dsDapAn.get(i).getNoiDung() + "\n";
            if (dsDapAn.get(i).isIsTrue()) {
                ketQua += (char) dapAnABC;
            }
        }
        string += "Thông tin chi tiết: \n";
        string += "Đáp án đúng : " + ketQua + "\n";
        string += "Độ khó: " + getDoKho() + "\n";
        string += "Chương: " + getChuong() + "\n";
        return string;
    }

    @Override
    public String inDeThi() {
        String string = "";
        int dapAnABC = 64;
        string += super.getNoiDungCauHoi() + "\n";
        for (int i = 0; i < dsDapAn.size(); i++) {
            dapAnABC++;
            string += (char) dapAnABC;
            string += " : " + dsDapAn.get(i).getNoiDung() + "\n";
        }
        return string;
    }

    @Override
    public String toString() {
        return this.getNoiDungCauHoi()+"\t"+this.getDoKho(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
