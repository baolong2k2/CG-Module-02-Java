import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        TreeMap<String, Integer> map = new TreeMap<>();
        System.out.println("Nhập vào một chuỗi: ");
        Scanner scanner = new Scanner(System.in);
        String chuoi = scanner.nextLine().toLowerCase();

        String[] array = chuoi.split(" ");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println("Thông kê số lần xuất hiện của các chữ: ");
        System.out.println(map);
    }
    }
