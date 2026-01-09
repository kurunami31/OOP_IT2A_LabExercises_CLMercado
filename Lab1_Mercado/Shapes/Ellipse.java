package Shapes;

public class Ellipse extends Shape {
    private double a, b; // semi-major axis, semi-minor axis

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public double perimeter() {
        // Ramanujan’s approximation
        return Math.PI * (3*(a+b) - Math.sqrt((3*a+b)*(a+3*b)));
    }
}