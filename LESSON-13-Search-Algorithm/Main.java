import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value");
        int keySearch = sc.nextInt();
        int result = Demo.linearSearch( keySearch);
        if(result != Demo.NOT_FOUND){
            System.out.println("result = "+ result);
        } else {
            System.out.println("Not found");
        }

    }
}