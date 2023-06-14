import java.io.*;

public class Main {
//    public static void main(String[] args) {
//        try {
//            FileInputStream fileInputStream = new FileInputStream("example.txt");
//            int ch;
//            while ((ch = fileInputStream.read()) != -1) {
//                System.out.print((char) ch); //ép kiểu thành char vì fIS trả về byte
//            }
//            fileInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }





//        public static void main(String[] args) {
//            try {
//                FileOutputStream fileOutputStream = new FileOutputStream("example.txt");
//                String text = "This is an example text.";
//                byte[] bytes = text.getBytes();
//                fileOutputStream.write(bytes);
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }




        public static void main(String[] args) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
                writer.write("Hello world!");
                writer.newLine(); // Thêm một dòng mới vào tệp
                writer.write("This is an example of using BufferedWriter in Java.");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




