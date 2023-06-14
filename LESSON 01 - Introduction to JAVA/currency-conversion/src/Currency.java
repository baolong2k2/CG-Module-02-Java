import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount in USD: ");
        usd = sc.nextDouble();
        double exchange =usd * 23000;
        System.out.print("Value VND: " + exchange);
    }
}
