
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer> thai = new ArrayList<>();
        thai.add(2);
        thai.add(5);
        thai.add(7);
        thai.add(19);
        thai.add(1);
        thai.add(-3);

        thai.sort(Comparator.comparingInt(Integer::intValue));

        System.out.println(thai);

    }



}
