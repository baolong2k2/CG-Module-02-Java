import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 30));
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 35));

        // Sắp xếp danh sách persons theo tuổi tăng dần
        Comparator<Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        };
        Collections.sort(persons, ageComparator);

        // In ra danh sách persons đã sắp xếp
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}