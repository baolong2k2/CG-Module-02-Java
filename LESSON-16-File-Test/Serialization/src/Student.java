import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Student student = new Student("John", 20, "123 Main St");

        try {
            // Serialize object to a file
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student deserializedStudent = null;

        try {
            // Deserialize object from a file
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedStudent = (Student) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print deserialized object
        System.out.println("Deserialized Student...");
        System.out.println("Name: " + deserializedStudent.getName());
        System.out.println("Age: " + deserializedStudent.getAge());
        System.out.println("Address: " + deserializedStudent.getAddress());
    }
}
