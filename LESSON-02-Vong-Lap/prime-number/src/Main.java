import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numbers;
        System.out.println("Enter a number: ");
        numbers = sc.nextInt();

        int count = 0;
        for (int N = 2; count < numbers; N++){
            boolean prime = true;
            for (int i = 2; i < (N - 1); i++){
                if (N % i == 0){
                    prime = false;
                    break;
                }
            }
            if (prime){
                System.out.println(N);
                count ++;
            }
        }
    }
}