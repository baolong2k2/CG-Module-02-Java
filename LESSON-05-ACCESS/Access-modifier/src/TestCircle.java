public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(10);
        System.out.println(circle1.getRadius() + " " + circle1.getColor());
        System.out.println(circle2.getRadius() + " " + circle2.getColor());
    }
}
