/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghidulieu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.MonHoc;
import model.TracNghiem;
import model.TuLuan;
import model.DapAn;

/**
 *
 * @author Quan
 */
public class DocGhiCauHoi {

    public boolean luuCauHoiTuLuan(ArrayList<TuLuan> dsCauHoiTuLuan, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (TuLuan tl : dsCauHoiTuLuan) {
                //String line = dsCauHoiTuLuan.getTenMonHoc() + ";" + mh.getMaMonHoc() + ";" + mh.getSoChuong() + ";" + mh.getGioiThieu();
                String line = tl.getNoiDungCauHoi() + ";" + tl.getChuong() + ";" + tl.getDoKho() + ";" + tl.getGoiYDapAn();
                bw.write(line);
                bw.newLine();
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

    public ArrayList<TuLuan> docCauHoiTuLuan(String path) {
        ArrayList<TuLuan> dsCauHoiTuLuan = new ArrayList<TuLuan>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                // if (arr.length == 4) {Lua
                TuLuan tl = new TuLuan(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3]);
                dsCauHoiTuLuan.add(tl);
                // }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsCauHoiTuLuan;
    }

    public boolean luuCauTracNghiem(ArrayList<TracNghiem> dsCauHoiTracNghiem, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            for (TracNghiem tn : dsCauHoiTracNghiem) {
                String line = "";
                String lineDapAn = "";
                for (DapAn dapAn : tn.getDsDapAn()) {
                    if (dapAn.isIsTrue()) {
                        lineDapAn += dapAn.getNoiDung() + "+|";
                    }else{
                        lineDapAn += dapAn.getNoiDung() + "|";
                    }
                }
                lineDapAn = lineDapAn.substring(0, lineDapAn.length() - 1);
                line = tn.getNoiDungCauHoi() + ";" + tn.getChuong() + ";" + tn.getDoKho() + ";" + lineDapAn;
                bw.write(line);
                bw.newLine();
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

    public ArrayList<TracNghiem> docCauHoiTracNghiem(String path) {
        ArrayList<TracNghiem> dsCauHoiTracNghiem = new ArrayList<TracNghiem>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 4) {
                    String[] arrDapAn = arr[3].split("\\|");
//                    for(String s:arrDapAn){
//                        System.out.println(s);
//                    }
                    ArrayList<DapAn> arr1 = new ArrayList<>();
//                    int i=0;
                    for (String temp : arrDapAn) {
                        DapAn da = new DapAn();
                        if (temp.endsWith("+")) {
                            da.setIsTrue(true);

                            temp = temp.substring(0, temp.length() - 1);
                        } else {
                            da.setIsTrue(false);
                        }
                        da.setNoiDung(temp);
//                            System.out.println(temp);
//                        }else{
//                            System.out.println("=============");
//                        }

//                        System.out.println("Noi dung:"+temp);
                        arr1.add(da);
//                        System.out.println("Noidung arr1:"+arr1.get(i).getNoiDung());
//                        i++;
                    }

                    TracNghiem tn = new TracNghiem(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr1);
                    dsCauHoiTracNghiem.add(tn);
                } else {
                    System.out.println("Có lỗi ở đây");
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println("đã ở đây");
//        for(TracNghiem tn:dsCauHoiTracNghiem) {
//            System.out.println("\n"+tn);
//        }
        return dsCauHoiTracNghiem;
    }

}
