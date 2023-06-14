import geometric.*;

public class ShapeFactory {
    public Shape getShape(String shape){
        switch (shape){
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                return new Rectangle();
        }
    }
}
