public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){}
    Circle(double radius){
        this.radius = radius;
    }
    double getRadius(){
        return this.radius;
    }
    String getColor(){
        return this.color;
    }
}
