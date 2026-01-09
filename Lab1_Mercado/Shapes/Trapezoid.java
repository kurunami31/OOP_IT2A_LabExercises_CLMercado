package Shapes;

public class Trapezoid extends Shape {
    private double base1, base2, height, side1, side2;

    public Trapezoid(double base1, double base2, double height, double side1, double side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double area() {
        return 0.5 * (base1 + base2) * height;
    }

    @Override
    public double perimeter() {
        return base1 + base2 + side1 + side2;
    }
}