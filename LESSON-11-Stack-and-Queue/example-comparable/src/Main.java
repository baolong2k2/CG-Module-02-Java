import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> listStudents = new ArrayList<Student>();
        // add students to list
        listStudents.add(new Student(1, "Ba", 19, "Hanoi"));
        listStudents.add(new Student(2, "Ma", 23, "Hanoi"));
        listStudents.add(new Student(3, "Ha", 20, "Hanoi"));
        listStudents.add(new Student(4, "La", 22, "Hanoi"));
        // sort list student
        Collections.sort(listStudents);
        // show list students
        for (Student student : listStudents) {
            System.out.println(student.toString());
        }
    }
}