public class Triangle {
    private double a, b, c;
    public Triangle (double a, double b, double c) throws ILLegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0){
            throw new ILLegalTriangleException("Edge cannot be negative");
        }
        if (a + b <= c || a + c <= b || c + b <= a){
            throw new ILLegalTriangleException("Not a triangle");
        }
        else {
            System.out.println("Triangle with side a " + a + " side b " + b + " side c " + c);
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
