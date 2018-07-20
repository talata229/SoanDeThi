/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class TuLuan extends CauHoi {

    String goiYDapAn;

    public TuLuan(String goiYDapAn) {
        this.goiYDapAn = goiYDapAn;
    }

    public TuLuan(String noiDungCauHoi, int chuong, int doKho, String goiYDapAn) {
        super(noiDungCauHoi, chuong, doKho);
        this.goiYDapAn = goiYDapAn;
    }
    
    public TuLuan(String noiDungCauHoi, int chuong, int doKho, double diem, String goiYDapAn) {
        super(noiDungCauHoi, chuong, doKho, diem);
        this.goiYDapAn = goiYDapAn;
    }

    public TuLuan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getGoiYDapAn() {
        return goiYDapAn;
    }

    public void setGoiYDapAn(String goiYDapAn) {
        this.goiYDapAn = goiYDapAn;
    }

    @Override
    public String inCauHoi() {
        String content = "";
        content += this.getNoiDungCauHoi() + "\n";
        content += "==================================\n";
        content += "Thông tin chi tiết về câu hỏi\n";
        content += "Độ khó: " + this.getDoKho() + "\n";
        content += "Chương: " + this.getChuong() + "\n";
        content += "Gợi ý đáp án: " + this.getGoiYDapAn();
        return content;
    }

    @Override
    public String inDeThi() {
        String content = "";
        content += this.getNoiDungCauHoi() + "\n";
        return content;
    }

    @Override
    public String toString() {
        return this.getNoiDungCauHoi()+ ";" + this.getChuong() + ";" + this.getDoKho() + ";" + this.getGoiYDapAn();
    }
    
    
}
