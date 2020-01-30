package com.codegym;

import java.io.*;

public class BinaryFile {
    public static void main(String[] args) {
        try {
            InputStream inputStream=new FileInputStream("D:/Dir/Test.txt");
            //Doc tung byte nhi phan
//            int value=-1;
//            while((value=inputStream.read())!=-1){
//                System.out.println((char)value);
//            }
            //Doc nhieu bytes
            byte[] bytesValue=new byte[10];
            int value=-1;
            while((value=inputStream.read(bytesValue))!=-1){
                String str=new String(bytesValue,0,value);
                System.out.println(str);
            }
            OutputStream outputStream=new FileOutputStream("D:/Dir/Output.txt");
////            byte[] binaryArray= new byte[]{'c','o','d','e','g','y','m'};
////            for(int i=0;i<binaryArray.length;i++){
////                byte value=binaryArray[i];
////                outputStream.write(value);
////            }
            byte[] b1 = new byte[] { 'c','o','d','e','g','y','m' };
            byte[] b2 = new byte[] { '.', 'c', 'o', 'm' };
            byte[] b3 = new byte[] { 13, 10 }; // Xuống dòng mới
            byte[] b4 = new byte[] { 'I', '/', 'O' };
            outputStream.write(b1);
            outputStream.write(b2);
            outputStream.write(b3);
            outputStream.write(b4);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
