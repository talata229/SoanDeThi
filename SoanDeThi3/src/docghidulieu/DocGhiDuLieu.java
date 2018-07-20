/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghidulieu;

import model.MonHoc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Quan
 */
public class DocGhiDuLieu {

    public boolean luuFile(ArrayList<MonHoc> dsmh, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (MonHoc mh : dsmh) {
                String line = mh.getMaMonHoc()+ ";" + mh.getTenMonHoc()+ ";" + mh.getSoChuong() + ";" + mh.getGioiThieu();
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

    public ArrayList<MonHoc> docFile(String path) {
        ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 4) {
                    MonHoc mh = new MonHoc(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3]);
                    dsmh.add(mh);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsmh;
    }
}
