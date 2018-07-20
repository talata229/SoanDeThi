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
public class DapAn {  
    private String noiDung;
    private boolean isTrue; //Đáp án đó có đúng không?

    public DapAn() {
    }

    public DapAn(String noiDung, boolean isTrue) {
        this.noiDung = noiDung;
        this.isTrue = isTrue;
    }
    
    

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        if(noiDung.equals("")) {
            System.out.println("Nội dung đáp án không được để trống");
        }
        else this.noiDung=noiDung;
              
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
    
}
