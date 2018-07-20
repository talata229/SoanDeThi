/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghidulieu;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import soandethi.TrangChu;

/**
 *
 * @author Jeremie
 */
public class PhuongThucChung {
    public static void showMessages(String noiDung){
        JOptionPane.showMessageDialog(null, noiDung);
    }
    public static void quayVeTrangChu() {
       TrangChu.clgt.setVisible(true);
                
    }
    
    public static File saveFile() {
        int choose;
        File file = null;
        JFileChooser chooser = new JFileChooser();
        choose = chooser.showSaveDialog(null);
        if(choose == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }
    
    public static void ghiPdf(String noiDung, File file){
        BaseFont bf = null ;
        
        try {
            bf = BaseFont.createFont("src/thuvien/font/times.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException ex) {
            
        } catch (IOException ex) {
            
        }

        Document dcm = new Document();
        try {
            PdfWriter.getInstance(dcm, new FileOutputStream(file));
            dcm.open();
            Font font = new Font(bf);
            dcm.add(new Paragraph(noiDung,font));
            dcm.close();
            showMessages("Đã tạo file PDF");
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        }   
        
    }
    
    public static void ghiTxt(String noiDung, File file){
           try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);     
            String[] arr = noiDung.split("\n");
            for(int i =0; i<arr.length; i++){
                bw.write(arr[i]+"\n");
                bw.newLine();
            }    
//            bw.write(noiDung);
            bw.close();
            osw.close();
            fos.close();
               showMessages("Đã tạo file Txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean yesNoOption(String action){
        int click;
        click = JOptionPane.showConfirmDialog(null, action);
        if(click == JOptionPane.YES_OPTION){   
            return true;
        }
        return false;
    }

    public static String dinhDangFile(File file) {
        String s = file.getName().substring(file.getName().indexOf(".")+1, file.getName().length());
        return s;
    }
    
    //Kiểm tra số từ form
    public static boolean kiemTraSoNguyen(String s){
        try{
            int i = Integer.parseInt(s);
            return true;
        }catch(Exception e){
            
        }
        return false;
    }
    public static boolean kiemTraSoThuc(String s){
            
        try{
            double i = Double.parseDouble(s);
            return true;
        }catch(Exception e){
            
        }
        return false;
    }
}
