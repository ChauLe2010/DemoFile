import java.io.*;

public class FileTest {
    public static void main(String[] args) {
//        File fileDemo=null;
//        FileWriter fileWriter=null;
//        try {
//            fileDemo=new File("D:/Dir/test.txt");
//            fileWriter=new FileWriter(fileDemo,true);
//            fileWriter.write("\nXin chao");
//            fileWriter.write("\nXin chao");
//            fileWriter.write("\nXin chao");
//            fileWriter.close();
//        } catch(FileNotFoundException e){
//            System.out.println("Duong dan ko dung");
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//
//        }
//
//
        File file=null;
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try{
            file=new File("D:/Dir/test.txt");
            fileReader=new FileReader(file);
            bufferedReader=new BufferedReader(fileReader);
            String str=null;
            while((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }
            bufferedReader.close();
            fileReader.close();
        }catch(FileNotFoundException e){
            System.out.println("Khong ton tai");

        }
        catch(IOException e){
            System.out.println("Loi doc file");

        }



    }
}
