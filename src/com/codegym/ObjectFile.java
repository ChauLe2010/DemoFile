package com.codegym;

import java.io.*;
import java.util.ArrayList;

class Student implements Serializable{
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void display(){
        System.out.println("ID: "+id+"Name: "+name);
    }
}
public class ObjectFile  {

    private static final String FILEPATH="D:/Dir/StudentFile.txt";

    public void writeFile(String path, ArrayList<Student> studentList){
        try {
            OutputStream outputStream=new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            for (Student student:studentList) {
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile(String path){
        try {
            InputStream fileInputStream=new FileInputStream(path);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Student student=null;
            while((student=(Student)objectInputStream.readObject())!=null){
                student.display();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Het file");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        ArrayList<Student> studentList=new ArrayList();
        studentList.add(new Student('1',"Chau"));
        studentList.add(new Student('2',"Due"));
        studentList.add(new Student('3',"Hung"));
        ObjectFile objectFile=new ObjectFile();
        objectFile.writeFile(FILEPATH,studentList);
        objectFile.readFile(FILEPATH);


    }
}
