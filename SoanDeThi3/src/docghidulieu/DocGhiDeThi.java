/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghidulieu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CauHoi;
import model.DapAn;
import model.DeThi;
import model.MonHoc;
import model.TracNghiem;
import model.TuLuan;

/**
 *
 * @author Jeremie
 */
public class DocGhiDeThi {

    public boolean luuDeThi(ArrayList<CauHoi> dsCauHoi, String path, String tenMonHoc, String ky, String namHoc,
            String thoiGian) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(tenMonHoc + ";" + ky + ";" + namHoc + ";" + thoiGian);
            bw.newLine();
            for (CauHoi ch : dsCauHoi) {
                if (ch instanceof TracNghiem) {
                    TracNghiem tn = (TracNghiem) ch;
                    String line = "";
                    String lineDapAn = "";
                    for (DapAn dapAn : tn.getDsDapAn()) {
                        if (dapAn.isIsTrue()) {
                            lineDapAn += dapAn.getNoiDung() + "+|";
                        } else {
                            lineDapAn += dapAn.getNoiDung() + "|";
                        }
                    }
                    lineDapAn = lineDapAn.substring(0, lineDapAn.length() - 1);
                    line = tn.getNoiDungCauHoi() + ";" + tn.getChuong() + ";" + tn.getDoKho() +";"+tn.getDiem()+ ";" + lineDapAn;
                    bw.write(line);
                    bw.newLine();
                } else {
                    TuLuan tl = (TuLuan) ch;
                    String line = tl.getNoiDungCauHoi() + ";" + tl.getChuong() + ";" + tl.getDoKho() + ";" +tl.getDiem()+";"+ tl.getGoiYDapAn() + "@";
                    bw.write(line);
                    bw.newLine();
                }

            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public DeThi docDeThi(String path){
        File file = new File(path);
        DeThi deThi = new DeThi();
        deThi.setTenDeThi(file.getName());
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            String[] arr = line.split(";");
            deThi.setMonHoc(arr[0]);
            deThi.setKy(arr[1]);
            deThi.setNamHoc(arr[2]);
            deThi.setThoiGian(Integer.parseInt(arr[3]));
            line = br.readLine();
            TuLuan tl;
            TracNghiem tn;
            CauHoi ch;
            ArrayList<CauHoi> listCauHoi = new ArrayList<>();
            while(line != null){
                arr = line.split(";");                
                if(arr[4].indexOf("@")!=-1){
                    String temp = arr[4].substring(0, arr[4].length()-1);
                    tl = new TuLuan(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Double.parseDouble(arr[3]), temp);
                    ch = tl;
                }else{
                    String[] arrDapAn = arr[4].split("\\|");
                    ArrayList<DapAn> arr1 = new ArrayList<>();
                    for (String temp : arrDapAn) {
                        DapAn da = new DapAn();
                        if (temp.endsWith("+")) {
                            da.setIsTrue(true);

                            temp = temp.substring(0, temp.length() - 1);
                        } else {
                            da.setIsTrue(false);
                        }
                        da.setNoiDung(temp);
                        arr1.add(da);
                    }
                    tn = new TracNghiem(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Double.parseDouble(arr[3]), arr1);
                    ch = tn;
                }
                listCauHoi.add(ch);
                line = br.readLine();
            }
            System.out.println(listCauHoi.size());
            deThi.setDsCauHoi(listCauHoi);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocGhiDeThi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DocGhiDeThi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocGhiDeThi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DocGhiDeThi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return deThi;
    }
}
