package com.codegym;

import java.io.*;
import java.util.ArrayList;

public class ObjectFileDemo {
    private static final String FILEPATH="object.txt";
    public void writeObjectFile(String path, ArrayList<Students> studentList){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            for (Students st:studentList) {
                objectOutputStream.writeObject(st);
            }
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void readObjectFile(String path){
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Students st=null;
            while((st=(Students)objectInputStream.readObject())!=null)
                st.display();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(InvalidClassException e){
            System.out.println("Loi class");
        }catch(EOFException e){
            System.out.println("Het file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ArrayList<Students> studentList=new ArrayList<>();
        studentList.add(new Students(1,"Khai","Ha Noi"));
        studentList.add(new Students(2,"Bang","Hai Phong"));
        studentList.add(new Students(3,"Hoang","Hai Duong"));
        ObjectFileDemo objectFileDemo=new ObjectFileDemo();
        //objectFileDemo.writeObjectFile(FILEPATH,studentList);
        objectFileDemo.readObjectFile(FILEPATH);

    }
}
