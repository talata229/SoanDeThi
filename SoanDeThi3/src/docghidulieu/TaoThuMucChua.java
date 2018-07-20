/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghidulieu;

import java.io.File;
import java.util.ArrayList;
import model.MonHoc;

/**
 *
 * @author admin
 */
public class TaoThuMucChua {

    public void taoThuMuc(ArrayList<MonHoc> dsmh) {
//     
//        for(MonHoc mh: dsmh){
//            String path = "src\\data\\"+mh.getTenMonHoc();
//            File fileleile(path);
//            file.mkdirs();
//        }
//    }

        for (MonHoc mh : dsmh) {
            String path = "src\\data\\" + mh.getTenMonHoc();
            String path_tuLuan = "src\\data\\" + mh.getTenMonHoc() + "\\TuLuan.txt";
            String path_tracNghiem = "src\\data\\" + mh.getTenMonHoc() + "\\TracNghiem.txt";
            File file = new File(path);
            File fileTuLuan = new File(path_tuLuan);
            File fileTracNghiem = new File(path_tracNghiem);
            file.mkdirs();
            try {

                fileTracNghiem.createNewFile();
                fileTuLuan.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
