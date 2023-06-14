import java.util.Scanner;

public class Main {
     public static class Account {
        double a, b, c;
        double delta, x1, x2;

        public Account(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double getDiscriminant() {
            this.delta = Math.pow(this.b, 2) - 4 * this.c * this.a;
            return this.delta;
        }

        double getRoot1() {
            this.x1 = ((-this.b + Math.sqrt(this.delta)) / 2 * a);
            return this.x1;
        }

        double getRoot2() {
            this.x2 = ((-this.b - Math.sqrt(this.delta)) / 2 * a);
            return this.x2;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = input.nextDouble();
        System.out.println("Enter b: ");
        double b = input.nextDouble();
        System.out.println("Enter c: ");
        double c = input.nextDouble();
        Account myEquation = new Account(a, b, c);
        if (myEquation.getDiscriminant() > 0) {
            System.out.println("The equation has two roots: " + myEquation.getRoot1() + " and " + myEquation.getRoot2());
        } else if (myEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one root: " + myEquation.getRoot1());
        } else
            System.out.println("The equation has no real root.");

    }
}