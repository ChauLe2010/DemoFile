package com.codegym;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.*;


public class FileDemo {
    public static void main(String[] args) {
//        File dirDemo=new File("D:/DirTest");
//        if(!dirDemo.exists()){
//            if(dirDemo.mkdir())
//                System.out.println("Make directory!");
//            else
//                System.out.println("Error");
//        }
//        File fileDemo = new File("D:/DirTest/TestFile.txt");
//        if(!fileDemo.exists()){
//            try{
//            fileDemo.createNewFile();
//            System.out.println("File exists");
//            }catch(IOException ex){
//                System.out.println("Loi tao moi");
//            }
//        }
        //Ghi file
//        try {
//            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
//            File f = new File("D:/DirTest/TestFile.txt");
//            //Tham số thứ 2 là true để mở file ghi nối tiêp append
//            FileWriter fw = new FileWriter(f,true);
//                       //Bước 2: Ghi dữ liệu
//            fw.write("\nGhi dữ liệu bằng luồng character");
//            fw.write("\nGhi dữ liệu bằng luồng character");
//            //Bước 3: Đóng luồng
//            fw.close();
//        } catch (IOException ex) {
//            System.out.println("Loi ghi file: " + ex);
//        }
        //Sử dụng Buffer
        final String FILENAME = "D:/DirTest/TestFile.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String data = " Nội dung mới nè";

            File file = new File(FILENAME);

            // kiểm tra nếu file chưa có thì tạo file mới
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.write(data);
            System.out.println("Xong");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try{
            File file=new File(FILENAME);
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str;
            while((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }
            bufferedReader.close();
            fileReader.close();
        }catch(IOException ex){
            System.out.println("Loi doc file");
        }

    }


}
