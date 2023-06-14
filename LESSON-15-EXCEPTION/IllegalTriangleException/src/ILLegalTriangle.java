import java.util.Scanner;

public class ILLegalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side a: ");
        double a = sc.nextDouble();
        System.out.println("Enter side b: ");
        double b = sc.nextDouble();
        System.out.println("Enter side c: ");
        double c = sc.nextDouble();

        try {
            Triangle triangle = new Triangle(a, b, c);
        }catch (ILLegalTriangleException e){
            e.printStackTrace();
        }
    }
}
