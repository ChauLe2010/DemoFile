package com.codegym;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileDemo {
    private static final String FILEPATH="binary.txt";
    public void writeFile(String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            byte[] value=new byte[]{'c','o','d','e'};
            fileOutputStream.write(value);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void readFile(String path){
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            byte[] temp=new byte[10];
            int value;
            while((value=fileInputStream.read(temp))!=-1){
                String str=new String(temp,0,value);
                System.out.println(str);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BinaryFileDemo test=new BinaryFileDemo();
       // test.writeFile(FILEPATH);
        test.readFile(FILEPATH);
    }
}
